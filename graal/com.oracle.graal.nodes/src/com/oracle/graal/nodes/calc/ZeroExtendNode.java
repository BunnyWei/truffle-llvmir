/*
 * Copyright (c) 2014, 2015, Oracle and/or its affiliates. All rights reserved.
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
package com.oracle.graal.nodes.calc;

import com.oracle.graal.api.code.*;
import com.oracle.graal.compiler.common.calc.*;
import com.oracle.graal.compiler.common.type.*;
import com.oracle.graal.compiler.common.type.ArithmeticOpTable.*;
import com.oracle.graal.compiler.common.type.ArithmeticOpTable.IntegerConvertOp.*;
import com.oracle.graal.graph.*;
import com.oracle.graal.graph.spi.*;
import com.oracle.graal.lir.gen.*;
import com.oracle.graal.nodeinfo.*;
import com.oracle.graal.nodes.*;
import com.oracle.graal.nodes.spi.*;

/**
 * The {@code ZeroExtendNode} converts an integer to a wider integer using zero extension.
 */
@NodeInfo
public final class ZeroExtendNode extends IntegerConvertNode<ZeroExtend, Narrow> {

    public static final NodeClass<ZeroExtendNode> TYPE = NodeClass.create(ZeroExtendNode.class);

    public ZeroExtendNode(ValueNode input, int resultBits) {
        this(input, PrimitiveStamp.getBits(input.stamp()), resultBits);
        assert 0 < PrimitiveStamp.getBits(input.stamp()) && PrimitiveStamp.getBits(input.stamp()) <= resultBits;
    }

    public ZeroExtendNode(ValueNode input, int inputBits, int resultBits) {
        super(TYPE, ArithmeticOpTable::getZeroExtend, ArithmeticOpTable::getNarrow, inputBits, resultBits, input);
    }

    public static ValueNode create(ValueNode input, int resultBits) {
        return create(input, PrimitiveStamp.getBits(input.stamp()), resultBits);
    }

    public static ValueNode create(ValueNode input, int inputBits, int resultBits) {
        IntegerConvertOp<ZeroExtend> signExtend = ArithmeticOpTable.forStamp(input.stamp()).getZeroExtend();
        ValueNode synonym = findSynonym(signExtend, input, inputBits, resultBits, signExtend.foldStamp(inputBits, resultBits, input.stamp()));
        if (synonym != null) {
            return synonym;
        } else {
            return new ZeroExtendNode(input, inputBits, resultBits);
        }
    }

    @Override
    public boolean isLossless() {
        return true;
    }

    @Override
    public boolean preservesOrder(Condition cond) {
        switch (cond) {
            case GE:
            case GT:
            case LE:
            case LT:
                return false;
            default:
                return true;
        }
    }

    @Override
    public ValueNode canonical(CanonicalizerTool tool, ValueNode forValue) {
        ValueNode ret = super.canonical(tool, forValue);
        if (ret != this) {
            return ret;
        }

        if (forValue instanceof ZeroExtendNode) {
            // xxxx -(zero-extend)-> 0000 xxxx -(zero-extend)-> 00000000 0000xxxx
            // ==> xxxx -(zero-extend)-> 00000000 0000xxxx
            ZeroExtendNode other = (ZeroExtendNode) forValue;
            return new ZeroExtendNode(other.getValue(), other.getInputBits(), getResultBits());
        }
        if (forValue instanceof NarrowNode) {
            NarrowNode narrow = (NarrowNode) forValue;
            Stamp inputStamp = narrow.getValue().stamp();
            if (inputStamp instanceof IntegerStamp && inputStamp.isCompatible(stamp())) {
                IntegerStamp istamp = (IntegerStamp) inputStamp;
                long mask = CodeUtil.mask(PrimitiveStamp.getBits(narrow.stamp()));
                if (((istamp.upMask() | istamp.downMask()) & ~mask) == 0) {
                    // The original value is in the range of the masked zero extended result so
                    // simply return the original input.
                    return narrow.getValue();
                }
            }
        }

        return this;
    }

    @Override
    public void generate(NodeMappableLIRBuilder builder, ArithmeticLIRGenerator gen) {
        builder.setResult(this, gen.emitZeroExtend(builder.operand(getValue()), getInputBits(), getResultBits()));
    }
}
