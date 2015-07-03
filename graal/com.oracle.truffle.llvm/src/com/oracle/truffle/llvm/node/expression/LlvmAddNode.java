package com.oracle.truffle.llvm.node.expression;

import java.math.*;

import com.oracle.truffle.api.*;
import com.oracle.truffle.api.CompilerDirectives.*;
import com.oracle.truffle.api.dsl.*;
import com.oracle.truffle.api.nodes.*;
import com.oracle.truffle.api.source.*;
import com.oracle.truffle.llvm.nodes.*;

@NodeInfo(shortName = "add")
public abstract class LlvmAddNode extends LlvmBinaryNode {

    protected LlvmAddNode(SourceSection src) {
        super(src);
        // TODO Auto-generated constructor stub
    }

    @Specialization(rewriteOn = ArithmeticException.class)
    protected long add(long left, long right) {
        return ExactMath.addExact(left, right);
    }

    @Specialization
    @TruffleBoundary
    protected BigInteger add(BigInteger left, BigInteger right) {
        return left.add(right);
    }

    @Specialization
    @TruffleBoundary
    protected float add(float left, float right) {
        return left + right;
    }

    @Specialization(guards = "isString(left, right)")
    @TruffleBoundary
    protected String add(Object left, Object right) {
        return left.toString() + right.toString();
    }

    protected boolean isString(Object a, Object b) {
        return a instanceof String || b instanceof String;
    }
}
