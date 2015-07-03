/*
 * Copyright (c) 2012, 2014, Oracle and/or its affiliates. All rights reserved.
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
// CheckStyle: start generated
package com.oracle.truffle.sl.nodes.expression;

import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.source.SourceSection;
import com.oracle.truffle.sl.nodes.SLExpressionNode;

@GeneratedBy(SLLogicalOrNode.class)
public final class SLLogicalOrNodeGen extends SLLogicalOrNode {

    @Child private SLExpressionNode leftNode_;
    @Child private SLExpressionNode rightNode_;
    @CompilationFinal private boolean excludeBoolean_;

    private SLLogicalOrNodeGen(SourceSection src, SLExpressionNode leftNode, SLExpressionNode rightNode) {
        super(src);
        this.leftNode_ = leftNode;
        this.rightNode_ = rightNode;
    }

    @Override
    public boolean executeBoolean(VirtualFrame frameValue) {
        boolean leftNodeValue_;
        try {
            leftNodeValue_ = leftNode_.executeBoolean(frameValue);
        } catch (UnexpectedResultException ex) {
            boolean hasRightNodeValue = this.needsRightNode(ex.getResult());
            Object rightNodeValue = null;
            if (hasRightNodeValue) {
                rightNodeValue = rightNode_.executeGeneric(frameValue);
            }
            throw unsupported(ex.getResult(), hasRightNodeValue, rightNodeValue);
        }
        boolean hasRightNodeValue = this.needsRightNode(leftNodeValue_);
        boolean rightNodeValue_ = false;
        if (hasRightNodeValue) {
            try {
                rightNodeValue_ = rightNode_.executeBoolean(frameValue);
            } catch (UnexpectedResultException ex) {
                throw unsupported(leftNodeValue_, hasRightNodeValue, ex.getResult());
            }
        }
        try {
            return this.doBoolean(leftNodeValue_, hasRightNodeValue, rightNodeValue_);
        } catch (RuntimeException ex) {
            excludeBoolean_ = true;
            throw unsupported(leftNodeValue_, hasRightNodeValue, rightNodeValue_);
        }
    }

    @Override
    public Object executeGeneric(VirtualFrame frameValue) {
        return executeBoolean(frameValue);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        executeBoolean(frameValue);
        return;
    }

    @Override
    public NodeCost getCost() {
        return NodeCost.MONOMORPHIC;
    }

    protected UnsupportedSpecializationException unsupported(Object leftNodeValue, Object hasRightNodeValue, Object rightNodeValue) {
        return new UnsupportedSpecializationException(this, new Node[] {leftNode_, null, rightNode_}, leftNodeValue, hasRightNodeValue, rightNodeValue);
    }

    public static SLLogicalOrNode create(SourceSection src, SLExpressionNode leftNode, SLExpressionNode rightNode) {
        return new SLLogicalOrNodeGen(src, leftNode, rightNode);
    }

}
