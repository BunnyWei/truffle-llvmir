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

import com.oracle.truffle.api.frame.*;
import com.oracle.truffle.api.nodes.*;
import com.oracle.truffle.llvm.runtime.*;

/**
 * Slow-path code for a call, used when the polymorphic inline cache exceeded its maximum size. Such
 * calls are not optimized any further, e.g., no method inlining is performed.
 */
final class LlvmGenericDispatchNode extends LlvmAbstractDispatchNode {

    /**
     * {@link IndirectCallNode} is part of the Truffle API and handles all the steps necessary for
     * calling a megamorphic call-site. The Graal specific version of this node performs additional
     * optimizations for the fast access of the SimpleLanguage stack trace.
     */
    @Child private IndirectCallNode callNode = Truffle.getRuntime().createIndirectCallNode();

    @Override
    protected Object executeDispatch(VirtualFrame frame, LlvmFunction function, Object[] arguments) {
        /*
         * Llvm has a quite simple call lookup: just ask the function for the current call target,
         * and call it.
         */
        return callNode.call(frame, function.getCallTarget(), arguments);
    }

}
