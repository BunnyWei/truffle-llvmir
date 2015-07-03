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
import com.oracle.truffle.sl.nodes.SLTypesGen;
import com.oracle.truffle.sl.nodes.SLTypesGen.SLTypesNode;
import com.oracle.truffle.sl.runtime.SLContext;

@GeneratedBy(SLPrintlnBuiltin.class)
public final class SLPrintlnBuiltinFactory extends NodeFactoryBase<SLPrintlnBuiltin> {

    private static SLPrintlnBuiltinFactory instance;

    private SLPrintlnBuiltinFactory() {
        super(SLPrintlnBuiltin.class, new Class<?>[] {SLExpressionNode.class}, new Class<?>[][] {new Class<?>[] {SLExpressionNode[].class, SLContext.class}});
    }

    @Override
    public SLPrintlnBuiltin createNode(Object... arguments) {
        if (arguments.length == 2 && (arguments[0] == null || arguments[0] instanceof SLExpressionNode[]) && (arguments[1] == null || arguments[1] instanceof SLContext)) {
            return create((SLExpressionNode[]) arguments[0], (SLContext) arguments[1]);
        } else {
            throw new IllegalArgumentException("Invalid create signature.");
        }
    }

    public static NodeFactory<SLPrintlnBuiltin> getInstance() {
        if (instance == null) {
            instance = new SLPrintlnBuiltinFactory();
        }
        return instance;
    }

    public static SLPrintlnBuiltin create(SLExpressionNode[] arguments, SLContext context) {
        return new SLPrintlnBuiltinNodeGen(arguments, context);
    }

    @GeneratedBy(SLPrintlnBuiltin.class)
    public static final class SLPrintlnBuiltinNodeGen extends SLPrintlnBuiltin implements SpecializedNode {

        private final SLContext context;
        @Child private SLExpressionNode arguments0_;
        @CompilationFinal private Class<?> arguments0Type_;
        @Child private BaseNode_ specialization_;

