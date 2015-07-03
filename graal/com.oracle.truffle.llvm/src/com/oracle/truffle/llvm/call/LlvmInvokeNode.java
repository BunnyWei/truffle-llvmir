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
package com.oracle.truffle.llvm.call;

import com.oracle.truffle.api.*;

import com.oracle.truffle.api.dsl.*;
import com.oracle.truffle.api.frame.*;
import com.oracle.truffle.api.nodes.*;
import com.oracle.truffle.api.source.*;
import com.oracle.truffle.llvm.nodes.*;
import com.oracle.truffle.llvm.runtime.*;

/**
 * The node for function invocation in Llvm. Since Llvm has first class functions, the
 * {@link LlvmFunction target function} can be computed by an {@link #functionNode arbitrary
 * expression}. This node is responsible for evaluating this expression, as well as evaluating the
 * {@link #argumentNodes arguments}. The actual dispatch is then delegated to a chain of
 * {@link LlvmAbstractDispatchNode}s that form a polymorphic inline cache.
 */
@NodeInfo(shortName = "invoke")
public final class LlvmInvokeNode extends LlvmExpressionNode {

    public static LlvmInvokeNode create(SourceSection src, LlvmExpressionNode function, LlvmExpressionNode[] arguments) {
        return new LlvmInvokeNode(src, function, arguments, new LlvmUninitializedDispatchNode());
    }

    @Child protected LlvmExpressionNode functionNode;
    @Children protected final LlvmExpressionNode[] argumentNodes;
    @Child protected LlvmAbstractDispatchNode dispatchNode;

    private LlvmInvokeNode(SourceSection src, LlvmExpressionNode functionNode, LlvmExpressionNode[] argumentNodes, LlvmAbstractDispatchNode dispatchNode) {
        super(src);
        this.functionNode = functionNode;
        this.argumentNodes = argumentNodes;
        this.dispatchNode = dispatchNode;
    }

    @Override
    @ExplodeLoop
    public Object executeGeneric(VirtualFrame frame) {
        LlvmFunction function = evaluateFunction(frame);

        /*
         * The number of arguments is constant for one invoke node. During compilation, the loop is
         * unrolled and the execute methods of all arguments are inlined. This is triggered by the
         * ExplodeLoop annotation on the method. The compiler assertion below illustrates that the
         * array length is really constant.
         */
        CompilerAsserts.compilationConstant(argumentNodes.length);

        Object[] argumentValues = new Object[argumentNodes.length];
        for (int i = 0; i < argumentNodes.length; i++) {
            argumentValues[i] = argumentNodes[i].executeGeneric(frame);
        }

        return dispatchNode.executeDispatch(frame, function, argumentValues);
    }

    private LlvmFunction evaluateFunction(VirtualFrame frame) {
        try {
            /*
             * The function node must evaluate to a LlvmFunction value, so we call
             * function-specialized method.
             */
            return functionNode.executeFunction(frame);
        } catch (UnexpectedResultException ex) {
            /*
             * The function node evaluated to a non-function result. This is a type error in the
             * Llvm program. We report it with the same exception that Truffle DSL generated nodes
             * use to report type errors.
             */
            throw new UnsupportedSpecializationException(this, new Node[]{functionNode}, ex.getResult());
        }
    }
}
