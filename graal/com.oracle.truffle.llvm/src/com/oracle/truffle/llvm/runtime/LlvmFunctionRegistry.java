/*
 * Copyright (c) 2012, 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package com.oracle.truffle.llvm.runtime;

import java.util.*;

import com.oracle.truffle.api.*;
import com.oracle.truffle.llvm.nodes.*;
import com.oracle.truffle.llvm.nodes.*;

/**
 * Manages the mapping from function names to {@link LlvmFunction function objects}.
 */
public final class LlvmFunctionRegistry {

    private final Map<String, LlvmFunction> functions = new HashMap<>();

    /**
     * Returns the canonical {@link LlvmFunction} object for the given name. If it does not exist
     * yet, it is created.
     */
    public LlvmFunction lookup(String name) {
        LlvmFunction result = functions.get(name);
        if (result == null) {
            result = new LlvmFunction(name);
            functions.put(name, result);
        }
        return result;
    }

    /**
     * Associates the {@link LlvmFunction} with the given name with the given implementation root
     * node. If the function did not exist before, it defines the function. If the function existed
     * before, it redefines the function and the old implementation is discarded.
     */
    public void register(String name, LlvmRootNode rootNode) {
        LlvmFunction function = lookup(name);
        RootCallTarget callTarget = Truffle.getRuntime().createCallTarget(rootNode);
        function.setCallTarget(callTarget);
    }

    /**
     * Returns the sorted list of all functions, for printing purposes only.
     */
    public List<LlvmFunction> getFunctions() {
        List<LlvmFunction> result = new ArrayList<>(functions.values());
        Collections.sort(result, new Comparator<LlvmFunction>() {
            public int compare(LlvmFunction f1, LlvmFunction f2) {
                return f1.toString().compareTo(f2.toString());
            }
        });
        return result;
    }
}
