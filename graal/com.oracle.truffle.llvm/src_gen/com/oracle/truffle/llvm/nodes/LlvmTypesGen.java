// CheckStyle: start generated
package com.oracle.truffle.llvm.nodes;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.internal.SpecializationNode;
import com.oracle.truffle.api.frame.Frame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.llvm.nodes.controlflow.LlvmBlockNode;
import com.oracle.truffle.llvm.runtime.LlvmFunction;
import com.oracle.truffle.llvm.runtime.LlvmNull;
import java.math.BigInteger;
import java.util.List;

@GeneratedBy(LlvmTypes.class)
public final class LlvmTypesGen extends LlvmTypes {

    @Deprecated public static final LlvmTypesGen LLVMTYPES = new LlvmTypesGen();

    protected LlvmTypesGen() {
    }

    public static boolean isLong(Object value) {
        return value instanceof Long;
    }

    public static long asLong(Object value) {
        assert value instanceof Long : "LlvmTypesGen.asLong: Long expected";
        return (long) value;
    }

    public static long expectLong(Object value) throws UnexpectedResultException {
        if (value instanceof Long) {
            return (long) value;
        }
        throw new UnexpectedResultException(value);
    }

    public static boolean isBigInteger(Object value) {
        return value instanceof BigInteger;
    }

    public static BigInteger asBigInteger(Object value) {
        assert value instanceof BigInteger : "LlvmTypesGen.asBigInteger: BigInteger expected";
        return (BigInteger) value;
    }

    public static BigInteger expectBigInteger(Object value) throws UnexpectedResultException {
        if (value instanceof BigInteger) {
            return (BigInteger) value;
        }
        throw new UnexpectedResultException(value);
    }

    public static BigInteger asImplicitBigInteger(Object value) {
        if (value instanceof Long) {
            return castBigInteger((long) value);
        } else if (value instanceof BigInteger) {
            return (BigInteger) value;
        } else {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            throw new IllegalArgumentException("Illegal type ");
        }
    }

    public static boolean isImplicitBigInteger(Object value) {
        return value instanceof Long
             || value instanceof BigInteger;
    }

    public static BigInteger asImplicitBigInteger(Object value, Class<?> typeHint) {
        if (typeHint == long.class) {
            return castBigInteger((long) value);
        } else if (typeHint == BigInteger.class) {
            return (BigInteger) value;
        } else {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            throw new IllegalArgumentException("Illegal type ");
        }
    }

    public static BigInteger expectImplicitBigInteger(Object value, Class<?> typeHint) throws UnexpectedResultException {
        if (typeHint == long.class && value instanceof Long) {
            return castBigInteger((long) value);
        } else if (typeHint == BigInteger.class && value instanceof BigInteger) {
            return (BigInteger) value;
        } else {
            throw new UnexpectedResultException(value);
        }
    }

    public static boolean isImplicitBigInteger(Object value, Class<?> typeHint) {
        return (typeHint == long.class && value instanceof Long)
             || (typeHint == BigInteger.class && value instanceof BigInteger);
    }

    public static Class<?> getImplicitBigIntegerClass(Object value) {
        if (value instanceof Long) {
            return long.class;
        } else if (value instanceof BigInteger) {
            return BigInteger.class;
        } else {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            throw new IllegalArgumentException("Illegal type ");
        }
    }

    public static boolean isBoolean(Object value) {
        return value instanceof Boolean;
    }

    public static boolean asBoolean(Object value) {
        assert value instanceof Boolean : "LlvmTypesGen.asBoolean: Boolean expected";
        return (boolean) value;
    }

    public static boolean expectBoolean(Object value) throws UnexpectedResultException {
        if (value instanceof Boolean) {
            return (boolean) value;
        }
        throw new UnexpectedResultException(value);
    }

    public static boolean isString(Object value) {
        return value instanceof String;
    }

    public static String asString(Object value) {
        assert value instanceof String : "LlvmTypesGen.asString: String expected";
        return (String) value;
    }

    public static String expectString(Object value) throws UnexpectedResultException {
        if (value instanceof String) {
            return (String) value;
        }
        throw new UnexpectedResultException(value);
    }

    public static boolean isList(Object value) {
        return value instanceof List<?>;
    }

    public static List<?> asList(Object value) {
        assert value instanceof List<?> : "LlvmTypesGen.asList: List<?> expected";
        return (List<?>) value;
    }

    public static List<?> expectList(Object value) throws UnexpectedResultException {
        if (value instanceof List<?>) {
            return (List<?>) value;
        }
        throw new UnexpectedResultException(value);
    }

