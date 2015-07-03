grammar LLVM_IR;

@lexer::header{
	package com.oracle.truffle.llvm.parser;
}

@parser::header{
	package com.oracle.truffle.llvm.parser;
	import com.oracle.truffle.llvm.parser.*;
	import com.oracle.truffle.llvm.nodes.*;
	import com.oracle.truffle.api.source.*;
	import com.oracle.truffle.llvm.runtime.*;
	import java.util.*;
}
@parser::members{
	int BlockStart;
	int BlockEnd;
	int CharPos = 0;
	Map<String, LlvmStatementNode> blockMap = new HashMap<>();
	Map<String, List<LlvmStatementNode>> createdBlock = new HashMap<>();
	LlvmContext context;
    Source source;
    LlvmNodeFactory factory;	
    int count = 0;
    Token ifstartToken;
    LlvmExpressionNode conditionToken;
    String thenStr;
    String elseStr;
    String blockName; // blockName contains an if sentence, and the if applies the blockName to create sourceSecion
    boolean isWhile = false;
    List<String> thenList;
    List<String> elseList;
    boolean isContainsElse = false;
    Map<String, String> thenElse;
}
model:
	elements+=toplevelelement*
;

toplevelelement:
	typedef | inlineasm | targetinfo | globalvalue | namedmetadata | attributegroup
;

attributegroup:
	'attributes' Attribute_id '=' '{'
	(
		attributes=functionattribute+ |
		alignstack+ '=' alignstackvalue=Integer+ |
		targetspecificattributes=targetspecificattribute+
	)+
	'}'
;

targetspecificattribute:
	name=String ('=' value=String)?
;

namedmetadata:
	name=Meta_int '=' 'metadata' node=metadatanode |
	name=Meta_name '=' node=metadatanode
;

metadataref:
	namedmetadata|metadataidentifier
;

metadataidentifier:
	Meta_int | Meta_name
;

valueref returns [LlvmExpressionNode result,Token resultToken]:
	(opG = globalvalueref{
		$resultToken = $opG.resultToken;
	} |
	op = localvalueref{
		$result = $op.result;
		$resultToken = $op.resultToken;
	})
;

globalvalueref returns [Token resultToken]:
	constantelement=constant{
		$resultToken = $constantelement.resultToken;
	} |
	metadata=metadataref
;

localvalueref returns [LlvmExpressionNode result,Token resultToken]:
	(Local_id{
		$result = factory.createRead($Local_id);
		$resultToken = $Local_id;
	}|op1 = localvalue{
		$result = $op1.result;
		$resultToken = $op1.resultToken;
	})
;

globalvalue:
	globalvariable | function | alias
;

globalvaluedef:
	globalvariable | functionheader | alias
;

localvalue returns [LlvmExpressionNode result,Token resultToken]:
	op1 = namedinstruction{
		$result = $op1.result;
	} | op2 = parameter{
		$result = factory.createRead($op2.resultToken);
		$resultToken = $op2.resultToken;
	}
;

namedinstruction returns [LlvmExpressionNode result]:
	op1 = startinginstruction{
		$result = $op1.result;
	} |
	op2 = namedmiddleinstruction{
		$result = $op2.result;
	} |
	op3 = namedterminatorinstruction{
		$result = $op3.result;
	}
;

instruction:
	startinginstruction |
	middleinstruction |
	terminatorinstruction
;

alias:
	name=globalname
	'alias'
	linkageelement=linkage?
	Visibilityelement=Visibility?
	typeelement=type
	aliaseeelement=aliasee
;

aliasee:
	globalvaluedef|Global_id | bitcast=constantexpression_convert
;

targetinfo:
	'target' infotype=('datalayout' | 'triple') '=' layout=String
;

inlineasm:
	'module' 'asm' asmline=String
;

globalvariable:
	name=globalname
	linkageelement=linkage?
	addrspace=addressspace?
	tlsmodelElement=tlsmodel?
	'unnamed_addr'?
	('constant' | 'global')
	typeelement=type
	(initialvalue=constant)?
	(',' sectionElement=section)?
	(',' alignElement=align)?
;

constant returns [Token resultToken]:
	op1 = simpleconstant{
		$resultToken = $op1.resultToken;
	} |
	structureconstant | //this has been modified. predicate because a vector constant and a structure constant can start with '<'
	arrayconstant |
	vectorconstant |
	zeroinitializer |
	metadatanode |
	metadatastring |
	blockaddress |
	undef |
	constantexpression |
	globalvaluedef|Global_id{
		$resultToken = $Global_id;
	}
;

constantexpression:
	constantexpression_convert |
	constantexpression_getelementptr |
	constantexpression_select |
	constantexpression_compare |
	constantexpression_extractelement |
	constantexpression_insertelement |
	constantexpression_shufflevector |
	constantexpression_extractvalue |
	constantexpression_insertvalue |
	constantexpression_binary
;

constantexpression_convert:
	opcodeElement=convertionopcode '(' fromtype=type constantElement=globalvalueref 'to' targettype=type ')'
;

constantexpression_getelementptr:
	opcode='getelementptr' 'inbounds'?
	'(' constanttype=type constantElement=globalvalueref (',' indextypes+=type indices+=constant)* ')'
;

constantexpression_select:
	opcode='select' '(' condition=typedvalue ',' op1=typedvalue ',' op2=typedvalue ')'
;

constantexpression_compare:
	('icmp' icmpcondition | 'fcmp' fcmpcondition)
	'(' op1=typedvalue ',' op2=typedvalue ')'
;

constantexpression_extractelement:
	opcode='extractelement' '(' vector=typedvalue ',' index=typedvalue ')'
;

constantexpression_insertelement:
	opcode='insertelement' '(' vectortypeElement=vectortype vector=valueref
	',' element=typedvalue
	',' index=typedvalue ')'
;

constantexpression_shufflevector:
	opcode='shufflevector' '('
	vector1=typedvalue ','
	vector2=typedvalue ','
	mask=typedvalue ')'
