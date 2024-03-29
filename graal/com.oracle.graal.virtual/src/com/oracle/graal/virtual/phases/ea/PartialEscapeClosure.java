/*
 * Copyright (c) 2011, 2014, Oracle and/or its affiliates. All rights reserved.
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
package com.oracle.graal.virtual.phases.ea;

import java.util.*;

import com.oracle.graal.api.meta.*;
import com.oracle.graal.compiler.common.*;
import com.oracle.graal.compiler.common.type.*;
import com.oracle.graal.compiler.common.util.*;
import com.oracle.graal.debug.*;
import com.oracle.graal.graph.*;
import com.oracle.graal.nodes.*;
import com.oracle.graal.nodes.VirtualState.NodeClosure;
import com.oracle.graal.nodes.cfg.*;
import com.oracle.graal.nodes.extended.*;
import com.oracle.graal.nodes.spi.*;
import com.oracle.graal.nodes.spi.Virtualizable.EscapeState;
import com.oracle.graal.nodes.virtual.*;
import com.oracle.graal.phases.schedule.*;

public abstract class PartialEscapeClosure<BlockT extends PartialEscapeBlockState<BlockT>> extends EffectsClosure<BlockT> {

    public static final DebugMetric METRIC_MATERIALIZATIONS = Debug.metric("Materializations");
    public static final DebugMetric METRIC_MATERIALIZATIONS_PHI = Debug.metric("MaterializationsPhi");
    public static final DebugMetric METRIC_MATERIALIZATIONS_MERGE = Debug.metric("MaterializationsMerge");
    public static final DebugMetric METRIC_MATERIALIZATIONS_UNHANDLED = Debug.metric("MaterializationsUnhandled");
    public static final DebugMetric METRIC_MATERIALIZATIONS_LOOP_REITERATION = Debug.metric("MaterializationsLoopReiteration");
    public static final DebugMetric METRIC_MATERIALIZATIONS_LOOP_END = Debug.metric("MaterializationsLoopEnd");
    public static final DebugMetric METRIC_ALLOCATION_REMOVED = Debug.metric("AllocationsRemoved");

    public static final DebugMetric METRIC_MEMORYCHECKPOINT = Debug.metric("MemoryCheckpoint");

    private final NodeBitMap usages;
    private final VirtualizerToolImpl tool;

    private final class CollectVirtualObjectsClosure extends NodeClosure<ValueNode> {
        private final Set<ObjectState> virtual;
        private final GraphEffectList effects;
        private final BlockT state;

        private CollectVirtualObjectsClosure(Set<ObjectState> virtual, GraphEffectList effects, BlockT state) {
            this.virtual = virtual;
            this.effects = effects;
            this.state = state;
        }

        @Override
        public void apply(Node usage, ValueNode value) {
            ObjectState valueObj = getObjectState(state, value);
            if (valueObj != null) {
                virtual.add(valueObj);
                effects.replaceFirstInput(usage, value, valueObj.virtual);
            } else if (value instanceof VirtualObjectNode) {
                ObjectState virtualObj = null;
                for (ObjectState obj : state.getStates()) {
                    if (value == obj.virtual) {
                        virtualObj = obj;
                        break;
                    }
                }
                if (virtualObj != null) {
                    virtual.add(virtualObj);
                }
            }
        }
    }

    /**
     * Final subclass of PartialEscapeClosure, for performance and to make everything behave nicely
     * with generics.
     */
    public static final class Final extends PartialEscapeClosure<PartialEscapeBlockState.Final> {

        public Final(SchedulePhase schedule, MetaAccessProvider metaAccess, ConstantReflectionProvider constantReflection) {
            super(schedule, metaAccess, constantReflection);
        }

        @Override
        protected PartialEscapeBlockState.Final getInitialState() {
            return new PartialEscapeBlockState.Final();
        }

        @Override
        protected PartialEscapeBlockState.Final cloneState(PartialEscapeBlockState.Final oldState) {
            return new PartialEscapeBlockState.Final(oldState);
        }
    }

    public PartialEscapeClosure(SchedulePhase schedule, MetaAccessProvider metaAccess, ConstantReflectionProvider constantReflection) {
        super(schedule, schedule.getCFG());
        this.usages = schedule.getCFG().graph.createNodeBitMap();
        this.tool = new VirtualizerToolImpl(metaAccess, constantReflection, this);
    }

    /**
     * @return true if the node was deleted, false otherwise
     */
    @Override
    protected boolean processNode(Node node, BlockT state, GraphEffectList effects, FixedWithNextNode lastFixedNode) {
        boolean isMarked = usages.isMarked(node);
        if (isMarked || node instanceof VirtualizableRoot) {
            VirtualUtil.trace("[[%s]] ", node);
            FixedNode nextFixedNode = lastFixedNode == null ? null : lastFixedNode.next();
            return processNode((ValueNode) node, nextFixedNode, state, effects, isMarked);
        } else {
            VirtualUtil.trace("%s ", node);
            return false;
        }
    }

    private boolean processNode(final ValueNode node, FixedNode insertBefore, final BlockT state, final GraphEffectList effects, boolean isMarked) {
        tool.reset(state, node, insertBefore, effects);
        if (node instanceof Virtualizable) {
            ((Virtualizable) node).virtualize(tool);
        }
        if (tool.isDeleted()) {
            return !(node instanceof CommitAllocationNode || node instanceof AllocatedObjectNode || node instanceof BoxNode);
        }
        if (isMarked) {
            for (Node input : node.inputs()) {
                if (input instanceof ValueNode) {
                    ObjectState obj = getObjectState(state, (ValueNode) input);
                    if (obj != null) {
                        VirtualUtil.trace("replacing input %s at %s: %s", input, node, obj);
                        replaceWithMaterialized(input, node, insertBefore, state, obj, effects, METRIC_MATERIALIZATIONS_UNHANDLED);
                    }
                }
            }
            if (node instanceof NodeWithState) {
                processNodeWithState((NodeWithState) node, state, effects);
            }
        }
        return false;
    }

    private void processNodeWithState(NodeWithState nodeWithState, final BlockT state, final GraphEffectList effects) {
        for (FrameState fs : nodeWithState.states()) {
            FrameState frameState = getUniqueFramestate(nodeWithState, fs);
            Set<ObjectState> virtual = new ArraySet<>();
            frameState.applyToNonVirtual(new CollectVirtualObjectsClosure(virtual, effects, state));
            collectLockedVirtualObjects(state, virtual);
            collectReferencedVirtualObjects(state, virtual);
            addVirtualMappings(effects, frameState, virtual);
        }
    }

    private static FrameState getUniqueFramestate(NodeWithState nodeWithState, FrameState frameState) {
        if (frameState.getUsageCount() > 1) {
            // Can happen for example from inlined snippets with multiple state split nodes.
            FrameState copy = (FrameState) frameState.copyWithInputs();
            nodeWithState.asNode().replaceFirstInput(frameState, copy);
            return copy;
        }
        return frameState;
    }

    private static void addVirtualMappings(GraphEffectList effects, FrameState frameState, Set<ObjectState> virtual) {
        for (ObjectState obj : virtual) {
            effects.addVirtualMapping(frameState, obj.createEscapeObjectState());
        }
    }

    private void collectReferencedVirtualObjects(final BlockT state, final Set<ObjectState> virtual) {
        ArrayDeque<ObjectState> queue = new ArrayDeque<>(virtual);
        while (!queue.isEmpty()) {
            ObjectState obj = queue.removeLast();
            if (obj.isVirtual()) {
                for (ValueNode entry : obj.getEntries()) {
                    if (entry instanceof VirtualObjectNode) {
                        ObjectState fieldObj = state.getObjectState((VirtualObjectNode) entry);
                        if (fieldObj.isVirtual() && !virtual.contains(fieldObj)) {
                            virtual.add(fieldObj);
                            queue.addLast(fieldObj);
                        }
                    }
                }
            }
        }
    }

    private void collectLockedVirtualObjects(final BlockT state, Set<ObjectState> virtual) {
        for (ObjectState obj : state.getStates()) {
            if (obj.isVirtual() && obj.hasLocks()) {
                virtual.add(obj);
            }
        }
    }

    /**
     * @return true if materialization happened, false if not.
     */
    private boolean ensureMaterialized(BlockT state, ObjectState obj, FixedNode materializeBefore, GraphEffectList effects, DebugMetric metric) {
        assert obj != null;
        if (obj.getState() == EscapeState.Virtual) {
            metric.increment();
            state.materializeBefore(materializeBefore, obj.virtual, EscapeState.Materialized, effects);
            updateStatesForMaterialized(state, obj);
            assert !obj.isVirtual();
            return true;
        } else {
            assert obj.getState() == EscapeState.Materialized;
            return false;
        }
    }

    public static void updateStatesForMaterialized(PartialEscapeBlockState<?> state, ObjectState obj) {
        // update all existing states with the newly materialized object
        for (ObjectState objState : state.objectStates.values()) {
            if (objState.isVirtual()) {
                ValueNode[] entries = objState.getEntries();
                for (int i = 0; i < entries.length; i++) {
                    if (entries[i] == obj.virtual) {
                        objState.setEntry(i, obj.getMaterializedValue());
                    }
                }
            }
        }
    }

    private boolean replaceWithMaterialized(Node value, Node usage, FixedNode materializeBefore, BlockT state, ObjectState obj, GraphEffectList effects, DebugMetric metric) {
        boolean materialized = ensureMaterialized(state, obj, materializeBefore, effects, metric);
        effects.replaceFirstInput(usage, value, obj.getMaterializedValue());
        return materialized;
    }

    @Override
    protected void processLoopExit(LoopExitNode exitNode, BlockT initialState, BlockT exitState, GraphEffectList effects) {
        if (exitNode.graph().hasValueProxies()) {
            Map<VirtualObjectNode, ProxyNode> proxies = Node.newMap();
            for (ProxyNode proxy : exitNode.proxies()) {
                ObjectState obj = getObjectState(exitState, proxy.value());
                if (obj != null) {
                    proxies.put(obj.virtual, proxy);
                }
            }
            for (ObjectState obj : exitState.getStates()) {
                ObjectState initialObj = initialState.getObjectStateOptional(obj.virtual);
                if (obj.isVirtual()) {
                    processVirtualAtLoopExit(exitNode, effects, obj, initialObj);
                } else {
                    processMaterializedAtLoopExit(exitNode, effects, proxies, obj, initialObj);
                }
            }
        }
    }

    private static void processMaterializedAtLoopExit(LoopExitNode exitNode, GraphEffectList effects, Map<VirtualObjectNode, ProxyNode> proxies, ObjectState obj, ObjectState initialObj) {
        if (initialObj == null || initialObj.isVirtual()) {
            ProxyNode proxy = proxies.get(obj.virtual);
            if (proxy == null) {
                proxy = new ValueProxyNode(obj.getMaterializedValue(), exitNode);
                effects.addFloatingNode(proxy, "proxy");
            } else {
                effects.replaceFirstInput(proxy, proxy.value(), obj.getMaterializedValue());
                // nothing to do - will be handled in processNode
            }
            obj.updateMaterializedValue(proxy);
        } else {
            if (initialObj.getMaterializedValue() == obj.getMaterializedValue()) {
                Debug.log("materialized value changes within loop: %s vs. %s at %s", initialObj.getMaterializedValue(), obj.getMaterializedValue(), exitNode);
            }
        }
    }

    private static void processVirtualAtLoopExit(LoopExitNode exitNode, GraphEffectList effects, ObjectState obj, ObjectState initialObj) {
        for (int i = 0; i < obj.getEntries().length; i++) {
            ValueNode value = obj.getEntry(i);
            if (!(value instanceof VirtualObjectNode || value.isConstant())) {
                if (exitNode.loopBegin().isPhiAtMerge(value) || initialObj == null || !initialObj.isVirtual() || initialObj.getEntry(i) != value) {
                    ProxyNode proxy = new ValueProxyNode(value, exitNode);
                    obj.setEntry(i, proxy);
                    effects.addFloatingNode(proxy, "virtualProxy");
                }
            }
        }
    }

    @Override
    protected MergeProcessor createMergeProcessor(Block merge) {
        return new MergeProcessor(merge);
    }

    protected class MergeProcessor extends EffectsClosure<BlockT>.MergeProcessor {

        private HashMap<Object, ValuePhiNode> materializedPhis;
        private Map<ValueNode, ValuePhiNode[]> valuePhis;
        private Map<ValuePhiNode, VirtualObjectNode> valueObjectVirtuals;
        private final boolean needsCaching;

        public MergeProcessor(Block mergeBlock) {
            super(mergeBlock);
            needsCaching = mergeBlock.isLoopHeader();
        }

        protected <T> PhiNode getPhi(T virtual, Stamp stamp) {
            if (needsCaching) {
                return getPhiCached(virtual, stamp);
            } else {
                return new ValuePhiNode(stamp, merge);
            }
        }

        private <T> PhiNode getPhiCached(T virtual, Stamp stamp) {
            if (materializedPhis == null) {
                materializedPhis = CollectionsFactory.newMap();
            }
            ValuePhiNode result = materializedPhis.get(virtual);
            if (result == null) {
                result = new ValuePhiNode(stamp, merge);
                materializedPhis.put(virtual, result);
            }
            return result;
        }

        private PhiNode[] getValuePhis(ValueNode key, int entryCount) {
            if (needsCaching) {
                return getValuePhisCached(key, entryCount);
            } else {
                return new ValuePhiNode[entryCount];
            }
        }

        private PhiNode[] getValuePhisCached(ValueNode key, int entryCount) {
            if (valuePhis == null) {
                valuePhis = Node.newIdentityMap();
            }
            ValuePhiNode[] result = valuePhis.get(key);
            if (result == null) {
                result = new ValuePhiNode[entryCount];
                valuePhis.put(key, result);
            }
            assert result.length == entryCount;
            return result;
        }

        private VirtualObjectNode getValueObjectVirtual(ValuePhiNode phi, VirtualObjectNode virtual) {
            if (needsCaching) {
                return getValueObjectVirtualCached(phi, virtual);
            } else {
                return virtual.duplicate();
            }
        }

        private VirtualObjectNode getValueObjectVirtualCached(ValuePhiNode phi, VirtualObjectNode virtual) {
            if (valueObjectVirtuals == null) {
                valueObjectVirtuals = Node.newIdentityMap();
            }
            VirtualObjectNode result = valueObjectVirtuals.get(phi);
            if (result == null) {
                result = virtual.duplicate();
                valueObjectVirtuals.put(phi, result);
            }
            return result;
        }

        /**
         * Merge all predecessor block states into one block state. This is an iterative process,
         * because merging states can lead to materializations which make previous parts of the
         * merging operation invalid. The merging process is executed until a stable state has been
         * reached. This method needs to be careful to place the effects of the merging operation
         * into the correct blocks.
         *
         * @param states the predecessor block states of the merge
         */
        @Override
        protected void merge(List<BlockT> states) {
            super.merge(states);

            // calculate the set of virtual objects that exist in all predecessors
            Set<VirtualObjectNode> virtualObjTemp = intersectVirtualObjects(states);

            ObjectState[] objStates = new ObjectState[states.size()];
            boolean materialized;
            do {
                materialized = false;
                for (VirtualObjectNode object : virtualObjTemp) {
                    for (int i = 0; i < objStates.length; i++) {
                        objStates[i] = states.get(i).getObjectState(object);
                    }

                    // determine if all inputs are virtual or the same materialized value
                    int virtual = 0;
                    ObjectState startObj = objStates[0];
                    boolean locksMatch = true;
                    ValueNode uniqueMaterializedValue = startObj.isVirtual() ? null : startObj.getMaterializedValue();
                    for (ObjectState obj : objStates) {
                        if (obj.isVirtual()) {
                            virtual++;
                            uniqueMaterializedValue = null;
                            locksMatch &= obj.locksEqual(startObj);
                        } else if (obj.getMaterializedValue() != uniqueMaterializedValue) {
                            uniqueMaterializedValue = null;
                        }
                    }

                    if (virtual == objStates.length && locksMatch) {
                        materialized |= mergeObjectStates(object, objStates, states);
                    } else {
                        if (uniqueMaterializedValue != null) {
                            newState.addObject(object, new ObjectState(object, uniqueMaterializedValue, EscapeState.Materialized, null));
                        } else {
                            PhiNode materializedValuePhi = getPhi(object, StampFactory.forKind(Kind.Object));
                            mergeEffects.addFloatingNode(materializedValuePhi, "materializedPhi");
                            for (int i = 0; i < objStates.length; i++) {
                                ObjectState obj = objStates[i];
                                if (obj.isVirtual()) {
                                    Block predecessor = mergeBlock.getPredecessors().get(i);
                                    materialized |= ensureMaterialized(states.get(i), obj, predecessor.getEndNode(), blockEffects.get(predecessor), METRIC_MATERIALIZATIONS_MERGE);
                                }
                                afterMergeEffects.addPhiInput(materializedValuePhi, obj.getMaterializedValue());
                            }
                            newState.addObject(object, new ObjectState(object, materializedValuePhi, EscapeState.Materialized, null));
                        }
                    }
                }

                for (PhiNode phi : merge.phis()) {
                    if (usages.isMarked(phi) && phi instanceof ValuePhiNode) {
                        materialized |= processPhi((ValuePhiNode) phi, states, virtualObjTemp);
                    }
                }
                if (materialized) {
                    newState.objectStates.clear();
                    mergeEffects.clear();
                    afterMergeEffects.clear();
                }
            } while (materialized);
        }

        private Set<VirtualObjectNode> intersectVirtualObjects(List<BlockT> states) {
            Set<VirtualObjectNode> virtualObjTemp = Node.newSet(states.get(0).getVirtualObjects());
            for (int i = 1; i < states.size(); i++) {
                virtualObjTemp.retainAll(states.get(i).getVirtualObjects());
            }
            return virtualObjTemp;
        }

        /**
         * Try to merge multiple virtual object states into a single object state. If the incoming
         * object states are compatible, then this method will create PhiNodes for the object's
         * entries where needed. If they are incompatible, then all incoming virtual objects will be
         * materialized, and a PhiNode for the materialized values will be created. Object states
         * can be incompatible if they contain {@code long} or {@code double} values occupying two
         * {@code int} slots in such a way that that their values cannot be merged using PhiNodes.
         *
         * @param object the virtual object that should be associated with the merged object state
         * @param objStates the incoming object states (all of which need to be virtual)
         * @param blockStates the predecessor block states of the merge
         * @return true if materialization happened during the merge, false otherwise
         */
        private boolean mergeObjectStates(VirtualObjectNode object, ObjectState[] objStates, List<BlockT> blockStates) {
            boolean compatible = true;
            ValueNode[] values = objStates[0].getEntries().clone();

            // determine all entries that have a two-slot value
            Kind[] twoSlotKinds = null;
            outer: for (int i = 0; i < objStates.length; i++) {
                ValueNode[] entries = objStates[i].getEntries();
                int valueIndex = 0;
                while (valueIndex < values.length) {
                    Kind otherKind = entries[valueIndex].getKind();
                    Kind entryKind = object.entryKind(valueIndex);
                    if (entryKind == Kind.Int && otherKind.needsTwoSlots()) {
                        if (twoSlotKinds == null) {
                            twoSlotKinds = new Kind[values.length];
                        }
                        if (twoSlotKinds[valueIndex] != null && twoSlotKinds[valueIndex] != otherKind) {
                            compatible = false;
                            break outer;
                        }
                        twoSlotKinds[valueIndex] = otherKind;
                        // skip the next entry
                        valueIndex++;
                    } else {
                        assert entryKind.getStackKind() == otherKind.getStackKind() || (entryKind == Kind.Int && otherKind == Kind.Illegal) || entryKind.getBitCount() >= otherKind.getBitCount() : entryKind +
                                        " vs " + otherKind;
                    }
                    valueIndex++;
                }
            }
            if (compatible && twoSlotKinds != null) {
                // if there are two-slot values then make sure the incoming states can be merged
                outer: for (int valueIndex = 0; valueIndex < values.length; valueIndex++) {
                    if (twoSlotKinds[valueIndex] != null) {
                        assert valueIndex < object.entryCount() - 1 && object.entryKind(valueIndex) == Kind.Int && object.entryKind(valueIndex + 1) == Kind.Int;
                        for (int i = 0; i < objStates.length; i++) {
                            ValueNode value = objStates[i].getEntry(valueIndex);
                            Kind valueKind = value.getKind();
                            if (valueKind != twoSlotKinds[valueIndex]) {
                                ValueNode nextValue = objStates[i].getEntry(valueIndex + 1);
                                if (value.isConstant() && value.asConstant().equals(JavaConstant.INT_0) && nextValue.isConstant() && nextValue.asConstant().equals(JavaConstant.INT_0)) {
                                    // rewrite to a zero constant of the larger kind
                                    objStates[i].setEntry(valueIndex, ConstantNode.defaultForKind(twoSlotKinds[valueIndex], merge.graph()));
                                    objStates[i].setEntry(valueIndex + 1, ConstantNode.forConstant(JavaConstant.forIllegal(), tool.getMetaAccessProvider(), merge.graph()));
                                } else {
                                    compatible = false;
                                    break outer;
                                }
                            }
                        }
                    }
                }
            }

            if (compatible) {
                // virtual objects are compatible: create phis for all entries that need them
                PhiNode[] phis = getValuePhis(object, object.entryCount());
                int valueIndex = 0;
                while (valueIndex < values.length) {
                    for (int i = 1; i < objStates.length; i++) {
                        ValueNode field = objStates[i].getEntry(valueIndex);
                        if (phis[valueIndex] == null && values[valueIndex] != field) {
                            phis[valueIndex] = new ValuePhiNode(values[valueIndex].stamp().unrestricted(), merge);
                        }
                    }
                    if (phis[valueIndex] != null && !phis[valueIndex].stamp().isCompatible(values[valueIndex].stamp())) {
                        phis[valueIndex] = new ValuePhiNode(values[valueIndex].stamp().unrestricted(), merge);
                    }
                    if (twoSlotKinds != null && twoSlotKinds[valueIndex] != null) {
                        // skip an entry after a long/double value that occupies two int slots
                        valueIndex++;
                        phis[valueIndex] = null;
                        values[valueIndex] = ConstantNode.forConstant(JavaConstant.forIllegal(), tool.getMetaAccessProvider(), merge.graph());
                    }
                    valueIndex++;
                }

                boolean materialized = false;
                for (int i = 0; i < values.length; i++) {
                    PhiNode phi = phis[i];
                    if (phi != null) {
                        mergeEffects.addFloatingNode(phi, "virtualMergePhi");
                        if (object.entryKind(i) == Kind.Object) {
                            materialized |= mergeObjectEntry(objStates, blockStates, phi, i);
                        } else {
                            mergePrimitiveEntry(objStates, phi, i);
                        }
                        values[i] = phi;
                    }
                }
                newState.addObject(object, new ObjectState(object, values, EscapeState.Virtual, objStates[0].getLocks()));
                return materialized;
            } else {
                // not compatible: materialize in all predecessors
                PhiNode materializedValuePhi = getPhi(object, StampFactory.forKind(Kind.Object));
                for (int i = 0; i < blockStates.size(); i++) {
                    ObjectState obj = objStates[i];
                    Block predecessor = mergeBlock.getPredecessors().get(i);
                    ensureMaterialized(blockStates.get(i), obj, predecessor.getEndNode(), blockEffects.get(predecessor), METRIC_MATERIALIZATIONS_MERGE);
                    afterMergeEffects.addPhiInput(materializedValuePhi, obj.getMaterializedValue());
                }
                newState.addObject(object, new ObjectState(object, materializedValuePhi, EscapeState.Materialized, null));
                return true;
            }
        }

        /**
         * Fill the inputs of the PhiNode corresponding to one {@link Kind#Object} entry in the
         * virtual object.
         *
         * @return true if materialization happened during the merge, false otherwise
         */
        private boolean mergeObjectEntry(ObjectState[] objStates, List<BlockT> blockStates, PhiNode phi, int entryIndex) {
            boolean materialized = false;
            for (int i = 0; i < objStates.length; i++) {
                if (!objStates[i].isVirtual()) {
                    break;
                }
                ValueNode entry = objStates[i].getEntry(entryIndex);
                if (entry instanceof VirtualObjectNode) {
                    ObjectState obj = blockStates.get(i).getObjectState((VirtualObjectNode) entry);
                    Block predecessor = mergeBlock.getPredecessors().get(i);
                    materialized |= ensureMaterialized(blockStates.get(i), obj, predecessor.getEndNode(), blockEffects.get(predecessor), METRIC_MATERIALIZATIONS_MERGE);
                    if (objStates[i].isVirtual()) {
                        objStates[i].setEntry(entryIndex, entry = obj.getMaterializedValue());
                    }
                }
                afterMergeEffects.addPhiInput(phi, entry);
            }
            return materialized;
        }

        /**
         * Fill the inputs of the PhiNode corresponding to one primitive entry in the virtual
         * object.
         */
        private void mergePrimitiveEntry(ObjectState[] objStates, PhiNode phi, int entryIndex) {
            for (ObjectState state : objStates) {
                if (!state.isVirtual()) {
                    break;
                }
                afterMergeEffects.addPhiInput(phi, state.getEntry(entryIndex));
            }
        }

        /**
         * Examine a PhiNode and try to replace it with merging of virtual objects if all its inputs
         * refer to virtual object states. In order for the merging to happen, all incoming object
         * states need to be compatible and without object identity (meaning that their object
         * identity if not used later on).
         *
         * @param phi the PhiNode that should be processed
         * @param states the predecessor block states of the merge
         * @param mergedVirtualObjects the set of virtual objects that exist in all incoming states,
         *            and therefore also exist in the merged state
         * @return true if materialization happened during the merge, false otherwise
         */
        private boolean processPhi(ValuePhiNode phi, List<BlockT> states, Set<VirtualObjectNode> mergedVirtualObjects) {
            aliases.set(phi, null);
            assert states.size() == phi.valueCount();

            // determine how many inputs are virtual and if they're all the same virtual object
            int virtualInputs = 0;
            ObjectState[] objStates = new ObjectState[states.size()];
            boolean uniqueVirtualObject = true;
            for (int i = 0; i < objStates.length; i++) {
                ObjectState obj = objStates[i] = getObjectState(states.get(i), phi.valueAt(i));
                if (obj != null) {
                    if (obj.isVirtual()) {
                        if (objStates[0] == null || objStates[0].virtual != obj.virtual) {
                            uniqueVirtualObject = false;
                        }
                        virtualInputs++;
                    }
                }
            }
            if (virtualInputs == objStates.length) {
                if (uniqueVirtualObject) {
                    // all inputs refer to the same object: just make the phi node an alias
                    addAndMarkAlias(objStates[0].virtual, phi);
                    mergeEffects.deleteNode(phi);
                    return false;
                } else {
                    // all inputs are virtual: check if they're compatible and without identity
                    boolean compatible = true;
                    boolean hasIdentity = false;
                    ObjectState firstObj = objStates[0];
                    for (int i = 0; i < objStates.length; i++) {
                        ObjectState obj = objStates[i];
                        hasIdentity |= obj.virtual.hasIdentity();
                        boolean identitySurvives = obj.virtual.hasIdentity() && mergedVirtualObjects.contains(obj.virtual);
                        if (identitySurvives || !firstObj.virtual.type().equals(obj.virtual.type()) || firstObj.virtual.entryCount() != obj.virtual.entryCount() || !firstObj.locksEqual(obj)) {
                            compatible = false;
                            break;
                        }
                    }
                    if (compatible && hasIdentity) {
                        // we still need to check whether this value is referenced by any other phi
                        outer: for (PhiNode otherPhi : merge.phis().filter(otherPhi -> otherPhi != phi)) {
                            for (int i = 0; i < objStates.length; i++) {
                                ObjectState otherPhiValueState = getObjectState(states.get(i), otherPhi.valueAt(i));
                                if (Arrays.asList(objStates).contains(otherPhiValueState)) {
                                    compatible = false;
                                    break outer;
                                }
                            }
                        }
                    }

                    if (compatible) {
                        VirtualObjectNode virtual = getValueObjectVirtual(phi, getObjectState(states.get(0), phi.valueAt(0)).virtual);
                        mergeEffects.addFloatingNode(virtual, "valueObjectNode");
                        mergeEffects.deleteNode(phi);

                        boolean materialized = mergeObjectStates(virtual, objStates, states);
                        addAndMarkAlias(virtual, virtual);
                        addAndMarkAlias(virtual, phi);
                        return materialized;
                    }
                }
            }

            // otherwise: materialize all phi inputs
            boolean materialized = false;
            for (int i = 0; i < objStates.length; i++) {
                ObjectState obj = objStates[i];
                if (obj != null) {
                    Block predecessor = mergeBlock.getPredecessors().get(i);
                    materialized |= ensureMaterialized(states.get(i), obj, predecessor.getEndNode(), blockEffects.get(predecessor), METRIC_MATERIALIZATIONS_PHI);
                    afterMergeEffects.initializePhiInput(phi, i, obj.getMaterializedValue());
                }
            }
            return materialized;
        }
    }

    public ObjectState getObjectState(PartialEscapeBlockState<?> state, ValueNode value) {
        if (value == null) {
            return null;
        }
        if (value.isAlive() && !aliases.isNew(value)) {
            ValueNode object = aliases.get(value);
            return object instanceof VirtualObjectNode ? state.getObjectStateOptional((VirtualObjectNode) object) : null;
        } else {
            if (value instanceof VirtualObjectNode) {
                return state.getObjectStateOptional((VirtualObjectNode) value);
            }
            return null;
        }
    }

    void addAndMarkAlias(VirtualObjectNode virtual, ValueNode node) {
        if (node.isAlive()) {
            aliases.set(node, virtual);
            for (Node usage : node.usages()) {
                markVirtualUsages(usage);
            }
        }
    }

    private void markVirtualUsages(Node node) {
        if (!usages.isNew(node)) {
            usages.mark(node);
        }
        if (node instanceof VirtualState) {
            for (Node usage : node.usages()) {
                markVirtualUsages(usage);
            }
        }
    }
}
