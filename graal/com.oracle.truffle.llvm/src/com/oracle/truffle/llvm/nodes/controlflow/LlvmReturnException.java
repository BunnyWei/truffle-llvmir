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

import com.oracle.truffle.api.nodes.*;

/**
 * Exception thrown by the {@link LlvmReturnNode return statement} and caught by the
 * {@link LlvmFunctionBodyNode function body}. The exception transports the return value in its
 * {@link #result} field.
 */
public final class LlvmReturnException extends ControlFlowException {

    // private static final long serialVersionUID = 4073191346281369231L;

    private final Object result;

    public LlvmReturnException(Object result) {
        this.result = result;
    }

    public Object getResult() {
        return result;
    }

    private static final long serialVersionUID = -9177536212065610691L;
}
