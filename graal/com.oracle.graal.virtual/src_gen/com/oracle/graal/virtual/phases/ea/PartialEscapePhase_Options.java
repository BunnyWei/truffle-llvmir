// CheckStyle: stop header check
// GENERATED CONTENT - DO NOT EDIT
// Source: PartialEscapePhase.java
package com.oracle.graal.virtual.phases.ea;

import java.util.*;
import com.oracle.graal.options.*;

public class PartialEscapePhase_Options implements Options {
    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            new OptionDescriptor("OptEarlyReadElimination", Boolean.class, "", PartialEscapePhase.Options.class, "OptEarlyReadElimination", PartialEscapePhase.Options.OptEarlyReadElimination)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
