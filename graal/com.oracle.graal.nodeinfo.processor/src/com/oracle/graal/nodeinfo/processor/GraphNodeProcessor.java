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
package com.oracle.graal.nodeinfo.processor;

import static com.oracle.truffle.dsl.processor.java.ElementUtils.*;
import static java.util.Collections.*;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import javax.annotation.processing.*;
import javax.lang.model.*;
import javax.lang.model.element.*;
import javax.lang.model.util.*;
import javax.tools.Diagnostic.Kind;

import com.oracle.graal.nodeinfo.*;

@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes({"com.oracle.graal.nodeinfo.NodeInfo"})
public class GraphNodeProcessor extends AbstractProcessor {
    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latest();
    }

    /**
     * Node class currently being processed.
     */
    private Element scope;

    public static boolean isEnclosedIn(Element e, Element scopeElement) {
        List<Element> elementHierarchy = getElementHierarchy(e);
        return elementHierarchy.contains(scopeElement);
    }

    void errorMessage(Element element, String format, Object... args) {
        message(Kind.ERROR, element, format, args);
    }

    void message(Kind kind, Element element, String format, Object... args) {
        if (scope != null && !isEnclosedIn(element, scope)) {
            // See https://bugs.eclipse.org/bugs/show_bug.cgi?id=428357#c1
            List<Element> elementHierarchy = getElementHierarchy(element);
            reverse(elementHierarchy);
            String loc = elementHierarchy.stream().filter(e -> e.getKind() != ElementKind.PACKAGE).map(Object::toString).collect(Collectors.joining("."));
            processingEnv.getMessager().printMessage(kind, String.format(loc + ": " + format, args), scope);
        } else {
            processingEnv.getMessager().printMessage(kind, String.format(format, args), element);
        }
    }

    /**
     * Bugs in an annotation processor can cause silent failure so try to report any exception
     * throws as errors.
     */
    private void reportException(Kind kind, Element element, Throwable t) {
        StringWriter buf = new StringWriter();
        t.printStackTrace(new PrintWriter(buf));
        buf.toString();
        message(kind, element, "Exception thrown during processing: %s", buf.toString());
    }

    ProcessingEnvironment getProcessingEnv() {
        return processingEnv;
    }

    boolean isNodeType(Element element) {
        if (element.getKind() != ElementKind.CLASS) {
            return false;
        }
        TypeElement type = (TypeElement) element;
        Types types = processingEnv.getTypeUtils();

        while (type != null) {
            if (type.toString().equals("com.oracle.graal.graph.Node")) {
                return true;
            }
            type = (TypeElement) types.asElement(type.getSuperclass());
        }
        return false;
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (roundEnv.processingOver()) {
            return false;
        }

        GraphNodeVerifier verifier = new GraphNodeVerifier(this);

        for (Element element : roundEnv.getElementsAnnotatedWith(NodeInfo.class)) {
            scope = element;
            try {
                if (!isNodeType(element)) {
                    errorMessage(element, "%s can only be applied to Node subclasses", NodeInfo.class.getSimpleName());
                    continue;
                }

                NodeInfo nodeInfo = element.getAnnotation(NodeInfo.class);
                if (nodeInfo == null) {
                    errorMessage(element, "Cannot get %s annotation from annotated element", NodeInfo.class.getSimpleName());
                    continue;
                }

                TypeElement typeElement = (TypeElement) element;

                Set<Modifier> modifiers = typeElement.getModifiers();
                if (!modifiers.contains(Modifier.FINAL) && !modifiers.contains(Modifier.ABSTRACT)) {
                    // TODO(thomaswue): Reenable this check.
                    // errorMessage(element, "%s annotated class must be either final or abstract",
                    // NodeInfo.class.getSimpleName());
                    // continue;
                }
                boolean found = false;
                for (Element e : typeElement.getEnclosedElements()) {
                    if (e.getKind() == ElementKind.FIELD) {
                        if (e.getSimpleName().toString().equals("TYPE")) {
                            found = true;
                            break;
                        }
                    }
                }
                if (!found) {
                    errorMessage(element, "%s annotated class must have a field named TYPE", NodeInfo.class.getSimpleName());
                }

                if (!typeElement.equals(verifier.Node) && !modifiers.contains(Modifier.ABSTRACT)) {
                    verifier.verify(typeElement);
                }
            } catch (ElementException ee) {
                errorMessage(ee.element, ee.getMessage());
            } catch (Throwable t) {
                reportException(isBug367599(t) ? Kind.NOTE : Kind.ERROR, element, t);
            } finally {
                scope = null;
            }
        }
        return false;
    }

    /**
     * Determines if a given exception is (most likely) caused by <a
     * href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=367599">Bug 367599</a>.
     */
    public static boolean isBug367599(Throwable t) {
        if (t instanceof FilerException) {
            for (StackTraceElement ste : t.getStackTrace()) {
                if (ste.toString().contains("org.eclipse.jdt.internal.apt.pluggable.core.filer.IdeFilerImpl.create")) {
                    // See: https://bugs.eclipse.org/bugs/show_bug.cgi?id=367599
                    return true;
                }
            }
        }
        if (t.getCause() != null) {
            return isBug367599(t.getCause());
        }
        return false;
    }
}
