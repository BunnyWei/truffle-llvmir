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
package com.oracle.truffle.llvm.node.expression;

import java.math.*;

import com.oracle.truffle.api.dsl.*;
import com.oracle.truffle.api.nodes.*;
import com.oracle.truffle.api.source.*;
import com.oracle.truffle.llvm.nodes.*;

/**
 * This class is similar to the extensively documented {@link LlvmAddNode}. Divisions by 0 throw the
 * same {@link ArithmeticException exception} as in Java, Llvm has no special handling for it to
 * keep the code simple.
 */

@NodeInfo(shortName = "rem")
public abstract class LlvmRemNode extends LlvmBinaryNode {

    public LlvmRemNode(SourceSection src) {
        super(src);
    }

    @Specialization
    protected long div(long left, long right) {
        /* No overflow is possible on a division. */
        return left % right;
    }

    @Specialization
    protected float div(float left, float right) {
        /* No overflow is possible on a division. */
        return left % right;
    }

    @Specialization
    protected BigInteger div(BigInteger left, BigInteger right) {
        return left.remainder(right);
    }
}
