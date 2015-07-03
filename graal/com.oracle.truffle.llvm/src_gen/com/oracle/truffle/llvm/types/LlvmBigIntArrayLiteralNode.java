package com.oracle.truffle.llvm.types;

import java.math.*;

import com.oracle.truffle.api.frame.*;
import com.oracle.truffle.api.nodes.*;
import com.oracle.truffle.api.source.*;
import com.oracle.truffle.llvm.nodes.*;

@NodeInfo(shortName = "big integer array")
public final class LlvmBigIntArrayLiteralNode extends LlvmExpressionNode {

    private BigInteger[] value;

    public LlvmBigIntArrayLiteralNode(SourceSection src, BigInteger[] value) {
        super(src);
        this.value = value;
    }

    @Override
    public BigInteger[] executeBigIntegerArray(VirtualFrame frame) {
        return value;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return value;
    }
}
