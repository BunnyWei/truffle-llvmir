/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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
package com.oracle.truffle.sl.builtins;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.NodeFactory;
import com.oracle.truffle.api.dsl.internal.NodeFactoryBase;
import com.oracle.truffle.api.dsl.internal.SpecializationNode;
import com.oracle.truffle.api.dsl.internal.SpecializedNode;
import com.oracle.truffle.api.frame.Frame;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.sl.nodes.SLExpressionNode;
import com.oracle.truffle.sl.nodes.SLTypes;
import com.oracle.truffle.sl.nodes.SLTypesGen;
import com.oracle.truffle.sl.nodes.SLTypesGen.SLTypesNode;
import com.oracle.truffle.sl.runtime.SLContext;
import com.oracle.truffle.sl.runtime.SLNull;

@GeneratedBy(SLAssertTrueBuiltin.class)
public final class SLAssertTrueBuiltinFactory extends NodeFactoryBase<SLAssertTrueBuiltin> {

    private static SLAssertTrueBuiltinFactory instance;

    private SLAssertTrueBuiltinFactory() {
        super(SLAssertTrueBuiltin.class, new Class<?>[] {SLExpressionNode.class, SLExpressionNode.class}, new Class<?>[][] {new Class<?>[] {SLExpressionNode[].class, SLContext.class}});
    }

    @Override
    public SLAssertTrueBuiltin createNode(Object... arguments) {
        if (arguments.length == 2 && (arguments[0] == null || arguments[0] instanceof SLExpressionNode[]) && (arguments[1] == null || arguments[1] instanceof SLContext)) {
            return create((SLExpressionNode[]) arguments[0], (SLContext) arguments[1]);
        } else {
            throw new IllegalArgumentException("Invalid create signature.");
        }
    }

    public static NodeFactory<SLAssertTrueBuiltin> getInstance() {
        if (instance == null) {
            instance = new SLAssertTrueBuiltinFactory();
        }
        return instance;
    }

    public static SLAssertTrueBuiltin create(SLExpressionNode[] arguments, SLContext context) {
        return new SLAssertTrueBuiltinNodeGen(arguments, context);
    }

    @GeneratedBy(SLAssertTrueBuiltin.class)
    public static final class SLAssertTrueBuiltinNodeGen extends SLAssertTrueBuiltin implements SpecializedNode {

        private final SLContext context;
        @Child private SLExpressionNode arguments0_;
        @Child private SLExpressionNode arguments1_;
        @CompilationFinal private Class<?> arguments0Type_;
        @Child private BaseNode_ specialization_;

        private SLAssertTrueBuiltinNodeGen(SLExpressionNode[] arguments, SLContext context) {
            this.context = context;
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
            this.specialization_ = UninitializedNode_.create(this);
        }

