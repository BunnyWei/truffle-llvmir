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
package com.oracle.graal.truffle.substitutions;

import java.util.concurrent.*;

import com.oracle.graal.api.meta.*;
import com.oracle.graal.api.replacements.*;
import com.oracle.graal.nodes.*;
import com.oracle.graal.nodes.extended.*;
import com.oracle.graal.nodes.spi.*;
import com.oracle.graal.truffle.nodes.*;
import com.oracle.graal.truffle.nodes.frame.*;
import com.oracle.truffle.api.*;

@ClassSubstitution(CompilerDirectives.class)
public class CompilerDirectivesSubstitutions {

    @MethodSubstitution
    public static void transferToInterpreter() {
        DeoptimizeNode.deopt(DeoptimizationAction.None, DeoptimizationReason.TransferToInterpreter);
    }

    @MethodSubstitution
    public static void transferToInterpreterAndInvalidate() {
        DeoptimizeNode.deopt(DeoptimizationAction.InvalidateReprofile, DeoptimizationReason.TransferToInterpreter);
    }

    @MethodSubstitution
    public static boolean inInterpreter() {
        return false;
    }

    @MethodSubstitution
    public static boolean inCompiledCode() {
        return true;
    }

    @MethodSubstitution
    public static void interpreterOnly(@SuppressWarnings("unused") Runnable runnable) {
    }

    @MethodSubstitution
    public static <T> T interpreterOnly(@SuppressWarnings("unused") Callable<T> callable) throws Exception {
        return null;
    }

    @MethodSubstitution
    public static boolean injectBranchProbability(double probability, boolean condition) {
        return BranchProbabilityNode.probability(probability, condition);
    }

    @MacroSubstitution(macro = BailoutNode.class, isStatic = true)
    public static native void bailout(String reason);

    @MethodSubstitution
    public static boolean isCompilationConstant(Object value) {
        return IsCompilationConstantNode.check(value);
    }

    @MethodSubstitution
    public static void materialize(Object obj) {
        ForceMaterializeNode.force(obj);
    }
}
