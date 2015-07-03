// $ANTLR : "LlvmParser.g" -> "CalParser.java"$

package com.oracle.truffle.llvm.parser;

import antlr.TokenBuffer;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.ANTLRException;
import antlr.LLkParser;
import antlr.Token;
import antlr.TokenStream;
import antlr.RecognitionException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.ParserSharedInputState;
import antlr.collections.impl.BitSet;
import antlr.collections.AST;

import java.util.Hashtable;

import antlr.ASTFactory;
import antlr.ASTPair;
import antlr.collections.impl.ASTArray;

import com.oracle.truffle.api.source.*;
import com.oracle.truffle.llvm.nodes.*;
import com.oracle.truffle.llvm.nodes.expression.*;
import com.oracle.truffle.llvm.parser.*;
import com.oracle.truffle.llvm.runtime.*;

public class CalParser extends antlr.LLkParser implements CalParserTokenTypes {

    LlvmNodeFactory factory;
    LlvmAddNodeGen addNodeGen;

    protected CalParser(TokenBuffer tokenBuf, int k) {
        super(tokenBuf, k);
        tokenNames = _tokenNames;
        buildTokenTypeASTClassMap();
        astFactory = new ASTFactory(getTokenTypeToASTClassMap());
    }

    public CalParser(TokenBuffer tokenBuf) {
        this(tokenBuf, 1);
    }

    protected CalParser(TokenStream lexer, int k) {
        super(lexer, k);
        tokenNames = _tokenNames;
        buildTokenTypeASTClassMap();
        astFactory = new ASTFactory(getTokenTypeToASTClassMap());
    }

    public CalParser(TokenStream lexer) {
        this(lexer, 1);
    }

    public CalParser(ParserSharedInputState state) {
        super(state, 1);
        tokenNames = _tokenNames;
        buildTokenTypeASTClassMap();
        astFactory = new ASTFactory(getTokenTypeToASTClassMap());
    }

    public final void prog() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST prog_AST = null;

        try {      // for error handling
            AST tmp1_AST = null;
            tmp1_AST = astFactory.create(LT(1));
            astFactory.makeASTRoot(currentAST, tmp1_AST);
            match(StringIndifier);
            AST tmp2_AST = null;
            tmp2_AST = astFactory.create(LT(1));
            astFactory.addASTChild(currentAST, tmp2_AST);
            match(Equal);
            expr();
            astFactory.addASTChild(currentAST, returnAST);
            prog_AST = (AST) currentAST.root;
        } catch (RecognitionException ex) {
            reportError(ex);
            recover(ex, _tokenSet_0);
        }
        returnAST = prog_AST;
    }

    public final void expr() throws RecognitionException, TokenStreamException {

        returnAST = null;
        ASTPair currentAST = new ASTPair();
        AST expr_AST = null;

        try {      // for error handling
            AST tmp3_AST = null;
            LlvmExpressionNode left;
            LlvmExpressionNode right;
            tmp3_AST = astFactory.create(LT(1));
            astFactory.makeASTRoot(currentAST, tmp3_AST);
            match(ADD);
            {
                AST tmp4_AST = null;
                tmp4_AST = astFactory.create(LT(1));
                astFactory.addASTChild(currentAST, tmp4_AST);
                match(Number);
                left = (LlvmExpressionNode) tmp4_AST;
            }
            {
                AST tmp5_AST = null;
                tmp5_AST = astFactory.create(LT(1));
                astFactory.addASTChild(currentAST, tmp5_AST);
                match(Number);
                right = (LlvmExpressionNode) tmp5_AST;
            }
            factory.createBinary("ADD", left, right);

            expr_AST = (AST) currentAST.root;
        } catch (RecognitionException ex) {
            reportError(ex);
            recover(ex, _tokenSet_0);
        }
        returnAST = expr_AST;
    }

    public static final String[] _tokenNames = {"<0>", "EOF", "<2>", "NULL_TREE_LOOKAHEAD", "StringIndifier", "Equal", "ADD", "Number", "Function", "SUB", "MUL", "DIV", "REM", "BlockIndifier",
                    "NumberIndifier", "String", "WS"};

    protected void buildTokenTypeASTClassMap() {
        tokenTypeToASTClassMap = null;
    };

    private static final long[] mk_tokenSet_0() {
        long[] data = {2L, 0L};
        return data;
    }

    public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());

}
