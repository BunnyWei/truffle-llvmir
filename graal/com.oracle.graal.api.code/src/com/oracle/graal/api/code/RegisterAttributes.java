/*
 * Copyright (c) 2010, 2011, Oracle and/or its affiliates. All rights reserved.
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
package com.oracle.graal.api.code;

import java.util.*;

/**
 * A collection of register attributes. The specific attribute values for a register may be local to
 * a compilation context. For example, a {@link RegisterConfig} in use during a compilation will
 * determine which registers are callee saved.
 */
public class RegisterAttributes {

    private final boolean callerSave;
    private final boolean calleeSave;
    private final boolean allocatable;

    public RegisterAttributes(boolean isCallerSave, boolean isCalleeSave, boolean isAllocatable) {
        this.callerSave = isCallerSave;
        this.calleeSave = isCalleeSave;
        this.allocatable = isAllocatable;
    }

    public static final RegisterAttributes NONE = new RegisterAttributes(false, false, false);

    /**
     * Creates a map from register {@linkplain Register#number numbers} to register
     * {@linkplain RegisterAttributes attributes} for a given register configuration and set of
     * registers.
     *
     * @param registerConfig a register configuration
     * @param registers a set of registers
     * @return an array whose length is the max register number in {@code registers} plus 1. An
     *         element at index i holds the attributes of the register whose number is i.
     */
    public static RegisterAttributes[] createMap(RegisterConfig registerConfig, Register[] registers) {
        RegisterAttributes[] map = new RegisterAttributes[registers.length];
        for (Register reg : registers) {
            if (reg != null) {
                CalleeSaveLayout csl = registerConfig.getCalleeSaveLayout();
                RegisterAttributes attr = new RegisterAttributes(Arrays.asList(registerConfig.getCallerSaveRegisters()).contains(reg),
                                csl == null ? false : Arrays.asList(csl.registers).contains(reg), Arrays.asList(registerConfig.getAllocatableRegisters()).contains(reg));
                if (map.length <= reg.number) {
                    map = Arrays.copyOf(map, reg.number + 1);
                }
                map[reg.number] = attr;
            }
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] == null) {
                map[i] = NONE;
            }
        }
        return map;
    }

    /**
     * @return Denotes a register that is available for use by a register allocator.
     */
    public boolean isAllocatable() {
        return allocatable;
    }

    /**
     * @return Denotes a register whose value preservation (if required) across a call is the
     *         responsibility of the callee.
     */
    public boolean isCalleeSave() {
        return calleeSave;
    }

    /**
     * @return Denotes a register whose value preservation (if required) across a call is the
     *         responsibility of the caller.
     */
    public boolean isCallerSave() {
        return callerSave;
    }
}
