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
package com.oracle.truffle.llvm.parser;

import java.math.*;
import java.util.*;

import org.antlr.v4.runtime.Token;

import com.oracle.truffle.api.frame.*;
import com.oracle.truffle.api.nodes.*;
import com.oracle.truffle.api.source.*;
import com.oracle.truffle.llvm.runtime.*;
import com.oracle.truffle.llvm.access.*;
import com.oracle.truffle.llvm.call.*;
import com.oracle.truffle.llvm.node.expression.*;
import com.oracle.truffle.llvm.nodes.*;
import com.oracle.truffle.llvm.nodes.controlflow.*;
import com.oracle.truffle.llvm.nodes.local.*;
import com.oracle.truffle.llvm.runtime.*;
import com.oracle.truffle.llvm.types.*;
import com.oracle.truffle.llvm.types.LlvmStringLiteralNode;

/**
 * Helper class used by the Llvm {@link LlvmParser} to create nodes. The code is factored out of the
 * automatically generated parser to keep the attributed grammar of Llvm small.
 */
public class LlvmNodeFactory {

    /**
     * Local variable names that are visible in the current block. Variables are not visible outside
     * of their defining block, to prevent the usage of undefined variables. Because of that, we can
     * decide during parsing if a name references a local variable or is a function name.
     */
    static class LexicalScope {
        protected final LexicalScope outer;
        protected final Map<String, FrameSlot> locals;
        protected Map<String, LlvmBlockNode> blockMap;

        public LexicalScope(LexicalScope outer) {
            this.outer = outer;
            this.locals = new HashMap<>();
            this.blockMap = new HashMap<>();
            if (outer != null) {
                locals.putAll(outer.locals);
            }
        }
    }

    /* State while parsing a source unit. */
    private final LlvmContext context;
    private final Source source;

    /* State while parsing a function. */
    private int functionStartPos;
    private String functionName;
    private int functionBodyStartPos; // includes parameter list
    private int parameterCount;
    private FrameDescriptor frameDescriptor;
    private List<LlvmStatementNode> methodNodes;

    /* State while parsing a block. */
    private LexicalScope lexicalScope;

    // basic block definition
    private String basicBlockName;
    private int basicBlockStartPos;
    private int basicBlockEndPos;

    public LlvmNodeFactory(LlvmContext context, Source source) {
        this.context = context;
        this.source = source;
    }

    public void startFunction(Token nameToken, int bodyStartPos) {
        assert functionStartPos == 0;
        assert functionName == null;
        assert functionBodyStartPos == 0;
        assert parameterCount == 0;
        assert frameDescriptor == null;
        assert lexicalScope == null;

        functionStartPos = nameToken.getStartIndex();
        functionName = nameToken.getText();
        functionBodyStartPos = bodyStartPos;
        frameDescriptor = new FrameDescriptor();
        methodNodes = new ArrayList<>();
        startBlock();
    }

    public void addFormalParameter(Token nameToken) {
        List<String> list = new ArrayList();
        /*
         * Method parameters are assigned to local variables at the beginning of the method. This
         * ensures that accesses to parameters are specialized the same way as local variables are
         * specialized.
         */
        final SourceSection src = srcFromToken(nameToken);
        final LlvmReadArgumentNode readArg = new LlvmReadArgumentNode(src, parameterCount);
        // 还要修改
        methodNodes.add(createAssignment(nameToken, readArg));
        parameterCount++;
    }

