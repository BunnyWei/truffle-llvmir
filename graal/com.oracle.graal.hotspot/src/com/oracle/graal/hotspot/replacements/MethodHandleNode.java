/*
 * Copyright (c) 2013, 2015, Oracle and/or its affiliates. All rights reserved.
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
package com.oracle.graal.hotspot.replacements;

import java.lang.invoke.*;
import java.util.*;

import com.oracle.graal.api.meta.*;
import com.oracle.graal.api.meta.MethodHandleAccessProvider.IntrinsicMethod;
import com.oracle.graal.compiler.common.*;
import com.oracle.graal.compiler.common.type.*;
import com.oracle.graal.graph.*;
import com.oracle.graal.graph.spi.*;
import com.oracle.graal.nodeinfo.*;
import com.oracle.graal.nodes.*;
import com.oracle.graal.nodes.CallTargetNode.InvokeKind;
import com.oracle.graal.nodes.java.*;
import com.oracle.graal.nodes.type.*;
import com.oracle.graal.nodes.util.*;
import com.oracle.graal.replacements.nodes.*;

/**
 * Node for invocation methods defined on the class {@link MethodHandle}.
 */
@NodeInfo
public final class MethodHandleNode extends MacroStateSplitNode implements Simplifiable {
    public static final NodeClass<MethodHandleNode> TYPE = NodeClass.create(MethodHandleNode.class);

    // Replacement method data
    protected ResolvedJavaMethod replacementTargetMethod;
    protected JavaType replacementReturnType;
    @Input NodeInputList<ValueNode> replacementArguments;

    public MethodHandleNode(Invoke invoke) {
        super(TYPE, invoke);
        MethodCallTargetNode callTarget = (MethodCallTargetNode) invoke.callTarget();
        // See if we need to save some replacement method data.
        if (callTarget instanceof SelfReplacingMethodCallTargetNode) {
            SelfReplacingMethodCallTargetNode selfReplacingMethodCallTargetNode = (SelfReplacingMethodCallTargetNode) callTarget;
            replacementTargetMethod = selfReplacingMethodCallTargetNode.replacementTargetMethod();
            replacementReturnType = selfReplacingMethodCallTargetNode.replacementReturnType();
            replacementArguments = selfReplacingMethodCallTargetNode.replacementArguments();
        } else {
            // NodeInputList can't be null.
            replacementArguments = new NodeInputList<>(this);
        }
    }

    /**
     * Returns the method handle method intrinsic identifier for the provided method, or
     * {@code null} if the method is not a method that can be handled by this class.
     */
    public static IntrinsicMethod lookupMethodHandleIntrinsic(ResolvedJavaMethod method, MethodHandleAccessProvider methodHandleAccess) {
        return methodHandleAccess.lookupMethodHandleIntrinsic(method);
    }

    @Override
    public void simplify(SimplifierTool tool) {
        InvokeNode invoke;
        IntrinsicMethod intrinsicMethod = lookupMethodHandleIntrinsic(targetMethod, tool.getConstantReflection().getMethodHandleAccess());
        switch (intrinsicMethod) {
            case INVOKE_BASIC:
                invoke = getInvokeBasicTarget(tool, intrinsicMethod);
                break;
            case LINK_TO_STATIC:
            case LINK_TO_SPECIAL:
            case LINK_TO_VIRTUAL:
            case LINK_TO_INTERFACE:
                invoke = getLinkToTarget(tool, intrinsicMethod);
                break;
            default:
                throw GraalInternalError.shouldNotReachHere();
        }
        if (invoke != null) {
            FixedNode currentNext = next();
            replaceAtUsages(invoke);
            GraphUtil.removeFixedWithUnusedInputs(this);
            graph().addBeforeFixed(currentNext, invoke);
        }
    }

    /**
     * Get the receiver of a MethodHandle.invokeBasic call.
     *
     * @return the receiver argument node
     */
    private ValueNode getReceiver() {
        return arguments.first();
    }

    /**
     * Get the MemberName argument of a MethodHandle.linkTo* call.
     *
     * @return the MemberName argument node (which is the last argument)
     */
    private ValueNode getMemberName() {
        return arguments.last();
    }

    /**
     * Used for the MethodHandle.invokeBasic method (the {@link IntrinsicMethod#INVOKE_BASIC }
     * method) to get the target {@link InvokeNode} if the method handle receiver is constant.
     *
     * @return invoke node for the {@link java.lang.invoke.MethodHandle} target
     */
    protected InvokeNode getInvokeBasicTarget(SimplifierTool tool, IntrinsicMethod intrinsicMethod) {
        ValueNode methodHandleNode = getReceiver();
        if (methodHandleNode.isConstant()) {
            return getTargetInvokeNode(tool.getConstantReflection().getMethodHandleAccess().resolveInvokeBasicTarget(methodHandleNode.asJavaConstant(), false), intrinsicMethod);
        }
        return null;
    }

    /**
     * Used for the MethodHandle.linkTo* methods (the {@link IntrinsicMethod#LINK_TO_STATIC},
     * {@link IntrinsicMethod#LINK_TO_SPECIAL}, {@link IntrinsicMethod#LINK_TO_VIRTUAL}, and
     * {@link IntrinsicMethod#LINK_TO_INTERFACE} methods) to get the target {@link InvokeNode} if
     * the member name argument is constant.
     *
     * @return invoke node for the member name target
     */
    protected InvokeNode getLinkToTarget(SimplifierTool tool, IntrinsicMethod intrinsicMethod) {
        ValueNode memberNameNode = getMemberName();
        if (memberNameNode.isConstant()) {
            return getTargetInvokeNode(tool.getConstantReflection().getMethodHandleAccess().resolveLinkToTarget(memberNameNode.asJavaConstant()), intrinsicMethod);
        }
        return null;
    }

