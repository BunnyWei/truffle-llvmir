package com.oracle.truffle.llvm.parser;

import java.util.*;

import com.oracle.truffle.api.source.*;
import com.oracle.truffle.llvm.nodes.*;
import com.oracle.truffle.llvm.runtime.*;
import com.oracle.truffle.llvm.parser.*;
import com.oracle.truffle.llvm.parser.Scanner;

public class LlvmParser {
    public static final int _EOF = 0;
    public static final int _identifier = 1;
    public static final int _stringLiteral = 2;
    public static final int _numericLiteral = 3;
    public static final int maxT = 101;
    static final boolean _T = true;
    static final boolean _x = false;
    static final int minErrDist = 2;
    public final int[] typeKind = new int[]{};

    public Token t; // last recognized token
    public Token la; // lookahead token
    int errDist = minErrDist;

    public final Scanner scanner;
    public final Errors errors;
    private final LlvmNodeFactory factory;

    public LlvmParser(LlvmContext context, Source source) {
        this.scanner = new Scanner(source.getInputStream());
        this.factory = new LlvmNodeFactory(context, source);
        errors = new Errors();
    }

    public void Parse() {
        la = new Token();
        la.val = "";
        Get();
        LlvmStartParse();
        Expect(0);
    }

    public void LlvmStartParse() {
        while (la.kind != 60 && la.kind != 65) {
            if (la.kind == 0) {
                break;
            }
            Get();
            while (la.kind == 65) {
                Function();
            }
        }

        while (la.kind == 60) {
            Get();
            if (la.kind == 30) {
                Get();
                LlvmExpressionNode result = factory.createRead(la);
            }
        }
        while (la.kind == 4) {
            Function();
        }
    }

    public void Function() {
        Expect(65); // define
        // Expect(38); // i32, 这里还需要改，因为是需要type
        Get();
        Expect(60); // @ %开头的
        Token identifierToken = t; // t 是上面那个Expect得到的la, Expect之后会执行Get(),la现在是后面得到的值
        Expect(5);
        int bodyStartPos = t.charPos;
        factory.startFunction(identifierToken, bodyStartPos);
        if (la.kind != 7) {
            Get();
            factory.addFormalParameter(la);
            Get();
            while (la.kind == 6) {
                Get();
                Get();
// Expect(1);// 这里需要改成type.kind
// Expect(1);
                factory.addFormalParameter(t);
                Get();
            }
        }
        Expect(7);
        while (la.kind == 76) {
            Get();
        }
        LlvmStatementNode body = Block(false);
        factory.finishFunction(body);
    }

    //

    public LlvmStatementNode Block(boolean inloop) {
        LlvmStatementNode result;
        factory.startBlock();
        List<LlvmStatementNode> list = new ArrayList();
        Expect(8);
        while (la.kind == 75) {
            Get();
        }
        if (la.kind == 39) {
            Get();
            if (la.kind == 63)
                Get();
        }
        while (la.kind == 75) {
            Get();
        }
        int start = t.charPos;
        while (la.kind != 9) {
            LlvmStatementNode statementNode = Statement(inloop);
            list.add(statementNode);
        }
        Expect(9);
        int length = (t.charPos + t.val.length()) - start;
        result = factory.finishBlock(list, start, length);
        return result;
    }

    public LlvmStatementNode Statement(boolean inLoop) {
        LlvmStatementNode result = null;
        switch (la.kind) {
            case 14: { // br
                result = BrStatement(t, inLoop);
                break;
            }
            case 16: {
                result = ReturnStatement(inLoop);
                Expect(75);
                break;
            }
            case 71: {
                result = CallFunction();
                Expect(75);
                break;
            }
// case 75: {
// Get();
// if(la.kind == )
// }
// case 64:{
// result = SwitchStatement(inLoop);
// }

            case 100: {
                Get();
                if (la.kind == 63) {
                    Get();
                    if (la.kind == 3) {
                        // result = IfStatement(la,inLoop);在这里应该是进入CodeSlide（）function
                        // result = CodeSlideBlock(t, inLoop);
                        break;
                    }
                }
            }
            case 1:
            case 2:
            case 3:
            case 5:
            case 60:
            case 61:
            case 67: {
                result = Expression();
                Expect(75);
                break;
            }
            default:
                SynErr(101);
                break;
        }

        return result;
    }

