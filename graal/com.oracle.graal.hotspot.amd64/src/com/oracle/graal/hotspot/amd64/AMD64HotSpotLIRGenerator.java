/*
 * Copyright (c) 2012, 2014, Oracle and/or its affiliates. All rights reserved.
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
package com.oracle.graal.hotspot.amd64;

import static com.oracle.graal.amd64.AMD64.*;
import static com.oracle.graal.api.code.ValueUtil.*;
import static com.oracle.graal.hotspot.HotSpotBackend.*;

import java.util.*;

import com.oracle.graal.amd64.*;
import com.oracle.graal.api.code.*;
import com.oracle.graal.api.meta.*;
import com.oracle.graal.compiler.amd64.*;
import com.oracle.graal.compiler.common.*;
import com.oracle.graal.compiler.common.calc.*;
import com.oracle.graal.compiler.common.spi.*;
import com.oracle.graal.hotspot.*;
import com.oracle.graal.hotspot.HotSpotVMConfig.CompressEncoding;
import com.oracle.graal.hotspot.amd64.AMD64HotSpotMove.HotSpotStoreConstantOp;
import com.oracle.graal.hotspot.meta.*;
import com.oracle.graal.hotspot.stubs.*;
import com.oracle.graal.lir.*;
import com.oracle.graal.lir.StandardOp.NoOp;
import com.oracle.graal.lir.StandardOp.SaveRegistersOp;
import com.oracle.graal.lir.amd64.*;
import com.oracle.graal.lir.amd64.AMD64ControlFlow.CondMoveOp;
import com.oracle.graal.lir.amd64.AMD64Move.CompareAndSwapOp;
import com.oracle.graal.lir.amd64.AMD64Move.LeaDataOp;
import com.oracle.graal.lir.amd64.AMD64Move.LoadOp;
import com.oracle.graal.lir.amd64.AMD64Move.MoveFromRegOp;
import com.oracle.graal.lir.amd64.AMD64Move.StoreOp;
import com.oracle.graal.lir.gen.*;

/**
 * LIR generator specialized for AMD64 HotSpot.
 */
public class AMD64HotSpotLIRGenerator extends AMD64LIRGenerator implements HotSpotLIRGenerator {

    final HotSpotVMConfig config;
    private HotSpotLockStack lockStack;

    protected AMD64HotSpotLIRGenerator(HotSpotProviders providers, HotSpotVMConfig config, CallingConvention cc, LIRGenerationResult lirGenRes) {
        this(new DefaultLIRKindTool(providers.getCodeCache().getTarget().wordKind), providers, config, cc, lirGenRes);
    }

    protected AMD64HotSpotLIRGenerator(LIRKindTool lirKindTool, HotSpotProviders providers, HotSpotVMConfig config, CallingConvention cc, LIRGenerationResult lirGenRes) {
        super(lirKindTool, providers, cc, lirGenRes);
        assert config.basicLockSize == 8;
        this.config = config;
    }

    @Override
    public HotSpotProviders getProviders() {
        return (HotSpotProviders) super.getProviders();
    }

    /**
     * Utility for emitting the instruction to save RBP.
     */
    class SaveRbp {

        final NoOp placeholder;

        /**
         * The slot reserved for saving RBP.
         */
        final StackSlot reservedSlot;

        public SaveRbp(NoOp placeholder) {
            this.placeholder = placeholder;
            AMD64FrameMapBuilder frameMapBuilder = (AMD64FrameMapBuilder) getResult().getFrameMapBuilder();
            this.reservedSlot = frameMapBuilder.allocateRBPSpillSlot();
        }

        /**
         * Replaces this operation with the appropriate move for saving rbp.
         *
         * @param useStack specifies if rbp must be saved to the stack
         */
        public AllocatableValue finalize(boolean useStack) {
            AllocatableValue dst;
            if (useStack) {
                dst = reservedSlot;
            } else {
                ((AMD64FrameMapBuilder) getResult().getFrameMapBuilder()).freeRBPSpillSlot();
                dst = newVariable(LIRKind.value(Kind.Long));
            }

            placeholder.replace(getResult().getLIR(), new MoveFromRegOp(Kind.Long, dst, rbp.asValue(LIRKind.value(Kind.Long))));
            return dst;
        }
    }

