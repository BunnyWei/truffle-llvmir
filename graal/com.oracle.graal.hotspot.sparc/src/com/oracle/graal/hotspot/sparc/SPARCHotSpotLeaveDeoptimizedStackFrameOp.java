/*
 * Copyright (c) 2014, 2015, Oracle and/or its affiliates. All rights reserved.
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
package com.oracle.graal.hotspot.sparc;

import static com.oracle.graal.sparc.SPARC.*;

import com.oracle.graal.asm.sparc.*;
import com.oracle.graal.lir.*;
import com.oracle.graal.lir.asm.*;
import com.oracle.graal.lir.sparc.*;

/**
 * Pops the current frame off the stack including the return address.
 */
@Opcode("LEAVE_DEOPTIMIZED_STACK_FRAME")
final class SPARCHotSpotLeaveDeoptimizedStackFrameOp extends SPARCLIRInstruction {

    public static final LIRInstructionClass<SPARCHotSpotLeaveDeoptimizedStackFrameOp> TYPE = LIRInstructionClass.create(SPARCHotSpotLeaveDeoptimizedStackFrameOp.class);

    protected SPARCHotSpotLeaveDeoptimizedStackFrameOp() {
        super(TYPE);
    }

    @Override
    public void emitCode(CompilationResultBuilder crb, SPARCMacroAssembler masm) {
        // Save O registers over restore.
        masm.mov(o0, i0);
        masm.mov(o1, i1);
        masm.mov(o2, i2);
        masm.mov(o3, i3);
        masm.mov(o4, i4);

        masm.restoreWindow();
    }

    @Override
    public boolean leavesRegisterWindow() {
        return true;
    }
}
