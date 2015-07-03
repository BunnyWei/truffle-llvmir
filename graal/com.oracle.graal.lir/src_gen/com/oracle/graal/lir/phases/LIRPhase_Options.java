// CheckStyle: stop header check
// GENERATED CONTENT - DO NOT EDIT
// Source: LIRPhase.java
package com.oracle.graal.lir.phases;

import java.util.*;
import com.oracle.graal.options.*;

public class LIRPhase_Options implements Options {
    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            new OptionDescriptor("LIROptimization", Boolean.class, "Enable LIR level optimiztations.", LIRPhase.Options.class, "LIROptimization", LIRPhase.Options.LIROptimization)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
