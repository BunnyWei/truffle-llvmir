/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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
package com.oracle.graal.lir;

import java.util.*;

import com.oracle.graal.api.code.*;
import com.oracle.graal.compiler.common.cfg.*;
import com.oracle.graal.lir.StandardOp.ImplicitNullCheck;
import com.oracle.graal.lir.StandardOp.NullCheck;
import com.oracle.graal.lir.gen.*;
import com.oracle.graal.lir.phases.*;

public final class NullCheckOptimizer extends PostAllocationOptimizationPhase {

    @Override
    protected <B extends AbstractBlockBase<B>> void run(TargetDescription target, LIRGenerationResult lirGenRes, List<B> codeEmittingOrder, List<B> linearScanOrder) {
        LIR ir = lirGenRes.getLIR();
        List<? extends AbstractBlockBase<?>> blocks = ir.codeEmittingOrder();
        NullCheckOptimizer.foldNullChecks(ir, blocks, target.implicitNullCheckLimit);
    }

    private static void foldNullChecks(LIR ir, List<? extends AbstractBlockBase<?>> blocks, int implicitNullCheckLimit) {
        for (AbstractBlockBase<?> block : blocks) {
            List<LIRInstruction> list = ir.getLIRforBlock(block);

            if (!list.isEmpty()) {

                LIRInstruction lastInstruction = list.get(0);
                for (int i = 0; i < list.size(); i++) {
                    LIRInstruction instruction = list.get(i);

                    if (instruction instanceof ImplicitNullCheck && lastInstruction instanceof NullCheck) {
                        NullCheck nullCheck = (NullCheck) lastInstruction;
                        ImplicitNullCheck implicitNullCheck = (ImplicitNullCheck) instruction;
                        if (implicitNullCheck.makeNullCheckFor(nullCheck.getCheckedValue(), nullCheck.getState(), implicitNullCheckLimit)) {
                            list.remove(i - 1);
                            if (i < list.size()) {
                                instruction = list.get(i);
                            }
                        }
                    }
                    lastInstruction = instruction;
                }
            }
        }
    }

}
