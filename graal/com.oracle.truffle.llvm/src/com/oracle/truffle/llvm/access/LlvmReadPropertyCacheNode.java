/*
 * Copyright (c) 2013, 2014, Oracle and/or its affiliates. All rights reserved.
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
package com.oracle.truffle.llvm.access;

import com.oracle.truffle.api.*;

import com.oracle.truffle.api.nodes.*;
import com.oracle.truffle.api.object.*;
import com.oracle.truffle.llvm.nodes.*;
import com.oracle.truffle.llvm.runtime.*;

/**
 * The node for accessing a property of an object. When executed, this node first evaluates the
 * object expression on the left side of the dot operator and then reads the named property.
 */
public abstract class LlvmReadPropertyCacheNode extends Node {

    public static LlvmReadPropertyCacheNode create(String propertyName) {
        return new LlvmUninitializedReadObjectPropertyNode(propertyName);
    }

    public abstract Object executeObject(DynamicObject receiver);

    public abstract long executeLong(DynamicObject receiver) throws UnexpectedResultException;

    protected abstract static class LlvmReadPropertyCacheChainNode extends LlvmReadPropertyCacheNode {
        protected final Shape shape;
        @Child protected LlvmReadPropertyCacheNode next;

        public LlvmReadPropertyCacheChainNode(Shape shape, LlvmReadPropertyCacheNode next) {
            this.shape = shape;
            this.next = next;
        }

        @Override
        public final Object executeObject(DynamicObject receiver) {
            try {
                // if this assumption fails, the object needs to be updated to a valid shape
                shape.getValidAssumption().check();
            } catch (InvalidAssumptionException e) {
                return this.replace(next).executeObject(receiver);
            }

            boolean condition = shape.check(receiver);

            if (condition) {
                return executeObjectUnchecked(receiver, condition);
            } else {
                return next.executeObject(receiver);
            }
        }

        @Override
        public final long executeLong(DynamicObject receiver) throws UnexpectedResultException {
            try {
                // if this assumption fails, the object needs to be updated to a valid shape
                shape.getValidAssumption().check();
            } catch (InvalidAssumptionException e) {
                return this.replace(next).executeLong(receiver);
            }

            boolean condition = shape.check(receiver);

            if (condition) {
                return executeLongUnchecked(receiver, condition);
            } else {
                return next.executeLong(receiver);
            }
        }

        protected abstract Object executeObjectUnchecked(DynamicObject receiver, boolean condition);

        protected long executeLongUnchecked(DynamicObject receiver, boolean condition) throws UnexpectedResultException {
            return LlvmTypesGen.expectLong(executeObjectUnchecked(receiver, condition));
        }
    }

    protected static class LlvmReadObjectPropertyNode extends LlvmReadPropertyCacheChainNode {
        private final Location location;

        protected LlvmReadObjectPropertyNode(Shape shape, Location location, LlvmReadPropertyCacheNode next) {
            super(shape, next);
            this.location = location;
        }

        @Override
        protected Object executeObjectUnchecked(DynamicObject receiver, boolean condition) {
            return location.get(receiver, condition);
        }
    }

    protected static class LlvmReadBooleanPropertyNode extends LlvmReadPropertyCacheChainNode {
        private final BooleanLocation location;

        protected LlvmReadBooleanPropertyNode(Shape shape, BooleanLocation location, LlvmReadPropertyCacheNode next) {
            super(shape, next);
            this.location = location;
        }

        @Override
        protected Object executeObjectUnchecked(DynamicObject receiver, boolean condition) {
            return location.getBoolean(receiver, condition);
        }
    }

    protected static class LlvmReadLongPropertyNode extends LlvmReadPropertyCacheChainNode {
        private final LongLocation location;

        protected LlvmReadLongPropertyNode(Shape shape, LongLocation location, LlvmReadPropertyCacheNode next) {
            super(shape, next);
            this.location = location;
        }

        @Override
        protected Object executeObjectUnchecked(DynamicObject receiver, boolean condition) {
            return location.getLong(receiver, condition);
        }

        @Override
        protected long executeLongUnchecked(DynamicObject receiver, boolean condition) throws UnexpectedResultException {
            return location.getLong(receiver, condition);
        }
    }

    protected static class LlvmReadMissingPropertyNode extends LlvmReadPropertyCacheChainNode {
        protected LlvmReadMissingPropertyNode(Shape shape, LlvmReadPropertyCacheNode next) {
            super(shape, next);
        }

        @Override
        protected Object executeObjectUnchecked(DynamicObject receiver, boolean condition) {
            // The property was not found in the object, return null
            return LlvmNull.SINGLETON;
        }
    }

    protected static class LlvmUninitializedReadObjectPropertyNode extends LlvmReadPropertyCacheNode {
        protected final String propertyName;

        protected LlvmUninitializedReadObjectPropertyNode(String propertyName) {
            this.propertyName = propertyName;
        }

        @Override
        public Object executeObject(DynamicObject receiver) {
            CompilerDirectives.transferToInterpreterAndInvalidate();

            receiver.updateShape();

            Shape shape = receiver.getShape();
            Property property = shape.getProperty(propertyName);

            final LlvmReadPropertyCacheNode resolvedNode;
            if (property == null) {
                resolvedNode = new LlvmReadMissingPropertyNode(shape, this);
            } else if (property.getLocation() instanceof LongLocation) {
                resolvedNode = new LlvmReadLongPropertyNode(shape, (LongLocation) property.getLocation(), this);
            } else if (property.getLocation() instanceof BooleanLocation) {
                resolvedNode = new LlvmReadBooleanPropertyNode(shape, (BooleanLocation) property.getLocation(), this);
            } else {
                resolvedNode = new LlvmReadObjectPropertyNode(shape, property.getLocation(), this);
            }

            return this.replace(resolvedNode, "resolved '" + propertyName + "'").executeObject(receiver);
        }

        @Override
        public long executeLong(DynamicObject receiver) throws UnexpectedResultException {
            return LlvmTypesGen.expectLong(executeObject(receiver));
        }
    }
}