    public void finishFunction(LlvmStatementNode bodyNode) {
        methodNodes.add(bodyNode);
        final int bodyEndPos = bodyNode.getSourceSection().getCharEndIndex();
        final SourceSection functionSrc = source.createSection(functionName, functionStartPos, bodyEndPos - functionStartPos);
        final LlvmStatementNode methodBlock = finishBlock(methodNodes, functionBodyStartPos, bodyEndPos - functionBodyStartPos);
        assert lexicalScope == null : "Wrong scoping of blocks in parser";

        final LlvmFunctionBodyNode functionBodyNode = new LlvmFunctionBodyNode(functionSrc, methodBlock);
        final LlvmRootNode rootNode = new LlvmRootNode(this.context, frameDescriptor, functionBodyNode, functionName);
        rootNode.assignSourceSection(functionSrc);

        context.getFunctionRegistry().register(functionName, rootNode);

        functionStartPos = 0;
        functionName = null;
        functionBodyStartPos = 0;
        parameterCount = 0;
        frameDescriptor = null;
        lexicalScope = null;
    }

    public void startBlock() {
        lexicalScope = new LexicalScope(lexicalScope);
    }

    public LlvmStatementNode finishBlock(List<LlvmStatementNode> bodyNodes, int startPos, int length) {
        lexicalScope = lexicalScope.outer;

        List<LlvmStatementNode> flattenedNodes = new ArrayList<>(bodyNodes.size());
        flattenBlocks(bodyNodes, flattenedNodes);

        final SourceSection src = source.createSection("block", startPos, length);
        return new LlvmBlockNode(src, flattenedNodes.toArray(new LlvmStatementNode[flattenedNodes.size()]));
    }

    private void flattenBlocks(Iterable<? extends Node> bodyNodes, List<LlvmStatementNode> flattenedNodes) {
        for (Node n : bodyNodes) {
            if (n instanceof LlvmBlockNode) {
                flattenBlocks(n.getChildren(), flattenedNodes);
            } else {
                flattenedNodes.add((LlvmStatementNode) n);
            }
        }
    }

// /**
// * Returns an {@link LlvmBreakNode} for the given token.
// *
// * @param breakToken The token containing the break node's info.
// * @return A LlvmBreakNode for the given token.
// */
// public LlvmStatementNode createBreak(Token breakToken) {
// final LlvmBreakNode breakNode = new LlvmBreakNode(srcFromToken(breakToken));
// return breakNode;
// }
//
// /**
// * Returns an {@link LlvmContinueNode} for the given token.
// *
// * @param continueToken The token containing the continue node's info.
// * @return A LlvmContinueNode built using the given token.
// */
// public LlvmStatementNode createContinue(Token continueToken) {
// final LlvmContinueNode continueNode = new LlvmContinueNode(srcFromToken(continueToken));
// return continueNode;
// }
//
// /**
// * Returns an {@link LlvmWhileNode} for the given parameters.
// *
// * @param whileToken The token containing the while node's info
// * @param conditionNode The conditional node for this while loop
// * @param bodyNode The body of the while loop
// * @return A LlvmWhileNode built using the given parameters.
// */
    public LlvmStatementNode createWhile(Token whileToken, LlvmExpressionNode conditionNode, Map<String, LlvmStatementNode> bodyNode, Token nameToken) {
        final int start = whileToken.getStartIndex();
        List<LlvmStatementNode> whileList = new ArrayList();
        if (bodyNode.values() instanceof List) {
            whileList = (List) bodyNode.values();
        } else {
            whileList = new ArrayList(bodyNode.values());
        }
        List<LlvmStatementNode> whileBody = new ArrayList();
        int length = 0;
        while (length < whileList.size()) {
            if (whileList.get(length) != null)
                whileBody.add(whileList.get(length));
            length++;
        }
        final int end = whileBody.get(whileBody.size() - 1).getSourceSection().getCharEndIndex();
        whileBody.add(lexicalScope.blockMap.get(nameToken.getText()));
        LlvmStatementNode whileReturnNode = this.createBasicBlockNode(nameToken, whileBody, start, end - start);
        final LlvmWhileNode whileNode = new LlvmWhileNode(source.createSection(whileToken.getText(), start, end - start), conditionNode, whileReturnNode);
        return whileNode;
// final int start = whileToken.getStartIndex();
// final int end = bodyNode.getSourceSection().getCharEndIndex();
// List<LlvmStatementNode> whileBody = new ArrayList();
// System.out.println(nameToken.getText());
// whileBody.add(bodyNode);
// whileBody.add(lexicalScope.blockMap.get(nameToken.getText()));
//
// bodyNode = this.createBasicBlockNode(nameToken, whileBody, start, end - start);
// final LlvmWhileNode whileNode = new LlvmWhileNode(source.createSection(whileToken.getText(),
// start, end - start), conditionNode, bodyNode);
// return whileNode;
    }

//
// /**
// * Returns an {@link LlvmIfNode} for the given parameters.
// *
// * @param ifToken The token containing the if node's info
// * @param conditionNode The condition node of this if statement
// * @param thenPartNode The then part of the if
// * @param elsePartNode The else part of the if
// * @return An LlvmIfNode for the given parameters.
// */
    public LlvmStatementNode createIf(Token ifToken, String str, LlvmExpressionNode conditionNode, LlvmStatementNode thenPartNode, LlvmStatementNode elsePartNode) {
        final int start = ifToken.getStartIndex();
        final int end = elsePartNode == null ? thenPartNode.getSourceSection().getCharEndIndex() : elsePartNode.getSourceSection().getCharEndIndex();
        final SourceSection src = source.createSection(str, start, end - start);
        final LlvmIfNode ifNode = new LlvmIfNode(source.createSection(ifToken.getText(), start, end - start), conditionNode, thenPartNode, elsePartNode);
        return ifNode;
    }

// /**
// * Returns an {@link LlvmReturnNode} for the given parameters.
// *
// * @param t The token containing the return node's info
// * @param valueNode The value of the return
// * @return An LlvmReturnNode for the given parameters.
// */
    public LlvmStatementNode createReturn(Token t, LlvmExpressionNode valueNode) {
        final int start = t.getStartIndex();
        final int length = valueNode == null ? t.getText().length() : valueNode.getSourceSection().getCharEndIndex() - start;
        final LlvmReturnNode returnNode = new LlvmReturnNode(source.createSection(t.getText(), start, length), valueNode);
        // final LlvmStatementNode returnNode = null;
        return returnNode;
    }

