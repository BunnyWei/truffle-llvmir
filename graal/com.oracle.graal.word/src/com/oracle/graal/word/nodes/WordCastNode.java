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
package com.oracle.graal.word.nodes;

import com.oracle.graal.api.meta.*;
import com.oracle.graal.compiler.common.type.*;
import com.oracle.graal.graph.*;
import com.oracle.graal.graph.spi.*;
import com.oracle.graal.nodeinfo.*;
import com.oracle.graal.nodes.*;
import com.oracle.graal.nodes.spi.*;
import com.oracle.graal.word.phases.*;

/**
 * Cast between Word and Object that is introduced by the {@link WordTypeRewriterPhase}. It has an
 * impact on the pointer maps for the GC, so it must not be scheduled or optimized away.
 */
@NodeInfo
public final class WordCastNode extends FixedWithNextNode implements LIRLowerable, Canonicalizable {

    public static final NodeClass<WordCastNode> TYPE = NodeClass.create(WordCastNode.class);
    @Input ValueNode input;

    public static WordCastNode wordToObject(ValueNode input, Kind wordKind) {
        assert input.getKind() == wordKind;
        return new WordCastNode(StampFactory.object(), input);
    }

    public static WordCastNode objectToWord(ValueNode input, Kind wordKind) {
        assert input.stamp() instanceof ObjectStamp;
        return new WordCastNode(StampFactory.forKind(wordKind), input);
    }

    public WordCastNode(Stamp stamp, ValueNode input) {
        super(TYPE, stamp);
        this.input = input;
    }

    public ValueNode getInput() {
        return input;
    }

    @Override
    public Node canonical(CanonicalizerTool tool) {
        if (getUsageCount() == 0) {
            /* If the cast is unused, it can be eliminated. */
            return input;
        }

        assert !stamp().isCompatible(input.stamp());
        if (input.isConstant()) {
            /* Null pointers are uncritical for GC, so they can be constant folded. */
            if (input.asJavaConstant().isNull()) {
                return ConstantNode.forIntegerStamp(stamp(), 0);
            } else if (input.asJavaConstant().getKind().isNumericInteger() && input.asJavaConstant().asLong() == 0) {
                return ConstantNode.forConstant(stamp(), JavaConstant.NULL_POINTER, tool.getMetaAccess());
            }
        }

        return this;
    }

    @Override
    public void generate(NodeLIRBuilderTool generator) {
        Value value = generator.operand(input);
        LIRKind kind = generator.getLIRGeneratorTool().getLIRKind(stamp());
        assert generator.getLIRGeneratorTool().target().getSizeInBytes(kind.getPlatformKind()) == generator.getLIRGeneratorTool().target().getSizeInBytes(value.getPlatformKind());

        if (kind.isValue() && !value.getLIRKind().isValue()) {
            // only add reference information, but never drop it
            kind = value.getLIRKind().changeType(kind.getPlatformKind());
        }

        if (kind.equals(value.getLIRKind())) {
            generator.setResult(this, value);
        } else {
            AllocatableValue result = generator.getLIRGeneratorTool().newVariable(kind);
            generator.getLIRGeneratorTool().emitMove(result, value);
            generator.setResult(this, result);
        }
    }
}
