/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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
package com.oracle.graal.hotspot.nodes;

import static com.oracle.graal.hotspot.HotSpotBackend.*;

import com.oracle.graal.api.code.*;
import com.oracle.graal.api.meta.*;
import com.oracle.graal.compiler.common.type.*;
import com.oracle.graal.graph.*;
import com.oracle.graal.hotspot.*;
import com.oracle.graal.lir.StandardOp.SaveRegistersOp;
import com.oracle.graal.nodeinfo.*;
import com.oracle.graal.nodes.*;
import com.oracle.graal.nodes.extended.*;
import com.oracle.graal.nodes.spi.*;
import com.oracle.graal.word.*;

/**
 * A call to the runtime code {@code Deoptimization::fetch_unroll_info}.
 */
@NodeInfo(allowedUsageTypes = {InputType.Memory})
public final class DeoptimizationFetchUnrollInfoCallNode extends FixedWithNextNode implements LIRLowerable, MemoryCheckpoint.Multi {

    public static final NodeClass<DeoptimizationFetchUnrollInfoCallNode> TYPE = NodeClass.create(DeoptimizationFetchUnrollInfoCallNode.class);
    @Input SaveAllRegistersNode registerSaver;
    protected final ForeignCallsProvider foreignCalls;

    public DeoptimizationFetchUnrollInfoCallNode(@InjectedNodeParameter ForeignCallsProvider foreignCalls, ValueNode registerSaver) {
        super(TYPE, StampFactory.forKind(Kind.fromJavaClass(FETCH_UNROLL_INFO.getResultType())));
        this.registerSaver = (SaveAllRegistersNode) registerSaver;
        this.foreignCalls = foreignCalls;
    }

    @Override
    public LocationIdentity[] getLocationIdentities() {
        return foreignCalls.getKilledLocations(FETCH_UNROLL_INFO);
    }

    public SaveRegistersOp getSaveRegistersOp() {
        return registerSaver.getSaveRegistersOp();
    }

    @Override
    public void generate(NodeLIRBuilderTool gen) {
        Value result = ((HotSpotLIRGenerator) gen.getLIRGeneratorTool()).emitDeoptimizationFetchUnrollInfoCall(getSaveRegistersOp());
        gen.setResult(this, result);
    }

    @NodeIntrinsic
    public static native Word fetchUnrollInfo(long registerSaver);
}
