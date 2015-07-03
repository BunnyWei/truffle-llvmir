package com.oracle.truffle.llvm.node.expression;

import java.math.*;

import com.oracle.truffle.api.CompilerDirectives.*;
import com.oracle.truffle.api.dsl.*;
import com.oracle.truffle.api.nodes.*;
import com.oracle.truffle.api.source.*;
import com.oracle.truffle.llvm.nodes.*;

@NodeInfo(shortName = "and")
public abstract class LlvmAndNode extends LlvmBinaryNode {

    public LlvmAndNode(SourceSection src) {
        super(src);
    }

    @Specialization(rewriteOn = ArithmeticException.class)
    protected long add(long left, long right) {
        return left & right;
    }

    @Specialization
    @TruffleBoundary
    protected BigInteger add(BigInteger left, BigInteger right) {
        return left.and(right);
    }

}
