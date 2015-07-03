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
package com.oracle.truffle.sl.nodes.expression;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.internal.SpecializationNode;
import com.oracle.truffle.api.dsl.internal.SpecializedNode;
import com.oracle.truffle.api.frame.Frame;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.source.SourceSection;
import com.oracle.truffle.sl.nodes.SLExpressionNode;
import com.oracle.truffle.sl.nodes.SLTypes;
import com.oracle.truffle.sl.nodes.SLTypesGen;
import com.oracle.truffle.sl.nodes.SLTypesGen.SLTypesNode;
import java.math.BigInteger;

@GeneratedBy(SLLessOrEqualNode.class)
public final class SLLessOrEqualNodeGen extends SLLessOrEqualNode implements SpecializedNode {

    @Child private SLExpressionNode leftNode_;
    @Child private SLExpressionNode rightNode_;
    @CompilationFinal private Class<?> leftNodeType_;
    @CompilationFinal private Class<?> rightNodeType_;
    @Child private BaseNode_ specialization_;

    private SLLessOrEqualNodeGen(SourceSection src, SLExpressionNode leftNode, SLExpressionNode rightNode) {
        super(src);
        this.leftNode_ = leftNode;
        this.rightNode_ = rightNode;
        this.specialization_ = UninitializedNode_.create(this);
    }

    @Override
    public boolean executeBoolean(VirtualFrame frameValue) throws UnexpectedResultException {
        return specialization_.executeBoolean(frameValue);
    }

    @Override
    public Object executeGeneric(VirtualFrame frameValue) {
        return specialization_.executeGeneric(frameValue);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        specialization_.executeVoid(frameValue);
        return;
    }

    @Override
    public NodeCost getCost() {
        return specialization_.getNodeCost();
    }

    @Override
    public SpecializationNode getSpecializationNode() {
        return specialization_;
    }

    @Override
    public Node deepCopy() {
        return SpecializationNode.updateRoot(super.deepCopy());
    }

    public static SLLessOrEqualNode create(SourceSection src, SLExpressionNode leftNode, SLExpressionNode rightNode) {
        return new SLLessOrEqualNodeGen(src, leftNode, rightNode);
    }

    @GeneratedBy(SLLessOrEqualNode.class)
    private abstract static class BaseNode_ extends SLTypesNode {

        protected final SLLessOrEqualNodeGen root;

        BaseNode_(SLLessOrEqualNodeGen root, int index) {
            super(index);
            this.root = root;
        }

        @Override
        protected final Node[] getSuppliedChildren() {
            return new Node[] {root.leftNode_, root.rightNode_};
        }

        @Override
        public Object executeGeneric(Frame frameValue) {
            Object leftNodeValue_ = executeLeftNode_(frameValue);
            Object rightNodeValue_ = executeRightNode_(frameValue);
            return acceptAndExecute(frameValue, leftNodeValue_, rightNodeValue_);
        }

        protected final Object executeLeftNode_(Frame frameValue) {
            Class<?> leftNodeType_ = root.leftNodeType_;
            try {
                if (leftNodeType_ == long.class) {
                    return root.leftNode_.executeLong((VirtualFrame) frameValue);
                } else if (leftNodeType_ == null) {
                    CompilerDirectives.transferToInterpreterAndInvalidate();
                    Object _value = root.leftNode_.executeGeneric((VirtualFrame) frameValue);
                    if (_value instanceof Long) {
                        root.leftNodeType_ = long.class;
                    } else {
                        root.leftNodeType_ = Object.class;
                    }
                    return _value;
                } else {
                    return root.leftNode_.executeGeneric((VirtualFrame) frameValue);
                }
            } catch (UnexpectedResultException ex) {
                root.leftNodeType_ = Object.class;
                return ex.getResult();
            }
        }

