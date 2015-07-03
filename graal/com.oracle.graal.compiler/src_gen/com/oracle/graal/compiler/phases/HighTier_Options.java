// CheckStyle: stop header check
// GENERATED CONTENT - DO NOT EDIT
// Source: HighTier.java
package com.oracle.graal.compiler.phases;

import java.util.*;
import com.oracle.graal.options.*;

public class HighTier_Options implements Options {
    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            new OptionDescriptor("Inline", Boolean.class, "Enable inlining", HighTier.Options.class, "Inline", HighTier.Options.Inline)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
