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
import com.oracle.truffle.api.frame.FrameSlotTypeException;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.source.SourceSection;
import com.oracle.truffle.sl.nodes.SLTypesGen;
import com.oracle.truffle.sl.nodes.SLTypesGen.SLTypesNode;

@GeneratedBy(SLReadLocalVariableNode.class)
public final class SLReadLocalVariableNodeGen extends SLReadLocalVariableNode implements SpecializedNode {

    private final FrameSlot slot;
    @CompilationFinal private boolean excludeReadLong_;
    @CompilationFinal private boolean excludeReadBoolean_;
    @CompilationFinal private boolean excludeReadObject_;
    @Child private BaseNode_ specialization_;

    private SLReadLocalVariableNodeGen(SourceSection src, FrameSlot slot) {
        super(src);
        this.slot = slot;
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

    public static SLReadLocalVariableNode create(SourceSection src, FrameSlot slot) {
        return new SLReadLocalVariableNodeGen(src, slot);
    }

    @GeneratedBy(SLReadLocalVariableNode.class)
    private abstract static class BaseNode_ extends SLTypesNode {

        protected final SLReadLocalVariableNodeGen root;

        BaseNode_(SLReadLocalVariableNodeGen root, int index) {
            super(index);
            this.root = root;
        }

        @Override
        protected final Node[] getSuppliedChildren() {
            return new Node[] {};
        }

        @Override
        public Object executeGeneric(Frame frameValue) {
            return acceptAndExecute(frameValue);
        }

        @Override
        protected final SpecializationNode createNext(Frame frameValue) {
            if (!root.excludeReadLong_) {
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return ReadLongNode_.create(root);
            }
            if (!root.excludeReadBoolean_) {
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return ReadBooleanNode_.create(root);
            }
            if (!root.excludeReadObject_) {
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return ReadObjectNode_.create(root);
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            root.excludeReadLong_ = true;
            root.excludeReadBoolean_ = true;
            root.excludeReadObject_ = true;
            return ReadNode_.create(root);
        }

        @Override
        protected final SpecializationNode createPolymorphic() {
            return PolymorphicNode_.create(root);
        }

    }
    @GeneratedBy(SLReadLocalVariableNode.class)
    private static final class UninitializedNode_ extends BaseNode_ {

        UninitializedNode_(SLReadLocalVariableNodeGen root) {
            super(root, 2147483647);
        }

        @Override
        public Object acceptAndExecute(Frame frameValue) {
            return uninitialized(frameValue);
        }

        static BaseNode_ create(SLReadLocalVariableNodeGen root) {
            return new UninitializedNode_(root);
        }

    }
    @GeneratedBy(SLReadLocalVariableNode.class)
    private static final class PolymorphicNode_ extends BaseNode_ {

        PolymorphicNode_(SLReadLocalVariableNodeGen root) {
            super(root, 0);
        }

        @Override
        public SpecializationNode merge(SpecializationNode newNode) {
            return polymorphicMerge(newNode);
        }

        @Override
        public Object acceptAndExecute(Frame frameValue) {
            return next.acceptAndExecute(frameValue);
        }

        static BaseNode_ create(SLReadLocalVariableNodeGen root) {
            return new PolymorphicNode_(root);
        }

    }
    @GeneratedBy(methodName = "readLong(VirtualFrame)", value = SLReadLocalVariableNode.class)
    private static final class ReadLongNode_ extends BaseNode_ {

        ReadLongNode_(SLReadLocalVariableNodeGen root) {
            super(root, 1);
        }

        @Override
        public SpecializationNode merge(SpecializationNode newNode) {
            if (newNode.getClass() == ReadNode_.class) {
                removeSame("Contained by read(VirtualFrame)");
            }
            return super.merge(newNode);
        }

        @Override
        public Object acceptAndExecute(Frame frameValue) {
            try {
                return root.readLong((VirtualFrame) frameValue);
            } catch (FrameSlotTypeException ex) {
                root.excludeReadLong_ = true;
                return remove("threw rewrite exception", frameValue);
            }
        }

        @Override
        public long executeLong(Frame frameValue) throws UnexpectedResultException {
            try {
                return root.readLong((VirtualFrame) frameValue);
            } catch (FrameSlotTypeException ex) {
                root.excludeReadLong_ = true;
                return SLTypesGen.expectLong(remove("threw rewrite exception", frameValue));
            }
        }

        @Override
        public void executeVoid(Frame frameValue) {
            executeLongVoid(frameValue);
        }

        static BaseNode_ create(SLReadLocalVariableNodeGen root) {
            return new ReadLongNode_(root);
        }

    }
    @GeneratedBy(methodName = "readBoolean(VirtualFrame)", value = SLReadLocalVariableNode.class)
    private static final class ReadBooleanNode_ extends BaseNode_ {

        ReadBooleanNode_(SLReadLocalVariableNodeGen root) {
            super(root, 2);
        }

        @Override
        public SpecializationNode merge(SpecializationNode newNode) {
            if (newNode.getClass() == ReadNode_.class) {
                removeSame("Contained by read(VirtualFrame)");
            }
            return super.merge(newNode);
        }

        @Override
        public Object acceptAndExecute(Frame frameValue) {
            try {
                return root.readBoolean((VirtualFrame) frameValue);
            } catch (FrameSlotTypeException ex) {
                root.excludeReadBoolean_ = true;
                return remove("threw rewrite exception", frameValue);
            }
        }

        @Override
        public boolean executeBoolean(Frame frameValue) throws UnexpectedResultException {
            try {
                return root.readBoolean((VirtualFrame) frameValue);
            } catch (FrameSlotTypeException ex) {
                root.excludeReadBoolean_ = true;
                return SLTypesGen.expectBoolean(remove("threw rewrite exception", frameValue));
            }
        }

        @Override
        public void executeVoid(Frame frameValue) {
            executeBooleanVoid(frameValue);
        }

        static BaseNode_ create(SLReadLocalVariableNodeGen root) {
            return new ReadBooleanNode_(root);
        }

    }
    @GeneratedBy(methodName = "readObject(VirtualFrame)", value = SLReadLocalVariableNode.class)
    private static final class ReadObjectNode_ extends BaseNode_ {

        ReadObjectNode_(SLReadLocalVariableNodeGen root) {
            super(root, 3);
        }

        @Override
        public SpecializationNode merge(SpecializationNode newNode) {
            if (newNode.getClass() == ReadNode_.class) {
                removeSame("Contained by read(VirtualFrame)");
            }
            return super.merge(newNode);
        }

        @Override
        public Object acceptAndExecute(Frame frameValue) {
            try {
                return root.readObject((VirtualFrame) frameValue);
            } catch (FrameSlotTypeException ex) {
                root.excludeReadObject_ = true;
                return remove("threw rewrite exception", frameValue);
            }
        }

        static BaseNode_ create(SLReadLocalVariableNodeGen root) {
            return new ReadObjectNode_(root);
        }

    }
    @GeneratedBy(methodName = "read(VirtualFrame)", value = SLReadLocalVariableNode.class)
    private static final class ReadNode_ extends BaseNode_ {

        ReadNode_(SLReadLocalVariableNodeGen root) {
            super(root, 4);
        }

        @Override
        public Object acceptAndExecute(Frame frameValue) {
            return root.read((VirtualFrame) frameValue);
        }

        static BaseNode_ create(SLReadLocalVariableNodeGen root) {
            return new ReadNode_(root);
        }

    }
}
