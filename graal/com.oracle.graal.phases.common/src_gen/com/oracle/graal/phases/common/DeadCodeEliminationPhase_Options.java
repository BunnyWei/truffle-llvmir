// CheckStyle: stop header check
// GENERATED CONTENT - DO NOT EDIT
// Source: DeadCodeEliminationPhase.java
package com.oracle.graal.phases.common;

import java.util.*;
import com.oracle.graal.options.*;

public class DeadCodeEliminationPhase_Options implements Options {
    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            new OptionDescriptor("ReduceDCE", Boolean.class, "Disable optional dead code eliminations", DeadCodeEliminationPhase.Options.class, "ReduceDCE", DeadCodeEliminationPhase.Options.ReduceDCE)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