    public static boolean isLlvmFunction(Object value) {
        return value instanceof LlvmFunction;
    }

    public static LlvmFunction asLlvmFunction(Object value) {
        assert value instanceof LlvmFunction : "LlvmTypesGen.asLlvmFunction: LlvmFunction expected";
        return (LlvmFunction) value;
    }

    public static LlvmFunction expectLlvmFunction(Object value) throws UnexpectedResultException {
        if (value instanceof LlvmFunction) {
            return (LlvmFunction) value;
        }
        throw new UnexpectedResultException(value);
    }

    public static boolean isLlvmBlockNode(Object value) {
        return value instanceof LlvmBlockNode;
    }

    public static LlvmBlockNode asLlvmBlockNode(Object value) {
        assert value instanceof LlvmBlockNode : "LlvmTypesGen.asLlvmBlockNode: LlvmBlockNode expected";
        return (LlvmBlockNode) value;
    }

    public static LlvmBlockNode expectLlvmBlockNode(Object value) throws UnexpectedResultException {
        if (value instanceof LlvmBlockNode) {
            return (LlvmBlockNode) value;
        }
        throw new UnexpectedResultException(value);
    }

    public static boolean isLlvmNull(Object value) {
        return value instanceof LlvmNull;
    }

    public static LlvmNull asLlvmNull(Object value) {
        assert value instanceof LlvmNull : "LlvmTypesGen.asLlvmNull: LlvmNull expected";
        return (LlvmNull) value;
    }

    public static LlvmNull expectLlvmNull(Object value) throws UnexpectedResultException {
        if (value instanceof LlvmNull) {
            return (LlvmNull) value;
        }
        throw new UnexpectedResultException(value);
    }

    public static boolean isFloat(Object value) {
        return value instanceof Float;
    }

    public static float asFloat(Object value) {
        assert value instanceof Float : "LlvmTypesGen.asFloat: Float expected";
        return (float) value;
    }

    public static float expectFloat(Object value) throws UnexpectedResultException {
        if (value instanceof Float) {
            return (float) value;
        }
        throw new UnexpectedResultException(value);
    }

    public static boolean isDouble(Object value) {
        return value instanceof Double;
    }

    public static double asDouble(Object value) {
        assert value instanceof Double : "LlvmTypesGen.asDouble: Double expected";
        return (double) value;
    }

    public static double expectDouble(Object value) throws UnexpectedResultException {
        if (value instanceof Double) {
            return (double) value;
        }
        throw new UnexpectedResultException(value);
    }

    public static double asImplicitDouble(Object value) {
        if (value instanceof Float) {
            return castDouble((float) value);
        } else if (value instanceof Double) {
            return (double) value;
        } else {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            throw new IllegalArgumentException("Illegal type ");
        }
    }

    public static boolean isImplicitDouble(Object value) {
        return value instanceof Float
             || value instanceof Double;
    }

    public static double asImplicitDouble(Object value, Class<?> typeHint) {
        if (typeHint == float.class) {
            return castDouble((float) value);
        } else if (typeHint == double.class) {
            return (double) value;
        } else {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            throw new IllegalArgumentException("Illegal type ");
        }
    }

    public static double expectImplicitDouble(Object value, Class<?> typeHint) throws UnexpectedResultException {
        if (typeHint == float.class && value instanceof Float) {
            return castDouble((float) value);
        } else if (typeHint == double.class && value instanceof Double) {
            return (double) value;
        } else {
            throw new UnexpectedResultException(value);
        }
    }

    public static boolean isImplicitDouble(Object value, Class<?> typeHint) {
        return (typeHint == float.class && value instanceof Float)
             || (typeHint == double.class && value instanceof Double);
    }

    public static Class<?> getImplicitDoubleClass(Object value) {
        if (value instanceof Float) {
            return float.class;
        } else if (value instanceof Double) {
            return double.class;
        } else {
            CompilerDirectives.transferToInterpreterAndInvalidate();
            throw new IllegalArgumentException("Illegal type ");
        }
    }

    public static boolean isIntArray(Object value) {
        return value instanceof int[];
    }

    public static int[] asIntArray(Object value) {
        assert value instanceof int[] : "LlvmTypesGen.asIntArray: int[] expected";
        return (int[]) value;
    }

    public static int[] expectIntArray(Object value) throws UnexpectedResultException {
        if (value instanceof int[]) {
            return (int[]) value;
        }
        throw new UnexpectedResultException(value);
    }

    public static boolean isBooleanArray(Object value) {
        return value instanceof boolean[];
    }