    SaveRbp saveRbp;

    /**
     * List of epilogue operations that need to restore RBP.
     */
    List<AMD64HotSpotEpilogueOp> epilogueOps = new ArrayList<>(2);

    @Override
    public void append(LIRInstruction op) {
        super.append(op);
        if (op instanceof AMD64HotSpotEpilogueOp) {
            epilogueOps.add((AMD64HotSpotEpilogueOp) op);
        }
    }

    @Override
    public StackSlotValue getLockSlot(int lockDepth) {
        return getLockStack().makeLockSlot(lockDepth);
    }

    private HotSpotLockStack getLockStack() {
        assert lockStack != null;
        return lockStack;
    }

    protected void setLockStack(HotSpotLockStack lockStack) {
        assert this.lockStack == null;
        this.lockStack = lockStack;
    }

    private Register findPollOnReturnScratchRegister() {
        RegisterConfig regConfig = getProviders().getCodeCache().getRegisterConfig();
        for (Register r : regConfig.getAllocatableRegisters(Kind.Long)) {
            if (!r.equals(regConfig.getReturnRegister(Kind.Long)) && !r.equals(AMD64.rbp)) {
                return r;
            }
        }
        throw GraalInternalError.shouldNotReachHere();
    }

    private Register pollOnReturnScratchRegister;

    @Override
    public void emitReturn(Value input) {
        AllocatableValue operand = Value.ILLEGAL;
        if (input != null) {
            operand = resultOperandFor(input.getLIRKind());
            emitMove(operand, input);
        }
        if (pollOnReturnScratchRegister == null) {
            pollOnReturnScratchRegister = findPollOnReturnScratchRegister();
        }
        append(new AMD64HotSpotReturnOp(operand, getStub() != null, pollOnReturnScratchRegister, config));
    }

    @Override
    public boolean needOnlyOopMaps() {
        // Stubs only need oop maps
        return ((AMD64HotSpotLIRGenerationResult) getResult()).getStub() != null;
    }

    @Override
    public void emitData(AllocatableValue dst, byte[] data) {
        append(new LeaDataOp(dst, data));
    }

    private LIRFrameState currentRuntimeCallInfo;

    @Override
    protected void emitForeignCallOp(ForeignCallLinkage linkage, Value result, Value[] arguments, Value[] temps, LIRFrameState info) {
        currentRuntimeCallInfo = info;
        super.emitForeignCallOp(linkage, result, arguments, temps, info);
    }

    public void emitLeaveCurrentStackFrame(SaveRegistersOp saveRegisterOp) {
        append(new AMD64HotSpotLeaveCurrentStackFrameOp(saveRegisterOp));
    }

    public void emitLeaveDeoptimizedStackFrame(Value frameSize, Value initialInfo) {
        Variable frameSizeVariable = load(frameSize);
        Variable initialInfoVariable = load(initialInfo);
        append(new AMD64HotSpotLeaveDeoptimizedStackFrameOp(frameSizeVariable, initialInfoVariable));
    }

    public void emitEnterUnpackFramesStackFrame(Value framePc, Value senderSp, Value senderFp, SaveRegistersOp saveRegisterOp) {
        Register threadRegister = getProviders().getRegisters().getThreadRegister();
        Variable framePcVariable = load(framePc);
        Variable senderSpVariable = load(senderSp);
        Variable senderFpVariable = load(senderFp);
        append(new AMD64HotSpotEnterUnpackFramesStackFrameOp(threadRegister, config.threadLastJavaSpOffset(), config.threadLastJavaPcOffset(), config.threadLastJavaFpOffset(), framePcVariable,
                        senderSpVariable, senderFpVariable, saveRegisterOp));
    }

