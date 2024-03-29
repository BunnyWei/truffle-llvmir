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
package com.oracle.truffle.api.dsl.test;

import static com.oracle.truffle.api.dsl.test.TestHelper.*;
import static org.junit.Assert.*;

import org.junit.*;

import com.oracle.truffle.api.*;
import com.oracle.truffle.api.dsl.*;
import com.oracle.truffle.api.dsl.test.LimitTestFactory.ConstantLimitTestFactory;
import com.oracle.truffle.api.dsl.test.LimitTestFactory.LocalLimitTestFactory;
import com.oracle.truffle.api.dsl.test.LimitTestFactory.MethodLimitTestFactory;
import com.oracle.truffle.api.dsl.test.MethodGuardsTestFactory.GuardCompareWithFieldTestFactory;
import com.oracle.truffle.api.dsl.test.MethodGuardsTestFactory.GuardComplexTestFactory;
import com.oracle.truffle.api.dsl.test.MethodGuardsTestFactory.GuardEqualTestFactory;
import com.oracle.truffle.api.dsl.test.MethodGuardsTestFactory.GuardFieldTestFactory;
import com.oracle.truffle.api.dsl.test.MethodGuardsTestFactory.GuardGreaterEqualTestFactory;
import com.oracle.truffle.api.dsl.test.MethodGuardsTestFactory.GuardGreaterTestFactory;
import com.oracle.truffle.api.dsl.test.MethodGuardsTestFactory.GuardLessEqualTestFactory;
import com.oracle.truffle.api.dsl.test.MethodGuardsTestFactory.GuardLessTestFactory;
import com.oracle.truffle.api.dsl.test.MethodGuardsTestFactory.GuardMethodTestFactory;
import com.oracle.truffle.api.dsl.test.MethodGuardsTestFactory.GuardMultipleAndMethodTestFactory;
import com.oracle.truffle.api.dsl.test.MethodGuardsTestFactory.GuardMultipleOrMethodTestFactory;
import com.oracle.truffle.api.dsl.test.MethodGuardsTestFactory.GuardNotTestFactory;
import com.oracle.truffle.api.dsl.test.MethodGuardsTestFactory.GuardOrTestFactory;
import com.oracle.truffle.api.dsl.test.MethodGuardsTestFactory.GuardStaticFieldTestFactory;
import com.oracle.truffle.api.dsl.test.MethodGuardsTestFactory.GuardUnboundMethodTestFactory;
import com.oracle.truffle.api.dsl.test.TypeSystemTest.ValueNode;

@SuppressWarnings("unused")
public class MethodGuardsTest {

    @Test
    public void testGuardEqual() {
        CallTarget root = createCallTarget(GuardEqualTestFactory.getInstance());
        assertEquals("do1", root.call(1));
        assertEquals("do2", root.call(2));
        assertEquals("do1", root.call(1));
    }

    @NodeChild
    static class GuardEqualTest extends ValueNode {
        @Specialization(guards = "value == 1")
        static String do1(int value) {
            return "do1";
        }

        @Specialization
        static String do2(int value) {
            return "do2";
        }
    }

    @Test
    public void testGuardLessEqual() {
        CallTarget root = createCallTarget(GuardLessEqualTestFactory.getInstance());
        assertEquals("do1", root.call(1));
        assertEquals("do1", root.call(0));
        assertEquals("do2", root.call(2));
        assertEquals("do1", root.call(0));
    }

    @NodeChild
    static class GuardLessEqualTest extends ValueNode {
        @Specialization(guards = "value <= 1")
        static String do1(int value) {
            return "do1";
        }

        @Specialization
        static String do2(int value) {
            return "do2";
        }
    }

    @Test
    public void testGuardLess() {
        CallTarget root = createCallTarget(GuardLessTestFactory.getInstance());
        assertEquals("do1", root.call(0));
        assertEquals("do2", root.call(1));
        assertEquals("do2", root.call(2));
        assertEquals("do1", root.call(-1));
    }

    @NodeChild
    static class GuardLessTest extends ValueNode {
        @Specialization(guards = "value < 1")
        static String do1(int value) {
            return "do1";
        }

        @Specialization
        static String do2(int value) {
            return "do2";
        }
    }

    @Test
    public void testGuardGreaterEqual() {
        CallTarget root = createCallTarget(GuardGreaterEqualTestFactory.getInstance());
        assertEquals("do1", root.call(1));
        assertEquals("do2", root.call(0));
        assertEquals("do1", root.call(2));
        assertEquals("do2", root.call(0));
    }