        protected final Object executeRightNode_(Frame frameValue) {
            Class<?> rightNodeType_ = root.rightNodeType_;
            try {
                if (rightNodeType_ == long.class) {
                    return root.rightNode_.executeLong((VirtualFrame) frameValue);
                } else if (rightNodeType_ == null) {
                    CompilerDirectives.transferToInterpreterAndInvalidate();
                    Object _value = root.rightNode_.executeGeneric((VirtualFrame) frameValue);
                    if (_value instanceof Long) {
                        root.rightNodeType_ = long.class;
                    } else {
                        root.rightNodeType_ = Object.class;
                    }
                    return _value;
                } else {
                    return root.rightNode_.executeGeneric((VirtualFrame) frameValue);
                }
            } catch (UnexpectedResultException ex) {
                root.rightNodeType_ = Object.class;
                return ex.getResult();
            }
        }

        @Override
        protected final SpecializationNode createNext(Frame frameValue, Object leftNodeValue, Object rightNodeValue) {
            if (leftNodeValue instanceof Long && rightNodeValue instanceof Long) {
                return LessOrEqual0Node_.create(root);
            }
            if (SLTypesGen.isImplicitBigInteger(leftNodeValue) && SLTypesGen.isImplicitBigInteger(rightNodeValue)) {
                return LessOrEqual1Node_.create(root, leftNodeValue, rightNodeValue);
            }
            return null;
        }

        @Override
        protected final SpecializationNode createPolymorphic() {
            return PolymorphicNode_.create(root);
        }

    }
    @GeneratedBy(SLLessOrEqualNode.class)
    private static final class UninitializedNode_ extends BaseNode_ {

        UninitializedNode_(SLLessOrEqualNodeGen root) {
            super(root, 2147483647);
        }

        @Override
        public Object acceptAndExecute(Frame frameValue, Object leftNodeValue, Object rightNodeValue) {
            return uninitialized(frameValue, leftNodeValue, rightNodeValue);
        }

        static BaseNode_ create(SLLessOrEqualNodeGen root) {
            return new UninitializedNode_(root);
        }

    }
    @GeneratedBy(SLLessOrEqualNode.class)
    private static final class PolymorphicNode_ extends BaseNode_ {

        PolymorphicNode_(SLLessOrEqualNodeGen root) {
            super(root, 0);
        }

        @Override
        public SpecializationNode merge(SpecializationNode newNode) {
            return polymorphicMerge(newNode);
        }

        @Override
        public Object acceptAndExecute(Frame frameValue, Object leftNodeValue, Object rightNodeValue) {
            return next.acceptAndExecute(frameValue, leftNodeValue, rightNodeValue);
        }

        static BaseNode_ create(SLLessOrEqualNodeGen root) {
            return new PolymorphicNode_(root);
        }

    }
    @GeneratedBy(methodName = "lessOrEqual(long, long)", value = SLLessOrEqualNode.class)
    private static final class LessOrEqual0Node_ extends BaseNode_ {

        LessOrEqual0Node_(SLLessOrEqualNodeGen root) {
            super(root, 1);
        }

        @Override
        public Object acceptAndExecute(Frame frameValue, Object leftNodeValue, Object rightNodeValue) {
            if (leftNodeValue instanceof Long && rightNodeValue instanceof Long) {
                long leftNodeValue_ = (long) leftNodeValue;
                long rightNodeValue_ = (long) rightNodeValue;
                return root.lessOrEqual(leftNodeValue_, rightNodeValue_);
            }
            return next.acceptAndExecute(frameValue, leftNodeValue, rightNodeValue);
        }

        @Override
        public boolean executeBoolean(Frame frameValue) throws UnexpectedResultException {
            long leftNodeValue_;
            try {
                leftNodeValue_ = root.leftNode_.executeLong((VirtualFrame) frameValue);
            } catch (UnexpectedResultException ex) {
                Object rightNodeValue = executeRightNode_(frameValue);
                return SLTypesGen.expectBoolean(next.acceptAndExecute(frameValue, ex.getResult(), rightNodeValue));
            }
            long rightNodeValue_;
            try {
                rightNodeValue_ = root.rightNode_.executeLong((VirtualFrame) frameValue);
            } catch (UnexpectedResultException ex) {
                return SLTypesGen.expectBoolean(next.acceptAndExecute(frameValue, leftNodeValue_, ex.getResult()));
            }
            return root.lessOrEqual(leftNodeValue_, rightNodeValue_);
        }

        @Override
        public Object executeGeneric(Frame frameValue) {
            try {
                return executeBoolean(frameValue);
            } catch (UnexpectedResultException ex) {
                return ex.getResult();
            }
        }

