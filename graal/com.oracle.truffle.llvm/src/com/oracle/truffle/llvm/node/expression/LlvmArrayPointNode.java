package com.oracle.truffle.llvm.node.expression;

import java.math.*;
import java.util.*;

import com.oracle.truffle.api.CompilerDirectives.*;
import com.oracle.truffle.api.dsl.*;
import com.oracle.truffle.api.nodes.*;
import com.oracle.truffle.api.source.*;
import com.oracle.truffle.llvm.nodes.*;

@NodeInfo(shortName = "arrayPointer")
public abstract class LlvmArrayPointNode extends LlvmBinaryNode {

    public LlvmArrayPointNode(SourceSection src) {
        super(src);
    }

    @Specialization
    @TruffleBoundary
    protected List point(int[] left, long right) {
        List list = new ArrayList();
        list.add(left);
        list.add(right);
        return list;
    }

    @Specialization
    @TruffleBoundary
    protected List point(float[] left, long right) {
        List<Object> list = new ArrayList<Object>();
        list.add(left);
        list.add(right);
        return list;
    }

    @Specialization
    @TruffleBoundary
    protected List point(boolean[] left, long right) {
        List list = new ArrayList();
        list.add(left);
        list.add(right);
        return list;
    }

    @Specialization
    @TruffleBoundary
    protected List point(double[] left, long right) {
        List list = new ArrayList();
        list.add(left);
        list.add(right);
        return list;
    }

}