    public void emitLeaveUnpackFramesStackFrame(SaveRegistersOp saveRegisterOp) {
        Register threadRegister = getProviders().getRegisters().getThreadRegister();
        append(new AMD64HotSpotLeaveUnpackFramesStackFrameOp(threadRegister, config.threadLastJavaSpOffset(), config.threadLastJavaPcOffset(), config.threadLastJavaFpOffset(), saveRegisterOp));
    }

    @Override
    public Value emitCardTableShift() {
        Variable result = newVariable(LIRKind.value(Kind.Long));
        append(new AMD64HotSpotCardTableShiftOp(result));
        return result;
    }

    @Override
    public Value emitCardTableAddress() {
        Variable result = newVariable(LIRKind.value(Kind.Long));
        append(new AMD64HotSpotCardTableAddressOp(result));
        return result;
    }

    /**
     * @param savedRegisters the registers saved by this operation which may be subject to pruning
     * @param savedRegisterLocations the slots to which the registers are saved
     * @param supportsRemove determines if registers can be pruned
     */
    protected AMD64SaveRegistersOp emitSaveRegisters(Register[] savedRegisters, StackSlotValue[] savedRegisterLocations, boolean supportsRemove) {
        AMD64SaveRegistersOp save = new AMD64SaveRegistersOp(savedRegisters, savedRegisterLocations, supportsRemove);
        append(save);
        return save;
    }

    /**
     * Adds a node to the graph that saves all allocatable registers to the stack.
     *
     * @param supportsRemove determines if registers can be pruned
     * @return the register save node
     */
    private AMD64SaveRegistersOp emitSaveAllRegisters(Register[] savedRegisters, boolean supportsRemove) {
        StackSlotValue[] savedRegisterLocations = new StackSlotValue[savedRegisters.length];
        for (int i = 0; i < savedRegisters.length; i++) {
            PlatformKind kind = target().arch.getLargestStorableKind(savedRegisters[i].getRegisterCategory());
            assert kind != Kind.Illegal;
            VirtualStackSlot spillSlot = getResult().getFrameMapBuilder().allocateSpillSlot(LIRKind.value(kind));
            savedRegisterLocations[i] = spillSlot;
        }
        return emitSaveRegisters(savedRegisters, savedRegisterLocations, supportsRemove);
    }

    @Override
    public SaveRegistersOp emitSaveAllRegisters() {
        // We are saving all registers.
        // TODO Save upper half of YMM registers.
        return emitSaveAllRegisters(cpuxmmRegisters, false);
    }

    protected void emitRestoreRegisters(AMD64SaveRegistersOp save) {
        append(new AMD64RestoreRegistersOp(save.getSlots().clone(), save));
    }

    public Stub getStub() {
        return ((AMD64HotSpotLIRGenerationResult) getResult()).getStub();
    }