    public static boolean[] asBooleanArray(Object value) {
        assert value instanceof boolean[] : "LlvmTypesGen.asBooleanArray: boolean[] expected";
        return (boolean[]) value;
    }

    public static boolean[] expectBooleanArray(Object value) throws UnexpectedResultException {
        if (value instanceof boolean[]) {
            return (boolean[]) value;
        }
        throw new UnexpectedResultException(value);
    }

    public static boolean isFloatArray(Object value) {
        return value instanceof float[];
    }

    public static float[] asFloatArray(Object value) {
        assert value instanceof float[] : "LlvmTypesGen.asFloatArray: float[] expected";
        return (float[]) value;
    }

    public static float[] expectFloatArray(Object value) throws UnexpectedResultException {
        if (value instanceof float[]) {
            return (float[]) value;
        }
        throw new UnexpectedResultException(value);
    }

    public static boolean isDoubleArray(Object value) {
        return value instanceof double[];
    }

    public static double[] asDoubleArray(Object value) {
        assert value instanceof double[] : "LlvmTypesGen.asDoubleArray: double[] expected";
        return (double[]) value;
    }

    public static double[] expectDoubleArray(Object value) throws UnexpectedResultException {
        if (value instanceof double[]) {
            return (double[]) value;
        }
        throw new UnexpectedResultException(value);
    }

    @GeneratedBy(LlvmTypes.class)
    public abstract static class LlvmTypesNode extends SpecializationNode {

        public LlvmTypesNode() {
            super();
        }

        public LlvmTypesNode(int index) {
            super(index);
        }

        public long executeLong(Frame frame) throws UnexpectedResultException {
            return LlvmTypesGen.expectLong(executeGeneric(frame));
        }

        protected final void executeLongVoid(Frame frame) {
            try {
                executeLong(frame);
            } catch (UnexpectedResultException e) {
            }
        }

        public BigInteger executeBigInteger(Frame frame) throws UnexpectedResultException {
            return LlvmTypesGen.expectBigInteger(executeGeneric(frame));
        }

        public boolean executeBoolean(Frame frame) throws UnexpectedResultException {
            return LlvmTypesGen.expectBoolean(executeGeneric(frame));
        }

        protected final void executeBooleanVoid(Frame frame) {
            try {
                executeBoolean(frame);
            } catch (UnexpectedResultException e) {
            }
        }

        public String executeString(Frame frame) throws UnexpectedResultException {
            return LlvmTypesGen.expectString(executeGeneric(frame));
        }

        public List<?> executeList(Frame frame) throws UnexpectedResultException {
            return LlvmTypesGen.expectList(executeGeneric(frame));
        }

        public LlvmFunction executeLlvmFunction(Frame frame) throws UnexpectedResultException {
            return LlvmTypesGen.expectLlvmFunction(executeGeneric(frame));
        }

        public LlvmBlockNode executeLlvmBlockNode(Frame frame) throws UnexpectedResultException {
            return LlvmTypesGen.expectLlvmBlockNode(executeGeneric(frame));
        }

        public LlvmNull executeLlvmNull(Frame frame) throws UnexpectedResultException {
            return LlvmTypesGen.expectLlvmNull(executeGeneric(frame));
        }

        public float executeFloat(Frame frame) throws UnexpectedResultException {
            return LlvmTypesGen.expectFloat(executeGeneric(frame));
        }

        protected final void executeFloatVoid(Frame frame) {
            try {
                executeFloat(frame);
            } catch (UnexpectedResultException e) {
            }
        }

        public double executeDouble(Frame frame) throws UnexpectedResultException {
            return LlvmTypesGen.expectDouble(executeGeneric(frame));
        }

        protected final void executeDoubleVoid(Frame frame) {
            try {
                executeDouble(frame);
            } catch (UnexpectedResultException e) {
            }
        }

        public int[] executeIntArray(Frame frame) throws UnexpectedResultException {
            return LlvmTypesGen.expectIntArray(executeGeneric(frame));
        }

        public boolean[] executeBooleanArray(Frame frame) throws UnexpectedResultException {
            return LlvmTypesGen.expectBooleanArray(executeGeneric(frame));
        }

        public float[] executeFloatArray(Frame frame) throws UnexpectedResultException {
            return LlvmTypesGen.expectFloatArray(executeGeneric(frame));
        }

        public double[] executeDoubleArray(Frame frame) throws UnexpectedResultException {
            return LlvmTypesGen.expectDoubleArray(executeGeneric(frame));
        }

        public abstract Object executeGeneric(Frame frame);

        public void executeVoid(Frame frame) {
            executeGeneric(frame);
            return;
        }

    }
}
