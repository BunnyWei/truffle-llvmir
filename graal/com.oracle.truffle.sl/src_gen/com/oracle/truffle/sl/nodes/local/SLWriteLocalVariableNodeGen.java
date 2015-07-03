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
package com.oracle.truffle.sl.nodes.local;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.internal.SpecializationNode;
import com.oracle.truffle.api.dsl.internal.SpecializedNode;
import com.oracle.truffle.api.frame.Frame;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.source.SourceSection;
import com.oracle.truffle.sl.nodes.SLExpressionNode;
import com.oracle.truffle.sl.nodes.SLTypesGen;
import com.oracle.truffle.sl.nodes.SLTypesGen.SLTypesNode;

@GeneratedBy(SLWriteLocalVariableNode.class)
public final class SLWriteLocalVariableNodeGen extends SLWriteLocalVariableNode implements SpecializedNode {

    private final FrameSlot slot;
    @Child private SLExpressionNode valueNode_;
    @CompilationFinal private Class<?> valueNodeType_;
    @CompilationFinal private boolean excludeWriteLong_;
    @CompilationFinal private boolean excludeWriteBoolean_;
    @Child private BaseNode_ specialization_;

    private SLWriteLocalVariableNodeGen(SourceSection src, SLExpressionNode valueNode, FrameSlot slot) {
        super(src);
        this.slot = slot;
        this.valueNode_ = valueNode;
        this.specialization_ = UninitializedNode_.create(this);
    }