    @Override
    public Variable emitForeignCall(ForeignCallLinkage linkage, LIRFrameState state, Value... args) {
        HotSpotForeignCallLinkage hotspotLinkage = (HotSpotForeignCallLinkage) linkage;
        boolean destroysRegisters = hotspotLinkage.destroysRegisters();

        AMD64SaveRegistersOp save = null;
        if (destroysRegisters) {
            if (getStub() != null) {
                if (getStub().preservesRegisters()) {
                    Register[] savedRegisters = getResult().getFrameMapBuilder().getRegisterConfig().getAllocatableRegisters();
                    save = emitSaveAllRegisters(savedRegisters, true);
                }
            }
        }

        Variable result;
        // TODO (je) check if we can remove this
        LIRFrameState deoptInfo = null;
        if (hotspotLinkage.canDeoptimize()) {
            deoptInfo = state;
            assert deoptInfo != null || getStub() != null;
            assert hotspotLinkage.needsJavaFrameAnchor();
        }

        if (hotspotLinkage.needsJavaFrameAnchor()) {
            Register thread = getProviders().getRegisters().getThreadRegister();
            append(new AMD64HotSpotCRuntimeCallPrologueOp(config.threadLastJavaSpOffset(), thread));
            result = super.emitForeignCall(hotspotLinkage, deoptInfo, args);
            append(new AMD64HotSpotCRuntimeCallEpilogueOp(config.threadLastJavaSpOffset(), config.threadLastJavaFpOffset(), thread));
        } else {
            assert deoptInfo == null;
            result = super.emitForeignCall(hotspotLinkage, null, args);
        }

        if (destroysRegisters) {
            if (getStub() != null) {
                if (getStub().preservesRegisters()) {
                    AMD64HotSpotLIRGenerationResult generationResult = (AMD64HotSpotLIRGenerationResult) getResult();
                    assert !generationResult.getCalleeSaveInfo().containsKey(currentRuntimeCallInfo);
                    generationResult.getCalleeSaveInfo().put(currentRuntimeCallInfo, save);
                    emitRestoreRegisters(save);
                } else {
                    assert zapRegisters();
                }
            }
        }

        return result;
    }

    public Value emitUncommonTrapCall(Value trapRequest, SaveRegistersOp saveRegisterOp) {
        ForeignCallLinkage linkage = getForeignCalls().lookupForeignCall(UNCOMMON_TRAP);

        Register thread = getProviders().getRegisters().getThreadRegister();
        append(new AMD64HotSpotCRuntimeCallPrologueOp(config.threadLastJavaSpOffset(), thread));
        Variable result = super.emitForeignCall(linkage, null, thread.asValue(LIRKind.value(Kind.Long)), trapRequest);
        append(new AMD64HotSpotCRuntimeCallEpilogueOp(config.threadLastJavaSpOffset(), config.threadLastJavaFpOffset(), thread));

        Map<LIRFrameState, SaveRegistersOp> calleeSaveInfo = ((AMD64HotSpotLIRGenerationResult) getResult()).getCalleeSaveInfo();
        assert !calleeSaveInfo.containsKey(currentRuntimeCallInfo);
        calleeSaveInfo.put(currentRuntimeCallInfo, saveRegisterOp);

        return result;
    }

    public Value emitDeoptimizationFetchUnrollInfoCall(SaveRegistersOp saveRegisterOp) {
        ForeignCallLinkage linkage = getForeignCalls().lookupForeignCall(FETCH_UNROLL_INFO);

        Register thread = getProviders().getRegisters().getThreadRegister();
        append(new AMD64HotSpotCRuntimeCallPrologueOp(config.threadLastJavaSpOffset(), thread));
        Variable result = super.emitForeignCall(linkage, null, thread.asValue(LIRKind.value(Kind.Long)));
        append(new AMD64HotSpotCRuntimeCallEpilogueOp(config.threadLastJavaSpOffset(), config.threadLastJavaFpOffset(), thread));

        Map<LIRFrameState, SaveRegistersOp> calleeSaveInfo = ((AMD64HotSpotLIRGenerationResult) getResult()).getCalleeSaveInfo();
        assert !calleeSaveInfo.containsKey(currentRuntimeCallInfo);
        calleeSaveInfo.put(currentRuntimeCallInfo, saveRegisterOp);

        return result;
    }

    protected AMD64ZapRegistersOp emitZapRegisters(Register[] zappedRegisters, JavaConstant[] zapValues) {
        AMD64ZapRegistersOp zap = new AMD64ZapRegistersOp(zappedRegisters, zapValues);
        append(zap);
        return zap;
    }

    protected boolean zapRegisters() {
        Register[] zappedRegisters = getResult().getFrameMapBuilder().getRegisterConfig().getAllocatableRegisters();
        JavaConstant[] zapValues = new JavaConstant[zappedRegisters.length];
        for (int i = 0; i < zappedRegisters.length; i++) {
            PlatformKind kind = target().arch.getLargestStorableKind(zappedRegisters[i].getRegisterCategory());
            assert kind != Kind.Illegal;
            zapValues[i] = zapValueForKind(kind);
        }
        ((AMD64HotSpotLIRGenerationResult) getResult()).getCalleeSaveInfo().put(currentRuntimeCallInfo, emitZapRegisters(zappedRegisters, zapValues));
        return true;
    }

