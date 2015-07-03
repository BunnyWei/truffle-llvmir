/*
 * Copyright (c) 2012, 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
// CheckStyle: start generated
package com.oracle.truffle.sl.nodes;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.internal.SpecializationNode;
import com.oracle.truffle.api.frame.Frame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.sl.runtime.SLFunction;
import com.oracle.truffle.sl.runtime.SLNull;
import java.math.BigInteger;

@GeneratedBy(SLTypes.class)
public final class SLTypesGen extends SLTypes {

    @Deprecated public static final SLTypesGen SLTYPES = new SLTypesGen();

    protected SLTypesGen() {
    }

    public static boolean isLong(Object value) {
        return value instanceof Long;
    }

    public static long asLong(Object value) {
        assert value instanceof Long : "SLTypesGen.asLong: Long expected";
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
        assert value instanceof BigInteger : "SLTypesGen.asBigInteger: BigInteger expected";
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
        assert value instanceof Boolean : "SLTypesGen.asBoolean: Boolean expected";
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
        assert value instanceof String : "SLTypesGen.asString: String expected";
        return (String) value;
    }

    public static String expectString(Object value) throws UnexpectedResultException {
        if (value instanceof String) {
            return (String) value;
        }
        throw new UnexpectedResultException(value);
    }

    public static boolean isSLFunction(Object value) {
        return value instanceof SLFunction;
    }

    public static SLFunction asSLFunction(Object value) {
        assert value instanceof SLFunction : "SLTypesGen.asSLFunction: SLFunction expected";
        return (SLFunction) value;
    }

    public static SLFunction expectSLFunction(Object value) throws UnexpectedResultException {
        if (value instanceof SLFunction) {
            return (SLFunction) value;
        }
        throw new UnexpectedResultException(value);
    }

    public static SLNull expectSLNull(Object value) throws UnexpectedResultException {
        if (SLTypes.isSLNull(value)) {
            return SLTypes.asSLNull(value);
        }
        throw new UnexpectedResultException(value);
    }

    @GeneratedBy(SLTypes.class)
    public abstract static class SLTypesNode extends SpecializationNode {

        public SLTypesNode() {
            super();
        }

        public SLTypesNode(int index) {
            super(index);
        }

        public long executeLong(Frame frame) throws UnexpectedResultException {
            return SLTypesGen.expectLong(executeGeneric(frame));
        }

        protected final void executeLongVoid(Frame frame) {
            try {
                executeLong(frame);
            } catch (UnexpectedResultException e) {
            }
        }

        public BigInteger executeBigInteger(Frame frame) throws UnexpectedResultException {
            return SLTypesGen.expectBigInteger(executeGeneric(frame));
        }

        public boolean executeBoolean(Frame frame) throws UnexpectedResultException {
            return SLTypesGen.expectBoolean(executeGeneric(frame));
        }

        protected final void executeBooleanVoid(Frame frame) {
            try {
                executeBoolean(frame);
            } catch (UnexpectedResultException e) {
            }
        }

        public String executeString(Frame frame) throws UnexpectedResultException {
            return SLTypesGen.expectString(executeGeneric(frame));
        }

        public SLFunction executeSLFunction(Frame frame) throws UnexpectedResultException {
            return SLTypesGen.expectSLFunction(executeGeneric(frame));
        }

        public SLNull executeSLNull(Frame frame) throws UnexpectedResultException {
            return SLTypesGen.expectSLNull(executeGeneric(frame));
        }

        public abstract Object executeGeneric(Frame frame);

        public void executeVoid(Frame frame) {
            executeGeneric(frame);
            return;
        }

    }
}
