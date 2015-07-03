grammar MethodSL;
@parser::header{
	package com.oracle.truffle.llvm.parser;
	import com.oracle.truffle.llvm.parser.*;
	import com.oracle.truffle.llvm.nodes.*;
	import com.oracle.truffle.api.source.*;
	import com.oracle.truffle.llvm.runtime.*;
}
@parser::members{


	int BlockStart;
	int BlockEnd;
	int CharPos = 0;
	LlvmContext context;
    Source source;
    LlvmNodeFactory factory;
	
}


	
		
Visibility:
	'default' |
	'hidden' |
	'protected'
;

Boolean:
	'true' | 'false'
;

Null:
	'null'
;

Int_type:
	'i' ('0'..'9')+
;

Global_id:
	'@' (Integer | Name | String)
;

Local_id:
	'%' (Integer | Name | String)
;

Basic_block_id:
	(Integer | Name | String) ':'
;

Meta_int:
	'!' (Integer)
;

Meta_name:
	'!' (Name)
;

Attribute_id:
	'#' (Integer | Name)
;

Integer:
	('0'..'9')+
;

Signed_int:
	('+' | '-') Integer
;

Name:
	('a'..'z'|'A'..'Z'|'$'|'.'|'_'|'-') ('a'..'z'|'A'..'Z'|'$'|'.'|'_'|'0'..'9'|'-')*
;

Cstring:
	'c' (String)
;

//String: 
//	'"' (( '\\' | (('a'..'z' | 'A'..'Z' | '0'..'9') ('a'..'z' | 'A'..'Z' | '0'..'9'))) | ('\\'|'"') )* '"'
//;
String: ('"') ('a'..'z'|'A'..'Z'| '0'..'9'|'$'|'.'|'_'|'-'|'\\'| ' '| '%') ('a'..'z'|'A'..'Z'| '0'..'9'|'$'|'.'|'_'|'-'|'\\'|' '|':'| ' '| '%')* ('"');

Metadata_string:
	'!' (String)
;

Float:
	(Signed_int | Integer) '.' (Integer) ('e' (Signed_int | Integer))?
	| '0x' ('k' | 'l' | 'm' | 'h')? ('a'..'f' | 'a'..'f' | '0'..'9')+
;

//Filecheck_comment:
//	'; ' ('a'..'z''A'..'Z' | '_' | '-')+ ': ' ('\n'|'\r')* ('\r'? '\n')? ->skip
//;
//
//Sl_comment:
//	';' ('\n'|'\r')* ('\r'? '\n')? ->skip
//;
Comment:';'.*? '\n' -> skip;

WS			: (' '|'\t'|'\r'|'\n')+ ->skip;

Any_other: .;