    @Override
    public void emitTailcall(Value[] args, Value address) {
        append(new AMD64TailcallOp(args, address));
    }

    @Override
    public void emitCCall(long address, CallingConvention nativeCallingConvention, Value[] args, int numberOfFloatingPointArguments) {
        Value[] argLocations = new Value[args.length];
        getResult().getFrameMapBuilder().callsMethod(nativeCallingConvention);
        // TODO(mg): in case a native function uses floating point varargs, the ABI requires that
        // RAX contains the length of the varargs
        PrimitiveConstant intConst = JavaConstant.forInt(numberOfFloatingPointArguments);
        AllocatableValue numberOfFloatingPointArgumentsRegister = AMD64.rax.asValue(intConst.getLIRKind());
        emitMove(numberOfFloatingPointArgumentsRegister, intConst);
        for (int i = 0; i < args.length; i++) {
            Value arg = args[i];
            AllocatableValue loc = nativeCallingConvention.getArgument(i);
            emitMove(loc, arg);
            argLocations[i] = loc;
        }
        Value ptr = emitMove(JavaConstant.forLong(address));
        append(new AMD64CCall(nativeCallingConvention.getReturn(), ptr, numberOfFloatingPointArgumentsRegister, argLocations));
    }

    @Override
    public void emitUnwind(Value exception) {
        ForeignCallLinkage linkage = getForeignCalls().lookupForeignCall(HotSpotBackend.UNWIND_EXCEPTION_TO_CALLER);
        CallingConvention outgoingCc = linkage.getOutgoingCallingConvention();
        assert outgoingCc.getArgumentCount() == 2;
        RegisterValue exceptionParameter = (RegisterValue) outgoingCc.getArgument(0);
        emitMove(exceptionParameter, exception);
        append(new AMD64HotSpotUnwindOp(exceptionParameter));
    }

    private void moveDeoptValuesToThread(Value actionAndReason, Value speculation) {
        moveValueToThread(actionAndReason, config.pendingDeoptimizationOffset);
        moveValueToThread(speculation, config.pendingFailedSpeculationOffset);
    }

    private void moveValueToThread(Value v, int offset) {
        LIRKind wordKind = LIRKind.value(getProviders().getCodeCache().getTarget().wordKind);
        RegisterValue thread = getProviders().getRegisters().getThreadRegister().asValue(wordKind);
        AMD64AddressValue address = new AMD64AddressValue(wordKind, thread, offset);
        emitStore(v.getLIRKind(), address, v, null);
    }

    @Override
    public void emitDeoptimize(Value actionAndReason, Value speculation, LIRFrameState state) {
        moveDeoptValuesToThread(actionAndReason, speculation);
        append(new AMD64DeoptimizeOp(state));
    }

    @Override
    public void emitDeoptimizeCaller(DeoptimizationAction action, DeoptimizationReason reason) {
        moveDeoptValuesToThread(getMetaAccess().encodeDeoptActionAndReason(action, reason, 0), JavaConstant.NULL_POINTER);
        append(new AMD64HotSpotDeoptimizeCallerOp());
    }

    @Override
    public void beforeRegisterAllocation() {
        super.beforeRegisterAllocation();
        boolean hasDebugInfo = getResult().getLIR().hasDebugInfo();
        AllocatableValue savedRbp = saveRbp.finalize(hasDebugInfo);
        if (hasDebugInfo) {
            ((AMD64HotSpotLIRGenerationResult) getResult()).setDeoptimizationRescueSlot(((AMD64FrameMapBuilder) getResult().getFrameMapBuilder()).allocateDeoptimizationRescueSlot());
        }

        for (AMD64HotSpotEpilogueOp op : epilogueOps) {
            op.savedRbp = savedRbp;
        }
    }

