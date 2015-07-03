package com.oracle.truffle.llvm.node.expression;

import java.math.*;

import com.oracle.truffle.api.CompilerDirectives.*;
import com.oracle.truffle.api.dsl.*;
import com.oracle.truffle.api.nodes.*;
import com.oracle.truffle.api.source.*;
import com.oracle.truffle.llvm.nodes.*;

@NodeInfo(shortName = "shl")
public abstract class LlvmShlName extends LlvmBinaryNode {

    String str;

    public LlvmShlName(SourceSection src, String str) {
        super(src);
        str = this.str;
    }

    @Specialization(rewriteOn = ArithmeticException.class)
    protected long shl(long left, long right) {
        switch (str) {
            case "shl":
                return left << right;
            case "lshr":
                return left >>> right;
            case "ashr":
                return left >> right;
            default:
                return -1;
        }

    }

}