;

constantexpression_extractvalue:
	opcode='extractvalue' '(' value=typedvalue (',' indices+=Integer)+ ')'
;

constantexpression_insertvalue:
	opcode='insertvalue' '(' value=typedvalue
	',' element=typedvalue
	(',' indices+=Integer)+ ')'
;

constantexpression_binary:
	(
		(opcode=('add' | 'sub' | 'mul' | 'shl') ('nuw'? 'nsw'?)) |
		(opcode=('sdiv' | 'udiv' | 'lshr' | 'ashr') 'exact'?) |
		opcode=('fadd' | 'fsub' | 'fmul' | 'fdiv' | 'urem' | 'srem' | 'frem' | 'and' | 'or' | 'xor')
	)
	'(' op1=typedvalue ',' op2=typedvalue ')'
;

undef:
	'undef'
;

blockaddress:
	'blockaddress' '(' functionElement=globalvalueref ',' basicblockElement=basicblockref ')'
;

zeroinitializer:
	'zeroinitializer'
;

structureconstant:
	(
	'{' list=constantlist? '}' |
	packed='<' '{' list=constantlist? '}' '>'
	)
;

arrayconstant:
	'[' list=constantlist? ']'
;

vectorconstant:
	'<' list=constantlist? '>'
;

constantlist:
	typedconstants+=typedconstant (',' typedconstants+=typedconstant)*
	//types+=type constants+=constant (',' types+=type constants+=constant)*
;

typedconstant:
	type constant
;

simpleconstant returns [Token resultToken]:
	(Integer{ $resultToken = $Integer; } | Signed_int { $resultToken = $Signed_int; }| Float {
		$resultToken = $Float; }| Boolean { $resultToken = $Boolean; 
		}| Null{ $resultToken = $Null; } | Cstring{ $resultToken = $Cstring; }) ;

metadatanode:
	'!' '{' (elements+=metadatanodeelement (',' elements+=metadatanodeelement)*)? '}'
;

metadatanodeelement:
	(typedvalue) | (metadataref) | Null
;

metadatastring:
	name=Metadata_string
;

tlsmodel:
	'thread_local' '(' tlsoption ')'
;

tlsoption:
	'localdynamic' |
	'initialexec' |
	'localexec'
;

addressspace:
	'addrspace' '(' value=Integer ')'
;

section:
	'section' String
;

align returns [Token result]:
	'align' Integer{
		$result = $Integer;
	}
;

gc:
	'gc' String
;

function:
	functiondef | functiondecl
;

functiondef:
	'define'{
		thenList = new ArrayList();
		elseList = new ArrayList();
		thenElse = new HashMap<String, String>();
	} header=functionheader startblockToken = '{' {
		List<LlvmStatementNode> list = new ArrayList();
		BlockStart = $startblockToken.getStartIndex() + 2;
		System.out.println("BlockStart"+BlockStart);
		factory.startBlock();
	}(basicblocks=basicblock{
		if($basicblocks.result != null){
			list.addAll($basicblocks.result);
		}
		
	})+ endblockToken = '}'{
		BlockEnd = $endblockToken.getStartIndex() - 4;	
		System.out.println("BlockEnd"+BlockEnd);	
		LlvmStatementNode result = factory.finishBlock(list, BlockStart, BlockEnd - BlockStart);
		factory.finishFunction(result);
	}
;

functiondecl:
	'declare' header=functionheader
;

functionheader:
	linkage? Visibility? cconv? 'unnamed_addr'? parameterattributes?
	type Global_id
	startindex = '(' {
		int functionStartPos = $startindex.getStartIndex();
		System.out.println("functionStartPos"+functionStartPos);
		factory.startFunction($Global_id,functionStartPos);
	}parameters? ')'
	functionattributes?
	section?
	align?
	gc?
	functionprefix?
;

functionprefix:
	'prefix' value=typedconstant
;

parameters:
	(
		(type pa1 = Local_id{
			factory.addFormalParameter($pa1);
		} (',' type pa2 = Local_id{
			factory.addFormalParameter($pa2);
		})* (',' vararg='...')?)? |
		vararg='...'
	)
;

functionattributes:
	(
		functionattribute+ |
		(alignstack+ '(' alignstackvalue+=Integer ')') |
		(attributegroup|Attribute_id)+
	)+
;

alignstack:
	'alignstack'
;

functionattribute:
	attribute=(
		'alwaysinline' |
		'builtin' |
		'cold' |
		'inlinehint' |
		'naked' |
		'nobuiltin' |
		'noduplicate' |
		'noimplicitFloat' |
		'noinline' |
		'nonlazybind' |
		'noredzone' |
		'noreturn' |
		'nounwind' |
		'optnone' |
		'optsize' |
		'readnone' |
		'readonly' |
		'returns_twice' |
		'sanitize_address' |
		'sanitize_memory' |
		'sanitize_thread' |
		'ssp' |
		'sspreq' |
		'sspstrong' |
		'uwtable' |
		// removed:
		'address_safety' |
		'thread_safety' |
		'uninitialized_checks'
	)
;

