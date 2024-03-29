/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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
package com.oracle.graal.options;

import java.io.*;
import java.util.function.*;

import com.oracle.graal.options.OptionValue.OverrideScope;

/**
 * A cached value that needs to be recomputed when an option changes.
 */
public class DerivedOptionValue<T> {

    public interface OptionSupplier<T> extends Supplier<T>, Serializable {
    }

    private final T initialValue;
    private final OptionSupplier<T> supplier;

    public DerivedOptionValue(OptionSupplier<T> supplier) {
        this.supplier = supplier;
        assert OptionValue.getOverrideScope() == null : "derived option value should be initialized outside any override scope";
        this.initialValue = createValue();
    }

    public T getValue() {
        OverrideScope overrideScope = OptionValue.getOverrideScope();
        if (overrideScope != null) {
            return overrideScope.getDerived(this);
        } else {
            return initialValue;
        }
    }

    T createValue() {
        return supplier.get();
    }
}
