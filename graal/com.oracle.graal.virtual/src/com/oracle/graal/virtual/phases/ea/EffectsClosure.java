/*
 * Copyright (c) 2011, 2012, Oracle and/or its affiliates. All rights reserved.
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

import static com.oracle.graal.compiler.common.GraalOptions.*;

import java.util.*;

import com.oracle.graal.compiler.common.*;
import com.oracle.graal.compiler.common.cfg.*;
import com.oracle.graal.debug.*;
import com.oracle.graal.graph.*;
import com.oracle.graal.nodes.*;
import com.oracle.graal.nodes.cfg.*;
import com.oracle.graal.nodes.util.*;
import com.oracle.graal.nodes.virtual.*;
import com.oracle.graal.phases.graph.*;
import com.oracle.graal.phases.graph.ReentrantBlockIterator.BlockIteratorClosure;
import com.oracle.graal.phases.graph.ReentrantBlockIterator.LoopInfo;
import com.oracle.graal.phases.schedule.*;

public abstract class EffectsClosure<BlockT extends EffectsBlockState<BlockT>> extends EffectsPhase.Closure<BlockT> {

    protected final ControlFlowGraph cfg;
    protected final SchedulePhase schedule;

    protected final NodeMap<ValueNode> aliases;
    protected final BlockMap<GraphEffectList> blockEffects;
    private final Map<Loop<Block>, GraphEffectList> loopMergeEffects = CollectionsFactory.newIdentityMap();
    private final Map<LoopBeginNode, BlockT> loopEntryStates = Node.newIdentityMap();

    protected boolean changed;

    public EffectsClosure(SchedulePhase schedule, ControlFlowGraph cfg) {
        this.schedule = schedule;
        this.cfg = cfg;
        this.aliases = cfg.graph.createNodeMap();
        this.blockEffects = new BlockMap<>(cfg);
        for (Block block : cfg.getBlocks()) {
            blockEffects.put(block, new GraphEffectList());
        }
    }

    @Override
    public boolean hasChanged() {
        return changed;
    }

    @Override
    public void applyEffects() {
        final StructuredGraph graph = cfg.graph;
        final ArrayList<Node> obsoleteNodes = new ArrayList<>(0);
        BlockIteratorClosure<Void> closure = new BlockIteratorClosure<Void>() {

            @Override
            protected Void getInitialState() {
                return null;
            }

            private void apply(GraphEffectList effects, Object context) {
                if (!effects.isEmpty()) {
                    Debug.log(" ==== effects for %s", context);
                    effects.apply(graph, obsoleteNodes);
                    if (TraceEscapeAnalysis.getValue()) {
                        Debug.dump(5, graph, "After processing EffectsList for %s", context);
                    }
                }
            }

            @Override
            protected Void processBlock(Block block, Void currentState) {
                apply(blockEffects.get(block), block);
                return currentState;
            }

            @Override
            protected Void merge(Block merge, List<Void> states) {
                return null;
            }

            @Override
            protected Void cloneState(Void oldState) {
                return oldState;
            }

            @Override
            protected List<Void> processLoop(Loop<Block> loop, Void initialState) {
                LoopInfo<Void> info = ReentrantBlockIterator.processLoop(this, loop, initialState);
                apply(loopMergeEffects.get(loop), loop);
                return info.exitStates;
            }
        };
        ReentrantBlockIterator.apply(closure, cfg.getStartBlock());
        assert VirtualUtil.assertNonReachable(graph, obsoleteNodes);
        for (Node node : obsoleteNodes) {
            if (node.isAlive()) {
                node.replaceAtUsages(null);
                GraphUtil.killWithUnusedFloatingInputs(node);
            }
        }
    }

    @Override
    protected BlockT processBlock(Block block, BlockT state) {
        VirtualUtil.trace("\nBlock: %s, preds: %s, succ: %s (", block, block.getPredecessors(), block.getSuccessors());

        GraphEffectList effects = blockEffects.get(block);
        FixedWithNextNode lastFixedNode = block.getBeginNode().predecessor() instanceof FixedWithNextNode ? (FixedWithNextNode) block.getBeginNode().predecessor() : null;
        Iterable<? extends Node> nodes = schedule != null ? schedule.getBlockToNodesMap().get(block) : block.getNodes();
        for (Node node : nodes) {
            aliases.set(node, null);
            if (node instanceof LoopExitNode) {
                LoopExitNode loopExit = (LoopExitNode) node;
                for (ProxyNode proxy : loopExit.proxies()) {
                    changed |= processNode(proxy, state, effects, lastFixedNode);
                }
                processLoopExit(loopExit, loopEntryStates.get(loopExit.loopBegin()), state, blockEffects.get(block));
            }
            changed |= processNode(node, state, effects, lastFixedNode);
            if (node instanceof FixedWithNextNode) {
                lastFixedNode = (FixedWithNextNode) node;
            }
        }
        VirtualUtil.trace(")\n    end state: %s\n", state);
        return state;
    }

    protected abstract boolean processNode(Node node, BlockT state, GraphEffectList effects, FixedWithNextNode lastFixedNode);

    @Override
    protected BlockT merge(Block merge, List<BlockT> states) {
        assert blockEffects.get(merge).isEmpty();
        MergeProcessor processor = createMergeProcessor(merge);
        processor.merge(states);
        processor.commitEnds(states);
        blockEffects.get(merge).addAll(processor.mergeEffects);
        blockEffects.get(merge).addAll(processor.afterMergeEffects);
        return processor.newState;
    }

    @Override
    protected final List<BlockT> processLoop(Loop<Block> loop, BlockT initialState) {
        BlockT loopEntryState = initialState;
        BlockT lastMergedState = cloneState(initialState);
        MergeProcessor mergeProcessor = createMergeProcessor(loop.getHeader());
        for (int iteration = 0; iteration < 10; iteration++) {
            LoopInfo<BlockT> info = ReentrantBlockIterator.processLoop(this, loop, cloneState(lastMergedState));

            List<BlockT> states = new ArrayList<>();
            states.add(initialState);
            states.addAll(info.endStates);
            mergeProcessor.merge(states);

            Debug.log("================== %s", loop.getHeader());
            Debug.log("%s", mergeProcessor.newState);
            Debug.log("===== vs.");
            Debug.log("%s", lastMergedState);

            if (mergeProcessor.newState.equivalentTo(lastMergedState)) {
                mergeProcessor.commitEnds(states);

                blockEffects.get(loop.getHeader()).insertAll(mergeProcessor.mergeEffects, 0);
                loopMergeEffects.put(loop, mergeProcessor.afterMergeEffects);

                assert info.exitStates.size() == loop.getExits().size();
                loopEntryStates.put((LoopBeginNode) loop.getHeader().getBeginNode(), loopEntryState);
                assert assertExitStatesNonEmpty(loop, info);

                return info.exitStates;
            } else {
                lastMergedState = mergeProcessor.newState;
                for (Block block : loop.getBlocks()) {
                    blockEffects.get(block).clear();
                }
            }
        }
        throw new GraalInternalError("too many iterations at %s", loop);
    }

    private boolean assertExitStatesNonEmpty(Loop<Block> loop, LoopInfo<BlockT> info) {
        for (int i = 0; i < loop.getExits().size(); i++) {
            assert info.exitStates.get(i) != null : "no loop exit state at " + loop.getExits().get(i) + " / " + loop.getHeader();
        }
        return true;
    }

    protected abstract void processLoopExit(LoopExitNode exitNode, BlockT initialState, BlockT exitState, GraphEffectList effects);

    protected abstract MergeProcessor createMergeProcessor(Block merge);

    protected class MergeProcessor {

        protected final Block mergeBlock;
        protected final AbstractMergeNode merge;

        protected final GraphEffectList mergeEffects;
        protected final GraphEffectList afterMergeEffects;
        protected BlockT newState;

        public MergeProcessor(Block mergeBlock) {
            this.mergeBlock = mergeBlock;
            this.merge = (AbstractMergeNode) mergeBlock.getBeginNode();
            this.mergeEffects = new GraphEffectList();
            this.afterMergeEffects = new GraphEffectList();
        }

        /**
         * @param states the states that should be merged.
         */
        protected void merge(List<BlockT> states) {
            newState = getInitialState();
            mergeEffects.clear();
            afterMergeEffects.clear();
        }

        @SuppressWarnings("unused")
        protected void commitEnds(List<BlockT> states) {
        }

        @Override
        public String toString() {
            return "MergeProcessor@" + merge;
        }
    }

    public void addScalarAlias(ValueNode node, ValueNode alias) {
        assert !(alias instanceof VirtualObjectNode);
        aliases.set(node, alias);
    }

    public ValueNode getScalarAlias(ValueNode node) {
        assert !(node instanceof VirtualObjectNode);
        if (node == null || !node.isAlive() || aliases.isNew(node)) {
            return node;
        }
        ValueNode result = aliases.get(node);
        return (result == null || result instanceof VirtualObjectNode) ? node : result;
    }
}