basicblock returns [List<LlvmStatementNode> result]:{
		List<LlvmStatementNode> list = new ArrayList(); 
	}
	name=basicblockname
	(startingList = startinginstruction{
		list.add($startingList.result);
	})*
	(middleList = middleinstruction{
		if($middleinstruction.result != null)
			list.add($middleList.result);
	})*
	terminatorList = terminatorinstruction{
		if($terminatorList.result != null){
			list.add($terminatorList.result);	
		}
		if($name.resultToken != null){
			int length = $terminatorList.resultToken.getStartIndex();
			CommonToken resultCommon = (CommonToken) $name.resultToken;
			String str = "%" + resultCommon.getText().subSequence(0, resultCommon.getText().length()-1);
			resultCommon.setText(str);
			LlvmStatementNode blockNode = factory.createBasicBlockNode(resultCommon, list,$name.resultToken.getStartIndex(),length-$name.resultToken.getStartIndex());
			if(blockMap.containsKey(str + "then") && blockMap.get(str + "then") == null){
				blockMap.put(str+"then", blockNode);
				//count--;
				ifstartToken = $name.resultToken;
				thenStr = str;
				thenList.add(str);
				//not contains the else part in the If-sentence;
				//isContainsElse = blockMap.containsKey($terminatorList.resultToken.getText() + "else");
				isContainsElse = thenElse.get(str + "then").equals($terminatorList.resultToken.getText() + "else")?true:false;
			}else if(blockMap.containsKey(str + "else") && blockMap.get(str+ "else") == null){
				blockMap.put(str + "else",blockNode);
				//count--;				
				if(thenStr == null){
					$result = new ArrayList();
					$result.add(blockNode);
				}else{
					elseStr = str;
				    elseList.add(str);
				}
			}
			if(!blockMap.containsKey(str + "then") && !blockMap.containsKey(str + "else")){
				blockNode = factory.createBasicBlockNode(resultCommon, list,$name.resultToken.getStartIndex(),length-$name.resultToken.getStartIndex());
				$result = new ArrayList();
				$result.add(blockNode);
				blockName = str;
			}
			if(isWhile){
				Token whileToken = $terminatorList.resultToken;
				LlvmStatementNode whileNode = factory.createWhile(ifstartToken, conditionToken,blockMap,whileToken);
				//list.add(whileNode);
				List<LlvmStatementNode> tempNode = new ArrayList();
				$result = new ArrayList();
				$result.add(whileNode);
				blockNode = factory.createBasicBlockNode(resultCommon,list,$name.resultToken.getStartIndex(),length-$name.resultToken.getStartIndex());
				thenStr = null;
				blockMap = new HashMap<String, LlvmStatementNode>();
				isWhile = false;
			}else if((thenStr != null && elseStr != null) | (thenStr != null && isContainsElse)){
				LlvmStatementNode ifNode = null;
				if(isContainsElse){
					ifNode= factory.createIf(ifstartToken,blockName  + "if",conditionToken,blockMap.get(thenStr+"then"),null);
				}else{
					ifNode= factory.createIf(ifstartToken,blockName  + "if",conditionToken,blockMap.get(thenStr+"then"),blockMap.get(elseStr+"else"));
				} 
				$result = new ArrayList();
				$result.add(ifNode);
				thenStr = null;
				elseStr = null;
				isContainsElse = false;
//				thenList.remove(thenList.size() -1);
//				elseList.remove(elseList.size() -1);
			}
			// if the str is contained in the blockMap, it should not create the basicblockNode
		}else{
			$result = list;
		}		
	}	
;

//basicblockname returns [ecore::estring:
//	// a value converter translates this into either %num (if this isn't provided)
//	// or into %name if it is.
//	Basic_block_id?
//;
basicblockname returns [Token resultToken]:
	(Basic_block_id{
		$resultToken = $Basic_block_id;
	})?;

metadatasuffix:
	',' name=Meta_name value=metadataref
;

startinginstruction returns [LlvmExpressionNode result]:
	name=localname
	instruction_phi
	metadatasuffix*
;

middleinstruction returns [LlvmExpressionNode result]:
	(
		op1 = namedmiddleinstruction{
			$result = $op1.result;
		} |
		op2 = instruction_store{
			$result = $op2.result;
		} |
		op3 = instruction_fence|
		op4 = instruction_call_void{
			$result = $op4.result;
		}
	)
	metadatasuffix*
;

namedmiddleinstruction returns [LlvmExpressionNode result]:
	name=localname
	(
		op1 = binaryinstruction{
		$result = factory.createAssignment($name.resultToken, $op1.result);
	} |
		op2 = bitwisebinaryinstruction{
		$result = factory.createAssignment($name.resultToken, $op2.result);
	} |
		op3 = vectorinstructions | 
		op4 = aggregateinstruction | 
		op5 = instruction_alloca{
		$result = factory.createAssignment($name.resultToken, $op5.result);
	} |
		op6 = instruction_load{
		$result = factory.createAssignment($name.resultToken, $op6.result);
	} |
		op7 = instruction_getelementptr{
			$result = factory
		}|
		op8 = instruction_cmpxchg |
		op9 = instruction_atomicrmw |
		op10= conversioninstruction |
		op11= otherinstruction {
			$result = factory.createAssignment($name.resultToken,$op11.result);
		}|
		op12= instruction_call_nonvoid{
			$result = factory.createAssignment($name.resultToken, $op12.result);
		}
	)
;

//paramname returns ecore::estring:
//	// a value converter translates this into either %num (if this isn't provided)
//	// or into %name if it is.
//	Local_id?
//;
paramname returns [Token resultToken]:
	// a value converter translates this into either %num (if this isn't provided)
	// or into %name if it is.
	(Local_id{
		$resultToken = $Local_id;
	})?
;

//localname returns ecore::estring:
//	// a value converter translates this into either %num (if this isn't provided)
//	// or into %name if it is.
//	(Local_id WS* '=')?
//;
localname returns [Token resultToken]:
	// a value converter translates this into either %num (if this isn't provided)
	// or into %name if it is.
	(Local_id WS* '='{
		$resultToken = $Local_id;
	})?
;

//globalname returns ecore::estring:
//	// a value converter translates this into either %num (if this isn't provided)
//	// or into %name if it is.
//	(Global_id WS* '=')?
//;
globalname :
  (Global_id WS* '=')?;

terminatorinstruction returns [LlvmStatementNode result, Token resultToken]:
	(
		namedterminatorinstruction |
		op2 = instruction_ret{
			$result = $op2.result;
			$resultToken = $op2.resultToken;
		} |
		op3 = instruction_br{
			$result = $op3.result;
			$resultToken = $op3.resultToken;
		} |
		instruction_switch |
		instruction_indirectbr |
		instruction_resume |
		instruction_unreachable |
		instruction_invoke_void
	)
	metadatasuffix*