    // this is right
    public LlvmStatementNode IfStatement(Token temp, boolean inLoop) {
        LlvmStatementNode result = null;
// // Expect(14); // t= br, la = the next
// Get();
// Token ifToken = temp;
// LlvmExpressionNode condition = Expression();
// Expect(6); // ,
// // Expect(59); // label
// LlvmStatementNode thenPart = null;
// LlvmStatementNode elsePart = null;
// Get();
// if (la.kind == 59) {
// Get();
// Token tempLabel1 = la;
// Get(); // get ','
// if (la.kind == 6) {
// Get(); // get "label"
// Get(); // get the label number
// }
// // 如果label是已经存在的，只需要调用在HashMap中的代码
// if (codeSlide.hashCodeSlide.containsKey(tempLabel1)) {
// thenPart = codeSlide.hashCodeSlide.get(tempLabel1);
// }
// // 如果label是不存在的，需要调用CodeSlideBlock方法，创建Block
// else {
// thenPart = CodeSlideBlock(tempLabel1, inLoop);
// }
// elsePart = CodeSlideBlock(la, inLoop);
// } else {
// Get();
// thenPart = CodeSlideBlock(la, inLoop);
// }
// result = factory.createIf(ifToken, condition, thenPart, elsePart);
// if (la.kind == 59) {
// thenPart = CodeSlideBlock(temp, inLoop);
// result = factory.createIf(ifToken, null, thenPart, null);
// }
        return result;
//
    }

    // br label 1 会直接转到label 1代码段处执行(在这时，会判断是否这个标签已经存在)
    // br i1 %3, label 2, label 3，会转到ifStatement处执行
    public LlvmStatementNode BrStatement(Token temp, boolean inLoop) {
        LlvmStatementNode result = null;
        Get();
        // 58 = i1
        if (la.kind == 58) {
            result = IfStatement(temp, inLoop);
        } else if (la.kind == 59) { // 59 = label
            Get();
// if (codeSlide.hashCodeSlide.containsKey(la)) {
// LlvmStatementNode thenPart = codeSlide.getHashCodeSlide().get(la);
// result = factory.createIf(la, null, thenPart, null);
// } else {
// LlvmStatementNode thenPart = CodeSlideBlock(la, inLoop);
// result = factory.createIf(la, null, thenPart, null);
// }
        }
        return result;
    }

    // 判断是以100 和label 数字开始
    // CodeSlideBlock是会保存label 和List<LlvmStatementNode>
// public LlvmStatementNode CodeSlideBlock(Token temp, boolean inLoop) {
// LlvmStatementNode result;
// codeSlide.startBlock();
// List<LlvmStatementNode> list = new ArrayList();
// Expect(100);
// Get();
// if (la.kind == 63) {
// if (la.kind == 63) {
// Get();
// }
// }
// Token temp1 = la;
// int start = la.charPos;
// while (StartOf(1)) {
// LlvmStatementNode statementNode = Statement(inLoop);
// list.add(statementNode);
// }
// Expect(100);
// int length = (t.charPos + t.val.length()) - start;
// result = codeSlide.finishCodeSlideBlock(temp1, list, start, length);
// return result;
// }

    public LlvmStatementNode ReturnStatement(boolean inLoop) {
        LlvmStatementNode result;
        Expect(16);
        Token returnToken = t;
        LlvmExpressionNode value = null;
        if (la.kind == 77) {
            value = null;
            Get();
        } else { // 改成type对应的kind
            Get();
            value = Expression();
        }
        result = factory.createReturn(returnToken, value);
        Expect(75);
        return result;
    }

