// CheckStyle: stop header check
// GENERATED CONTENT - DO NOT EDIT
// Source: Graph.java
package com.oracle.graal.graph;

import java.util.*;
import com.oracle.graal.options.*;

public class Graph_Options implements Options {
    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            new OptionDescriptor("VerifyGraalGraphs", Boolean.class, "Verify graphs often during compilation when assertions are turned on", Graph.Options.class, "VerifyGraalGraphs", Graph.Options.VerifyGraalGraphs)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
