/*
 * Copyright (c) 2012, 2015, Oracle and/or its affiliates. All rights reserved.
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
package com.oracle.graal.lir.sparc;

import static com.oracle.graal.lir.LIRInstruction.OperandFlag.*;

import com.oracle.graal.api.meta.*;
import com.oracle.graal.asm.sparc.*;
import com.oracle.graal.lir.*;
import com.oracle.graal.lir.asm.*;

/**
 * Emits a breakpoint.
 */
@Opcode("BREAKPOINT")
public final class SPARCBreakpointOp extends SPARCLIRInstruction {
    public static final LIRInstructionClass<SPARCBreakpointOp> TYPE = LIRInstructionClass.create(SPARCBreakpointOp.class);

    // historical - from hotspot src/cpu/sparc/vm
    // <sys/trap.h> promises that the system will not use traps 16-31
    // We want to use ST_BREAKPOINT here, but the debugger is confused by it.
    public static final int ST_RESERVED_FOR_USER_0 = 0x10;

    /**
     * A set of values loaded into the Java ABI parameter locations (for inspection by a debugger).
     */
    @Use({REG, STACK}) protected Value[] parameters;

    public SPARCBreakpointOp(Value[] parameters) {
        super(TYPE);
        this.parameters = parameters;
    }

    @Override
    public void emitCode(CompilationResultBuilder crb, SPARCMacroAssembler masm) {
        masm.ta(ST_RESERVED_FOR_USER_0);
    }
}
