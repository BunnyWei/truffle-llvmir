/*
 * Copyright (c) 2009, 2012, Oracle and/or its affiliates. All rights reserved.
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
package com.oracle.graal.nodes.cfg;

import java.util.*;

import com.oracle.graal.compiler.common.cfg.*;
import com.oracle.graal.graph.*;
import com.oracle.graal.nodes.*;

public final class Block extends AbstractBlockBase<Block> {

    protected final AbstractBeginNode beginNode;

    protected FixedNode endNode;

    protected double probability;
    protected Loop<Block> loop;

    protected Block postdominator;
    protected Block distancedDominatorCache;

    protected Block(AbstractBeginNode node) {
        this.beginNode = node;
    }

    public AbstractBeginNode getBeginNode() {
        return beginNode;
    }

    public FixedNode getEndNode() {
        return endNode;
    }

    @Override
    public Loop<Block> getLoop() {
        return loop;
    }

    public void setLoop(Loop<Block> loop) {
        this.loop = loop;
    }

    @Override
    public int getLoopDepth() {
        return loop == null ? 0 : loop.getDepth();
    }

    @Override
    public boolean isLoopHeader() {
        return getBeginNode() instanceof LoopBeginNode;
    }

    @Override
    public boolean isLoopEnd() {
        return getEndNode() instanceof LoopEndNode;
    }

    @Override
    public boolean isExceptionEntry() {
        Node predecessor = getBeginNode().predecessor();
        return predecessor != null && predecessor instanceof InvokeWithExceptionNode && getBeginNode() == ((InvokeWithExceptionNode) predecessor).exceptionEdge();
    }

    public Block getFirstPredecessor() {
        return getPredecessors().get(0);
    }

    public Block getFirstSuccessor() {
        return getSuccessors().get(0);
    }

    public Block getEarliestPostDominated() {
        Block b = this;
        while (true) {
            Block dom = b.getDominator();
            if (dom != null && dom.getPostdominator() == b) {
                b = dom;
            } else {
                break;
            }
        }
        return b;
    }

    @Override
    public Block getPostdominator() {
        return postdominator;
    }

    private class NodeIterator implements Iterator<FixedNode> {

        private FixedNode cur;

        public NodeIterator() {
            cur = getBeginNode();
        }

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public FixedNode next() {
            FixedNode result = cur;
            if (cur == getEndNode()) {
                cur = null;
            } else {
                cur = ((FixedWithNextNode) cur).next();
            }
            assert !(cur instanceof AbstractBeginNode);
            return result;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public Iterable<FixedNode> getNodes() {
        return new Iterable<FixedNode>() {

            @Override
            public Iterator<FixedNode> iterator() {
                return new NodeIterator();
            }

            @Override
            public String toString() {
                StringBuilder str = new StringBuilder().append('[');
                for (FixedNode node : this) {
                    str.append(node).append(", ");
                }
                if (str.length() > 1) {
                    str.setLength(str.length() - 2);
                }
                return str.append(']').toString();
            }
        };
    }

    @Override
    public String toString() {
        return "B" + id;
    }

    @Override
    public double probability() {
        return probability;
    }

    public void setProbability(double probability) {
        assert probability >= 0 && Double.isFinite(probability);
        this.probability = probability;
    }

    @Override
    public Block getDominator(int distance) {
        Block result = this;
        for (int i = 0; i < distance; ++i) {
            result = result.getDominator();
        }
        return result;
    }
}