    LlvmExpressionNode Expression() {
        LlvmExpressionNode result = null;
        if ((la.kind == 40 || la.kind == 36 || la.kind == 43 || la.kind == 44)) {
            result = Arithmetic();
            return result;
        }
        if (la.kind <= 49 && la.kind >= 45) {
            result = Term();
            return result;
        }
        if (la.kind == 50 || la.kind == 51) {
            result = RemCal();
            return result;
        }
        if (la.kind == 67) {
            result = Store();
            return result;
        }
        if (la.kind == 68) {
            result = Load();
            return result;
        }
        if (la.kind == 71) {
            result = CallFunctionBultin();
            return result;
        }
        result = Factor();
        return result;
    }

    LlvmExpressionNode LogicTerm() {
        LlvmExpressionNode result;
        result = LogicFactor();
        while (la.kind == 18) {
            Get();
            Token op = t;
            LlvmExpressionNode right = LogicFactor();
            result = factory.createBinary(op, result, right);
        }
        return result;
    }

    LlvmExpressionNode LogicFactor() {
        LlvmExpressionNode result;
        result = Arithmetic();
        if (StartOf(3)) {
            switch (la.kind) {
                case 19: {
                    Get();
                    break;
                }
                case 20: {
                    Get();
                    break;
                }
                case 21: {
                    Get();
                    break;
                }
                case 22: {
                    Get();
                    break;
                }
                case 23: {
                    Get();
                    break;
                }
                case 24: {
                    Get();
                    break;
                }
            }
            Token op = t;
            LlvmExpressionNode right = Arithmetic();
            result = factory.createBinary(op, result, right);
        }
        return result;
    }

    LlvmExpressionNode Arithmetic() {
        LlvmExpressionNode result = null;
        Token op = la;
        while (la.kind == 40 || la.kind == 36 || la.kind == 43 || la.kind == 44) {
            Get();
            while (la.kind == 41 || la.kind == 42 || la.kind == 38) {
                Get();
            }
            result = Factor();
            Expect(6);
            LlvmExpressionNode right = Factor();
            result = factory.createBinary(op, result, right);
        }
        return result;
    }

    LlvmExpressionNode RemCal() {
        LlvmExpressionNode result = null;
        Token op = la;
        while (la.kind == 50 || la.kind == 51) {
            Get();
            while (la.kind == 41 || la.kind == 42 || la.kind == 38) {
                Get();
            }
            result = Factor();
            Expect(6);
            LlvmExpressionNode right = Factor();
            result = factory.createBinary(op, result, right);
        }
        return result;
    }

// * /
    LlvmExpressionNode Term() {
        LlvmExpressionNode result = null;
        Token op = la;
        while (la.kind <= 49 && la.kind >= 45) {
            Get();
            while (la.kind == 41 || la.kind == 42 || la.kind == 38) {
                Get();
            }
            result = Factor();
            Expect(6);
            LlvmExpressionNode right = Factor();
            result = factory.createBinary(op, result, right);
        }
        return result;
    }

    LlvmExpressionNode Factor() {
        LlvmExpressionNode result;
        result = null;
        if (la.kind == 1 || la.kind == 60 || la.kind == 61 || la.kind == 73) {
            Get();
            if (la.kind == 5 || la.kind == 29 || la.kind == 30) {
                result = MemberExpression(null, null, t);
            } else {
                result = factory.createRead(t);
            }
        } else if (la.kind == 2) {
            Get();
            result = factory.createStringLiteral(t);
        } else if (la.kind == 3) {
            Get();
            result = factory.createNumericLiteral(t);
        } else if (la.kind == 5) {
            Get();
            int start = t.charPos;
            result = Expression();
            LlvmExpressionNode expr = result;
            Expect(7);
            int length = (t.charPos + t.val.length()) - start;
            result = factory.createParenExpression(expr, start, length);
        } else if (la.kind == 70) {
            Get();
            while (la.kind != 75) {
                Get();
            }
            t.val = "0";
            result = factory.createNumericLiteral(t);
        } else
            SynErr(34);
        return result;
    }

