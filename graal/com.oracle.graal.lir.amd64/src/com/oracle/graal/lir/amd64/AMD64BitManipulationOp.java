/*
 * Copyright (c) 2012, 2012, Oracle and/or its affiliates. All rights reserved.
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

import com.oracle.graal.api.code.*;
import com.oracle.graal.api.meta.*;
import com.oracle.graal.asm.amd64.*;
import com.oracle.graal.lir.*;
import com.oracle.graal.lir.asm.*;

public final class AMD64BitManipulationOp extends AMD64LIRInstruction {
    public static final LIRInstructionClass<AMD64BitManipulationOp> TYPE = LIRInstructionClass.create(AMD64BitManipulationOp.class);

    public enum IntrinsicOpcode {
        IPOPCNT,
        LPOPCNT,
        IBSR,
        LBSR,
        BSF,
        ILZCNT,
        LLZCNT,
        ITZCNT,
        LTZCNT
    }

    @Opcode private final IntrinsicOpcode opcode;
    @Def protected AllocatableValue result;
    @Use({OperandFlag.REG, OperandFlag.STACK}) protected AllocatableValue input;

    public AMD64BitManipulationOp(IntrinsicOpcode opcode, AllocatableValue result, AllocatableValue input) {
        super(TYPE);
        this.opcode = opcode;
        this.result = result;
        this.input = input;
    }

    @Override
    public void emitCode(CompilationResultBuilder crb, AMD64MacroAssembler masm) {
        Register dst = ValueUtil.asIntReg(result);
        if (ValueUtil.isRegister(input)) {
            Register src = ValueUtil.asRegister(input);
            switch (opcode) {
                case IPOPCNT:
                    masm.popcntl(dst, src);
                    break;
                case LPOPCNT:
                    masm.popcntq(dst, src);
                    break;
                case BSF:
                    masm.bsfq(dst, src);
                    break;
                case IBSR:
                    masm.bsrl(dst, src);
                    break;
                case LBSR:
                    masm.bsrq(dst, src);
                    break;
                case ILZCNT:
                    masm.lzcntl(dst, src);
                    break;
                case LLZCNT:
                    masm.lzcntq(dst, src);
                    break;
                case ITZCNT:
                    masm.tzcntl(dst, src);
                    break;
                case LTZCNT:
                    masm.tzcntq(dst, src);
                    break;
            }
        } else {
            AMD64Address src = (AMD64Address) crb.asAddress(input);
            switch (opcode) {
                case IPOPCNT:
                    masm.popcntl(dst, src);
                    break;
                case LPOPCNT:
                    masm.popcntq(dst, src);
                    break;
                case BSF:
                    masm.bsfq(dst, src);
                    break;
                case IBSR:
                    masm.bsrl(dst, src);
                    break;
                case LBSR:
                    masm.bsrq(dst, src);
                    break;
                case ILZCNT:
                    masm.lzcntl(dst, src);
                    break;
                case LLZCNT:
                    masm.lzcntq(dst, src);
                    break;
                case ITZCNT:
                    masm.tzcntl(dst, src);
                    break;
                case LTZCNT:
                    masm.tzcntq(dst, src);
                    break;
            }
        }
    }

}
