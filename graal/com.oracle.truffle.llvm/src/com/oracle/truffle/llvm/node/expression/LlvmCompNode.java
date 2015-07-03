package com.oracle.truffle.llvm.node.expression;

import java.math.*;

import com.oracle.truffle.api.dsl.*;
import com.oracle.truffle.api.nodes.*;
import com.oracle.truffle.api.source.*;
import com.oracle.truffle.llvm.nodes.*;

@NodeInfo(shortName = "cmp")
public abstract class LlvmCompNode extends LlvmBinaryNode {

    String str;

    public LlvmCompNode(SourceSection src, String str) {
        super(src);
        this.str = str;
    }

    @Specialization
    protected boolean lessOrEqual(long left, long right) {
        switch (str) {
            case "ult":
            case "slt":
                return left < right;
            case "ule":
            case "sle":
                return left <= right;
            case "ugt":
            case "sgt":
                return left > right;
            case "uge":
            case "sge":
                return left >= right;
            case "eq":
                return left == right;
            case "ne":
                return left != right;
            default:
                return false;
        }
    }

    @Specialization
    protected boolean lessOrEqual(BigInteger left, BigInteger right) {
        switch (str) {
            case "ult":
            case "slt":
                return left.compareTo(right) < 0;
            case "ule":
            case "sle":
                return left.compareTo(right) <= 0;
            case "ugt":
            case "sgt":
                return left.compareTo(right) > 0;
            case "uge":
            case "sge":
                return left.compareTo(right) >= 0;
            case "eq":
                return left.compareTo(right) == 0;
            case "ne":
                return left.compareTo(right) != 0;
            default:
                return false;
        }
    }

}