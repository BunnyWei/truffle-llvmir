/*
 * Copyright (c) 2013, 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package com.oracle.graal.lir;

import static com.oracle.graal.api.code.ValueUtil.*;

import java.util.*;

import com.oracle.graal.api.code.*;
import com.oracle.graal.api.meta.*;
import com.oracle.graal.compiler.common.*;
import com.oracle.graal.compiler.common.cfg.*;
import com.oracle.graal.debug.*;
import com.oracle.graal.lir.LIRInstruction.OperandFlag;
import com.oracle.graal.lir.LIRInstruction.OperandMode;
import com.oracle.graal.lir.StandardOp.MoveOp;
import com.oracle.graal.lir.framemap.*;
import com.oracle.graal.lir.gen.*;
import com.oracle.graal.lir.phases.*;

/**
 * Removes move instructions, where the destination value is already in place.
 */
public final class RedundantMoveElimination extends PostAllocationOptimizationPhase {

    @Override
    protected <B extends AbstractBlockBase<B>> void run(TargetDescription target, LIRGenerationResult lirGenRes, List<B> codeEmittingOrder, List<B> linearScanOrder) {
        Optimization redundantMoveElimination = new Optimization();
        redundantMoveElimination.doOptimize(lirGenRes.getLIR(), lirGenRes.getFrameMap());
    }

    /**
     * Holds the entry and exit states for each block for dataflow analysis. The state is an array
     * with an element for each relevant location (register or stack slot). Each element holds the
     * global number of the location's definition. A location definition is simply an output of an
     * instruction. Note that because instructions can have multiple outputs it is not possible to
     * use the instruction id for value numbering. In addition, the result of merging at block
     * entries (= phi values) get unique value numbers.
     *
     * The value numbers also contain information if it is an object kind value or not: if the
     * number is negative it is an object kind value.
     */
    private static final class BlockData {

        BlockData(int stateSize) {
            entryState = new int[stateSize];
            exitState = new int[stateSize];
        }

        /*
         * The state at block entry for global dataflow analysis. It contains a global value number
         * for each location to optimize.
         */
        int[] entryState;

        /*
         * The state at block exit for global dataflow analysis. It contains a global value number
         * for each location to optimize.
         */
        int[] exitState;

        /*
         * The starting number for global value numbering in this block.
         */
        int entryValueNum;
    }

    private static final class Optimization {

        Map<AbstractBlockBase<?>, BlockData> blockData = CollectionsFactory.newMap();

        Register[] callerSaveRegs;

        /**
         * Contains the register number for registers which can be optimized and -1 for the others.
         */
        int[] eligibleRegs;

        Map<StackSlot, Integer> stackIndices = CollectionsFactory.newMap();

        int numRegs;

        /*
         * Pseudo value for a not yet assigned location.
         */
        static final int INIT_VALUE = 0;

        /**
         * The main method doing the elimination of redundant moves.
         */
        private void doOptimize(LIR lir, FrameMap frameMap) {

            try (Indent indent = Debug.logAndIndent("eliminate redundant moves")) {

                callerSaveRegs = frameMap.getRegisterConfig().getCallerSaveRegisters();

                initBlockData(lir);

                // Compute a table of the registers which are eligible for move optimization.
                // Unallocatable registers should never be optimized.
                eligibleRegs = new int[numRegs];
                Arrays.fill(eligibleRegs, -1);
                for (Register reg : frameMap.getRegisterConfig().getAllocatableRegisters()) {
                    if (reg.number < numRegs) {
                        eligibleRegs[reg.number] = reg.number;
                    }
                }

                if (!solveDataFlow(lir)) {
                    return;
                }

                eliminateMoves(lir);
            }
        }

        /**
         * The maximum number of locations * blocks. This is a complexity limit for the inner loop
         * in {@link #mergeState} (assuming a small number of iterations in {@link #solveDataFlow}.
         */
        private static final int COMPLEXITY_LIMIT = 30000;

