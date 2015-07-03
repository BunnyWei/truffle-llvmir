package com.oracle.truffle.llvm.types;

import com.oracle.truffle.api.frame.*;
import com.oracle.truffle.api.source.*;
import com.oracle.truffle.llvm.nodes.*;

public final class LlvmDoubleLiteralNode extends LlvmExpressionNode {

    private double value;

    public LlvmDoubleLiteralNode(SourceSection src, double value) {
        super(src);
        this.value = value;
    }

    @Override
    public double executeDouble(VirtualFrame frame) {
        return value;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return value;
    }

}