    @NodeChild
    static class GuardGreaterEqualTest extends ValueNode {
        @Specialization(guards = "value >= 1")
        static String do1(int value) {
            return "do1";
        }

        @Specialization
        static String do2(int value) {
            return "do2";
        }
    }

    @Test
    public void testGuardGreater() {
        CallTarget root = createCallTarget(GuardGreaterTestFactory.getInstance());
        assertEquals("do1", root.call(2));
        assertEquals("do2", root.call(0));
        assertEquals("do2", root.call(1));
        assertEquals("do2", root.call(0));
    }

    @NodeChild
    static class GuardGreaterTest extends ValueNode {
        @Specialization(guards = "value > 1")
        static String do1(int value) {
            return "do1";
        }

        @Specialization
        static String do2(int value) {
            return "do2";
        }
    }

    @Test
    public void testGuardOr() {
        CallTarget root = createCallTarget(GuardOrTestFactory.getInstance());
        assertEquals("do1", root.call(1));
        assertEquals("do1", root.call(0));
        assertEquals("do2", root.call(2));
        assertEquals("do2", root.call(-1));
    }

    @NodeChild
    static class GuardOrTest extends ValueNode {
        @Specialization(guards = "value == 1 || value == 0")
        static String do1(int value) {
            return "do1";
        }

        @Specialization
        static String do2(int value) {
            return "do2";
        }
    }

    @Test
    public void testGuardNot() {
        CallTarget root = createCallTarget(GuardNotTestFactory.getInstance());
        assertEquals("do1", root.call(0));
        assertEquals("do1", root.call(2));
        assertEquals("do2", root.call(1));
        assertEquals("do1", root.call(0));
    }

    @NodeChild
    static class GuardNotTest extends ValueNode {
        @Specialization(guards = "!(value == 1)")
        static String do1(int value) {
            return "do1";
        }

        @Specialization
        static String do2(int value) {
            return "do2";
        }
    }

    @Test
    public void testGuardField() {
        CallTarget root = createCallTarget(GuardFieldTestFactory.getInstance());
        GuardFieldTest node = getNode(root);
        node.field = true;
        assertEquals("do1", root.call(0));
        assertEquals("do1", root.call(2));

        node.field = false;
        try {
            root.call(2);
            fail("expected Assertion failed");
        } catch (AssertionError e) {
        }
    }

    @NodeChild
    static class GuardFieldTest extends ValueNode {

        boolean field;

        @Specialization(guards = "field")
        static String do1(int value) {
            return "do1";
        }

        @Specialization
        static String do2(int value) {
            return "do2";
        }
    }

    @Test
    public void testGuardCompareWithField() {
        CallTarget root = createCallTarget(GuardCompareWithFieldTestFactory.getInstance());
        GuardCompareWithFieldTest node = getNode(root);
        node.field = 1;
        assertEquals("do1", root.call(1));
        assertEquals("do2", root.call(2));

        node.field = 2;
        assertEquals("do2", root.call(1));
        assertEquals("do1", root.call(2));
    }

    @NodeChild
    static class GuardCompareWithFieldTest extends ValueNode {

        int field;

        @Specialization(guards = "value == field")
        static String do1(int value) {
            return "do1";
        }

        @Specialization
        static String do2(int value) {
            return "do2";
        }
    }

    @Test
    public void testGuardStaticField() {
        CallTarget root = createCallTarget(GuardStaticFieldTestFactory.getInstance());
        GuardStaticFieldTest.field = true;
        assertEquals("do1", root.call(1));
        assertEquals("do1", root.call(2));
        GuardStaticFieldTest.field = false;
        try {
            root.call(2);
            fail("expected Assertion failed");
        } catch (AssertionError e) {
        }
    }

    @NodeChild
    static class GuardStaticFieldTest extends ValueNode {

        static boolean field;

        @Specialization(guards = "field")
        static String do1(int value) {
            return "do1";
        }

        @Specialization
        static String do2(int value) {
            return "do2";
        }
    }

    @Test
    public void testGuardMethod() {
        CallTarget root = createCallTarget(GuardMethodTestFactory.getInstance());
        assertEquals("do1", root.call(1));
        assertEquals("do2", root.call(2));
        assertEquals("do1", root.call(1));
        assertEquals("do2", root.call(0));
    }

    @NodeChild
    static class GuardMethodTest extends ValueNode {

