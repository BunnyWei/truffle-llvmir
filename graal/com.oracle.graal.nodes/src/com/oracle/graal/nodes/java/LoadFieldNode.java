/*
 * Copyright (c) 2009, 2015, Oracle and/or its affiliates. All rights reserved.
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
package com.oracle.graal.nodes.java;

import static com.oracle.graal.graph.iterators.NodePredicates.*;

import com.oracle.graal.api.meta.*;
import com.oracle.graal.compiler.common.type.*;
import com.oracle.graal.graph.*;
import com.oracle.graal.graph.spi.*;
import com.oracle.graal.nodeinfo.*;
import com.oracle.graal.nodes.*;
import com.oracle.graal.nodes.spi.*;
import com.oracle.graal.nodes.type.*;
import com.oracle.graal.nodes.virtual.*;

/**
 * The {@code LoadFieldNode} represents a read of a static or instance field.
 */
@NodeInfo(nameTemplate = "LoadField#{p#field/s}")
public final class LoadFieldNode extends AccessFieldNode implements Canonicalizable.Unary<ValueNode>, VirtualizableRoot, UncheckedInterfaceProvider {

    public static final NodeClass<LoadFieldNode> TYPE = NodeClass.create(LoadFieldNode.class);

    public LoadFieldNode(ValueNode object, ResolvedJavaField field) {
        super(TYPE, createStamp(field), object, field);
    }

    public ValueNode getValue() {
        return object();
    }

    private static Stamp createStamp(ResolvedJavaField field) {
        Kind kind = field.getKind();
        if (kind == Kind.Object && field.getType() instanceof ResolvedJavaType) {
            return StampFactory.declared((ResolvedJavaType) field.getType());
        } else {
            return StampFactory.forKind(kind);
        }
    }

    public ValueNode canonical(CanonicalizerTool tool, ValueNode forObject) {
        if (hasNoUsages() && !isVolatile() && (isStatic() || StampTool.isPointerNonNull(forObject.stamp()))) {
            return null;
        }
        MetaAccessProvider metaAccess = tool.getMetaAccess();
        ConstantReflectionProvider constantReflection = tool.getConstantReflection();
        if (tool.canonicalizeReads() && metaAccess != null) {
            ConstantNode constant = asConstant(metaAccess, constantReflection, forObject);
            if (constant != null) {
                return constant;
            }
            PhiNode phi = asPhi(metaAccess, constantReflection, forObject);
            if (phi != null) {
                return phi;
            }
        }
        if (!isStatic() && forObject.isNullConstant()) {
            return new DeoptimizeNode(DeoptimizationAction.None, DeoptimizationReason.NullCheckException);
        }
        return this;
    }

    /**
     * Gets a constant value for this load if possible.
     */
    public ConstantNode asConstant(MetaAccessProvider metaAccess, ConstantReflectionProvider constantReflection, ValueNode forObject) {
        JavaConstant constant = null;
        if (isStatic()) {
            constant = constantReflection.readConstantFieldValue(field(), null);
        } else if (forObject.isConstant() && !forObject.isNullConstant()) {
            constant = constantReflection.readConstantFieldValue(field(), forObject.asJavaConstant());
        }
        if (constant != null) {
            return ConstantNode.forConstant(constant, metaAccess);
        }
        return null;
    }

    private PhiNode asPhi(MetaAccessProvider metaAccess, ConstantReflectionProvider constantReflection, ValueNode forObject) {
        if (!isStatic() && field.isFinal() && forObject instanceof ValuePhiNode && ((ValuePhiNode) forObject).values().filter(isNotA(ConstantNode.class)).isEmpty()) {
            PhiNode phi = (PhiNode) forObject;
            JavaConstant[] constants = new JavaConstant[phi.valueCount()];
            for (int i = 0; i < phi.valueCount(); i++) {
                JavaConstant constantValue = constantReflection.readConstantFieldValue(field(), phi.valueAt(i).asJavaConstant());
                if (constantValue == null) {
                    return null;
                }
                constants[i] = constantValue;
            }
            ConstantNode[] constantNodes = new ConstantNode[phi.valueCount()];
            for (int i = 0; i < phi.valueCount(); i++) {
                constantNodes[i] = ConstantNode.forConstant(constants[i], metaAccess);
            }
            return new ValuePhiNode(stamp(), phi.merge(), constantNodes);
        }
        return null;
    }

    @Override
    public void virtualize(VirtualizerTool tool) {
        State state = tool.getObjectState(object());
        if (state != null && state.getState() == EscapeState.Virtual) {
            int fieldIndex = ((VirtualInstanceNode) state.getVirtualObject()).fieldIndex(field());
            if (fieldIndex != -1) {
                tool.replaceWith(state.getEntry(fieldIndex));
            }
        }
    }

    public Stamp uncheckedStamp() {
        return UncheckedInterfaceProvider.uncheckedOrNull(field().getType(), stamp());
    }
}