    /**
     * Returns the corresponding subclass of {@link LlvmExpressionNode} for binary expressions.
     * </br>These nodes are currently not instrumented.
     *
     * @param opToken The operator of the binary expression
     * @param leftNode The left node of the expression
     * @param rightNode The right node of the expression
     * @return A subclass of LlvmExpressionNode using the given parameters based on the given
     *         opToken.
     */
    public LlvmExpressionNode createBinary(Token opToken, LlvmExpressionNode leftNode, LlvmExpressionNode rightNode) {
        int start = leftNode.getSourceSection().getCharIndex();
        int length = rightNode.getSourceSection().getCharEndIndex() - start;
        final SourceSection src = source.createSection(opToken.getText(), start, length);
        switch (opToken.getText()) {
            case "add":
            case "fadd":
                return LlvmAddNodeGen.create(src, leftNode, rightNode);
            case "mul":
            case "fmul":
                return LlvmMulNodeGen.create(src, leftNode, rightNode);
            case "udiv":
            case "sdiv":
            case "fdiv":
                return LlvmDivNodeGen.create(src, leftNode, rightNode);
            case "sub":
            case "fsub":
                return LlvmSubNodeGen.create(src, leftNode, rightNode);
            case "urem":
            case "srem":
                return LlvmRemNodeGen.create(src, leftNode, rightNode);
            default:
                throw new RuntimeException("unexpected operation: " + opToken.getText());
        }
    }

