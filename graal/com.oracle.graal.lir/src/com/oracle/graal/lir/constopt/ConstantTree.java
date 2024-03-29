/*
 * Copyright (c) 2014, 2014, Oracle and/or its affiliates. All rights reserved.
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
package com.oracle.graal.lir.constopt;

import java.util.*;
import java.util.function.*;

import com.oracle.graal.compiler.common.cfg.*;

/**
 * Represents a dominator (sub-)tree for a constant definition.
 */
public class ConstantTree extends PrintableDominatorOptimizationProblem<ConstantTree.Flags, ConstantTree.NodeCost> {

    public enum Flags {
        SUBTREE,
        USAGE,
        MATERIALIZE,
        CANDIDATE,
    }

    /**
     * Costs associated with a block.
     */
    public static class NodeCost implements PropertyConsumable {
        private List<UseEntry> usages;
        private double bestCost;
        private int numMat;

        public NodeCost(double bestCost, List<UseEntry> usages, int numMat) {
            this.bestCost = bestCost;
            this.usages = usages;
            this.numMat = numMat;
        }

        public void forEachProperty(BiConsumer<String, String> action) {
            action.accept("bestCost", Double.toString(getBestCost()));
            action.accept("numMat", Integer.toString(getNumMaterializations()));
            action.accept("numUsages", Integer.toString(usages.size()));
        }

        public void addUsage(UseEntry usage) {
            if (usages == null) {
                usages = new ArrayList<>();
            }
            usages.add(usage);
        }

        public List<UseEntry> getUsages() {
            if (usages == null) {
                Collections.emptyList();
            }
            return usages;
        }

        public double getBestCost() {
            return bestCost;
        }

        public int getNumMaterializations() {
            return numMat;
        }

        public void setBestCost(double cost) {
            bestCost = cost;
        }

        @Override
        public String toString() {
            return "NodeCost [bestCost=" + bestCost + ", numUsages=" + usages.size() + ", numMat=" + numMat + "]";
        }
    }

    private final BlockMap<List<UseEntry>> blockMap;

    public ConstantTree(AbstractControlFlowGraph<?> cfg, DefUseTree tree) {
        super(Flags.class, cfg);
        this.blockMap = new BlockMap<>(cfg);
        tree.forEach(u -> getOrInitList(u.getBlock()).add(u));
    }

    private List<UseEntry> getOrInitList(AbstractBlockBase<?> block) {
        List<UseEntry> list = blockMap.get(block);
        if (list == null) {
            list = new ArrayList<>();
            blockMap.put(block, list);
        }
        return list;
    }

    public List<UseEntry> getUsages(AbstractBlockBase<?> block) {
        List<UseEntry> list = blockMap.get(block);
        if (list == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(list);
    }

    /**
     * Returns the cost object associated with {@code block}. If there is none, a new cost object is
     * created.
     */
    NodeCost getOrInitCost(AbstractBlockBase<?> block) {
        NodeCost cost = getCost(block);
        if (cost == null) {
            cost = new NodeCost(block.probability(), blockMap.get(block), 1);
            setCost(block, cost);
        }
        return cost;
    }

    @Override
    public String getName(Flags type) {
        switch (type) {
            case USAGE:
                return "hasUsage";
            case SUBTREE:
                return "inSubtree";
            case MATERIALIZE:
                return "materialize";
            case CANDIDATE:
                return "candidate";
        }
        return super.getName(type);
    }

    @Override
    public void forEachPropertyPair(AbstractBlockBase<?> block, BiConsumer<String, String> action) {
        if (get(Flags.SUBTREE, block) && (block.getDominator() == null || !get(Flags.SUBTREE, block.getDominator()))) {
            action.accept("hasDefinition", "true");
        }
        super.forEachPropertyPair(block, action);
    }

    public long subTreeSize() {
        return stream(Flags.SUBTREE).count();
    }

    public AbstractBlockBase<?> getStartBlock() {
        return stream(Flags.SUBTREE).findFirst().get();
    }

    public void markBlocks() {
        stream(Flags.USAGE).forEach(block -> setDominatorPath(Flags.SUBTREE, block));
    }

    public boolean isMarked(AbstractBlockBase<?> block) {
        return get(Flags.SUBTREE, block);
    }

    public boolean isLeafBlock(AbstractBlockBase<?> block) {
        return block.getDominated().stream().noneMatch(this::isMarked);
    }

    public void setSolution(AbstractBlockBase<?> block) {
        set(Flags.MATERIALIZE, block);
    }

    public int size() {
        return getBlocks().size();
    }

    public void traverseTreeWhileTrue(AbstractBlockBase<?> block, Predicate<AbstractBlockBase<?>> action) {
        assert block != null : "block must not be null!";
        if (action.test(block)) {
            block.getDominated().stream().filter(this::isMarked).forEach(dominated -> traverseTreeWhileTrue(dominated, action));
        }
    }

}