    /**
     * Helper function to get the {@link InvokeNode} for the targetMethod of a
     * java.lang.invoke.MemberName.
     *
     * @param target the target, already loaded from the member name node
     * @return invoke node for the member name target
     */
    private InvokeNode getTargetInvokeNode(ResolvedJavaMethod target, IntrinsicMethod intrinsicMethod) {
        if (target == null) {
            return null;
        }

        // In lambda forms we erase signature types to avoid resolving issues
        // involving class loaders. When we optimize a method handle invoke
        // to a direct call we must cast the receiver and arguments to its
        // actual types.
        Signature signature = target.getSignature();
        final boolean isStatic = target.isStatic();
        final int receiverSkip = isStatic ? 0 : 1;

        // Cast receiver to its type.
        if (!isStatic) {
            JavaType receiverType = target.getDeclaringClass();
            maybeCastArgument(0, receiverType);
        }

        // Cast reference arguments to its type.
        for (int index = 0; index < signature.getParameterCount(false); index++) {
            JavaType parameterType = signature.getParameterType(index, target.getDeclaringClass());
            maybeCastArgument(receiverSkip + index, parameterType);
        }

        // Try to get the most accurate receiver type
        if (intrinsicMethod == IntrinsicMethod.LINK_TO_VIRTUAL || intrinsicMethod == IntrinsicMethod.LINK_TO_INTERFACE) {
            ResolvedJavaType receiverType = StampTool.typeOrNull(getReceiver().stamp());
            if (receiverType != null) {
                ResolvedJavaMethod concreteMethod = receiverType.findUniqueConcreteMethod(target);
                if (concreteMethod != null) {
                    return createTargetInvokeNode(concreteMethod, intrinsicMethod);
                }
            }
        }

        if (target.canBeStaticallyBound()) {
            return createTargetInvokeNode(target, intrinsicMethod);
        }

        ResolvedJavaMethod concreteMethod = target.getDeclaringClass().findUniqueConcreteMethod(target);
        if (concreteMethod != null) {
            return createTargetInvokeNode(concreteMethod, intrinsicMethod);
        }

        return null;
    }

    /**
     * Inserts a node to cast the argument at index to the given type if the given type is more
     * concrete than the argument type.
     *
     * @param index of the argument to be cast
     * @param type the type the argument should be cast to
     */
    private void maybeCastArgument(int index, JavaType type) {
        if (type instanceof ResolvedJavaType) {
            ResolvedJavaType targetType = (ResolvedJavaType) type;
            if (!targetType.isPrimitive()) {
                ValueNode argument = arguments.get(index);
                ResolvedJavaType argumentType = StampTool.typeOrNull(argument.stamp());
                if (argumentType == null || (argumentType.isAssignableFrom(targetType) && !argumentType.equals(targetType))) {
                    PiNode piNode = graph().unique(new PiNode(argument, StampFactory.declared(targetType)));
                    arguments.set(index, piNode);
                }
            }
        }
    }

    /**
     * Creates an {@link InvokeNode} for the given target method. The {@link CallTargetNode} passed
     * to the InvokeNode is in fact a {@link SelfReplacingMethodCallTargetNode}.
     *
     * @param target the method to be called
     * @return invoke node for the member name target
     */
    private InvokeNode createTargetInvokeNode(ResolvedJavaMethod target, IntrinsicMethod intrinsicMethod) {
        InvokeKind targetInvokeKind = target.isStatic() ? InvokeKind.Static : InvokeKind.Special;
        JavaType targetReturnType = target.getSignature().getReturnType(null);

        // MethodHandleLinkTo* nodes have a trailing MemberName argument which
        // needs to be popped.
        ValueNode[] originalArguments = arguments.toArray(new ValueNode[arguments.size()]);
        ValueNode[] targetArguments;
        switch (intrinsicMethod) {
            case INVOKE_BASIC:
                targetArguments = originalArguments;
                break;
            case LINK_TO_STATIC:
            case LINK_TO_SPECIAL:
            case LINK_TO_VIRTUAL:
            case LINK_TO_INTERFACE:
                targetArguments = Arrays.copyOfRange(originalArguments, 0, arguments.size() - 1);
                break;
            default:
                throw GraalInternalError.shouldNotReachHere();
        }

        // If there is already replacement information, use that instead.
        MethodCallTargetNode callTarget;
        if (replacementTargetMethod == null) {
            callTarget = new SelfReplacingMethodCallTargetNode(targetInvokeKind, target, targetArguments, targetReturnType, getTargetMethod(), originalArguments, getReturnType());
        } else {
            ValueNode[] args = replacementArguments.toArray(new ValueNode[replacementArguments.size()]);
            callTarget = new SelfReplacingMethodCallTargetNode(targetInvokeKind, target, targetArguments, targetReturnType, replacementTargetMethod, args, replacementReturnType);
        }
        graph().add(callTarget);

        // The call target can have a different return type than the invoker,
        // e.g. the target returns an Object but the invoker void. In this case
        // we need to use the stamp of the invoker. Note: always using the
        // invoker's stamp would be wrong because it's a less concrete type
        // (usually java.lang.Object).
        InvokeNode invoke;
        if (stamp() == StampFactory.forVoid()) {
            invoke = new InvokeNode(callTarget, getBci(), stamp());
        } else {
            invoke = new InvokeNode(callTarget, getBci());
        }
        graph().add(invoke);
        invoke.setStateAfter(stateAfter());
        return invoke;
    }

}