        private void initBlockData(LIR lir) {

            List<? extends AbstractBlockBase<?>> blocks = lir.linearScanOrder();
            numRegs = 0;

            int maxStackLocations = COMPLEXITY_LIMIT / blocks.size();

            /*
             * Search for relevant locations which can be optimized. These are register or stack
             * slots which occur as destinations of move instructions.
             */
            for (AbstractBlockBase<?> block : blocks) {
                List<LIRInstruction> instructions = lir.getLIRforBlock(block);
                for (LIRInstruction op : instructions) {
                    if (isEligibleMove(op)) {
                        Value dest = ((MoveOp) op).getResult();
                        if (isRegister(dest)) {
                            int regNum = ((RegisterValue) dest).getRegister().number;
                            if (regNum >= numRegs) {
                                numRegs = regNum + 1;
                            }
                        } else if (isStackSlot(dest)) {
                            StackSlot stackSlot = (StackSlot) dest;
                            if (!stackIndices.containsKey(stackSlot) && stackIndices.size() < maxStackLocations) {
                                stackIndices.put(stackSlot, stackIndices.size());
                            }
                        }
                    }
                }
            }

            /*
             * Now we know the number of locations to optimize, so we can allocate the block states.
             */
            int numLocations = numRegs + stackIndices.size();
            Debug.log("num locations = %d (regs = %d, stack = %d)", numLocations, numRegs, stackIndices.size());
            for (AbstractBlockBase<?> block : blocks) {
                BlockData data = new BlockData(numLocations);
                blockData.put(block, data);
            }
        }

        /**
         * Calculates the entry and exit states for all basic blocks.
         *
         * @return Returns true on success and false if the the control flow is too complex.
         */
        private boolean solveDataFlow(LIR lir) {

            try (Indent indent = Debug.logAndIndent("solve data flow")) {

                List<? extends AbstractBlockBase<?>> blocks = lir.linearScanOrder();

                int numIter = 0;

                /*
                 * Iterate until there are no more changes.
                 */
                int currentValueNum = 1;
                boolean firstRound = true;
                boolean changed;
                do {
                    changed = false;
                    try (Indent indent2 = Debug.logAndIndent("new iteration")) {

                        for (AbstractBlockBase<?> block : blocks) {

                            BlockData data = blockData.get(block);
                            /*
                             * Initialize the number for global value numbering for this block. It
                             * is essential that the starting number for a block is consistent at
                             * all iterations and also in eliminateMoves().
                             */
                            if (firstRound) {
                                data.entryValueNum = currentValueNum;
                            }
                            int valueNum = data.entryValueNum;
                            assert valueNum > 0;
                            boolean newState = false;

                            if (block == blocks.get(0) || block.isExceptionEntry()) {
                                /*
                                 * The entry block has undefined values. And also exception handler
                                 * blocks: the LinearScan can insert moves at the end of an
                                 * exception handler predecessor block (after the invoke, which
                                 * throws the exception), and in reality such moves are not in the
                                 * control flow in case of an exception. So we assume a save default
                                 * for exception handler blocks.
                                 */
                                Debug.log("kill all values at entry of block %d", block.getId());
                                clearValues(data.entryState, valueNum);
                            } else {
                                /*
                                 * Merge the states of predecessor blocks
                                 */
                                for (AbstractBlockBase<?> predecessor : block.getPredecessors()) {
                                    BlockData predData = blockData.get(predecessor);
                                    newState |= mergeState(data.entryState, predData.exitState, valueNum);
                                }
                            }
                            // Advance by the value numbers which are "consumed" by
                            // clearValues and mergeState
                            valueNum += data.entryState.length;

                            if (newState || firstRound) {
                                try (Indent indent3 = Debug.logAndIndent("update block %d", block.getId())) {

                                    /*
                                     * Derive the exit state from the entry state by iterating
                                     * through all instructions of the block.
                                     */
                                    int[] iterState = data.exitState;
                                    copyState(iterState, data.entryState);
                                    List<LIRInstruction> instructions = lir.getLIRforBlock(block);

                                    for (LIRInstruction op : instructions) {
                                        valueNum = updateState(iterState, op, valueNum);
                                    }
                                    changed = true;
                                }
                            }
                            if (firstRound) {
                                currentValueNum = valueNum;
                            }
                        }
                        firstRound = false;
                    }
                    numIter++;

                    if (numIter > 5) {
                        /*
                         * This is _very_ seldom.
                         */
                        return false;
                    }

                } while (changed);

            }

            return true;
        }