    LlvmExpressionNode MemberExpression(LlvmExpressionNode r, LlvmExpressionNode assignmentReceiver, Token assignmentName) {
        LlvmExpressionNode result;
        result = null;
        LlvmExpressionNode receiver = r;
        Token nestedAssignmentName = null;
        Token op = t;
        if (la.kind == 5) {
            if (t.kind == 73) {
                while (la.kind != 6 || t.kind != 7)
                    Get();
            }
            // while (la.kind != 1 && la.kind != 2 && la.kind != 3 && la.kind != 60 && la.kind !=
// 61)
            Get();// 跳过类型定义
            Get();
            List<LlvmExpressionNode> parameters = new ArrayList<>();
            LlvmExpressionNode parameter;
            if (receiver == null) {
                receiver = factory.createRead(assignmentName);
            }
            parameter = Expression();
            parameters.add(parameter);
            while (la.kind == 6) {
                Get(); // 跳过类型定义
                Get();
                parameter = Expression();
                parameters.add(parameter);
            }
            Expect(7);
            Token finalToken = t;
            result = factory.createCall(receiver, parameters, finalToken);
        } else if (la.kind == 29) {
            Get();
            LlvmExpressionNode value = Expression();
            if (assignmentName == null) {
                SemErr("invalid assignment target");
            } else if (assignmentReceiver == null) {
                result = factory.createAssignment(assignmentName, value);
            }
// else {
// result = factory.createWriteProperty(assignmentReceiver, assignmentName, value);
// }
        } else
// if (la.kind == 30) {
// Get();
// if (receiver == null) {
// receiver = factory.createRead(assignmentName);
// }
// Expect(1);
// result = factory.createReadProperty(receiver, t);
// nestedAssignmentName = t;
// } else
// SynErr(35);
        if (la.kind == 5 || la.kind == 29 || la.kind == 30) {
            result = MemberExpression(result, receiver, nestedAssignmentName);
        }
        return result;
    }

    public LlvmExpressionNode Store() {
        Get();
        Expect(38); // i32 or i8;
        Expect(74);
        Token op = la;
        LlvmExpressionNode result = null;
        if (la.kind == 3) {
            Get();
            result = factory.createNumericLiteral(t);
        }
        if (la.kind == 1 || la.kind == 60 || la.kind == 61) {
            Get();
            result = factory.createRead(t);
        }
        Expect(6);
        Get(); // 跳过类型定义
        Get();
        result = factory.createReassignment(la, result);
        while (la.kind != 75) {
            Get();
        }
        return result;
    }

    public LlvmExpressionNode Load() {
        while (la.kind != 1 && la.kind != 61 && la.kind != 60) {
            Get();
        }
        LlvmExpressionNode result = factory.createRead(la);
        while (la.kind != 75) {
            Get();
        }
        // LlvmExpressionNode result = factory.createAssignment(nameToken, value);
        return result;
    }

    public LlvmExpressionNode CallFunction() {
        Token op = la;
        while (la.kind != 60) {
            Get();
        }
        LlvmExpressionNode receiver = factory.createRead(la);
        Get();
        Get();
        List<LlvmExpressionNode> parameters = new ArrayList<>();
        LlvmExpressionNode parameter;
        if (la.kind != 7) {
            Get();
            parameter = factory.createRead(la);
            parameters.add(parameter);
            Get();
        }

        while (la.kind == 6) {
            Get(); // 跳过类型定义
            Get();
            parameter = factory.createRead(la);
            parameters.add(parameter);
            Get();
        }
        Expect(7);
        Token finalToken = t;
        LlvmExpressionNode result = factory.createCall(receiver, parameters, finalToken);
        return result;
// LlvmExpressionNode result = Factor();
// return result;
    }

    public LlvmExpressionNode CallFunctionBultin() {
        Token op = la;
        while (la.kind != 1 && la.kind != 60 && la.kind != 61 && la.kind != 73) {
            Get();
        }
        LlvmExpressionNode result = Factor();
        return result;
    }

    void Get() {
        for (;;) {
            t = la;
            la = scanner.Scan();
            if (la.kind <= maxT) {
                ++errDist;
                break;
            }

            la = t;
        }
    }

    void Expect(int n) {
        if (la.kind == n)
            Get();
        else {
            SynErr(n);
        }
    }

