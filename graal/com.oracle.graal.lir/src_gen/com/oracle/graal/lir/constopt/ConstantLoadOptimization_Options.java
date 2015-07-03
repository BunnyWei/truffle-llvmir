// CheckStyle: stop header check
// GENERATED CONTENT - DO NOT EDIT
// Source: ConstantLoadOptimization.java
package com.oracle.graal.lir.constopt;

import java.util.*;
import com.oracle.graal.options.*;

public class ConstantLoadOptimization_Options implements Options {
    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            new OptionDescriptor("LIROptConstantLoadOptimization", Boolean.class, "Enable constant load optimization.", ConstantLoadOptimization.Options.class, "LIROptConstantLoadOptimization", ConstantLoadOptimization.Options.LIROptConstantLoadOptimization)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