        private SLPrintlnBuiltinNodeGen(SLExpressionNode[] arguments, SLContext context) {
            this.context = context;
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
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

        @GeneratedBy(SLPrintlnBuiltin.class)
        private abstract static class BaseNode_ extends SLTypesNode {

            protected final SLPrintlnBuiltinNodeGen root;

            BaseNode_(SLPrintlnBuiltinNodeGen root, int index) {
                super(index);
                this.root = root;
            }

            @Override
            protected final Node[] getSuppliedChildren() {
                return new Node[] {root.arguments0_};
            }

            @Override
            public Object executeGeneric(Frame frameValue) {
                Object arguments0Value_ = executeArguments0_(frameValue);
                return acceptAndExecute(frameValue, arguments0Value_);
            }

            protected final Object executeArguments0_(Frame frameValue) {
                Class<?> arguments0Type_ = root.arguments0Type_;
                try {
                    if (arguments0Type_ == long.class) {
                        return root.arguments0_.executeLong((VirtualFrame) frameValue);
                    } else if (arguments0Type_ == boolean.class) {
                        return root.arguments0_.executeBoolean((VirtualFrame) frameValue);
                    } else if (arguments0Type_ == null) {
                        CompilerDirectives.transferToInterpreterAndInvalidate();
                        Object _value = root.arguments0_.executeGeneric((VirtualFrame) frameValue);
                        if (_value instanceof Long) {
                            root.arguments0Type_ = long.class;
                        } else if (_value instanceof Boolean) {
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
            protected final SpecializationNode createNext(Frame frameValue, Object arguments0Value) {
                if (arguments0Value instanceof Long) {
                    return Println0Node_.create(root);
                }
                if (arguments0Value instanceof Boolean) {
                    return Println1Node_.create(root);
                }
                if (arguments0Value instanceof String) {
                    return Println2Node_.create(root);
                }
                return Println3Node_.create(root);
            }

            @Override
            protected final SpecializationNode createPolymorphic() {
                return PolymorphicNode_.create(root);
            }

        }
        @GeneratedBy(SLPrintlnBuiltin.class)
        private static final class UninitializedNode_ extends BaseNode_ {

            UninitializedNode_(SLPrintlnBuiltinNodeGen root) {
                super(root, 2147483647);
            }

            @Override
            public Object acceptAndExecute(Frame frameValue, Object arguments0Value) {
                return uninitialized(frameValue, arguments0Value);
            }

            static BaseNode_ create(SLPrintlnBuiltinNodeGen root) {
                return new UninitializedNode_(root);
            }

        }
        @GeneratedBy(SLPrintlnBuiltin.class)
        private static final class PolymorphicNode_ extends BaseNode_ {

            PolymorphicNode_(SLPrintlnBuiltinNodeGen root) {
                super(root, 0);
            }

            @Override
            public SpecializationNode merge(SpecializationNode newNode) {
                return polymorphicMerge(newNode);
            }

            @Override
            public Object acceptAndExecute(Frame frameValue, Object arguments0Value) {
                return next.acceptAndExecute(frameValue, arguments0Value);
            }

            static BaseNode_ create(SLPrintlnBuiltinNodeGen root) {
                return new PolymorphicNode_(root);
            }

        }
        @GeneratedBy(methodName = "println(long)", value = SLPrintlnBuiltin.class)
        private static final class Println0Node_ extends BaseNode_ {

            Println0Node_(SLPrintlnBuiltinNodeGen root) {
                super(root, 1);
            }

            @Override
            public Object acceptAndExecute(Frame frameValue, Object arguments0Value) {
                if (arguments0Value instanceof Long) {
                    long arguments0Value_ = (long) arguments0Value;
                    return root.println(arguments0Value_);
                }
                return next.acceptAndExecute(frameValue, arguments0Value);
            }

            @Override
            public long executeLong(Frame frameValue) throws UnexpectedResultException {
                long arguments0Value_;
                try {
                    arguments0Value_ = root.arguments0_.executeLong((VirtualFrame) frameValue);
                } catch (UnexpectedResultException ex) {
                    return SLTypesGen.expectLong(next.acceptAndExecute(frameValue, ex.getResult()));
                }
                return root.println(arguments0Value_);
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

            static BaseNode_ create(SLPrintlnBuiltinNodeGen root) {
                return new Println0Node_(root);
            }

        }
        @GeneratedBy(methodName = "println(boolean)", value = SLPrintlnBuiltin.class)
        private static final class Println1Node_ extends BaseNode_ {

            Println1Node_(SLPrintlnBuiltinNodeGen root) {
                super(root, 2);
            }

            @Override
            public Object acceptAndExecute(Frame frameValue, Object arguments0Value) {
                if (arguments0Value instanceof Boolean) {
                    boolean arguments0Value_ = (boolean) arguments0Value;
                    return root.println(arguments0Value_);
                }
                return next.acceptAndExecute(frameValue, arguments0Value);
            }

            @Override
            public boolean executeBoolean(Frame frameValue) throws UnexpectedResultException {
                boolean arguments0Value_;
                try {
                    arguments0Value_ = root.arguments0_.executeBoolean((VirtualFrame) frameValue);
                } catch (UnexpectedResultException ex) {
                    return SLTypesGen.expectBoolean(next.acceptAndExecute(frameValue, ex.getResult()));
                }
                return root.println(arguments0Value_);
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

            static BaseNode_ create(SLPrintlnBuiltinNodeGen root) {
                return new Println1Node_(root);
            }

        }
        @GeneratedBy(methodName = "println(String)", value = SLPrintlnBuiltin.class)
        private static final class Println2Node_ extends BaseNode_ {

            Println2Node_(SLPrintlnBuiltinNodeGen root) {
                super(root, 3);
            }

            @Override
            public Object acceptAndExecute(Frame frameValue, Object arguments0Value) {
                if (arguments0Value instanceof String) {
                    String arguments0Value_ = (String) arguments0Value;
                    return root.println(arguments0Value_);
                }
                return next.acceptAndExecute(frameValue, arguments0Value);
            }

            static BaseNode_ create(SLPrintlnBuiltinNodeGen root) {
                return new Println2Node_(root);
            }

        }
        @GeneratedBy(methodName = "println(Object)", value = SLPrintlnBuiltin.class)
        private static final class Println3Node_ extends BaseNode_ {

            Println3Node_(SLPrintlnBuiltinNodeGen root) {
                super(root, 4);
            }

            @Override
            public Object acceptAndExecute(Frame frameValue, Object arguments0Value) {
                return root.println(arguments0Value);
            }

            static BaseNode_ create(SLPrintlnBuiltinNodeGen root) {
                return new Println3Node_(root);
            }

        }
    }
}