    void SynErr(int n) {
        if (errDist >= minErrDist)
            errors.SynErr(la.line, la.col, n);
        errDist = 0;
    }

    public void SemErr(String msg) {
        if (errDist >= minErrDist)
            errors.SemErr(t.line, t.col, msg);
        errDist = 0;
    }

    boolean StartOf(int s) {
        return set[s][la.kind];
    }

    void ExpectWeak(int n, int follow) {
        if (la.kind == n)
            Get();
        else {
            SynErr(n);
            while (!StartOf(follow))
                Get();
        }
    }

    boolean WeakSeparator(int n, int syFol, int repFol) {
        int kind = la.kind;
        if (kind == n) {
            Get();
            return true;
        } else if (StartOf(repFol))
            return false;
        else {
            SynErr(n);
            while (!(set[syFol][kind] || set[repFol][kind] || set[0][kind])) {
                Get();
                kind = la.kind;
            }
            return StartOf(syFol);
        }
    }

    public static void parseLlvm(LlvmContext context, Source source) {
        LlvmParser parser = new LlvmParser(context, source);
        parser.Parse();
        if (parser.errors.errors.size() > 0) {
            StringBuilder msg = new StringBuilder("Error(s) parsing script:\n");
            for (String error : parser.errors.errors) {
                msg.append(error).append("\n");
            }
            // throw new LlvmException(msg.toString());
        }
    }

    private static final boolean[][] set = {{_T, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x},
                    {_x, _T, _T, _T, _x, _T, _x, _x, _x, _x, _T, _x, _T, _T, _T, _x, _T, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x},
                    {_x, _T, _T, _T, _x, _T, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x},
                    {_x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _x, _T, _T, _T, _T, _T, _T, _x, _x, _x, _x, _x, _x, _x, _x},
                    {_x, _x, _x, _x, _x, _T, _T, _T, _x, _x, _x, _T, _x, _x, _x, _x, _x, _T, _T, _T, _T, _T, _T, _T, _T, _T, _T, _T, _T, _T, _T, _x, _x}

    };
}

class Errors {

    protected final List<String> errors = new ArrayList<>();
    public String errMsgFormat = "-- line {0} col {1}: {2}"; // 0=line, 1=column, 2=text

    protected void printMsg(int line, int column, String msg) {
        StringBuffer b = new StringBuffer(errMsgFormat);
        int pos = b.indexOf("{0}");
        if (pos >= 0) {
            b.delete(pos, pos + 3);
            b.insert(pos, line);
        }
        pos = b.indexOf("{1}");
        if (pos >= 0) {
            b.delete(pos, pos + 3);
            b.insert(pos, column);
        }
        pos = b.indexOf("{2}");
        if (pos >= 0)
            b.replace(pos, pos + 3, msg);
        errors.add(b.toString());
    }

