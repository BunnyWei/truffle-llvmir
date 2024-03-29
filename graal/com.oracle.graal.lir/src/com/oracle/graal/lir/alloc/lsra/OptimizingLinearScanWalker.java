/*
 * Copyright (c) 2014, 2014, Oracle and/or its affiliates. All rights reserved.
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
package com.oracle.graal.lir.alloc.lsra;

import static com.oracle.graal.api.code.ValueUtil.*;

import com.oracle.graal.api.code.*;
import com.oracle.graal.api.meta.*;
import com.oracle.graal.compiler.common.cfg.*;
import com.oracle.graal.debug.*;
import com.oracle.graal.debug.Debug.Scope;
import com.oracle.graal.lir.alloc.lsra.Interval.*;
import com.oracle.graal.options.*;

public class OptimizingLinearScanWalker extends LinearScanWalker {

    public static class Options {
        // @formatter:off
        @Option(help = "Enable LSRA optimization", type = OptionType.Debug)
        public static final OptionValue<Boolean> LSRAOptimization = new OptionValue<>(true);
        @Option(help = "LSRA optimization: Only split but do not reassign", type = OptionType.Debug)
        public static final OptionValue<Boolean> LSRAOptSplitOnly = new OptionValue<>(false);
        // @formatter:on
    }

    OptimizingLinearScanWalker(LinearScan allocator, Interval unhandledFixedFirst, Interval unhandledAnyFirst) {
        super(allocator, unhandledFixedFirst, unhandledAnyFirst);
    }

    @Override
    protected void handleSpillSlot(Interval interval) {
        assert interval.location() != null : "interval  not assigned " + interval;
        if (interval.canMaterialize()) {
            assert !isStackSlotValue(interval.location()) : "interval can materialize but assigned to a stack slot " + interval;
            return;
        }
        assert isStackSlotValue(interval.location()) : "interval not assigned to a stack slot " + interval;
        try (Scope s1 = Debug.scope("LSRAOptimization")) {
            Debug.log("adding stack to unhandled list %s", interval);
            unhandledLists.addToListSortedByStartAndUsePositions(RegisterBinding.Stack, interval);
        }
    }

    @SuppressWarnings("unused")
    private static void printRegisterBindingList(RegisterBindingLists list, RegisterBinding binding) {
        for (Interval interval = list.get(binding); interval != Interval.EndMarker; interval = interval.next) {
            Debug.log("%s", interval);
        }
    }

    @Override
    void walk() {
        try (Scope s = Debug.scope("OptimizingLinearScanWalker")) {
            for (AbstractBlockBase<?> block : allocator.sortedBlocks) {
                optimizeBlock(block);
            }
        }
        super.walk();
    }

    private void optimizeBlock(AbstractBlockBase<?> block) {
        if (block.getPredecessorCount() == 1) {
            int nextBlock = allocator.getFirstLirInstructionId(block);
            try (Scope s1 = Debug.scope("LSRAOptimization")) {
                Debug.log("next block: %s (%d)", block, nextBlock);
            }
            try (Indent indent0 = Debug.indent()) {
                walkTo(nextBlock);

                try (Scope s1 = Debug.scope("LSRAOptimization")) {
                    boolean changed = true;
                    // we need to do this because the active lists might change
                    loop: while (changed) {
                        changed = false;
                        try (Indent indent1 = Debug.logAndIndent("Active intervals: (block %s [%d])", block, nextBlock)) {
                            for (Interval active = activeLists.get(RegisterBinding.Any); active != Interval.EndMarker; active = active.next) {
                                Debug.log("active   (any): %s", active);
                                if (optimize(nextBlock, block, active, RegisterBinding.Any)) {
                                    changed = true;
                                    break loop;
                                }
                            }
                            for (Interval active = activeLists.get(RegisterBinding.Stack); active != Interval.EndMarker; active = active.next) {
                                Debug.log("active (stack): %s", active);
                                if (optimize(nextBlock, block, active, RegisterBinding.Stack)) {
                                    changed = true;
                                    break loop;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean optimize(int currentPos, AbstractBlockBase<?> currentBlock, Interval currentInterval, RegisterBinding binding) {
        // BEGIN initialize and sanity checks
        assert currentBlock != null : "block must not be null";
        assert currentInterval != null : "interval must not be null";

        assert currentBlock.getPredecessorCount() == 1 : "more than one predecessors -> optimization not possible";

        if (!currentInterval.isSplitChild()) {
            // interval is not a split child -> no need for optimization
            return false;
        }

        if (currentInterval.from() == currentPos) {
            // the interval starts at the current position so no need for splitting
            return false;
        }

        // get current location
        AllocatableValue currentLocation = currentInterval.location();
        assert currentLocation != null : "active intervals must have a location assigned!";

        // get predecessor stuff
        AbstractBlockBase<?> predecessorBlock = currentBlock.getPredecessors().get(0);
        int predEndId = allocator.getLastLirInstructionId(predecessorBlock);
        Interval predecessorInterval = currentInterval.getIntervalCoveringOpId(predEndId);
        assert predecessorInterval != null : "variable not live at the end of the only predecessor! " + predecessorBlock + " -> " + currentBlock + " interval: " + currentInterval;
        AllocatableValue predecessorLocation = predecessorInterval.location();
        assert predecessorLocation != null : "handled intervals must have a location assigned!";

        // END initialize and sanity checks

        if (currentLocation.equals(predecessorLocation)) {
            // locations are already equal -> nothing to optimize
            return false;
        }

        if (!isStackSlotValue(predecessorLocation) && !isRegister(predecessorLocation)) {
            assert predecessorInterval.canMaterialize();
            // value is materialized -> no need for optimization
            return false;
        }

        assert isStackSlotValue(currentLocation) || isRegister(currentLocation) : "current location not a register or stack slot " + currentLocation;

        try (Indent indent = Debug.logAndIndent("location differs: %s vs. %s", predecessorLocation, currentLocation)) {
            // split current interval at current position
            Debug.log("splitting at position %d", currentPos);

            assert allocator.isBlockBegin(currentPos) && ((currentPos & 1) == 0) : "split pos must be even when on block boundary";

            Interval splitPart = currentInterval.split(currentPos, allocator);
            activeLists.remove(binding, currentInterval);

            assert splitPart.from() >= currentPosition : "cannot append new interval before current walk position";

            // the currentSplitChild is needed later when moves are inserted for reloading
            assert splitPart.currentSplitChild() == currentInterval : "overwriting wrong currentSplitChild";
            splitPart.makeCurrentSplitChild();

            if (Debug.isLogEnabled()) {
                Debug.log("left interval  : %s", currentInterval.logString(allocator));
                Debug.log("right interval : %s", splitPart.logString(allocator));
            }

            if (Options.LSRAOptSplitOnly.getValue()) {
                // just add the split interval to the unhandled list
                unhandledLists.addToListSortedByStartAndUsePositions(RegisterBinding.Any, splitPart);
            } else {
                if (isRegister(predecessorLocation)) {
                    splitRegisterInterval(splitPart, asRegister(predecessorLocation));
                } else {
                    assert isStackSlotValue(predecessorLocation);
                    Debug.log("assigning interval %s to %s", splitPart, predecessorLocation);
                    splitPart.assignLocation(predecessorLocation);
                    // activate interval
                    activeLists.addToListSortedByCurrentFromPositions(RegisterBinding.Stack, splitPart);
                    splitPart.state = State.Active;

                    splitStackInterval(splitPart);
                }
            }
        }
        return true;
    }

    private void splitRegisterInterval(Interval interval, Register reg) {
        // collect current usage of registers
        initVarsForAlloc(interval);
        initUseLists(false);
        spillExcludeActiveFixed();
        // spillBlockUnhandledFixed(cur);
        assert unhandledLists.get(RegisterBinding.Fixed) == Interval.EndMarker : "must not have unhandled fixed intervals because all fixed intervals have a use at position 0";
        spillBlockInactiveFixed(interval);
        spillCollectActiveAny();
        spillCollectInactiveAny(interval);

        if (Debug.isLogEnabled()) {
            try (Indent indent2 = Debug.logAndIndent("state of registers:")) {
                for (Register register : availableRegs) {
                    int i = register.number;
                    try (Indent indent3 = Debug.logAndIndent("reg %d: usePos: %d, blockPos: %d, intervals: ", i, usePos[i], blockPos[i])) {
                        for (int j = 0; j < spillIntervals[i].size(); j++) {
                            Debug.log("%d ", spillIntervals[i].get(j).operandNumber);
                        }
                    }
                }
            }
        }

        // the register must be free at least until this position
        boolean needSplit = blockPos[reg.number] <= interval.to();

        int splitPos = blockPos[reg.number];

        assert splitPos > 0 : "invalid splitPos";
        assert needSplit || splitPos > interval.from() : "splitting interval at from";

        Debug.log("assigning interval %s to %s", interval, reg);
        interval.assignLocation(reg.asValue(interval.kind()));
        if (needSplit) {
            // register not available for full interval : so split it
            splitWhenPartialRegisterAvailable(interval, splitPos);
        }

        // perform splitting and spilling for all affected intervals
        splitAndSpillIntersectingIntervals(reg);

        // activate interval
        activeLists.addToListSortedByCurrentFromPositions(RegisterBinding.Any, interval);
        interval.state = State.Active;

    }
}
