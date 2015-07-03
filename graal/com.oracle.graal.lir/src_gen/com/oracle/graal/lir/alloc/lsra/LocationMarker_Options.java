// CheckStyle: stop header check
// GENERATED CONTENT - DO NOT EDIT
// Source: LocationMarker.java
package com.oracle.graal.lir.alloc.lsra;

import java.util.*;
import com.oracle.graal.options.*;

public class LocationMarker_Options implements Options {
    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            new OptionDescriptor("UseLocationMarker", Boolean.class, "Use decoupled pass for location marking (instead of using LSRA marking)", LocationMarker.Options.class, "UseLocationMarker", LocationMarker.Options.UseLocationMarker)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