    private static LIRKind toStackKind(LIRKind kind) {
        if (kind.getPlatformKind() instanceof Kind) {
            Kind stackKind = ((Kind) kind.getPlatformKind()).getStackKind();
            return kind.changeType(stackKind);
        } else {
            return kind;
        }
    }

    public void emitPushInterpreterFrame(Value frameSize, Value framePc, Value senderSp, Value initialInfo) {
        Variable frameSizeVariable = load(frameSize);
        Variable framePcVariable = load(framePc);
        Variable senderSpVariable = load(senderSp);
        Variable initialInfoVariable = load(initialInfo);
        append(new AMD64HotSpotPushInterpreterFrameOp(frameSizeVariable, framePcVariable, senderSpVariable, initialInfoVariable, config));
    }

    @Override
    public Variable emitLoad(LIRKind kind, Value address, LIRFrameState state) {
        AMD64AddressValue loadAddress = asAddressValue(address);
        Variable result = newVariable(toStackKind(kind));
        append(new LoadOp((Kind) kind.getPlatformKind(), result, loadAddress, state));
        return result;
    }

    @Override
    public void emitStore(LIRKind kind, Value address, Value inputVal, LIRFrameState state) {
        AMD64AddressValue storeAddress = asAddressValue(address);
        if (isConstant(inputVal)) {
            JavaConstant c = asConstant(inputVal);
            if (canStoreConstant(c)) {
                append(new HotSpotStoreConstantOp((Kind) kind.getPlatformKind(), storeAddress, c, state));
                return;
            }
        }
        Variable input = load(inputVal);
        append(new StoreOp((Kind) kind.getPlatformKind(), storeAddress, input, state));
    }

    @Override
    public Value emitCompress(Value pointer, CompressEncoding encoding, boolean nonNull) {
        LIRKind inputKind = pointer.getLIRKind();
        assert inputKind.getPlatformKind() == Kind.Long || inputKind.getPlatformKind() == Kind.Object;
        if (inputKind.isReference(0)) {
            // oop
            Variable result = newVariable(LIRKind.reference(Kind.Int));
            append(new AMD64HotSpotMove.CompressPointer(result, asAllocatable(pointer), getProviders().getRegisters().getHeapBaseRegister().asValue(), encoding, nonNull));
            return result;
        } else {
            // metaspace pointer
            Variable result = newVariable(LIRKind.value(Kind.Int));
            AllocatableValue base = Value.ILLEGAL;
            if (encoding.base != 0) {
                base = emitMove(JavaConstant.forLong(encoding.base));
            }
            append(new AMD64HotSpotMove.CompressPointer(result, asAllocatable(pointer), base, encoding, nonNull));
            return result;
        }
    }

    @Override
    public Value emitUncompress(Value pointer, CompressEncoding encoding, boolean nonNull) {
        LIRKind inputKind = pointer.getLIRKind();
        assert inputKind.getPlatformKind() == Kind.Int;
        if (inputKind.isReference(0)) {
            // oop
            Variable result = newVariable(LIRKind.reference(Kind.Object));
            append(new AMD64HotSpotMove.UncompressPointer(result, asAllocatable(pointer), getProviders().getRegisters().getHeapBaseRegister().asValue(), encoding, nonNull));
            return result;
        } else {
            // metaspace pointer
            Variable result = newVariable(LIRKind.value(Kind.Long));
            AllocatableValue base = Value.ILLEGAL;
            if (encoding.base != 0) {
                base = emitMove(JavaConstant.forLong(encoding.base));
            }
            append(new AMD64HotSpotMove.UncompressPointer(result, asAllocatable(pointer), base, encoding, nonNull));
            return result;
        }
    }