;

namedterminatorinstruction returns [LlvmExpressionNode result]: 
	name=localname
	(
		op = instruction_invoke_nonvoid
	)
;

// ret <type> <value>       ; return a value from a non-void function
// ret void                 ; return from void function
instruction_ret returns [LlvmStatementNode result, Token resultToken]:
	opcode='ret' (val=typedvalue{
		$result = factory.createReturn($opcode, $val.result);
		$resultToken = $val.resultToken;
	} | re = 'void'{
		$resultToken = $re;
		$result = factory.createReturn($opcode, null);
	})
;

// br i1 <cond>, label <iftrue>, label <iffalse>
// br label <dest>          ; unconditional branch

	
instruction_br returns [LlvmStatementNode result, Token resultToken]:
	opcode='br' (
		(condition=typedvalue ',' 'label' trueelement=basicblockref ',' 'label' falseelement=basicblockref 
		{
			//boolean isTrue = $condition.resultToken.getText().equals("true");
			$resultToken = $falseelement.resultToken;
			blockMap.put($trueelement.resultToken.getText()+ "then",null);
			blockMap.put($falseelement.resultToken.getText()+"else",null);
//			LlvmExpressionNode trueToken = factory.createisReadBlock($trueelement.resultToken);
//			LlvmExpressionNode falseToken = factory.createisReadBlock($falseelement.resultToken);
//			LlvmExpressionNode trueNode = factory.createCallBasicBlock(trueToken,$resultToken);
//			LlvmExpressionNode falseNode = factory.createCallBasicBlock(falseToken,$resultToken);
//			//$result = factory.createIf($opcode, $condition.result ,trueNode,falseNode);
			conditionToken = $condition.result; 
			count += 2;
			thenStr = null;
			elseStr = null;
			thenElse.put($trueelement.resultToken.getText()+ "then", $falseelement.resultToken.getText()+"else");
		}) |
		('label' unconditional=basicblockref{
			$resultToken = $unconditional.resultToken;	
			LlvmExpressionNode unconNode = factory.createisReadBlock($resultToken);
			//$result = factory.createCallBasicBlock(unconNode,$resultToken);
			if(unconNode != null && !blockMap.containsKey($resultToken.getText() + "then")&& !blockMap.containsKey($resultToken.getText() + "else")){
				isWhile = true;
				//$result = factory.createCallBasicBlock(unconNode,$resultToken);
				//$result = factory.createisReadBlock($resultToken);
				// if exists, it creates the whileNode;
			}
		})
	)
;

// switch <intty> <value>, label <defaultdest> [ <intty> <val>, label <dest> ... ]
instruction_switch:
	opcode='switch' comparisonvalue=typedvalue
	',' 'label' defaultdest=basicblockref
	'['
	(caseconditions+=typedvalue ',' 'label' destinations+=basicblockref)*
	']'
;

// indirectbr <somety>* <address>, [ label <dest1>, label <dest2>, ... ]
instruction_indirectbr:
	opcode='indirectbr' address=typedvalue ','
	'['
	('label' destinations+=basicblockref (',' 'label' destinations+=basicblockref)*)?
	']'
;

// <result> = invoke [cconv] [ret attrs] <ptr to function ty> <function ptr val>(<function args>) [fn attrs]
//                 to label <normal label> unwind label <exception label>
// notice this template as it appears in the reference is incorrect, <ptr to function ty> actually
// behaves just like in a call instruction, so it's possible to provide return type only.
instruction_invoke_void:
	opcode='invoke' cconv?
	('zeroext'? 'signext'? 'inreg'?)
	voidtype
	callee
	arglist
	functionattributes?
	'to' 'label' tolabel=basicblockref 'unwind' 'label' exceptionlabel=basicblockref
;

// <result> = invoke [cconv] [ret attrs] <ptr to function ty> <function ptr val>(<function args>) [fn attrs]
//                 to label <normal label> unwind label <exception label>
// notice this template as it appears in the reference is incorrect, <ptr to function ty> actually
// behaves just like in a call instruction, so it's possible to provide return type only.
instruction_invoke_nonvoid:
	opcode='invoke' cconv?
	('zeroext'? 'signext'? 'inreg'?)
	nonvoidtype
	callee
	arglist
	functionattributes?
	'to' 'label' tolabel=basicblockref 'unwind' 'label' exceptionlabel=basicblockref
;

// resume <type> <value>
instruction_resume:
	opcode='resume' value=typedvalue
;

// unreachable
instruction_unreachable:
	opcode='unreachable'
;

basicblockref returns [LlvmStatementNode result,CommonToken resultToken]:
	(basicBlockNodeName = basicblock|Local_id{
		$resultToken = (CommonToken)$Local_id; 
	})
;

binaryinstruction returns [LlvmExpressionNode result]:
	(op1 = instruction_add{
		$result = $op1.result;
	} |
	op2 = instruction_fadd{
		$result = $op2.result;
	} |
	op3 = instruction_sub{
		$result = $op3.result;
	} |
	op4 = instruction_fsub{
		$result = $op4.result;
	} |
	op5 = instruction_mul{
		$result = $op5.result;
	} |
	op6 = instruction_fmul{
		$result = $op6.result;
	} |
	op7 = instruction_udiv{
		$result = $op7.result;
	} |
	op8 = instruction_sdiv{
		$result = $op8.result;
	} |
	op9 = instruction_fdiv{
		$result = $op9.result;
	} |
	op10 = instruction_urem{
		$result = $op10.result;
	} |
	op11 = instruction_srem{
		$result = $op11.result;
	} |
	op12 = instruction_frem{
		$result = $op12.result;
	})
	
;

