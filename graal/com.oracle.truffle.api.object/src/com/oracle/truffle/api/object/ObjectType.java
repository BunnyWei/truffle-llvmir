/*
 * Copyright (c) 2013, 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
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
package com.oracle.truffle.api.object;

import com.oracle.truffle.api.*;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.interop.*;
import com.oracle.truffle.api.interop.exception.*;
import com.oracle.truffle.api.interop.messages.*;

public class ObjectType {
    /**
     * Delegate method for {@link DynamicObject#equals(Object)}.
     */
    public boolean equals(DynamicObject object, Object other) {
        return object == other;
    }

    /**
     * Delegate method for {@link DynamicObject#hashCode()}.
     */
    public int hashCode(DynamicObject object) {
        return System.identityHashCode(object);
    }

    /**
     * Delegate method for {@link DynamicObject#toString()}.
     */
    @TruffleBoundary
    public String toString(DynamicObject object) {
        return "DynamicObject<" + this.toString() + ">@" + Integer.toHexString(hashCode(object));
    }

    /**
     * Creates a data object to be associated with a newly created shape.
     *
     * @param shape the shape for which to create the data object
     */
    public Object createShapeData(Shape shape) {
        return null;
    }

    /**
     * Called when a new property is added to a shape.
     *
     * @param property the added property
     * @param shapeBefore shape before the property was added
     * @param shapeAfter shape after the property was added
     */
    public void onPropertyAdded(Property property, Shape shapeBefore, Shape shapeAfter) {
    }

    public ForeignAccessFactory getForeignAccessFactory() {
        return new ForeignAccessFactory() {

            public InteropPredicate getLanguageCheck() {
                throw new UnsupportedMessageException(this.toString() + " cannot be shared");
            }

            public CallTarget getAccess(Message tree) {
                throw new UnsupportedMessageException(this.toString() + " cannot be shared; Message not possible: " + tree.toString());
            }
        };
    }
}
