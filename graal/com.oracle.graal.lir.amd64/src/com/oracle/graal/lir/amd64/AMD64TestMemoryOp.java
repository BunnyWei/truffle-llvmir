/*
 * Copyright (c) 2011, 2015, Oracle and/or its affiliates. All rights reserved.
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
package com.oracle.graal.lir.amd64;

import static com.oracle.graal.api.code.ValueUtil.*;
import static com.oracle.graal.lir.LIRInstruction.OperandFlag.*;

import com.oracle.graal.api.meta.*;
import com.oracle.graal.asm.amd64.*;
import com.oracle.graal.compiler.common.*;
import com.oracle.graal.lir.*;
import com.oracle.graal.lir.amd64.AMD64Move.MemOp;
import com.oracle.graal.lir.asm.*;

public final class AMD64TestMemoryOp extends MemOp {
    public static final LIRInstructionClass<AMD64TestMemoryOp> TYPE = LIRInstructionClass.create(AMD64TestMemoryOp.class);

    @Use({REG, CONST}) protected Value y;

    public AMD64TestMemoryOp(Kind kind, AMD64AddressValue x, Value y, LIRFrameState state) {
        super(TYPE, kind, x, state);
        this.y = y;
        this.state = state;
    }

    @Override
    public void emitMemAccess(CompilationResultBuilder crb, AMD64MacroAssembler masm) {
        if (isRegister(y)) {
            switch (kind) {
                case Int:
                    masm.testl(asIntReg(y), address.toAddress());
                    break;
                case Long:
                    masm.testq(asLongReg(y), address.toAddress());
                    break;
                default:
                    throw GraalInternalError.shouldNotReachHere();
            }
        } else if (isConstant(y)) {
            switch (kind) {
                case Int:
                    masm.testl(address.toAddress(), crb.asIntConst(y));
                    break;
                case Long:
                    masm.testq(address.toAddress(), crb.asIntConst(y));
                    break;
                default:
                    throw GraalInternalError.shouldNotReachHere();
            }
        } else {
            throw GraalInternalError.shouldNotReachHere();
        }
    }

    @Override
    public void verify() {
        super.verify();
        assert (kind == Kind.Int || kind == Kind.Long) && kind == y.getKind() : address + " " + y;
    }
}