    @Override
    protected FrameSlot getSlot() {
        return this.slot;
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
    public long executeLong(VirtualFrame frameValue) throws UnexpectedResultException {
        return specialization_.executeLong(frameValue);
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

    public static SLWriteLocalVariableNode create(SourceSection src, SLExpressionNode valueNode, FrameSlot slot) {
        return new SLWriteLocalVariableNodeGen(src, valueNode, slot);
    }

    @GeneratedBy(SLWriteLocalVariableNode.class)
    private abstract static class BaseNode_ extends SLTypesNode {

        protected final SLWriteLocalVariableNodeGen root;

        BaseNode_(SLWriteLocalVariableNodeGen root, int index) {
            super(index);
            this.root = root;
        }

        @Override
        protected final Node[] getSuppliedChildren() {
            return new Node[] {root.valueNode_};
        }

        @Override
        public Object executeGeneric(Frame frameValue) {
            Object valueNodeValue_ = executeValueNode_(frameValue);
            return acceptAndExecute(frameValue, valueNodeValue_);
        }

        protected final Object executeValueNode_(Frame frameValue) {
            Class<?> valueNodeType_ = root.valueNodeType_;
            try {
                if (valueNodeType_ == long.class) {
                    return root.valueNode_.executeLong((VirtualFrame) frameValue);
                } else if (valueNodeType_ == boolean.class) {
                    return root.valueNode_.executeBoolean((VirtualFrame) frameValue);
                } else if (valueNodeType_ == null) {
                    CompilerDirectives.transferToInterpreterAndInvalidate();
                    Object _value = root.valueNode_.executeGeneric((VirtualFrame) frameValue);
                    if (_value instanceof Long) {
                        root.valueNodeType_ = long.class;
                    } else if (_value instanceof Boolean) {
                        root.valueNodeType_ = boolean.class;
                    } else {
                        root.valueNodeType_ = Object.class;
                    }
                    return _value;
                } else {
                    return root.valueNode_.executeGeneric((VirtualFrame) frameValue);
                }
            } catch (UnexpectedResultException ex) {
                root.valueNodeType_ = Object.class;
                return ex.getResult();
            }
        }

        @Override
        protected final SpecializationNode createNext(Frame frameValue, Object valueNodeValue) {
            if (valueNodeValue instanceof Long) {
                if ((root.isLongKind((VirtualFrame) frameValue))) {
                    if (!root.excludeWriteLong_) {
                        CompilerDirectives.transferToInterpreterAndInvalidate();
                        return WriteLongNode_.create(root);
                    }
                }
            }
            if (valueNodeValue instanceof Boolean) {
                if ((root.isBooleanKind((VirtualFrame) frameValue))) {
                    if (!root.excludeWriteBoolean_) {
                        CompilerDirectives.transferToInterpreterAndInvalidate();
                        return WriteBooleanNode_.create(root);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            root.excludeWriteLong_ = true;
            root.excludeWriteBoolean_ = true;
            return WriteNode_.create(root);
        }

        @Override
        protected final SpecializationNode createPolymorphic() {
            return PolymorphicNode_.create(root);
        }

    }
    @GeneratedBy(SLWriteLocalVariableNode.class)
    private static final class UninitializedNode_ extends BaseNode_ {

        UninitializedNode_(SLWriteLocalVariableNodeGen root) {
            super(root, 2147483647);
        }

        @Override
        public Object acceptAndExecute(Frame frameValue, Object valueNodeValue) {
            return uninitialized(frameValue, valueNodeValue);
        }

        static BaseNode_ create(SLWriteLocalVariableNodeGen root) {
            return new UninitializedNode_(root);
        }

    }
    @GeneratedBy(SLWriteLocalVariableNode.class)
    private static final class PolymorphicNode_ extends BaseNode_ {

        PolymorphicNode_(SLWriteLocalVariableNodeGen root) {
            super(root, 0);
        }

        @Override
        public SpecializationNode merge(SpecializationNode newNode) {
            return polymorphicMerge(newNode);
        }

        @Override
        public Object acceptAndExecute(Frame frameValue, Object valueNodeValue) {
            return next.acceptAndExecute(frameValue, valueNodeValue);
        }

        static BaseNode_ create(SLWriteLocalVariableNodeGen root) {
            return new PolymorphicNode_(root);
        }

    }
    @GeneratedBy(methodName = "writeLong(VirtualFrame, long)", value = SLWriteLocalVariableNode.class)
    private static final class WriteLongNode_ extends BaseNode_ {

        WriteLongNode_(SLWriteLocalVariableNodeGen root) {
            super(root, 1);
        }

        @Override
        public SpecializationNode merge(SpecializationNode newNode) {
            if (newNode.getClass() == WriteNode_.class) {
                removeSame("Contained by write(VirtualFrame, Object)");
            }
            return super.merge(newNode);
        }

        @Override
        public Object acceptAndExecute(Frame frameValue, Object valueNodeValue) {
            if (valueNodeValue instanceof Long) {
                long valueNodeValue_ = (long) valueNodeValue;
                if ((root.isLongKind((VirtualFrame) frameValue))) {
                    return root.writeLong((VirtualFrame) frameValue, valueNodeValue_);
                }
            }
            return next.acceptAndExecute(frameValue, valueNodeValue);
        }

        @Override
        public long executeLong(Frame frameValue) throws UnexpectedResultException {
            long valueNodeValue_;
            try {
                valueNodeValue_ = root.valueNode_.executeLong((VirtualFrame) frameValue);
            } catch (UnexpectedResultException ex) {
                return SLTypesGen.expectLong(next.acceptAndExecute(frameValue, ex.getResult()));
            }
            if ((root.isLongKind((VirtualFrame) frameValue))) {
                return root.writeLong((VirtualFrame) frameValue, valueNodeValue_);
            }
            return SLTypesGen.expectLong(next.acceptAndExecute(frameValue, valueNodeValue_));
        }

        @Override
        public Object executeGeneric(Frame frameValue) {
            try {
                return executeLong(frameValue);
            } catch (UnexpectedResultException ex) {
                return ex.getResult();
            }
        }

        @Override
        public void executeVoid(Frame frameValue) {
            executeLongVoid(frameValue);
        }

        static BaseNode_ create(SLWriteLocalVariableNodeGen root) {
            return new WriteLongNode_(root);
        }

    }
    @GeneratedBy(methodName = "writeBoolean(VirtualFrame, boolean)", value = SLWriteLocalVariableNode.class)
    private static final class WriteBooleanNode_ extends BaseNode_ {

        WriteBooleanNode_(SLWriteLocalVariableNodeGen root) {
            super(root, 2);
        }

        @Override
        public SpecializationNode merge(SpecializationNode newNode) {
            if (newNode.getClass() == WriteNode_.class) {
                removeSame("Contained by write(VirtualFrame, Object)");
            }
            return super.merge(newNode);
        }

        @Override
        public Object acceptAndExecute(Frame frameValue, Object valueNodeValue) {
            if (valueNodeValue instanceof Boolean) {
                boolean valueNodeValue_ = (boolean) valueNodeValue;
                if ((root.isBooleanKind((VirtualFrame) frameValue))) {
                    return root.writeBoolean((VirtualFrame) frameValue, valueNodeValue_);
                }
            }
            return next.acceptAndExecute(frameValue, valueNodeValue);
        }

        @Override
        public boolean executeBoolean(Frame frameValue) throws UnexpectedResultException {
            boolean valueNodeValue_;
            try {
                valueNodeValue_ = root.valueNode_.executeBoolean((VirtualFrame) frameValue);
            } catch (UnexpectedResultException ex) {
                return SLTypesGen.expectBoolean(next.acceptAndExecute(frameValue, ex.getResult()));
            }
            if ((root.isBooleanKind((VirtualFrame) frameValue))) {
                return root.writeBoolean((VirtualFrame) frameValue, valueNodeValue_);
            }
            return SLTypesGen.expectBoolean(next.acceptAndExecute(frameValue, valueNodeValue_));
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

        static BaseNode_ create(SLWriteLocalVariableNodeGen root) {
            return new WriteBooleanNode_(root);
        }

    }
    @GeneratedBy(methodName = "write(VirtualFrame, Object)", value = SLWriteLocalVariableNode.class)
    private static final class WriteNode_ extends BaseNode_ {

        WriteNode_(SLWriteLocalVariableNodeGen root) {
            super(root, 3);
        }

        @Override
        public Object acceptAndExecute(Frame frameValue, Object valueNodeValue) {
            return root.write((VirtualFrame) frameValue, valueNodeValue);
        }

        static BaseNode_ create(SLWriteLocalVariableNodeGen root) {
            return new WriteNode_(root);
        }

    }
}
