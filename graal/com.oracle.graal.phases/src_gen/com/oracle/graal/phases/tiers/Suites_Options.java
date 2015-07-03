// CheckStyle: stop header check
// GENERATED CONTENT - DO NOT EDIT
// Source: Suites.java
package com.oracle.graal.phases.tiers;

import java.util.*;
import com.oracle.graal.options.*;

public class Suites_Options implements Options {
    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            new OptionDescriptor("CompilerConfiguration", String.class, "The compiler configuration to use", Suites.Options.class, "CompilerConfiguration", Suites.Options.CompilerConfiguration)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