        /**
         * Deletes all move instructions where the target location already contains the source
         * value.
         */
        private void eliminateMoves(LIR lir) {

            try (Indent indent = Debug.logAndIndent("eliminate moves")) {

                List<? extends AbstractBlockBase<?>> blocks = lir.linearScanOrder();

                for (AbstractBlockBase<?> block : blocks) {

                    try (Indent indent2 = Debug.logAndIndent("eliminate moves in block %d", block.getId())) {

                        List<LIRInstruction> instructions = lir.getLIRforBlock(block);
                        BlockData data = blockData.get(block);
                        boolean hasDead = false;

                        // Reuse the entry state for iteration, we don't need it later.
                        int[] iterState = data.entryState;

                        // Add the values which are "consumed" by clearValues and
                        // mergeState in solveDataFlow
                        int valueNum = data.entryValueNum + data.entryState.length;

                        int numInsts = instructions.size();
                        for (int idx = 0; idx < numInsts; idx++) {
                            LIRInstruction op = instructions.get(idx);
                            if (isEligibleMove(op)) {
                                MoveOp moveOp = (MoveOp) op;
                                int sourceIdx = getStateIdx(moveOp.getInput());
                                int destIdx = getStateIdx(moveOp.getResult());
                                if (sourceIdx >= 0 && destIdx >= 0 && iterState[sourceIdx] == iterState[destIdx]) {
                                    assert iterState[sourceIdx] != INIT_VALUE;
                                    Debug.log("delete move %s", op);
                                    instructions.set(idx, null);
                                    hasDead = true;
                                }
                            }
                            // It doesn't harm if updateState is also called for a deleted move
                            valueNum = updateState(iterState, op, valueNum);
                        }
                        if (hasDead) {
                            instructions.removeAll(Collections.singleton(null));
                        }
                    }
                }
            }
        }

        /**
         * Updates the state for one instruction.
         */
        private int updateState(final int[] state, LIRInstruction op, int initValueNum) {

            try (final Indent indent = Debug.logAndIndent("update state for op %s, initial value num = %d", op, initValueNum)) {
                if (isEligibleMove(op)) {
                    /*
                     * Handle the special case of a move instruction
                     */
                    MoveOp moveOp = (MoveOp) op;
                    int sourceIdx = getStateIdx(moveOp.getInput());
                    int destIdx = getStateIdx(moveOp.getResult());
                    if (sourceIdx >= 0 && destIdx >= 0) {
                        assert isObjectValue(state[sourceIdx]) || moveOp.getInput().getLIRKind().isValue() : "move op moves object but input is not defined as object";
                        state[destIdx] = state[sourceIdx];
                        Debug.log("move value %d from %d to %d", state[sourceIdx], sourceIdx, destIdx);
                        return initValueNum;
                    }
                }

                int valueNum = initValueNum;

                if (op.destroysCallerSavedRegisters()) {
                    Debug.log("kill all caller save regs");

                    for (Register reg : callerSaveRegs) {
                        if (reg.number < numRegs) {
                            // Kind.Object is the save default
                            state[reg.number] = encodeValueNum(valueNum++, true);
                        }
                    }
                }

                /*
                 * Value procedure for the instruction's output and temp values
                 */
                class OutputValueConsumer implements ValueConsumer {

                    int opValueNum;

                    OutputValueConsumer(int opValueNum) {
                        this.opValueNum = opValueNum;
                    }

                    @Override
                    public void visitValue(Value operand, OperandMode mode, EnumSet<OperandFlag> flags) {
                        int stateIdx = getStateIdx(operand);
                        if (stateIdx >= 0) {
                            /*
                             * Assign a unique number to the output or temp location.
                             */
                            state[stateIdx] = encodeValueNum(opValueNum++, !operand.getLIRKind().isValue());
                            Debug.log("set def %d for register %s(%d): %d", opValueNum, operand, stateIdx, state[stateIdx]);
                        }
                    }
                }

                OutputValueConsumer outputValueConsumer = new OutputValueConsumer(valueNum);

                op.visitEachTemp(outputValueConsumer);
                /*
                 * Semantically the output values are written _after_ the temp values
                 */
                op.visitEachOutput(outputValueConsumer);

                valueNum = outputValueConsumer.opValueNum;

                if (op.hasState()) {
                    /*
                     * All instructions with framestates (mostly method calls), may do garbage
                     * collection. GC will rewrite all object references which are live at this
                     * point. So we can't rely on their values. It would be sufficient to just kill
                     * all values which are referenced in the state (or all values which are not),
                     * but for simplicity we kill all values.
                     */
                    Debug.log("kill all object values");
                    clearValuesOfKindObject(state, valueNum);
                    valueNum += state.length;
                }

                return valueNum;
            }
        }

