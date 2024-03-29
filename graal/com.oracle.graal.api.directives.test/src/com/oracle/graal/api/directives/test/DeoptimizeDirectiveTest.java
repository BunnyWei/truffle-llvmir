/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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
package com.oracle.graal.api.directives.test;

import org.junit.*;

import com.oracle.graal.api.code.*;
import com.oracle.graal.api.directives.*;
import com.oracle.graal.api.meta.*;
import com.oracle.graal.compiler.test.*;

public class DeoptimizeDirectiveTest extends GraalCompilerTest {

    public static boolean inCompiledCode() {
        return GraalDirectives.inCompiledCode();
    }

    @Test
    public void testInCompiledCode() {
        ResolvedJavaMethod method = getResolvedJavaMethod("inCompiledCode");

        Result interpreted = executeExpected(method, null);
        assertEquals(new Result(false, null), interpreted);

        Result compiled = executeActual(method, null);
        assertEquals(new Result(true, null), compiled);
    }

    public static boolean deoptimizeSnippet() {
        GraalDirectives.deoptimize();
        return GraalDirectives.inCompiledCode(); // should always return false
    }

    public static boolean deoptimizeAndInvalidateSnippet() {
        GraalDirectives.deoptimizeAndInvalidate();
        return GraalDirectives.inCompiledCode(); // should always return false
    }

    @Test
    public void testDeoptimize() {
        test("deoptimizeSnippet");
    }

    private boolean testDeoptimizeCheckValid(ResolvedJavaMethod method) {
        Result expected = executeExpected(method, null);

        InstalledCode code = getCode(method);
        Result actual;
        try {
            actual = new Result(code.executeVarargs(), null);
        } catch (Throwable e) {
            actual = new Result(null, e);
        }

        assertEquals(expected, actual);
        return code.isValid();
    }

    @Test
    public void testDeoptimizeAndInvalidate() {
        ResolvedJavaMethod method = getResolvedJavaMethod("deoptimizeAndInvalidateSnippet");
        boolean valid = testDeoptimizeCheckValid(method);
        Assert.assertFalse("code should be invalidated", valid);
    }

    @Test
    public void testDeoptimizeDontInvalidate() {
        ResolvedJavaMethod method = getResolvedJavaMethod("deoptimizeSnippet");
        boolean valid = testDeoptimizeCheckValid(method);
        Assert.assertTrue("code should still be valid", valid);
    }
}
