package com.oracle.truffle.llvm.types;

import com.oracle.truffle.api.frame.*;
import com.oracle.truffle.api.source.*;
import com.oracle.truffle.llvm.nodes.*;

public final class LlvmIntArrayLiteralNode extends LlvmExpressionNode {

    private int[] value;

    public LlvmIntArrayLiteralNode(SourceSection src, int[] value) {
        super(src);
        this.value = value;
    }

    @Override
    public int[] executeIntArray(VirtualFrame frame) {
        return value;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return value;
    }
}
