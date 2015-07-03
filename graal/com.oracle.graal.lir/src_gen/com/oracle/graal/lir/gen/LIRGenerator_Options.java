// CheckStyle: stop header check
// GENERATED CONTENT - DO NOT EDIT
// Source: LIRGenerator.java
package com.oracle.graal.lir.gen;

import java.util.*;
import com.oracle.graal.options.*;

public class LIRGenerator_Options implements Options {
    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            new OptionDescriptor("PrintIRWithLIR", Boolean.class, "Print HIR along side LIR as the latter is generated", LIRGenerator.Options.class, "PrintIRWithLIR", LIRGenerator.Options.PrintIRWithLIR),
            new OptionDescriptor("TraceLIRGeneratorLevel", Integer.class, "The trace level for the LIR generator", LIRGenerator.Options.class, "TraceLIRGeneratorLevel", LIRGenerator.Options.TraceLIRGeneratorLevel)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
