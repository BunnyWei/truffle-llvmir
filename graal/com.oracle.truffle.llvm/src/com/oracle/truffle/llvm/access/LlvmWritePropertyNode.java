/*
 * Copyright (c) 2013, 2014, Oracle and/or its affiliates. All rights reserved.
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
package com.oracle.truffle.llvm.access;

import com.oracle.truffle.api.frame.*;

import com.oracle.truffle.api.nodes.*;
import com.oracle.truffle.api.source.*;
import com.oracle.truffle.api.utilities.*;
import com.oracle.truffle.llvm.*;
import com.oracle.truffle.llvm.nodes.*;
import com.oracle.truffle.llvm.runtime.*;

/**
 * The node for setting a property of an object. When executed, this node first evaluates the value
 * expression on the right hand side of the equals operator, followed by the object expression on
 * the left side of the dot operator, and then sets the named property of this object to the new
 * value if the property already exists or adds a new property. Finally, it returns the new value.
 */
@NodeInfo(shortName = ".=")
public final class LlvmWritePropertyNode extends LlvmExpressionNode {

    public static LlvmWritePropertyNode create(SourceSection src, LlvmExpressionNode receiverNode, String propertyName, LlvmExpressionNode valueNode) {
        return new LlvmWritePropertyNode(src, receiverNode, propertyName, valueNode);
    }

    @Child protected LlvmExpressionNode receiverNode;
    protected final String propertyName;
    @Child protected LlvmExpressionNode valueNode;
    @Child protected LlvmWritePropertyCacheNode cacheNode;
    private final ConditionProfile receiverTypeCondition = ConditionProfile.createBinaryProfile();

    private LlvmWritePropertyNode(SourceSection src, LlvmExpressionNode receiverNode, String propertyName, LlvmExpressionNode valueNode) {
        super(src);
        this.receiverNode = receiverNode;
        this.propertyName = propertyName;
        this.valueNode = valueNode;
        this.cacheNode = LlvmWritePropertyCacheNode.create(propertyName);
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        Object value = valueNode.executeGeneric(frame);
        Object object = receiverNode.executeGeneric(frame);
        if (receiverTypeCondition.profile(LlvmContext.isLlvmObject(object))) {
            cacheNode.executeObject(LlvmContext.castLlvmObject(object), value);
        } else {
            System.out.println("unexpected receiver type");
            return null;
            // throw new LlvmException("unexpected receiver type");
        }
        return value;
    }
}
