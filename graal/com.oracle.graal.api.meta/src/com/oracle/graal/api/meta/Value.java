/*
 * Copyright (c) 2009, 2014, Oracle and/or its affiliates. All rights reserved.
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
package com.oracle.graal.api.meta;

/**
 * Interface for values manipulated by the compiler. All values have a {@linkplain Kind kind} and
 * are immutable.
 */
public interface Value extends KindProvider, TrustedInterface {

    @SuppressWarnings("serial") AllocatableValue ILLEGAL = new AllocatableValue(LIRKind.Illegal) {

        @Override
        public String toString() {
            return "-";
        }

        @Override
        public boolean equals(Object other) {
            return this == other;
        }
    };

    LIRKind getLIRKind();

    /**
     * Returns the platform specific kind used to store this value.
     */
    PlatformKind getPlatformKind();

    /**
     * Checks if this value is identical to {@code other}.
     *
     * Warning: Use with caution! Usually equivalence {@link #equals(Object)} is sufficient and
     * should be used.
     */
    @ExcludeFromIdentityComparisonVerification
    default boolean identityEquals(Value other) {
        return this == other;
    }
}
