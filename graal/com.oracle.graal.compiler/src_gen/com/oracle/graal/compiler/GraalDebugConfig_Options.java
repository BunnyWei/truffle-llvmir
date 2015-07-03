// CheckStyle: stop header check
// GENERATED CONTENT - DO NOT EDIT
// Source: GraalDebugConfig.java
package com.oracle.graal.compiler;

import java.util.*;
import com.oracle.graal.options.*;

public class GraalDebugConfig_Options implements Options {
    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            new OptionDescriptor("DebugValueSummary", String.class, "How to print metric and timing values:%nName - aggregate by unqualified name%nPartial - aggregate by partially qualified name (e.g., A.B.C.D.Counter and X.Y.Z.D.Counter will be merged to D.Counter)%nComplete - aggregate by qualified name%nThread - aggregate by qualified name and thread", GraalDebugConfig.class, "DebugValueSummary", GraalDebugConfig.DebugValueSummary),
            new OptionDescriptor("Dump", String.class, "Pattern for scope(s) in which dumping is enabled (see DebugFilter and Debug.dump)", GraalDebugConfig.class, "Dump", GraalDebugConfig.Dump),
            new OptionDescriptor("DumpOnError", Boolean.class, "Send Graal IR to dump handlers on error", GraalDebugConfig.class, "DumpOnError", GraalDebugConfig.DumpOnError),
            new OptionDescriptor("InterceptBailout", Boolean.class, "Intercept also bailout exceptions", GraalDebugConfig.class, "InterceptBailout", GraalDebugConfig.InterceptBailout),
            new OptionDescriptor("Log", String.class, "Pattern for scope(s) in which logging is enabled (see DebugFilter and Debug.log)", GraalDebugConfig.class, "Log", GraalDebugConfig.Log),
            new OptionDescriptor("LogVerbose", Boolean.class, "Enable more verbose log output when available", GraalDebugConfig.class, "LogVerbose", GraalDebugConfig.LogVerbose),
            new OptionDescriptor("Meter", String.class, "Pattern for scope(s) in which metering is enabled (see DebugFilter and Debug.metric)", GraalDebugConfig.class, "Meter", GraalDebugConfig.Meter),
            new OptionDescriptor("MethodFilter", String.class, "Pattern for filtering debug scope output based on method context (see MethodFilter)", GraalDebugConfig.class, "MethodFilter", GraalDebugConfig.MethodFilter),
            new OptionDescriptor("MethodFilterRootOnly", Boolean.class, "Only check MethodFilter against the root method in the context if true, otherwise check all methods", GraalDebugConfig.class, "MethodFilterRootOnly", GraalDebugConfig.MethodFilterRootOnly),
            new OptionDescriptor("SuppressZeroDebugValues", Boolean.class, "Omit reporting 0-value metrics", GraalDebugConfig.class, "SuppressZeroDebugValues", GraalDebugConfig.SuppressZeroDebugValues),
            new OptionDescriptor("Time", String.class, "Pattern for scope(s) in which timing is enabled (see DebugFilter and Debug.timer)", GraalDebugConfig.class, "Time", GraalDebugConfig.Time),
            new OptionDescriptor("TrackMemUse", String.class, "Pattern for scope(s) in which memory use tracking is enabled (see DebugFilter and Debug.metric)", GraalDebugConfig.class, "TrackMemUse", GraalDebugConfig.TrackMemUse),
            new OptionDescriptor("Verify", String.class, "Pattern for scope(s) in which verification is enabled (see DebugFilter and Debug.verify)", GraalDebugConfig.class, "Verify", GraalDebugConfig.Verify)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