// <result> = add <ty> <op1>, <op2>          ; yields {ty}:result
// <result> = add nuw <ty> <op1>, <op2>      ; yields {ty}:result
// <result> = add nsw <ty> <op1>, <op2>      ; yields {ty}:result
// <result> = add nuw nsw <ty> <op1>, <op2>  ; yields {ty}:result
instruction_add returns [LlvmExpressionNode result]:
	opcode='add' ('nuw'? 'nsw'?) type op1=valueref ',' op2=valueref{
		LlvmExpressionNode leftNode = $op1.result;
		LlvmExpressionNode rightNode = $op2.result;
		if($op1.result == null){
			leftNode = factory.createNumericLiteral($op1.resultToken);
		}
		if($op2.result == null){
			rightNode = factory.createNumericLiteral($op2.resultToken);
		}
		$result = factory.createBinary($opcode, leftNode, rightNode);
	}
;

// <result> = fadd [fast-math flags]* <ty> <op1>, <op2>   ; yields {ty}:result
instruction_fadd returns [LlvmExpressionNode result]:
	opcode='fadd' fastmathflags+=fastmathflag* type op1=valueref ',' op2=valueref{
		$result = factory.createBinary($opcode, $op1.result, $op2.result);
	}
;

//fastmathflag:
//	{fastmathflag}
//	kind=("nnan" | "ninf" | "nsz" | "arcp" | "fast")
//;
fastmathflag:
	'nnan' | 'ninf' | 'nsz' | 'arcp' | 'fast' ;

// <result> = sub <ty> <op1>, <op2>          ; yields {ty}:result
// <result> = sub nuw <ty> <op1>, <op2>      ; yields {ty}:result
// <result> = sub nsw <ty> <op1>, <op2>      ; yields {ty}:result
// <result> = sub nuw nsw <ty> <op1>, <op2>  ; yields {ty}:result
instruction_sub returns [LlvmExpressionNode result]:
	opcode='sub' ('nuw'? 'nsw'?) type op1=valueref ',' op2=valueref{
		$result = factory.createBinary($opcode, $op1.result, $op2.result);
	}
;

// <result> = fsub [fast-math flags]* <ty> <op1>, <op2>   ; yields {ty}:result
instruction_fsub returns [LlvmExpressionNode result]:
	opcode='fsub' fastmathflags+=fastmathflag* type op1=valueref ',' op2=valueref{
		$result = factory.createBinary($opcode, $op1.result, $op2.result);
	}
;

// <result> = mul <ty> <op1>, <op2>          ; yields {ty}:result
// <result> = mul nuw <ty> <op1>, <op2>      ; yields {ty}:result
// <result> = mul nsw <ty> <op1>, <op2>      ; yields {ty}:result
// <result> = mul nuw nsw <ty> <op1>, <op2>  ; yields {ty}:result
instruction_mul returns [LlvmExpressionNode result]:
	opcode='mul' ('nuw'? 'nsw'?) type op1=valueref ',' op2=valueref{
		$result = factory.createBinary($opcode, $op1.result, $op2.result);
	}
;

// <result> = fmul [fast-math flags]* <ty> <op1>, <op2>   ; yields {ty}:result
instruction_fmul returns [LlvmExpressionNode result]:
	opcode='fmul' fastmathflags+=fastmathflag* type op1=valueref ',' op2=valueref{
		$result = factory.createBinary($opcode, $op1.result, $op2.result);
	}
;

// <result> = udiv <ty> <op1>, <op2>         ; yields {ty}:result
// <result> = udiv exact <ty> <op1>, <op2>   ; yields {ty}:result
instruction_udiv returns [LlvmExpressionNode result]:
	opcode='udiv' 'exact'? type op1=valueref ',' op2=valueref{
		$result = factory.createBinary($opcode, $op1.result, $op2.result);
	}
;

// <result> = sdiv <ty> <op1>, <op2>         ; yields {ty}:result
// <result> = sdiv exact <ty> <op1>, <op2>   ; yields {ty}:result
instruction_sdiv returns [LlvmExpressionNode result]:
	opcode='sdiv' 'exact'? type op1=valueref ',' op2=valueref{
		$result = factory.createBinary($opcode, $op1.result, $op2.result);
	}
;

// <result> = fdiv [fast-math flags]* <ty> <op1>, <op2>   ; yields {ty}:result
instruction_fdiv returns [LlvmExpressionNode result]:
	opcode='fdiv' fastmathflags+=fastmathflag* type op1=valueref ',' op2=valueref{
		$result = factory.createBinary($opcode, $op1.result, $op2.result);
	}
;

// <result> = urem <ty> <op1>, <op2>   ; yields {ty}:result
instruction_urem returns [LlvmExpressionNode result]:
	opcode='urem' type op1=valueref ',' op2=valueref{
		$result = factory.createBinary($opcode, $op1.result, $op2.result);
	}
;

// <result> = srem <ty> <op1>, <op2>   ; yields {ty}:result
instruction_srem returns [LlvmExpressionNode result]:
	opcode='srem' type op1=valueref ',' op2=valueref{
		$result = factory.createBinary($opcode, $op1.result, $op2.result);
	}
;

// <result> = frem <ty> <op1>, <op2>   ; yields {ty}:result
instruction_frem returns [LlvmExpressionNode result]:
	opcode='frem' type op1=valueref ',' op2=valueref{
		$result = factory.createBinary($opcode, $op1.result, $op2.result);
	}
;

bitwisebinaryinstruction returns [LlvmExpressionNode result]:
	(op1 = instruction_shl{
		$result = $op1.result;
	} |
	op2 = instruction_lshr{
		$result = $op2.result;
	} |
	op3 = instruction_ashr{
		$result = $op3.result;
	} |
	op4 = instruction_and{
		$result = $op4.result;
	} |
	op5 = instruction_or{
		$result = $op5.result;
	} |
	op6 = instruction_xor{
		$result = $op6.result;
	})
;

// <result> = shl <ty> <op1>, <op2>           ; yields {ty}:result
// <result> = shl nuw <ty> <op1>, <op2>       ; yields {ty}:result
// <result> = shl nsw <ty> <op1>, <op2>       ; yields {ty}:result
// <result> = shl nuw nsw <ty> <op1>, <op2>   ; yields {ty}:result
instruction_shl returns [LlvmExpressionNode result]:
	opcode='shl' ('nuw'? 'nsw'?) type op1=valueref ',' op2=valueref{
		$result = factory.createBinary($opcode, $op1.result, $op2.result);
	}
