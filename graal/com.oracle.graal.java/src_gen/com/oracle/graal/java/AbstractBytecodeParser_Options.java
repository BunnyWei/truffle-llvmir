// CheckStyle: stop header check
// GENERATED CONTENT - DO NOT EDIT
// Source: AbstractBytecodeParser.java
package com.oracle.graal.java;

import java.util.*;
import com.oracle.graal.options.*;

public class AbstractBytecodeParser_Options implements Options {
    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            new OptionDescriptor("TraceBytecodeParserLevel", Integer.class, "The trace level for the bytecode parser used when building a graph from bytecode", AbstractBytecodeParser.Options.class, "TraceBytecodeParserLevel", AbstractBytecodeParser.Options.TraceBytecodeParserLevel)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