    @Override
    protected AMD64LIRInstruction createMove(AllocatableValue dst, Value src) {
        if (src instanceof JavaConstant) {
            return new AMD64HotSpotMove.HotSpotLoadConstantOp(dst, (JavaConstant) src);
        } else {
            return super.createMove(dst, src);
        }
    }

    public Variable emitCompareAndSwap(Value address, Value expectedValue, Value newValue, Value trueValue, Value falseValue) {
        LIRKind kind = newValue.getLIRKind();
        assert kind.equals(expectedValue.getLIRKind());
        Kind memKind = (Kind) kind.getPlatformKind();

        AMD64AddressValue addressValue = asAddressValue(address);
        RegisterValue raxRes = AMD64.rax.asValue(kind);
        emitMove(raxRes, expectedValue);
        append(new CompareAndSwapOp(memKind, raxRes, addressValue, raxRes, asAllocatable(newValue)));

        assert trueValue.getLIRKind().equals(falseValue.getLIRKind());
        Variable result = newVariable(trueValue.getLIRKind());
        append(new CondMoveOp(result, Condition.EQ, asAllocatable(trueValue), falseValue));
        return result;
    }

    public Value emitAtomicReadAndAdd(Value address, Value delta) {
        LIRKind kind = delta.getLIRKind();
        Kind memKind = (Kind) kind.getPlatformKind();
        Variable result = newVariable(kind);
        AMD64AddressValue addressValue = asAddressValue(address);
        append(new AMD64Move.AtomicReadAndAddOp(memKind, result, addressValue, asAllocatable(delta)));
        return result;
    }

    public Value emitAtomicReadAndWrite(Value address, Value newValue) {
        LIRKind kind = newValue.getLIRKind();
        Kind memKind = (Kind) kind.getPlatformKind();
        Variable result = newVariable(kind);
        AMD64AddressValue addressValue = asAddressValue(address);
        append(new AMD64Move.AtomicReadAndWriteOp(memKind, result, addressValue, asAllocatable(newValue)));
        return result;
    }

    public void emitNullCheck(Value address, LIRFrameState state) {
        if (address.getLIRKind().getPlatformKind() == Kind.Int) {
            CompressEncoding encoding = config.getOopEncoding();
            if (encoding.shift <= 3) {
                AMD64AddressValue uncompressionAddress = emitAddress(getProviders().getRegisters().getHeapBaseRegister().asValue(), 0, load(address), 1 << encoding.shift);
                append(new AMD64HotSpotMove.CompressedNullCheckOp(uncompressionAddress, state));
            } else {
                Value uncompress = emitUncompress(address, encoding, false);
                append(new AMD64Move.NullCheckOp(load(uncompress), state));
            }
        } else {
            assert address.getKind() == Kind.Object || address.getKind() == Kind.Long : address + " - " + address.getKind() + " not a pointer!";
            append(new AMD64Move.NullCheckOp(load(address), state));
        }
    }

    @Override
    protected void emitCompareOp(PlatformKind cmpKind, Variable left, Value right) {
        if (right instanceof HotSpotConstant) {
            append(new AMD64HotSpotCompare.HotSpotCompareConstantOp(left, (JavaConstant) right));
        } else {
            super.emitCompareOp(cmpKind, left, right);
        }
    }

    @Override
    protected void emitCompareMemoryConOp(Kind kind, AMD64AddressValue address, JavaConstant value, LIRFrameState state) {
        if (value instanceof HotSpotConstant) {
            append(new AMD64HotSpotCompare.HotSpotCompareMemoryConstantOp(kind, address, value, state));
        } else {
            super.emitCompareMemoryConOp(kind, address, value, state);
        }
    }

    @Override
    public boolean canInlineConstant(JavaConstant c) {
        if (HotSpotCompressedNullConstant.COMPRESSED_NULL.equals(c)) {
            return true;
        } else if (c instanceof HotSpotObjectConstant) {
            return ((HotSpotObjectConstant) c).isCompressed();
        } else {
            return super.canInlineConstant(c);
        }
    }
}