    public void SynErr(int line, int col, int n) {
        String s;
        switch (n) {
            case 0:
                s = "EOF expected";
                break;
            case 1:
                s = "identifier expected";
                break;
            case 2:
                s = "stringLiteral expected";
                break;
            case 3:
                s = "numericLiteral expected";
                break;

            case 5:
                s = "\"(\" expected";
                break;
            case 6:
                s = "\",\" expected";
                break;
            case 7:
                s = "\")\" expected";
                break;
            case 8:
                s = "\"{\" expected";
                break;
            case 9:
                s = "\"}\" expected";
                break;
            case 10:
                s = "\"break\" expected";
                break;
            case 11:
                s = "\";\" expected";
                break;
            case 12:
                s = "\"continue\" expected";
                break;
            case 13:
                s = "\"while\" expected";
                break;
            case 14:
                s = "\"br\" expected";
                break;
            case 15:
                s = "\"else\" expected";
                break;
            case 16:
                s = "\"ret\" expected";
                break;
            case 17:
                s = "\"||\" expected";
                break;
            case 18:
                s = "\"&&\" expected";
                break;
            case 19:
                s = "\"<\" expected";
                break;
            case 20:
                s = "\"<=\" expected";
                break;
            case 21:
                s = "\">\" expected";
                break;
            case 22:
                s = "\">=\" expected";
                break;
            case 23:
                s = "\"==\" expected";
                break;
            case 24:
                s = "\"!=\" expected";
                break;
            case 25:
                s = "\"add\" expected";
                break;
            case 26:
                s = "\"-\" expected";
                break;
            case 27:
                s = "\"*\" expected";
                break;
            case 28:
                s = "\"/\" expected";
                break;
            case 29:
                s = "\"=\" expected";
                break;
            case 30:
                s = "\".\" expected";
                break;
            case 31:
                s = "??? expected";
                break;
            case 32:
                s = "invalid Statement";
                break;
            case 33:
                s = "invalid Factor";
                break;
            case 34:
                s = "invalid Factor";
                break;
            case 35:
                s = "invalid MemberExpression";
                break;
            case 36:
                s = "\"fadd\" expected";
                break;
            case 37:
                s = "\"double\" expected";
                break;
            case 38:
                s = "\"i32\" expected";
                break;
            case 39:
                s = "\"entry:\" expected";
                break;
            case 40:
                s = "\"add:\" expected";
                break;
            case 41:
                s = "\"nuw:\" expected";
                break;
            case 42:
                s = "\"nsw:\" expected";
                break;
            case 43:
                s = "\"fsub:\" expected";
                break;
            case 44:
                s = "\"sub:\" expected";
                break;
            case 45:
                s = "\"mul:\" expected";
                break;
            case 46:
                s = "\"fmul:\" expected";
                break;
            case 47:
                s = "\"udiv:\" expected";
                break;
            case 48:
                s = "\"sdiv:\" expected";
                break;
            case 49:
                s = "\"fdiv:\" expected";
                break;
            case 50:
                s = "\"urem:\" expected";
                break;
            case 51:
                s = "\"srem:\" expected";
                break;
            case 52:
                s = "\"shl:\" expected";
                break;
            case 53:
                s = "\"lshr:\" expected";
                break;
            case 54:
                s = "\"ashr:\" expected";
                break;
            case 55:
                s = "\"and:\" expected";
                break;
            case 56:
                s = "\"or:\" expected";
                break;
            case 57:
                s = "\"xor:\" expected";
                break;
            case 58:
                s = "\"i1:\" expected";
                break;
            case 59:
                s = "\"label:\" expected";
                break;
            case 60:
                s = "\"@\" expected";
                break;
            case 61:
                s = "\";\" expected";
                break;
            case 62:
                s = "\"target\" expected";
                break;
            case 63:
                s = "\":\" expected";
                break;
            case 64:
                s = "\"switch\" expected";
                break;
            case 65:
                s = "\"define\" expected";
            case 66:
                s = "\"align\" expected";
                break;
            case 67:
                s = "\"store\" expected";
                break;
            case 68:
                s = "\"load\" expected";
                break;
            case 69:
                s = "\"i32*\" expected";
                break;
            case 70:
                s = "\"alloca\" expected";
                break;
            case 71:
                s = "\"call\" expected";
                break;
            case 72:
                s = "\"tail\" expected";
                break;
            case 73:
                s = "\"@printf\" expected";
                break;
            case 74:
                s = "\"i8\" expected";
                break;
            case 75:
                s = "\"whitespace\" expected";
                break;
            case 76:
                s = "\"attributes 0\" expected";
                break;
            case 77:
                s = "\"void\" expected";
                break;
            case 99:
                s = "\"statebreak\" expected";
                break;
            case 100:
                s = "\"blockbreak\" expected";
                break;
            default:
                s = "error " + n;
                break;
        }
        printMsg(line, col, s);
    }

    public void SemErr(int line, int col, String s) {
        printMsg(line, col, s);
    }

    public void SemErr(String s) {
        errors.add(s);
    }

    public void Warning(int line, int col, String s) {
        printMsg(line, col, s);
    }

    public void Warning(String s) {
        errors.add(s);
    }
} // Errors

class FatalError extends RuntimeException {

    public static final long serialVersionUID = 1L;

    public FatalError(String s) {
        super(s);
    }
}