;

// <result> = lshr <ty> <op1>, <op2>         ; yields {ty}:result
// <result> = lshr exact <ty> <op1>, <op2>   ; yields {ty}:result
instruction_lshr returns [LlvmExpressionNode result]:
	opcode='lshr' 'exact'? type op1=valueref ',' op2=valueref{
		$result = factory.createBinary($opcode, $op1.result, $op2.result);
	}
;

// <result> = ashr <ty> <op1>, <op2>         ; yields {ty}:result
// <result> = ashr exact <ty> <op1>, <op2>   ; yields {ty}:result
instruction_ashr  returns [LlvmExpressionNode result]:
	opcode='ashr' 'exact'? type op1=valueref ',' op2=valueref{
		$result = factory.createBinary($opcode, $op1.result, $op2.result);
	}
;

// <result> = and <ty> <op1>, <op2>   ; yields {ty}:result
instruction_and  returns [LlvmExpressionNode result]:
	opcode='and' type op1=valueref ',' op2=valueref{
		$result = factory.createBinary($opcode, $op1.result, $op2.result);
	}
;

// <result> = or <ty> <op1>, <op2>   ; yields {ty}:result
instruction_or  returns [LlvmExpressionNode result]:
	opcode='or' type op1=valueref ',' op2=valueref{
		$result = factory.createBinary($opcode, $op1.result, $op2.result);
	}
;

// <result> = xor <ty> <op1>, <op2>   ; yields {ty}:result
instruction_xor returns [LlvmExpressionNode result]:
	opcode='xor' type op1=valueref ',' op2=valueref{
		$result = factory.createBinary($opcode, $op1.result, $op2.result);
	}
;

vectorinstructions:
	instruction_extractelement |
	instruction_insertelement |
	instruction_shufflevector
;

// <result> = extractelement <n x <ty>> <val>, i32 <idx>    ; yields <ty>
instruction_extractelement:
	opcode='extractelement' vector=typedvalue ',' index=typedvalue
;

// <result> = insertelement <n x <ty>> <val>, <ty> <elt>, i32 <idx>    ; yields <n x <ty>>
instruction_insertelement:
	opcode='insertelement' vector=typedvalue
	',' element=typedvalue
	',' index=typedvalue
;

// <result> = shufflevector <n x <ty>> <v1>, <n x <ty>> <v2>, <m x i32> <mask>    ; yields <m x <ty>>
instruction_shufflevector:
	opcode='shufflevector'
	vector1=typedvalue ','
	vector2=typedvalue ','
	mask=typedvalue
;

aggregateinstruction:
	instruction_extractvalue |
	instruction_insertvalue
;

// <result> = extractvalue <aggregate type> <val>, <idx>{, <idx>}*
instruction_extractvalue:
	opcode='extractvalue' aggregate=typedvalue (',' indices+=constant)+
;

// <result> = insertvalue <aggregate type> <val>, <ty> <elt>, <idx>{, <idx>}*    ; yields <aggregate type>
instruction_insertvalue:
	opcode='insertvalue' aggregate=typedvalue
	',' element=typedvalue
	(',' indices+=constant)+
;

memoryinstruction:
	instruction_alloca |
	instruction_load |
	instruction_store |
	instruction_fence |
	instruction_cmpxchg |
	instruction_atomicrmw |
	instruction_getelementptr
;

// <result> = alloca <type>[, <ty> <numelements>][, align <alignment>]     ; yields {type*}:result
instruction_alloca returns [LlvmExpressionNode result]:
	opcode='alloca' allocaType = type
	(',' numelements=typedvalue{
		$result = $numelements.result;
	})?
	(',' alignment=align{
		if($allocaType.resultToken != null){
			$result = factory.createArrayLiteral($allocaType.resultToken);
		}
		$result = factory.createNumericLiteral($alignment.result);
	})?
;

// <result> = load [volatile] <ty>* <pointer>[, align <alignment>][, !nontemporal !<index>][, !invariant.load !<index>]
// <result> = load atomic [volatile] <ty>* <pointer> [singlethread] <ordering>, align <alignment>
// !<index> = !{ i32 1 }
instruction_load returns [LlvmExpressionNode result]:
	opcode='load'
	(
		(
			'volatile'? type (',' type)? Local_id{
			$result = factory.createRead($Local_id);}
			(',' alignment=align)?
			(',' '!nontemporal' nontemporalindex=metadataref)?
			(',' '!invariant.load' invariantloadindex=metadataref)?
		) | 
		(
			'atomic' 'volatile'? type Local_id{
			$result = factory.createRead($Local_id);}
			'singlethread'?
			ordering
			align
		)
	)
;

// store [volatile] <ty> <value>, <ty>* <pointer>[, align <alignment>][, !nontemporal !<index>]        ; yields {void}
// store atomic [volatile] <ty> <value>, <ty>* <pointer> [singlethread] <ordering>, align <alignment>  ; yields {void}
instruction_store returns [LlvmExpressionNode result]:
	opcode='store' 
	(
		(
			'volatile'?
			type (Local_id{$result = factory.createRead($Local_id);} | 
			value2=Integer{$result = factory.createNumericLiteral($value2);})
			',' type pointer=Local_id
			(',' alignment=align)?
			(',' '!nontemporal' nontemporalindex=metadataref)?{			
			$result = factory.createReassignment($pointer,$result);	
	}
		) | 
		(
			'atomic' 'volatile'?
			type (Local_id{$result = factory.createRead($Local_id);} | 
			value4=Integer{$result = factory.createNumericLiteral($value4);})
			',' type pointer=Local_id
			'singlethread'?
			ordering
			alignment=align{
			$result = factory.createReassignment($pointer,$result);	
	}
		)
	)
;