        @Specialization(guards = "method(value)")
        static String do1(int value) {
            return "do1";
        }

        @Specialization
        static String do2(int value) {
            return "do2";
        }

        boolean method(int value) {
            return value == 1;
        }
    }

    @Test
    public void testGuardUnboundMethodField() {
        CallTarget root = createCallTarget(GuardUnboundMethodTestFactory.getInstance());
        GuardUnboundMethodTest node = getNode(root);
        node.hiddenValue = true;
        assertEquals("do1", root.call(1));
        assertEquals("do1", root.call(2));
        node.hiddenValue = false;
        try {
            root.call(2);
            fail("expected Assertion failed");
        } catch (AssertionError e) {
        }
    }

    @NodeChild
    static class GuardUnboundMethodTest extends ValueNode {

        private boolean hiddenValue;

        @Specialization(guards = "method()")
        static String do1(int value) {
            return "do1";
        }

        boolean method() {
            return hiddenValue;
        }
    }

    @Test
    public void testStaticGuardMethod() {
        CallTarget root = createCallTarget(GuardMethodTestFactory.getInstance());
        assertEquals("do1", root.call(1));
        assertEquals("do2", root.call(2));
        assertEquals("do1", root.call(1));
        assertEquals("do2", root.call(0));
    }

    @NodeChild
    static class StaticGuardMethodTest extends ValueNode {

        @Specialization(guards = "method(value)")
        static String do1(int value) {
            return "do1";
        }

        @Specialization
        static String do2(int value) {
            return "do2";
        }

        static boolean method(int value) {
            return value == 1;
        }
    }

    @Test
    public void testMultipleGuardAndMethod() {
        CallTarget root = createCallTarget(GuardMultipleAndMethodTestFactory.getInstance());
        assertEquals("do1", root.call(1));
        assertEquals("do1", root.call(2));
        assertEquals("do2", root.call(3));
        assertEquals("do2", root.call(0));
    }

    @NodeChild
    static class GuardMultipleAndMethodTest extends ValueNode {

        @Specialization(guards = {"method1(value)", "method2(value)"})
        static String do1(int value) {
            return "do1";
        }

        @Specialization
        static String do2(int value) {
            return "do2";
        }

        boolean method1(int value) {
            return value >= 1;
        }

        boolean method2(int value) {
            return value <= 2;
        }
    }

    @Test
    public void testMultipleGuardOrMethod() {
        CallTarget root = createCallTarget(GuardMultipleOrMethodTestFactory.getInstance());
        assertEquals("do1", root.call(1));
        assertEquals("do1", root.call(2));
        assertEquals("do2", root.call(3));
        assertEquals("do2", root.call(0));
    }

    @NodeChild
    static class GuardMultipleOrMethodTest extends ValueNode {

        @Specialization(guards = {"method1(value) || method2(value)"})
        static String do1(int value) {
            return "do1";
        }

        @Specialization
        static String do2(int value) {
            return "do2";
        }

        boolean method1(int value) {
            return value == 1;
        }

        boolean method2(int value) {
            return value == 2;
        }
    }

    @Test
    public void testComplexGuard() {
        CallTarget root = createCallTarget(GuardComplexTestFactory.getInstance());
        assertEquals("do1", root.call(1));
        assertEquals("do1", root.call(2));
        assertEquals("do2", root.call(3));
        assertEquals("do1", root.call(0));
    }

    @NodeChild
    static class GuardComplexTest extends ValueNode {

        int field1 = 1;
        static int field2 = 2;

        @Specialization(guards = {"method2(method1(field1 == 1), value <= 2)", "field2 == 2"})
        static String do1(int value) {
            return "do1";
        }

        @Specialization
        static String do2(int value) {
            return "do2";
        }

        static boolean method1(boolean value) {
            return value;
        }

        boolean method2(boolean value1, boolean value2) {
            return value1 && value2;
        }
    }

    @NodeChild
    static class ErrorGuardNotTest extends ValueNode {
        @ExpectError("Error parsing expression '!value == 1': The operator ! is undefined for the argument type int.")
        @Specialization(guards = "!value == 1")
        static String do1(int value) {
            return "do1";
        }
    }

    @NodeChild
    static class ErrorIncompatibleReturnTypeTest extends ValueNode {

        @ExpectError("Incompatible return type int. Guards must return boolean.")
        @Specialization(guards = "1")
        static String do1(int value) {
            return "do1";
        }

    }

}
