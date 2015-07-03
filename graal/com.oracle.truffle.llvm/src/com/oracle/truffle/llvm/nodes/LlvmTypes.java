package com.oracle.truffle.llvm.nodes;

import java.lang.reflect.*;
import java.math.*;
import java.util.*;

import com.oracle.truffle.api.dsl.*;
import com.oracle.truffle.api.dsl.internal.*;
import com.oracle.truffle.llvm.nodes.controlflow.*;
import com.oracle.truffle.llvm.runtime.*;

@TypeSystem({long.class, BigInteger.class, boolean.class, String.class, List.class, LlvmFunction.class, LlvmBlockNode.class, LlvmNull.class, float.class, double.class, int[].class, boolean[].class,
                float[].class, double[].class})
@DSLOptions(useNewLayout = true)
public abstract class LlvmTypes {

    @ImplicitCast
    public static BigInteger castBigInteger(long value) {
        return BigInteger.valueOf(value);
    }

    @ImplicitCast
    public static double castDouble(float value) {
        return Double.valueOf(value);
    }

}
