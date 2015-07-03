// Generated from MethodSL.g4 by ANTLR 4.4
package com.oracle.truffle.llvm.parser;

import com.oracle.truffle.llvm.parser.*;

import com.oracle.truffle.llvm.nodes.*;
import com.oracle.truffle.api.source.*;
import com.oracle.truffle.llvm.runtime.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by {@link MethodSLParser}.
 */
public interface MethodSLListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link MethodSLParser#funcDec}.
     *
     * @param ctx the parse tree
     */
    void enterFuncDec(@NotNull MethodSLParser.FuncDecContext ctx);

    /**
     * Exit a parse tree produced by {@link MethodSLParser#funcDec}.
     *
     * @param ctx the parse tree
     */
    void exitFuncDec(@NotNull MethodSLParser.FuncDecContext ctx);

    /**
     * Enter a parse tree produced by {@link MethodSLParser#add}.
     *
     * @param ctx the parse tree
     */
    void enterAdd(@NotNull MethodSLParser.AddContext ctx);

    /**
     * Exit a parse tree produced by {@link MethodSLParser#add}.
     *
     * @param ctx the parse tree
     */
    void exitAdd(@NotNull MethodSLParser.AddContext ctx);

    /**
     * Enter a parse tree produced by {@link MethodSLParser#expression}.
     *
     * @param ctx the parse tree
     */
    void enterExpression(@NotNull MethodSLParser.ExpressionContext ctx);

    /**
     * Exit a parse tree produced by {@link MethodSLParser#expression}.
     *
     * @param ctx the parse tree
     */
    void exitExpression(@NotNull MethodSLParser.ExpressionContext ctx);

    /**
     * Enter a parse tree produced by {@link MethodSLParser#storeExpr}.
     *
     * @param ctx the parse tree
     */
    void enterStoreExpr(@NotNull MethodSLParser.StoreExprContext ctx);

    /**
     * Exit a parse tree produced by {@link MethodSLParser#storeExpr}.
     *
     * @param ctx the parse tree
     */
    void exitStoreExpr(@NotNull MethodSLParser.StoreExprContext ctx);

    /**
     * Enter a parse tree produced by {@link MethodSLParser#statements}.
     *
     * @param ctx the parse tree
     */
    void enterStatements(@NotNull MethodSLParser.StatementsContext ctx);

    /**
     * Exit a parse tree produced by {@link MethodSLParser#statements}.
     *
     * @param ctx the parse tree
     */
    void exitStatements(@NotNull MethodSLParser.StatementsContext ctx);

    /**
     * Enter a parse tree produced by {@link MethodSLParser#funcStart}.
     *
     * @param ctx the parse tree
     */
    void enterFuncStart(@NotNull MethodSLParser.FuncStartContext ctx);

    /**
     * Exit a parse tree produced by {@link MethodSLParser#funcStart}.
     *
     * @param ctx the parse tree
     */
    void exitFuncStart(@NotNull MethodSLParser.FuncStartContext ctx);

    /**
     * Enter a parse tree produced by {@link MethodSLParser#allocaExpr}.
     *
     * @param ctx the parse tree
     */
    void enterAllocaExpr(@NotNull MethodSLParser.AllocaExprContext ctx);

    /**
     * Exit a parse tree produced by {@link MethodSLParser#allocaExpr}.
     *
     * @param ctx the parse tree
     */
    void exitAllocaExpr(@NotNull MethodSLParser.AllocaExprContext ctx);

    /**
     * Enter a parse tree produced by {@link MethodSLParser#prog}.
     *
     * @param ctx the parse tree
     */
    void enterProg(@NotNull MethodSLParser.ProgContext ctx);

    /**
     * Exit a parse tree produced by {@link MethodSLParser#prog}.
     *
     * @param ctx the parse tree
     */
    void exitProg(@NotNull MethodSLParser.ProgContext ctx);

    /**
     * Enter a parse tree produced by {@link MethodSLParser#call}.
     *
     * @param ctx the parse tree
     */
    void enterCall(@NotNull MethodSLParser.CallContext ctx);

    /**
     * Exit a parse tree produced by {@link MethodSLParser#call}.
     *
     * @param ctx the parse tree
     */
    void exitCall(@NotNull MethodSLParser.CallContext ctx);

    /**
     * Enter a parse tree produced by {@link MethodSLParser#printFunction}.
     *
     * @param ctx the parse tree
     */
    void enterPrintFunction(@NotNull MethodSLParser.PrintFunctionContext ctx);

    /**
     * Exit a parse tree produced by {@link MethodSLParser#printFunction}.
     *
     * @param ctx the parse tree
     */
    void exitPrintFunction(@NotNull MethodSLParser.PrintFunctionContext ctx);

    /**
     * Enter a parse tree produced by {@link MethodSLParser#methodParams}.
     *
     * @param ctx the parse tree
     */
    void enterMethodParams(@NotNull MethodSLParser.MethodParamsContext ctx);

    /**
     * Exit a parse tree produced by {@link MethodSLParser#methodParams}.
     *
     * @param ctx the parse tree
     */
    void exitMethodParams(@NotNull MethodSLParser.MethodParamsContext ctx);

    /**
     * Enter a parse tree produced by {@link MethodSLParser#load}.
     *
     * @param ctx the parse tree
     */
    void enterLoad(@NotNull MethodSLParser.LoadContext ctx);

    /**
     * Exit a parse tree produced by {@link MethodSLParser#load}.
     *
     * @param ctx the parse tree
     */
    void exitLoad(@NotNull MethodSLParser.LoadContext ctx);

    /**
     * Enter a parse tree produced by {@link MethodSLParser#statement}.
     *
     * @param ctx the parse tree
     */
    void enterStatement(@NotNull MethodSLParser.StatementContext ctx);

    /**
     * Exit a parse tree produced by {@link MethodSLParser#statement}.
     *
     * @param ctx the parse tree
     */
    void exitStatement(@NotNull MethodSLParser.StatementContext ctx);

    /**
     * Enter a parse tree produced by {@link MethodSLParser#sext}.
     *
     * @param ctx the parse tree
     */
    void enterSext(@NotNull MethodSLParser.SextContext ctx);

    /**
     * Exit a parse tree produced by {@link MethodSLParser#sext}.
     *
     * @param ctx the parse tree
     */
    void exitSext(@NotNull MethodSLParser.SextContext ctx);

    /**
     * Enter a parse tree produced by {@link MethodSLParser#funcBody}.
     *
     * @param ctx the parse tree
     */
    void enterFuncBody(@NotNull MethodSLParser.FuncBodyContext ctx);

    /**
     * Exit a parse tree produced by {@link MethodSLParser#funcBody}.
     *
     * @param ctx the parse tree
     */
    void exitFuncBody(@NotNull MethodSLParser.FuncBodyContext ctx);
}