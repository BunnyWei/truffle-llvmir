// Generated from Method.g4 by ANTLR 4.4
package com.oracle.truffle.llvm.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MethodParser}.
 */
public interface MethodListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MethodParser#r}.
	 * @param ctx the parse tree
	 */
	void enterR(@NotNull MethodParser.RContext ctx);
	/**
	 * Exit a parse tree produced by {@link MethodParser#r}.
	 * @param ctx the parse tree
	 */
	void exitR(@NotNull MethodParser.RContext ctx);
}