    public LlvmExpressionNode createArrayCopyBinary(Token opToken, LlvmExpressionNode leftNode, LlvmExpressionNode rightNode) {
        int start = leftNode.getSourceSection().getCharIndex();
        int length = leftNode.getSourceSection().getCharEndIndex() + 2 - start;
        final SourceSection src = source.createSection(opToken.getText(), start, length);
        return LlvmArrayPointNodeGen.create(src, leftNode, rightNode);
    }

    public LlvmExpressionNode createCompBinary(Token opToken, String cmpType, LlvmExpressionNode leftNode, LlvmExpressionNode rightNode) {
        int start = leftNode.getSourceSection().getCharIndex();
        int length = rightNode.getSourceSection().getCharEndIndex() - start;
        final SourceSection src = source.createSection(opToken.getText(), start, length);
        return LlvmCompNodeGen.create(src, cmpType, leftNode, rightNode);
    }

    /**
     * Returns an {@link LlvmInvokeNode} for the given parameters.
     *
     * @param functionNode The function being called
     * @param parameterNodes The parameters of the function call
     * @param finalToken A token used to determine the end of the sourceSelection for this call
     * @return An LlvmInvokeNode for the given parameters.
     */
    public LlvmExpressionNode createCall(LlvmExpressionNode functionNode, List<LlvmExpressionNode> parameterNodes, Token finalToken) {
        final int startPos = functionNode.getSourceSection().getCharIndex();
        final int endPos = finalToken.getStartIndex() + finalToken.getText().length();
        final SourceSection src = source.createSection(functionNode.getSourceSection().getIdentifier(), startPos, endPos - startPos);
        return LlvmInvokeNode.create(src, functionNode, parameterNodes.toArray(new LlvmExpressionNode[parameterNodes.size()]));
    }

    /**
     * Returns an {@link LlvmWriteLocalVariableNode} for the given parameters.
     *
     * @param nameToken The name of the variable being assigned
     * @param valueNode The value to be assigned
     * @return An LlvmExpressionNode for the given parameters.
     */
    public LlvmExpressionNode createAssignment(Token nameToken, LlvmExpressionNode valueNode) {
        FrameSlot frameLlvmot = frameDescriptor.findOrAddFrameSlot(nameToken.getText());
        lexicalScope.locals.put(nameToken.getText(), frameLlvmot);
        final int start = nameToken.getStartIndex();
        final int length = valueNode.getSourceSection().getCharEndIndex() - start;
        return LlvmWriteLocalVariableNodeGen.create(source.createSection("=", start, length), valueNode, frameLlvmot);
    }

    public LlvmExpressionNode createReassignment(Token nameToken, LlvmExpressionNode valueNode) {
        FrameSlot frameLlvmot = frameDescriptor.findOrAddFrameSlot(nameToken.getText());
        lexicalScope.locals.put(nameToken.getText(), frameLlvmot);
        final int start = nameToken.getStartIndex();
        final int length = start - valueNode.getSourceSection().getCharIndex();
        return LlvmWriteLocalArrayVariableNodeGen.create(source.createSection("=", start, length), valueNode, frameLlvmot);
    }

