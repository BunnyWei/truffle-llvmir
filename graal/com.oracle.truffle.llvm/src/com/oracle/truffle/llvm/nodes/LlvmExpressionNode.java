package com.oracle.truffle.llvm.nodes;

import java.math.*;

import com.oracle.truffle.api.dsl.*;
import com.oracle.truffle.api.frame.*;
import com.oracle.truffle.api.nodes.*;
import com.oracle.truffle.api.source.*;
import com.oracle.truffle.llvm.nodes.*;
import com.oracle.truffle.llvm.nodes.controlflow.*;
import com.oracle.truffle.llvm.runtime.*;

@TypeSystemReference(LlvmTypes.class)
public abstract class LlvmExpressionNode extends LlvmStatementNode {

    public LlvmExpressionNode(SourceSection src) {
        super(src);
    }

    public abstract Object executeGeneric(VirtualFrame frame);

    @Override
    public void executeVoid(VirtualFrame frame) {
        executeGeneric(frame);
    }

    public long executeLong(VirtualFrame frameValue) throws UnexpectedResultException {
        return LlvmTypesGen.expectLong(executeGeneric(frameValue));
        // return 0;
    }

    public float executeFloat(VirtualFrame frameValue) throws UnexpectedResultException {
        return LlvmTypesGen.expectFloat(executeGeneric(frameValue));
        // return 0;
    }

    public LlvmFunction executeFunction(VirtualFrame frame) throws UnexpectedResultException {
        return LlvmTypesGen.expectLlvmFunction(executeGeneric(frame));
    }

    // basicBlock
    public LlvmBlockNode executeBlock(VirtualFrame frame) throws UnexpectedResultException {
        return LlvmTypesGen.expectLlvmBlockNode(executeGeneric(frame));
    }

    public BigInteger executeBigInteger(VirtualFrame frame) throws UnexpectedResultException {
        return LlvmTypesGen.expectBigInteger(executeGeneric(frame));
        // return null;
    }

    public boolean executeBoolean(VirtualFrame frame) throws UnexpectedResultException {
        return LlvmTypesGen.expectBoolean(executeGeneric(frame));
    }

    public String executeString(VirtualFrame frame) throws UnexpectedResultException {
        return LlvmTypesGen.expectString(executeGeneric(frame));
    }

    public LlvmNull executeNull(VirtualFrame frame) throws UnexpectedResultException {
        return LlvmTypesGen.expectLlvmNull(executeGeneric(frame));
    }

    public int[] executeIntArray(VirtualFrame frame) throws UnexpectedResultException {
        return LlvmTypesGen.expectIntArray(executeGeneric(frame));
    }

    public float[] executeFloatArray(VirtualFrame frame) throws UnexpectedResultException {
        return LlvmTypesGen.expectFloatArray(executeGeneric(frame));
    }

    public double[] executeDoubleArray(VirtualFrame frame) throws UnexpectedResultException {
        return LlvmTypesGen.expectDoubleArray(executeGeneric(frame));
    }

    public boolean[] executeBooleanArray(VirtualFrame frame) throws UnexpectedResultException {
        return LlvmTypesGen.expectBooleanArray(executeGeneric(frame));
    }

    public double executeDouble(VirtualFrame frame) throws UnexpectedResultException {
        return LlvmTypesGen.expectDouble(executeGeneric(frame));
    }

    public BigInteger[] executeBigIntegerArray(VirtualFrame frame) throws UnexpectedResultException {
        return LlvmTypesGen.expectBigIntegerArray(executeGeneric(frame));
    }

}
