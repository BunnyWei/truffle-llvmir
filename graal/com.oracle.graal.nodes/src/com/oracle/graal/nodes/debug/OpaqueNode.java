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
package com.oracle.graal.nodes.debug;

import com.oracle.graal.graph.*;
import com.oracle.graal.nodeinfo.*;
import com.oracle.graal.nodes.*;
import com.oracle.graal.nodes.calc.*;
import com.oracle.graal.nodes.spi.*;

@NodeInfo
public final class OpaqueNode extends FloatingNode implements LIRLowerable {

    public static final NodeClass<OpaqueNode> TYPE = NodeClass.create(OpaqueNode.class);
    @Input protected ValueNode value;

    public OpaqueNode(ValueNode value) {
        super(TYPE, value.stamp().unrestricted());
        this.value = value;
    }

    public ValueNode getValue() {
        return value;
    }

    @Override
    public void generate(NodeLIRBuilderTool gen) {
        gen.setResult(this, gen.operand(value));
    }

    @NodeIntrinsic
    public static native boolean opaque(boolean v);

    @NodeIntrinsic
    public static native byte opaque(byte v);

    @NodeIntrinsic
    public static native short opaque(short v);

    @NodeIntrinsic
    public static native char opaque(char v);

    @NodeIntrinsic
    public static native int opaque(int v);

    @NodeIntrinsic
    public static native long opaque(long v);

    @NodeIntrinsic
    public static native float opaque(float v);

    @NodeIntrinsic
    public static native double opaque(double v);

    @NodeIntrinsic
    public static native <T> T opaque(T v);
}
