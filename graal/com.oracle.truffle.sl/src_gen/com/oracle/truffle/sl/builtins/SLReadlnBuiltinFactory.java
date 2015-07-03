/*
 * Copyright (c) 2014, 2014, Oracle and/or its affiliates. All rights reserved.
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

import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.NodeFactory;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.dsl.internal.DSLMetadata;
import com.oracle.truffle.api.dsl.internal.NodeFactoryBase;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.sl.nodes.SLExpressionNode;
import com.oracle.truffle.sl.runtime.SLContext;

@GeneratedBy(SLReadlnBuiltin.class)
public final class SLReadlnBuiltinFactory extends NodeFactoryBase<SLReadlnBuiltin> {

    private static SLReadlnBuiltinFactory instance;

    private SLReadlnBuiltinFactory() {
        super(SLReadlnBuiltin.class, DSLMetadata.EMPTY_CLASS_ARRAY, new Class<?>[][] {new Class<?>[] {SLExpressionNode[].class, SLContext.class}});
    }

    @Override
    public SLReadlnBuiltin createNode(Object... arguments) {
        if (arguments.length == 2 && (arguments[0] == null || arguments[0] instanceof SLExpressionNode[]) && (arguments[1] == null || arguments[1] instanceof SLContext)) {
            return create((SLExpressionNode[]) arguments[0], (SLContext) arguments[1]);
        } else {
            throw new IllegalArgumentException("Invalid create signature.");
        }
    }

    public static NodeFactory<SLReadlnBuiltin> getInstance() {
        if (instance == null) {
            instance = new SLReadlnBuiltinFactory();
        }
        return instance;
    }

    public static SLReadlnBuiltin create(SLExpressionNode[] arguments, SLContext context) {
        return new SLReadlnBuiltinNodeGen(arguments, context);
    }

    @GeneratedBy(SLReadlnBuiltin.class)
    public static final class SLReadlnBuiltinNodeGen extends SLReadlnBuiltin {

        private final SLContext context;

        @SuppressWarnings("unused")
        private SLReadlnBuiltinNodeGen(SLExpressionNode[] arguments, SLContext context) {
            this.context = context;
        }

        @Override
        public SLContext getContext() {
            return this.context;
        }

        @Override
        public Object executeGeneric(VirtualFrame frameValue) {
            return this.readln();
        }

        @Override
        public NodeCost getCost() {
            return NodeCost.MONOMORPHIC;
        }

        protected UnsupportedSpecializationException unsupported() {
            return new UnsupportedSpecializationException(this, new Node[] {});
        }

    }
}