    public LlvmStatementNode createBasicBlockNode(Token nameToken, List<LlvmStatementNode> bodyNodes, int startPos, int length) {
        // lexicalScope = lexicalScope.outer;
        FrameSlot frameLlvmot = frameDescriptor.findOrAddFrameSlot(nameToken.getText());
        lexicalScope.locals.put(nameToken.getText(), frameLlvmot);
        List<LlvmStatementNode> flattenedNodes = new ArrayList<>(bodyNodes.size());
        flattenBlocks(bodyNodes, flattenedNodes);
        final SourceSection src = source.createSection(nameToken.getText(), startPos, length);
        LlvmBlockNode blockNode = new LlvmBlockNode(src, flattenedNodes.toArray(new LlvmStatementNode[flattenedNodes.size()]));
        // 这句话关键
        blockNode.assignSourceSection(src);
        lexicalScope.blockMap.put(nameToken.getText(), blockNode);
        return blockNode;
    }

// public LlvmExpressionNode createReadBlock(Token nameToken) {
// final FrameSlot frameLlvmot = lexicalScope.locals.get(nameToken.getText());
// final SourceSection src = srcFromToken(nameToken);
// if (frameLlvmot != null) {
// return LlvmReadLocalVariableNodeGen.create(src, frameLlvmot);
// } else {
// // read before writen
// FrameSlot frameLlvmotTwo = frameDescriptor.findOrAddFrameSlot(nameToken.getText());
// lexicalScope.locals.put(nameToken.getText(), frameLlvmotTwo);
// final int start = nameToken.getStartIndex();
// final int length = 50;
// return LlvmWriteLocalVariableNodeGen.create(source.createSection("=", start, length), null,
// frameLlvmot);
// }
// }

// public LlvmExpressionNode createCallBasicBlock(Token nameToken, Token finalToken) {
// FrameSlot frameLlvmot = frameDescriptor.findOrAddFrameSlot(nameToken.getText());
// lexicalScope.locals.put(nameToken.getText(), frameLlvmot);
// final int startPos = nameToken.getStartIndex();
// final int endPos = finalToken.getStartIndex() + finalToken.getText().length();
// final SourceSection src = source.createSection(nameToken.getText(), startPos, endPos - startPos);
// LlvmExpressionNode basicBlockNode = this.createRead(nameToken);
// return LlvmInvokeBasicBlockNode.create(src, nameToken, basicBlockNode);
// }
    public LlvmStatementNode createCallBasicBlock(LlvmExpressionNode blockNode, Token finalToken) {
        final int startPos = blockNode.getSourceSection().getCharIndex();
        final int endPos = finalToken.getStartIndex() + finalToken.getText().length();
        final SourceSection src = source.createSection(blockNode.getSourceSection().getIdentifier(), startPos, endPos - startPos);
        // return LlvmInvokeBasicBlockNode.create(src, blockNode);
        return lexicalScope.blockMap.get(blockNode.getSourceSection().getIdentifier());
    }

    public LlvmExpressionNode createisReadBlock(Token nameToken) {
        FrameSlot frameLlvmot = lexicalScope.locals.get(nameToken.getText());
        final SourceSection src = srcFromToken(nameToken);
        if (frameLlvmot != null) {
            return LlvmReadLocalVariableNodeGen.create(src, frameLlvmot);
        } else {
// LlvmBlockNode block = new LlvmBlockNode(src, null);
// block.assignSourceSection(src);
// frameLlvmot = frameDescriptor.findOrAddFrameSlot(nameToken.getText());
// lexicalScope.locals.put(nameToken.getText(), frameLlvmot);
// return new LlvmBasicBlockLiteralNode(src, block);
            return null;
        }
    }

//
// /**
// * Returns a {@link LlvmReadLocalVariableNode} if this read is a local variable or a
// * {@link LlvmFunctionLiteralNode} if this read is global. In Simple, the only global names are
// * functions. </br> There is currently no instrumentation for this node.
// *
// * @param nameToken The name of the variable/function being read
// * @return either:
// * <ul>
// * <li>A LlvmReadLocalVariableNode representing the local variable being read.</li>
// * <li>A LlvmFunctionLiteralNode representing the function definition</li>
// * </ul>
// */
    public LlvmExpressionNode createRead(Token nameToken) {
        final FrameSlot frameLlvmot = lexicalScope.locals.get(nameToken.getText());
        final SourceSection src = srcFromToken(nameToken);
        if (frameLlvmot != null) {
            /* Read of a local variable. */
            // return new LlvmFunctionLiteralNode(src,
// context.getFunctionRegistry().lookup(nameToken.val));
            return LlvmReadLocalVariableNodeGen.create(src, frameLlvmot);
        } else {
            /* Read of a global name. In our language, the only global names are functions. */
            return new LlvmFunctionLiteralNode(src, context.getFunctionRegistry().lookup(nameToken.getText()));
        }
    }