// fence [singlethread] <ordering>                   ; yields {void}
instruction_fence:
	opcode='fence' 'singlethread'? ordering
;

// cmpxchg [volatile] <ty>* <pointer>, <ty> <cmp>, <ty> <new> [singlethread] <ordering>  ; yields {ty}
instruction_cmpxchg:
	opcode='cmpxchg' 'volatile'? pointer=typedvalue
	',' comparedwith=typedvalue
	',' newvalue=typedvalue
	'singlethread'? ordering
;

// atomicrmw [volatile] <operation> <ty>* <pointer>, <ty> <value> [singlethread] <ordering>
//                   ; yields {ty}
instruction_atomicrmw:
	opcode='atomicrmw' 'volatile'? operation=atomicrmw_operation
	pointer=typedvalue
	',' typedvalue 'singlethread'? ordering
;

atomicrmw_operation:
	'xchg' | 'add' | 'sub' | 'and' | 'nand' |
	'or' | 'xor' | 'max' | 'min' | 'umax' | 'umin'
;

// <result> = getelementptr <pty>* <ptrval>{, <ty> <idx>}*
// <result> = getelementptr inbounds <pty>* <ptrval>{, <ty> <idx>}*
// <result> = getelementptr <ptr vector> ptrval, <vector index type> idx 
instruction_getelementptr returns [LlvmExpressionNode result]:{
		Token index;
	}
	opcode='getelementptr' 'inbounds'?
	base=typedvalue{
		$result = factory.createRead($base.resultToken);
	}
	(',' indices =typedvalue{
		index = indices.resultToken;
	})*{
		if(index != null){
			$result = factory.createArrayCopyBinary($opcode, $result, factory.createNumericLiteral(index));
		}
	}
;

conversioninstruction:
	// merged since they all look exactly the same except the opcode
	opcode=convertionopcode
	fromtype=type value=valueref 'to' targettype=type
;

convertionopcode:
	'trunc' | 'zext' | 'sext' |
	'fptrunc' | 'fpext' | 'fptoui' | 'fptosi' | 'uitofp' | 'sitofp' |
	'ptrtoint' | 'inttoptr' |
	'bitcast' | 'addrspacecast'
;

otherinstruction returns [LlvmExpressionNode result]:
	op1 = instruction_icmp {
		$result = $op1.result; 
	}|
	instruction_fcmp |
	instruction_select |
	instruction_va_arg |
	instruction_landingpad
;

// <result> = icmp <cond> <ty> <op1>, <op2>   ; yields {i1} or {<n x i1>}:result
instruction_icmp returns [LlvmExpressionNode result]:
	opcode='icmp' condition=icmpcondition type op1=valueref ',' op2=valueref{
		LlvmExpressionNode op1Result = factory.createisReadBlock($op1.resultToken);
		if(op1Result == null){
			op1Result = factory.createNumericLiteral($op1.resultToken);
		}
		LlvmExpressionNode op2Result = factory.createisReadBlock($op2.resultToken);
		if(op2Result == null){
			op2Result = factory.createNumericLiteral($op2.resultToken);
		}
		$result = factory.createCompBinary($opcode,$condition.resultToken.getText(),op1Result,op2Result);
	}
;

icmpcondition returns [Token resultToken]:
	opconde = ('eq' | 'ne' |
	'ugt' | 'uge' | 'ult' | 'ule' |
	'sgt' | 'sge' | 'slt' | 'sle'){
		$resultToken = $opconde;
	}
;

// <result> = fcmp <cond> <ty> <op1>, <op2>     ; yields {i1} or {<n x i1>}:result
instruction_fcmp:
	opcode='fcmp' condition=fcmpcondition type op1=valueref ',' op2=valueref
;

fcmpcondition:
	Boolean |
	'oeq' | 'ogt' | 'oge' | 'olt' | 'ole' | 'one' | 'ord' |
	'ueq' | 'ugt' | 'uge' | 'ult' | 'ule' | 'une' | 'uno'
;

// <result> = phi <ty> [ <val0>, <label0>], ...
instruction_phi:
	opcode='phi' type
	('[' values+=valueref ',' labels+=basicblockref ']')
	(',' '[' values+=valueref ',' labels+=basicblockref ']')*
;

// <result> = select selty <cond>, <ty> <val1>, <ty> <val2>             ; yields ty
// selty is either i1 or {<n x i1>}
instruction_select:
	opcode='select' condition=typedvalue
	',' value1=typedvalue
	',' value2=typedvalue
;

// <result> = [tail] call [cconv] [ret attrs] <ty> [<fnty>*] <fnptrval>(<function args>) [fn attrs]
instruction_call_nonvoid returns [LlvmExpressionNode result]:{
		Token finalToken;
	}
	(istail = 'tail'?)?
	opcode='call'
	cconv?
	returnattributes=parameterattributes?
	nonvoidtype
	functionName = callee
	arglistName = arglist
	functionattributes?{
		LlvmExpressionNode node = factory.createRead($functionName.resultToken);
		finalToken = $arglistName.finalToken;
		$result = factory.createCall(node,$arglistName.result, finalToken);
	}
;

instruction_call_void returns [LlvmExpressionNode result]:{
		Token finalToken;
	}
	(istail = 'tail'?)?
	opcode='call'
	cconv?
	returnattributes=parameterattributes?
	voidtype
	functionName = callee
	args=arglist
	functionattributes?{
		LlvmExpressionNode node = factory.createRead($functionName.resultToken);
		finalToken = $args.finalToken;
		$result = factory.createCall(node,$args.result, finalToken);
	}
;

arglist returns [List<LlvmExpressionNode> result, Token finalToken]:{
		List<LlvmExpressionNode> parameters = new ArrayList<>();
	}
	'(' (arguments=argument{		
		parameters.add(factory.createRead($arguments.resultToken));
	} (',' arguments=argument{
		parameters.add(factory.createRead($arguments.resultToken));
	})* )? op1 = ')'{
		$result = parameters;
		$finalToken = $op1;
	}