        @Override
        public SLContext getContext() {
            return this.context;
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

        @GeneratedBy(SLAssertTrueBuiltin.class)
        private abstract static class BaseNode_ extends SLTypesNode {

            protected final SLAssertTrueBuiltinNodeGen root;

            BaseNode_(SLAssertTrueBuiltinNodeGen root, int index) {
                super(index);
                this.root = root;
            }

            @Override
            protected final Node[] getSuppliedChildren() {
                return new Node[] {root.arguments0_, root.arguments1_};
            }

            @Override
            public Object executeGeneric(Frame frameValue) {
                Object arguments0Value_ = executeArguments0_(frameValue);
                Object arguments1Value_ = root.arguments1_.executeGeneric((VirtualFrame) frameValue);
                return acceptAndExecute(frameValue, arguments0Value_, arguments1Value_);
            }

            protected final Object executeArguments0_(Frame frameValue) {
                Class<?> arguments0Type_ = root.arguments0Type_;
                try {
                    if (arguments0Type_ == boolean.class) {
                        return root.arguments0_.executeBoolean((VirtualFrame) frameValue);
                    } else if (arguments0Type_ == null) {
                        CompilerDirectives.transferToInterpreterAndInvalidate();
                        Object _value = root.arguments0_.executeGeneric((VirtualFrame) frameValue);
                        if (_value instanceof Boolean) {
                            root.arguments0Type_ = boolean.class;
                        } else {
                            root.arguments0Type_ = Object.class;
                        }
                        return _value;
                    } else {
                        return root.arguments0_.executeGeneric((VirtualFrame) frameValue);
                    }
                } catch (UnexpectedResultException ex) {
                    root.arguments0Type_ = Object.class;
                    return ex.getResult();
                }
            }

            @Override
            protected final SpecializationNode createNext(Frame frameValue, Object arguments0Value, Object arguments1Value) {
                if (arguments0Value instanceof Boolean) {
                    if (arguments1Value instanceof String) {
                        return AssertNode_.create(root);
                    }
                    if (SLTypes.isSLNull(arguments1Value)) {
                        return AssertNullNode_.create(root);
                    }
                }
                return null;
            }

            @Override
            protected final SpecializationNode createPolymorphic() {
                return PolymorphicNode_.create(root);
            }

        }
        @GeneratedBy(SLAssertTrueBuiltin.class)
        private static final class UninitializedNode_ extends BaseNode_ {

            UninitializedNode_(SLAssertTrueBuiltinNodeGen root) {
                super(root, 2147483647);
            }

            @Override
            public Object acceptAndExecute(Frame frameValue, Object arguments0Value, Object arguments1Value) {
                return uninitialized(frameValue, arguments0Value, arguments1Value);
            }

            static BaseNode_ create(SLAssertTrueBuiltinNodeGen root) {
                return new UninitializedNode_(root);
            }

        }
        @GeneratedBy(SLAssertTrueBuiltin.class)
        private static final class PolymorphicNode_ extends BaseNode_ {

            PolymorphicNode_(SLAssertTrueBuiltinNodeGen root) {
                super(root, 0);
            }

            @Override
            public SpecializationNode merge(SpecializationNode newNode) {
                return polymorphicMerge(newNode);
            }

            @Override
            public Object acceptAndExecute(Frame frameValue, Object arguments0Value, Object arguments1Value) {
                return next.acceptAndExecute(frameValue, arguments0Value, arguments1Value);
            }

            static BaseNode_ create(SLAssertTrueBuiltinNodeGen root) {
                return new PolymorphicNode_(root);
            }

        }
        @GeneratedBy(methodName = "doAssert(boolean, String)", value = SLAssertTrueBuiltin.class)
        private static final class AssertNode_ extends BaseNode_ {

            AssertNode_(SLAssertTrueBuiltinNodeGen root) {
                super(root, 1);
            }

            @Override
            public Object acceptAndExecute(Frame frameValue, Object arguments0Value, Object arguments1Value) {
                if (arguments0Value instanceof Boolean && arguments1Value instanceof String) {
                    boolean arguments0Value_ = (boolean) arguments0Value;
                    String arguments1Value_ = (String) arguments1Value;
                    return root.doAssert(arguments0Value_, arguments1Value_);
                }
                return next.acceptAndExecute(frameValue, arguments0Value, arguments1Value);
            }

            @Override
            public boolean executeBoolean(Frame frameValue) throws UnexpectedResultException {
                boolean arguments0Value_;
                try {
                    arguments0Value_ = root.arguments0_.executeBoolean((VirtualFrame) frameValue);
                } catch (UnexpectedResultException ex) {
                    Object arguments1Value = root.arguments1_.executeGeneric((VirtualFrame) frameValue);
                    return SLTypesGen.expectBoolean(next.acceptAndExecute(frameValue, ex.getResult(), arguments1Value));
                }
                String arguments1Value_;
                try {
                    arguments1Value_ = root.arguments1_.executeString((VirtualFrame) frameValue);
                } catch (UnexpectedResultException ex) {
                    return SLTypesGen.expectBoolean(next.acceptAndExecute(frameValue, arguments0Value_, ex.getResult()));
                }
                return root.doAssert(arguments0Value_, arguments1Value_);
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

            static BaseNode_ create(SLAssertTrueBuiltinNodeGen root) {
                return new AssertNode_(root);
            }

        }
        @GeneratedBy(methodName = "doAssertNull(boolean, SLNull)", value = SLAssertTrueBuiltin.class)
        private static final class AssertNullNode_ extends BaseNode_ {

            AssertNullNode_(SLAssertTrueBuiltinNodeGen root) {
                super(root, 2);
            }

            @Override
            public Object acceptAndExecute(Frame frameValue, Object arguments0Value, Object arguments1Value) {
                if (arguments0Value instanceof Boolean && SLTypes.isSLNull(arguments1Value)) {
                    boolean arguments0Value_ = (boolean) arguments0Value;
                    SLNull arguments1Value_ = SLTypes.asSLNull(arguments1Value);
                    return root.doAssertNull(arguments0Value_, arguments1Value_);
                }
                return next.acceptAndExecute(frameValue, arguments0Value, arguments1Value);
            }

            @Override
            public boolean executeBoolean(Frame frameValue) throws UnexpectedResultException {
                boolean arguments0Value_;
                try {
                    arguments0Value_ = root.arguments0_.executeBoolean((VirtualFrame) frameValue);
                } catch (UnexpectedResultException ex) {
                    Object arguments1Value = root.arguments1_.executeGeneric((VirtualFrame) frameValue);
                    return SLTypesGen.expectBoolean(next.acceptAndExecute(frameValue, ex.getResult(), arguments1Value));
                }
                SLNull arguments1Value_;
                try {
                    arguments1Value_ = root.arguments1_.executeNull((VirtualFrame) frameValue);
                } catch (UnexpectedResultException ex) {
                    return SLTypesGen.expectBoolean(next.acceptAndExecute(frameValue, arguments0Value_, ex.getResult()));
                }
                return root.doAssertNull(arguments0Value_, arguments1Value_);
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

            static BaseNode_ create(SLAssertTrueBuiltinNodeGen root) {
                return new AssertNullNode_(root);
            }

        }
    }
}
