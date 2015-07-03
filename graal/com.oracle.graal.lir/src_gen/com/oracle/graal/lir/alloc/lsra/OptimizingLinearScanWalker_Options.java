// CheckStyle: stop header check
// GENERATED CONTENT - DO NOT EDIT
// Source: OptimizingLinearScanWalker.java
package com.oracle.graal.lir.alloc.lsra;

import java.util.*;
import com.oracle.graal.options.*;

public class OptimizingLinearScanWalker_Options implements Options {
    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            new OptionDescriptor("LSRAOptSplitOnly", Boolean.class, "LSRA optimization: Only split but do not reassign", OptimizingLinearScanWalker.Options.class, "LSRAOptSplitOnly", OptimizingLinearScanWalker.Options.LSRAOptSplitOnly),
            new OptionDescriptor("LSRAOptimization", Boolean.class, "Enable LSRA optimization", OptimizingLinearScanWalker.Options.class, "LSRAOptimization", OptimizingLinearScanWalker.Options.LSRAOptimization)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
