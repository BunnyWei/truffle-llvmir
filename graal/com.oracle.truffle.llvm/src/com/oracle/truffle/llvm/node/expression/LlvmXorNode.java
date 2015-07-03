package com.oracle.truffle.llvm.node.expression;

import java.math.*;

import com.oracle.truffle.api.CompilerDirectives.*;
import com.oracle.truffle.api.dsl.*;
import com.oracle.truffle.api.nodes.*;
import com.oracle.truffle.api.source.*;
import com.oracle.truffle.llvm.nodes.*;

@NodeInfo(shortName = "xor")
public abstract class LlvmXorNode extends LlvmBinaryNode {

    public LlvmXorNode(SourceSection src) {
        super(src);
    }

    @Specialization(rewriteOn = ArithmeticException.class)
    protected long xor(long left, long right) {
        return left ^ right;
    }

    @Specialization
    @TruffleBoundary
    protected BigInteger xor(BigInteger left, BigInteger right) {
        return left.xor(right);
    }

}
