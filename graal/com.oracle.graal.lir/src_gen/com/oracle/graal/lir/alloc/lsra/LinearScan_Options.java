// CheckStyle: stop header check
// GENERATED CONTENT - DO NOT EDIT
// Source: LinearScan.java
package com.oracle.graal.lir.alloc.lsra;

import java.util.*;
import com.oracle.graal.options.*;

public class LinearScan_Options implements Options {
    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            new OptionDescriptor("LSRAOptimizeSpillPosition", Boolean.class, "Enable spill position optimization", LinearScan.Options.class, "LSRAOptimizeSpillPosition", LinearScan.Options.LSRAOptimizeSpillPosition)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