;

callee returns [LlvmExpressionNode result, Token resultToken]:
	op1 = valueref{
		$resultToken = $op1.resultToken; 
	} | inlineassembler
;

inlineassembler:
	'asm' 'sideeffect'? 'alignstack'? 'inteldialect'? assembler=String ',' flags=String
;


// <resultval> = va_arg <va_list*> <arglist>, <argty>
instruction_va_arg:
	opcode='va_arg' typedvalue ',' type
;

// <resultval> = landingpad <resultty> personality <type> <pers_fn> <clause>+
// <resultval> = landingpad <resultty> personality <type> <pers_fn> cleanup <clause>*
// <clause> := catch <type> <value>
// <clause> := filter <array constant type> <array constant>
instruction_landingpad:
	opcode='landingpad' resulttype=type 'personality' personality=typedvalue
	(clauses+=landingpadclause | 'cleanup')
	clauses+=landingpadclause*
;

landingpadclause:
	landingpadtype='catch' catchtype=typedvalue |
	landingpadtype='filter' arrayType=arraytype arrayConstant=arrayconstant
;

ordering:
	'unordered' | 'monotonic' | 'acquire' | 'release' | 'acq_rel' | 'seq_cst'
;

typedvalue returns [LlvmExpressionNode result,Token resultToken]:
	type val = valueref{
		$result = $val.result;
		$resultToken = $val.resultToken;
	}
;

parametertype:
	type parameterattributes?
;

parameterattributes:
	attributes+=parameterattribute+
;

parameterattribute:
	'zeroext' |
	'signext' |
	'inreg' |
	('byval' ('align' Integer)?) |
	'sret' |
	'noalias' |
	'nocapture' |
	'nest' |
	'returned' |
	'inalloca'
;

argument returns [Token resultToken]:
	parametertype op2 = valueref{
		$resultToken = $op2.resultToken;
	}
;

parameter returns [Token resultToken]:
	parametertype pa1 = paramname{
		$resultToken = $pa1.resultToken;
	}
;

nonvoidtype:
	// a function which returns void, or a pointer to such a function.
	basetype=voidtype
	suffixes+=typesuffix+
	|
	// a non-void single type, or a pointer to such a type, or a function which returns
	// such a type or a pointer to such a type, or a pointer to such a function. in short,
	// all type options not covered by the previous alternative, but not including "void",
	// which is the only type not allowed.
	nonleftrecursivenonvoidtype
	star*
	typesuffix*
;

star:
	addressspace? '*'
;

type returns [Token resultToken]:
	basetype=nonleftrecursivetype{
		$resultToken = $basetype.resultToken;
	}
	// pointers or functions:
	stars+=star*
	suffixes+=typesuffix*
;

// a suffix of a function type or a pointer to a function type - basically
// the entire function type, not including the return type.  
typesuffix:
	'(' (
		(containedtypes+=parametertype (',' containedtypes+=parametertype)* (',' vararg='...')?)? |
		vararg='...'
	)')'
	stars+=star*
;

nonleftrecursivetype returns [Token resultToken]:
	// complete types:
	(
		intType = inttype|
		floatingType = floatingtype|
		vectortype |
		arrayType = arraytype{
			$resultToken = $arrayType.resultToken;
		} |
		x86mmxtype |
		voidtype |
		metadatatype |
		structtype |
		opaquetype
	) |
	(typedef|Local_id)
;

nonleftrecursivenonvoidtype returns [Token resultToken]:
	// complete types:
	(
		intType = inttype|
		floatingType = floatingtype|
		vectortype |
		arrayType = arraytype{
			$resultToken = $arrayType.resultToken;
		} |
		x86mmxtype |
		metadatatype |
		structtype |
		opaquetype
	) |
	(typedef|Local_id)
;

typedef:
	localname 'type' nonvoidtype
;

binaryopcode:
	'mov' | 'add' | 'sub'
;

inttype returns [Token resultToken]:
	Int_type {
		$resultToken = $Int_type;
	}
;

opaquetype:
	'opaque'
;

structtype:
	(
		'{' (types+=type (',' types+=type)*)? '}' |
		packed='<' '{' (types+=type (',' types+=type)*)? '}' '>'
	)
;

vectortype:
	'<' size=Integer 'x' elemtype=type '>'
;

arraytype returns [CommonToken resultToken]:
	'[' size=Integer 'x' elemtype=type {
		$resultToken = $size;
		$resultToken.setText($elemtype.resultToken.getText()+"x" + $size.getText());
	}']'
;

x86mmxtype:
	'x86_mmx' 
;

voidtype:
	'void'
;

metadatatype:
	'metadata' 
;

floatingtype:
	('half' | 'float' | 'double' | 'fp128' | 'x86_fp80' | 'ppc_fp128')
;

linkage:
	'private' |
	'linker_private' |
	'linker_private_weak' |
	'linker_private_weak_def_auto' |
	'internal' |
	'available_externally' |
	'linkonce' |
	'weak' |
	'common' |
	'appending' |
	'extern_weak' |
	'linkonce_odr' |
	'weak_odr' |
	'external' |
	'dllimport' |
	'dllexport'
;

cconv:
	val=(
		'ccc' |
		'fastcc' |
		'coldcc' |
		'webkit_jscc' |
		'anyregcc' |
		'preserve_mostcc' |
		'preserve_allcc' |
		// the following are not documented in the langref:
	    'intel_ocl_bicc' |
	    'x86_stdcallcc' |
	    'x86_fastcallcc' |
	    'x86_thiscallcc' |
	    'arm_apcscc' |
	    'arm_aapcscc' |
	    'arm_aapcs_vfpcc' |
	    'msp430_intrcc' |
	    'ptx_kernel' |
	    'ptx_device' |
	    'spir_kernel' |
	    'spir_func' |
	    'x86_64_sysvcc' |
	    'x86_64_win64cc'
    )
    |
    // custom
	val='cc' customnumber=Integer
;


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
