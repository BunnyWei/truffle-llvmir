/*
 * Copyright (c) 2011, 2015, Oracle and/or its affiliates. All rights reserved.
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
package com.oracle.graal.nodes;

import java.util.*;

import com.oracle.graal.api.meta.*;
import com.oracle.graal.graph.*;
import com.oracle.graal.nodeinfo.*;
import com.oracle.graal.nodes.extended.*;
import com.oracle.graal.nodes.java.*;
import com.oracle.graal.nodes.spi.*;
import com.oracle.graal.nodes.util.*;

@NodeInfo(nameTemplate = "Invoke!#{p#targetMethod/s}", allowedUsageTypes = {InputType.Memory})
public final class InvokeWithExceptionNode extends ControlSplitNode implements Invoke, MemoryCheckpoint.Single, LIRLowerable {
    public static final NodeClass<InvokeWithExceptionNode> TYPE = NodeClass.create(InvokeWithExceptionNode.class);

    private static final double EXCEPTION_PROBA = 1e-5;

    @Successor AbstractBeginNode next;
    @Successor AbstractBeginNode exceptionEdge;
    @Input(InputType.Extension) CallTargetNode callTarget;
    @OptionalInput(InputType.State) FrameState stateDuring;
    @OptionalInput(InputType.State) FrameState stateAfter;
    @OptionalInput(InputType.Guard) GuardingNode guard;
    protected final int bci;
    protected boolean polymorphic;
    protected boolean useForInlining;
    protected double exceptionProbability;

    public InvokeWithExceptionNode(CallTargetNode callTarget, AbstractBeginNode exceptionEdge, int bci) {
        super(TYPE, callTarget.returnStamp());
        this.exceptionEdge = exceptionEdge;
        this.bci = bci;
        this.callTarget = callTarget;
        this.polymorphic = false;
        this.useForInlining = true;
        this.exceptionProbability = EXCEPTION_PROBA;
    }

    public AbstractBeginNode exceptionEdge() {
        return exceptionEdge;
    }

    public void setExceptionEdge(AbstractBeginNode x) {
        updatePredecessor(exceptionEdge, x);
        exceptionEdge = x;
    }

    public AbstractBeginNode next() {
        return next;
    }

    public void setNext(AbstractBeginNode x) {
        updatePredecessor(next, x);
        next = x;
    }

    public CallTargetNode callTarget() {
        return callTarget;
    }

    public MethodCallTargetNode methodCallTarget() {
        return (MethodCallTargetNode) callTarget;
    }

    @Override
    public boolean isPolymorphic() {
        return polymorphic;
    }

    @Override
    public void setPolymorphic(boolean value) {
        this.polymorphic = value;
    }

    @Override
    public boolean useForInlining() {
        return useForInlining;
    }

    @Override
    public void setUseForInlining(boolean value) {
        this.useForInlining = value;
    }

    @Override
    public String toString(Verbosity verbosity) {
        if (verbosity == Verbosity.Long) {
            return super.toString(Verbosity.Short) + "(bci=" + bci() + ")";
        } else if (verbosity == Verbosity.Name) {
            return "Invoke#" + (callTarget == null ? "null" : callTarget().targetName());
        } else {
            return super.toString(verbosity);
        }
    }

    public int bci() {
        return bci;
    }

    @Override
    public void setNext(FixedNode x) {
        if (x != null) {
            this.setNext(KillingBeginNode.begin(x, getLocationIdentity()));
        } else {
            this.setNext(null);
        }
    }

    @Override
    public void lower(LoweringTool tool) {
        tool.getLowerer().lower(this, tool);
    }

    @Override
    public void generate(NodeLIRBuilderTool gen) {
        gen.emitInvoke(this);
    }

    public FrameState stateAfter() {
        return stateAfter;
    }

    public void setStateAfter(FrameState stateAfter) {
        updateUsages(this.stateAfter, stateAfter);
        this.stateAfter = stateAfter;
    }

    public boolean hasSideEffect() {
        return true;
    }

    @Override
    public LocationIdentity getLocationIdentity() {
        return LocationIdentity.ANY_LOCATION;
    }

    @Override
    public Map<Object, Object> getDebugProperties(Map<Object, Object> map) {
        Map<Object, Object> debugProperties = super.getDebugProperties(map);
        debugProperties.put("targetMethod", callTarget.targetName());
        return debugProperties;
    }

    public void killExceptionEdge() {
        AbstractBeginNode edge = exceptionEdge();
        setExceptionEdge(null);
        GraphUtil.killCFG(edge);
    }

    @Override
    public void intrinsify(Node node) {
        assert !(node instanceof ValueNode) || (((ValueNode) node).getKind() == Kind.Void) == (getKind() == Kind.Void);
        CallTargetNode call = callTarget;
        FrameState state = stateAfter();
        killExceptionEdge();
        if (node instanceof StateSplit) {
            StateSplit stateSplit = (StateSplit) node;
            stateSplit.setStateAfter(state);
        }
        if (node instanceof ForeignCallNode) {
            ForeignCallNode foreign = (ForeignCallNode) node;
            foreign.setBci(bci());
        }
        if (node == null) {
            assert getKind() == Kind.Void && hasNoUsages();
            graph().removeSplit(this, next());
        } else if (node instanceof ControlSinkNode) {
            this.replaceAtPredecessor(node);
            this.replaceAtUsages(null);
            GraphUtil.killCFG(this);
            return;
        } else {
            graph().replaceSplit(this, node, next());
        }
        GraphUtil.killWithUnusedFloatingInputs(call);
        if (state.hasNoUsages()) {
            GraphUtil.killWithUnusedFloatingInputs(state);
        }
    }

    @Override
    public double probability(AbstractBeginNode successor) {
        return successor == next ? 1 - exceptionProbability : exceptionProbability;
    }

    @Override
    public boolean canDeoptimize() {
        return true;
    }

    @Override
    public FrameState stateDuring() {
        return stateDuring;
    }

    @Override
    public void setStateDuring(FrameState stateDuring) {
        updateUsages(this.stateDuring, stateDuring);
        this.stateDuring = stateDuring;
    }

    @Override
    public GuardingNode getGuard() {
        return guard;
    }

    @Override
    public void setGuard(GuardingNode guard) {
        updateUsagesInterface(this.guard, guard);
        this.guard = guard;
    }

    @Override
    public AbstractBeginNode getPrimarySuccessor() {
        return this.next();
    }
}
