// CheckStyle: stop header check
// GENERATED CONTENT - DO NOT EDIT
// Source: LoopPolicies.java
package com.oracle.graal.loop;

import java.util.*;
import com.oracle.graal.options.*;

public class LoopPolicies_Options implements Options {
    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            new OptionDescriptor("ExactFullUnrollMaxNodes", Integer.class, "", LoopPolicies.class, "ExactFullUnrollMaxNodes", LoopPolicies.ExactFullUnrollMaxNodes),
            new OptionDescriptor("FullUnrollMaxIterations", Integer.class, "", LoopPolicies.class, "FullUnrollMaxIterations", LoopPolicies.FullUnrollMaxIterations),
            new OptionDescriptor("FullUnrollMaxNodes", Integer.class, "", LoopPolicies.class, "FullUnrollMaxNodes", LoopPolicies.FullUnrollMaxNodes),
            new OptionDescriptor("LoopUnswitchFrequencyBoost", Double.class, "", LoopPolicies.class, "LoopUnswitchFrequencyBoost", LoopPolicies.LoopUnswitchFrequencyBoost),
            new OptionDescriptor("LoopUnswitchMaxIncrease", Integer.class, "", LoopPolicies.class, "LoopUnswitchMaxIncrease", LoopPolicies.LoopUnswitchMaxIncrease),
            new OptionDescriptor("LoopUnswitchTrivial", Integer.class, "", LoopPolicies.class, "LoopUnswitchTrivial", LoopPolicies.LoopUnswitchTrivial)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
