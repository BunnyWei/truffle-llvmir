// Generated from LLVM_IR.g4 by ANTLR 4.4
package com.oracle.truffle.llvm.parser;

	package com.oracle.truffle.llvm.parser;
	import com.oracle.truffle.llvm.parser.*;
	import com.oracle.truffle.llvm.nodes.*;
	import com.oracle.truffle.api.source.*;
	import com.oracle.truffle.llvm.runtime.*;
	import java.util.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LLVM_IRParser}.
 */
public interface LLVM_IRListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#namedterminatorinstruction}.
	 * @param ctx the parse tree
	 */
	void enterNamedterminatorinstruction(@NotNull LLVM_IRParser.NamedterminatorinstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#namedterminatorinstruction}.
	 * @param ctx the parse tree
	 */
	void exitNamedterminatorinstruction(@NotNull LLVM_IRParser.NamedterminatorinstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_store}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_store(@NotNull LLVM_IRParser.Instruction_storeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_store}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_store(@NotNull LLVM_IRParser.Instruction_storeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_and}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_and(@NotNull LLVM_IRParser.Instruction_andContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_and}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_and(@NotNull LLVM_IRParser.Instruction_andContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#callee}.
	 * @param ctx the parse tree
	 */
	void enterCallee(@NotNull LLVM_IRParser.CalleeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#callee}.
	 * @param ctx the parse tree
	 */
	void exitCallee(@NotNull LLVM_IRParser.CalleeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#tlsoption}.
	 * @param ctx the parse tree
	 */
	void enterTlsoption(@NotNull LLVM_IRParser.TlsoptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#tlsoption}.
	 * @param ctx the parse tree
	 */
	void exitTlsoption(@NotNull LLVM_IRParser.TlsoptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_va_arg}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_va_arg(@NotNull LLVM_IRParser.Instruction_va_argContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_va_arg}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_va_arg(@NotNull LLVM_IRParser.Instruction_va_argContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_fdiv}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_fdiv(@NotNull LLVM_IRParser.Instruction_fdivContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_fdiv}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_fdiv(@NotNull LLVM_IRParser.Instruction_fdivContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#middleinstruction}.
	 * @param ctx the parse tree
	 */
	void enterMiddleinstruction(@NotNull LLVM_IRParser.MiddleinstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#middleinstruction}.
	 * @param ctx the parse tree
	 */
	void exitMiddleinstruction(@NotNull LLVM_IRParser.MiddleinstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull LLVM_IRParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull LLVM_IRParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#typedvalue}.
	 * @param ctx the parse tree
	 */
	void enterTypedvalue(@NotNull LLVM_IRParser.TypedvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#typedvalue}.
	 * @param ctx the parse tree
	 */
	void exitTypedvalue(@NotNull LLVM_IRParser.TypedvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#arrayconstant}.
	 * @param ctx the parse tree
	 */
	void enterArrayconstant(@NotNull LLVM_IRParser.ArrayconstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#arrayconstant}.
	 * @param ctx the parse tree
	 */
	void exitArrayconstant(@NotNull LLVM_IRParser.ArrayconstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#structureconstant}.
	 * @param ctx the parse tree
	 */
	void enterStructureconstant(@NotNull LLVM_IRParser.StructureconstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#structureconstant}.
	 * @param ctx the parse tree
	 */
	void exitStructureconstant(@NotNull LLVM_IRParser.StructureconstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#parametertype}.
	 * @param ctx the parse tree
	 */
	void enterParametertype(@NotNull LLVM_IRParser.ParametertypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#parametertype}.
	 * @param ctx the parse tree
	 */
	void exitParametertype(@NotNull LLVM_IRParser.ParametertypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#inttype}.
	 * @param ctx the parse tree
	 */
	void enterInttype(@NotNull LLVM_IRParser.InttypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#inttype}.
	 * @param ctx the parse tree
	 */
	void exitInttype(@NotNull LLVM_IRParser.InttypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#localvalue}.
	 * @param ctx the parse tree
	 */
	void enterLocalvalue(@NotNull LLVM_IRParser.LocalvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#localvalue}.
	 * @param ctx the parse tree
	 */
	void exitLocalvalue(@NotNull LLVM_IRParser.LocalvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#constantexpression_insertelement}.
	 * @param ctx the parse tree
	 */
	void enterConstantexpression_insertelement(@NotNull LLVM_IRParser.Constantexpression_insertelementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#constantexpression_insertelement}.
	 * @param ctx the parse tree
	 */
	void exitConstantexpression_insertelement(@NotNull LLVM_IRParser.Constantexpression_insertelementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#model}.
	 * @param ctx the parse tree
	 */
	void enterModel(@NotNull LLVM_IRParser.ModelContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#model}.
	 * @param ctx the parse tree
	 */
	void exitModel(@NotNull LLVM_IRParser.ModelContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#paramname}.
	 * @param ctx the parse tree
	 */
	void enterParamname(@NotNull LLVM_IRParser.ParamnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#paramname}.
	 * @param ctx the parse tree
	 */
	void exitParamname(@NotNull LLVM_IRParser.ParamnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#toplevelelement}.
	 * @param ctx the parse tree
	 */
	void enterToplevelelement(@NotNull LLVM_IRParser.ToplevelelementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#toplevelelement}.
	 * @param ctx the parse tree
	 */
	void exitToplevelelement(@NotNull LLVM_IRParser.ToplevelelementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#inlineasm}.
	 * @param ctx the parse tree
	 */
	void enterInlineasm(@NotNull LLVM_IRParser.InlineasmContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#inlineasm}.
	 * @param ctx the parse tree
	 */
	void exitInlineasm(@NotNull LLVM_IRParser.InlineasmContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#constantexpression_binary}.
	 * @param ctx the parse tree
	 */
	void enterConstantexpression_binary(@NotNull LLVM_IRParser.Constantexpression_binaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#constantexpression_binary}.
	 * @param ctx the parse tree
	 */
	void exitConstantexpression_binary(@NotNull LLVM_IRParser.Constantexpression_binaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_srem}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_srem(@NotNull LLVM_IRParser.Instruction_sremContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_srem}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_srem(@NotNull LLVM_IRParser.Instruction_sremContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_shl}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_shl(@NotNull LLVM_IRParser.Instruction_shlContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_shl}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_shl(@NotNull LLVM_IRParser.Instruction_shlContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#globalvaluedef}.
	 * @param ctx the parse tree
	 */
	void enterGlobalvaluedef(@NotNull LLVM_IRParser.GlobalvaluedefContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#globalvaluedef}.
	 * @param ctx the parse tree
	 */
	void exitGlobalvaluedef(@NotNull LLVM_IRParser.GlobalvaluedefContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#metadatatype}.
	 * @param ctx the parse tree
	 */
	void enterMetadatatype(@NotNull LLVM_IRParser.MetadatatypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#metadatatype}.
	 * @param ctx the parse tree
	 */
	void exitMetadatatype(@NotNull LLVM_IRParser.MetadatatypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_insertelement}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_insertelement(@NotNull LLVM_IRParser.Instruction_insertelementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_insertelement}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_insertelement(@NotNull LLVM_IRParser.Instruction_insertelementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#functionattributes}.
	 * @param ctx the parse tree
	 */
	void enterFunctionattributes(@NotNull LLVM_IRParser.FunctionattributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#functionattributes}.
	 * @param ctx the parse tree
	 */
	void exitFunctionattributes(@NotNull LLVM_IRParser.FunctionattributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_br}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_br(@NotNull LLVM_IRParser.Instruction_brContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_br}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_br(@NotNull LLVM_IRParser.Instruction_brContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_extractvalue}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_extractvalue(@NotNull LLVM_IRParser.Instruction_extractvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_extractvalue}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_extractvalue(@NotNull LLVM_IRParser.Instruction_extractvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_mul}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_mul(@NotNull LLVM_IRParser.Instruction_mulContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_mul}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_mul(@NotNull LLVM_IRParser.Instruction_mulContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#arraytype}.
	 * @param ctx the parse tree
	 */
	void enterArraytype(@NotNull LLVM_IRParser.ArraytypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#arraytype}.
	 * @param ctx the parse tree
	 */
	void exitArraytype(@NotNull LLVM_IRParser.ArraytypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_sdiv}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_sdiv(@NotNull LLVM_IRParser.Instruction_sdivContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_sdiv}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_sdiv(@NotNull LLVM_IRParser.Instruction_sdivContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#basicblock}.
	 * @param ctx the parse tree
	 */
	void enterBasicblock(@NotNull LLVM_IRParser.BasicblockContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#basicblock}.
	 * @param ctx the parse tree
	 */
	void exitBasicblock(@NotNull LLVM_IRParser.BasicblockContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_icmp}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_icmp(@NotNull LLVM_IRParser.Instruction_icmpContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_icmp}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_icmp(@NotNull LLVM_IRParser.Instruction_icmpContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#basicblockref}.
	 * @param ctx the parse tree
	 */
	void enterBasicblockref(@NotNull LLVM_IRParser.BasicblockrefContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#basicblockref}.
	 * @param ctx the parse tree
	 */
	void exitBasicblockref(@NotNull LLVM_IRParser.BasicblockrefContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#functionheader}.
	 * @param ctx the parse tree
	 */
	void enterFunctionheader(@NotNull LLVM_IRParser.FunctionheaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#functionheader}.
	 * @param ctx the parse tree
	 */
	void exitFunctionheader(@NotNull LLVM_IRParser.FunctionheaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#localname}.
	 * @param ctx the parse tree
	 */
	void enterLocalname(@NotNull LLVM_IRParser.LocalnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#localname}.
	 * @param ctx the parse tree
	 */
	void exitLocalname(@NotNull LLVM_IRParser.LocalnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_fcmp}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_fcmp(@NotNull LLVM_IRParser.Instruction_fcmpContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_fcmp}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_fcmp(@NotNull LLVM_IRParser.Instruction_fcmpContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#constantexpression_insertvalue}.
	 * @param ctx the parse tree
	 */
	void enterConstantexpression_insertvalue(@NotNull LLVM_IRParser.Constantexpression_insertvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#constantexpression_insertvalue}.
	 * @param ctx the parse tree
	 */
	void exitConstantexpression_insertvalue(@NotNull LLVM_IRParser.Constantexpression_insertvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#nonleftrecursivetype}.
	 * @param ctx the parse tree
	 */
	void enterNonleftrecursivetype(@NotNull LLVM_IRParser.NonleftrecursivetypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#nonleftrecursivetype}.
	 * @param ctx the parse tree
	 */
	void exitNonleftrecursivetype(@NotNull LLVM_IRParser.NonleftrecursivetypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#blockaddress}.
	 * @param ctx the parse tree
	 */
	void enterBlockaddress(@NotNull LLVM_IRParser.BlockaddressContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#blockaddress}.
	 * @param ctx the parse tree
	 */
	void exitBlockaddress(@NotNull LLVM_IRParser.BlockaddressContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#ordering}.
	 * @param ctx the parse tree
	 */
	void enterOrdering(@NotNull LLVM_IRParser.OrderingContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#ordering}.
	 * @param ctx the parse tree
	 */
	void exitOrdering(@NotNull LLVM_IRParser.OrderingContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#metadatasuffix}.
	 * @param ctx the parse tree
	 */
	void enterMetadatasuffix(@NotNull LLVM_IRParser.MetadatasuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#metadatasuffix}.
	 * @param ctx the parse tree
	 */
	void exitMetadatasuffix(@NotNull LLVM_IRParser.MetadatasuffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#addressspace}.
	 * @param ctx the parse tree
	 */
	void enterAddressspace(@NotNull LLVM_IRParser.AddressspaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#addressspace}.
	 * @param ctx the parse tree
	 */
	void exitAddressspace(@NotNull LLVM_IRParser.AddressspaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#linkage}.
	 * @param ctx the parse tree
	 */
	void enterLinkage(@NotNull LLVM_IRParser.LinkageContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#linkage}.
	 * @param ctx the parse tree
	 */
	void exitLinkage(@NotNull LLVM_IRParser.LinkageContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#alignstack}.
	 * @param ctx the parse tree
	 */
	void enterAlignstack(@NotNull LLVM_IRParser.AlignstackContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#alignstack}.
	 * @param ctx the parse tree
	 */
	void exitAlignstack(@NotNull LLVM_IRParser.AlignstackContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#voidtype}.
	 * @param ctx the parse tree
	 */
	void enterVoidtype(@NotNull LLVM_IRParser.VoidtypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#voidtype}.
	 * @param ctx the parse tree
	 */
	void exitVoidtype(@NotNull LLVM_IRParser.VoidtypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#metadataidentifier}.
	 * @param ctx the parse tree
	 */
	void enterMetadataidentifier(@NotNull LLVM_IRParser.MetadataidentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#metadataidentifier}.
	 * @param ctx the parse tree
	 */
	void exitMetadataidentifier(@NotNull LLVM_IRParser.MetadataidentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#bitwisebinaryinstruction}.
	 * @param ctx the parse tree
	 */
	void enterBitwisebinaryinstruction(@NotNull LLVM_IRParser.BitwisebinaryinstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#bitwisebinaryinstruction}.
	 * @param ctx the parse tree
	 */
	void exitBitwisebinaryinstruction(@NotNull LLVM_IRParser.BitwisebinaryinstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#typedconstant}.
	 * @param ctx the parse tree
	 */
	void enterTypedconstant(@NotNull LLVM_IRParser.TypedconstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#typedconstant}.
	 * @param ctx the parse tree
	 */
	void exitTypedconstant(@NotNull LLVM_IRParser.TypedconstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#globalvariable}.
	 * @param ctx the parse tree
	 */
	void enterGlobalvariable(@NotNull LLVM_IRParser.GlobalvariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#globalvariable}.
	 * @param ctx the parse tree
	 */
	void exitGlobalvariable(@NotNull LLVM_IRParser.GlobalvariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#constantexpression_select}.
	 * @param ctx the parse tree
	 */
	void enterConstantexpression_select(@NotNull LLVM_IRParser.Constantexpression_selectContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#constantexpression_select}.
	 * @param ctx the parse tree
	 */
	void exitConstantexpression_select(@NotNull LLVM_IRParser.Constantexpression_selectContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#memoryinstruction}.
	 * @param ctx the parse tree
	 */
	void enterMemoryinstruction(@NotNull LLVM_IRParser.MemoryinstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#memoryinstruction}.
	 * @param ctx the parse tree
	 */
	void exitMemoryinstruction(@NotNull LLVM_IRParser.MemoryinstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#startinginstruction}.
	 * @param ctx the parse tree
	 */
	void enterStartinginstruction(@NotNull LLVM_IRParser.StartinginstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#startinginstruction}.
	 * @param ctx the parse tree
	 */
	void exitStartinginstruction(@NotNull LLVM_IRParser.StartinginstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#arglist}.
	 * @param ctx the parse tree
	 */
	void enterArglist(@NotNull LLVM_IRParser.ArglistContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#arglist}.
	 * @param ctx the parse tree
	 */
	void exitArglist(@NotNull LLVM_IRParser.ArglistContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#floatingtype}.
	 * @param ctx the parse tree
	 */
	void enterFloatingtype(@NotNull LLVM_IRParser.FloatingtypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#floatingtype}.
	 * @param ctx the parse tree
	 */
	void exitFloatingtype(@NotNull LLVM_IRParser.FloatingtypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#constantexpression}.
	 * @param ctx the parse tree
	 */
	void enterConstantexpression(@NotNull LLVM_IRParser.ConstantexpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#constantexpression}.
	 * @param ctx the parse tree
	 */
	void exitConstantexpression(@NotNull LLVM_IRParser.ConstantexpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#vectorconstant}.
	 * @param ctx the parse tree
	 */
	void enterVectorconstant(@NotNull LLVM_IRParser.VectorconstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#vectorconstant}.
	 * @param ctx the parse tree
	 */
	void exitVectorconstant(@NotNull LLVM_IRParser.VectorconstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_fsub}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_fsub(@NotNull LLVM_IRParser.Instruction_fsubContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_fsub}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_fsub(@NotNull LLVM_IRParser.Instruction_fsubContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#x86mmxtype}.
	 * @param ctx the parse tree
	 */
	void enterX86mmxtype(@NotNull LLVM_IRParser.X86mmxtypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#x86mmxtype}.
	 * @param ctx the parse tree
	 */
	void exitX86mmxtype(@NotNull LLVM_IRParser.X86mmxtypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#simpleconstant}.
	 * @param ctx the parse tree
	 */
	void enterSimpleconstant(@NotNull LLVM_IRParser.SimpleconstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#simpleconstant}.
	 * @param ctx the parse tree
	 */
	void exitSimpleconstant(@NotNull LLVM_IRParser.SimpleconstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#star}.
	 * @param ctx the parse tree
	 */
	void enterStar(@NotNull LLVM_IRParser.StarContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#star}.
	 * @param ctx the parse tree
	 */
	void exitStar(@NotNull LLVM_IRParser.StarContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#undef}.
	 * @param ctx the parse tree
	 */
	void enterUndef(@NotNull LLVM_IRParser.UndefContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#undef}.
	 * @param ctx the parse tree
	 */
	void exitUndef(@NotNull LLVM_IRParser.UndefContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_urem}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_urem(@NotNull LLVM_IRParser.Instruction_uremContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_urem}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_urem(@NotNull LLVM_IRParser.Instruction_uremContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#constantexpression_extractvalue}.
	 * @param ctx the parse tree
	 */
	void enterConstantexpression_extractvalue(@NotNull LLVM_IRParser.Constantexpression_extractvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#constantexpression_extractvalue}.
	 * @param ctx the parse tree
	 */
	void exitConstantexpression_extractvalue(@NotNull LLVM_IRParser.Constantexpression_extractvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#valueref}.
	 * @param ctx the parse tree
	 */
	void enterValueref(@NotNull LLVM_IRParser.ValuerefContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#valueref}.
	 * @param ctx the parse tree
	 */
	void exitValueref(@NotNull LLVM_IRParser.ValuerefContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#metadatanode}.
	 * @param ctx the parse tree
	 */
	void enterMetadatanode(@NotNull LLVM_IRParser.MetadatanodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#metadatanode}.
	 * @param ctx the parse tree
	 */
	void exitMetadatanode(@NotNull LLVM_IRParser.MetadatanodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_udiv}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_udiv(@NotNull LLVM_IRParser.Instruction_udivContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_udiv}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_udiv(@NotNull LLVM_IRParser.Instruction_udivContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_extractelement}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_extractelement(@NotNull LLVM_IRParser.Instruction_extractelementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_extractelement}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_extractelement(@NotNull LLVM_IRParser.Instruction_extractelementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#globalname}.
	 * @param ctx the parse tree
	 */
	void enterGlobalname(@NotNull LLVM_IRParser.GlobalnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#globalname}.
	 * @param ctx the parse tree
	 */
	void exitGlobalname(@NotNull LLVM_IRParser.GlobalnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(@NotNull LLVM_IRParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(@NotNull LLVM_IRParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_fence}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_fence(@NotNull LLVM_IRParser.Instruction_fenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_fence}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_fence(@NotNull LLVM_IRParser.Instruction_fenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_select}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_select(@NotNull LLVM_IRParser.Instruction_selectContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_select}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_select(@NotNull LLVM_IRParser.Instruction_selectContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_indirectbr}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_indirectbr(@NotNull LLVM_IRParser.Instruction_indirectbrContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_indirectbr}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_indirectbr(@NotNull LLVM_IRParser.Instruction_indirectbrContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_shufflevector}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_shufflevector(@NotNull LLVM_IRParser.Instruction_shufflevectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_shufflevector}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_shufflevector(@NotNull LLVM_IRParser.Instruction_shufflevectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#metadatanodeelement}.
	 * @param ctx the parse tree
	 */
	void enterMetadatanodeelement(@NotNull LLVM_IRParser.MetadatanodeelementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#metadatanodeelement}.
	 * @param ctx the parse tree
	 */
	void exitMetadatanodeelement(@NotNull LLVM_IRParser.MetadatanodeelementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_insertvalue}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_insertvalue(@NotNull LLVM_IRParser.Instruction_insertvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_insertvalue}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_insertvalue(@NotNull LLVM_IRParser.Instruction_insertvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_cmpxchg}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_cmpxchg(@NotNull LLVM_IRParser.Instruction_cmpxchgContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_cmpxchg}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_cmpxchg(@NotNull LLVM_IRParser.Instruction_cmpxchgContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(@NotNull LLVM_IRParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(@NotNull LLVM_IRParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(@NotNull LLVM_IRParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(@NotNull LLVM_IRParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_landingpad}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_landingpad(@NotNull LLVM_IRParser.Instruction_landingpadContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_landingpad}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_landingpad(@NotNull LLVM_IRParser.Instruction_landingpadContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#nonleftrecursivenonvoidtype}.
	 * @param ctx the parse tree
	 */
	void enterNonleftrecursivenonvoidtype(@NotNull LLVM_IRParser.NonleftrecursivenonvoidtypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#nonleftrecursivenonvoidtype}.
	 * @param ctx the parse tree
	 */
	void exitNonleftrecursivenonvoidtype(@NotNull LLVM_IRParser.NonleftrecursivenonvoidtypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#structtype}.
	 * @param ctx the parse tree
	 */
	void enterStructtype(@NotNull LLVM_IRParser.StructtypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#structtype}.
	 * @param ctx the parse tree
	 */
	void exitStructtype(@NotNull LLVM_IRParser.StructtypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#localvalueref}.
	 * @param ctx the parse tree
	 */
	void enterLocalvalueref(@NotNull LLVM_IRParser.LocalvaluerefContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#localvalueref}.
	 * @param ctx the parse tree
	 */
	void exitLocalvalueref(@NotNull LLVM_IRParser.LocalvaluerefContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#constantexpression_getelementptr}.
	 * @param ctx the parse tree
	 */
	void enterConstantexpression_getelementptr(@NotNull LLVM_IRParser.Constantexpression_getelementptrContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#constantexpression_getelementptr}.
	 * @param ctx the parse tree
	 */
	void exitConstantexpression_getelementptr(@NotNull LLVM_IRParser.Constantexpression_getelementptrContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#section}.
	 * @param ctx the parse tree
	 */
	void enterSection(@NotNull LLVM_IRParser.SectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#section}.
	 * @param ctx the parse tree
	 */
	void exitSection(@NotNull LLVM_IRParser.SectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_xor}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_xor(@NotNull LLVM_IRParser.Instruction_xorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_xor}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_xor(@NotNull LLVM_IRParser.Instruction_xorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#align}.
	 * @param ctx the parse tree
	 */
	void enterAlign(@NotNull LLVM_IRParser.AlignContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#align}.
	 * @param ctx the parse tree
	 */
	void exitAlign(@NotNull LLVM_IRParser.AlignContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#aliasee}.
	 * @param ctx the parse tree
	 */
	void enterAliasee(@NotNull LLVM_IRParser.AliaseeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#aliasee}.
	 * @param ctx the parse tree
	 */
	void exitAliasee(@NotNull LLVM_IRParser.AliaseeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#parameterattribute}.
	 * @param ctx the parse tree
	 */
	void enterParameterattribute(@NotNull LLVM_IRParser.ParameterattributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#parameterattribute}.
	 * @param ctx the parse tree
	 */
	void exitParameterattribute(@NotNull LLVM_IRParser.ParameterattributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_load}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_load(@NotNull LLVM_IRParser.Instruction_loadContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_load}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_load(@NotNull LLVM_IRParser.Instruction_loadContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#targetspecificattribute}.
	 * @param ctx the parse tree
	 */
	void enterTargetspecificattribute(@NotNull LLVM_IRParser.TargetspecificattributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#targetspecificattribute}.
	 * @param ctx the parse tree
	 */
	void exitTargetspecificattribute(@NotNull LLVM_IRParser.TargetspecificattributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#tlsmodel}.
	 * @param ctx the parse tree
	 */
	void enterTlsmodel(@NotNull LLVM_IRParser.TlsmodelContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#tlsmodel}.
	 * @param ctx the parse tree
	 */
	void exitTlsmodel(@NotNull LLVM_IRParser.TlsmodelContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(@NotNull LLVM_IRParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(@NotNull LLVM_IRParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#binaryinstruction}.
	 * @param ctx the parse tree
	 */
	void enterBinaryinstruction(@NotNull LLVM_IRParser.BinaryinstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#binaryinstruction}.
	 * @param ctx the parse tree
	 */
	void exitBinaryinstruction(@NotNull LLVM_IRParser.BinaryinstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_lshr}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_lshr(@NotNull LLVM_IRParser.Instruction_lshrContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_lshr}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_lshr(@NotNull LLVM_IRParser.Instruction_lshrContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#landingpadclause}.
	 * @param ctx the parse tree
	 */
	void enterLandingpadclause(@NotNull LLVM_IRParser.LandingpadclauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#landingpadclause}.
	 * @param ctx the parse tree
	 */
	void exitLandingpadclause(@NotNull LLVM_IRParser.LandingpadclauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#nonvoidtype}.
	 * @param ctx the parse tree
	 */
	void enterNonvoidtype(@NotNull LLVM_IRParser.NonvoidtypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#nonvoidtype}.
	 * @param ctx the parse tree
	 */
	void exitNonvoidtype(@NotNull LLVM_IRParser.NonvoidtypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#globalvalueref}.
	 * @param ctx the parse tree
	 */
	void enterGlobalvalueref(@NotNull LLVM_IRParser.GlobalvaluerefContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#globalvalueref}.
	 * @param ctx the parse tree
	 */
	void exitGlobalvalueref(@NotNull LLVM_IRParser.GlobalvaluerefContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#namedmiddleinstruction}.
	 * @param ctx the parse tree
	 */
	void enterNamedmiddleinstruction(@NotNull LLVM_IRParser.NamedmiddleinstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#namedmiddleinstruction}.
	 * @param ctx the parse tree
	 */
	void exitNamedmiddleinstruction(@NotNull LLVM_IRParser.NamedmiddleinstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_or}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_or(@NotNull LLVM_IRParser.Instruction_orContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_or}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_or(@NotNull LLVM_IRParser.Instruction_orContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#binaryopcode}.
	 * @param ctx the parse tree
	 */
	void enterBinaryopcode(@NotNull LLVM_IRParser.BinaryopcodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#binaryopcode}.
	 * @param ctx the parse tree
	 */
	void exitBinaryopcode(@NotNull LLVM_IRParser.BinaryopcodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_unreachable}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_unreachable(@NotNull LLVM_IRParser.Instruction_unreachableContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_unreachable}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_unreachable(@NotNull LLVM_IRParser.Instruction_unreachableContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#typedef}.
	 * @param ctx the parse tree
	 */
	void enterTypedef(@NotNull LLVM_IRParser.TypedefContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#typedef}.
	 * @param ctx the parse tree
	 */
	void exitTypedef(@NotNull LLVM_IRParser.TypedefContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_sub}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_sub(@NotNull LLVM_IRParser.Instruction_subContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_sub}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_sub(@NotNull LLVM_IRParser.Instruction_subContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#basicblockname}.
	 * @param ctx the parse tree
	 */
	void enterBasicblockname(@NotNull LLVM_IRParser.BasicblocknameContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#basicblockname}.
	 * @param ctx the parse tree
	 */
	void exitBasicblockname(@NotNull LLVM_IRParser.BasicblocknameContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#targetinfo}.
	 * @param ctx the parse tree
	 */
	void enterTargetinfo(@NotNull LLVM_IRParser.TargetinfoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#targetinfo}.
	 * @param ctx the parse tree
	 */
	void exitTargetinfo(@NotNull LLVM_IRParser.TargetinfoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#cconv}.
	 * @param ctx the parse tree
	 */
	void enterCconv(@NotNull LLVM_IRParser.CconvContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#cconv}.
	 * @param ctx the parse tree
	 */
	void exitCconv(@NotNull LLVM_IRParser.CconvContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#namedmetadata}.
	 * @param ctx the parse tree
	 */
	void enterNamedmetadata(@NotNull LLVM_IRParser.NamedmetadataContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#namedmetadata}.
	 * @param ctx the parse tree
	 */
	void exitNamedmetadata(@NotNull LLVM_IRParser.NamedmetadataContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#metadataref}.
	 * @param ctx the parse tree
	 */
	void enterMetadataref(@NotNull LLVM_IRParser.MetadatarefContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#metadataref}.
	 * @param ctx the parse tree
	 */
	void exitMetadataref(@NotNull LLVM_IRParser.MetadatarefContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#fastmathflag}.
	 * @param ctx the parse tree
	 */
	void enterFastmathflag(@NotNull LLVM_IRParser.FastmathflagContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#fastmathflag}.
	 * @param ctx the parse tree
	 */
	void exitFastmathflag(@NotNull LLVM_IRParser.FastmathflagContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#constantexpression_compare}.
	 * @param ctx the parse tree
	 */
	void enterConstantexpression_compare(@NotNull LLVM_IRParser.Constantexpression_compareContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#constantexpression_compare}.
	 * @param ctx the parse tree
	 */
	void exitConstantexpression_compare(@NotNull LLVM_IRParser.Constantexpression_compareContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#globalvalue}.
	 * @param ctx the parse tree
	 */
	void enterGlobalvalue(@NotNull LLVM_IRParser.GlobalvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#globalvalue}.
	 * @param ctx the parse tree
	 */
	void exitGlobalvalue(@NotNull LLVM_IRParser.GlobalvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(@NotNull LLVM_IRParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(@NotNull LLVM_IRParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_switch}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_switch(@NotNull LLVM_IRParser.Instruction_switchContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_switch}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_switch(@NotNull LLVM_IRParser.Instruction_switchContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_ashr}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_ashr(@NotNull LLVM_IRParser.Instruction_ashrContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_ashr}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_ashr(@NotNull LLVM_IRParser.Instruction_ashrContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_atomicrmw}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_atomicrmw(@NotNull LLVM_IRParser.Instruction_atomicrmwContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_atomicrmw}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_atomicrmw(@NotNull LLVM_IRParser.Instruction_atomicrmwContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#terminatorinstruction}.
	 * @param ctx the parse tree
	 */
	void enterTerminatorinstruction(@NotNull LLVM_IRParser.TerminatorinstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#terminatorinstruction}.
	 * @param ctx the parse tree
	 */
	void exitTerminatorinstruction(@NotNull LLVM_IRParser.TerminatorinstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#zeroinitializer}.
	 * @param ctx the parse tree
	 */
	void enterZeroinitializer(@NotNull LLVM_IRParser.ZeroinitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#zeroinitializer}.
	 * @param ctx the parse tree
	 */
	void exitZeroinitializer(@NotNull LLVM_IRParser.ZeroinitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_ret}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_ret(@NotNull LLVM_IRParser.Instruction_retContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_ret}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_ret(@NotNull LLVM_IRParser.Instruction_retContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_add}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_add(@NotNull LLVM_IRParser.Instruction_addContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_add}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_add(@NotNull LLVM_IRParser.Instruction_addContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#inlineassembler}.
	 * @param ctx the parse tree
	 */
	void enterInlineassembler(@NotNull LLVM_IRParser.InlineassemblerContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#inlineassembler}.
	 * @param ctx the parse tree
	 */
	void exitInlineassembler(@NotNull LLVM_IRParser.InlineassemblerContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#convertionopcode}.
	 * @param ctx the parse tree
	 */
	void enterConvertionopcode(@NotNull LLVM_IRParser.ConvertionopcodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#convertionopcode}.
	 * @param ctx the parse tree
	 */
	void exitConvertionopcode(@NotNull LLVM_IRParser.ConvertionopcodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#vectortype}.
	 * @param ctx the parse tree
	 */
	void enterVectortype(@NotNull LLVM_IRParser.VectortypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#vectortype}.
	 * @param ctx the parse tree
	 */
	void exitVectortype(@NotNull LLVM_IRParser.VectortypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#functiondef}.
	 * @param ctx the parse tree
	 */
	void enterFunctiondef(@NotNull LLVM_IRParser.FunctiondefContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#functiondef}.
	 * @param ctx the parse tree
	 */
	void exitFunctiondef(@NotNull LLVM_IRParser.FunctiondefContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#vectorinstructions}.
	 * @param ctx the parse tree
	 */
	void enterVectorinstructions(@NotNull LLVM_IRParser.VectorinstructionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#vectorinstructions}.
	 * @param ctx the parse tree
	 */
	void exitVectorinstructions(@NotNull LLVM_IRParser.VectorinstructionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(@NotNull LLVM_IRParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(@NotNull LLVM_IRParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#alias}.
	 * @param ctx the parse tree
	 */
	void enterAlias(@NotNull LLVM_IRParser.AliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#alias}.
	 * @param ctx the parse tree
	 */
	void exitAlias(@NotNull LLVM_IRParser.AliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_fmul}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_fmul(@NotNull LLVM_IRParser.Instruction_fmulContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_fmul}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_fmul(@NotNull LLVM_IRParser.Instruction_fmulContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#gc}.
	 * @param ctx the parse tree
	 */
	void enterGc(@NotNull LLVM_IRParser.GcContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#gc}.
	 * @param ctx the parse tree
	 */
	void exitGc(@NotNull LLVM_IRParser.GcContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#typesuffix}.
	 * @param ctx the parse tree
	 */
	void enterTypesuffix(@NotNull LLVM_IRParser.TypesuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#typesuffix}.
	 * @param ctx the parse tree
	 */
	void exitTypesuffix(@NotNull LLVM_IRParser.TypesuffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#conversioninstruction}.
	 * @param ctx the parse tree
	 */
	void enterConversioninstruction(@NotNull LLVM_IRParser.ConversioninstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#conversioninstruction}.
	 * @param ctx the parse tree
	 */
	void exitConversioninstruction(@NotNull LLVM_IRParser.ConversioninstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#constantexpression_convert}.
	 * @param ctx the parse tree
	 */
	void enterConstantexpression_convert(@NotNull LLVM_IRParser.Constantexpression_convertContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#constantexpression_convert}.
	 * @param ctx the parse tree
	 */
	void exitConstantexpression_convert(@NotNull LLVM_IRParser.Constantexpression_convertContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_phi}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_phi(@NotNull LLVM_IRParser.Instruction_phiContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_phi}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_phi(@NotNull LLVM_IRParser.Instruction_phiContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_call_void}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_call_void(@NotNull LLVM_IRParser.Instruction_call_voidContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_call_void}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_call_void(@NotNull LLVM_IRParser.Instruction_call_voidContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#parameterattributes}.
	 * @param ctx the parse tree
	 */
	void enterParameterattributes(@NotNull LLVM_IRParser.ParameterattributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#parameterattributes}.
	 * @param ctx the parse tree
	 */
	void exitParameterattributes(@NotNull LLVM_IRParser.ParameterattributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#attributegroup}.
	 * @param ctx the parse tree
	 */
	void enterAttributegroup(@NotNull LLVM_IRParser.AttributegroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#attributegroup}.
	 * @param ctx the parse tree
	 */
	void exitAttributegroup(@NotNull LLVM_IRParser.AttributegroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#functionattribute}.
	 * @param ctx the parse tree
	 */
	void enterFunctionattribute(@NotNull LLVM_IRParser.FunctionattributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#functionattribute}.
	 * @param ctx the parse tree
	 */
	void exitFunctionattribute(@NotNull LLVM_IRParser.FunctionattributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#icmpcondition}.
	 * @param ctx the parse tree
	 */
	void enterIcmpcondition(@NotNull LLVM_IRParser.IcmpconditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#icmpcondition}.
	 * @param ctx the parse tree
	 */
	void exitIcmpcondition(@NotNull LLVM_IRParser.IcmpconditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_getelementptr}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_getelementptr(@NotNull LLVM_IRParser.Instruction_getelementptrContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_getelementptr}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_getelementptr(@NotNull LLVM_IRParser.Instruction_getelementptrContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#functionprefix}.
	 * @param ctx the parse tree
	 */
	void enterFunctionprefix(@NotNull LLVM_IRParser.FunctionprefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#functionprefix}.
	 * @param ctx the parse tree
	 */
	void exitFunctionprefix(@NotNull LLVM_IRParser.FunctionprefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#fcmpcondition}.
	 * @param ctx the parse tree
	 */
	void enterFcmpcondition(@NotNull LLVM_IRParser.FcmpconditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#fcmpcondition}.
	 * @param ctx the parse tree
	 */
	void exitFcmpcondition(@NotNull LLVM_IRParser.FcmpconditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_invoke_void}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_invoke_void(@NotNull LLVM_IRParser.Instruction_invoke_voidContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_invoke_void}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_invoke_void(@NotNull LLVM_IRParser.Instruction_invoke_voidContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#constantexpression_extractelement}.
	 * @param ctx the parse tree
	 */
	void enterConstantexpression_extractelement(@NotNull LLVM_IRParser.Constantexpression_extractelementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#constantexpression_extractelement}.
	 * @param ctx the parse tree
	 */
	void exitConstantexpression_extractelement(@NotNull LLVM_IRParser.Constantexpression_extractelementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#aggregateinstruction}.
	 * @param ctx the parse tree
	 */
	void enterAggregateinstruction(@NotNull LLVM_IRParser.AggregateinstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#aggregateinstruction}.
	 * @param ctx the parse tree
	 */
	void exitAggregateinstruction(@NotNull LLVM_IRParser.AggregateinstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#atomicrmw_operation}.
	 * @param ctx the parse tree
	 */
	void enterAtomicrmw_operation(@NotNull LLVM_IRParser.Atomicrmw_operationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#atomicrmw_operation}.
	 * @param ctx the parse tree
	 */
	void exitAtomicrmw_operation(@NotNull LLVM_IRParser.Atomicrmw_operationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_frem}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_frem(@NotNull LLVM_IRParser.Instruction_fremContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_frem}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_frem(@NotNull LLVM_IRParser.Instruction_fremContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#constantexpression_shufflevector}.
	 * @param ctx the parse tree
	 */
	void enterConstantexpression_shufflevector(@NotNull LLVM_IRParser.Constantexpression_shufflevectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#constantexpression_shufflevector}.
	 * @param ctx the parse tree
	 */
	void exitConstantexpression_shufflevector(@NotNull LLVM_IRParser.Constantexpression_shufflevectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#functiondecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctiondecl(@NotNull LLVM_IRParser.FunctiondeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#functiondecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctiondecl(@NotNull LLVM_IRParser.FunctiondeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_resume}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_resume(@NotNull LLVM_IRParser.Instruction_resumeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_resume}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_resume(@NotNull LLVM_IRParser.Instruction_resumeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#otherinstruction}.
	 * @param ctx the parse tree
	 */
	void enterOtherinstruction(@NotNull LLVM_IRParser.OtherinstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#otherinstruction}.
	 * @param ctx the parse tree
	 */
	void exitOtherinstruction(@NotNull LLVM_IRParser.OtherinstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_fadd}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_fadd(@NotNull LLVM_IRParser.Instruction_faddContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_fadd}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_fadd(@NotNull LLVM_IRParser.Instruction_faddContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#constantlist}.
	 * @param ctx the parse tree
	 */
	void enterConstantlist(@NotNull LLVM_IRParser.ConstantlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#constantlist}.
	 * @param ctx the parse tree
	 */
	void exitConstantlist(@NotNull LLVM_IRParser.ConstantlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_alloca}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_alloca(@NotNull LLVM_IRParser.Instruction_allocaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_alloca}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_alloca(@NotNull LLVM_IRParser.Instruction_allocaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#namedinstruction}.
	 * @param ctx the parse tree
	 */
	void enterNamedinstruction(@NotNull LLVM_IRParser.NamedinstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#namedinstruction}.
	 * @param ctx the parse tree
	 */
	void exitNamedinstruction(@NotNull LLVM_IRParser.NamedinstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_call_nonvoid}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_call_nonvoid(@NotNull LLVM_IRParser.Instruction_call_nonvoidContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_call_nonvoid}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_call_nonvoid(@NotNull LLVM_IRParser.Instruction_call_nonvoidContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#opaquetype}.
	 * @param ctx the parse tree
	 */
	void enterOpaquetype(@NotNull LLVM_IRParser.OpaquetypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#opaquetype}.
	 * @param ctx the parse tree
	 */
	void exitOpaquetype(@NotNull LLVM_IRParser.OpaquetypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#instruction_invoke_nonvoid}.
	 * @param ctx the parse tree
	 */
	void enterInstruction_invoke_nonvoid(@NotNull LLVM_IRParser.Instruction_invoke_nonvoidContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#instruction_invoke_nonvoid}.
	 * @param ctx the parse tree
	 */
	void exitInstruction_invoke_nonvoid(@NotNull LLVM_IRParser.Instruction_invoke_nonvoidContext ctx);
	/**
	 * Enter a parse tree produced by {@link LLVM_IRParser#metadatastring}.
	 * @param ctx the parse tree
	 */
	void enterMetadatastring(@NotNull LLVM_IRParser.MetadatastringContext ctx);
	/**
	 * Exit a parse tree produced by {@link LLVM_IRParser#metadatastring}.
	 * @param ctx the parse tree
	 */
	void exitMetadatastring(@NotNull LLVM_IRParser.MetadatastringContext ctx);
}