    public LlvmExpressionNode createStringLiteral(Token literalToken) {
        /* Remove the trailing and ending " */
        String literal = literalToken.getText();
        assert literal.length() >= 2 && literal.startsWith("\"") && literal.endsWith("\"");
        final SourceSection src = srcFromToken(literalToken);
        literal = literal.substring(1, literal.length() - 1);

        return new LlvmStringLiteralNode(src, literal);
    }

    public LlvmExpressionNode createNumericLiteral(Token literalToken) {
        final SourceSection src = srcFromToken(literalToken);
        try {
            /* Try if the literal is small enough to fit into a long value. */
            return new LlvmLongLiteralNode(src, Long.parseLong(literalToken.getText()));
        } catch (NumberFormatException ex) {
            /* Overflow of long value, so fall back to BigInteger. */
            return new LlvmBigIntegerLiteralNode(src, new BigInteger(literalToken.getText()));
        }
    }

    public LlvmExpressionNode createFloatLiteral(Token literalToken) {
        final SourceSection src = srcFromToken(literalToken);
        try {
            /* Try if the literal is small enough to fit into a long value. */
            return new LlvmFloatLiteralNode(src, Long.parseLong(literalToken.getText()));
        } catch (NumberFormatException ex) {
            /* Overflow of long value, so fall back to BigInteger. */
            return new LlvmDoubleLiteralNode(src, new Double(literalToken.getText()));
        }
    }

    public LlvmExpressionNode createArrayLiteral(Token literalToken) {
        final SourceSection src = srcFromToken(literalToken);
        String[] str = literalToken.getText().split("x");
        switch (str[0]) {
            case "i32":
            case "i8":
                return new LlvmIntArrayLiteralNode(src, new int[Integer.parseInt(str[1])]);
            case "i64":
                return new LlvmBigIntArrayLiteralNode(src, new BigInteger[Integer.parseInt(str[1])]);
        }
        return null;
    }

    public LlvmExpressionNode createParenExpression(LlvmExpressionNode expressionNode, int start, int length) {
        final SourceSection src = source.createSection("()", start, length);
        return new LlvmParenExpressionNode(src, expressionNode);
    }

    /**
     * Returns an {@link LlvmReadPropertyNode} for the given parameters.
     *
     * @param receiverNode The receiver of the property access
     * @param nameToken The name of the property being accessed
     * @return An LlvmExpressionNode for the given parameters.
     */
    public LlvmExpressionNode createReadProperty(LlvmExpressionNode receiverNode, Token nameToken) {
        final int startPos = receiverNode.getSourceSection().getCharIndex();
        final int endPos = nameToken.getStartIndex() + nameToken.getText().length();
        final SourceSection src = source.createSection(".", startPos, endPos - startPos);
        return LlvmReadPropertyNode.create(src, receiverNode, nameToken.getText());
    }

    /**
     * Returns an {@link LlvmWritePropertyNode} for the given parameters.
     *
     * @param receiverNode The receiver object of the property assignment
     * @param nameToken The name of the property being assigned
     * @param valueNode The value to be assigned
     * @return An LlvmExpressionNode for the given parameters.
     */
    public LlvmExpressionNode createWriteProperty(LlvmExpressionNode receiverNode, Token nameToken, LlvmExpressionNode valueNode) {
        final int start = receiverNode.getSourceSection().getCharIndex();
        final int length = valueNode.getSourceSection().getCharEndIndex() - start;
        SourceSection src = source.createSection("=", start, length);
        return LlvmWritePropertyNode.create(src, receiverNode, nameToken.getText(), valueNode);
    }

    /**
     * Creates source description of a single token.
     */
    private SourceSection srcFromToken(Token token) {
        return source.createSection(token.getText(), token.getStartIndex(), token.getText().length());
    }

}