        /**
         * The state merge function for dataflow joins.
         */
        private static boolean mergeState(int[] dest, int[] source, int defNum) {
            assert dest.length == source.length;
            boolean changed = false;
            for (int idx = 0; idx < source.length; idx++) {
                int phiNum = defNum + idx;
                int dst = dest[idx];
                int src = source[idx];
                if (dst != src && src != INIT_VALUE && dst != encodeValueNum(phiNum, isObjectValue(dst))) {
                    if (dst != INIT_VALUE) {
                        dst = encodeValueNum(phiNum, isObjectValue(dst) || isObjectValue(src));
                    } else {
                        dst = src;
                    }
                    dest[idx] = dst;
                    changed = true;
                }
            }
            return changed;
        }

        private static void copyState(int[] dest, int[] source) {
            assert dest.length == source.length;
            for (int idx = 0; idx < source.length; idx++) {
                dest[idx] = source[idx];
            }
        }

        private static void clearValues(int[] state, int defNum) {
            for (int idx = 0; idx < state.length; idx++) {
                int phiNum = defNum + idx;
                // Let the killed values assume to be object references: it's the save default.
                state[idx] = encodeValueNum(phiNum, true);
            }
        }

        private static void clearValuesOfKindObject(int[] state, int defNum) {
            for (int idx = 0; idx < state.length; idx++) {
                int phiNum = defNum + idx;
                if (isObjectValue(state[idx])) {
                    state[idx] = encodeValueNum(phiNum, true);
                }
            }
        }

        /**
         * Returns the index to the state arrays in BlockData for a specific location.
         */
        private int getStateIdx(Value location) {
            if (isRegister(location)) {
                int regNum = ((RegisterValue) location).getRegister().number;
                if (regNum < numRegs) {
                    return eligibleRegs[regNum];
                }
                return -1;
            }
            if (isStackSlot(location)) {
                StackSlot slot = (StackSlot) location;
                Integer index = stackIndices.get(slot);
                if (index != null) {
                    return index.intValue() + numRegs;
                }
            }
            return -1;
        }

        /**
         * Encodes a value number + the is-object information to a number to be stored in a state.
         */
        private static int encodeValueNum(int valueNum, boolean isObjectKind) {
            assert valueNum > 0;
            if (isObjectKind) {
                return -valueNum;
            }
            return valueNum;
        }

        /**
         * Returns true if an encoded value number (which is stored in a state) refers to an object
         * reference.
         */
        private static boolean isObjectValue(int encodedValueNum) {
            return encodedValueNum < 0;
        }

        /**
         * Returns true for a move instruction which is a candidate for elimination.
         */
        private static boolean isEligibleMove(LIRInstruction op) {
            if (op instanceof MoveOp) {
                MoveOp moveOp = (MoveOp) op;
                Value source = moveOp.getInput();
                Value dest = moveOp.getResult();
                /*
                 * Moves with mismatching kinds are not moves, but memory loads/stores!
                 */
                return source.getLIRKind().equals(dest.getLIRKind());
            }
            return false;
        }
    }
}
