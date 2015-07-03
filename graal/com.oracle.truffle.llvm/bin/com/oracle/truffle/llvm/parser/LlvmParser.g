header{
	package com.oracle.truffle.llvm.parser;
}
{
	import com.oracle.truffle.llvm.parser.*;
}

class CalParser extends Parser; 
options{
	buildAST = true;
}
{
	LlvmNodeFactory factory;
	LlvmAddNodeGen addNodeGen;
}

prog : StringIndifier^ Equal expr;
expr : ADD^ (Number)(Number){
	addNodeGen = new 
	factory.createBinary(ADD, Number, Number);
};

class LlvmLexer extends Lexer;

Function : ("define");
ADD : ("add"
		| "fadd")
		;
		
SUB	 : ("sub"
		| "fsub")
		;
		
MUL	 : ("mul"
		| "fmul")
		;
		
DIV	 : ("udiv"
		| "fdiv"
		| "sdiv")
		;

REM	 : ("urem"
		| "srem"
		| "frem")
		;
	
BlockIndifier : ('\r' '\r')('0'..'9')+;	
NumberIndifier : ('%' | '@')('0'..'9')+;
Number		   : ('0'..'9');
StringIndifier : ('%' | '@')('a'..'z'|'A'..'Z')+
FLOAT	:('0'..'9')+ ('.')('0'..'9')+;		

String : ('a'..'z'|'A'..'Z')+;
Equal : ('=');
WS    : ( ' '|'\r' '\n'| '\n'| '\t')  {$setType(Token.SKIP);} ;
