/*
 * Copyright (c) 2009, 2014, Oracle and/or its affiliates. All rights reserved.
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
package com.oracle.graal.nodes.virtual;

import java.util.*;

import com.oracle.graal.compiler.common.type.*;
import com.oracle.graal.graph.*;
import com.oracle.graal.graph.spi.*;
import com.oracle.graal.nodeinfo.*;
import com.oracle.graal.nodes.*;
import com.oracle.graal.nodes.java.*;
import com.oracle.graal.nodes.spi.*;

@NodeInfo(nameTemplate = "Alloc {i#virtualObjects}", allowedUsageTypes = {InputType.Extension})
public final class CommitAllocationNode extends FixedWithNextNode implements VirtualizableAllocation, Lowerable, Simplifiable {

    public static final NodeClass<CommitAllocationNode> TYPE = NodeClass.create(CommitAllocationNode.class);
    @Input NodeInputList<VirtualObjectNode> virtualObjects = new NodeInputList<>(this);
    @Input NodeInputList<ValueNode> values = new NodeInputList<>(this);
    @Input(InputType.Association) NodeInputList<MonitorIdNode> locks = new NodeInputList<>(this);
    protected ArrayList<Integer> lockIndexes = new ArrayList<>(Arrays.asList(0));

    public CommitAllocationNode() {
        super(TYPE, StampFactory.forVoid());
    }

    public List<VirtualObjectNode> getVirtualObjects() {
        return virtualObjects;
    }

    public List<ValueNode> getValues() {
        return values;
    }

    public List<MonitorIdNode> getLocks(int objIndex) {
        return locks.subList(lockIndexes.get(objIndex), lockIndexes.get(objIndex + 1));
    }

    @Override
    public boolean verify() {
        assertTrue(virtualObjects.size() + 1 == lockIndexes.size(), "lockIndexes size doesn't match " + virtualObjects + ", " + lockIndexes);
        assertTrue(lockIndexes.get(lockIndexes.size() - 1) == locks.size(), "locks size doesn't match " + lockIndexes + ", " + locks);
        int valueCount = 0;
        for (VirtualObjectNode virtual : virtualObjects) {
            valueCount += virtual.entryCount();
        }
        assertTrue(values.size() == valueCount, "values size doesn't match");
        return super.verify();
    }

    @Override
    public void lower(LoweringTool tool) {
        tool.getLowerer().lower(this, tool);
    }

    @Override
    public void afterClone(Node other) {
        lockIndexes = new ArrayList<>(lockIndexes);
    }

    public void addLocks(List<MonitorIdNode> monitorIds) {
        locks.addAll(monitorIds);
        lockIndexes.add(locks.size());
    }

    @Override
    public void virtualize(VirtualizerTool tool) {
        int pos = 0;
        for (int i = 0; i < virtualObjects.size(); i++) {
            VirtualObjectNode virtualObject = virtualObjects.get(i);
            int entryCount = virtualObject.entryCount();
            tool.createVirtualObject(virtualObject, values.subList(pos, pos + entryCount).toArray(new ValueNode[entryCount]), getLocks(i));
            pos += entryCount;
        }
        tool.delete();
    }

    @Override
    public Map<Object, Object> getDebugProperties(Map<Object, Object> map) {
        Map<Object, Object> properties = super.getDebugProperties(map);
        int valuePos = 0;
        for (int objIndex = 0; objIndex < virtualObjects.size(); objIndex++) {
            VirtualObjectNode virtual = virtualObjects.get(objIndex);
            StringBuilder s = new StringBuilder();
            s.append(virtual.type().toJavaName(false)).append("[");
            for (int i = 0; i < virtual.entryCount(); i++) {
                ValueNode value = values.get(valuePos++);
                s.append(i == 0 ? "" : ",").append(value == null ? "_" : value.toString(Verbosity.Id));
            }
            s.append("]");
            if (!getLocks(objIndex).isEmpty()) {
                s.append(" locked(").append(getLocks(objIndex)).append(")");
            }
            properties.put("object(" + virtual.toString(Verbosity.Id) + ")", s.toString());
        }
        return properties;
    }

    @Override
    public void simplify(SimplifierTool tool) {
        boolean[] used = new boolean[virtualObjects.size()];
        int usedCount = 0;
        for (Node usage : usages()) {
            AllocatedObjectNode addObject = (AllocatedObjectNode) usage;
            int index = virtualObjects.indexOf(addObject.getVirtualObject());
            assert !used[index];
            used[index] = true;
            usedCount++;
        }
        if (usedCount == 0) {
            List<Node> inputSnapshot = inputs().snapshot();
            graph().removeFixed(this);
            for (Node input : inputSnapshot) {
                tool.removeIfUnused(input);
            }
            return;
        }
        boolean progress;
        do {
            progress = false;
            int valuePos = 0;
            for (int objIndex = 0; objIndex < virtualObjects.size(); objIndex++) {
                VirtualObjectNode virtualObject = virtualObjects.get(objIndex);
                if (used[objIndex]) {
                    for (int i = 0; i < virtualObject.entryCount(); i++) {
                        int index = virtualObjects.indexOf(values.get(valuePos + i));
                        if (index != -1 && !used[index]) {
                            progress = true;
                            used[index] = true;
                            usedCount++;
                        }
                    }
                }
                valuePos += virtualObject.entryCount();
            }

        } while (progress);

        if (usedCount < virtualObjects.size()) {
            List<VirtualObjectNode> newVirtualObjects = new ArrayList<>(usedCount);
            List<MonitorIdNode> newLocks = new ArrayList<>(usedCount);
            ArrayList<Integer> newLockIndexes = new ArrayList<>(usedCount + 1);
            newLockIndexes.add(0);
            List<ValueNode> newValues = new ArrayList<>();
            int valuePos = 0;
            for (int objIndex = 0; objIndex < virtualObjects.size(); objIndex++) {
                VirtualObjectNode virtualObject = virtualObjects.get(objIndex);
                if (used[objIndex]) {
                    newVirtualObjects.add(virtualObject);
                    newLocks.addAll(getLocks(objIndex));
                    newLockIndexes.add(newLocks.size());
                    newValues.addAll(values.subList(valuePos, valuePos + virtualObject.entryCount()));
                }
                valuePos += virtualObject.entryCount();
            }
            virtualObjects.clear();
            virtualObjects.addAll(newVirtualObjects);
            locks.clear();
            locks.addAll(newLocks);
            values.clear();
            values.addAll(newValues);
            lockIndexes = newLockIndexes;
        }
    }

}
