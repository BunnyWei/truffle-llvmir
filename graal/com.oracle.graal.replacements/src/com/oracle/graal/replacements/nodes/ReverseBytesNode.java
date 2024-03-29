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
package com.oracle.graal.replacements.nodes;

import com.oracle.graal.api.code.*;
import com.oracle.graal.api.meta.*;
import com.oracle.graal.compiler.common.type.*;
import com.oracle.graal.graph.*;
import com.oracle.graal.graph.spi.*;
import com.oracle.graal.nodeinfo.*;
import com.oracle.graal.nodes.*;
import com.oracle.graal.nodes.calc.*;
import com.oracle.graal.nodes.spi.*;

@NodeInfo
public final class ReverseBytesNode extends UnaryNode implements LIRLowerable {

    public static final NodeClass<ReverseBytesNode> TYPE = NodeClass.create(ReverseBytesNode.class);

    public ReverseBytesNode(ValueNode value) {
        super(TYPE, StampFactory.forKind(value.getKind()), value);
        assert getKind() == Kind.Int || getKind() == Kind.Long;
    }

    @Override
    public boolean inferStamp() {
        IntegerStamp valueStamp = (IntegerStamp) getValue().stamp();
        Stamp newStamp;
        if (getKind() == Kind.Int) {
            long mask = CodeUtil.mask(Kind.Int.getBitCount());
            newStamp = IntegerStamp.stampForMask(valueStamp.getBits(), reverse((int) valueStamp.downMask()) & mask, reverse((int) valueStamp.upMask()) & mask);
        } else if (getKind() == Kind.Long) {
            newStamp = IntegerStamp.stampForMask(valueStamp.getBits(), reverse(valueStamp.downMask()), reverse(valueStamp.upMask()));
        } else {
            return false;
        }
        return updateStamp(newStamp);
    }

    @Override
    public ValueNode canonical(CanonicalizerTool tool, ValueNode forValue) {
        if (forValue.isConstant()) {
            JavaConstant c = forValue.asJavaConstant();
            return ConstantNode.forIntegerKind(getKind(), getKind() == Kind.Int ? reverse(c.asInt()) : reverse(c.asLong()));
        }
        return this;
    }

    @NodeIntrinsic
    public static int reverse(int v) {
        return Integer.reverseBytes(v);
    }

    @NodeIntrinsic
    public static long reverse(long v) {
        return Long.reverseBytes(v);
    }

    @Override
    public void generate(NodeLIRBuilderTool gen) {
        Value result = gen.getLIRGeneratorTool().emitByteSwap(gen.operand(getValue()));
        gen.setResult(this, result);
    }
}
