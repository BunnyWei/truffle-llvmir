// CheckStyle: stop header check
// GENERATED CONTENT - DO NOT EDIT
// Source: PostAllocationOptimizationStage.java
package com.oracle.graal.lir.phases;

import java.util.*;
import com.oracle.graal.options.*;

public class PostAllocationOptimizationStage_Options implements Options {
    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            new OptionDescriptor("LIROptControlFlowOptmizer", Boolean.class, "", PostAllocationOptimizationStage.Options.class, "LIROptControlFlowOptmizer", PostAllocationOptimizationStage.Options.LIROptControlFlowOptmizer),
            new OptionDescriptor("LIROptEdgeMoveOptimizer", Boolean.class, "", PostAllocationOptimizationStage.Options.class, "LIROptEdgeMoveOptimizer", PostAllocationOptimizationStage.Options.LIROptEdgeMoveOptimizer),
            new OptionDescriptor("LIROptNullCheckOptimizer", Boolean.class, "", PostAllocationOptimizationStage.Options.class, "LIROptNullCheckOptimizer", PostAllocationOptimizationStage.Options.LIROptNullCheckOptimizer),
            new OptionDescriptor("LIROptRedundantMoveElimination", Boolean.class, "", PostAllocationOptimizationStage.Options.class, "LIROptRedundantMoveElimination", PostAllocationOptimizationStage.Options.LIROptRedundantMoveElimination)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
