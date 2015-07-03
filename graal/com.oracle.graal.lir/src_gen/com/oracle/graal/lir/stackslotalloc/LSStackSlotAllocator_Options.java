// CheckStyle: stop header check
// GENERATED CONTENT - DO NOT EDIT
// Source: LSStackSlotAllocator.java
package com.oracle.graal.lir.stackslotalloc;

import java.util.*;
import com.oracle.graal.options.*;

public class LSStackSlotAllocator_Options implements Options {
    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            new OptionDescriptor("LIROptLSStackSlotAllocator", Boolean.class, "Use linear scan stack slot allocation.", LSStackSlotAllocator.Options.class, "LIROptLSStackSlotAllocator", LSStackSlotAllocator.Options.LIROptLSStackSlotAllocator)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
