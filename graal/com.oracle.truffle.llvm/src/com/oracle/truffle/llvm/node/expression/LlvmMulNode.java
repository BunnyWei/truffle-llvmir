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

import com.oracle.truffle.api.*;
import com.oracle.truffle.api.CompilerDirectives.*;
import com.oracle.truffle.api.dsl.*;
import com.oracle.truffle.api.nodes.*;
import com.oracle.truffle.api.source.*;
import com.oracle.truffle.llvm.nodes.*;

/**
 * This class is similar to the extensively documented {@link LlvmAddNode}.
 */

@NodeInfo(shortName = "mul")
public abstract class LlvmMulNode extends LlvmBinaryNode {

    public LlvmMulNode(SourceSection src) {
        super(src);
    }

    @Specialization(rewriteOn = ArithmeticException.class)
    protected long mul(long left, long right) {
        return ExactMath.multiplyExact(left, right);
    }

    @Specialization(rewriteOn = ArithmeticException.class)
    protected float mul(float left, float right) {
        return left * right;
    }

    @Specialization
    @TruffleBoundary
    protected BigInteger mul(BigInteger left, BigInteger right) {
        return left.multiply(right);
    }
}
