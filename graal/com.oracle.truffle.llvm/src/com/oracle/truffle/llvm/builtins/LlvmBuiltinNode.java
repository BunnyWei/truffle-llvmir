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
package com.oracle.truffle.llvm.builtins;

import com.oracle.truffle.api.dsl.*;

import com.oracle.truffle.api.source.*;
import com.oracle.truffle.llvm.nodes.*;
import com.oracle.truffle.llvm.runtime.*;

/**
 * Base class for all builtin functions. It contains the Truffle DLlvm annotation {@link NodeChild}
 * that defines the function arguments.<br>
 * Builtin functions need access to the {@link LlvmContext}. Instead of defining a Java field
 * manually and setting it in a constructor, we use the Truffle DLlvm annotation {@link NodeField}
 * that generates the field and constructor automatically.
 * <p>
 * The builtin functions are registered in {@link LlvmContext#installBuiltins}. Every builtin node
 * subclass is instantiated there, wrapped into a function, and added to the
 * {@link LlvmFunctionRegistry}. This ensures that builtin functions can be called like user-defined
 * functions; there is no special function lookup or call node for builtin functions.
 */
@NodeChild(value = "arguments", type = LlvmExpressionNode[].class)
@NodeField(name = "context", type = LlvmContext.class)
@GenerateNodeFactory
public abstract class LlvmBuiltinNode extends LlvmExpressionNode {

    public LlvmBuiltinNode(SourceSection src) {
        super(src);
    }

    /**
     * Accessor for the {@link LlvmContext}. The implementation of this method is generated
     * automatically based on the {@link NodeField} annotation on the class.
     */
    public abstract LlvmContext getContext();
}
