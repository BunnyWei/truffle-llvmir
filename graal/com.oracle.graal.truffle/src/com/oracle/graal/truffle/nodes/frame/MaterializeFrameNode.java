/*
 * Copyright (c) 2013, 2015, Oracle and/or its affiliates. All rights reserved.
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
package com.oracle.graal.truffle.nodes.frame;

import com.oracle.graal.graph.*;
import com.oracle.graal.nodeinfo.*;
import com.oracle.graal.nodes.*;
import com.oracle.truffle.api.frame.*;

/**
 * Intrinsic node for materializing a Truffle frame.
 */
@NodeInfo(nameTemplate = "MaterializeFrame{p#frame/s}")
public final class MaterializeFrameNode extends FixedWithNextNode implements IterableNodeType {

    public static final NodeClass<MaterializeFrameNode> TYPE = NodeClass.create(MaterializeFrameNode.class);
    @Input ValueNode frame;

    public MaterializeFrameNode(ValueNode frame) {
        super(TYPE, frame.stamp());
        this.frame = frame;
    }

    public ValueNode getFrame() {
        return frame;
    }

    @NodeIntrinsic
    public static native <T> T materialize(VirtualFrame frame);
}
