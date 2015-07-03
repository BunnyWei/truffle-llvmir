// CheckStyle: stop header check
// GENERATED CONTENT - DO NOT EDIT
// Source: LowTier.java
package com.oracle.graal.compiler.phases;

import java.util.*;
import com.oracle.graal.options.*;

public class LowTier_Options implements Options {
    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            new OptionDescriptor("ProfileCompiledMethods", Boolean.class, "", LowTier.Options.class, "ProfileCompiledMethods", LowTier.Options.ProfileCompiledMethods)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
