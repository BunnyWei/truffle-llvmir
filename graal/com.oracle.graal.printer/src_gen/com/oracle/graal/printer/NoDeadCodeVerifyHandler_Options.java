// CheckStyle: stop header check
// GENERATED CONTENT - DO NOT EDIT
// Source: NoDeadCodeVerifyHandler.java
package com.oracle.graal.printer;

import java.util.*;
import com.oracle.graal.options.*;

public class NoDeadCodeVerifyHandler_Options implements Options {
    @Override
    public Iterator<OptionDescriptor> iterator() {
        // CheckStyle: stop line length check
        List<OptionDescriptor> options = Arrays.asList(
            new OptionDescriptor("NDCV", Integer.class, "Run level for NoDeadCodeVerifyHandler (0 = off, 1 = info, 2 = verbose, 3 = fatal)", NoDeadCodeVerifyHandler.Options.class, "NDCV", NoDeadCodeVerifyHandler.Options.NDCV)
        );
        // CheckStyle: resume line length check
        return options.iterator();
    }
}
