/*
 * Copyright (c) 2014, 2014, Oracle and/or its affiliates. All rights reserved.
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
package com.oracle.graal.lir.framemap;

import java.util.*;

import com.oracle.graal.api.code.*;
import com.oracle.graal.api.meta.*;

/**
 * Represents a {@link #getSlots() numbered} range of {@link VirtualStackSlot virtual stack slot} of
 * size {@link TargetDescription#wordSize}.
 */
public class VirtualStackSlotRange extends VirtualStackSlot {

    private static final long serialVersionUID = 5152592950118317121L;
    private final BitSet objects;
    private final int slots;

    public VirtualStackSlotRange(int id, int slots, BitSet objects) {
        super(id, LIRKind.reference(Kind.Object));
        this.slots = slots;
        this.objects = (BitSet) objects.clone();
    }

    public int getSlots() {
        return slots;
    }

    public BitSet getObjects() {
        return (BitSet) objects.clone();
    }

}
