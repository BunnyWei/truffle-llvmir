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
package com.oracle.truffle.llvm.nodes.controlflow;

import com.oracle.truffle.api.frame.*;
import com.oracle.truffle.api.nodes.*;
import com.oracle.truffle.api.source.*;
import com.oracle.truffle.llvm.nodes.*;

/**
 * Implementation of the Llvm continue statement. We need to unwind an unknown number of interpreter
 * frames that are between this {@link LlvmContinueNode} and the {@link LlvmWhileNode} of the loop
 * we are continuing. This is done by throwing an {@link LlvmContinueException exception} that is
 * caught by the {@link LlvmWhileNode#executeVoid loop node}.
 */
@NodeInfo(shortName = "continue", description = "The node implementing a continue statement")
public final class LlvmContinueNode extends LlvmStatementNode {

    public LlvmContinueNode(SourceSection src) {
        super(src);
    }

    @Override
    public void executeVoid(VirtualFrame frame) {
        throw LlvmContinueException.SINGLETON;
    }
}
