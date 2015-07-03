// Generated from MethodSL.g4 by ANTLR 4.4
package com.oracle.truffle.llvm.parser;

import com.oracle.truffle.llvm.parser.*;

import com.oracle.truffle.llvm.nodes.*;
import com.oracle.truffle.api.source.*;
import com.oracle.truffle.llvm.runtime.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

//@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MethodSLParser extends Parser {
    static {
        RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
    public static final int T__5 = 1, T__4 = 2, T__3 = 3, T__2 = 4, T__1 = 5, T__0 = 6, PrintIdentifer = 7, ReturnIdentifer = 8, MethodIdentifer = 9, DefineIdentifer = 10, ClassIdentifer = 11,
                    AllocIdentifer = 12, StoreIdentifer = 13, LoadIdentifer = 14, AddIdentifer = 15, SubIdentifer = 16, MulIdentifer = 17, DivIdentifer = 18, AlignIdentifer = 19, CallIdentifer = 20,
                    SextIdentifer = 21, NuwNsWIdentifer = 22, VariaIdentifer = 23, Number = 24, LeftBracket = 25, RightBracket = 26, LParentheses = 27, RParentheses = 28, Equal = 29, PrintPara = 30,
                    Type = 31, ID = 32, Commend = 33, CommendTwo = 34, CommendThr = 35, NEWLINE = 36, WS = 37;
    public static final String[] tokenNames = {"<INVALID>", "')*'", "'...'", "'getelementptr'", "'to'", "'inbounds'", "','", "'@printf'", "'ret'", "MethodIdentifer", "'define'", "'ModuleID'",
                    "'alloca'", "'store'", "'load'", "AddIdentifer", "SubIdentifer", "MulIdentifer", "DivIdentifer", "'align'", "'call'", "'sext'", "NuwNsWIdentifer", "VariaIdentifer", "Number",
                    "'{'", "'}'", "'('", "')'", "'='", "PrintPara", "Type", "ID", "Commend", "CommendTwo", "CommendThr", "NEWLINE", "WS"};
    public static final int RULE_prog = 0, RULE_funcDec = 1, RULE_methodParams = 2, RULE_funcStart = 3, RULE_funcBody = 4, RULE_statements = 5, RULE_statement = 6, RULE_allocaExpr = 7,
                    RULE_storeExpr = 8, RULE_expression = 9, RULE_load = 10, RULE_add = 11, RULE_sext = 12, RULE_call = 13, RULE_printFunction = 14;
    public static final String[] ruleNames = {"prog", "funcDec", "methodParams", "funcStart", "funcBody", "statements", "statement", "allocaExpr", "storeExpr", "expression", "load", "add", "sext",
                    "call", "printFunction"};

    @Override
    public String getGrammarFileName() {
        return "MethodSL.g4";
    }

    @Override
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    int BlockStart;
    int BlockEnd;
    int CharPos = 0;
    LlvmContext context;
    Source source;
    LlvmNodeFactory factory;

    public MethodSLParser(TokenStream input, LlvmContext context, Source source) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
        this.context = context;
        this.source = source;
        factory = new LlvmNodeFactory(context, source);
    }

    public static class ProgContext extends ParserRuleContext {
        public List<FuncDecContext> funcDec() {
            return getRuleContexts(FuncDecContext.class);
        }

        public FuncDecContext funcDec(int i) {
            return getRuleContext(FuncDecContext.class, i);
        }

        public ProgContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_prog;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MethodSLListener)
                ((MethodSLListener) listener).enterProg(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MethodSLListener)
                ((MethodSLListener) listener).exitProg(this);
        }
    }

    public final ProgContext prog() throws RecognitionException {
        ProgContext _localctx = new ProgContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_prog);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(31);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(30);
                            funcDec();
                        }
                    }
                    setState(33);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (_la == DefineIdentifer);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FuncDecContext extends ParserRuleContext {
        public Token Type;
        public Token MethodIdentifer;

        public TerminalNode VariaIdentifer() {
            return getToken(MethodSLParser.VariaIdentifer, 0);
        }

        public FuncStartContext funcStart() {
            return getRuleContext(FuncStartContext.class, 0);
        }

        public MethodParamsContext methodParams() {
            return getRuleContext(MethodParamsContext.class, 0);
        }

        public TerminalNode DefineIdentifer() {
            return getToken(MethodSLParser.DefineIdentifer, 0);
        }

        public TerminalNode Type() {
            return getToken(MethodSLParser.Type, 0);
        }

        public TerminalNode MethodIdentifer() {
            return getToken(MethodSLParser.MethodIdentifer, 0);
        }

        public FuncDecContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_funcDec;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MethodSLListener)
                ((MethodSLListener) listener).enterFuncDec(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MethodSLListener)
                ((MethodSLListener) listener).exitFuncDec(this);
        }
    }

    public final FuncDecContext funcDec() throws RecognitionException {
        FuncDecContext _localctx = new FuncDecContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_funcDec);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(35);
                match(DefineIdentifer);
                setState(36);
                ((FuncDecContext) _localctx).Type = match(Type);
                setState(37);
                ((FuncDecContext) _localctx).MethodIdentifer = match(MethodIdentifer);

                CharPos += 6 + ((((FuncDecContext) _localctx).Type != null ? ((FuncDecContext) _localctx).Type.getText() : null)).length() +
                                ((((FuncDecContext) _localctx).MethodIdentifer != null ? ((FuncDecContext) _localctx).MethodIdentifer.getText() : null)).length();
                int bodyStartPos = CharPos;
                factory.startFunction(((FuncDecContext) _localctx).MethodIdentifer, bodyStartPos);

                setState(39);
                match(LParentheses);
                setState(41);
                switch (getInterpreter().adaptivePredict(_input, 1, _ctx)) {
                    case 1: {
                        setState(40);
                        methodParams();
                    }
                        break;
                }
                setState(43);
                match(RParentheses);
                setState(45);
                _la = _input.LA(1);
                if (_la == VariaIdentifer) {
                    {
                        setState(44);
                        match(VariaIdentifer);
                    }
                }

                setState(47);
                funcStart();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class MethodParamsContext extends ParserRuleContext {
        public Token Type;
        public Token VariaIdentifer;

        public List<TerminalNode> VariaIdentifer() {
            return getTokens(MethodSLParser.VariaIdentifer);
        }

        public TerminalNode Type(int i) {
            return getToken(MethodSLParser.Type, i);
        }

        public TerminalNode VariaIdentifer(int i) {
            return getToken(MethodSLParser.VariaIdentifer, i);
        }

        public List<TerminalNode> Type() {
            return getTokens(MethodSLParser.Type);
        }

        public MethodParamsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_methodParams;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MethodSLListener)
                ((MethodSLListener) listener).enterMethodParams(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MethodSLListener)
                ((MethodSLListener) listener).exitMethodParams(this);
        }
    }

    public final MethodParamsContext methodParams() throws RecognitionException {
        MethodParamsContext _localctx = new MethodParamsContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_methodParams);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(61);
                _la = _input.LA(1);
                if (_la == Type) {
                    {
                        setState(49);
                        ((MethodParamsContext) _localctx).Type = match(Type);
                        setState(50);
                        ((MethodParamsContext) _localctx).VariaIdentifer = match(VariaIdentifer);

                        CharPos += ((((MethodParamsContext) _localctx).Type != null ? ((MethodParamsContext) _localctx).Type.getText() : null)).length() +
                                        ((((MethodParamsContext) _localctx).VariaIdentifer != null ? ((MethodParamsContext) _localctx).VariaIdentifer.getText() : null)).length();
                        factory.addFormalParameter(((MethodParamsContext) _localctx).VariaIdentifer);

                        setState(58);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == T__0) {
                            {
                                {
                                    setState(52);
                                    match(T__0);
                                    setState(53);
                                    ((MethodParamsContext) _localctx).Type = match(Type);
                                    setState(54);
                                    ((MethodParamsContext) _localctx).VariaIdentifer = match(VariaIdentifer);

                                    CharPos += 1 + ((((MethodParamsContext) _localctx).Type != null ? ((MethodParamsContext) _localctx).Type.getText() : null)).length() +
                                                    ((((MethodParamsContext) _localctx).VariaIdentifer != null ? ((MethodParamsContext) _localctx).VariaIdentifer.getText() : null)).length();
                                    factory.addFormalParameter(((MethodParamsContext) _localctx).VariaIdentifer);

                                }
                            }
                            setState(60);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FuncStartContext extends ParserRuleContext {
        public int start;
        public int length;
        public Token LeftBracket;
        public Token RightBracket;

        public TerminalNode RightBracket() {
            return getToken(MethodSLParser.RightBracket, 0);
        }

        public TerminalNode LeftBracket() {
            return getToken(MethodSLParser.LeftBracket, 0);
        }

        public FuncBodyContext funcBody() {
            return getRuleContext(FuncBodyContext.class, 0);
        }

        public TerminalNode NEWLINE() {
            return getToken(MethodSLParser.NEWLINE, 0);
        }

        public FuncStartContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_funcStart;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MethodSLListener)
                ((MethodSLListener) listener).enterFuncStart(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MethodSLListener)
                ((MethodSLListener) listener).exitFuncStart(this);
        }
    }

    public final FuncStartContext funcStart() throws RecognitionException {
        FuncStartContext _localctx = new FuncStartContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_funcStart);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(63);
                ((FuncStartContext) _localctx).LeftBracket = match(LeftBracket);
                setState(65);
                _la = _input.LA(1);
                if (_la == NEWLINE) {
                    {
                        setState(64);
                        match(NEWLINE);
                    }
                }

                CharPos += ((((FuncStartContext) _localctx).LeftBracket != null ? ((FuncStartContext) _localctx).LeftBracket.getText() : null)).length();
                BlockStart = CharPos;

                setState(68);
                funcBody();
                setState(69);
                ((FuncStartContext) _localctx).RightBracket = match(RightBracket);

                CharPos += ((((FuncStartContext) _localctx).RightBracket != null ? ((FuncStartContext) _localctx).RightBracket.getText() : null)).length();

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FuncBodyContext extends ParserRuleContext {
        public StatementsContext block;

        public StatementsContext statements() {
            return getRuleContext(StatementsContext.class, 0);
        }

        public FuncBodyContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_funcBody;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MethodSLListener)
                ((MethodSLListener) listener).enterFuncBody(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MethodSLListener)
                ((MethodSLListener) listener).exitFuncBody(this);
        }
    }

    public final FuncBodyContext funcBody() throws RecognitionException {
        FuncBodyContext _localctx = new FuncBodyContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_funcBody);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(72);
                ((FuncBodyContext) _localctx).block = statements();

                factory.finishFunction(((FuncBodyContext) _localctx).block.result);

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class StatementsContext extends ParserRuleContext {
        public LlvmStatementNode result;
        public StatementContext listStatements;

        public StatementContext statement(int i) {
            return getRuleContext(StatementContext.class, i);
        }

        public List<StatementContext> statement() {
            return getRuleContexts(StatementContext.class);
        }

        public StatementsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_statements;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MethodSLListener)
                ((MethodSLListener) listener).enterStatements(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MethodSLListener)
                ((MethodSLListener) listener).exitStatements(this);
        }
    }

    public final StatementsContext statements() throws RecognitionException {
        StatementsContext _localctx = new StatementsContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_statements);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {

                factory.startBlock();
                List<LlvmStatementNode> list = new ArrayList();

                setState(81);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AllocIdentifer) | (1L << StoreIdentifer) | (1L << CallIdentifer) | (1L << VariaIdentifer))) != 0)) {
                    {
                        {
                            setState(76);
                            ((StatementsContext) _localctx).listStatements = statement();

                            LlvmStatementNode statementNode = ((StatementsContext) _localctx).listStatements.result;
                            list.add(statementNode);

                        }
                    }
                    setState(83);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }

                // System.out.println("the start is:"+BlockStart);
                BlockEnd = CharPos;
                // System.out.println("the end is:"+BlockEnd);
                ((StatementsContext) _localctx).result = factory.finishBlock(list, BlockStart, BlockEnd);

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class StatementContext extends ParserRuleContext {
        public LlvmStatementNode result;
        public StoreExprContext store;
        public AllocaExprContext alloca;
        public ExpressionContext expr;
        public CallContext recall;

        public StoreExprContext storeExpr() {
            return getRuleContext(StoreExprContext.class, 0);
        }

        public AllocaExprContext allocaExpr() {
            return getRuleContext(AllocaExprContext.class, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public CallContext call() {
            return getRuleContext(CallContext.class, 0);
        }

        public StatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_statement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MethodSLListener)
                ((MethodSLListener) listener).enterStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MethodSLListener)
                ((MethodSLListener) listener).exitStatement(this);
        }
    }

    public final StatementContext statement() throws RecognitionException {
        StatementContext _localctx = new StatementContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_statement);
        try {
            setState(98);
            switch (_input.LA(1)) {
                case StoreIdentifer:
                    enterOuterAlt(_localctx, 1);
                    {
                        setState(86);
                        ((StatementContext) _localctx).store = storeExpr();

                        ((StatementContext) _localctx).result = ((StatementContext) _localctx).store.result;

                    }
                    break;
                case AllocIdentifer:
                    enterOuterAlt(_localctx, 2);
                    {
                        setState(89);
                        ((StatementContext) _localctx).alloca = allocaExpr();

                        ((StatementContext) _localctx).result = ((StatementContext) _localctx).alloca.result;

                    }
                    break;
                case VariaIdentifer:
                    enterOuterAlt(_localctx, 3);
                    {
                        setState(92);
                        ((StatementContext) _localctx).expr = expression();

                        ((StatementContext) _localctx).result = ((StatementContext) _localctx).expr.result;

                    }
                    break;
                case CallIdentifer:
                    enterOuterAlt(_localctx, 4);
                    {
                        setState(95);
                        ((StatementContext) _localctx).recall = call();

                        ((StatementContext) _localctx).result = ((StatementContext) _localctx).recall.result;

                    }
                    break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class AllocaExprContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Token Type;
        public Token Number;

        public TerminalNode AllocIdentifer() {
            return getToken(MethodSLParser.AllocIdentifer, 0);
        }

        public TerminalNode AlignIdentifer() {
            return getToken(MethodSLParser.AlignIdentifer, 0);
        }

        public TerminalNode Number() {
            return getToken(MethodSLParser.Number, 0);
        }

        public TerminalNode Type() {
            return getToken(MethodSLParser.Type, 0);
        }

        public AllocaExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_allocaExpr;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MethodSLListener)
                ((MethodSLListener) listener).enterAllocaExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MethodSLListener)
                ((MethodSLListener) listener).exitAllocaExpr(this);
        }
    }

    public final AllocaExprContext allocaExpr() throws RecognitionException {
        AllocaExprContext _localctx = new AllocaExprContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_allocaExpr);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(100);
                match(AllocIdentifer);
                setState(101);
                ((AllocaExprContext) _localctx).Type = match(Type);
                setState(102);
                match(T__0);
                setState(103);
                match(AlignIdentifer);
                setState(104);
                ((AllocaExprContext) _localctx).Number = match(Number);

                CharPos += 6 + ((((AllocaExprContext) _localctx).Type != null ? ((AllocaExprContext) _localctx).Type.getText() : null)).length() + 6 +
                                ((((AllocaExprContext) _localctx).Number != null ? ((AllocaExprContext) _localctx).Number.getText() : null)).length();
                ((AllocaExprContext) _localctx).result = factory.createNumericLiteral(((AllocaExprContext) _localctx).Number);

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class StoreExprContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Token Type;
        public Token Number;
        public Token VariaIdentifer;

        public List<TerminalNode> VariaIdentifer() {
            return getTokens(MethodSLParser.VariaIdentifer);
        }

        public TerminalNode Type(int i) {
            return getToken(MethodSLParser.Type, i);
        }

        public TerminalNode StoreIdentifer() {
            return getToken(MethodSLParser.StoreIdentifer, 0);
        }

        public TerminalNode AlignIdentifer() {
            return getToken(MethodSLParser.AlignIdentifer, 0);
        }

        public List<TerminalNode> Number() {
            return getTokens(MethodSLParser.Number);
        }

        public TerminalNode VariaIdentifer(int i) {
            return getToken(MethodSLParser.VariaIdentifer, i);
        }

        public List<TerminalNode> Type() {
            return getTokens(MethodSLParser.Type);
        }

        public TerminalNode Number(int i) {
            return getToken(MethodSLParser.Number, i);
        }

        public StoreExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_storeExpr;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MethodSLListener)
                ((MethodSLListener) listener).enterStoreExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MethodSLListener)
                ((MethodSLListener) listener).exitStoreExpr(this);
        }
    }

    public final StoreExprContext storeExpr() throws RecognitionException {
        StoreExprContext _localctx = new StoreExprContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_storeExpr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(107);
                match(StoreIdentifer);
                setState(108);
                ((StoreExprContext) _localctx).Type = match(Type);
                setState(113);
                switch (_input.LA(1)) {
                    case Number: {
                        setState(109);
                        ((StoreExprContext) _localctx).Number = match(Number);

                        CharPos += 5 + ((((StoreExprContext) _localctx).Type != null ? ((StoreExprContext) _localctx).Type.getText() : null)).length() +
                                        ((((StoreExprContext) _localctx).Number != null ? ((StoreExprContext) _localctx).Number.getText() : null)).length();
                        ((StoreExprContext) _localctx).result = factory.createNumericLiteral(((StoreExprContext) _localctx).Number);

                    }
                        break;
                    case VariaIdentifer: {
                        setState(111);
                        ((StoreExprContext) _localctx).VariaIdentifer = match(VariaIdentifer);

                        CharPos += 5 + ((((StoreExprContext) _localctx).Type != null ? ((StoreExprContext) _localctx).Type.getText() : null)).length() +
                                        ((((StoreExprContext) _localctx).VariaIdentifer != null ? ((StoreExprContext) _localctx).VariaIdentifer.getText() : null)).length();
                        ((StoreExprContext) _localctx).result = factory.createRead(((StoreExprContext) _localctx).VariaIdentifer);

                    }
                        break;
                    default:
                        throw new NoViableAltException(this);
                }
                setState(115);
                match(T__0);
                setState(116);
                ((StoreExprContext) _localctx).Type = match(Type);
                setState(117);
                ((StoreExprContext) _localctx).VariaIdentifer = match(VariaIdentifer);
                setState(121);
                _la = _input.LA(1);
                if (_la == T__0) {
                    {
                        setState(118);
                        match(T__0);
                        setState(119);
                        match(AlignIdentifer);
                        setState(120);
                        ((StoreExprContext) _localctx).Number = match(Number);
                    }
                }

                CharPos += 1 + ((((StoreExprContext) _localctx).Type != null ? ((StoreExprContext) _localctx).Type.getText() : null)).length() +
                                ((((StoreExprContext) _localctx).VariaIdentifer != null ? ((StoreExprContext) _localctx).VariaIdentifer.getText() : null)).length() + 6 +
                                ((((StoreExprContext) _localctx).Number != null ? ((StoreExprContext) _localctx).Number.getText() : null)).length();
                ((StoreExprContext) _localctx).result = factory.createReassignment(((StoreExprContext) _localctx).VariaIdentifer, _localctx.result);

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExpressionContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Token VariaIdentifer;
        public AllocaExprContext ReallocaExpr;
        public LoadContext Reload;
        public AddContext Readd;
        public SextContext Resext;
        public CallContext Recall;

        public TerminalNode VariaIdentifer() {
            return getToken(MethodSLParser.VariaIdentifer, 0);
        }

        public AllocaExprContext allocaExpr() {
            return getRuleContext(AllocaExprContext.class, 0);
        }

        public SextContext sext() {
            return getRuleContext(SextContext.class, 0);
        }

        public CallContext call() {
            return getRuleContext(CallContext.class, 0);
        }

        public LoadContext load() {
            return getRuleContext(LoadContext.class, 0);
        }

        public AddContext add() {
            return getRuleContext(AddContext.class, 0);
        }

        public ExpressionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_expression;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MethodSLListener)
                ((MethodSLListener) listener).enterExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MethodSLListener)
                ((MethodSLListener) listener).exitExpression(this);
        }
    }

    public final ExpressionContext expression() throws RecognitionException {
        ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
        enterRule(_localctx, 18, RULE_expression);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(125);
                ((ExpressionContext) _localctx).VariaIdentifer = match(VariaIdentifer);

                CharPos += ((((ExpressionContext) _localctx).VariaIdentifer != null ? ((ExpressionContext) _localctx).VariaIdentifer.getText() : null)).length();
                factory.createRead(((ExpressionContext) _localctx).VariaIdentifer);

                setState(127);
                match(Equal);
                setState(143);
                switch (_input.LA(1)) {
                    case AllocIdentifer: {
                        setState(128);
                        ((ExpressionContext) _localctx).ReallocaExpr = allocaExpr();

                        CharPos += 1;
                        ((ExpressionContext) _localctx).result = factory.createAssignment(((ExpressionContext) _localctx).VariaIdentifer, ((ExpressionContext) _localctx).ReallocaExpr.result);

                    }
                        break;
                    case LoadIdentifer: {
                        setState(131);
                        ((ExpressionContext) _localctx).Reload = load();

                        CharPos += 1;
                        ((ExpressionContext) _localctx).result = factory.createAssignment(((ExpressionContext) _localctx).VariaIdentifer, ((ExpressionContext) _localctx).Reload.result);

                    }
                        break;
                    case AddIdentifer:
                    case SubIdentifer:
                    case MulIdentifer:
                    case DivIdentifer: {
                        setState(134);
                        ((ExpressionContext) _localctx).Readd = add();

                        CharPos += 1;
                        ((ExpressionContext) _localctx).result = factory.createAssignment(((ExpressionContext) _localctx).VariaIdentifer, ((ExpressionContext) _localctx).Readd.result);

                    }
                        break;
                    case SextIdentifer: {
                        setState(137);
                        ((ExpressionContext) _localctx).Resext = sext();

                        CharPos += 1;
                        ((ExpressionContext) _localctx).result = factory.createAssignment(((ExpressionContext) _localctx).VariaIdentifer, ((ExpressionContext) _localctx).Resext.result);

                    }
                        break;
                    case CallIdentifer: {
                        setState(140);
                        ((ExpressionContext) _localctx).Recall = call();

                        CharPos += 1;
                        ((ExpressionContext) _localctx).result = factory.createAssignment(((ExpressionContext) _localctx).VariaIdentifer, ((ExpressionContext) _localctx).Recall.result);

                    }
                        break;
                    default:
                        throw new NoViableAltException(this);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class LoadContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Token LoadIdentifer;
        public Token Type;
        public Token VariaIdentifer;
        public Token AlignIdentifer;
        public Token Number;

        public TerminalNode VariaIdentifer() {
            return getToken(MethodSLParser.VariaIdentifer, 0);
        }

        public TerminalNode AlignIdentifer() {
            return getToken(MethodSLParser.AlignIdentifer, 0);
        }

        public TerminalNode Number() {
            return getToken(MethodSLParser.Number, 0);
        }

        public TerminalNode LoadIdentifer() {
            return getToken(MethodSLParser.LoadIdentifer, 0);
        }

        public TerminalNode Type() {
            return getToken(MethodSLParser.Type, 0);
        }

        public LoadContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_load;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MethodSLListener)
                ((MethodSLListener) listener).enterLoad(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MethodSLListener)
                ((MethodSLListener) listener).exitLoad(this);
        }
    }

    public final LoadContext load() throws RecognitionException {
        LoadContext _localctx = new LoadContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_load);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(145);
                ((LoadContext) _localctx).LoadIdentifer = match(LoadIdentifer);
                setState(146);
                ((LoadContext) _localctx).Type = match(Type);
                setState(147);
                ((LoadContext) _localctx).VariaIdentifer = match(VariaIdentifer);
                setState(148);
                match(T__0);
                setState(149);
                ((LoadContext) _localctx).AlignIdentifer = match(AlignIdentifer);
                setState(150);
                ((LoadContext) _localctx).Number = match(Number);

                CharPos += ((((LoadContext) _localctx).LoadIdentifer != null ? ((LoadContext) _localctx).LoadIdentifer.getText() : null)).length() +
                                ((((LoadContext) _localctx).Type != null ? ((LoadContext) _localctx).Type.getText() : null)).length() +
                                ((((LoadContext) _localctx).VariaIdentifer != null ? ((LoadContext) _localctx).VariaIdentifer.getText() : null)).length() +
                                ((((LoadContext) _localctx).AlignIdentifer != null ? ((LoadContext) _localctx).AlignIdentifer.getText() : null)).length() +
                                ((((LoadContext) _localctx).Number != null ? ((LoadContext) _localctx).Number.getText() : null)).length();
                ((LoadContext) _localctx).result = factory.createRead(((LoadContext) _localctx).VariaIdentifer);

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class AddContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Token op;
        public Token op2;
        public Token Type;
        public Token vari1;
        public Token vari2;

        public List<TerminalNode> VariaIdentifer() {
            return getTokens(MethodSLParser.VariaIdentifer);
        }

        public TerminalNode SubIdentifer() {
            return getToken(MethodSLParser.SubIdentifer, 0);
        }

        public TerminalNode MulIdentifer() {
            return getToken(MethodSLParser.MulIdentifer, 0);
        }

        public TerminalNode NuwNsWIdentifer(int i) {
            return getToken(MethodSLParser.NuwNsWIdentifer, i);
        }

        public TerminalNode AddIdentifer() {
            return getToken(MethodSLParser.AddIdentifer, 0);
        }

        public TerminalNode VariaIdentifer(int i) {
            return getToken(MethodSLParser.VariaIdentifer, i);
        }

        public TerminalNode DivIdentifer() {
            return getToken(MethodSLParser.DivIdentifer, 0);
        }

        public TerminalNode Type() {
            return getToken(MethodSLParser.Type, 0);
        }

        public List<TerminalNode> NuwNsWIdentifer() {
            return getTokens(MethodSLParser.NuwNsWIdentifer);
        }

        public AddContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_add;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MethodSLListener)
                ((MethodSLListener) listener).enterAdd(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MethodSLListener)
                ((MethodSLListener) listener).exitAdd(this);
        }
    }

    public final AddContext add() throws RecognitionException {
        AddContext _localctx = new AddContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_add);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(153);
                ((AddContext) _localctx).op = _input.LT(1);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AddIdentifer) | (1L << SubIdentifer) | (1L << MulIdentifer) | (1L << DivIdentifer))) != 0))) {
                    ((AddContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                }
                consume();
                setState(157);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == NuwNsWIdentifer) {
                    {
                        {
                            setState(154);
                            ((AddContext) _localctx).op2 = match(NuwNsWIdentifer);
                        }
                    }
                    setState(159);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(160);
                ((AddContext) _localctx).Type = match(Type);
                setState(161);
                ((AddContext) _localctx).vari1 = match(VariaIdentifer);
                setState(162);
                match(T__0);
                setState(163);
                ((AddContext) _localctx).vari2 = match(VariaIdentifer);

                CharPos += ((((AddContext) _localctx).op != null ? ((AddContext) _localctx).op.getText() : null)).length() +
                                ((((AddContext) _localctx).Type != null ? ((AddContext) _localctx).Type.getText() : null)).length() +
                                ((((AddContext) _localctx).vari1 != null ? ((AddContext) _localctx).vari1.getText() : null)).length() +
                                ((((AddContext) _localctx).vari2 != null ? ((AddContext) _localctx).vari2.getText() : null)).length();
                LlvmExpressionNode left = factory.createRead(((AddContext) _localctx).vari1);
                LlvmExpressionNode right = factory.createRead(((AddContext) _localctx).vari2);
                ((AddContext) _localctx).result = factory.createBinary(((AddContext) _localctx).op, left, right);

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class SextContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Token op;
        public Token Type;
        public Token VariaIdentifer;

        public TerminalNode VariaIdentifer() {
            return getToken(MethodSLParser.VariaIdentifer, 0);
        }

        public TerminalNode Type(int i) {
            return getToken(MethodSLParser.Type, i);
        }

        public TerminalNode SextIdentifer() {
            return getToken(MethodSLParser.SextIdentifer, 0);
        }

        public List<TerminalNode> Type() {
            return getTokens(MethodSLParser.Type);
        }

        public SextContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sext;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MethodSLListener)
                ((MethodSLListener) listener).enterSext(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MethodSLListener)
                ((MethodSLListener) listener).exitSext(this);
        }
    }

    public final SextContext sext() throws RecognitionException {
        SextContext _localctx = new SextContext(_ctx, getState());
        enterRule(_localctx, 24, RULE_sext);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(166);
                ((SextContext) _localctx).op = match(SextIdentifer);
                setState(167);
                ((SextContext) _localctx).Type = match(Type);
                setState(168);
                ((SextContext) _localctx).VariaIdentifer = match(VariaIdentifer);
                setState(169);
                match(T__2);
                setState(170);
                ((SextContext) _localctx).Type = match(Type);

                CharPos += ((((SextContext) _localctx).op != null ? ((SextContext) _localctx).op.getText() : null)).length() +
                                ((((SextContext) _localctx).Type != null ? ((SextContext) _localctx).Type.getText() : null)).length() +
                                ((((SextContext) _localctx).VariaIdentifer != null ? ((SextContext) _localctx).VariaIdentifer.getText() : null)).length() + 2 +
                                ((((SextContext) _localctx).Type != null ? ((SextContext) _localctx).Type.getText() : null)).length();
                ((SextContext) _localctx).result = factory.createRead(((SextContext) _localctx).VariaIdentifer);

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class CallContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Token Type;
        public PrintFunctionContext print;
        public Token MethodIdentifer;
        public Token vari1;
        public Token VariaIdentifer;

        public List<TerminalNode> VariaIdentifer() {
            return getTokens(MethodSLParser.VariaIdentifer);
        }

        public TerminalNode Type(int i) {
            return getToken(MethodSLParser.Type, i);
        }

        public PrintFunctionContext printFunction() {
            return getRuleContext(PrintFunctionContext.class, 0);
        }

        public TerminalNode VariaIdentifer(int i) {
            return getToken(MethodSLParser.VariaIdentifer, i);
        }

        public TerminalNode CallIdentifer() {
            return getToken(MethodSLParser.CallIdentifer, 0);
        }

        public List<TerminalNode> Type() {
            return getTokens(MethodSLParser.Type);
        }

        public TerminalNode MethodIdentifer() {
            return getToken(MethodSLParser.MethodIdentifer, 0);
        }

        public CallContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_call;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MethodSLListener)
                ((MethodSLListener) listener).enterCall(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MethodSLListener)
                ((MethodSLListener) listener).exitCall(this);
        }
    }

    public final CallContext call() throws RecognitionException {
        CallContext _localctx = new CallContext(_ctx, getState());
        enterRule(_localctx, 26, RULE_call);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {

                List<LlvmExpressionNode> parameters = new ArrayList();

                setState(174);
                match(CallIdentifer);
                setState(175);
                ((CallContext) _localctx).Type = match(Type);
                setState(181);
                _la = _input.LA(1);
                if (_la == LParentheses) {
                    {
                        setState(176);
                        match(LParentheses);
                        setState(177);
                        ((CallContext) _localctx).Type = match(Type);
                        setState(178);
                        match(T__0);
                        setState(179);
                        match(T__4);
                        setState(180);
                        match(T__5);
                    }
                }

                setState(202);
                switch (_input.LA(1)) {
                    case PrintIdentifer: {
                        setState(183);
                        ((CallContext) _localctx).print = printFunction();

                        CharPos += 4 + ((((CallContext) _localctx).Type != null ? ((CallContext) _localctx).Type.getText() : null)).length() + 6;
                        ((CallContext) _localctx).result = ((CallContext) _localctx).print.result;

                    }
                        break;
                    case MethodIdentifer: {
                        {
                            setState(186);
                            ((CallContext) _localctx).MethodIdentifer = match(MethodIdentifer);
                            setState(187);
                            match(LParentheses);
                            setState(188);
                            ((CallContext) _localctx).Type = match(Type);
                            setState(189);
                            ((CallContext) _localctx).vari1 = match(VariaIdentifer);

                            CharPos += ((((CallContext) _localctx).MethodIdentifer != null ? ((CallContext) _localctx).MethodIdentifer.getText() : null)).length() + 1 +
                                            ((((CallContext) _localctx).Type != null ? ((CallContext) _localctx).Type.getText() : null)).length() +
                                            ((((CallContext) _localctx).vari1 != null ? ((CallContext) _localctx).vari1.getText() : null)).length();
                            LlvmExpressionNode parameter = factory.createRead(((CallContext) _localctx).vari1);
                            parameters.add(parameter);

                            setState(197);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            while (_la == T__0) {
                                {
                                    {
                                        setState(191);
                                        match(T__0);
                                        setState(192);
                                        ((CallContext) _localctx).Type = match(Type);
                                        setState(193);
                                        ((CallContext) _localctx).VariaIdentifer = match(VariaIdentifer);

                                        CharPos += 1 + ((((CallContext) _localctx).Type != null ? ((CallContext) _localctx).Type.getText() : null)).length() +
                                                        ((((CallContext) _localctx).VariaIdentifer != null ? ((CallContext) _localctx).VariaIdentifer.getText() : null)).length();
                                        parameter = factory.createRead(((CallContext) _localctx).VariaIdentifer);
                                        parameters.add(parameter);

                                    }
                                }
                                setState(199);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                            }
                            setState(200);
                            match(RParentheses);

                            CharPos += 1;
                            LlvmExpressionNode receiver = factory.createRead(((CallContext) _localctx).MethodIdentifer);
                            ((CallContext) _localctx).result = factory.createCall(receiver, parameters, ((CallContext) _localctx).VariaIdentifer);

                        }
                    }
                        break;
                    default:
                        throw new NoViableAltException(this);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class PrintFunctionContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Token PrintIdentifer;
        public Token Type;
        public Token VariaIdentifer;

        public TerminalNode VariaIdentifer() {
            return getToken(MethodSLParser.VariaIdentifer, 0);
        }

        public TerminalNode Type(int i) {
            return getToken(MethodSLParser.Type, i);
        }

        public TerminalNode PrintIdentifer() {
            return getToken(MethodSLParser.PrintIdentifer, 0);
        }

        public TerminalNode PrintPara() {
            return getToken(MethodSLParser.PrintPara, 0);
        }

        public List<TerminalNode> Type() {
            return getTokens(MethodSLParser.Type);
        }

        public PrintFunctionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_printFunction;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof MethodSLListener)
                ((MethodSLListener) listener).enterPrintFunction(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof MethodSLListener)
                ((MethodSLListener) listener).exitPrintFunction(this);
        }
    }

    public final PrintFunctionContext printFunction() throws RecognitionException {
        PrintFunctionContext _localctx = new PrintFunctionContext(_ctx, getState());
        enterRule(_localctx, 28, RULE_printFunction);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(204);
                ((PrintFunctionContext) _localctx).PrintIdentifer = match(PrintIdentifer);
                setState(205);
                match(LParentheses);
                setState(206);
                ((PrintFunctionContext) _localctx).Type = match(Type);
                setState(208);
                _la = _input.LA(1);
                if (_la == T__3) {
                    {
                        setState(207);
                        match(T__3);
                    }
                }

                setState(211);
                _la = _input.LA(1);
                if (_la == T__1) {
                    {
                        setState(210);
                        match(T__1);
                    }
                }

                setState(213);
                match(PrintPara);
                setState(214);
                match(T__0);
                setState(215);
                ((PrintFunctionContext) _localctx).Type = match(Type);
                setState(216);
                ((PrintFunctionContext) _localctx).VariaIdentifer = match(VariaIdentifer);
                setState(217);
                match(RParentheses);

                CharPos += ((((PrintFunctionContext) _localctx).PrintIdentifer != null ? ((PrintFunctionContext) _localctx).PrintIdentifer.getText() : null)).length() + 1 +
                                ((((PrintFunctionContext) _localctx).Type != null ? ((PrintFunctionContext) _localctx).Type.getText() : null)).length() + 20 + 33 +
                                ((((PrintFunctionContext) _localctx).Type != null ? ((PrintFunctionContext) _localctx).Type.getText() : null)).length() +
                                ((((PrintFunctionContext) _localctx).VariaIdentifer != null ? ((PrintFunctionContext) _localctx).VariaIdentifer.getText() : null)).length();
                List<LlvmExpressionNode> parameters = new ArrayList<>();
                LlvmExpressionNode parameter = factory.createRead(((PrintFunctionContext) _localctx).VariaIdentifer);
                parameters.add(parameter);
                LlvmExpressionNode receiver = factory.createRead(((PrintFunctionContext) _localctx).PrintIdentifer);
                ((PrintFunctionContext) _localctx).result = factory.createCall(receiver, parameters, ((PrintFunctionContext) _localctx).VariaIdentifer);

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static final String _serializedATN = "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\'\u00df\4\2\t\2\4" + "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"
                    + "\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\6\2\"\n\2\r\2\16" + "\2#\3\3\3\3\3\3\3\3\3\3\3\3\5\3,\n\3\3\3\3\3\5\3\60\n\3\3\3\3\3\3\4\3"
                    + "\4\3\4\3\4\3\4\3\4\3\4\7\4;\n\4\f\4\16\4>\13\4\5\4@\n\4\3\5\3\5\5\5D\n" + "\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\7\7R\n\7\f\7\16\7U"
                    + "\13\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\be\n\b" + "\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\5\nt\n\n\3\n\3\n"
                    + "\3\n\3\n\3\n\3\n\5\n|\n\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3" + "\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0092\n\13"
                    + "\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\7\r\u009e\n\r\f\r\16\r\u00a1" + "\13\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17"
                    + "\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00b8\n\17\3\17\3\17\3\17\3\17" + "\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u00c6\n\17\f\17\16\17\u00c9"
                    + "\13\17\3\17\3\17\5\17\u00cd\n\17\3\20\3\20\3\20\3\20\5\20\u00d3\n\20\3" + "\20\5\20\u00d6\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\2\2\21\2\4"
                    + "\6\b\n\f\16\20\22\24\26\30\32\34\36\2\3\3\2\21\24\u00e5\2!\3\2\2\2\4%" + "\3\2\2\2\6?\3\2\2\2\bA\3\2\2\2\nJ\3\2\2\2\fM\3\2\2\2\16d\3\2\2\2\20f\3"
                    + "\2\2\2\22m\3\2\2\2\24\177\3\2\2\2\26\u0093\3\2\2\2\30\u009b\3\2\2\2\32" + "\u00a8\3\2\2\2\34\u00af\3\2\2\2\36\u00ce\3\2\2\2 \"\5\4\3\2! \3\2\2\2"
                    + "\"#\3\2\2\2#!\3\2\2\2#$\3\2\2\2$\3\3\2\2\2%&\7\f\2\2&\'\7!\2\2\'(\7\13" + "\2\2()\b\3\1\2)+\7\35\2\2*,\5\6\4\2+*\3\2\2\2+,\3\2\2\2,-\3\2\2\2-/\7"
                    + "\36\2\2.\60\7\31\2\2/.\3\2\2\2/\60\3\2\2\2\60\61\3\2\2\2\61\62\5\b\5\2" + "\62\5\3\2\2\2\63\64\7!\2\2\64\65\7\31\2\2\65<\b\4\1\2\66\67\7\b\2\2\67"
                    + "8\7!\2\289\7\31\2\29;\b\4\1\2:\66\3\2\2\2;>\3\2\2\2<:\3\2\2\2<=\3\2\2" + "\2=@\3\2\2\2><\3\2\2\2?\63\3\2\2\2?@\3\2\2\2@\7\3\2\2\2AC\7\33\2\2BD\7"
                    + "&\2\2CB\3\2\2\2CD\3\2\2\2DE\3\2\2\2EF\b\5\1\2FG\5\n\6\2GH\7\34\2\2HI\b" + "\5\1\2I\t\3\2\2\2JK\5\f\7\2KL\b\6\1\2L\13\3\2\2\2MS\b\7\1\2NO\5\16\b\2"
                    + "OP\b\7\1\2PR\3\2\2\2QN\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TV\3\2\2\2" + "US\3\2\2\2VW\b\7\1\2W\r\3\2\2\2XY\5\22\n\2YZ\b\b\1\2Ze\3\2\2\2[\\\5\20"
                    + "\t\2\\]\b\b\1\2]e\3\2\2\2^_\5\24\13\2_`\b\b\1\2`e\3\2\2\2ab\5\34\17\2" + "bc\b\b\1\2ce\3\2\2\2dX\3\2\2\2d[\3\2\2\2d^\3\2\2\2da\3\2\2\2e\17\3\2\2"
                    + "\2fg\7\16\2\2gh\7!\2\2hi\7\b\2\2ij\7\25\2\2jk\7\32\2\2kl\b\t\1\2l\21\3" + "\2\2\2mn\7\17\2\2ns\7!\2\2op\7\32\2\2pt\b\n\1\2qr\7\31\2\2rt\b\n\1\2s"
                    + "o\3\2\2\2sq\3\2\2\2tu\3\2\2\2uv\7\b\2\2vw\7!\2\2w{\7\31\2\2xy\7\b\2\2" + "yz\7\25\2\2z|\7\32\2\2{x\3\2\2\2{|\3\2\2\2|}\3\2\2\2}~\b\n\1\2~\23\3\2"
                    + "\2\2\177\u0080\7\31\2\2\u0080\u0081\b\13\1\2\u0081\u0091\7\37\2\2\u0082" + "\u0083\5\20\t\2\u0083\u0084\b\13\1\2\u0084\u0092\3\2\2\2\u0085\u0086\5"
                    + "\26\f\2\u0086\u0087\b\13\1\2\u0087\u0092\3\2\2\2\u0088\u0089\5\30\r\2" + "\u0089\u008a\b\13\1\2\u008a\u0092\3\2\2\2\u008b\u008c\5\32\16\2\u008c"
                    + "\u008d\b\13\1\2\u008d\u0092\3\2\2\2\u008e\u008f\5\34\17\2\u008f\u0090" + "\b\13\1\2\u0090\u0092\3\2\2\2\u0091\u0082\3\2\2\2\u0091\u0085\3\2\2\2"
                    + "\u0091\u0088\3\2\2\2\u0091\u008b\3\2\2\2\u0091\u008e\3\2\2\2\u0092\25" + "\3\2\2\2\u0093\u0094\7\20\2\2\u0094\u0095\7!\2\2\u0095\u0096\7\31\2\2"
                    + "\u0096\u0097\7\b\2\2\u0097\u0098\7\25\2\2\u0098\u0099\7\32\2\2\u0099\u009a" + "\b\f\1\2\u009a\27\3\2\2\2\u009b\u009f\t\2\2\2\u009c\u009e\7\30\2\2\u009d"
                    + "\u009c\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2" + "\2\2\u00a0\u00a2\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a3\7!\2\2\u00a3"
                    + "\u00a4\7\31\2\2\u00a4\u00a5\7\b\2\2\u00a5\u00a6\7\31\2\2\u00a6\u00a7\b" + "\r\1\2\u00a7\31\3\2\2\2\u00a8\u00a9\7\27\2\2\u00a9\u00aa\7!\2\2\u00aa"
                    + "\u00ab\7\31\2\2\u00ab\u00ac\7\6\2\2\u00ac\u00ad\7!\2\2\u00ad\u00ae\b\16" + "\1\2\u00ae\33\3\2\2\2\u00af\u00b0\b\17\1\2\u00b0\u00b1\7\26\2\2\u00b1"
                    + "\u00b7\7!\2\2\u00b2\u00b3\7\35\2\2\u00b3\u00b4\7!\2\2\u00b4\u00b5\7\b" + "\2\2\u00b5\u00b6\7\4\2\2\u00b6\u00b8\7\3\2\2\u00b7\u00b2\3\2\2\2\u00b7"
                    + "\u00b8\3\2\2\2\u00b8\u00cc\3\2\2\2\u00b9\u00ba\5\36\20\2\u00ba\u00bb\b" + "\17\1\2\u00bb\u00cd\3\2\2\2\u00bc\u00bd\7\13\2\2\u00bd\u00be\7\35\2\2"
                    + "\u00be\u00bf\7!\2\2\u00bf\u00c0\7\31\2\2\u00c0\u00c7\b\17\1\2\u00c1\u00c2" + "\7\b\2\2\u00c2\u00c3\7!\2\2\u00c3\u00c4\7\31\2\2\u00c4\u00c6\b\17\1\2"
                    + "\u00c5\u00c1\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8" + "\3\2\2\2\u00c8\u00ca\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00cb\7\36\2\2"
                    + "\u00cb\u00cd\b\17\1\2\u00cc\u00b9\3\2\2\2\u00cc\u00bc\3\2\2\2\u00cd\35" + "\3\2\2\2\u00ce\u00cf\7\t\2\2\u00cf\u00d0\7\35\2\2\u00d0\u00d2\7!\2\2\u00d1"
                    + "\u00d3\7\5\2\2\u00d2\u00d1\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d5\3\2" + "\2\2\u00d4\u00d6\7\7\2\2\u00d5\u00d4\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6"
                    + "\u00d7\3\2\2\2\u00d7\u00d8\7 \2\2\u00d8\u00d9\7\b\2\2\u00d9\u00da\7!\2" + "\2\u00da\u00db\7\31\2\2\u00db\u00dc\7\36\2\2\u00dc\u00dd\b\20\1\2\u00dd"
                    + "\37\3\2\2\2\23#+/<?CSds{\u0091\u009f\u00b7\u00c7\u00cc\u00d2\u00d5";
    public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}