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

@GeneratedBy(SLNanoTimeBuiltin.class)
public final class SLNanoTimeBuiltinFactory extends NodeFactoryBase<SLNanoTimeBuiltin> {

    private static SLNanoTimeBuiltinFactory instance;

    private SLNanoTimeBuiltinFactory() {
        super(SLNanoTimeBuiltin.class, DSLMetadata.EMPTY_CLASS_ARRAY, new Class<?>[][] {new Class<?>[] {SLExpressionNode[].class, SLContext.class}});
    }

    @Override
    public SLNanoTimeBuiltin createNode(Object... arguments) {
        if (arguments.length == 2 && (arguments[0] == null || arguments[0] instanceof SLExpressionNode[]) && (arguments[1] == null || arguments[1] instanceof SLContext)) {
            return create((SLExpressionNode[]) arguments[0], (SLContext) arguments[1]);
        } else {
            throw new IllegalArgumentException("Invalid create signature.");
        }
    }

    public static NodeFactory<SLNanoTimeBuiltin> getInstance() {
        if (instance == null) {
            instance = new SLNanoTimeBuiltinFactory();
        }
        return instance;
    }

    public static SLNanoTimeBuiltin create(SLExpressionNode[] arguments, SLContext context) {
        return new SLNanoTimeBuiltinNodeGen(arguments, context);
    }

    @GeneratedBy(SLNanoTimeBuiltin.class)
    public static final class SLNanoTimeBuiltinNodeGen extends SLNanoTimeBuiltin {

        private final SLContext context;

        @SuppressWarnings("unused")
        private SLNanoTimeBuiltinNodeGen(SLExpressionNode[] arguments, SLContext context) {
            this.context = context;
        }

        @Override
        public SLContext getContext() {
            return this.context;
        }

        @Override
        public Object executeGeneric(VirtualFrame frameValue) {
            return executeLong(frameValue);
        }

        @Override
        public long executeLong(VirtualFrame frameValue) {
            return this.nanoTime();
        }

        @Override
        public void executeVoid(VirtualFrame frameValue) {
            executeLong(frameValue);
            return;
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
