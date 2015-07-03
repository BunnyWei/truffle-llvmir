// CheckStyle: stop header check
// GENERATED CONTENT - DO NOT EDIT
// Source: GraalCompiler.java
package com.oracle.graal.compiler;

import java.util.*;
import com.oracle.graal.options.*;

public class GraalCompiler_Options implements Options {
    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            new OptionDescriptor("EmitLIRRepeatCount", Integer.class, "Repeatedly run the LIR code generation pass to improve statistical profiling results.", GraalCompiler.Options.class, "EmitLIRRepeatCount", GraalCompiler.Options.EmitLIRRepeatCount),
            new OptionDescriptor("IntrinsificationsDisabled", String.class, "Pattern for method(s) to which intrinsification will not be applied. See MethodFilter class for pattern syntax.", GraalCompiler.Options.class, "IntrinsificationsDisabled", GraalCompiler.Options.IntrinsificationsDisabled),
            new OptionDescriptor("IntrinsificationsEnabled", String.class, "Pattern for method(s) to which intrinsification (if available) will be applied. By default, all available intrinsifications are applied except for methods matched by IntrinsificationsDisabled. See MethodFilter class for pattern syntax.", GraalCompiler.Options.class, "IntrinsificationsEnabled", GraalCompiler.Options.IntrinsificationsEnabled)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
