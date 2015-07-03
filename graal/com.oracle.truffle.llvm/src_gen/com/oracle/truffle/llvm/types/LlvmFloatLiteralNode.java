package com.oracle.truffle.llvm.types;

import com.oracle.truffle.api.frame.*;
import com.oracle.truffle.api.source.*;
import com.oracle.truffle.llvm.nodes.*;

public final class LlvmFloatLiteralNode extends LlvmExpressionNode {

    private final float value;

    public LlvmFloatLiteralNode(SourceSection src, float value) {
        super(src);
        this.value = value;
    }

    @Override
    public float executeFloat(VirtualFrame frame) {
        return value;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return value;
    }

}