        @Override
        public void executeVoid(Frame frameValue) {
            executeBooleanVoid(frameValue);
        }

        static BaseNode_ create(SLLessOrEqualNodeGen root) {
            return new LessOrEqual0Node_(root);
        }

    }
    @GeneratedBy(methodName = "lessOrEqual(BigInteger, BigInteger)", value = SLLessOrEqualNode.class)
    private static final class LessOrEqual1Node_ extends BaseNode_ {

        private final Class<?> leftNodeImplicitType;
        private final Class<?> rightNodeImplicitType;

        LessOrEqual1Node_(SLLessOrEqualNodeGen root, Object leftNodeValue, Object rightNodeValue) {
            super(root, 2);
            this.leftNodeImplicitType = SLTypesGen.getImplicitBigIntegerClass(leftNodeValue);
            this.rightNodeImplicitType = SLTypesGen.getImplicitBigIntegerClass(rightNodeValue);
        }

        @Override
        public boolean isSame(SpecializationNode other) {
            return super.isSame(other) && this.leftNodeImplicitType == ((LessOrEqual1Node_) other).leftNodeImplicitType && this.rightNodeImplicitType == ((LessOrEqual1Node_) other).rightNodeImplicitType;
        }

        @Override
        public Object acceptAndExecute(Frame frameValue, Object leftNodeValue, Object rightNodeValue) {
            if (SLTypesGen.isImplicitBigInteger(leftNodeValue, leftNodeImplicitType) && SLTypesGen.isImplicitBigInteger(rightNodeValue, rightNodeImplicitType)) {
                BigInteger leftNodeValue_ = SLTypesGen.asImplicitBigInteger(leftNodeValue, leftNodeImplicitType);
                BigInteger rightNodeValue_ = SLTypesGen.asImplicitBigInteger(rightNodeValue, rightNodeImplicitType);
                return root.lessOrEqual(leftNodeValue_, rightNodeValue_);
            }
            return next.acceptAndExecute(frameValue, leftNodeValue, rightNodeValue);
        }

        @Override
        public boolean executeBoolean(Frame frameValue) throws UnexpectedResultException {
            BigInteger leftNodeValue_;
            try {
                if (leftNodeImplicitType == Long.class) {
                    leftNodeValue_ = SLTypes.castBigInteger(root.leftNode_.executeLong((VirtualFrame) frameValue));
                } else {
                    Object leftNodeValue__ = executeLeftNode_(frameValue);
                    leftNodeValue_ = SLTypesGen.expectImplicitBigInteger(leftNodeValue__, leftNodeImplicitType);
                }
            } catch (UnexpectedResultException ex) {
                Object rightNodeValue = executeRightNode_(frameValue);
                return SLTypesGen.expectBoolean(next.acceptAndExecute(frameValue, ex.getResult(), rightNodeValue));
            }
            BigInteger rightNodeValue_;
            try {
                if (rightNodeImplicitType == Long.class) {
                    rightNodeValue_ = SLTypes.castBigInteger(root.rightNode_.executeLong((VirtualFrame) frameValue));
                } else {
                    Object rightNodeValue__ = executeRightNode_(frameValue);
                    rightNodeValue_ = SLTypesGen.expectImplicitBigInteger(rightNodeValue__, rightNodeImplicitType);
                }
            } catch (UnexpectedResultException ex) {
                return SLTypesGen.expectBoolean(next.acceptAndExecute(frameValue, leftNodeValue_, ex.getResult()));
            }
            return root.lessOrEqual(leftNodeValue_, rightNodeValue_);
        }

        @Override
        public Object executeGeneric(Frame frameValue) {
            try {
                return executeBoolean(frameValue);
            } catch (UnexpectedResultException ex) {
                return ex.getResult();
            }
        }

        @Override
        public void executeVoid(Frame frameValue) {
            executeBooleanVoid(frameValue);
        }

        static BaseNode_ create(SLLessOrEqualNodeGen root, Object leftNodeValue, Object rightNodeValue) {
            return new LessOrEqual1Node_(root, leftNodeValue, rightNodeValue);
        }

    }
}
