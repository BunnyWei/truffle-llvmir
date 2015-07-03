package com.oracle.truffle.llvm.node.expression;

import java.math.*;

import com.oracle.truffle.api.*;
import com.oracle.truffle.api.CompilerDirectives.*;
import com.oracle.truffle.api.dsl.*;
import com.oracle.truffle.api.nodes.*;
import com.oracle.truffle.api.source.*;
import com.oracle.truffle.llvm.nodes.*;

@NodeInfo(shortName = "or")
public abstract class LlvmOrNode extends LlvmBinaryNode {

    public LlvmOrNode(SourceSection src) {
        super(src);
    }

    @Specialization(rewriteOn = ArithmeticException.class)
    protected long or(long left, long right) {
        return left | right;
    }

    @Specialization
    @TruffleBoundary
    protected BigInteger or(BigInteger left, BigInteger right) {
        return left.or(right);
    }

}
