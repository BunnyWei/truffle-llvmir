// Generated from graal/com.oracle.truffle.llvm/src/com/oracle/truffle/llvm/parser/LLVM_IR.g4 by ANTLR 4.4

package com.oracle.truffle.llvm.parser;

import com.oracle.truffle.llvm.parser.*;
import com.oracle.truffle.llvm.nodes.*;
import com.oracle.truffle.api.source.*;
import com.oracle.truffle.llvm.runtime.*;
import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

//@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LLVM_IRParser extends Parser {
    static {
        RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
    public static final int T__239 = 1, T__238 = 2, T__237 = 3, T__236 = 4, T__235 = 5, T__234 = 6, T__233 = 7, T__232 = 8, T__231 = 9, T__230 = 10, T__229 = 11, T__228 = 12, T__227 = 13,
                    T__226 = 14, T__225 = 15, T__224 = 16, T__223 = 17, T__222 = 18, T__221 = 19, T__220 = 20, T__219 = 21, T__218 = 22, T__217 = 23, T__216 = 24, T__215 = 25, T__214 = 26,
                    T__213 = 27, T__212 = 28, T__211 = 29, T__210 = 30, T__209 = 31, T__208 = 32, T__207 = 33, T__206 = 34, T__205 = 35, T__204 = 36, T__203 = 37, T__202 = 38, T__201 = 39,
                    T__200 = 40, T__199 = 41, T__198 = 42, T__197 = 43, T__196 = 44, T__195 = 45, T__194 = 46, T__193 = 47, T__192 = 48, T__191 = 49, T__190 = 50, T__189 = 51, T__188 = 52,
                    T__187 = 53, T__186 = 54, T__185 = 55, T__184 = 56, T__183 = 57, T__182 = 58, T__181 = 59, T__180 = 60, T__179 = 61, T__178 = 62, T__177 = 63, T__176 = 64, T__175 = 65,
                    T__174 = 66, T__173 = 67, T__172 = 68, T__171 = 69, T__170 = 70, T__169 = 71, T__168 = 72, T__167 = 73, T__166 = 74, T__165 = 75, T__164 = 76, T__163 = 77, T__162 = 78,
                    T__161 = 79, T__160 = 80, T__159 = 81, T__158 = 82, T__157 = 83, T__156 = 84, T__155 = 85, T__154 = 86, T__153 = 87, T__152 = 88, T__151 = 89, T__150 = 90, T__149 = 91,
                    T__148 = 92, T__147 = 93, T__146 = 94, T__145 = 95, T__144 = 96, T__143 = 97, T__142 = 98, T__141 = 99, T__140 = 100, T__139 = 101, T__138 = 102, T__137 = 103, T__136 = 104,
                    T__135 = 105, T__134 = 106, T__133 = 107, T__132 = 108, T__131 = 109, T__130 = 110, T__129 = 111, T__128 = 112, T__127 = 113, T__126 = 114, T__125 = 115, T__124 = 116,
                    T__123 = 117, T__122 = 118, T__121 = 119, T__120 = 120, T__119 = 121, T__118 = 122, T__117 = 123, T__116 = 124, T__115 = 125, T__114 = 126, T__113 = 127, T__112 = 128,
                    T__111 = 129, T__110 = 130, T__109 = 131, T__108 = 132, T__107 = 133, T__106 = 134, T__105 = 135, T__104 = 136, T__103 = 137, T__102 = 138, T__101 = 139, T__100 = 140,
                    T__99 = 141, T__98 = 142, T__97 = 143, T__96 = 144, T__95 = 145, T__94 = 146, T__93 = 147, T__92 = 148, T__91 = 149, T__90 = 150, T__89 = 151, T__88 = 152, T__87 = 153,
                    T__86 = 154, T__85 = 155, T__84 = 156, T__83 = 157, T__82 = 158, T__81 = 159, T__80 = 160, T__79 = 161, T__78 = 162, T__77 = 163, T__76 = 164, T__75 = 165, T__74 = 166,
                    T__73 = 167, T__72 = 168, T__71 = 169, T__70 = 170, T__69 = 171, T__68 = 172, T__67 = 173, T__66 = 174, T__65 = 175, T__64 = 176, T__63 = 177, T__62 = 178, T__61 = 179,
                    T__60 = 180, T__59 = 181, T__58 = 182, T__57 = 183, T__56 = 184, T__55 = 185, T__54 = 186, T__53 = 187, T__52 = 188, T__51 = 189, T__50 = 190, T__49 = 191, T__48 = 192,
                    T__47 = 193, T__46 = 194, T__45 = 195, T__44 = 196, T__43 = 197, T__42 = 198, T__41 = 199, T__40 = 200, T__39 = 201, T__38 = 202, T__37 = 203, T__36 = 204, T__35 = 205,
                    T__34 = 206, T__33 = 207, T__32 = 208, T__31 = 209, T__30 = 210, T__29 = 211, T__28 = 212, T__27 = 213, T__26 = 214, T__25 = 215, T__24 = 216, T__23 = 217, T__22 = 218,
                    T__21 = 219, T__20 = 220, T__19 = 221, T__18 = 222, T__17 = 223, T__16 = 224, T__15 = 225, T__14 = 226, T__13 = 227, T__12 = 228, T__11 = 229, T__10 = 230, T__9 = 231, T__8 = 232,
                    T__7 = 233, T__6 = 234, T__5 = 235, T__4 = 236, T__3 = 237, T__2 = 238, T__1 = 239, T__0 = 240, Visibility = 241, Boolean = 242, Null = 243, Int_type = 244, Global_id = 245,
                    Local_id = 246, Basic_block_id = 247, Meta_int = 248, Meta_name = 249, Attribute_id = 250, Integer = 251, Signed_int = 252, Name = 253, Cstring = 254, String = 255,
                    Metadata_string = 256, Float = 257, Comment = 258, WS = 259, Any_other = 260, Floatingtype = 261;
    public static final String[] tokenNames = {"<INVALID>", "'ole'", "'!nontemporal'", "'filter'", "'sdiv'", "'='", "'call'", "'x86_fastcallcc'", "'ult'", "'nonlazybind'", "'linker_private_weak'",
                    "'internal'", "'extractelement'", "'available_externally'", "'fsub'", "'nsw'", "'insertvalue'", "'section'", "','", "'ppc_fp128'", "'asm'", "'fast'", "'arcp'", "'ne'", "'exact'",
                    "'sitofp'", "'inlinehint'", "'getelementptr'", "'opaque'", "'<'", "'mul'", "'x86_fp80'", "']'", "'byval'", "'cold'", "'urem'", "'va_arg'", "'sret'", "'nest'", "'optnone'",
                    "'coldcc'", "'ule'", "'landingpad'", "'release'", "'personality'", "'max'", "'}'", "'ptx_kernel'", "'arm_aapcs_vfpcc'", "'cmpxchg'", "'fpext'", "'store'", "'dllexport'",
                    "'triple'", "'shufflevector'", "'*'", "'bitcast'", "'anyregcc'", "'atomic'", "'fptoui'", "'external'", "'to'", "'['", "'select'", "'linker_private'", "'preserve_mostcc'",
                    "'acq_rel'", "'xor'", "'spir_func'", "'signext'", "')'", "'and'", "'sanitize_address'", "'prefix'", "'ccc'", "'inalloca'", "'noreturn'", "'x86_stdcallcc'", "'private'",
                    "'initialexec'", "'sle'", "'noduplicate'", "'float'", "'x86_mmx'", "'unnamed_addr'", "'umin'", "'{'", "'one'", "'x86_64_win64cc'", "'eq'", "'nuw'", "'('", "'extern_weak'",
                    "'declare'", "'trunc'", "'volatile'", "'appending'", "'gc'", "'noalias'", "'ueq'", "'type'", "'indirectbr'", "'uge'", "'module'", "'intel_ocl_bicc'", "'icmp'", "'une'", "'ashr'",
                    "'noimplicitFloat'", "'unordered'", "'preserve_allcc'", "'undef'", "'inbounds'", "'target'", "'atomicrmw'", "'spir_kernel'", "'alloca'", "'olt'", "'double'", "'resume'",
                    "'sspstrong'", "'phi'", "'metadata'", "'fptrunc'", "'xchg'", "'sanitize_thread'", "'inreg'", "'thread_safety'", "'lshr'", "'fptosi'", "'fcmp'", "'linker_private_weak_def_auto'",
                    "'dllimport'", "'x'", "'fadd'", "'or'", "'tail'", "'unreachable'", "'fdiv'", "'singlethread'", "'fastcc'", "'linkonce'", "'half'", "'srem'", "'ogt'", "'unwind'", "'ssp'", "'min'",
                    "'zeroinitializer'", "'fp128'", "'fmul'", "'datalayout'", "'nnan'", "'optsize'", "'sideeffect'", "'ptrtoint'", "'sub'", "'nocapture'", "'address_safety'", "'udiv'", "'uno'",
                    "'inttoptr'", "'ninf'", "'attributes'", "'ptx_device'", "'monotonic'", "'insertelement'", "'oge'", "'constant'", "'weak_odr'", "'alwaysinline'", "'inteldialect'", "'uwtable'",
                    "'ugt'", "'cleanup'", "'shl'", "'zext'", "'slt'", "'switch'", "'builtin'", "'weak'", "'define'", "'zeroext'", "'sanitize_memory'", "'noredzone'", "'!'", "'invoke'", "'oeq'",
                    "'load'", "'extractvalue'", "'label'", "'sgt'", "'!invariant.load'", "'void'", "'x86_thiscallcc'", "'readnone'", "'localexec'", "'readonly'", "'uitofp'", "'x86_64_sysvcc'",
                    "'common'", "'naked'", "'mov'", "'uninitialized_checks'", "'nobuiltin'", "'webkit_jscc'", "'global'", "'msp430_intrcc'", "'ord'", "'cc'", "'alignstack'", "'sext'", "'br'",
                    "'umax'", "'nsz'", "'addrspacecast'", "'arm_apcscc'", "'catch'", "'frem'", "'localdynamic'", "'arm_aapcscc'", "'returns_twice'", "'linkonce_odr'", "'thread_local'", "'nand'",
                    "'add'", "'...'", "'fence'", "'nounwind'", "'ret'", "'align'", "'blockaddress'", "'>'", "'addrspace'", "'seq_cst'", "'noinline'", "'sge'", "'returned'", "'acquire'", "'sspreq'",
                    "'alias'", "Visibility", "Boolean", "'null'", "Int_type", "Global_id", "Local_id", "Basic_block_id", "Meta_int", "Meta_name", "Attribute_id", "Integer", "Signed_int", "Name",
                    "Cstring", "String", "Metadata_string", "Float", "Comment", "WS", "Any_other", "Floatingtype"};
    public static final int RULE_model = 0, RULE_toplevelelement = 1, RULE_attributegroup = 2, RULE_targetspecificattribute = 3, RULE_namedmetadata = 4, RULE_metadataref = 5,
                    RULE_metadataidentifier = 6, RULE_valueref = 7, RULE_globalvalueref = 8, RULE_localvalueref = 9, RULE_globalvalue = 10, RULE_globalvaluedef = 11, RULE_localvalue = 12,
                    RULE_namedinstruction = 13, RULE_instruction = 14, RULE_alias = 15, RULE_aliasee = 16, RULE_targetinfo = 17, RULE_inlineasm = 18, RULE_globalvariable = 19, RULE_constant = 20,
                    RULE_constantexpression = 21, RULE_constantexpression_convert = 22, RULE_constantexpression_getelementptr = 23, RULE_constantexpression_select = 24,
                    RULE_constantexpression_compare = 25, RULE_constantexpression_extractelement = 26, RULE_constantexpression_insertelement = 27, RULE_constantexpression_shufflevector = 28,
                    RULE_constantexpression_extractvalue = 29, RULE_constantexpression_insertvalue = 30, RULE_constantexpression_binary = 31, RULE_undef = 32, RULE_blockaddress = 33,
                    RULE_zeroinitializer = 34, RULE_structureconstant = 35, RULE_arrayconstant = 36, RULE_vectorconstant = 37, RULE_constantlist = 38, RULE_typedconstant = 39,
                    RULE_simpleconstant = 40, RULE_metadatanode = 41, RULE_metadatanodeelement = 42, RULE_metadatastring = 43, RULE_tlsmodel = 44, RULE_tlsoption = 45, RULE_addressspace = 46,
                    RULE_section = 47, RULE_align = 48, RULE_gc = 49, RULE_function = 50, RULE_functiondef = 51, RULE_functiondecl = 52, RULE_functionheader = 53, RULE_functionprefix = 54,
                    RULE_parameters = 55, RULE_functionattributes = 56, RULE_alignstack = 57, RULE_functionattribute = 58, RULE_basicblock = 59, RULE_basicblockname = 60, RULE_metadatasuffix = 61,
                    RULE_startinginstruction = 62, RULE_middleinstruction = 63, RULE_namedmiddleinstruction = 64, RULE_paramname = 65, RULE_localname = 66, RULE_globalname = 67,
                    RULE_terminatorinstruction = 68, RULE_namedterminatorinstruction = 69, RULE_instruction_ret = 70, RULE_instruction_br = 71, RULE_instruction_switch = 72,
                    RULE_instruction_indirectbr = 73, RULE_instruction_invoke_void = 74, RULE_instruction_invoke_nonvoid = 75, RULE_instruction_resume = 76, RULE_instruction_unreachable = 77,
                    RULE_basicblockref = 78, RULE_binaryinstruction = 79, RULE_instruction_add = 80, RULE_instruction_fadd = 81, RULE_fastmathflag = 82, RULE_instruction_sub = 83,
                    RULE_instruction_fsub = 84, RULE_instruction_mul = 85, RULE_instruction_fmul = 86, RULE_instruction_udiv = 87, RULE_instruction_sdiv = 88, RULE_instruction_fdiv = 89,
                    RULE_instruction_urem = 90, RULE_instruction_srem = 91, RULE_instruction_frem = 92, RULE_bitwisebinaryinstruction = 93, RULE_instruction_shl = 94, RULE_instruction_lshr = 95,
                    RULE_instruction_ashr = 96, RULE_instruction_and = 97, RULE_instruction_or = 98, RULE_instruction_xor = 99, RULE_vectorinstructions = 100, RULE_instruction_extractelement = 101,
                    RULE_instruction_insertelement = 102, RULE_instruction_shufflevector = 103, RULE_aggregateinstruction = 104, RULE_instruction_extractvalue = 105,
                    RULE_instruction_insertvalue = 106, RULE_memoryinstruction = 107, RULE_instruction_alloca = 108, RULE_instruction_load = 109, RULE_instruction_store = 110,
                    RULE_instruction_fence = 111, RULE_instruction_cmpxchg = 112, RULE_instruction_atomicrmw = 113, RULE_atomicrmw_operation = 114, RULE_instruction_getelementptr = 115,
                    RULE_conversioninstruction = 116, RULE_convertionopcode = 117, RULE_otherinstruction = 118, RULE_instruction_icmp = 119, RULE_icmpcondition = 120, RULE_instruction_fcmp = 121,
                    RULE_fcmpcondition = 122, RULE_instruction_phi = 123, RULE_instruction_select = 124, RULE_instruction_call_nonvoid = 125, RULE_instruction_call_void = 126, RULE_arglist = 127,
                    RULE_callee = 128, RULE_inlineassembler = 129, RULE_instruction_va_arg = 130, RULE_instruction_landingpad = 131, RULE_landingpadclause = 132, RULE_ordering = 133,
                    RULE_typedvalue = 134, RULE_parametertype = 135, RULE_parameterattributes = 136, RULE_parameterattribute = 137, RULE_argument = 138, RULE_parameter = 139, RULE_nonvoidtype = 140,
                    RULE_star = 141, RULE_type = 142, RULE_typesuffix = 143, RULE_nonleftrecursivetype = 144, RULE_nonleftrecursivenonvoidtype = 145, RULE_typedef = 146, RULE_binaryopcode = 147,
                    RULE_inttype = 148, RULE_opaquetype = 149, RULE_structtype = 150, RULE_vectortype = 151, RULE_arraytype = 152, RULE_x86mmxtype = 153, RULE_voidtype = 154, RULE_metadatatype = 155,
                    RULE_floatingtype = 156, RULE_linkage = 157, RULE_cconv = 158;
    public static final String[] ruleNames = {"model", "toplevelelement", "attributegroup", "targetspecificattribute", "namedmetadata", "metadataref", "metadataidentifier", "valueref",
                    "globalvalueref", "localvalueref", "globalvalue", "globalvaluedef", "localvalue", "namedinstruction", "instruction", "alias", "aliasee", "targetinfo", "inlineasm",
                    "globalvariable", "constant", "constantexpression", "constantexpression_convert", "constantexpression_getelementptr", "constantexpression_select", "constantexpression_compare",
                    "constantexpression_extractelement", "constantexpression_insertelement", "constantexpression_shufflevector", "constantexpression_extractvalue", "constantexpression_insertvalue",
                    "constantexpression_binary", "undef", "blockaddress", "zeroinitializer", "structureconstant", "arrayconstant", "vectorconstant", "constantlist", "typedconstant", "simpleconstant",
                    "metadatanode", "metadatanodeelement", "metadatastring", "tlsmodel", "tlsoption", "addressspace", "section", "align", "gc", "function", "functiondef", "functiondecl",
                    "functionheader", "functionprefix", "parameters", "functionattributes", "alignstack", "functionattribute", "basicblock", "basicblockname", "metadatasuffix", "startinginstruction",
                    "middleinstruction", "namedmiddleinstruction", "paramname", "localname", "globalname", "terminatorinstruction", "namedterminatorinstruction", "instruction_ret", "instruction_br",
                    "instruction_switch", "instruction_indirectbr", "instruction_invoke_void", "instruction_invoke_nonvoid", "instruction_resume", "instruction_unreachable", "basicblockref",
                    "binaryinstruction", "instruction_add", "instruction_fadd", "fastmathflag", "instruction_sub", "instruction_fsub", "instruction_mul", "instruction_fmul", "instruction_udiv",
                    "instruction_sdiv", "instruction_fdiv", "instruction_urem", "instruction_srem", "instruction_frem", "bitwisebinaryinstruction", "instruction_shl", "instruction_lshr",
                    "instruction_ashr", "instruction_and", "instruction_or", "instruction_xor", "vectorinstructions", "instruction_extractelement", "instruction_insertelement",
                    "instruction_shufflevector", "aggregateinstruction", "instruction_extractvalue", "instruction_insertvalue", "memoryinstruction", "instruction_alloca", "instruction_load",
                    "instruction_store", "instruction_fence", "instruction_cmpxchg", "instruction_atomicrmw", "atomicrmw_operation", "instruction_getelementptr", "conversioninstruction",
                    "convertionopcode", "otherinstruction", "instruction_icmp", "icmpcondition", "instruction_fcmp", "fcmpcondition", "instruction_phi", "instruction_select",
                    "instruction_call_nonvoid", "instruction_call_void", "arglist", "callee", "inlineassembler", "instruction_va_arg", "instruction_landingpad", "landingpadclause", "ordering",
                    "typedvalue", "parametertype", "parameterattributes", "parameterattribute", "argument", "parameter", "nonvoidtype", "star", "type", "typesuffix", "nonleftrecursivetype",
                    "nonleftrecursivenonvoidtype", "typedef", "binaryopcode", "inttype", "opaquetype", "structtype", "vectortype", "arraytype", "x86mmxtype", "voidtype", "metadatatype",
                    "floatingtype", "linkage", "cconv"};

    @Override
    public String getGrammarFileName() {
        return "LLVM_IR.g4";
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
    String blockName; // blockName contains an if sentence, and the if applies the blockName to
// create sourceSecion
    boolean isWhile = false;
    List<String> thenList;
    List<String> elseList;
    boolean isContainsElse = false;
    Map<String, String> thenElse;

    public LLVM_IRParser(TokenStream input, LlvmContext context, Source source) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
        this.context = context;
        this.source = source;
        factory = new LlvmNodeFactory(context, source);
    }

    public static class ModelContext extends ParserRuleContext {
        public ToplevelelementContext toplevelelement;
        public List<ToplevelelementContext> elements = new ArrayList<ToplevelelementContext>();

        public List<ToplevelelementContext> toplevelelement() {
            return getRuleContexts(ToplevelelementContext.class);
        }

        public ToplevelelementContext toplevelelement(int i) {
            return getRuleContext(ToplevelelementContext.class, i);
        }

        public ModelContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_model;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterModel(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitModel(this);
        }
    }

    public final ModelContext model() throws RecognitionException {
        ModelContext _localctx = new ModelContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_model);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(321);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__230) | (1L << T__229) | (1L << T__227) | (1L << T__188) | (1L << T__180))) != 0) ||
                                ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__176 - 64)) | (1L << (T__162 - 64)) | (1L << (T__156 - 64)) | (1L << (T__148 - 64)) |
                                                (1L << (T__147 - 64)) | (1L << (T__144 - 64)) | (1L << (T__140 - 64)) | (1L << (T__137 - 64)) | (1L << (T__127 - 64)))) != 0) ||
                                ((((_la - 131)) & ~0x3f) == 0 && ((1L << (_la - 131)) & ((1L << (T__109 - 131)) | (1L << (T__108 - 131)) | (1L << (T__99 - 131)) | (1L << (T__77 - 131)) |
                                                (1L << (T__72 - 131)) | (1L << (T__71 - 131)) | (1L << (T__60 - 131)) | (1L << (T__59 - 131)))) != 0) ||
                                ((((_la - 200)) & ~0x3f) == 0 && ((1L << (_la - 200)) & ((1L << (T__40 - 200)) | (1L << (T__34 - 200)) | (1L << (T__18 - 200)) | (1L << (T__17 - 200)) |
                                                (1L << (T__7 - 200)) | (1L << (T__0 - 200)) | (1L << (Global_id - 200)) | (1L << (Local_id - 200)) | (1L << (Meta_int - 200)) | (1L << (Meta_name - 200)))) != 0)) {
                    {
                        {
                            setState(318);
                            ((ModelContext) _localctx).toplevelelement = toplevelelement();
                            ((ModelContext) _localctx).elements.add(((ModelContext) _localctx).toplevelelement);
                        }
                    }
                    setState(323);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
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

    public static class ToplevelelementContext extends ParserRuleContext {
        public AttributegroupContext attributegroup() {
            return getRuleContext(AttributegroupContext.class, 0);
        }

        public InlineasmContext inlineasm() {
            return getRuleContext(InlineasmContext.class, 0);
        }

        public TargetinfoContext targetinfo() {
            return getRuleContext(TargetinfoContext.class, 0);
        }

        public NamedmetadataContext namedmetadata() {
            return getRuleContext(NamedmetadataContext.class, 0);
        }

        public TypedefContext typedef() {
            return getRuleContext(TypedefContext.class, 0);
        }

        public GlobalvalueContext globalvalue() {
            return getRuleContext(GlobalvalueContext.class, 0);
        }

        public ToplevelelementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_toplevelelement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterToplevelelement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitToplevelelement(this);
        }
    }

    public final ToplevelelementContext toplevelelement() throws RecognitionException {
        ToplevelelementContext _localctx = new ToplevelelementContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_toplevelelement);
        try {
            setState(330);
            switch (_input.LA(1)) {
                case T__140:
                case Local_id:
                    enterOuterAlt(_localctx, 1);
                    {
                        setState(324);
                        typedef();
                    }
                    break;
                case T__137:
                    enterOuterAlt(_localctx, 2);
                    {
                        setState(325);
                        inlineasm();
                    }
                    break;
                case T__127:
                    enterOuterAlt(_localctx, 3);
                    {
                        setState(326);
                        targetinfo();
                    }
                    break;
                case T__230:
                case T__229:
                case T__227:
                case T__188:
                case T__180:
                case T__176:
                case T__162:
                case T__156:
                case T__148:
                case T__147:
                case T__144:
                case T__109:
                case T__108:
                case T__99:
                case T__72:
                case T__71:
                case T__60:
                case T__59:
                case T__40:
                case T__34:
                case T__18:
                case T__17:
                case T__7:
                case T__0:
                case Global_id:
                    enterOuterAlt(_localctx, 4);
                    {
                        setState(327);
                        globalvalue();
                    }
                    break;
                case Meta_int:
                case Meta_name:
                    enterOuterAlt(_localctx, 5);
                    {
                        setState(328);
                        namedmetadata();
                    }
                    break;
                case T__77:
                    enterOuterAlt(_localctx, 6);
                    {
                        setState(329);
                        attributegroup();
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

    public static class AttributegroupContext extends ParserRuleContext {
        public FunctionattributeContext attributes;
        public Token alignstackvalue;
        public TargetspecificattributeContext targetspecificattributes;

        public TargetspecificattributeContext targetspecificattribute(int i) {
            return getRuleContext(TargetspecificattributeContext.class, i);
        }

        public TerminalNode Integer(int i) {
            return getToken(LLVM_IRParser.Integer, i);
        }

        public List<FunctionattributeContext> functionattribute() {
            return getRuleContexts(FunctionattributeContext.class);
        }

        public List<TargetspecificattributeContext> targetspecificattribute() {
            return getRuleContexts(TargetspecificattributeContext.class);
        }

        public TerminalNode Attribute_id() {
            return getToken(LLVM_IRParser.Attribute_id, 0);
        }

        public List<TerminalNode> Integer() {
            return getTokens(LLVM_IRParser.Integer);
        }

        public List<AlignstackContext> alignstack() {
            return getRuleContexts(AlignstackContext.class);
        }

        public FunctionattributeContext functionattribute(int i) {
            return getRuleContext(FunctionattributeContext.class, i);
        }

        public AlignstackContext alignstack(int i) {
            return getRuleContext(AlignstackContext.class, i);
        }

        public AttributegroupContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_attributegroup;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterAttributegroup(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitAttributegroup(this);
        }
    }

    public final AttributegroupContext attributegroup() throws RecognitionException {
        AttributegroupContext _localctx = new AttributegroupContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_attributegroup);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(332);
                match(T__77);
                setState(333);
                match(Attribute_id);
                setState(334);
                match(T__235);
                setState(335);
                match(T__154);
                setState(357);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        setState(357);
                        switch (_input.LA(1)) {
                            case T__231:
                            case T__214:
                            case T__206:
                            case T__201:
                            case T__168:
                            case T__164:
                            case T__159:
                            case T__132:
                            case T__120:
                            case T__115:
                            case T__113:
                            case T__94:
                            case T__87:
                            case T__82:
                            case T__70:
                            case T__68:
                            case T__61:
                            case T__57:
                            case T__56:
                            case T__45:
                            case T__43:
                            case T__39:
                            case T__37:
                            case T__36:
                            case T__19:
                            case T__12:
                            case T__5:
                            case T__1: {
                                setState(337);
                                _errHandler.sync(this);
                                _alt = 1;
                                do {
                                    switch (_alt) {
                                        case 1: {
                                            {
                                                setState(336);
                                                ((AttributegroupContext) _localctx).attributes = functionattribute();
                                            }
                                        }
                                            break;
                                        default:
                                            throw new NoViableAltException(this);
                                    }
                                    setState(339);
                                    _errHandler.sync(this);
                                    _alt = getInterpreter().adaptivePredict(_input, 2, _ctx);
                                } while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
                            }
                                break;
                            case T__30: {
                                setState(342);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                                do {
                                    {
                                        {
                                            setState(341);
                                            alignstack();
                                        }
                                    }
                                    setState(344);
                                    _errHandler.sync(this);
                                    _la = _input.LA(1);
                                } while (_la == T__30);
                                setState(346);
                                match(T__235);
                                setState(348);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                                do {
                                    {
                                        {
                                            setState(347);
                                            ((AttributegroupContext) _localctx).alignstackvalue = match(Integer);
                                        }
                                    }
                                    setState(350);
                                    _errHandler.sync(this);
                                    _la = _input.LA(1);
                                } while (_la == Integer);
                            }
                                break;
                            case String: {
                                setState(353);
                                _errHandler.sync(this);
                                _alt = 1;
                                do {
                                    switch (_alt) {
                                        case 1: {
                                            {
                                                setState(352);
                                                ((AttributegroupContext) _localctx).targetspecificattributes = targetspecificattribute();
                                            }
                                        }
                                            break;
                                        default:
                                            throw new NoViableAltException(this);
                                    }
                                    setState(355);
                                    _errHandler.sync(this);
                                    _alt = getInterpreter().adaptivePredict(_input, 5, _ctx);
                                } while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
                            }
                                break;
                            default:
                                throw new NoViableAltException(this);
                        }
                    }
                    setState(359);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__231) | (1L << T__214) | (1L << T__206) | (1L << T__201))) != 0) ||
                                ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (T__168 - 72)) | (1L << (T__164 - 72)) | (1L << (T__159 - 72)) | (1L << (T__132 - 72)) |
                                                (1L << (T__120 - 72)) | (1L << (T__115 - 72)) | (1L << (T__113 - 72)))) != 0) ||
                                ((((_la - 146)) & ~0x3f) == 0 && ((1L << (_la - 146)) & ((1L << (T__94 - 146)) | (1L << (T__87 - 146)) | (1L << (T__82 - 146)) | (1L << (T__70 - 146)) |
                                                (1L << (T__68 - 146)) | (1L << (T__61 - 146)) | (1L << (T__57 - 146)) | (1L << (T__56 - 146)) | (1L << (T__45 - 146)) | (1L << (T__43 - 146)) |
                                                (1L << (T__39 - 146)) | (1L << (T__37 - 146)) | (1L << (T__36 - 146)))) != 0) ||
                                ((((_la - 210)) & ~0x3f) == 0 && ((1L << (_la - 210)) & ((1L << (T__30 - 210)) | (1L << (T__19 - 210)) | (1L << (T__12 - 210)) | (1L << (T__5 - 210)) |
                                                (1L << (T__1 - 210)) | (1L << (String - 210)))) != 0));
                setState(361);
                match(T__194);
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

    public static class TargetspecificattributeContext extends ParserRuleContext {
        public Token name;
        public Token value;

        public List<TerminalNode> String() {
            return getTokens(LLVM_IRParser.String);
        }

        public TerminalNode String(int i) {
            return getToken(LLVM_IRParser.String, i);
        }

        public TargetspecificattributeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_targetspecificattribute;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterTargetspecificattribute(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitTargetspecificattribute(this);
        }
    }

    public final TargetspecificattributeContext targetspecificattribute() throws RecognitionException {
        TargetspecificattributeContext _localctx = new TargetspecificattributeContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_targetspecificattribute);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(363);
                ((TargetspecificattributeContext) _localctx).name = match(String);
                setState(366);
                _la = _input.LA(1);
                if (_la == T__235) {
                    {
                        setState(364);
                        match(T__235);
                        setState(365);
                        ((TargetspecificattributeContext) _localctx).value = match(String);
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

    public static class NamedmetadataContext extends ParserRuleContext {
        public Token name;
        public MetadatanodeContext node;

        public TerminalNode Meta_int() {
            return getToken(LLVM_IRParser.Meta_int, 0);
        }

        public TerminalNode Meta_name() {
            return getToken(LLVM_IRParser.Meta_name, 0);
        }

        public MetadatanodeContext metadatanode() {
            return getRuleContext(MetadatanodeContext.class, 0);
        }

        public NamedmetadataContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_namedmetadata;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterNamedmetadata(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitNamedmetadata(this);
        }
    }

    public final NamedmetadataContext namedmetadata() throws RecognitionException {
        NamedmetadataContext _localctx = new NamedmetadataContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_namedmetadata);
        try {
            setState(375);
            switch (_input.LA(1)) {
                case Meta_int:
                    enterOuterAlt(_localctx, 1);
                    {
                        setState(368);
                        ((NamedmetadataContext) _localctx).name = match(Meta_int);
                        setState(369);
                        match(T__235);
                        setState(370);
                        match(T__118);
                        setState(371);
                        ((NamedmetadataContext) _localctx).node = metadatanode();
                    }
                    break;
                case Meta_name:
                    enterOuterAlt(_localctx, 2);
                    {
                        setState(372);
                        ((NamedmetadataContext) _localctx).name = match(Meta_name);
                        setState(373);
                        match(T__235);
                        setState(374);
                        ((NamedmetadataContext) _localctx).node = metadatanode();
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

    public static class MetadatarefContext extends ParserRuleContext {
        public NamedmetadataContext namedmetadata() {
            return getRuleContext(NamedmetadataContext.class, 0);
        }

        public MetadataidentifierContext metadataidentifier() {
            return getRuleContext(MetadataidentifierContext.class, 0);
        }

        public MetadatarefContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_metadataref;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterMetadataref(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitMetadataref(this);
        }
    }

    public final MetadatarefContext metadataref() throws RecognitionException {
        MetadatarefContext _localctx = new MetadatarefContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_metadataref);
        try {
            setState(379);
            switch (getInterpreter().adaptivePredict(_input, 10, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                    {
                        setState(377);
                        namedmetadata();
                    }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                    {
                        setState(378);
                        metadataidentifier();
                    }
                    break;
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

    public static class MetadataidentifierContext extends ParserRuleContext {
        public TerminalNode Meta_int() {
            return getToken(LLVM_IRParser.Meta_int, 0);
        }

        public TerminalNode Meta_name() {
            return getToken(LLVM_IRParser.Meta_name, 0);
        }

        public MetadataidentifierContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_metadataidentifier;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterMetadataidentifier(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitMetadataidentifier(this);
        }
    }

    public final MetadataidentifierContext metadataidentifier() throws RecognitionException {
        MetadataidentifierContext _localctx = new MetadataidentifierContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_metadataidentifier);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(381);
                _la = _input.LA(1);
                if (!(_la == Meta_int || _la == Meta_name)) {
                    _errHandler.recoverInline(this);
                }
                consume();
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

    public static class ValuerefContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Token resultToken;
        public GlobalvaluerefContext opG;
        public LocalvaluerefContext op;

        public GlobalvaluerefContext globalvalueref() {
            return getRuleContext(GlobalvaluerefContext.class, 0);
        }

        public LocalvaluerefContext localvalueref() {
            return getRuleContext(LocalvaluerefContext.class, 0);
        }

        public ValuerefContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_valueref;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterValueref(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitValueref(this);
        }
    }

    public final ValuerefContext valueref() throws RecognitionException {
        ValuerefContext _localctx = new ValuerefContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_valueref);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(389);
                switch (getInterpreter().adaptivePredict(_input, 11, _ctx)) {
                    case 1: {
                        setState(383);
                        ((ValuerefContext) _localctx).opG = globalvalueref();

                        ((ValuerefContext) _localctx).resultToken = ((ValuerefContext) _localctx).opG.resultToken;

                    }
                        break;
                    case 2: {
                        setState(386);
                        ((ValuerefContext) _localctx).op = localvalueref();

                        ((ValuerefContext) _localctx).result = ((ValuerefContext) _localctx).op.result;
                        ((ValuerefContext) _localctx).resultToken = ((ValuerefContext) _localctx).op.resultToken;

                    }
                        break;
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

    public static class GlobalvaluerefContext extends ParserRuleContext {
        public Token resultToken;
        public ConstantContext constantelement;
        public MetadatarefContext metadata;

        public MetadatarefContext metadataref() {
            return getRuleContext(MetadatarefContext.class, 0);
        }

        public ConstantContext constant() {
            return getRuleContext(ConstantContext.class, 0);
        }

        public GlobalvaluerefContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_globalvalueref;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterGlobalvalueref(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitGlobalvalueref(this);
        }
    }

    public final GlobalvaluerefContext globalvalueref() throws RecognitionException {
        GlobalvaluerefContext _localctx = new GlobalvaluerefContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_globalvalueref);
        try {
            setState(395);
            switch (_input.LA(1)) {
                case T__236:
                case T__233:
                case T__230:
                case T__229:
                case T__228:
                case T__227:
                case T__226:
                case T__224:
                case T__215:
                case T__213:
                case T__212:
                case T__211:
                case T__210:
                case T__207:
                case T__205:
                case T__203:
                case T__202:
                case T__200:
                case T__193:
                case T__192:
                case T__190:
                case T__188:
                case T__186:
                case T__184:
                case T__183:
                case T__181:
                case T__180:
                case T__178:
                case T__177:
                case T__176:
                case T__175:
                case T__173:
                case T__172:
                case T__171:
                case T__169:
                case T__166:
                case T__165:
                case T__163:
                case T__162:
                case T__157:
                case T__156:
                case T__154:
                case T__152:
                case T__148:
                case T__146:
                case T__144:
                case T__142:
                case T__140:
                case T__136:
                case T__135:
                case T__133:
                case T__130:
                case T__129:
                case T__125:
                case T__118:
                case T__117:
                case T__114:
                case T__112:
                case T__111:
                case T__110:
                case T__109:
                case T__108:
                case T__106:
                case T__105:
                case T__102:
                case T__100:
                case T__99:
                case T__97:
                case T__92:
                case T__90:
                case T__85:
                case T__84:
                case T__83:
                case T__81:
                case T__79:
                case T__76:
                case T__74:
                case T__72:
                case T__71:
                case T__65:
                case T__64:
                case T__60:
                case T__58:
                case T__55:
                case T__51:
                case T__47:
                case T__46:
                case T__42:
                case T__41:
                case T__40:
                case T__35:
                case T__34:
                case T__33:
                case T__31:
                case T__29:
                case T__25:
                case T__24:
                case T__22:
                case T__20:
                case T__18:
                case T__17:
                case T__15:
                case T__9:
                case T__7:
                case T__3:
                case T__0:
                case Visibility:
                case Boolean:
                case Null:
                case Int_type:
                case Global_id:
                case Local_id:
                case Integer:
                case Signed_int:
                case Cstring:
                case Metadata_string:
                case Float:
                case Floatingtype:
                    enterOuterAlt(_localctx, 1);
                    {
                        setState(391);
                        ((GlobalvaluerefContext) _localctx).constantelement = constant();

                        ((GlobalvaluerefContext) _localctx).resultToken = ((GlobalvaluerefContext) _localctx).constantelement.resultToken;

                    }
                    break;
                case Meta_int:
                case Meta_name:
                    enterOuterAlt(_localctx, 2);
                    {
                        setState(394);
                        ((GlobalvaluerefContext) _localctx).metadata = metadataref();
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

    public static class LocalvaluerefContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Token resultToken;
        public Token Local_id;
        public LocalvalueContext op1;

        public LocalvalueContext localvalue() {
            return getRuleContext(LocalvalueContext.class, 0);
        }

        public TerminalNode Local_id() {
            return getToken(LLVM_IRParser.Local_id, 0);
        }

        public LocalvaluerefContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_localvalueref;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterLocalvalueref(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitLocalvalueref(this);
        }
    }

    public final LocalvaluerefContext localvalueref() throws RecognitionException {
        LocalvaluerefContext _localctx = new LocalvaluerefContext(_ctx, getState());
        enterRule(_localctx, 18, RULE_localvalueref);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(402);
                switch (getInterpreter().adaptivePredict(_input, 13, _ctx)) {
                    case 1: {
                        setState(397);
                        ((LocalvaluerefContext) _localctx).Local_id = match(Local_id);

                        ((LocalvaluerefContext) _localctx).result = factory.createRead(((LocalvaluerefContext) _localctx).Local_id);
                        ((LocalvaluerefContext) _localctx).resultToken = ((LocalvaluerefContext) _localctx).Local_id;

                    }
                        break;
                    case 2: {
                        setState(399);
                        ((LocalvaluerefContext) _localctx).op1 = localvalue();

                        ((LocalvaluerefContext) _localctx).result = ((LocalvaluerefContext) _localctx).op1.result;
                        ((LocalvaluerefContext) _localctx).resultToken = ((LocalvaluerefContext) _localctx).op1.resultToken;

                    }
                        break;
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

    public static class GlobalvalueContext extends ParserRuleContext {
        public GlobalvariableContext globalvariable() {
            return getRuleContext(GlobalvariableContext.class, 0);
        }

        public AliasContext alias() {
            return getRuleContext(AliasContext.class, 0);
        }

        public FunctionContext function() {
            return getRuleContext(FunctionContext.class, 0);
        }

        public GlobalvalueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_globalvalue;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterGlobalvalue(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitGlobalvalue(this);
        }
    }

    public final GlobalvalueContext globalvalue() throws RecognitionException {
        GlobalvalueContext _localctx = new GlobalvalueContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_globalvalue);
        try {
            setState(407);
            switch (getInterpreter().adaptivePredict(_input, 14, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                    {
                        setState(404);
                        globalvariable();
                    }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                    {
                        setState(405);
                        function();
                    }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                    {
                        setState(406);
                        alias();
                    }
                    break;
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

    public static class GlobalvaluedefContext extends ParserRuleContext {
        public GlobalvariableContext globalvariable() {
            return getRuleContext(GlobalvariableContext.class, 0);
        }

        public FunctionheaderContext functionheader() {
            return getRuleContext(FunctionheaderContext.class, 0);
        }

        public AliasContext alias() {
            return getRuleContext(AliasContext.class, 0);
        }

        public GlobalvaluedefContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_globalvaluedef;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterGlobalvaluedef(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitGlobalvaluedef(this);
        }
    }

    public final GlobalvaluedefContext globalvaluedef() throws RecognitionException {
        GlobalvaluedefContext _localctx = new GlobalvaluedefContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_globalvaluedef);
        try {
            setState(412);
            switch (getInterpreter().adaptivePredict(_input, 15, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                    {
                        setState(409);
                        globalvariable();
                    }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                    {
                        setState(410);
                        functionheader();
                    }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                    {
                        setState(411);
                        alias();
                    }
                    break;
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

    public static class LocalvalueContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Token resultToken;
        public NamedinstructionContext op1;
        public ParameterContext op2;

        public ParameterContext parameter() {
            return getRuleContext(ParameterContext.class, 0);
        }

        public NamedinstructionContext namedinstruction() {
            return getRuleContext(NamedinstructionContext.class, 0);
        }

        public LocalvalueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_localvalue;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterLocalvalue(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitLocalvalue(this);
        }
    }

    public final LocalvalueContext localvalue() throws RecognitionException {
        LocalvalueContext _localctx = new LocalvalueContext(_ctx, getState());
        enterRule(_localctx, 24, RULE_localvalue);
        try {
            setState(420);
            switch (getInterpreter().adaptivePredict(_input, 16, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                    {
                        setState(414);
                        ((LocalvalueContext) _localctx).op1 = namedinstruction();

                        ((LocalvalueContext) _localctx).result = ((LocalvalueContext) _localctx).op1.result;

                    }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                    {
                        setState(417);
                        ((LocalvalueContext) _localctx).op2 = parameter();

                        ((LocalvalueContext) _localctx).result = factory.createRead(((LocalvalueContext) _localctx).op2.resultToken);
                        ((LocalvalueContext) _localctx).resultToken = ((LocalvalueContext) _localctx).op2.resultToken;

                    }
                    break;
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

    public static class NamedinstructionContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public StartinginstructionContext op1;
        public NamedmiddleinstructionContext op2;
        public NamedterminatorinstructionContext op3;

        public StartinginstructionContext startinginstruction() {
            return getRuleContext(StartinginstructionContext.class, 0);
        }

        public NamedterminatorinstructionContext namedterminatorinstruction() {
            return getRuleContext(NamedterminatorinstructionContext.class, 0);
        }

        public NamedmiddleinstructionContext namedmiddleinstruction() {
            return getRuleContext(NamedmiddleinstructionContext.class, 0);
        }

        public NamedinstructionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_namedinstruction;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterNamedinstruction(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitNamedinstruction(this);
        }
    }

    public final NamedinstructionContext namedinstruction() throws RecognitionException {
        NamedinstructionContext _localctx = new NamedinstructionContext(_ctx, getState());
        enterRule(_localctx, 26, RULE_namedinstruction);
        try {
            setState(431);
            switch (getInterpreter().adaptivePredict(_input, 17, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                    {
                        setState(422);
                        ((NamedinstructionContext) _localctx).op1 = startinginstruction();

                        ((NamedinstructionContext) _localctx).result = ((NamedinstructionContext) _localctx).op1.result;

                    }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                    {
                        setState(425);
                        ((NamedinstructionContext) _localctx).op2 = namedmiddleinstruction();

                        ((NamedinstructionContext) _localctx).result = ((NamedinstructionContext) _localctx).op2.result;

                    }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                    {
                        setState(428);
                        ((NamedinstructionContext) _localctx).op3 = namedterminatorinstruction();

                        ((NamedinstructionContext) _localctx).result = ((NamedinstructionContext) _localctx).op3.result;

                    }
                    break;
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

    public static class InstructionContext extends ParserRuleContext {
        public StartinginstructionContext startinginstruction() {
            return getRuleContext(StartinginstructionContext.class, 0);
        }

        public TerminatorinstructionContext terminatorinstruction() {
            return getRuleContext(TerminatorinstructionContext.class, 0);
        }

        public MiddleinstructionContext middleinstruction() {
            return getRuleContext(MiddleinstructionContext.class, 0);
        }

        public InstructionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction(this);
        }
    }

    public final InstructionContext instruction() throws RecognitionException {
        InstructionContext _localctx = new InstructionContext(_ctx, getState());
        enterRule(_localctx, 28, RULE_instruction);
        try {
            setState(436);
            switch (getInterpreter().adaptivePredict(_input, 18, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                    {
                        setState(433);
                        startinginstruction();
                    }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                    {
                        setState(434);
                        middleinstruction();
                    }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                    {
                        setState(435);
                        terminatorinstruction();
                    }
                    break;
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

    public static class AliasContext extends ParserRuleContext {
        public GlobalnameContext name;
        public LinkageContext linkageelement;
        public Token Visibilityelement;
        public TypeContext typeelement;
        public AliaseeContext aliaseeelement;

        public TerminalNode Visibility() {
            return getToken(LLVM_IRParser.Visibility, 0);
        }

        public GlobalnameContext globalname() {
            return getRuleContext(GlobalnameContext.class, 0);
        }

        public AliaseeContext aliasee() {
            return getRuleContext(AliaseeContext.class, 0);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public LinkageContext linkage() {
            return getRuleContext(LinkageContext.class, 0);
        }

        public AliasContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_alias;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterAlias(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitAlias(this);
        }
    }

    public final AliasContext alias() throws RecognitionException {
        AliasContext _localctx = new AliasContext(_ctx, getState());
        enterRule(_localctx, 30, RULE_alias);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(438);
                ((AliasContext) _localctx).name = globalname();
                setState(439);
                match(T__0);
                setState(441);
                _la = _input.LA(1);
                if (((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & ((1L << (T__230 - 10)) | (1L << (T__229 - 10)) | (1L << (T__227 - 10)) | (1L << (T__188 - 10)) | (1L << (T__180 - 10)) | (1L << (T__176 - 10)))) != 0) ||
                                ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & ((1L << (T__162 - 78)) | (1L << (T__148 - 78)) | (1L << (T__144 - 78)) | (1L << (T__109 - 78)) |
                                                (1L << (T__108 - 78)) | (1L << (T__99 - 78)))) != 0) ||
                                ((((_la - 169)) & ~0x3f) == 0 && ((1L << (_la - 169)) & ((1L << (T__71 - 169)) | (1L << (T__60 - 169)) | (1L << (T__40 - 169)) | (1L << (T__18 - 169)))) != 0)) {
                    {
                        setState(440);
                        ((AliasContext) _localctx).linkageelement = linkage();
                    }
                }

                setState(444);
                _la = _input.LA(1);
                if (_la == Visibility) {
                    {
                        setState(443);
                        ((AliasContext) _localctx).Visibilityelement = match(Visibility);
                    }
                }

                setState(446);
                ((AliasContext) _localctx).typeelement = type();
                setState(447);
                ((AliasContext) _localctx).aliaseeelement = aliasee();
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

    public static class AliaseeContext extends ParserRuleContext {
        public Constantexpression_convertContext bitcast;

        public Constantexpression_convertContext constantexpression_convert() {
            return getRuleContext(Constantexpression_convertContext.class, 0);
        }

        public GlobalvaluedefContext globalvaluedef() {
            return getRuleContext(GlobalvaluedefContext.class, 0);
        }

        public TerminalNode Global_id() {
            return getToken(LLVM_IRParser.Global_id, 0);
        }

        public AliaseeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_aliasee;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterAliasee(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitAliasee(this);
        }
    }

    public final AliaseeContext aliasee() throws RecognitionException {
        AliaseeContext _localctx = new AliaseeContext(_ctx, getState());
        enterRule(_localctx, 32, RULE_aliasee);
        try {
            setState(452);
            switch (getInterpreter().adaptivePredict(_input, 21, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                    {
                        setState(449);
                        globalvaluedef();
                    }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                    {
                        setState(450);
                        match(Global_id);
                    }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                    {
                        setState(451);
                        ((AliaseeContext) _localctx).bitcast = constantexpression_convert();
                    }
                    break;
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

    public static class TargetinfoContext extends ParserRuleContext {
        public Token infotype;
        public Token layout;

        public TerminalNode String() {
            return getToken(LLVM_IRParser.String, 0);
        }

        public TargetinfoContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_targetinfo;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterTargetinfo(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitTargetinfo(this);
        }
    }

    public final TargetinfoContext targetinfo() throws RecognitionException {
        TargetinfoContext _localctx = new TargetinfoContext(_ctx, getState());
        enterRule(_localctx, 34, RULE_targetinfo);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(454);
                match(T__127);
                setState(455);
                ((TargetinfoContext) _localctx).infotype = _input.LT(1);
                _la = _input.LA(1);
                if (!(_la == T__187 || _la == T__89)) {
                    ((TargetinfoContext) _localctx).infotype = (Token) _errHandler.recoverInline(this);
                }
                consume();
                setState(456);
                match(T__235);
                setState(457);
                ((TargetinfoContext) _localctx).layout = match(String);
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

    public static class InlineasmContext extends ParserRuleContext {
        public Token asmline;

        public TerminalNode String() {
            return getToken(LLVM_IRParser.String, 0);
        }

        public InlineasmContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_inlineasm;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInlineasm(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInlineasm(this);
        }
    }

    public final InlineasmContext inlineasm() throws RecognitionException {
        InlineasmContext _localctx = new InlineasmContext(_ctx, getState());
        enterRule(_localctx, 36, RULE_inlineasm);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(459);
                match(T__137);
                setState(460);
                match(T__220);
                setState(461);
                ((InlineasmContext) _localctx).asmline = match(String);
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

    public static class GlobalvariableContext extends ParserRuleContext {
        public GlobalnameContext name;
        public LinkageContext linkageelement;
        public AddressspaceContext addrspace;
        public TlsmodelContext tlsmodelElement;
        public TypeContext typeelement;
        public ConstantContext initialvalue;
        public SectionContext sectionElement;
        public AlignContext alignElement;

        public TlsmodelContext tlsmodel() {
            return getRuleContext(TlsmodelContext.class, 0);
        }

        public ConstantContext constant() {
            return getRuleContext(ConstantContext.class, 0);
        }

        public AlignContext align() {
            return getRuleContext(AlignContext.class, 0);
        }

        public GlobalnameContext globalname() {
            return getRuleContext(GlobalnameContext.class, 0);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public AddressspaceContext addressspace() {
            return getRuleContext(AddressspaceContext.class, 0);
        }

        public SectionContext section() {
            return getRuleContext(SectionContext.class, 0);
        }

        public LinkageContext linkage() {
            return getRuleContext(LinkageContext.class, 0);
        }

        public GlobalvariableContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_globalvariable;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterGlobalvariable(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitGlobalvariable(this);
        }
    }

    public final GlobalvariableContext globalvariable() throws RecognitionException {
        GlobalvariableContext _localctx = new GlobalvariableContext(_ctx, getState());
        enterRule(_localctx, 38, RULE_globalvariable);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(463);
                ((GlobalvariableContext) _localctx).name = globalname();
                setState(465);
                _la = _input.LA(1);
                if (((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & ((1L << (T__230 - 10)) | (1L << (T__229 - 10)) | (1L << (T__227 - 10)) | (1L << (T__188 - 10)) | (1L << (T__180 - 10)) | (1L << (T__176 - 10)))) != 0) ||
                                ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & ((1L << (T__162 - 78)) | (1L << (T__148 - 78)) | (1L << (T__144 - 78)) | (1L << (T__109 - 78)) |
                                                (1L << (T__108 - 78)) | (1L << (T__99 - 78)))) != 0) ||
                                ((((_la - 169)) & ~0x3f) == 0 && ((1L << (_la - 169)) & ((1L << (T__71 - 169)) | (1L << (T__60 - 169)) | (1L << (T__40 - 169)) | (1L << (T__18 - 169)))) != 0)) {
                    {
                        setState(464);
                        ((GlobalvariableContext) _localctx).linkageelement = linkage();
                    }
                }

                setState(468);
                _la = _input.LA(1);
                if (_la == T__7) {
                    {
                        setState(467);
                        ((GlobalvariableContext) _localctx).addrspace = addressspace();
                    }
                }

                setState(471);
                _la = _input.LA(1);
                if (_la == T__17) {
                    {
                        setState(470);
                        ((GlobalvariableContext) _localctx).tlsmodelElement = tlsmodel();
                    }
                }

                setState(474);
                _la = _input.LA(1);
                if (_la == T__156) {
                    {
                        setState(473);
                        match(T__156);
                    }
                }

                setState(476);
                _la = _input.LA(1);
                if (!(_la == T__72 || _la == T__34)) {
                    _errHandler.recoverInline(this);
                }
                consume();
                setState(477);
                ((GlobalvariableContext) _localctx).typeelement = type();
                setState(479);
                switch (getInterpreter().adaptivePredict(_input, 26, _ctx)) {
                    case 1: {
                        setState(478);
                        ((GlobalvariableContext) _localctx).initialvalue = constant();
                    }
                        break;
                }
                setState(483);
                switch (getInterpreter().adaptivePredict(_input, 27, _ctx)) {
                    case 1: {
                        setState(481);
                        match(T__222);
                        setState(482);
                        ((GlobalvariableContext) _localctx).sectionElement = section();
                    }
                        break;
                }
                setState(487);
                switch (getInterpreter().adaptivePredict(_input, 28, _ctx)) {
                    case 1: {
                        setState(485);
                        match(T__222);
                        setState(486);
                        ((GlobalvariableContext) _localctx).alignElement = align();
                    }
                        break;
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

    public static class ConstantContext extends ParserRuleContext {
        public Token resultToken;
        public SimpleconstantContext op1;
        public Token Global_id;

        public SimpleconstantContext simpleconstant() {
            return getRuleContext(SimpleconstantContext.class, 0);
        }

        public StructureconstantContext structureconstant() {
            return getRuleContext(StructureconstantContext.class, 0);
        }

        public UndefContext undef() {
            return getRuleContext(UndefContext.class, 0);
        }

        public ZeroinitializerContext zeroinitializer() {
            return getRuleContext(ZeroinitializerContext.class, 0);
        }

        public GlobalvaluedefContext globalvaluedef() {
            return getRuleContext(GlobalvaluedefContext.class, 0);
        }

        public ArrayconstantContext arrayconstant() {
            return getRuleContext(ArrayconstantContext.class, 0);
        }

        public VectorconstantContext vectorconstant() {
            return getRuleContext(VectorconstantContext.class, 0);
        }

        public TerminalNode Global_id() {
            return getToken(LLVM_IRParser.Global_id, 0);
        }

        public MetadatastringContext metadatastring() {
            return getRuleContext(MetadatastringContext.class, 0);
        }

        public BlockaddressContext blockaddress() {
            return getRuleContext(BlockaddressContext.class, 0);
        }

        public MetadatanodeContext metadatanode() {
            return getRuleContext(MetadatanodeContext.class, 0);
        }

        public ConstantexpressionContext constantexpression() {
            return getRuleContext(ConstantexpressionContext.class, 0);
        }

        public ConstantContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_constant;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterConstant(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitConstant(this);
        }
    }

    public final ConstantContext constant() throws RecognitionException {
        ConstantContext _localctx = new ConstantContext(_ctx, getState());
        enterRule(_localctx, 40, RULE_constant);
        try {
            setState(504);
            switch (getInterpreter().adaptivePredict(_input, 29, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                    {
                        setState(489);
                        ((ConstantContext) _localctx).op1 = simpleconstant();

                        ((ConstantContext) _localctx).resultToken = ((ConstantContext) _localctx).op1.resultToken;

                    }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                    {
                        setState(492);
                        structureconstant();
                    }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                    {
                        setState(493);
                        arrayconstant();
                    }
                    break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                    {
                        setState(494);
                        vectorconstant();
                    }
                    break;
                case 5:
                    enterOuterAlt(_localctx, 5);
                    {
                        setState(495);
                        zeroinitializer();
                    }
                    break;
                case 6:
                    enterOuterAlt(_localctx, 6);
                    {
                        setState(496);
                        metadatanode();
                    }
                    break;
                case 7:
                    enterOuterAlt(_localctx, 7);
                    {
                        setState(497);
                        metadatastring();
                    }
                    break;
                case 8:
                    enterOuterAlt(_localctx, 8);
                    {
                        setState(498);
                        blockaddress();
                    }
                    break;
                case 9:
                    enterOuterAlt(_localctx, 9);
                    {
                        setState(499);
                        undef();
                    }
                    break;
                case 10:
                    enterOuterAlt(_localctx, 10);
                    {
                        setState(500);
                        constantexpression();
                    }
                    break;
                case 11:
                    enterOuterAlt(_localctx, 11);
                    {
                        setState(501);
                        globalvaluedef();
                    }
                    break;
                case 12:
                    enterOuterAlt(_localctx, 12);
                    {
                        setState(502);
                        ((ConstantContext) _localctx).Global_id = match(Global_id);

                        ((ConstantContext) _localctx).resultToken = ((ConstantContext) _localctx).Global_id;

                    }
                    break;
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

    public static class ConstantexpressionContext extends ParserRuleContext {
        public Constantexpression_compareContext constantexpression_compare() {
            return getRuleContext(Constantexpression_compareContext.class, 0);
        }

        public Constantexpression_insertelementContext constantexpression_insertelement() {
            return getRuleContext(Constantexpression_insertelementContext.class, 0);
        }

        public Constantexpression_extractvalueContext constantexpression_extractvalue() {
            return getRuleContext(Constantexpression_extractvalueContext.class, 0);
        }

        public Constantexpression_extractelementContext constantexpression_extractelement() {
            return getRuleContext(Constantexpression_extractelementContext.class, 0);
        }

        public Constantexpression_binaryContext constantexpression_binary() {
            return getRuleContext(Constantexpression_binaryContext.class, 0);
        }

        public Constantexpression_convertContext constantexpression_convert() {
            return getRuleContext(Constantexpression_convertContext.class, 0);
        }

        public Constantexpression_insertvalueContext constantexpression_insertvalue() {
            return getRuleContext(Constantexpression_insertvalueContext.class, 0);
        }

        public Constantexpression_selectContext constantexpression_select() {
            return getRuleContext(Constantexpression_selectContext.class, 0);
        }

        public Constantexpression_shufflevectorContext constantexpression_shufflevector() {
            return getRuleContext(Constantexpression_shufflevectorContext.class, 0);
        }

        public Constantexpression_getelementptrContext constantexpression_getelementptr() {
            return getRuleContext(Constantexpression_getelementptrContext.class, 0);
        }

        public ConstantexpressionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_constantexpression;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterConstantexpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitConstantexpression(this);
        }
    }

    public final ConstantexpressionContext constantexpression() throws RecognitionException {
        ConstantexpressionContext _localctx = new ConstantexpressionContext(_ctx, getState());
        enterRule(_localctx, 42, RULE_constantexpression);
        try {
            setState(516);
            switch (_input.LA(1)) {
                case T__215:
                case T__190:
                case T__184:
                case T__181:
                case T__146:
                case T__117:
                case T__111:
                case T__85:
                case T__79:
                case T__64:
                case T__42:
                case T__29:
                case T__25:
                    enterOuterAlt(_localctx, 1);
                    {
                        setState(506);
                        constantexpression_convert();
                    }
                    break;
                case T__213:
                    enterOuterAlt(_localctx, 2);
                    {
                        setState(507);
                        constantexpression_getelementptr();
                    }
                    break;
                case T__177:
                    enterOuterAlt(_localctx, 3);
                    {
                        setState(508);
                        constantexpression_select();
                    }
                    break;
                case T__135:
                case T__110:
                    enterOuterAlt(_localctx, 4);
                    {
                        setState(509);
                        constantexpression_compare();
                    }
                    break;
                case T__228:
                    enterOuterAlt(_localctx, 5);
                    {
                        setState(510);
                        constantexpression_extractelement();
                    }
                    break;
                case T__74:
                    enterOuterAlt(_localctx, 6);
                    {
                        setState(511);
                        constantexpression_insertelement();
                    }
                    break;
                case T__186:
                    enterOuterAlt(_localctx, 7);
                    {
                        setState(512);
                        constantexpression_shufflevector();
                    }
                    break;
                case T__51:
                    enterOuterAlt(_localctx, 8);
                    {
                        setState(513);
                        constantexpression_extractvalue();
                    }
                    break;
                case T__224:
                    enterOuterAlt(_localctx, 9);
                    {
                        setState(514);
                        constantexpression_insertvalue();
                    }
                    break;
                case T__236:
                case T__226:
                case T__210:
                case T__205:
                case T__173:
                case T__169:
                case T__133:
                case T__112:
                case T__106:
                case T__105:
                case T__102:
                case T__97:
                case T__90:
                case T__84:
                case T__81:
                case T__65:
                case T__22:
                case T__15:
                    enterOuterAlt(_localctx, 10);
                    {
                        setState(515);
                        constantexpression_binary();
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

    public static class Constantexpression_convertContext extends ParserRuleContext {
        public ConvertionopcodeContext opcodeElement;
        public TypeContext fromtype;
        public GlobalvaluerefContext constantElement;
        public TypeContext targettype;

        public TypeContext type(int i) {
            return getRuleContext(TypeContext.class, i);
        }

        public GlobalvaluerefContext globalvalueref() {
            return getRuleContext(GlobalvaluerefContext.class, 0);
        }

        public ConvertionopcodeContext convertionopcode() {
            return getRuleContext(ConvertionopcodeContext.class, 0);
        }

        public List<TypeContext> type() {
            return getRuleContexts(TypeContext.class);
        }

        public Constantexpression_convertContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_constantexpression_convert;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterConstantexpression_convert(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitConstantexpression_convert(this);
        }
    }

    public final Constantexpression_convertContext constantexpression_convert() throws RecognitionException {
        Constantexpression_convertContext _localctx = new Constantexpression_convertContext(_ctx, getState());
        enterRule(_localctx, 44, RULE_constantexpression_convert);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(518);
                ((Constantexpression_convertContext) _localctx).opcodeElement = convertionopcode();
                setState(519);
                match(T__149);
                setState(520);
                ((Constantexpression_convertContext) _localctx).fromtype = type();
                setState(521);
                ((Constantexpression_convertContext) _localctx).constantElement = globalvalueref();
                setState(522);
                match(T__179);
                setState(523);
                ((Constantexpression_convertContext) _localctx).targettype = type();
                setState(524);
                match(T__170);
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

    public static class Constantexpression_getelementptrContext extends ParserRuleContext {
        public Token opcode;
        public TypeContext constanttype;
        public GlobalvaluerefContext constantElement;
        public TypeContext type;
        public List<TypeContext> indextypes = new ArrayList<TypeContext>();
        public ConstantContext constant;
        public List<ConstantContext> indices = new ArrayList<ConstantContext>();

        public List<ConstantContext> constant() {
            return getRuleContexts(ConstantContext.class);
        }

        public TypeContext type(int i) {
            return getRuleContext(TypeContext.class, i);
        }

        public GlobalvaluerefContext globalvalueref() {
            return getRuleContext(GlobalvaluerefContext.class, 0);
        }

        public List<TypeContext> type() {
            return getRuleContexts(TypeContext.class);
        }

        public ConstantContext constant(int i) {
            return getRuleContext(ConstantContext.class, i);
        }

        public Constantexpression_getelementptrContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_constantexpression_getelementptr;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterConstantexpression_getelementptr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitConstantexpression_getelementptr(this);
        }
    }

    public final Constantexpression_getelementptrContext constantexpression_getelementptr() throws RecognitionException {
        Constantexpression_getelementptrContext _localctx = new Constantexpression_getelementptrContext(_ctx, getState());
        enterRule(_localctx, 46, RULE_constantexpression_getelementptr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(526);
                ((Constantexpression_getelementptrContext) _localctx).opcode = match(T__213);
                setState(528);
                _la = _input.LA(1);
                if (_la == T__128) {
                    {
                        setState(527);
                        match(T__128);
                    }
                }

                setState(530);
                match(T__149);
                setState(531);
                ((Constantexpression_getelementptrContext) _localctx).constanttype = type();
                setState(532);
                ((Constantexpression_getelementptrContext) _localctx).constantElement = globalvalueref();
                setState(539);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__222) {
                    {
                        {
                            setState(533);
                            match(T__222);
                            setState(534);
                            ((Constantexpression_getelementptrContext) _localctx).type = type();
                            ((Constantexpression_getelementptrContext) _localctx).indextypes.add(((Constantexpression_getelementptrContext) _localctx).type);
                            setState(535);
                            ((Constantexpression_getelementptrContext) _localctx).constant = constant();
                            ((Constantexpression_getelementptrContext) _localctx).indices.add(((Constantexpression_getelementptrContext) _localctx).constant);
                        }
                    }
                    setState(541);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(542);
                match(T__170);
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

    public static class Constantexpression_selectContext extends ParserRuleContext {
        public Token opcode;
        public TypedvalueContext condition;
        public TypedvalueContext op1;
        public TypedvalueContext op2;

        public TypedvalueContext typedvalue(int i) {
            return getRuleContext(TypedvalueContext.class, i);
        }

        public List<TypedvalueContext> typedvalue() {
            return getRuleContexts(TypedvalueContext.class);
        }

        public Constantexpression_selectContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_constantexpression_select;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterConstantexpression_select(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitConstantexpression_select(this);
        }
    }

    public final Constantexpression_selectContext constantexpression_select() throws RecognitionException {
        Constantexpression_selectContext _localctx = new Constantexpression_selectContext(_ctx, getState());
        enterRule(_localctx, 48, RULE_constantexpression_select);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(544);
                ((Constantexpression_selectContext) _localctx).opcode = match(T__177);
                setState(545);
                match(T__149);
                setState(546);
                ((Constantexpression_selectContext) _localctx).condition = typedvalue();
                setState(547);
                match(T__222);
                setState(548);
                ((Constantexpression_selectContext) _localctx).op1 = typedvalue();
                setState(549);
                match(T__222);
                setState(550);
                ((Constantexpression_selectContext) _localctx).op2 = typedvalue();
                setState(551);
                match(T__170);
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

    public static class Constantexpression_compareContext extends ParserRuleContext {
        public TypedvalueContext op1;
        public TypedvalueContext op2;

        public IcmpconditionContext icmpcondition() {
            return getRuleContext(IcmpconditionContext.class, 0);
        }

        public FcmpconditionContext fcmpcondition() {
            return getRuleContext(FcmpconditionContext.class, 0);
        }

        public TypedvalueContext typedvalue(int i) {
            return getRuleContext(TypedvalueContext.class, i);
        }

        public List<TypedvalueContext> typedvalue() {
            return getRuleContexts(TypedvalueContext.class);
        }

        public Constantexpression_compareContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_constantexpression_compare;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterConstantexpression_compare(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitConstantexpression_compare(this);
        }
    }

    public final Constantexpression_compareContext constantexpression_compare() throws RecognitionException {
        Constantexpression_compareContext _localctx = new Constantexpression_compareContext(_ctx, getState());
        enterRule(_localctx, 50, RULE_constantexpression_compare);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(557);
                switch (_input.LA(1)) {
                    case T__135: {
                        setState(553);
                        match(T__135);
                        setState(554);
                        icmpcondition();
                    }
                        break;
                    case T__110: {
                        setState(555);
                        match(T__110);
                        setState(556);
                        fcmpcondition();
                    }
                        break;
                    default:
                        throw new NoViableAltException(this);
                }
                setState(559);
                match(T__149);
                setState(560);
                ((Constantexpression_compareContext) _localctx).op1 = typedvalue();
                setState(561);
                match(T__222);
                setState(562);
                ((Constantexpression_compareContext) _localctx).op2 = typedvalue();
                setState(563);
                match(T__170);
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

    public static class Constantexpression_extractelementContext extends ParserRuleContext {
        public Token opcode;
        public TypedvalueContext vector;
        public TypedvalueContext index;

        public TypedvalueContext typedvalue(int i) {
            return getRuleContext(TypedvalueContext.class, i);
        }

        public List<TypedvalueContext> typedvalue() {
            return getRuleContexts(TypedvalueContext.class);
        }

        public Constantexpression_extractelementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_constantexpression_extractelement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterConstantexpression_extractelement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitConstantexpression_extractelement(this);
        }
    }

    public final Constantexpression_extractelementContext constantexpression_extractelement() throws RecognitionException {
        Constantexpression_extractelementContext _localctx = new Constantexpression_extractelementContext(_ctx, getState());
        enterRule(_localctx, 52, RULE_constantexpression_extractelement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(565);
                ((Constantexpression_extractelementContext) _localctx).opcode = match(T__228);
                setState(566);
                match(T__149);
                setState(567);
                ((Constantexpression_extractelementContext) _localctx).vector = typedvalue();
                setState(568);
                match(T__222);
                setState(569);
                ((Constantexpression_extractelementContext) _localctx).index = typedvalue();
                setState(570);
                match(T__170);
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

    public static class Constantexpression_insertelementContext extends ParserRuleContext {
        public Token opcode;
        public VectortypeContext vectortypeElement;
        public ValuerefContext vector;
        public TypedvalueContext element;
        public TypedvalueContext index;

        public TypedvalueContext typedvalue(int i) {
            return getRuleContext(TypedvalueContext.class, i);
        }

        public List<TypedvalueContext> typedvalue() {
            return getRuleContexts(TypedvalueContext.class);
        }

        public VectortypeContext vectortype() {
            return getRuleContext(VectortypeContext.class, 0);
        }

        public ValuerefContext valueref() {
            return getRuleContext(ValuerefContext.class, 0);
        }

        public Constantexpression_insertelementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_constantexpression_insertelement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterConstantexpression_insertelement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitConstantexpression_insertelement(this);
        }
    }

    public final Constantexpression_insertelementContext constantexpression_insertelement() throws RecognitionException {
        Constantexpression_insertelementContext _localctx = new Constantexpression_insertelementContext(_ctx, getState());
        enterRule(_localctx, 54, RULE_constantexpression_insertelement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(572);
                ((Constantexpression_insertelementContext) _localctx).opcode = match(T__74);
                setState(573);
                match(T__149);
                setState(574);
                ((Constantexpression_insertelementContext) _localctx).vectortypeElement = vectortype();
                setState(575);
                ((Constantexpression_insertelementContext) _localctx).vector = valueref();
                setState(576);
                match(T__222);
                setState(577);
                ((Constantexpression_insertelementContext) _localctx).element = typedvalue();
                setState(578);
                match(T__222);
                setState(579);
                ((Constantexpression_insertelementContext) _localctx).index = typedvalue();
                setState(580);
                match(T__170);
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

    public static class Constantexpression_shufflevectorContext extends ParserRuleContext {
        public Token opcode;
        public TypedvalueContext vector1;
        public TypedvalueContext vector2;
        public TypedvalueContext mask;

        public TypedvalueContext typedvalue(int i) {
            return getRuleContext(TypedvalueContext.class, i);
        }

        public List<TypedvalueContext> typedvalue() {
            return getRuleContexts(TypedvalueContext.class);
        }

        public Constantexpression_shufflevectorContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_constantexpression_shufflevector;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterConstantexpression_shufflevector(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitConstantexpression_shufflevector(this);
        }
    }

    public final Constantexpression_shufflevectorContext constantexpression_shufflevector() throws RecognitionException {
        Constantexpression_shufflevectorContext _localctx = new Constantexpression_shufflevectorContext(_ctx, getState());
        enterRule(_localctx, 56, RULE_constantexpression_shufflevector);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(582);
                ((Constantexpression_shufflevectorContext) _localctx).opcode = match(T__186);
                setState(583);
                match(T__149);
                setState(584);
                ((Constantexpression_shufflevectorContext) _localctx).vector1 = typedvalue();
                setState(585);
                match(T__222);
                setState(586);
                ((Constantexpression_shufflevectorContext) _localctx).vector2 = typedvalue();
                setState(587);
                match(T__222);
                setState(588);
                ((Constantexpression_shufflevectorContext) _localctx).mask = typedvalue();
                setState(589);
                match(T__170);
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

    public static class Constantexpression_extractvalueContext extends ParserRuleContext {
        public Token opcode;
        public TypedvalueContext value;
        public Token Integer;
        public List<Token> indices = new ArrayList<Token>();

        public TerminalNode Integer(int i) {
            return getToken(LLVM_IRParser.Integer, i);
        }

        public List<TerminalNode> Integer() {
            return getTokens(LLVM_IRParser.Integer);
        }

        public TypedvalueContext typedvalue() {
            return getRuleContext(TypedvalueContext.class, 0);
        }

        public Constantexpression_extractvalueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_constantexpression_extractvalue;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterConstantexpression_extractvalue(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitConstantexpression_extractvalue(this);
        }
    }

    public final Constantexpression_extractvalueContext constantexpression_extractvalue() throws RecognitionException {
        Constantexpression_extractvalueContext _localctx = new Constantexpression_extractvalueContext(_ctx, getState());
        enterRule(_localctx, 58, RULE_constantexpression_extractvalue);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(591);
                ((Constantexpression_extractvalueContext) _localctx).opcode = match(T__51);
                setState(592);
                match(T__149);
                setState(593);
                ((Constantexpression_extractvalueContext) _localctx).value = typedvalue();
                setState(596);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(594);
                            match(T__222);
                            setState(595);
                            ((Constantexpression_extractvalueContext) _localctx).Integer = match(Integer);
                            ((Constantexpression_extractvalueContext) _localctx).indices.add(((Constantexpression_extractvalueContext) _localctx).Integer);
                        }
                    }
                    setState(598);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (_la == T__222);
                setState(600);
                match(T__170);
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

    public static class Constantexpression_insertvalueContext extends ParserRuleContext {
        public Token opcode;
        public TypedvalueContext value;
        public TypedvalueContext element;
        public Token Integer;
        public List<Token> indices = new ArrayList<Token>();

        public TerminalNode Integer(int i) {
            return getToken(LLVM_IRParser.Integer, i);
        }

        public TypedvalueContext typedvalue(int i) {
            return getRuleContext(TypedvalueContext.class, i);
        }

        public List<TerminalNode> Integer() {
            return getTokens(LLVM_IRParser.Integer);
        }

        public List<TypedvalueContext> typedvalue() {
            return getRuleContexts(TypedvalueContext.class);
        }

        public Constantexpression_insertvalueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_constantexpression_insertvalue;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterConstantexpression_insertvalue(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitConstantexpression_insertvalue(this);
        }
    }

    public final Constantexpression_insertvalueContext constantexpression_insertvalue() throws RecognitionException {
        Constantexpression_insertvalueContext _localctx = new Constantexpression_insertvalueContext(_ctx, getState());
        enterRule(_localctx, 60, RULE_constantexpression_insertvalue);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(602);
                ((Constantexpression_insertvalueContext) _localctx).opcode = match(T__224);
                setState(603);
                match(T__149);
                setState(604);
                ((Constantexpression_insertvalueContext) _localctx).value = typedvalue();
                setState(605);
                match(T__222);
                setState(606);
                ((Constantexpression_insertvalueContext) _localctx).element = typedvalue();
                setState(609);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(607);
                            match(T__222);
                            setState(608);
                            ((Constantexpression_insertvalueContext) _localctx).Integer = match(Integer);
                            ((Constantexpression_insertvalueContext) _localctx).indices.add(((Constantexpression_insertvalueContext) _localctx).Integer);
                        }
                    }
                    setState(611);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (_la == T__222);
                setState(613);
                match(T__170);
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

    public static class Constantexpression_binaryContext extends ParserRuleContext {
        public Token opcode;
        public TypedvalueContext op1;
        public TypedvalueContext op2;

        public TypedvalueContext typedvalue(int i) {
            return getRuleContext(TypedvalueContext.class, i);
        }

        public List<TypedvalueContext> typedvalue() {
            return getRuleContexts(TypedvalueContext.class);
        }

        public Constantexpression_binaryContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_constantexpression_binary;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterConstantexpression_binary(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitConstantexpression_binary(this);
        }
    }

    public final Constantexpression_binaryContext constantexpression_binary() throws RecognitionException {
        Constantexpression_binaryContext _localctx = new Constantexpression_binaryContext(_ctx, getState());
        enterRule(_localctx, 62, RULE_constantexpression_binary);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(627);
                switch (_input.LA(1)) {
                    case T__210:
                    case T__84:
                    case T__65:
                    case T__15: {
                        {
                            setState(615);
                            ((Constantexpression_binaryContext) _localctx).opcode = _input.LT(1);
                            _la = _input.LA(1);
                            if (!(_la == T__210 || _la == T__84 || _la == T__65 || _la == T__15)) {
                                ((Constantexpression_binaryContext) _localctx).opcode = (Token) _errHandler.recoverInline(this);
                            }
                            consume();
                            {
                                setState(617);
                                _la = _input.LA(1);
                                if (_la == T__150) {
                                    {
                                        setState(616);
                                        match(T__150);
                                    }
                                }

                                setState(620);
                                _la = _input.LA(1);
                                if (_la == T__225) {
                                    {
                                        setState(619);
                                        match(T__225);
                                    }
                                }

                            }
                        }
                    }
                        break;
                    case T__236:
                    case T__133:
                    case T__112:
                    case T__81: {
                        {
                            setState(622);
                            ((Constantexpression_binaryContext) _localctx).opcode = _input.LT(1);
                            _la = _input.LA(1);
                            if (!(_la == T__236 || ((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & ((1L << (T__133 - 107)) | (1L << (T__112 - 107)) | (1L << (T__81 - 107)))) != 0))) {
                                ((Constantexpression_binaryContext) _localctx).opcode = (Token) _errHandler.recoverInline(this);
                            }
                            consume();
                            setState(624);
                            _la = _input.LA(1);
                            if (_la == T__216) {
                                {
                                    setState(623);
                                    match(T__216);
                                }
                            }

                        }
                    }
                        break;
                    case T__226:
                    case T__205:
                    case T__173:
                    case T__169:
                    case T__106:
                    case T__105:
                    case T__102:
                    case T__97:
                    case T__90:
                    case T__22: {
                        setState(626);
                        ((Constantexpression_binaryContext) _localctx).opcode = _input.LT(1);
                        _la = _input.LA(1);
                        if (!(((((_la - 14)) & ~0x3f) == 0 && ((1L << (_la - 14)) & ((1L << (T__226 - 14)) | (1L << (T__205 - 14)) | (1L << (T__173 - 14)) | (1L << (T__169 - 14)))) != 0) ||
                                        ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (T__106 - 134)) | (1L << (T__105 - 134)) | (1L << (T__102 - 134)) | (1L << (T__97 - 134)) | (1L << (T__90 - 134)))) != 0) || _la == T__22)) {
                            ((Constantexpression_binaryContext) _localctx).opcode = (Token) _errHandler.recoverInline(this);
                        }
                        consume();
                    }
                        break;
                    default:
                        throw new NoViableAltException(this);
                }
                setState(629);
                match(T__149);
                setState(630);
                ((Constantexpression_binaryContext) _localctx).op1 = typedvalue();
                setState(631);
                match(T__222);
                setState(632);
                ((Constantexpression_binaryContext) _localctx).op2 = typedvalue();
                setState(633);
                match(T__170);
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

    public static class UndefContext extends ParserRuleContext {
        public UndefContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_undef;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterUndef(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitUndef(this);
        }
    }

    public final UndefContext undef() throws RecognitionException {
        UndefContext _localctx = new UndefContext(_ctx, getState());
        enterRule(_localctx, 64, RULE_undef);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(635);
                match(T__129);
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

    public static class BlockaddressContext extends ParserRuleContext {
        public GlobalvaluerefContext functionElement;
        public BasicblockrefContext basicblockElement;

        public GlobalvaluerefContext globalvalueref() {
            return getRuleContext(GlobalvaluerefContext.class, 0);
        }

        public BasicblockrefContext basicblockref() {
            return getRuleContext(BasicblockrefContext.class, 0);
        }

        public BlockaddressContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_blockaddress;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterBlockaddress(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitBlockaddress(this);
        }
    }

    public final BlockaddressContext blockaddress() throws RecognitionException {
        BlockaddressContext _localctx = new BlockaddressContext(_ctx, getState());
        enterRule(_localctx, 66, RULE_blockaddress);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(637);
                match(T__9);
                setState(638);
                match(T__149);
                setState(639);
                ((BlockaddressContext) _localctx).functionElement = globalvalueref();
                setState(640);
                match(T__222);
                setState(641);
                ((BlockaddressContext) _localctx).basicblockElement = basicblockref();
                setState(642);
                match(T__170);
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

    public static class ZeroinitializerContext extends ParserRuleContext {
        public ZeroinitializerContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_zeroinitializer;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterZeroinitializer(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitZeroinitializer(this);
        }
    }

    public final ZeroinitializerContext zeroinitializer() throws RecognitionException {
        ZeroinitializerContext _localctx = new ZeroinitializerContext(_ctx, getState());
        enterRule(_localctx, 68, RULE_zeroinitializer);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(644);
                match(T__92);
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

    public static class StructureconstantContext extends ParserRuleContext {
        public ConstantlistContext list;
        public Token packed;

        public ConstantlistContext constantlist() {
            return getRuleContext(ConstantlistContext.class, 0);
        }

        public StructureconstantContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_structureconstant;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterStructureconstant(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitStructureconstant(this);
        }
    }

    public final StructureconstantContext structureconstant() throws RecognitionException {
        StructureconstantContext _localctx = new StructureconstantContext(_ctx, getState());
        enterRule(_localctx, 70, RULE_structureconstant);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(658);
                switch (_input.LA(1)) {
                    case T__154: {
                        setState(646);
                        match(T__154);
                        setState(648);
                        _la = _input.LA(1);
                        if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__212) | (1L << T__211) | (1L << T__178))) != 0) ||
                                        ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__157 - 83)) | (1L << (T__154 - 83)) | (1L << (T__140 - 83)) | (1L << (T__118 - 83)))) != 0) ||
                                        ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (T__47 - 193)) | (1L << (Int_type - 193)) | (1L << (Local_id - 193)))) != 0) ||
                                        _la == Floatingtype) {
                            {
                                setState(647);
                                ((StructureconstantContext) _localctx).list = constantlist();
                            }
                        }

                        setState(650);
                        match(T__194);
                    }
                        break;
                    case T__211: {
                        setState(651);
                        ((StructureconstantContext) _localctx).packed = match(T__211);
                        setState(652);
                        match(T__154);
                        setState(654);
                        _la = _input.LA(1);
                        if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__212) | (1L << T__211) | (1L << T__178))) != 0) ||
                                        ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__157 - 83)) | (1L << (T__154 - 83)) | (1L << (T__140 - 83)) | (1L << (T__118 - 83)))) != 0) ||
                                        ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (T__47 - 193)) | (1L << (Int_type - 193)) | (1L << (Local_id - 193)))) != 0) ||
                                        _la == Floatingtype) {
                            {
                                setState(653);
                                ((StructureconstantContext) _localctx).list = constantlist();
                            }
                        }

                        setState(656);
                        match(T__194);
                        setState(657);
                        match(T__8);
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

    public static class ArrayconstantContext extends ParserRuleContext {
        public ConstantlistContext list;

        public ConstantlistContext constantlist() {
            return getRuleContext(ConstantlistContext.class, 0);
        }

        public ArrayconstantContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_arrayconstant;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterArrayconstant(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitArrayconstant(this);
        }
    }

    public final ArrayconstantContext arrayconstant() throws RecognitionException {
        ArrayconstantContext _localctx = new ArrayconstantContext(_ctx, getState());
        enterRule(_localctx, 72, RULE_arrayconstant);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(660);
                match(T__178);
                setState(662);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__212) | (1L << T__211) | (1L << T__178))) != 0) ||
                                ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__157 - 83)) | (1L << (T__154 - 83)) | (1L << (T__140 - 83)) | (1L << (T__118 - 83)))) != 0) ||
                                ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (T__47 - 193)) | (1L << (Int_type - 193)) | (1L << (Local_id - 193)))) != 0) || _la == Floatingtype) {
                    {
                        setState(661);
                        ((ArrayconstantContext) _localctx).list = constantlist();
                    }
                }

                setState(664);
                match(T__208);
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

    public static class VectorconstantContext extends ParserRuleContext {
        public ConstantlistContext list;

        public ConstantlistContext constantlist() {
            return getRuleContext(ConstantlistContext.class, 0);
        }

        public VectorconstantContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_vectorconstant;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterVectorconstant(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitVectorconstant(this);
        }
    }

    public final VectorconstantContext vectorconstant() throws RecognitionException {
        VectorconstantContext _localctx = new VectorconstantContext(_ctx, getState());
        enterRule(_localctx, 74, RULE_vectorconstant);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(666);
                match(T__211);
                setState(668);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__212) | (1L << T__211) | (1L << T__178))) != 0) ||
                                ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__157 - 83)) | (1L << (T__154 - 83)) | (1L << (T__140 - 83)) | (1L << (T__118 - 83)))) != 0) ||
                                ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (T__47 - 193)) | (1L << (Int_type - 193)) | (1L << (Local_id - 193)))) != 0) || _la == Floatingtype) {
                    {
                        setState(667);
                        ((VectorconstantContext) _localctx).list = constantlist();
                    }
                }

                setState(670);
                match(T__8);
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

    public static class ConstantlistContext extends ParserRuleContext {
        public TypedconstantContext typedconstant;
        public List<TypedconstantContext> typedconstants = new ArrayList<TypedconstantContext>();

        public List<TypedconstantContext> typedconstant() {
            return getRuleContexts(TypedconstantContext.class);
        }

        public TypedconstantContext typedconstant(int i) {
            return getRuleContext(TypedconstantContext.class, i);
        }

        public ConstantlistContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_constantlist;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterConstantlist(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitConstantlist(this);
        }
    }

    public final ConstantlistContext constantlist() throws RecognitionException {
        ConstantlistContext _localctx = new ConstantlistContext(_ctx, getState());
        enterRule(_localctx, 76, RULE_constantlist);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(672);
                ((ConstantlistContext) _localctx).typedconstant = typedconstant();
                ((ConstantlistContext) _localctx).typedconstants.add(((ConstantlistContext) _localctx).typedconstant);
                setState(677);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__222) {
                    {
                        {
                            setState(673);
                            match(T__222);
                            setState(674);
                            ((ConstantlistContext) _localctx).typedconstant = typedconstant();
                            ((ConstantlistContext) _localctx).typedconstants.add(((ConstantlistContext) _localctx).typedconstant);
                        }
                    }
                    setState(679);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
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

    public static class TypedconstantContext extends ParserRuleContext {
        public ConstantContext constant() {
            return getRuleContext(ConstantContext.class, 0);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public TypedconstantContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_typedconstant;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterTypedconstant(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitTypedconstant(this);
        }
    }

    public final TypedconstantContext typedconstant() throws RecognitionException {
        TypedconstantContext _localctx = new TypedconstantContext(_ctx, getState());
        enterRule(_localctx, 78, RULE_typedconstant);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(680);
                type();
                setState(681);
                constant();
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

    public static class SimpleconstantContext extends ParserRuleContext {
        public Token resultToken;
        public Token Integer;
        public Token Signed_int;
        public Token Float;
        public Token Boolean;
        public Token Null;
        public Token Cstring;

        public TerminalNode Cstring() {
            return getToken(LLVM_IRParser.Cstring, 0);
        }

        public TerminalNode Signed_int() {
            return getToken(LLVM_IRParser.Signed_int, 0);
        }

        public TerminalNode Integer() {
            return getToken(LLVM_IRParser.Integer, 0);
        }

        public TerminalNode Float() {
            return getToken(LLVM_IRParser.Float, 0);
        }

        public TerminalNode Null() {
            return getToken(LLVM_IRParser.Null, 0);
        }

        public TerminalNode Boolean() {
            return getToken(LLVM_IRParser.Boolean, 0);
        }

        public SimpleconstantContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_simpleconstant;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterSimpleconstant(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitSimpleconstant(this);
        }
    }

    public final SimpleconstantContext simpleconstant() throws RecognitionException {
        SimpleconstantContext _localctx = new SimpleconstantContext(_ctx, getState());
        enterRule(_localctx, 80, RULE_simpleconstant);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(695);
                switch (_input.LA(1)) {
                    case Integer: {
                        setState(683);
                        ((SimpleconstantContext) _localctx).Integer = match(Integer);
                        ((SimpleconstantContext) _localctx).resultToken = ((SimpleconstantContext) _localctx).Integer;
                    }
                        break;
                    case Signed_int: {
                        setState(685);
                        ((SimpleconstantContext) _localctx).Signed_int = match(Signed_int);
                        ((SimpleconstantContext) _localctx).resultToken = ((SimpleconstantContext) _localctx).Signed_int;
                    }
                        break;
                    case Float: {
                        setState(687);
                        ((SimpleconstantContext) _localctx).Float = match(Float);

                        ((SimpleconstantContext) _localctx).resultToken = ((SimpleconstantContext) _localctx).Float;
                    }
                        break;
                    case Boolean: {
                        setState(689);
                        ((SimpleconstantContext) _localctx).Boolean = match(Boolean);
                        ((SimpleconstantContext) _localctx).resultToken = ((SimpleconstantContext) _localctx).Boolean;

                    }
                        break;
                    case Null: {
                        setState(691);
                        ((SimpleconstantContext) _localctx).Null = match(Null);
                        ((SimpleconstantContext) _localctx).resultToken = ((SimpleconstantContext) _localctx).Null;
                    }
                        break;
                    case Cstring: {
                        setState(693);
                        ((SimpleconstantContext) _localctx).Cstring = match(Cstring);
                        ((SimpleconstantContext) _localctx).resultToken = ((SimpleconstantContext) _localctx).Cstring;
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

    public static class MetadatanodeContext extends ParserRuleContext {
        public MetadatanodeelementContext metadatanodeelement;
        public List<MetadatanodeelementContext> elements = new ArrayList<MetadatanodeelementContext>();

        public MetadatanodeelementContext metadatanodeelement(int i) {
            return getRuleContext(MetadatanodeelementContext.class, i);
        }

        public List<MetadatanodeelementContext> metadatanodeelement() {
            return getRuleContexts(MetadatanodeelementContext.class);
        }

        public MetadatanodeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_metadatanode;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterMetadatanode(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitMetadatanode(this);
        }
    }

    public final MetadatanodeContext metadatanode() throws RecognitionException {
        MetadatanodeContext _localctx = new MetadatanodeContext(_ctx, getState());
        enterRule(_localctx, 82, RULE_metadatanode);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(697);
                match(T__55);
                setState(698);
                match(T__154);
                setState(707);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__212) | (1L << T__211) | (1L << T__178))) != 0) ||
                                ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__157 - 83)) | (1L << (T__154 - 83)) | (1L << (T__140 - 83)) | (1L << (T__118 - 83)))) != 0) ||
                                ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (T__47 - 193)) | (1L << (Null - 193)) | (1L << (Int_type - 193)) | (1L << (Local_id - 193)) |
                                                (1L << (Meta_int - 193)) | (1L << (Meta_name - 193)))) != 0) || _la == Floatingtype) {
                    {
                        setState(699);
                        ((MetadatanodeContext) _localctx).metadatanodeelement = metadatanodeelement();
                        ((MetadatanodeContext) _localctx).elements.add(((MetadatanodeContext) _localctx).metadatanodeelement);
                        setState(704);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == T__222) {
                            {
                                {
                                    setState(700);
                                    match(T__222);
                                    setState(701);
                                    ((MetadatanodeContext) _localctx).metadatanodeelement = metadatanodeelement();
                                    ((MetadatanodeContext) _localctx).elements.add(((MetadatanodeContext) _localctx).metadatanodeelement);
                                }
                            }
                            setState(706);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                    }
                }

                setState(709);
                match(T__194);
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

    public static class MetadatanodeelementContext extends ParserRuleContext {
        public MetadatarefContext metadataref() {
            return getRuleContext(MetadatarefContext.class, 0);
        }

        public TypedvalueContext typedvalue() {
            return getRuleContext(TypedvalueContext.class, 0);
        }

        public TerminalNode Null() {
            return getToken(LLVM_IRParser.Null, 0);
        }

        public MetadatanodeelementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_metadatanodeelement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterMetadatanodeelement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitMetadatanodeelement(this);
        }
    }

    public final MetadatanodeelementContext metadatanodeelement() throws RecognitionException {
        MetadatanodeelementContext _localctx = new MetadatanodeelementContext(_ctx, getState());
        enterRule(_localctx, 84, RULE_metadatanodeelement);
        try {
            setState(714);
            switch (_input.LA(1)) {
                case T__212:
                case T__211:
                case T__178:
                case T__157:
                case T__154:
                case T__140:
                case T__118:
                case T__47:
                case Int_type:
                case Local_id:
                case Floatingtype:
                    enterOuterAlt(_localctx, 1);
                    {
                        {
                            setState(711);
                            typedvalue();
                        }
                    }
                    break;
                case Meta_int:
                case Meta_name:
                    enterOuterAlt(_localctx, 2);
                    {
                        {
                            setState(712);
                            metadataref();
                        }
                    }
                    break;
                case Null:
                    enterOuterAlt(_localctx, 3);
                    {
                        setState(713);
                        match(Null);
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

    public static class MetadatastringContext extends ParserRuleContext {
        public Token name;

        public TerminalNode Metadata_string() {
            return getToken(LLVM_IRParser.Metadata_string, 0);
        }

        public MetadatastringContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_metadatastring;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterMetadatastring(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitMetadatastring(this);
        }
    }

    public final MetadatastringContext metadatastring() throws RecognitionException {
        MetadatastringContext _localctx = new MetadatastringContext(_ctx, getState());
        enterRule(_localctx, 86, RULE_metadatastring);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(716);
                ((MetadatastringContext) _localctx).name = match(Metadata_string);
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

    public static class TlsmodelContext extends ParserRuleContext {
        public TlsoptionContext tlsoption() {
            return getRuleContext(TlsoptionContext.class, 0);
        }

        public TlsmodelContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_tlsmodel;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterTlsmodel(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitTlsmodel(this);
        }
    }

    public final TlsmodelContext tlsmodel() throws RecognitionException {
        TlsmodelContext _localctx = new TlsmodelContext(_ctx, getState());
        enterRule(_localctx, 88, RULE_tlsmodel);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(718);
                match(T__17);
                setState(719);
                match(T__149);
                setState(720);
                tlsoption();
                setState(721);
                match(T__170);
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

    public static class TlsoptionContext extends ParserRuleContext {
        public TlsoptionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_tlsoption;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterTlsoption(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitTlsoption(this);
        }
    }

    public final TlsoptionContext tlsoption() throws RecognitionException {
        TlsoptionContext _localctx = new TlsoptionContext(_ctx, getState());
        enterRule(_localctx, 90, RULE_tlsoption);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(723);
                _la = _input.LA(1);
                if (!(_la == T__161 || _la == T__44 || _la == T__21)) {
                    _errHandler.recoverInline(this);
                }
                consume();
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

    public static class AddressspaceContext extends ParserRuleContext {
        public Token value;

        public TerminalNode Integer() {
            return getToken(LLVM_IRParser.Integer, 0);
        }

        public AddressspaceContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_addressspace;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterAddressspace(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitAddressspace(this);
        }
    }

    public final AddressspaceContext addressspace() throws RecognitionException {
        AddressspaceContext _localctx = new AddressspaceContext(_ctx, getState());
        enterRule(_localctx, 92, RULE_addressspace);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(725);
                match(T__7);
                setState(726);
                match(T__149);
                setState(727);
                ((AddressspaceContext) _localctx).value = match(Integer);
                setState(728);
                match(T__170);
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

    public static class SectionContext extends ParserRuleContext {
        public TerminalNode String() {
            return getToken(LLVM_IRParser.String, 0);
        }

        public SectionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_section;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterSection(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitSection(this);
        }
    }

    public final SectionContext section() throws RecognitionException {
        SectionContext _localctx = new SectionContext(_ctx, getState());
        enterRule(_localctx, 94, RULE_section);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(730);
                match(T__223);
                setState(731);
                match(String);
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

    public static class AlignContext extends ParserRuleContext {
        public Token result;
        public Token Integer;

        public TerminalNode Integer() {
            return getToken(LLVM_IRParser.Integer, 0);
        }

        public AlignContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_align;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterAlign(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitAlign(this);
        }
    }

    public final AlignContext align() throws RecognitionException {
        AlignContext _localctx = new AlignContext(_ctx, getState());
        enterRule(_localctx, 96, RULE_align);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(733);
                match(T__10);
                setState(734);
                ((AlignContext) _localctx).Integer = match(Integer);

                ((AlignContext) _localctx).result = ((AlignContext) _localctx).Integer;

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

    public static class GcContext extends ParserRuleContext {
        public TerminalNode String() {
            return getToken(LLVM_IRParser.String, 0);
        }

        public GcContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_gc;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterGc(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitGc(this);
        }
    }

    public final GcContext gc() throws RecognitionException {
        GcContext _localctx = new GcContext(_ctx, getState());
        enterRule(_localctx, 98, RULE_gc);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(737);
                match(T__143);
                setState(738);
                match(String);
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

    public static class FunctionContext extends ParserRuleContext {
        public FunctiondeclContext functiondecl() {
            return getRuleContext(FunctiondeclContext.class, 0);
        }

        public FunctiondefContext functiondef() {
            return getRuleContext(FunctiondefContext.class, 0);
        }

        public FunctionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_function;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterFunction(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitFunction(this);
        }
    }

    public final FunctionContext function() throws RecognitionException {
        FunctionContext _localctx = new FunctionContext(_ctx, getState());
        enterRule(_localctx, 100, RULE_function);
        try {
            setState(742);
            switch (_input.LA(1)) {
                case T__59:
                    enterOuterAlt(_localctx, 1);
                    {
                        setState(740);
                        functiondef();
                    }
                    break;
                case T__147:
                    enterOuterAlt(_localctx, 2);
                    {
                        setState(741);
                        functiondecl();
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

    public static class FunctiondefContext extends ParserRuleContext {
        public FunctionheaderContext header;
        public Token startblockToken;
        public BasicblockContext basicblocks;
        public Token endblockToken;

        public FunctionheaderContext functionheader() {
            return getRuleContext(FunctionheaderContext.class, 0);
        }

        public BasicblockContext basicblock(int i) {
            return getRuleContext(BasicblockContext.class, i);
        }

        public List<BasicblockContext> basicblock() {
            return getRuleContexts(BasicblockContext.class);
        }

        public FunctiondefContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_functiondef;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterFunctiondef(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitFunctiondef(this);
        }
    }

    public final FunctiondefContext functiondef() throws RecognitionException {
        FunctiondefContext _localctx = new FunctiondefContext(_ctx, getState());
        enterRule(_localctx, 102, RULE_functiondef);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(744);
                match(T__59);

                thenList = new ArrayList();
                elseList = new ArrayList();
                thenElse = new HashMap<String, String>();

                setState(746);
                ((FunctiondefContext) _localctx).header = functionheader();
                setState(747);
                ((FunctiondefContext) _localctx).startblockToken = match(T__154);

                List<LlvmStatementNode> list = new ArrayList();
                BlockStart = ((FunctiondefContext) _localctx).startblockToken.getStartIndex() + 2;
                factory.startBlock();

                setState(752);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(749);
                            ((FunctiondefContext) _localctx).basicblocks = basicblock();

                            if (((FunctiondefContext) _localctx).basicblocks.result != null) {
                                list.addAll(((FunctiondefContext) _localctx).basicblocks.result);
                            }

                        }
                    }
                    setState(754);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__236) | (1L << T__234) | (1L << T__228) | (1L << T__226) | (1L << T__224) | (1L << T__215) | (1L << T__213) |
                                (1L << T__210) | (1L << T__205) | (1L << T__204) | (1L << T__198) | (1L << T__191) | (1L << T__190) | (1L << T__189) | (1L << T__186) | (1L << T__184) | (1L << T__181) | (1L << T__177))) != 0) ||
                                ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__173 - 67)) | (1L << (T__169 - 67)) | (1L << (T__146 - 67)) | (1L << (T__139 - 67)) |
                                                (1L << (T__135 - 67)) | (1L << (T__133 - 67)) | (1L << (T__126 - 67)) | (1L << (T__124 - 67)) | (1L << (T__121 - 67)) | (1L << (T__119 - 67)) |
                                                (1L << (T__117 - 67)) | (1L << (T__112 - 67)) | (1L << (T__111 - 67)) | (1L << (T__110 - 67)))) != 0) ||
                                ((((_la - 134)) & ~0x3f) == 0 && ((1L << (_la - 134)) & ((1L << (T__106 - 134)) | (1L << (T__105 - 134)) | (1L << (T__104 - 134)) | (1L << (T__103 - 134)) |
                                                (1L << (T__102 - 134)) | (1L << (T__97 - 134)) | (1L << (T__90 - 134)) | (1L << (T__85 - 134)) | (1L << (T__84 - 134)) | (1L << (T__81 - 134)) |
                                                (1L << (T__79 - 134)) | (1L << (T__74 - 134)) | (1L << (T__65 - 134)) | (1L << (T__64 - 134)) | (1L << (T__62 - 134)) | (1L << (T__54 - 134)) |
                                                (1L << (T__52 - 134)) | (1L << (T__51 - 134)))) != 0) ||
                                ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & ((1L << (T__42 - 198)) | (1L << (T__29 - 198)) | (1L << (T__28 - 198)) | (1L << (T__25 - 198)) |
                                                (1L << (T__22 - 198)) | (1L << (T__15 - 198)) | (1L << (T__13 - 198)) | (1L << (T__11 - 198)) | (1L << (Local_id - 198)) | (1L << (Basic_block_id - 198)))) != 0));
                setState(756);
                ((FunctiondefContext) _localctx).endblockToken = match(T__194);

                BlockEnd = ((FunctiondefContext) _localctx).endblockToken.getStartIndex() - 4;
                LlvmStatementNode result = factory.finishBlock(list, BlockStart, BlockEnd - BlockStart);
                factory.finishFunction(result);

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

    public static class FunctiondeclContext extends ParserRuleContext {
        public FunctionheaderContext header;

        public FunctionheaderContext functionheader() {
            return getRuleContext(FunctionheaderContext.class, 0);
        }

        public FunctiondeclContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_functiondecl;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterFunctiondecl(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitFunctiondecl(this);
        }
    }

    public final FunctiondeclContext functiondecl() throws RecognitionException {
        FunctiondeclContext _localctx = new FunctiondeclContext(_ctx, getState());
        enterRule(_localctx, 104, RULE_functiondecl);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(759);
                match(T__147);
                setState(760);
                ((FunctiondeclContext) _localctx).header = functionheader();
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

    public static class FunctionheaderContext extends ParserRuleContext {
        public Token Global_id;
        public Token startindex;

        public TerminalNode Visibility() {
            return getToken(LLVM_IRParser.Visibility, 0);
        }

        public ParameterattributesContext parameterattributes() {
            return getRuleContext(ParameterattributesContext.class, 0);
        }

        public CconvContext cconv() {
            return getRuleContext(CconvContext.class, 0);
        }

        public ParametersContext parameters() {
            return getRuleContext(ParametersContext.class, 0);
        }

        public AlignContext align() {
            return getRuleContext(AlignContext.class, 0);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public FunctionattributesContext functionattributes() {
            return getRuleContext(FunctionattributesContext.class, 0);
        }

        public FunctionprefixContext functionprefix() {
            return getRuleContext(FunctionprefixContext.class, 0);
        }

        public TerminalNode Global_id() {
            return getToken(LLVM_IRParser.Global_id, 0);
        }

        public GcContext gc() {
            return getRuleContext(GcContext.class, 0);
        }

        public SectionContext section() {
            return getRuleContext(SectionContext.class, 0);
        }

        public LinkageContext linkage() {
            return getRuleContext(LinkageContext.class, 0);
        }

        public FunctionheaderContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_functionheader;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterFunctionheader(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitFunctionheader(this);
        }
    }

    public final FunctionheaderContext functionheader() throws RecognitionException {
        FunctionheaderContext _localctx = new FunctionheaderContext(_ctx, getState());
        enterRule(_localctx, 106, RULE_functionheader);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(763);
                _la = _input.LA(1);
                if (((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & ((1L << (T__230 - 10)) | (1L << (T__229 - 10)) | (1L << (T__227 - 10)) | (1L << (T__188 - 10)) | (1L << (T__180 - 10)) | (1L << (T__176 - 10)))) != 0) ||
                                ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & ((1L << (T__162 - 78)) | (1L << (T__148 - 78)) | (1L << (T__144 - 78)) | (1L << (T__109 - 78)) |
                                                (1L << (T__108 - 78)) | (1L << (T__99 - 78)))) != 0) ||
                                ((((_la - 169)) & ~0x3f) == 0 && ((1L << (_la - 169)) & ((1L << (T__71 - 169)) | (1L << (T__60 - 169)) | (1L << (T__40 - 169)) | (1L << (T__18 - 169)))) != 0)) {
                    {
                        setState(762);
                        linkage();
                    }
                }

                setState(766);
                _la = _input.LA(1);
                if (_la == Visibility) {
                    {
                        setState(765);
                        match(Visibility);
                    }
                }

                setState(769);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__233) | (1L << T__200) | (1L << T__193) | (1L << T__192) | (1L << T__183))) != 0) ||
                                ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (T__175 - 65)) | (1L << (T__172 - 65)) | (1L << (T__166 - 65)) | (1L << (T__163 - 65)) |
                                                (1L << (T__152 - 65)) | (1L << (T__136 - 65)) | (1L << (T__130 - 65)) | (1L << (T__125 - 65)))) != 0) ||
                                ((((_la - 140)) & ~0x3f) == 0 && ((1L << (_la - 140)) & ((1L << (T__100 - 140)) | (1L << (T__76 - 140)) | (1L << (T__46 - 140)) | (1L << (T__41 - 140)))) != 0) ||
                                ((((_la - 205)) & ~0x3f) == 0 && ((1L << (_la - 205)) & ((1L << (T__35 - 205)) | (1L << (T__33 - 205)) | (1L << (T__31 - 205)) | (1L << (T__24 - 205)) | (1L << (T__20 - 205)))) != 0)) {
                    {
                        setState(768);
                        cconv();
                    }
                }

                setState(772);
                _la = _input.LA(1);
                if (_la == T__156) {
                    {
                        setState(771);
                        match(T__156);
                    }
                }

                setState(775);
                _la = _input.LA(1);
                if (((((_la - 33)) & ~0x3f) == 0 && ((1L << (_la - 33)) & ((1L << (T__207 - 33)) | (1L << (T__203 - 33)) | (1L << (T__202 - 33)) | (1L << (T__171 - 33)) | (1L << (T__165 - 33)))) != 0) ||
                                ((((_la - 98)) & ~0x3f) == 0 && ((1L << (_la - 98)) & ((1L << (T__142 - 98)) | (1L << (T__114 - 98)) | (1L << (T__83 - 98)))) != 0) || _la == T__58 || _la == T__3) {
                    {
                        setState(774);
                        parameterattributes();
                    }
                }

                setState(777);
                type();
                setState(778);
                ((FunctionheaderContext) _localctx).Global_id = match(Global_id);
                setState(779);
                ((FunctionheaderContext) _localctx).startindex = match(T__149);

                int functionStartPos = ((FunctionheaderContext) _localctx).startindex.getStartIndex();
                factory.startFunction(((FunctionheaderContext) _localctx).Global_id, functionStartPos);

                setState(782);
                switch (getInterpreter().adaptivePredict(_input, 57, _ctx)) {
                    case 1: {
                        setState(781);
                        parameters();
                    }
                        break;
                }
                setState(784);
                match(T__170);
                setState(786);
                switch (getInterpreter().adaptivePredict(_input, 58, _ctx)) {
                    case 1: {
                        setState(785);
                        functionattributes();
                    }
                        break;
                }
                setState(789);
                _la = _input.LA(1);
                if (_la == T__223) {
                    {
                        setState(788);
                        section();
                    }
                }

                setState(792);
                _la = _input.LA(1);
                if (_la == T__10) {
                    {
                        setState(791);
                        align();
                    }
                }

                setState(795);
                _la = _input.LA(1);
                if (_la == T__143) {
                    {
                        setState(794);
                        gc();
                    }
                }

                setState(798);
                _la = _input.LA(1);
                if (_la == T__167) {
                    {
                        setState(797);
                        functionprefix();
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

    public static class FunctionprefixContext extends ParserRuleContext {
        public TypedconstantContext value;

        public TypedconstantContext typedconstant() {
            return getRuleContext(TypedconstantContext.class, 0);
        }

        public FunctionprefixContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_functionprefix;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterFunctionprefix(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitFunctionprefix(this);
        }
    }

    public final FunctionprefixContext functionprefix() throws RecognitionException {
        FunctionprefixContext _localctx = new FunctionprefixContext(_ctx, getState());
        enterRule(_localctx, 108, RULE_functionprefix);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(800);
                match(T__167);
                setState(801);
                ((FunctionprefixContext) _localctx).value = typedconstant();
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

    public static class ParametersContext extends ParserRuleContext {
        public Token pa1;
        public Token pa2;
        public Token vararg;

        public TypeContext type(int i) {
            return getRuleContext(TypeContext.class, i);
        }

        public List<TerminalNode> Local_id() {
            return getTokens(LLVM_IRParser.Local_id);
        }

        public List<TypeContext> type() {
            return getRuleContexts(TypeContext.class);
        }

        public TerminalNode Local_id(int i) {
            return getToken(LLVM_IRParser.Local_id, i);
        }

        public ParametersContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_parameters;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterParameters(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitParameters(this);
        }
    }

    public final ParametersContext parameters() throws RecognitionException {
        ParametersContext _localctx = new ParametersContext(_ctx, getState());
        enterRule(_localctx, 110, RULE_parameters);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(823);
                switch (_input.LA(1)) {
                    case T__212:
                    case T__211:
                    case T__178:
                    case T__170:
                    case T__157:
                    case T__154:
                    case T__140:
                    case T__118:
                    case T__47:
                    case Int_type:
                    case Local_id:
                    case Floatingtype: {
                        setState(820);
                        _la = _input.LA(1);
                        if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__212) | (1L << T__211) | (1L << T__178))) != 0) ||
                                        ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__157 - 83)) | (1L << (T__154 - 83)) | (1L << (T__140 - 83)) | (1L << (T__118 - 83)))) != 0) ||
                                        ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (T__47 - 193)) | (1L << (Int_type - 193)) | (1L << (Local_id - 193)))) != 0) ||
                                        _la == Floatingtype) {
                            {
                                setState(803);
                                type();
                                setState(804);
                                ((ParametersContext) _localctx).pa1 = match(Local_id);

                                factory.addFormalParameter(((ParametersContext) _localctx).pa1);

                                setState(813);
                                _errHandler.sync(this);
                                _alt = getInterpreter().adaptivePredict(_input, 63, _ctx);
                                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                                    if (_alt == 1) {
                                        {
                                            {
                                                setState(806);
                                                match(T__222);
                                                setState(807);
                                                type();
                                                setState(808);
                                                ((ParametersContext) _localctx).pa2 = match(Local_id);

                                                factory.addFormalParameter(((ParametersContext) _localctx).pa2);

                                            }
                                        }
                                    }
                                    setState(815);
                                    _errHandler.sync(this);
                                    _alt = getInterpreter().adaptivePredict(_input, 63, _ctx);
                                }
                                setState(818);
                                _la = _input.LA(1);
                                if (_la == T__222) {
                                    {
                                        setState(816);
                                        match(T__222);
                                        setState(817);
                                        ((ParametersContext) _localctx).vararg = match(T__14);
                                    }
                                }

                            }
                        }

                    }
                        break;
                    case T__14: {
                        setState(822);
                        ((ParametersContext) _localctx).vararg = match(T__14);
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

    public static class FunctionattributesContext extends ParserRuleContext {
        public Token Integer;
        public List<Token> alignstackvalue = new ArrayList<Token>();

        public List<AttributegroupContext> attributegroup() {
            return getRuleContexts(AttributegroupContext.class);
        }

        public TerminalNode Attribute_id(int i) {
            return getToken(LLVM_IRParser.Attribute_id, i);
        }

        public TerminalNode Integer(int i) {
            return getToken(LLVM_IRParser.Integer, i);
        }

        public List<FunctionattributeContext> functionattribute() {
            return getRuleContexts(FunctionattributeContext.class);
        }

        public List<TerminalNode> Integer() {
            return getTokens(LLVM_IRParser.Integer);
        }

        public List<TerminalNode> Attribute_id() {
            return getTokens(LLVM_IRParser.Attribute_id);
        }

        public FunctionattributeContext functionattribute(int i) {
            return getRuleContext(FunctionattributeContext.class, i);
        }

        public List<AlignstackContext> alignstack() {
            return getRuleContexts(AlignstackContext.class);
        }

        public AlignstackContext alignstack(int i) {
            return getRuleContext(AlignstackContext.class, i);
        }

        public AttributegroupContext attributegroup(int i) {
            return getRuleContext(AttributegroupContext.class, i);
        }

        public FunctionattributesContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_functionattributes;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterFunctionattributes(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitFunctionattributes(this);
        }
    }

    public final FunctionattributesContext functionattributes() throws RecognitionException {
        FunctionattributesContext _localctx = new FunctionattributesContext(_ctx, getState());
        enterRule(_localctx, 112, RULE_functionattributes);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(845);
                _errHandler.sync(this);
                _alt = 1;
                do {
                    switch (_alt) {
                        case 1: {
                            setState(845);
                            switch (_input.LA(1)) {
                                case T__231:
                                case T__214:
                                case T__206:
                                case T__201:
                                case T__168:
                                case T__164:
                                case T__159:
                                case T__132:
                                case T__120:
                                case T__115:
                                case T__113:
                                case T__94:
                                case T__87:
                                case T__82:
                                case T__70:
                                case T__68:
                                case T__61:
                                case T__57:
                                case T__56:
                                case T__45:
                                case T__43:
                                case T__39:
                                case T__37:
                                case T__36:
                                case T__19:
                                case T__12:
                                case T__5:
                                case T__1: {
                                    setState(826);
                                    _errHandler.sync(this);
                                    _alt = 1;
                                    do {
                                        switch (_alt) {
                                            case 1: {
                                                {
                                                    setState(825);
                                                    functionattribute();
                                                }
                                            }
                                                break;
                                            default:
                                                throw new NoViableAltException(this);
                                        }
                                        setState(828);
                                        _errHandler.sync(this);
                                        _alt = getInterpreter().adaptivePredict(_input, 67, _ctx);
                                    } while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
                                }
                                    break;
                                case T__30: {
                                    {
                                        setState(831);
                                        _errHandler.sync(this);
                                        _la = _input.LA(1);
                                        do {
                                            {
                                                {
                                                    setState(830);
                                                    alignstack();
                                                }
                                            }
                                            setState(833);
                                            _errHandler.sync(this);
                                            _la = _input.LA(1);
                                        } while (_la == T__30);
                                        setState(835);
                                        match(T__149);
                                        setState(836);
                                        ((FunctionattributesContext) _localctx).Integer = match(Integer);
                                        ((FunctionattributesContext) _localctx).alignstackvalue.add(((FunctionattributesContext) _localctx).Integer);
                                        setState(837);
                                        match(T__170);
                                    }
                                }
                                    break;
                                case T__77:
                                case Attribute_id: {
                                    setState(841);
                                    _errHandler.sync(this);
                                    _alt = 1;
                                    do {
                                        switch (_alt) {
                                            case 1: {
                                                setState(841);
                                                switch (_input.LA(1)) {
                                                    case T__77: {
                                                        setState(839);
                                                        attributegroup();
                                                    }
                                                        break;
                                                    case Attribute_id: {
                                                        setState(840);
                                                        match(Attribute_id);
                                                    }
                                                        break;
                                                    default:
                                                        throw new NoViableAltException(this);
                                                }
                                            }
                                                break;
                                            default:
                                                throw new NoViableAltException(this);
                                        }
                                        setState(843);
                                        _errHandler.sync(this);
                                        _alt = getInterpreter().adaptivePredict(_input, 70, _ctx);
                                    } while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
                                }
                                    break;
                                default:
                                    throw new NoViableAltException(this);
                            }
                        }
                            break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    setState(847);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 72, _ctx);
                } while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
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

    public static class AlignstackContext extends ParserRuleContext {
        public AlignstackContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_alignstack;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterAlignstack(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitAlignstack(this);
        }
    }

    public final AlignstackContext alignstack() throws RecognitionException {
        AlignstackContext _localctx = new AlignstackContext(_ctx, getState());
        enterRule(_localctx, 114, RULE_alignstack);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(849);
                match(T__30);
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

    public static class FunctionattributeContext extends ParserRuleContext {
        public Token attribute;

        public FunctionattributeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_functionattribute;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterFunctionattribute(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitFunctionattribute(this);
        }
    }

    public final FunctionattributeContext functionattribute() throws RecognitionException {
        FunctionattributeContext _localctx = new FunctionattributeContext(_ctx, getState());
        enterRule(_localctx, 116, RULE_functionattribute);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(851);
                ((FunctionattributeContext) _localctx).attribute = _input.LT(1);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__231) | (1L << T__214) | (1L << T__206) | (1L << T__201))) != 0) ||
                                ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (T__168 - 72)) | (1L << (T__164 - 72)) | (1L << (T__159 - 72)) | (1L << (T__132 - 72)) |
                                                (1L << (T__120 - 72)) | (1L << (T__115 - 72)) | (1L << (T__113 - 72)))) != 0) ||
                                ((((_la - 146)) & ~0x3f) == 0 && ((1L << (_la - 146)) & ((1L << (T__94 - 146)) | (1L << (T__87 - 146)) | (1L << (T__82 - 146)) | (1L << (T__70 - 146)) |
                                                (1L << (T__68 - 146)) | (1L << (T__61 - 146)) | (1L << (T__57 - 146)) | (1L << (T__56 - 146)) | (1L << (T__45 - 146)) | (1L << (T__43 - 146)) |
                                                (1L << (T__39 - 146)) | (1L << (T__37 - 146)) | (1L << (T__36 - 146)))) != 0) || ((((_la - 221)) & ~0x3f) == 0 && ((1L << (_la - 221)) & ((1L << (T__19 - 221)) |
                                (1L << (T__12 - 221)) | (1L << (T__5 - 221)) | (1L << (T__1 - 221)))) != 0))) {
                    ((FunctionattributeContext) _localctx).attribute = (Token) _errHandler.recoverInline(this);
                }
                consume();
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

    public static class BasicblockContext extends ParserRuleContext {
        public List<LlvmStatementNode> result;
        public BasicblocknameContext name;
        public StartinginstructionContext startingList;
        public MiddleinstructionContext middleList;
        public MiddleinstructionContext middleinstruction;
        public TerminatorinstructionContext terminatorList;

        public MiddleinstructionContext middleinstruction(int i) {
            return getRuleContext(MiddleinstructionContext.class, i);
        }

        public BasicblocknameContext basicblockname() {
            return getRuleContext(BasicblocknameContext.class, 0);
        }

        public List<StartinginstructionContext> startinginstruction() {
            return getRuleContexts(StartinginstructionContext.class);
        }

        public TerminatorinstructionContext terminatorinstruction() {
            return getRuleContext(TerminatorinstructionContext.class, 0);
        }

        public List<MiddleinstructionContext> middleinstruction() {
            return getRuleContexts(MiddleinstructionContext.class);
        }

        public StartinginstructionContext startinginstruction(int i) {
            return getRuleContext(StartinginstructionContext.class, i);
        }

        public BasicblockContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_basicblock;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterBasicblock(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitBasicblock(this);
        }
    }

    public final BasicblockContext basicblock() throws RecognitionException {
        BasicblockContext _localctx = new BasicblockContext(_ctx, getState());
        enterRule(_localctx, 118, RULE_basicblock);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {

                List<LlvmStatementNode> list = new ArrayList();

                setState(854);
                ((BasicblockContext) _localctx).name = basicblockname();
                setState(860);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 73, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(855);
                                ((BasicblockContext) _localctx).startingList = startinginstruction();

                                list.add(((BasicblockContext) _localctx).startingList.result);

                            }
                        }
                    }
                    setState(862);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 73, _ctx);
                }
                setState(868);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 74, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(863);
                                ((BasicblockContext) _localctx).middleList = ((BasicblockContext) _localctx).middleinstruction = middleinstruction();

                                if (((BasicblockContext) _localctx).middleinstruction.result != null)
                                    list.add(((BasicblockContext) _localctx).middleList.result);

                            }
                        }
                    }
                    setState(870);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 74, _ctx);
                }
                setState(871);
                ((BasicblockContext) _localctx).terminatorList = terminatorinstruction();

                if (((BasicblockContext) _localctx).terminatorList.result != null) {
                    list.add(((BasicblockContext) _localctx).terminatorList.result);
                }
                if (((BasicblockContext) _localctx).name.resultToken != null) {
                    int length = ((BasicblockContext) _localctx).terminatorList.resultToken.getStartIndex();
                    CommonToken resultCommon = (CommonToken) ((BasicblockContext) _localctx).name.resultToken;
                    String str = "%" + resultCommon.getText().subSequence(0, resultCommon.getText().length() - 1);
                    resultCommon.setText(str);
                    LlvmStatementNode blockNode = factory.createBasicBlockNode(resultCommon, list, ((BasicblockContext) _localctx).name.resultToken.getStartIndex(), length -
                                    ((BasicblockContext) _localctx).name.resultToken.getStartIndex());
                    if (blockMap.containsKey(str + "then") && blockMap.get(str + "then") == null) {
                        blockMap.put(str + "then", blockNode);
                        // count--;
                        ifstartToken = ((BasicblockContext) _localctx).name.resultToken;
                        thenStr = str;
                        thenList.add(str);
                        // not contains the else part in the If-sentence;
                        // isContainsElse =
// blockMap.containsKey(((BasicblockContext)_localctx).terminatorList.resultToken.getText() +
// "else");
                        isContainsElse = thenElse.get(str + "then").equals(((BasicblockContext) _localctx).terminatorList.resultToken.getText() + "else") ? true : false;
                    } else if (blockMap.containsKey(str + "else") && blockMap.get(str + "else") == null) {
                        blockMap.put(str + "else", blockNode);
                        // count--;
                        if (thenStr == null) {
                            ((BasicblockContext) _localctx).result = new ArrayList();
                            _localctx.result.add(blockNode);
                        } else {
                            elseStr = str;
                            elseList.add(str);
                        }
                    }
                    if (!blockMap.containsKey(str + "then") && !blockMap.containsKey(str + "else")) {
                        blockNode = factory.createBasicBlockNode(resultCommon, list, ((BasicblockContext) _localctx).name.resultToken.getStartIndex(), length -
                                        ((BasicblockContext) _localctx).name.resultToken.getStartIndex());
                        ((BasicblockContext) _localctx).result = new ArrayList();
                        _localctx.result.add(blockNode);
                        blockName = str;
                    }
                    if (isWhile) {
                        Token whileToken = ((BasicblockContext) _localctx).terminatorList.resultToken;
                        LlvmStatementNode whileNode = factory.createWhile(ifstartToken, conditionToken, blockMap, whileToken);
                        // list.add(whileNode);
                        List<LlvmStatementNode> tempNode = new ArrayList();
                        ((BasicblockContext) _localctx).result = new ArrayList();
                        _localctx.result.add(whileNode);
                        blockNode = factory.createBasicBlockNode(resultCommon, list, ((BasicblockContext) _localctx).name.resultToken.getStartIndex(), length -
                                        ((BasicblockContext) _localctx).name.resultToken.getStartIndex());
                        thenStr = null;
                        blockMap = new HashMap<String, LlvmStatementNode>();
                        isWhile = false;
                    } else if ((thenStr != null && elseStr != null) | (thenStr != null && isContainsElse)) {
                        LlvmStatementNode ifNode = null;
                        if (isContainsElse) {
                            ifNode = factory.createIf(ifstartToken, blockName + "if", conditionToken, blockMap.get(thenStr + "then"), null);
                        } else {
                            ifNode = factory.createIf(ifstartToken, blockName + "if", conditionToken, blockMap.get(thenStr + "then"), blockMap.get(elseStr + "else"));
                        }
                        ((BasicblockContext) _localctx).result = new ArrayList();
                        _localctx.result.add(ifNode);
                        thenStr = null;
                        elseStr = null;
                        isContainsElse = false;
                        // thenList.remove(thenList.size() -1);
                        // elseList.remove(elseList.size() -1);
                    }
                    // if the str is contained in the blockMap, it should not create the
// basicblockNode
                } else {
                    ((BasicblockContext) _localctx).result = list;
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

    public static class BasicblocknameContext extends ParserRuleContext {
        public Token resultToken;
        public Token Basic_block_id;

        public TerminalNode Basic_block_id() {
            return getToken(LLVM_IRParser.Basic_block_id, 0);
        }

        public BasicblocknameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_basicblockname;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterBasicblockname(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitBasicblockname(this);
        }
    }

    public final BasicblocknameContext basicblockname() throws RecognitionException {
        BasicblocknameContext _localctx = new BasicblocknameContext(_ctx, getState());
        enterRule(_localctx, 120, RULE_basicblockname);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(876);
                _la = _input.LA(1);
                if (_la == Basic_block_id) {
                    {
                        setState(874);
                        ((BasicblocknameContext) _localctx).Basic_block_id = match(Basic_block_id);

                        ((BasicblocknameContext) _localctx).resultToken = ((BasicblocknameContext) _localctx).Basic_block_id;

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

    public static class MetadatasuffixContext extends ParserRuleContext {
        public Token name;
        public MetadatarefContext value;

        public MetadatarefContext metadataref() {
            return getRuleContext(MetadatarefContext.class, 0);
        }

        public TerminalNode Meta_name() {
            return getToken(LLVM_IRParser.Meta_name, 0);
        }

        public MetadatasuffixContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_metadatasuffix;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterMetadatasuffix(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitMetadatasuffix(this);
        }
    }

    public final MetadatasuffixContext metadatasuffix() throws RecognitionException {
        MetadatasuffixContext _localctx = new MetadatasuffixContext(_ctx, getState());
        enterRule(_localctx, 122, RULE_metadatasuffix);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(878);
                match(T__222);
                setState(879);
                ((MetadatasuffixContext) _localctx).name = match(Meta_name);
                setState(880);
                ((MetadatasuffixContext) _localctx).value = metadataref();
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

    public static class StartinginstructionContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public LocalnameContext name;

        public LocalnameContext localname() {
            return getRuleContext(LocalnameContext.class, 0);
        }

        public Instruction_phiContext instruction_phi() {
            return getRuleContext(Instruction_phiContext.class, 0);
        }

        public List<MetadatasuffixContext> metadatasuffix() {
            return getRuleContexts(MetadatasuffixContext.class);
        }

        public MetadatasuffixContext metadatasuffix(int i) {
            return getRuleContext(MetadatasuffixContext.class, i);
        }

        public StartinginstructionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_startinginstruction;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterStartinginstruction(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitStartinginstruction(this);
        }
    }

    public final StartinginstructionContext startinginstruction() throws RecognitionException {
        StartinginstructionContext _localctx = new StartinginstructionContext(_ctx, getState());
        enterRule(_localctx, 124, RULE_startinginstruction);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(882);
                ((StartinginstructionContext) _localctx).name = localname();
                setState(883);
                instruction_phi();
                setState(887);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 76, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(884);
                                metadatasuffix();
                            }
                        }
                    }
                    setState(889);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 76, _ctx);
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

    public static class MiddleinstructionContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public NamedmiddleinstructionContext op1;
        public Instruction_storeContext op2;
        public Instruction_fenceContext op3;
        public Instruction_call_voidContext op4;

        public Instruction_storeContext instruction_store() {
            return getRuleContext(Instruction_storeContext.class, 0);
        }

        public Instruction_call_voidContext instruction_call_void() {
            return getRuleContext(Instruction_call_voidContext.class, 0);
        }

        public NamedmiddleinstructionContext namedmiddleinstruction() {
            return getRuleContext(NamedmiddleinstructionContext.class, 0);
        }

        public Instruction_fenceContext instruction_fence() {
            return getRuleContext(Instruction_fenceContext.class, 0);
        }

        public List<MetadatasuffixContext> metadatasuffix() {
            return getRuleContexts(MetadatasuffixContext.class);
        }

        public MetadatasuffixContext metadatasuffix(int i) {
            return getRuleContext(MetadatasuffixContext.class, i);
        }

        public MiddleinstructionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_middleinstruction;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterMiddleinstruction(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitMiddleinstruction(this);
        }
    }

    public final MiddleinstructionContext middleinstruction() throws RecognitionException {
        MiddleinstructionContext _localctx = new MiddleinstructionContext(_ctx, getState());
        enterRule(_localctx, 126, RULE_middleinstruction);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(900);
                switch (getInterpreter().adaptivePredict(_input, 77, _ctx)) {
                    case 1: {
                        setState(890);
                        ((MiddleinstructionContext) _localctx).op1 = namedmiddleinstruction();

                        ((MiddleinstructionContext) _localctx).result = ((MiddleinstructionContext) _localctx).op1.result;

                    }
                        break;
                    case 2: {
                        setState(893);
                        ((MiddleinstructionContext) _localctx).op2 = instruction_store();

                        ((MiddleinstructionContext) _localctx).result = ((MiddleinstructionContext) _localctx).op2.result;

                    }
                        break;
                    case 3: {
                        setState(896);
                        ((MiddleinstructionContext) _localctx).op3 = instruction_fence();
                    }
                        break;
                    case 4: {
                        setState(897);
                        ((MiddleinstructionContext) _localctx).op4 = instruction_call_void();

                        ((MiddleinstructionContext) _localctx).result = ((MiddleinstructionContext) _localctx).op4.result;

                    }
                        break;
                }
                setState(905);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__222) {
                    {
                        {
                            setState(902);
                            metadatasuffix();
                        }
                    }
                    setState(907);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
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

    public static class NamedmiddleinstructionContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public LocalnameContext name;
        public BinaryinstructionContext op1;
        public BitwisebinaryinstructionContext op2;
        public VectorinstructionsContext op3;
        public AggregateinstructionContext op4;
        public Instruction_allocaContext op5;
        public Instruction_loadContext op6;
        public Instruction_getelementptrContext op7;
        public Instruction_cmpxchgContext op8;
        public Instruction_atomicrmwContext op9;
        public ConversioninstructionContext op10;
        public OtherinstructionContext op11;
        public Instruction_call_nonvoidContext op12;

        public Instruction_allocaContext instruction_alloca() {
            return getRuleContext(Instruction_allocaContext.class, 0);
        }

        public Instruction_getelementptrContext instruction_getelementptr() {
            return getRuleContext(Instruction_getelementptrContext.class, 0);
        }

        public Instruction_cmpxchgContext instruction_cmpxchg() {
            return getRuleContext(Instruction_cmpxchgContext.class, 0);
        }

        public Instruction_loadContext instruction_load() {
            return getRuleContext(Instruction_loadContext.class, 0);
        }

        public BitwisebinaryinstructionContext bitwisebinaryinstruction() {
            return getRuleContext(BitwisebinaryinstructionContext.class, 0);
        }

        public Instruction_call_nonvoidContext instruction_call_nonvoid() {
            return getRuleContext(Instruction_call_nonvoidContext.class, 0);
        }

        public AggregateinstructionContext aggregateinstruction() {
            return getRuleContext(AggregateinstructionContext.class, 0);
        }

        public Instruction_atomicrmwContext instruction_atomicrmw() {
            return getRuleContext(Instruction_atomicrmwContext.class, 0);
        }

        public LocalnameContext localname() {
            return getRuleContext(LocalnameContext.class, 0);
        }

        public OtherinstructionContext otherinstruction() {
            return getRuleContext(OtherinstructionContext.class, 0);
        }

        public VectorinstructionsContext vectorinstructions() {
            return getRuleContext(VectorinstructionsContext.class, 0);
        }

        public BinaryinstructionContext binaryinstruction() {
            return getRuleContext(BinaryinstructionContext.class, 0);
        }

        public ConversioninstructionContext conversioninstruction() {
            return getRuleContext(ConversioninstructionContext.class, 0);
        }

        public NamedmiddleinstructionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_namedmiddleinstruction;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterNamedmiddleinstruction(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitNamedmiddleinstruction(this);
        }
    }

    public final NamedmiddleinstructionContext namedmiddleinstruction() throws RecognitionException {
        NamedmiddleinstructionContext _localctx = new NamedmiddleinstructionContext(_ctx, getState());
        enterRule(_localctx, 128, RULE_namedmiddleinstruction);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(908);
                ((NamedmiddleinstructionContext) _localctx).name = localname();
                setState(933);
                switch (_input.LA(1)) {
                    case T__236:
                    case T__226:
                    case T__210:
                    case T__205:
                    case T__106:
                    case T__102:
                    case T__97:
                    case T__90:
                    case T__84:
                    case T__81:
                    case T__22:
                    case T__15: {
                        setState(909);
                        ((NamedmiddleinstructionContext) _localctx).op1 = binaryinstruction();

                        ((NamedmiddleinstructionContext) _localctx).result = factory.createAssignment(((NamedmiddleinstructionContext) _localctx).name.resultToken,
                                        ((NamedmiddleinstructionContext) _localctx).op1.result);

                    }
                        break;
                    case T__173:
                    case T__169:
                    case T__133:
                    case T__112:
                    case T__105:
                    case T__65: {
                        setState(912);
                        ((NamedmiddleinstructionContext) _localctx).op2 = bitwisebinaryinstruction();

                        ((NamedmiddleinstructionContext) _localctx).result = factory.createAssignment(((NamedmiddleinstructionContext) _localctx).name.resultToken,
                                        ((NamedmiddleinstructionContext) _localctx).op2.result);

                    }
                        break;
                    case T__228:
                    case T__186:
                    case T__74: {
                        setState(915);
                        ((NamedmiddleinstructionContext) _localctx).op3 = vectorinstructions();
                    }
                        break;
                    case T__224:
                    case T__51: {
                        setState(916);
                        ((NamedmiddleinstructionContext) _localctx).op4 = aggregateinstruction();
                    }
                        break;
                    case T__124: {
                        setState(917);
                        ((NamedmiddleinstructionContext) _localctx).op5 = instruction_alloca();

                        ((NamedmiddleinstructionContext) _localctx).result = factory.createAssignment(((NamedmiddleinstructionContext) _localctx).name.resultToken,
                                        ((NamedmiddleinstructionContext) _localctx).op5.result);

                    }
                        break;
                    case T__52: {
                        setState(920);
                        ((NamedmiddleinstructionContext) _localctx).op6 = instruction_load();

                        ((NamedmiddleinstructionContext) _localctx).result = factory.createAssignment(((NamedmiddleinstructionContext) _localctx).name.resultToken,
                                        ((NamedmiddleinstructionContext) _localctx).op6.result);

                    }
                        break;
                    case T__213: {
                        setState(923);
                        ((NamedmiddleinstructionContext) _localctx).op7 = instruction_getelementptr();
                    }
                        break;
                    case T__191: {
                        setState(924);
                        ((NamedmiddleinstructionContext) _localctx).op8 = instruction_cmpxchg();
                    }
                        break;
                    case T__126: {
                        setState(925);
                        ((NamedmiddleinstructionContext) _localctx).op9 = instruction_atomicrmw();
                    }
                        break;
                    case T__215:
                    case T__190:
                    case T__184:
                    case T__181:
                    case T__146:
                    case T__117:
                    case T__111:
                    case T__85:
                    case T__79:
                    case T__64:
                    case T__42:
                    case T__29:
                    case T__25: {
                        setState(926);
                        ((NamedmiddleinstructionContext) _localctx).op10 = conversioninstruction();
                    }
                        break;
                    case T__204:
                    case T__198:
                    case T__177:
                    case T__135:
                    case T__110: {
                        setState(927);
                        ((NamedmiddleinstructionContext) _localctx).op11 = otherinstruction();

                        ((NamedmiddleinstructionContext) _localctx).result = factory.createAssignment(((NamedmiddleinstructionContext) _localctx).name.resultToken,
                                        ((NamedmiddleinstructionContext) _localctx).op11.result);

                    }
                        break;
                    case T__234:
                    case T__104: {
                        setState(930);
                        ((NamedmiddleinstructionContext) _localctx).op12 = instruction_call_nonvoid();

                        ((NamedmiddleinstructionContext) _localctx).result = factory.createAssignment(((NamedmiddleinstructionContext) _localctx).name.resultToken,
                                        ((NamedmiddleinstructionContext) _localctx).op12.result);

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

    public static class ParamnameContext extends ParserRuleContext {
        public Token resultToken;
        public Token Local_id;

        public TerminalNode Local_id() {
            return getToken(LLVM_IRParser.Local_id, 0);
        }

        public ParamnameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_paramname;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterParamname(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitParamname(this);
        }
    }

    public final ParamnameContext paramname() throws RecognitionException {
        ParamnameContext _localctx = new ParamnameContext(_ctx, getState());
        enterRule(_localctx, 130, RULE_paramname);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(937);
                switch (getInterpreter().adaptivePredict(_input, 80, _ctx)) {
                    case 1: {
                        setState(935);
                        ((ParamnameContext) _localctx).Local_id = match(Local_id);

                        ((ParamnameContext) _localctx).resultToken = ((ParamnameContext) _localctx).Local_id;

                    }
                        break;
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

    public static class LocalnameContext extends ParserRuleContext {
        public Token resultToken;
        public Token Local_id;

        public TerminalNode WS(int i) {
            return getToken(LLVM_IRParser.WS, i);
        }

        public List<TerminalNode> WS() {
            return getTokens(LLVM_IRParser.WS);
        }

        public TerminalNode Local_id() {
            return getToken(LLVM_IRParser.Local_id, 0);
        }

        public LocalnameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_localname;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterLocalname(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitLocalname(this);
        }
    }

    public final LocalnameContext localname() throws RecognitionException {
        LocalnameContext _localctx = new LocalnameContext(_ctx, getState());
        enterRule(_localctx, 132, RULE_localname);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(948);
                _la = _input.LA(1);
                if (_la == Local_id) {
                    {
                        setState(939);
                        ((LocalnameContext) _localctx).Local_id = match(Local_id);
                        setState(943);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == WS) {
                            {
                                {
                                    setState(940);
                                    match(WS);
                                }
                            }
                            setState(945);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                        setState(946);
                        match(T__235);

                        ((LocalnameContext) _localctx).resultToken = ((LocalnameContext) _localctx).Local_id;

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

    public static class GlobalnameContext extends ParserRuleContext {
        public TerminalNode WS(int i) {
            return getToken(LLVM_IRParser.WS, i);
        }

        public List<TerminalNode> WS() {
            return getTokens(LLVM_IRParser.WS);
        }

        public TerminalNode Global_id() {
            return getToken(LLVM_IRParser.Global_id, 0);
        }

        public GlobalnameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_globalname;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterGlobalname(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitGlobalname(this);
        }
    }

    public final GlobalnameContext globalname() throws RecognitionException {
        GlobalnameContext _localctx = new GlobalnameContext(_ctx, getState());
        enterRule(_localctx, 134, RULE_globalname);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(958);
                _la = _input.LA(1);
                if (_la == Global_id) {
                    {
                        setState(950);
                        match(Global_id);
                        setState(954);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == WS) {
                            {
                                {
                                    setState(951);
                                    match(WS);
                                }
                            }
                            setState(956);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                        setState(957);
                        match(T__235);
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

    public static class TerminatorinstructionContext extends ParserRuleContext {
        public LlvmStatementNode result;
        public Token resultToken;
        public Instruction_retContext op2;
        public Instruction_brContext op3;

        public Instruction_resumeContext instruction_resume() {
            return getRuleContext(Instruction_resumeContext.class, 0);
        }

        public Instruction_switchContext instruction_switch() {
            return getRuleContext(Instruction_switchContext.class, 0);
        }

        public Instruction_indirectbrContext instruction_indirectbr() {
            return getRuleContext(Instruction_indirectbrContext.class, 0);
        }

        public Instruction_invoke_voidContext instruction_invoke_void() {
            return getRuleContext(Instruction_invoke_voidContext.class, 0);
        }

        public NamedterminatorinstructionContext namedterminatorinstruction() {
            return getRuleContext(NamedterminatorinstructionContext.class, 0);
        }

        public Instruction_unreachableContext instruction_unreachable() {
            return getRuleContext(Instruction_unreachableContext.class, 0);
        }

        public Instruction_retContext instruction_ret() {
            return getRuleContext(Instruction_retContext.class, 0);
        }

        public List<MetadatasuffixContext> metadatasuffix() {
            return getRuleContexts(MetadatasuffixContext.class);
        }

        public MetadatasuffixContext metadatasuffix(int i) {
            return getRuleContext(MetadatasuffixContext.class, i);
        }

        public Instruction_brContext instruction_br() {
            return getRuleContext(Instruction_brContext.class, 0);
        }

        public TerminatorinstructionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_terminatorinstruction;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterTerminatorinstruction(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitTerminatorinstruction(this);
        }
    }

    public final TerminatorinstructionContext terminatorinstruction() throws RecognitionException {
        TerminatorinstructionContext _localctx = new TerminatorinstructionContext(_ctx, getState());
        enterRule(_localctx, 136, RULE_terminatorinstruction);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(972);
                switch (getInterpreter().adaptivePredict(_input, 85, _ctx)) {
                    case 1: {
                        setState(960);
                        namedterminatorinstruction();
                    }
                        break;
                    case 2: {
                        setState(961);
                        ((TerminatorinstructionContext) _localctx).op2 = instruction_ret();

                        ((TerminatorinstructionContext) _localctx).result = ((TerminatorinstructionContext) _localctx).op2.result;
                        ((TerminatorinstructionContext) _localctx).resultToken = ((TerminatorinstructionContext) _localctx).op2.resultToken;

                    }
                        break;
                    case 3: {
                        setState(964);
                        ((TerminatorinstructionContext) _localctx).op3 = instruction_br();

                        ((TerminatorinstructionContext) _localctx).result = ((TerminatorinstructionContext) _localctx).op3.result;
                        ((TerminatorinstructionContext) _localctx).resultToken = ((TerminatorinstructionContext) _localctx).op3.resultToken;

                    }
                        break;
                    case 4: {
                        setState(967);
                        instruction_switch();
                    }
                        break;
                    case 5: {
                        setState(968);
                        instruction_indirectbr();
                    }
                        break;
                    case 6: {
                        setState(969);
                        instruction_resume();
                    }
                        break;
                    case 7: {
                        setState(970);
                        instruction_unreachable();
                    }
                        break;
                    case 8: {
                        setState(971);
                        instruction_invoke_void();
                    }
                        break;
                }
                setState(977);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 86, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(974);
                                metadatasuffix();
                            }
                        }
                    }
                    setState(979);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 86, _ctx);
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

    public static class NamedterminatorinstructionContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public LocalnameContext name;
        public Instruction_invoke_nonvoidContext op;

        public LocalnameContext localname() {
            return getRuleContext(LocalnameContext.class, 0);
        }

        public Instruction_invoke_nonvoidContext instruction_invoke_nonvoid() {
            return getRuleContext(Instruction_invoke_nonvoidContext.class, 0);
        }

        public NamedterminatorinstructionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_namedterminatorinstruction;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterNamedterminatorinstruction(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitNamedterminatorinstruction(this);
        }
    }

    public final NamedterminatorinstructionContext namedterminatorinstruction() throws RecognitionException {
        NamedterminatorinstructionContext _localctx = new NamedterminatorinstructionContext(_ctx, getState());
        enterRule(_localctx, 138, RULE_namedterminatorinstruction);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(980);
                ((NamedterminatorinstructionContext) _localctx).name = localname();
                {
                    setState(981);
                    ((NamedterminatorinstructionContext) _localctx).op = instruction_invoke_nonvoid();
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

    public static class Instruction_retContext extends ParserRuleContext {
        public LlvmStatementNode result;
        public Token resultToken;
        public Token opcode;
        public TypedvalueContext val;
        public Token re;

        public TypedvalueContext typedvalue() {
            return getRuleContext(TypedvalueContext.class, 0);
        }

        public Instruction_retContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_ret;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_ret(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_ret(this);
        }
    }

    public final Instruction_retContext instruction_ret() throws RecognitionException {
        Instruction_retContext _localctx = new Instruction_retContext(_ctx, getState());
        enterRule(_localctx, 140, RULE_instruction_ret);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(983);
                ((Instruction_retContext) _localctx).opcode = match(T__11);
                setState(989);
                switch (getInterpreter().adaptivePredict(_input, 87, _ctx)) {
                    case 1: {
                        setState(984);
                        ((Instruction_retContext) _localctx).val = typedvalue();

                        ((Instruction_retContext) _localctx).result = factory.createReturn(((Instruction_retContext) _localctx).opcode, ((Instruction_retContext) _localctx).val.result);
                        ((Instruction_retContext) _localctx).resultToken = ((Instruction_retContext) _localctx).val.resultToken;

                    }
                        break;
                    case 2: {
                        setState(987);
                        ((Instruction_retContext) _localctx).re = match(T__47);

                        ((Instruction_retContext) _localctx).resultToken = ((Instruction_retContext) _localctx).re;
                        ((Instruction_retContext) _localctx).result = factory.createReturn(((Instruction_retContext) _localctx).opcode, null);

                    }
                        break;
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

    public static class Instruction_brContext extends ParserRuleContext {
        public LlvmStatementNode result;
        public Token resultToken;
        public Token opcode;
        public TypedvalueContext condition;
        public BasicblockrefContext trueelement;
        public BasicblockrefContext falseelement;
        public BasicblockrefContext unconditional;

        public BasicblockrefContext basicblockref(int i) {
            return getRuleContext(BasicblockrefContext.class, i);
        }

        public TypedvalueContext typedvalue() {
            return getRuleContext(TypedvalueContext.class, 0);
        }

        public List<BasicblockrefContext> basicblockref() {
            return getRuleContexts(BasicblockrefContext.class);
        }

        public Instruction_brContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_br;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_br(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_br(this);
        }
    }

    public final Instruction_brContext instruction_br() throws RecognitionException {
        Instruction_brContext _localctx = new Instruction_brContext(_ctx, getState());
        enterRule(_localctx, 142, RULE_instruction_br);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(991);
                ((Instruction_brContext) _localctx).opcode = match(T__28);
                setState(1005);
                switch (_input.LA(1)) {
                    case T__212:
                    case T__211:
                    case T__178:
                    case T__157:
                    case T__154:
                    case T__140:
                    case T__118:
                    case T__47:
                    case Int_type:
                    case Local_id:
                    case Floatingtype: {
                        {
                            setState(992);
                            ((Instruction_brContext) _localctx).condition = typedvalue();
                            setState(993);
                            match(T__222);
                            setState(994);
                            match(T__50);
                            setState(995);
                            ((Instruction_brContext) _localctx).trueelement = basicblockref();
                            setState(996);
                            match(T__222);
                            setState(997);
                            match(T__50);
                            setState(998);
                            ((Instruction_brContext) _localctx).falseelement = basicblockref();

                            // boolean isTrue =
// ((Instruction_brContext)_localctx).condition.resultToken.getText().equals("true");
                            ((Instruction_brContext) _localctx).resultToken = ((Instruction_brContext) _localctx).falseelement.resultToken;
                            blockMap.put(((Instruction_brContext) _localctx).trueelement.resultToken.getText() + "then", null);
                            blockMap.put(((Instruction_brContext) _localctx).falseelement.resultToken.getText() + "else", null);
                            // LlvmExpressionNode trueToken =
// factory.createisReadBlock(((Instruction_brContext)_localctx).trueelement.resultToken);
                            // LlvmExpressionNode falseToken =
// factory.createisReadBlock(((Instruction_brContext)_localctx).falseelement.resultToken);
                            // LlvmExpressionNode trueNode =
// factory.createCallBasicBlock(trueToken,_localctx.resultToken);
                            // LlvmExpressionNode falseNode =
// factory.createCallBasicBlock(falseToken,_localctx.resultToken);
                            // //((Instruction_brContext)_localctx).result =
// factory.createIf(((Instruction_brContext)_localctx).opcode,
// ((Instruction_brContext)_localctx).condition.result ,trueNode,falseNode);
                            conditionToken = ((Instruction_brContext) _localctx).condition.result;
                            count += 2;
                            thenStr = null;
                            elseStr = null;
                            thenElse.put(((Instruction_brContext) _localctx).trueelement.resultToken.getText() + "then", ((Instruction_brContext) _localctx).falseelement.resultToken.getText() +
                                            "else");

                        }
                    }
                        break;
                    case T__50: {
                        {
                            setState(1001);
                            match(T__50);
                            setState(1002);
                            ((Instruction_brContext) _localctx).unconditional = basicblockref();

                            ((Instruction_brContext) _localctx).resultToken = ((Instruction_brContext) _localctx).unconditional.resultToken;
                            LlvmExpressionNode unconNode = factory.createisReadBlock(_localctx.resultToken);
                            // ((Instruction_brContext)_localctx).result =
// factory.createCallBasicBlock(unconNode,_localctx.resultToken);
                            if (unconNode != null && !blockMap.containsKey(_localctx.resultToken.getText() + "then") && !blockMap.containsKey(_localctx.resultToken.getText() + "else")) {
                                isWhile = true;
                                // ((Instruction_brContext)_localctx).result =
// factory.createCallBasicBlock(unconNode,_localctx.resultToken);
                                // ((Instruction_brContext)_localctx).result =
// factory.createisReadBlock(_localctx.resultToken);
                                // if exists, it creates the whileNode;
                            }

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

    public static class Instruction_switchContext extends ParserRuleContext {
        public Token opcode;
        public TypedvalueContext comparisonvalue;
        public BasicblockrefContext defaultdest;
        public TypedvalueContext typedvalue;
        public List<TypedvalueContext> caseconditions = new ArrayList<TypedvalueContext>();
        public BasicblockrefContext basicblockref;
        public List<BasicblockrefContext> destinations = new ArrayList<BasicblockrefContext>();

        public BasicblockrefContext basicblockref(int i) {
            return getRuleContext(BasicblockrefContext.class, i);
        }

        public TypedvalueContext typedvalue(int i) {
            return getRuleContext(TypedvalueContext.class, i);
        }

        public List<TypedvalueContext> typedvalue() {
            return getRuleContexts(TypedvalueContext.class);
        }

        public List<BasicblockrefContext> basicblockref() {
            return getRuleContexts(BasicblockrefContext.class);
        }

        public Instruction_switchContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_switch;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_switch(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_switch(this);
        }
    }

    public final Instruction_switchContext instruction_switch() throws RecognitionException {
        Instruction_switchContext _localctx = new Instruction_switchContext(_ctx, getState());
        enterRule(_localctx, 144, RULE_instruction_switch);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1007);
                ((Instruction_switchContext) _localctx).opcode = match(T__62);
                setState(1008);
                ((Instruction_switchContext) _localctx).comparisonvalue = typedvalue();
                setState(1009);
                match(T__222);
                setState(1010);
                match(T__50);
                setState(1011);
                ((Instruction_switchContext) _localctx).defaultdest = basicblockref();
                setState(1012);
                match(T__178);
                setState(1020);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__212) | (1L << T__211) | (1L << T__178))) != 0) ||
                                ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__157 - 83)) | (1L << (T__154 - 83)) | (1L << (T__140 - 83)) | (1L << (T__118 - 83)))) != 0) ||
                                ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (T__47 - 193)) | (1L << (Int_type - 193)) | (1L << (Local_id - 193)))) != 0) || _la == Floatingtype) {
                    {
                        {
                            setState(1013);
                            ((Instruction_switchContext) _localctx).typedvalue = typedvalue();
                            ((Instruction_switchContext) _localctx).caseconditions.add(((Instruction_switchContext) _localctx).typedvalue);
                            setState(1014);
                            match(T__222);
                            setState(1015);
                            match(T__50);
                            setState(1016);
                            ((Instruction_switchContext) _localctx).basicblockref = basicblockref();
                            ((Instruction_switchContext) _localctx).destinations.add(((Instruction_switchContext) _localctx).basicblockref);
                        }
                    }
                    setState(1022);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(1023);
                match(T__208);
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

    public static class Instruction_indirectbrContext extends ParserRuleContext {
        public Token opcode;
        public TypedvalueContext address;
        public BasicblockrefContext basicblockref;
        public List<BasicblockrefContext> destinations = new ArrayList<BasicblockrefContext>();

        public BasicblockrefContext basicblockref(int i) {
            return getRuleContext(BasicblockrefContext.class, i);
        }

        public TypedvalueContext typedvalue() {
            return getRuleContext(TypedvalueContext.class, 0);
        }

        public List<BasicblockrefContext> basicblockref() {
            return getRuleContexts(BasicblockrefContext.class);
        }

        public Instruction_indirectbrContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_indirectbr;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_indirectbr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_indirectbr(this);
        }
    }

    public final Instruction_indirectbrContext instruction_indirectbr() throws RecognitionException {
        Instruction_indirectbrContext _localctx = new Instruction_indirectbrContext(_ctx, getState());
        enterRule(_localctx, 146, RULE_instruction_indirectbr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1025);
                ((Instruction_indirectbrContext) _localctx).opcode = match(T__139);
                setState(1026);
                ((Instruction_indirectbrContext) _localctx).address = typedvalue();
                setState(1027);
                match(T__222);
                setState(1028);
                match(T__178);
                setState(1039);
                _la = _input.LA(1);
                if (_la == T__50) {
                    {
                        setState(1029);
                        match(T__50);
                        setState(1030);
                        ((Instruction_indirectbrContext) _localctx).basicblockref = basicblockref();
                        ((Instruction_indirectbrContext) _localctx).destinations.add(((Instruction_indirectbrContext) _localctx).basicblockref);
                        setState(1036);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == T__222) {
                            {
                                {
                                    setState(1031);
                                    match(T__222);
                                    setState(1032);
                                    match(T__50);
                                    setState(1033);
                                    ((Instruction_indirectbrContext) _localctx).basicblockref = basicblockref();
                                    ((Instruction_indirectbrContext) _localctx).destinations.add(((Instruction_indirectbrContext) _localctx).basicblockref);
                                }
                            }
                            setState(1038);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                    }
                }

                setState(1041);
                match(T__208);
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

    public static class Instruction_invoke_voidContext extends ParserRuleContext {
        public Token opcode;
        public BasicblockrefContext tolabel;
        public BasicblockrefContext exceptionlabel;

        public CalleeContext callee() {
            return getRuleContext(CalleeContext.class, 0);
        }

        public CconvContext cconv() {
            return getRuleContext(CconvContext.class, 0);
        }

        public BasicblockrefContext basicblockref(int i) {
            return getRuleContext(BasicblockrefContext.class, i);
        }

        public FunctionattributesContext functionattributes() {
            return getRuleContext(FunctionattributesContext.class, 0);
        }

        public List<BasicblockrefContext> basicblockref() {
            return getRuleContexts(BasicblockrefContext.class);
        }

        public ArglistContext arglist() {
            return getRuleContext(ArglistContext.class, 0);
        }

        public VoidtypeContext voidtype() {
            return getRuleContext(VoidtypeContext.class, 0);
        }

        public Instruction_invoke_voidContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_invoke_void;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_invoke_void(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_invoke_void(this);
        }
    }

    public final Instruction_invoke_voidContext instruction_invoke_void() throws RecognitionException {
        Instruction_invoke_voidContext _localctx = new Instruction_invoke_voidContext(_ctx, getState());
        enterRule(_localctx, 148, RULE_instruction_invoke_void);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1043);
                ((Instruction_invoke_voidContext) _localctx).opcode = match(T__54);
                setState(1045);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__233) | (1L << T__200) | (1L << T__193) | (1L << T__192) | (1L << T__183))) != 0) ||
                                ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (T__175 - 65)) | (1L << (T__172 - 65)) | (1L << (T__166 - 65)) | (1L << (T__163 - 65)) |
                                                (1L << (T__152 - 65)) | (1L << (T__136 - 65)) | (1L << (T__130 - 65)) | (1L << (T__125 - 65)))) != 0) ||
                                ((((_la - 140)) & ~0x3f) == 0 && ((1L << (_la - 140)) & ((1L << (T__100 - 140)) | (1L << (T__76 - 140)) | (1L << (T__46 - 140)) | (1L << (T__41 - 140)))) != 0) ||
                                ((((_la - 205)) & ~0x3f) == 0 && ((1L << (_la - 205)) & ((1L << (T__35 - 205)) | (1L << (T__33 - 205)) | (1L << (T__31 - 205)) | (1L << (T__24 - 205)) | (1L << (T__20 - 205)))) != 0)) {
                    {
                        setState(1044);
                        cconv();
                    }
                }

                {
                    setState(1048);
                    _la = _input.LA(1);
                    if (_la == T__58) {
                        {
                            setState(1047);
                            match(T__58);
                        }
                    }

                    setState(1051);
                    _la = _input.LA(1);
                    if (_la == T__171) {
                        {
                            setState(1050);
                            match(T__171);
                        }
                    }

                    setState(1054);
                    _la = _input.LA(1);
                    if (_la == T__114) {
                        {
                            setState(1053);
                            match(T__114);
                        }
                    }

                }
                setState(1056);
                voidtype();
                setState(1057);
                callee();
                setState(1058);
                arglist();
                setState(1060);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__231) | (1L << T__214) | (1L << T__206) | (1L << T__201))) != 0) ||
                                ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (T__168 - 72)) | (1L << (T__164 - 72)) | (1L << (T__159 - 72)) | (1L << (T__132 - 72)) |
                                                (1L << (T__120 - 72)) | (1L << (T__115 - 72)) | (1L << (T__113 - 72)))) != 0) ||
                                ((((_la - 146)) & ~0x3f) == 0 && ((1L << (_la - 146)) & ((1L << (T__94 - 146)) | (1L << (T__87 - 146)) | (1L << (T__82 - 146)) | (1L << (T__77 - 146)) |
                                                (1L << (T__70 - 146)) | (1L << (T__68 - 146)) | (1L << (T__61 - 146)) | (1L << (T__57 - 146)) | (1L << (T__56 - 146)) | (1L << (T__45 - 146)) |
                                                (1L << (T__43 - 146)) | (1L << (T__39 - 146)) | (1L << (T__37 - 146)) | (1L << (T__36 - 146)))) != 0) ||
                                ((((_la - 210)) & ~0x3f) == 0 && ((1L << (_la - 210)) & ((1L << (T__30 - 210)) | (1L << (T__19 - 210)) | (1L << (T__12 - 210)) | (1L << (T__5 - 210)) |
                                                (1L << (T__1 - 210)) | (1L << (Attribute_id - 210)))) != 0)) {
                    {
                        setState(1059);
                        functionattributes();
                    }
                }

                setState(1062);
                match(T__179);
                setState(1063);
                match(T__50);
                setState(1064);
                ((Instruction_invoke_voidContext) _localctx).tolabel = basicblockref();
                setState(1065);
                match(T__95);
                setState(1066);
                match(T__50);
                setState(1067);
                ((Instruction_invoke_voidContext) _localctx).exceptionlabel = basicblockref();
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

    public static class Instruction_invoke_nonvoidContext extends ParserRuleContext {
        public Token opcode;
        public BasicblockrefContext tolabel;
        public BasicblockrefContext exceptionlabel;

        public NonvoidtypeContext nonvoidtype() {
            return getRuleContext(NonvoidtypeContext.class, 0);
        }

        public CalleeContext callee() {
            return getRuleContext(CalleeContext.class, 0);
        }

        public CconvContext cconv() {
            return getRuleContext(CconvContext.class, 0);
        }

        public BasicblockrefContext basicblockref(int i) {
            return getRuleContext(BasicblockrefContext.class, i);
        }

        public FunctionattributesContext functionattributes() {
            return getRuleContext(FunctionattributesContext.class, 0);
        }

        public List<BasicblockrefContext> basicblockref() {
            return getRuleContexts(BasicblockrefContext.class);
        }

        public ArglistContext arglist() {
            return getRuleContext(ArglistContext.class, 0);
        }

        public Instruction_invoke_nonvoidContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_invoke_nonvoid;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_invoke_nonvoid(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_invoke_nonvoid(this);
        }
    }

    public final Instruction_invoke_nonvoidContext instruction_invoke_nonvoid() throws RecognitionException {
        Instruction_invoke_nonvoidContext _localctx = new Instruction_invoke_nonvoidContext(_ctx, getState());
        enterRule(_localctx, 150, RULE_instruction_invoke_nonvoid);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1069);
                ((Instruction_invoke_nonvoidContext) _localctx).opcode = match(T__54);
                setState(1071);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__233) | (1L << T__200) | (1L << T__193) | (1L << T__192) | (1L << T__183))) != 0) ||
                                ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (T__175 - 65)) | (1L << (T__172 - 65)) | (1L << (T__166 - 65)) | (1L << (T__163 - 65)) |
                                                (1L << (T__152 - 65)) | (1L << (T__136 - 65)) | (1L << (T__130 - 65)) | (1L << (T__125 - 65)))) != 0) ||
                                ((((_la - 140)) & ~0x3f) == 0 && ((1L << (_la - 140)) & ((1L << (T__100 - 140)) | (1L << (T__76 - 140)) | (1L << (T__46 - 140)) | (1L << (T__41 - 140)))) != 0) ||
                                ((((_la - 205)) & ~0x3f) == 0 && ((1L << (_la - 205)) & ((1L << (T__35 - 205)) | (1L << (T__33 - 205)) | (1L << (T__31 - 205)) | (1L << (T__24 - 205)) | (1L << (T__20 - 205)))) != 0)) {
                    {
                        setState(1070);
                        cconv();
                    }
                }

                {
                    setState(1074);
                    _la = _input.LA(1);
                    if (_la == T__58) {
                        {
                            setState(1073);
                            match(T__58);
                        }
                    }

                    setState(1077);
                    _la = _input.LA(1);
                    if (_la == T__171) {
                        {
                            setState(1076);
                            match(T__171);
                        }
                    }

                    setState(1080);
                    _la = _input.LA(1);
                    if (_la == T__114) {
                        {
                            setState(1079);
                            match(T__114);
                        }
                    }

                }
                setState(1082);
                nonvoidtype();
                setState(1083);
                callee();
                setState(1084);
                arglist();
                setState(1086);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__231) | (1L << T__214) | (1L << T__206) | (1L << T__201))) != 0) ||
                                ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (T__168 - 72)) | (1L << (T__164 - 72)) | (1L << (T__159 - 72)) | (1L << (T__132 - 72)) |
                                                (1L << (T__120 - 72)) | (1L << (T__115 - 72)) | (1L << (T__113 - 72)))) != 0) ||
                                ((((_la - 146)) & ~0x3f) == 0 && ((1L << (_la - 146)) & ((1L << (T__94 - 146)) | (1L << (T__87 - 146)) | (1L << (T__82 - 146)) | (1L << (T__77 - 146)) |
                                                (1L << (T__70 - 146)) | (1L << (T__68 - 146)) | (1L << (T__61 - 146)) | (1L << (T__57 - 146)) | (1L << (T__56 - 146)) | (1L << (T__45 - 146)) |
                                                (1L << (T__43 - 146)) | (1L << (T__39 - 146)) | (1L << (T__37 - 146)) | (1L << (T__36 - 146)))) != 0) ||
                                ((((_la - 210)) & ~0x3f) == 0 && ((1L << (_la - 210)) & ((1L << (T__30 - 210)) | (1L << (T__19 - 210)) | (1L << (T__12 - 210)) | (1L << (T__5 - 210)) |
                                                (1L << (T__1 - 210)) | (1L << (Attribute_id - 210)))) != 0)) {
                    {
                        setState(1085);
                        functionattributes();
                    }
                }

                setState(1088);
                match(T__179);
                setState(1089);
                match(T__50);
                setState(1090);
                ((Instruction_invoke_nonvoidContext) _localctx).tolabel = basicblockref();
                setState(1091);
                match(T__95);
                setState(1092);
                match(T__50);
                setState(1093);
                ((Instruction_invoke_nonvoidContext) _localctx).exceptionlabel = basicblockref();
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

    public static class Instruction_resumeContext extends ParserRuleContext {
        public Token opcode;
        public TypedvalueContext value;

        public TypedvalueContext typedvalue() {
            return getRuleContext(TypedvalueContext.class, 0);
        }

        public Instruction_resumeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_resume;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_resume(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_resume(this);
        }
    }

    public final Instruction_resumeContext instruction_resume() throws RecognitionException {
        Instruction_resumeContext _localctx = new Instruction_resumeContext(_ctx, getState());
        enterRule(_localctx, 152, RULE_instruction_resume);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1095);
                ((Instruction_resumeContext) _localctx).opcode = match(T__121);
                setState(1096);
                ((Instruction_resumeContext) _localctx).value = typedvalue();
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

    public static class Instruction_unreachableContext extends ParserRuleContext {
        public Token opcode;

        public Instruction_unreachableContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_unreachable;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_unreachable(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_unreachable(this);
        }
    }

    public final Instruction_unreachableContext instruction_unreachable() throws RecognitionException {
        Instruction_unreachableContext _localctx = new Instruction_unreachableContext(_ctx, getState());
        enterRule(_localctx, 154, RULE_instruction_unreachable);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1098);
                ((Instruction_unreachableContext) _localctx).opcode = match(T__103);
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

    public static class BasicblockrefContext extends ParserRuleContext {
        public LlvmStatementNode result;
        public CommonToken resultToken;
        public BasicblockContext basicBlockNodeName;
        public Token Local_id;

        public BasicblockContext basicblock() {
            return getRuleContext(BasicblockContext.class, 0);
        }

        public TerminalNode Local_id() {
            return getToken(LLVM_IRParser.Local_id, 0);
        }

        public BasicblockrefContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_basicblockref;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterBasicblockref(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitBasicblockref(this);
        }
    }

    public final BasicblockrefContext basicblockref() throws RecognitionException {
        BasicblockrefContext _localctx = new BasicblockrefContext(_ctx, getState());
        enterRule(_localctx, 156, RULE_basicblockref);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1103);
                switch (getInterpreter().adaptivePredict(_input, 102, _ctx)) {
                    case 1: {
                        setState(1100);
                        ((BasicblockrefContext) _localctx).basicBlockNodeName = basicblock();
                    }
                        break;
                    case 2: {
                        setState(1101);
                        ((BasicblockrefContext) _localctx).Local_id = match(Local_id);

                        ((BasicblockrefContext) _localctx).resultToken = (CommonToken) ((BasicblockrefContext) _localctx).Local_id;

                    }
                        break;
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

    public static class BinaryinstructionContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Instruction_addContext op1;
        public Instruction_faddContext op2;
        public Instruction_subContext op3;
        public Instruction_fsubContext op4;
        public Instruction_mulContext op5;
        public Instruction_fmulContext op6;
        public Instruction_udivContext op7;
        public Instruction_sdivContext op8;
        public Instruction_fdivContext op9;
        public Instruction_uremContext op10;
        public Instruction_sremContext op11;
        public Instruction_fremContext op12;

        public Instruction_faddContext instruction_fadd() {
            return getRuleContext(Instruction_faddContext.class, 0);
        }

        public Instruction_addContext instruction_add() {
            return getRuleContext(Instruction_addContext.class, 0);
        }

        public Instruction_fsubContext instruction_fsub() {
            return getRuleContext(Instruction_fsubContext.class, 0);
        }

        public Instruction_subContext instruction_sub() {
            return getRuleContext(Instruction_subContext.class, 0);
        }

        public Instruction_udivContext instruction_udiv() {
            return getRuleContext(Instruction_udivContext.class, 0);
        }

        public Instruction_sremContext instruction_srem() {
            return getRuleContext(Instruction_sremContext.class, 0);
        }

        public Instruction_uremContext instruction_urem() {
            return getRuleContext(Instruction_uremContext.class, 0);
        }

        public Instruction_sdivContext instruction_sdiv() {
            return getRuleContext(Instruction_sdivContext.class, 0);
        }

        public Instruction_fremContext instruction_frem() {
            return getRuleContext(Instruction_fremContext.class, 0);
        }

        public Instruction_fdivContext instruction_fdiv() {
            return getRuleContext(Instruction_fdivContext.class, 0);
        }

        public Instruction_fmulContext instruction_fmul() {
            return getRuleContext(Instruction_fmulContext.class, 0);
        }

        public Instruction_mulContext instruction_mul() {
            return getRuleContext(Instruction_mulContext.class, 0);
        }

        public BinaryinstructionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_binaryinstruction;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterBinaryinstruction(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitBinaryinstruction(this);
        }
    }

    public final BinaryinstructionContext binaryinstruction() throws RecognitionException {
        BinaryinstructionContext _localctx = new BinaryinstructionContext(_ctx, getState());
        enterRule(_localctx, 158, RULE_binaryinstruction);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1141);
                switch (_input.LA(1)) {
                    case T__15: {
                        setState(1105);
                        ((BinaryinstructionContext) _localctx).op1 = instruction_add();

                        ((BinaryinstructionContext) _localctx).result = ((BinaryinstructionContext) _localctx).op1.result;

                    }
                        break;
                    case T__106: {
                        setState(1108);
                        ((BinaryinstructionContext) _localctx).op2 = instruction_fadd();

                        ((BinaryinstructionContext) _localctx).result = ((BinaryinstructionContext) _localctx).op2.result;

                    }
                        break;
                    case T__84: {
                        setState(1111);
                        ((BinaryinstructionContext) _localctx).op3 = instruction_sub();

                        ((BinaryinstructionContext) _localctx).result = ((BinaryinstructionContext) _localctx).op3.result;

                    }
                        break;
                    case T__226: {
                        setState(1114);
                        ((BinaryinstructionContext) _localctx).op4 = instruction_fsub();

                        ((BinaryinstructionContext) _localctx).result = ((BinaryinstructionContext) _localctx).op4.result;

                    }
                        break;
                    case T__210: {
                        setState(1117);
                        ((BinaryinstructionContext) _localctx).op5 = instruction_mul();

                        ((BinaryinstructionContext) _localctx).result = ((BinaryinstructionContext) _localctx).op5.result;

                    }
                        break;
                    case T__90: {
                        setState(1120);
                        ((BinaryinstructionContext) _localctx).op6 = instruction_fmul();

                        ((BinaryinstructionContext) _localctx).result = ((BinaryinstructionContext) _localctx).op6.result;

                    }
                        break;
                    case T__81: {
                        setState(1123);
                        ((BinaryinstructionContext) _localctx).op7 = instruction_udiv();

                        ((BinaryinstructionContext) _localctx).result = ((BinaryinstructionContext) _localctx).op7.result;

                    }
                        break;
                    case T__236: {
                        setState(1126);
                        ((BinaryinstructionContext) _localctx).op8 = instruction_sdiv();

                        ((BinaryinstructionContext) _localctx).result = ((BinaryinstructionContext) _localctx).op8.result;

                    }
                        break;
                    case T__102: {
                        setState(1129);
                        ((BinaryinstructionContext) _localctx).op9 = instruction_fdiv();

                        ((BinaryinstructionContext) _localctx).result = ((BinaryinstructionContext) _localctx).op9.result;

                    }
                        break;
                    case T__205: {
                        setState(1132);
                        ((BinaryinstructionContext) _localctx).op10 = instruction_urem();

                        ((BinaryinstructionContext) _localctx).result = ((BinaryinstructionContext) _localctx).op10.result;

                    }
                        break;
                    case T__97: {
                        setState(1135);
                        ((BinaryinstructionContext) _localctx).op11 = instruction_srem();

                        ((BinaryinstructionContext) _localctx).result = ((BinaryinstructionContext) _localctx).op11.result;

                    }
                        break;
                    case T__22: {
                        setState(1138);
                        ((BinaryinstructionContext) _localctx).op12 = instruction_frem();

                        ((BinaryinstructionContext) _localctx).result = ((BinaryinstructionContext) _localctx).op12.result;

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

    public static class Instruction_addContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Token opcode;
        public ValuerefContext op1;
        public ValuerefContext op2;

        public ValuerefContext valueref(int i) {
            return getRuleContext(ValuerefContext.class, i);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public List<ValuerefContext> valueref() {
            return getRuleContexts(ValuerefContext.class);
        }

        public Instruction_addContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_add;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_add(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_add(this);
        }
    }

    public final Instruction_addContext instruction_add() throws RecognitionException {
        Instruction_addContext _localctx = new Instruction_addContext(_ctx, getState());
        enterRule(_localctx, 160, RULE_instruction_add);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1143);
                ((Instruction_addContext) _localctx).opcode = match(T__15);
                {
                    setState(1145);
                    _la = _input.LA(1);
                    if (_la == T__150) {
                        {
                            setState(1144);
                            match(T__150);
                        }
                    }

                    setState(1148);
                    _la = _input.LA(1);
                    if (_la == T__225) {
                        {
                            setState(1147);
                            match(T__225);
                        }
                    }

                }
                setState(1150);
                type();
                setState(1151);
                ((Instruction_addContext) _localctx).op1 = valueref();
                setState(1152);
                match(T__222);
                setState(1153);
                ((Instruction_addContext) _localctx).op2 = valueref();

                LlvmExpressionNode leftNode = ((Instruction_addContext) _localctx).op1.result;
                LlvmExpressionNode rightNode = ((Instruction_addContext) _localctx).op2.result;
                if (((Instruction_addContext) _localctx).op1.result == null) {
                    leftNode = factory.createNumericLiteral(((Instruction_addContext) _localctx).op1.resultToken);
                }
                if (((Instruction_addContext) _localctx).op2.result == null) {
                    rightNode = factory.createNumericLiteral(((Instruction_addContext) _localctx).op2.resultToken);
                }
                ((Instruction_addContext) _localctx).result = factory.createBinary(((Instruction_addContext) _localctx).opcode, leftNode, rightNode);

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

    public static class Instruction_faddContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Token opcode;
        public FastmathflagContext fastmathflag;
        public List<FastmathflagContext> fastmathflags = new ArrayList<FastmathflagContext>();
        public ValuerefContext op1;
        public ValuerefContext op2;

        public List<FastmathflagContext> fastmathflag() {
            return getRuleContexts(FastmathflagContext.class);
        }

        public ValuerefContext valueref(int i) {
            return getRuleContext(ValuerefContext.class, i);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public List<ValuerefContext> valueref() {
            return getRuleContexts(ValuerefContext.class);
        }

        public FastmathflagContext fastmathflag(int i) {
            return getRuleContext(FastmathflagContext.class, i);
        }

        public Instruction_faddContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_fadd;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_fadd(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_fadd(this);
        }
    }

    public final Instruction_faddContext instruction_fadd() throws RecognitionException {
        Instruction_faddContext _localctx = new Instruction_faddContext(_ctx, getState());
        enterRule(_localctx, 162, RULE_instruction_fadd);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1156);
                ((Instruction_faddContext) _localctx).opcode = match(T__106);
                setState(1160);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__219 || _la == T__218 || ((((_la - 152)) & ~0x3f) == 0 && ((1L << (_la - 152)) & ((1L << (T__88 - 152)) | (1L << (T__78 - 152)) | (1L << (T__26 - 152)))) != 0)) {
                    {
                        {
                            setState(1157);
                            ((Instruction_faddContext) _localctx).fastmathflag = fastmathflag();
                            ((Instruction_faddContext) _localctx).fastmathflags.add(((Instruction_faddContext) _localctx).fastmathflag);
                        }
                    }
                    setState(1162);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(1163);
                type();
                setState(1164);
                ((Instruction_faddContext) _localctx).op1 = valueref();
                setState(1165);
                match(T__222);
                setState(1166);
                ((Instruction_faddContext) _localctx).op2 = valueref();

                ((Instruction_faddContext) _localctx).result = factory.createBinary(((Instruction_faddContext) _localctx).opcode, ((Instruction_faddContext) _localctx).op1.result,
                                ((Instruction_faddContext) _localctx).op2.result);

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

    public static class FastmathflagContext extends ParserRuleContext {
        public FastmathflagContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fastmathflag;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterFastmathflag(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitFastmathflag(this);
        }
    }

    public final FastmathflagContext fastmathflag() throws RecognitionException {
        FastmathflagContext _localctx = new FastmathflagContext(_ctx, getState());
        enterRule(_localctx, 164, RULE_fastmathflag);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1169);
                _la = _input.LA(1);
                if (!(_la == T__219 || _la == T__218 || ((((_la - 152)) & ~0x3f) == 0 && ((1L << (_la - 152)) & ((1L << (T__88 - 152)) | (1L << (T__78 - 152)) | (1L << (T__26 - 152)))) != 0))) {
                    _errHandler.recoverInline(this);
                }
                consume();
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

    public static class Instruction_subContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Token opcode;
        public ValuerefContext op1;
        public ValuerefContext op2;

        public ValuerefContext valueref(int i) {
            return getRuleContext(ValuerefContext.class, i);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public List<ValuerefContext> valueref() {
            return getRuleContexts(ValuerefContext.class);
        }

        public Instruction_subContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_sub;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_sub(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_sub(this);
        }
    }

    public final Instruction_subContext instruction_sub() throws RecognitionException {
        Instruction_subContext _localctx = new Instruction_subContext(_ctx, getState());
        enterRule(_localctx, 166, RULE_instruction_sub);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1171);
                ((Instruction_subContext) _localctx).opcode = match(T__84);
                {
                    setState(1173);
                    _la = _input.LA(1);
                    if (_la == T__150) {
                        {
                            setState(1172);
                            match(T__150);
                        }
                    }

                    setState(1176);
                    _la = _input.LA(1);
                    if (_la == T__225) {
                        {
                            setState(1175);
                            match(T__225);
                        }
                    }

                }
                setState(1178);
                type();
                setState(1179);
                ((Instruction_subContext) _localctx).op1 = valueref();
                setState(1180);
                match(T__222);
                setState(1181);
                ((Instruction_subContext) _localctx).op2 = valueref();

                ((Instruction_subContext) _localctx).result = factory.createBinary(((Instruction_subContext) _localctx).opcode, ((Instruction_subContext) _localctx).op1.result,
                                ((Instruction_subContext) _localctx).op2.result);

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

    public static class Instruction_fsubContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Token opcode;
        public FastmathflagContext fastmathflag;
        public List<FastmathflagContext> fastmathflags = new ArrayList<FastmathflagContext>();
        public ValuerefContext op1;
        public ValuerefContext op2;

        public List<FastmathflagContext> fastmathflag() {
            return getRuleContexts(FastmathflagContext.class);
        }

        public ValuerefContext valueref(int i) {
            return getRuleContext(ValuerefContext.class, i);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public List<ValuerefContext> valueref() {
            return getRuleContexts(ValuerefContext.class);
        }

        public FastmathflagContext fastmathflag(int i) {
            return getRuleContext(FastmathflagContext.class, i);
        }

        public Instruction_fsubContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_fsub;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_fsub(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_fsub(this);
        }
    }

    public final Instruction_fsubContext instruction_fsub() throws RecognitionException {
        Instruction_fsubContext _localctx = new Instruction_fsubContext(_ctx, getState());
        enterRule(_localctx, 168, RULE_instruction_fsub);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1184);
                ((Instruction_fsubContext) _localctx).opcode = match(T__226);
                setState(1188);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__219 || _la == T__218 || ((((_la - 152)) & ~0x3f) == 0 && ((1L << (_la - 152)) & ((1L << (T__88 - 152)) | (1L << (T__78 - 152)) | (1L << (T__26 - 152)))) != 0)) {
                    {
                        {
                            setState(1185);
                            ((Instruction_fsubContext) _localctx).fastmathflag = fastmathflag();
                            ((Instruction_fsubContext) _localctx).fastmathflags.add(((Instruction_fsubContext) _localctx).fastmathflag);
                        }
                    }
                    setState(1190);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(1191);
                type();
                setState(1192);
                ((Instruction_fsubContext) _localctx).op1 = valueref();
                setState(1193);
                match(T__222);
                setState(1194);
                ((Instruction_fsubContext) _localctx).op2 = valueref();

                ((Instruction_fsubContext) _localctx).result = factory.createBinary(((Instruction_fsubContext) _localctx).opcode, ((Instruction_fsubContext) _localctx).op1.result,
                                ((Instruction_fsubContext) _localctx).op2.result);

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

    public static class Instruction_mulContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Token opcode;
        public ValuerefContext op1;
        public ValuerefContext op2;

        public ValuerefContext valueref(int i) {
            return getRuleContext(ValuerefContext.class, i);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public List<ValuerefContext> valueref() {
            return getRuleContexts(ValuerefContext.class);
        }

        public Instruction_mulContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_mul;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_mul(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_mul(this);
        }
    }

    public final Instruction_mulContext instruction_mul() throws RecognitionException {
        Instruction_mulContext _localctx = new Instruction_mulContext(_ctx, getState());
        enterRule(_localctx, 170, RULE_instruction_mul);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1197);
                ((Instruction_mulContext) _localctx).opcode = match(T__210);
                {
                    setState(1199);
                    _la = _input.LA(1);
                    if (_la == T__150) {
                        {
                            setState(1198);
                            match(T__150);
                        }
                    }

                    setState(1202);
                    _la = _input.LA(1);
                    if (_la == T__225) {
                        {
                            setState(1201);
                            match(T__225);
                        }
                    }

                }
                setState(1204);
                type();
                setState(1205);
                ((Instruction_mulContext) _localctx).op1 = valueref();
                setState(1206);
                match(T__222);
                setState(1207);
                ((Instruction_mulContext) _localctx).op2 = valueref();

                ((Instruction_mulContext) _localctx).result = factory.createBinary(((Instruction_mulContext) _localctx).opcode, ((Instruction_mulContext) _localctx).op1.result,
                                ((Instruction_mulContext) _localctx).op2.result);

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

    public static class Instruction_fmulContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Token opcode;
        public FastmathflagContext fastmathflag;
        public List<FastmathflagContext> fastmathflags = new ArrayList<FastmathflagContext>();
        public ValuerefContext op1;
        public ValuerefContext op2;

        public List<FastmathflagContext> fastmathflag() {
            return getRuleContexts(FastmathflagContext.class);
        }

        public ValuerefContext valueref(int i) {
            return getRuleContext(ValuerefContext.class, i);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public List<ValuerefContext> valueref() {
            return getRuleContexts(ValuerefContext.class);
        }

        public FastmathflagContext fastmathflag(int i) {
            return getRuleContext(FastmathflagContext.class, i);
        }

        public Instruction_fmulContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_fmul;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_fmul(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_fmul(this);
        }
    }

    public final Instruction_fmulContext instruction_fmul() throws RecognitionException {
        Instruction_fmulContext _localctx = new Instruction_fmulContext(_ctx, getState());
        enterRule(_localctx, 172, RULE_instruction_fmul);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1210);
                ((Instruction_fmulContext) _localctx).opcode = match(T__90);
                setState(1214);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__219 || _la == T__218 || ((((_la - 152)) & ~0x3f) == 0 && ((1L << (_la - 152)) & ((1L << (T__88 - 152)) | (1L << (T__78 - 152)) | (1L << (T__26 - 152)))) != 0)) {
                    {
                        {
                            setState(1211);
                            ((Instruction_fmulContext) _localctx).fastmathflag = fastmathflag();
                            ((Instruction_fmulContext) _localctx).fastmathflags.add(((Instruction_fmulContext) _localctx).fastmathflag);
                        }
                    }
                    setState(1216);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(1217);
                type();
                setState(1218);
                ((Instruction_fmulContext) _localctx).op1 = valueref();
                setState(1219);
                match(T__222);
                setState(1220);
                ((Instruction_fmulContext) _localctx).op2 = valueref();

                ((Instruction_fmulContext) _localctx).result = factory.createBinary(((Instruction_fmulContext) _localctx).opcode, ((Instruction_fmulContext) _localctx).op1.result,
                                ((Instruction_fmulContext) _localctx).op2.result);

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

    public static class Instruction_udivContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Token opcode;
        public ValuerefContext op1;
        public ValuerefContext op2;

        public ValuerefContext valueref(int i) {
            return getRuleContext(ValuerefContext.class, i);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public List<ValuerefContext> valueref() {
            return getRuleContexts(ValuerefContext.class);
        }

        public Instruction_udivContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_udiv;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_udiv(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_udiv(this);
        }
    }

    public final Instruction_udivContext instruction_udiv() throws RecognitionException {
        Instruction_udivContext _localctx = new Instruction_udivContext(_ctx, getState());
        enterRule(_localctx, 174, RULE_instruction_udiv);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1223);
                ((Instruction_udivContext) _localctx).opcode = match(T__81);
                setState(1225);
                _la = _input.LA(1);
                if (_la == T__216) {
                    {
                        setState(1224);
                        match(T__216);
                    }
                }

                setState(1227);
                type();
                setState(1228);
                ((Instruction_udivContext) _localctx).op1 = valueref();
                setState(1229);
                match(T__222);
                setState(1230);
                ((Instruction_udivContext) _localctx).op2 = valueref();

                ((Instruction_udivContext) _localctx).result = factory.createBinary(((Instruction_udivContext) _localctx).opcode, ((Instruction_udivContext) _localctx).op1.result,
                                ((Instruction_udivContext) _localctx).op2.result);

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

    public static class Instruction_sdivContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Token opcode;
        public ValuerefContext op1;
        public ValuerefContext op2;

        public ValuerefContext valueref(int i) {
            return getRuleContext(ValuerefContext.class, i);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public List<ValuerefContext> valueref() {
            return getRuleContexts(ValuerefContext.class);
        }

        public Instruction_sdivContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_sdiv;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_sdiv(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_sdiv(this);
        }
    }

    public final Instruction_sdivContext instruction_sdiv() throws RecognitionException {
        Instruction_sdivContext _localctx = new Instruction_sdivContext(_ctx, getState());
        enterRule(_localctx, 176, RULE_instruction_sdiv);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1233);
                ((Instruction_sdivContext) _localctx).opcode = match(T__236);
                setState(1235);
                _la = _input.LA(1);
                if (_la == T__216) {
                    {
                        setState(1234);
                        match(T__216);
                    }
                }

                setState(1237);
                type();
                setState(1238);
                ((Instruction_sdivContext) _localctx).op1 = valueref();
                setState(1239);
                match(T__222);
                setState(1240);
                ((Instruction_sdivContext) _localctx).op2 = valueref();

                ((Instruction_sdivContext) _localctx).result = factory.createBinary(((Instruction_sdivContext) _localctx).opcode, ((Instruction_sdivContext) _localctx).op1.result,
                                ((Instruction_sdivContext) _localctx).op2.result);

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

    public static class Instruction_fdivContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Token opcode;
        public FastmathflagContext fastmathflag;
        public List<FastmathflagContext> fastmathflags = new ArrayList<FastmathflagContext>();
        public ValuerefContext op1;
        public ValuerefContext op2;

        public List<FastmathflagContext> fastmathflag() {
            return getRuleContexts(FastmathflagContext.class);
        }

        public ValuerefContext valueref(int i) {
            return getRuleContext(ValuerefContext.class, i);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public List<ValuerefContext> valueref() {
            return getRuleContexts(ValuerefContext.class);
        }

        public FastmathflagContext fastmathflag(int i) {
            return getRuleContext(FastmathflagContext.class, i);
        }

        public Instruction_fdivContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_fdiv;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_fdiv(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_fdiv(this);
        }
    }

    public final Instruction_fdivContext instruction_fdiv() throws RecognitionException {
        Instruction_fdivContext _localctx = new Instruction_fdivContext(_ctx, getState());
        enterRule(_localctx, 178, RULE_instruction_fdiv);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1243);
                ((Instruction_fdivContext) _localctx).opcode = match(T__102);
                setState(1247);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__219 || _la == T__218 || ((((_la - 152)) & ~0x3f) == 0 && ((1L << (_la - 152)) & ((1L << (T__88 - 152)) | (1L << (T__78 - 152)) | (1L << (T__26 - 152)))) != 0)) {
                    {
                        {
                            setState(1244);
                            ((Instruction_fdivContext) _localctx).fastmathflag = fastmathflag();
                            ((Instruction_fdivContext) _localctx).fastmathflags.add(((Instruction_fdivContext) _localctx).fastmathflag);
                        }
                    }
                    setState(1249);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(1250);
                type();
                setState(1251);
                ((Instruction_fdivContext) _localctx).op1 = valueref();
                setState(1252);
                match(T__222);
                setState(1253);
                ((Instruction_fdivContext) _localctx).op2 = valueref();

                ((Instruction_fdivContext) _localctx).result = factory.createBinary(((Instruction_fdivContext) _localctx).opcode, ((Instruction_fdivContext) _localctx).op1.result,
                                ((Instruction_fdivContext) _localctx).op2.result);

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

    public static class Instruction_uremContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Token opcode;
        public ValuerefContext op1;
        public ValuerefContext op2;

        public ValuerefContext valueref(int i) {
            return getRuleContext(ValuerefContext.class, i);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public List<ValuerefContext> valueref() {
            return getRuleContexts(ValuerefContext.class);
        }

        public Instruction_uremContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_urem;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_urem(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_urem(this);
        }
    }

    public final Instruction_uremContext instruction_urem() throws RecognitionException {
        Instruction_uremContext _localctx = new Instruction_uremContext(_ctx, getState());
        enterRule(_localctx, 180, RULE_instruction_urem);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1256);
                ((Instruction_uremContext) _localctx).opcode = match(T__205);
                setState(1257);
                type();
                setState(1258);
                ((Instruction_uremContext) _localctx).op1 = valueref();
                setState(1259);
                match(T__222);
                setState(1260);
                ((Instruction_uremContext) _localctx).op2 = valueref();

                ((Instruction_uremContext) _localctx).result = factory.createBinary(((Instruction_uremContext) _localctx).opcode, ((Instruction_uremContext) _localctx).op1.result,
                                ((Instruction_uremContext) _localctx).op2.result);

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

    public static class Instruction_sremContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Token opcode;
        public ValuerefContext op1;
        public ValuerefContext op2;

        public ValuerefContext valueref(int i) {
            return getRuleContext(ValuerefContext.class, i);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public List<ValuerefContext> valueref() {
            return getRuleContexts(ValuerefContext.class);
        }

        public Instruction_sremContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_srem;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_srem(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_srem(this);
        }
    }

    public final Instruction_sremContext instruction_srem() throws RecognitionException {
        Instruction_sremContext _localctx = new Instruction_sremContext(_ctx, getState());
        enterRule(_localctx, 182, RULE_instruction_srem);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1263);
                ((Instruction_sremContext) _localctx).opcode = match(T__97);
                setState(1264);
                type();
                setState(1265);
                ((Instruction_sremContext) _localctx).op1 = valueref();
                setState(1266);
                match(T__222);
                setState(1267);
                ((Instruction_sremContext) _localctx).op2 = valueref();

                ((Instruction_sremContext) _localctx).result = factory.createBinary(((Instruction_sremContext) _localctx).opcode, ((Instruction_sremContext) _localctx).op1.result,
                                ((Instruction_sremContext) _localctx).op2.result);

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

    public static class Instruction_fremContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Token opcode;
        public ValuerefContext op1;
        public ValuerefContext op2;

        public ValuerefContext valueref(int i) {
            return getRuleContext(ValuerefContext.class, i);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public List<ValuerefContext> valueref() {
            return getRuleContexts(ValuerefContext.class);
        }

        public Instruction_fremContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_frem;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_frem(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_frem(this);
        }
    }

    public final Instruction_fremContext instruction_frem() throws RecognitionException {
        Instruction_fremContext _localctx = new Instruction_fremContext(_ctx, getState());
        enterRule(_localctx, 184, RULE_instruction_frem);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1270);
                ((Instruction_fremContext) _localctx).opcode = match(T__22);
                setState(1271);
                type();
                setState(1272);
                ((Instruction_fremContext) _localctx).op1 = valueref();
                setState(1273);
                match(T__222);
                setState(1274);
                ((Instruction_fremContext) _localctx).op2 = valueref();

                ((Instruction_fremContext) _localctx).result = factory.createBinary(((Instruction_fremContext) _localctx).opcode, ((Instruction_fremContext) _localctx).op1.result,
                                ((Instruction_fremContext) _localctx).op2.result);

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

    public static class BitwisebinaryinstructionContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Instruction_shlContext op1;
        public Instruction_lshrContext op2;
        public Instruction_ashrContext op3;
        public Instruction_andContext op4;
        public Instruction_orContext op5;
        public Instruction_xorContext op6;

        public Instruction_orContext instruction_or() {
            return getRuleContext(Instruction_orContext.class, 0);
        }

        public Instruction_xorContext instruction_xor() {
            return getRuleContext(Instruction_xorContext.class, 0);
        }

        public Instruction_shlContext instruction_shl() {
            return getRuleContext(Instruction_shlContext.class, 0);
        }

        public Instruction_ashrContext instruction_ashr() {
            return getRuleContext(Instruction_ashrContext.class, 0);
        }

        public Instruction_lshrContext instruction_lshr() {
            return getRuleContext(Instruction_lshrContext.class, 0);
        }

        public Instruction_andContext instruction_and() {
            return getRuleContext(Instruction_andContext.class, 0);
        }

        public BitwisebinaryinstructionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_bitwisebinaryinstruction;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterBitwisebinaryinstruction(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitBitwisebinaryinstruction(this);
        }
    }

    public final BitwisebinaryinstructionContext bitwisebinaryinstruction() throws RecognitionException {
        BitwisebinaryinstructionContext _localctx = new BitwisebinaryinstructionContext(_ctx, getState());
        enterRule(_localctx, 186, RULE_bitwisebinaryinstruction);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1295);
                switch (_input.LA(1)) {
                    case T__65: {
                        setState(1277);
                        ((BitwisebinaryinstructionContext) _localctx).op1 = instruction_shl();

                        ((BitwisebinaryinstructionContext) _localctx).result = ((BitwisebinaryinstructionContext) _localctx).op1.result;

                    }
                        break;
                    case T__112: {
                        setState(1280);
                        ((BitwisebinaryinstructionContext) _localctx).op2 = instruction_lshr();

                        ((BitwisebinaryinstructionContext) _localctx).result = ((BitwisebinaryinstructionContext) _localctx).op2.result;

                    }
                        break;
                    case T__133: {
                        setState(1283);
                        ((BitwisebinaryinstructionContext) _localctx).op3 = instruction_ashr();

                        ((BitwisebinaryinstructionContext) _localctx).result = ((BitwisebinaryinstructionContext) _localctx).op3.result;

                    }
                        break;
                    case T__169: {
                        setState(1286);
                        ((BitwisebinaryinstructionContext) _localctx).op4 = instruction_and();

                        ((BitwisebinaryinstructionContext) _localctx).result = ((BitwisebinaryinstructionContext) _localctx).op4.result;

                    }
                        break;
                    case T__105: {
                        setState(1289);
                        ((BitwisebinaryinstructionContext) _localctx).op5 = instruction_or();

                        ((BitwisebinaryinstructionContext) _localctx).result = ((BitwisebinaryinstructionContext) _localctx).op5.result;

                    }
                        break;
                    case T__173: {
                        setState(1292);
                        ((BitwisebinaryinstructionContext) _localctx).op6 = instruction_xor();

                        ((BitwisebinaryinstructionContext) _localctx).result = ((BitwisebinaryinstructionContext) _localctx).op6.result;

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

    public static class Instruction_shlContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Token opcode;
        public ValuerefContext op1;
        public ValuerefContext op2;

        public ValuerefContext valueref(int i) {
            return getRuleContext(ValuerefContext.class, i);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public List<ValuerefContext> valueref() {
            return getRuleContexts(ValuerefContext.class);
        }

        public Instruction_shlContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_shl;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_shl(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_shl(this);
        }
    }

    public final Instruction_shlContext instruction_shl() throws RecognitionException {
        Instruction_shlContext _localctx = new Instruction_shlContext(_ctx, getState());
        enterRule(_localctx, 188, RULE_instruction_shl);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1297);
                ((Instruction_shlContext) _localctx).opcode = match(T__65);
                {
                    setState(1299);
                    _la = _input.LA(1);
                    if (_la == T__150) {
                        {
                            setState(1298);
                            match(T__150);
                        }
                    }

                    setState(1302);
                    _la = _input.LA(1);
                    if (_la == T__225) {
                        {
                            setState(1301);
                            match(T__225);
                        }
                    }

                }
                setState(1304);
                type();
                setState(1305);
                ((Instruction_shlContext) _localctx).op1 = valueref();
                setState(1306);
                match(T__222);
                setState(1307);
                ((Instruction_shlContext) _localctx).op2 = valueref();

                ((Instruction_shlContext) _localctx).result = factory.createBinary(((Instruction_shlContext) _localctx).opcode, ((Instruction_shlContext) _localctx).op1.result,
                                ((Instruction_shlContext) _localctx).op2.result);

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

    public static class Instruction_lshrContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Token opcode;
        public ValuerefContext op1;
        public ValuerefContext op2;

        public ValuerefContext valueref(int i) {
            return getRuleContext(ValuerefContext.class, i);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public List<ValuerefContext> valueref() {
            return getRuleContexts(ValuerefContext.class);
        }

        public Instruction_lshrContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_lshr;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_lshr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_lshr(this);
        }
    }

    public final Instruction_lshrContext instruction_lshr() throws RecognitionException {
        Instruction_lshrContext _localctx = new Instruction_lshrContext(_ctx, getState());
        enterRule(_localctx, 190, RULE_instruction_lshr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1310);
                ((Instruction_lshrContext) _localctx).opcode = match(T__112);
                setState(1312);
                _la = _input.LA(1);
                if (_la == T__216) {
                    {
                        setState(1311);
                        match(T__216);
                    }
                }

                setState(1314);
                type();
                setState(1315);
                ((Instruction_lshrContext) _localctx).op1 = valueref();
                setState(1316);
                match(T__222);
                setState(1317);
                ((Instruction_lshrContext) _localctx).op2 = valueref();

                ((Instruction_lshrContext) _localctx).result = factory.createBinary(((Instruction_lshrContext) _localctx).opcode, ((Instruction_lshrContext) _localctx).op1.result,
                                ((Instruction_lshrContext) _localctx).op2.result);

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

    public static class Instruction_ashrContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Token opcode;
        public ValuerefContext op1;
        public ValuerefContext op2;

        public ValuerefContext valueref(int i) {
            return getRuleContext(ValuerefContext.class, i);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public List<ValuerefContext> valueref() {
            return getRuleContexts(ValuerefContext.class);
        }

        public Instruction_ashrContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_ashr;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_ashr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_ashr(this);
        }
    }

    public final Instruction_ashrContext instruction_ashr() throws RecognitionException {
        Instruction_ashrContext _localctx = new Instruction_ashrContext(_ctx, getState());
        enterRule(_localctx, 192, RULE_instruction_ashr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1320);
                ((Instruction_ashrContext) _localctx).opcode = match(T__133);
                setState(1322);
                _la = _input.LA(1);
                if (_la == T__216) {
                    {
                        setState(1321);
                        match(T__216);
                    }
                }

                setState(1324);
                type();
                setState(1325);
                ((Instruction_ashrContext) _localctx).op1 = valueref();
                setState(1326);
                match(T__222);
                setState(1327);
                ((Instruction_ashrContext) _localctx).op2 = valueref();

                ((Instruction_ashrContext) _localctx).result = factory.createBinary(((Instruction_ashrContext) _localctx).opcode, ((Instruction_ashrContext) _localctx).op1.result,
                                ((Instruction_ashrContext) _localctx).op2.result);

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

    public static class Instruction_andContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Token opcode;
        public ValuerefContext op1;
        public ValuerefContext op2;

        public ValuerefContext valueref(int i) {
            return getRuleContext(ValuerefContext.class, i);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public List<ValuerefContext> valueref() {
            return getRuleContexts(ValuerefContext.class);
        }

        public Instruction_andContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_and;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_and(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_and(this);
        }
    }

    public final Instruction_andContext instruction_and() throws RecognitionException {
        Instruction_andContext _localctx = new Instruction_andContext(_ctx, getState());
        enterRule(_localctx, 194, RULE_instruction_and);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1330);
                ((Instruction_andContext) _localctx).opcode = match(T__169);
                setState(1331);
                type();
                setState(1332);
                ((Instruction_andContext) _localctx).op1 = valueref();
                setState(1333);
                match(T__222);
                setState(1334);
                ((Instruction_andContext) _localctx).op2 = valueref();

                ((Instruction_andContext) _localctx).result = factory.createBinary(((Instruction_andContext) _localctx).opcode, ((Instruction_andContext) _localctx).op1.result,
                                ((Instruction_andContext) _localctx).op2.result);

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

    public static class Instruction_orContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Token opcode;
        public ValuerefContext op1;
        public ValuerefContext op2;

        public ValuerefContext valueref(int i) {
            return getRuleContext(ValuerefContext.class, i);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public List<ValuerefContext> valueref() {
            return getRuleContexts(ValuerefContext.class);
        }

        public Instruction_orContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_or;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_or(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_or(this);
        }
    }

    public final Instruction_orContext instruction_or() throws RecognitionException {
        Instruction_orContext _localctx = new Instruction_orContext(_ctx, getState());
        enterRule(_localctx, 196, RULE_instruction_or);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1337);
                ((Instruction_orContext) _localctx).opcode = match(T__105);
                setState(1338);
                type();
                setState(1339);
                ((Instruction_orContext) _localctx).op1 = valueref();
                setState(1340);
                match(T__222);
                setState(1341);
                ((Instruction_orContext) _localctx).op2 = valueref();

                ((Instruction_orContext) _localctx).result = factory.createBinary(((Instruction_orContext) _localctx).opcode, ((Instruction_orContext) _localctx).op1.result,
                                ((Instruction_orContext) _localctx).op2.result);

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

    public static class Instruction_xorContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Token opcode;
        public ValuerefContext op1;
        public ValuerefContext op2;

        public ValuerefContext valueref(int i) {
            return getRuleContext(ValuerefContext.class, i);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public List<ValuerefContext> valueref() {
            return getRuleContexts(ValuerefContext.class);
        }

        public Instruction_xorContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_xor;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_xor(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_xor(this);
        }
    }

    public final Instruction_xorContext instruction_xor() throws RecognitionException {
        Instruction_xorContext _localctx = new Instruction_xorContext(_ctx, getState());
        enterRule(_localctx, 198, RULE_instruction_xor);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1344);
                ((Instruction_xorContext) _localctx).opcode = match(T__173);
                setState(1345);
                type();
                setState(1346);
                ((Instruction_xorContext) _localctx).op1 = valueref();
                setState(1347);
                match(T__222);
                setState(1348);
                ((Instruction_xorContext) _localctx).op2 = valueref();

                ((Instruction_xorContext) _localctx).result = factory.createBinary(((Instruction_xorContext) _localctx).opcode, ((Instruction_xorContext) _localctx).op1.result,
                                ((Instruction_xorContext) _localctx).op2.result);

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

    public static class VectorinstructionsContext extends ParserRuleContext {
        public Instruction_shufflevectorContext instruction_shufflevector() {
            return getRuleContext(Instruction_shufflevectorContext.class, 0);
        }

        public Instruction_insertelementContext instruction_insertelement() {
            return getRuleContext(Instruction_insertelementContext.class, 0);
        }

        public Instruction_extractelementContext instruction_extractelement() {
            return getRuleContext(Instruction_extractelementContext.class, 0);
        }

        public VectorinstructionsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_vectorinstructions;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterVectorinstructions(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitVectorinstructions(this);
        }
    }

    public final VectorinstructionsContext vectorinstructions() throws RecognitionException {
        VectorinstructionsContext _localctx = new VectorinstructionsContext(_ctx, getState());
        enterRule(_localctx, 200, RULE_vectorinstructions);
        try {
            setState(1354);
            switch (_input.LA(1)) {
                case T__228:
                    enterOuterAlt(_localctx, 1);
                    {
                        setState(1351);
                        instruction_extractelement();
                    }
                    break;
                case T__74:
                    enterOuterAlt(_localctx, 2);
                    {
                        setState(1352);
                        instruction_insertelement();
                    }
                    break;
                case T__186:
                    enterOuterAlt(_localctx, 3);
                    {
                        setState(1353);
                        instruction_shufflevector();
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

    public static class Instruction_extractelementContext extends ParserRuleContext {
        public Token opcode;
        public TypedvalueContext vector;
        public TypedvalueContext index;

        public TypedvalueContext typedvalue(int i) {
            return getRuleContext(TypedvalueContext.class, i);
        }

        public List<TypedvalueContext> typedvalue() {
            return getRuleContexts(TypedvalueContext.class);
        }

        public Instruction_extractelementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_extractelement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_extractelement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_extractelement(this);
        }
    }

    public final Instruction_extractelementContext instruction_extractelement() throws RecognitionException {
        Instruction_extractelementContext _localctx = new Instruction_extractelementContext(_ctx, getState());
        enterRule(_localctx, 202, RULE_instruction_extractelement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1356);
                ((Instruction_extractelementContext) _localctx).opcode = match(T__228);
                setState(1357);
                ((Instruction_extractelementContext) _localctx).vector = typedvalue();
                setState(1358);
                match(T__222);
                setState(1359);
                ((Instruction_extractelementContext) _localctx).index = typedvalue();
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

    public static class Instruction_insertelementContext extends ParserRuleContext {
        public Token opcode;
        public TypedvalueContext vector;
        public TypedvalueContext element;
        public TypedvalueContext index;

        public TypedvalueContext typedvalue(int i) {
            return getRuleContext(TypedvalueContext.class, i);
        }

        public List<TypedvalueContext> typedvalue() {
            return getRuleContexts(TypedvalueContext.class);
        }

        public Instruction_insertelementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_insertelement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_insertelement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_insertelement(this);
        }
    }

    public final Instruction_insertelementContext instruction_insertelement() throws RecognitionException {
        Instruction_insertelementContext _localctx = new Instruction_insertelementContext(_ctx, getState());
        enterRule(_localctx, 204, RULE_instruction_insertelement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1361);
                ((Instruction_insertelementContext) _localctx).opcode = match(T__74);
                setState(1362);
                ((Instruction_insertelementContext) _localctx).vector = typedvalue();
                setState(1363);
                match(T__222);
                setState(1364);
                ((Instruction_insertelementContext) _localctx).element = typedvalue();
                setState(1365);
                match(T__222);
                setState(1366);
                ((Instruction_insertelementContext) _localctx).index = typedvalue();
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

    public static class Instruction_shufflevectorContext extends ParserRuleContext {
        public Token opcode;
        public TypedvalueContext vector1;
        public TypedvalueContext vector2;
        public TypedvalueContext mask;

        public TypedvalueContext typedvalue(int i) {
            return getRuleContext(TypedvalueContext.class, i);
        }

        public List<TypedvalueContext> typedvalue() {
            return getRuleContexts(TypedvalueContext.class);
        }

        public Instruction_shufflevectorContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_shufflevector;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_shufflevector(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_shufflevector(this);
        }
    }

    public final Instruction_shufflevectorContext instruction_shufflevector() throws RecognitionException {
        Instruction_shufflevectorContext _localctx = new Instruction_shufflevectorContext(_ctx, getState());
        enterRule(_localctx, 206, RULE_instruction_shufflevector);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1368);
                ((Instruction_shufflevectorContext) _localctx).opcode = match(T__186);
                setState(1369);
                ((Instruction_shufflevectorContext) _localctx).vector1 = typedvalue();
                setState(1370);
                match(T__222);
                setState(1371);
                ((Instruction_shufflevectorContext) _localctx).vector2 = typedvalue();
                setState(1372);
                match(T__222);
                setState(1373);
                ((Instruction_shufflevectorContext) _localctx).mask = typedvalue();
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

    public static class AggregateinstructionContext extends ParserRuleContext {
        public Instruction_insertvalueContext instruction_insertvalue() {
            return getRuleContext(Instruction_insertvalueContext.class, 0);
        }

        public Instruction_extractvalueContext instruction_extractvalue() {
            return getRuleContext(Instruction_extractvalueContext.class, 0);
        }

        public AggregateinstructionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_aggregateinstruction;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterAggregateinstruction(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitAggregateinstruction(this);
        }
    }

    public final AggregateinstructionContext aggregateinstruction() throws RecognitionException {
        AggregateinstructionContext _localctx = new AggregateinstructionContext(_ctx, getState());
        enterRule(_localctx, 208, RULE_aggregateinstruction);
        try {
            setState(1377);
            switch (_input.LA(1)) {
                case T__51:
                    enterOuterAlt(_localctx, 1);
                    {
                        setState(1375);
                        instruction_extractvalue();
                    }
                    break;
                case T__224:
                    enterOuterAlt(_localctx, 2);
                    {
                        setState(1376);
                        instruction_insertvalue();
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

    public static class Instruction_extractvalueContext extends ParserRuleContext {
        public Token opcode;
        public TypedvalueContext aggregate;
        public ConstantContext constant;
        public List<ConstantContext> indices = new ArrayList<ConstantContext>();

        public List<ConstantContext> constant() {
            return getRuleContexts(ConstantContext.class);
        }

        public TypedvalueContext typedvalue() {
            return getRuleContext(TypedvalueContext.class, 0);
        }

        public ConstantContext constant(int i) {
            return getRuleContext(ConstantContext.class, i);
        }

        public Instruction_extractvalueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_extractvalue;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_extractvalue(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_extractvalue(this);
        }
    }

    public final Instruction_extractvalueContext instruction_extractvalue() throws RecognitionException {
        Instruction_extractvalueContext _localctx = new Instruction_extractvalueContext(_ctx, getState());
        enterRule(_localctx, 210, RULE_instruction_extractvalue);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1379);
                ((Instruction_extractvalueContext) _localctx).opcode = match(T__51);
                setState(1380);
                ((Instruction_extractvalueContext) _localctx).aggregate = typedvalue();
                setState(1383);
                _errHandler.sync(this);
                _alt = 1;
                do {
                    switch (_alt) {
                        case 1: {
                            {
                                setState(1381);
                                match(T__222);
                                setState(1382);
                                ((Instruction_extractvalueContext) _localctx).constant = constant();
                                ((Instruction_extractvalueContext) _localctx).indices.add(((Instruction_extractvalueContext) _localctx).constant);
                            }
                        }
                            break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    setState(1385);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 123, _ctx);
                } while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
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

    public static class Instruction_insertvalueContext extends ParserRuleContext {
        public Token opcode;
        public TypedvalueContext aggregate;
        public TypedvalueContext element;
        public ConstantContext constant;
        public List<ConstantContext> indices = new ArrayList<ConstantContext>();

        public List<ConstantContext> constant() {
            return getRuleContexts(ConstantContext.class);
        }

        public TypedvalueContext typedvalue(int i) {
            return getRuleContext(TypedvalueContext.class, i);
        }

        public List<TypedvalueContext> typedvalue() {
            return getRuleContexts(TypedvalueContext.class);
        }

        public ConstantContext constant(int i) {
            return getRuleContext(ConstantContext.class, i);
        }

        public Instruction_insertvalueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_insertvalue;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_insertvalue(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_insertvalue(this);
        }
    }

    public final Instruction_insertvalueContext instruction_insertvalue() throws RecognitionException {
        Instruction_insertvalueContext _localctx = new Instruction_insertvalueContext(_ctx, getState());
        enterRule(_localctx, 212, RULE_instruction_insertvalue);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1387);
                ((Instruction_insertvalueContext) _localctx).opcode = match(T__224);
                setState(1388);
                ((Instruction_insertvalueContext) _localctx).aggregate = typedvalue();
                setState(1389);
                match(T__222);
                setState(1390);
                ((Instruction_insertvalueContext) _localctx).element = typedvalue();
                setState(1393);
                _errHandler.sync(this);
                _alt = 1;
                do {
                    switch (_alt) {
                        case 1: {
                            {
                                setState(1391);
                                match(T__222);
                                setState(1392);
                                ((Instruction_insertvalueContext) _localctx).constant = constant();
                                ((Instruction_insertvalueContext) _localctx).indices.add(((Instruction_insertvalueContext) _localctx).constant);
                            }
                        }
                            break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    setState(1395);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 124, _ctx);
                } while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
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

    public static class MemoryinstructionContext extends ParserRuleContext {
        public Instruction_allocaContext instruction_alloca() {
            return getRuleContext(Instruction_allocaContext.class, 0);
        }

        public Instruction_storeContext instruction_store() {
            return getRuleContext(Instruction_storeContext.class, 0);
        }

        public Instruction_cmpxchgContext instruction_cmpxchg() {
            return getRuleContext(Instruction_cmpxchgContext.class, 0);
        }

        public Instruction_getelementptrContext instruction_getelementptr() {
            return getRuleContext(Instruction_getelementptrContext.class, 0);
        }

        public Instruction_atomicrmwContext instruction_atomicrmw() {
            return getRuleContext(Instruction_atomicrmwContext.class, 0);
        }

        public Instruction_loadContext instruction_load() {
            return getRuleContext(Instruction_loadContext.class, 0);
        }

        public Instruction_fenceContext instruction_fence() {
            return getRuleContext(Instruction_fenceContext.class, 0);
        }

        public MemoryinstructionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_memoryinstruction;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterMemoryinstruction(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitMemoryinstruction(this);
        }
    }

    public final MemoryinstructionContext memoryinstruction() throws RecognitionException {
        MemoryinstructionContext _localctx = new MemoryinstructionContext(_ctx, getState());
        enterRule(_localctx, 214, RULE_memoryinstruction);
        try {
            setState(1404);
            switch (_input.LA(1)) {
                case T__124:
                    enterOuterAlt(_localctx, 1);
                    {
                        setState(1397);
                        instruction_alloca();
                    }
                    break;
                case T__52:
                    enterOuterAlt(_localctx, 2);
                    {
                        setState(1398);
                        instruction_load();
                    }
                    break;
                case T__189:
                    enterOuterAlt(_localctx, 3);
                    {
                        setState(1399);
                        instruction_store();
                    }
                    break;
                case T__13:
                    enterOuterAlt(_localctx, 4);
                    {
                        setState(1400);
                        instruction_fence();
                    }
                    break;
                case T__191:
                    enterOuterAlt(_localctx, 5);
                    {
                        setState(1401);
                        instruction_cmpxchg();
                    }
                    break;
                case T__126:
                    enterOuterAlt(_localctx, 6);
                    {
                        setState(1402);
                        instruction_atomicrmw();
                    }
                    break;
                case T__213:
                    enterOuterAlt(_localctx, 7);
                    {
                        setState(1403);
                        instruction_getelementptr();
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

    public static class Instruction_allocaContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Token opcode;
        public TypedvalueContext numelements;
        public AlignContext alignment;

        public AlignContext align() {
            return getRuleContext(AlignContext.class, 0);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public TypedvalueContext typedvalue() {
            return getRuleContext(TypedvalueContext.class, 0);
        }

        public Instruction_allocaContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_alloca;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_alloca(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_alloca(this);
        }
    }

    public final Instruction_allocaContext instruction_alloca() throws RecognitionException {
        Instruction_allocaContext _localctx = new Instruction_allocaContext(_ctx, getState());
        enterRule(_localctx, 216, RULE_instruction_alloca);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1406);
                ((Instruction_allocaContext) _localctx).opcode = match(T__124);
                setState(1407);
                type();
                setState(1412);
                switch (getInterpreter().adaptivePredict(_input, 126, _ctx)) {
                    case 1: {
                        setState(1408);
                        match(T__222);
                        setState(1409);
                        ((Instruction_allocaContext) _localctx).numelements = typedvalue();

                        ((Instruction_allocaContext) _localctx).result = ((Instruction_allocaContext) _localctx).numelements.result;

                    }
                        break;
                }
                setState(1418);
                switch (getInterpreter().adaptivePredict(_input, 127, _ctx)) {
                    case 1: {
                        setState(1414);
                        match(T__222);
                        setState(1415);
                        ((Instruction_allocaContext) _localctx).alignment = align();

                        ((Instruction_allocaContext) _localctx).result = factory.createNumericLiteral(((Instruction_allocaContext) _localctx).alignment.result);

                    }
                        break;
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

    public static class Instruction_loadContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Token opcode;
        public Token Local_id;
        public AlignContext alignment;
        public MetadatarefContext nontemporalindex;
        public MetadatarefContext invariantloadindex;

        public MetadatarefContext metadataref(int i) {
            return getRuleContext(MetadatarefContext.class, i);
        }

        public List<MetadatarefContext> metadataref() {
            return getRuleContexts(MetadatarefContext.class);
        }

        public TypeContext type(int i) {
            return getRuleContext(TypeContext.class, i);
        }

        public TerminalNode Local_id() {
            return getToken(LLVM_IRParser.Local_id, 0);
        }

        public AlignContext align() {
            return getRuleContext(AlignContext.class, 0);
        }

        public List<TypeContext> type() {
            return getRuleContexts(TypeContext.class);
        }

        public OrderingContext ordering() {
            return getRuleContext(OrderingContext.class, 0);
        }

        public Instruction_loadContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_load;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_load(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_load(this);
        }
    }

    public final Instruction_loadContext instruction_load() throws RecognitionException {
        Instruction_loadContext _localctx = new Instruction_loadContext(_ctx, getState());
        enterRule(_localctx, 218, RULE_instruction_load);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1420);
                ((Instruction_loadContext) _localctx).opcode = match(T__52);
                setState(1458);
                switch (_input.LA(1)) {
                    case T__212:
                    case T__211:
                    case T__178:
                    case T__157:
                    case T__154:
                    case T__145:
                    case T__140:
                    case T__118:
                    case T__47:
                    case Int_type:
                    case Local_id:
                    case Floatingtype: {
                        {
                            setState(1422);
                            _la = _input.LA(1);
                            if (_la == T__145) {
                                {
                                    setState(1421);
                                    match(T__145);
                                }
                            }

                            setState(1424);
                            type();
                            setState(1427);
                            _la = _input.LA(1);
                            if (_la == T__222) {
                                {
                                    setState(1425);
                                    match(T__222);
                                    setState(1426);
                                    type();
                                }
                            }

                            setState(1429);
                            ((Instruction_loadContext) _localctx).Local_id = match(Local_id);

                            ((Instruction_loadContext) _localctx).result = factory.createRead(((Instruction_loadContext) _localctx).Local_id);
                            setState(1433);
                            switch (getInterpreter().adaptivePredict(_input, 130, _ctx)) {
                                case 1: {
                                    setState(1431);
                                    match(T__222);
                                    setState(1432);
                                    ((Instruction_loadContext) _localctx).alignment = align();
                                }
                                    break;
                            }
                            setState(1438);
                            switch (getInterpreter().adaptivePredict(_input, 131, _ctx)) {
                                case 1: {
                                    setState(1435);
                                    match(T__222);
                                    setState(1436);
                                    match(T__238);
                                    setState(1437);
                                    ((Instruction_loadContext) _localctx).nontemporalindex = metadataref();
                                }
                                    break;
                            }
                            setState(1443);
                            switch (getInterpreter().adaptivePredict(_input, 132, _ctx)) {
                                case 1: {
                                    setState(1440);
                                    match(T__222);
                                    setState(1441);
                                    match(T__48);
                                    setState(1442);
                                    ((Instruction_loadContext) _localctx).invariantloadindex = metadataref();
                                }
                                    break;
                            }
                        }
                    }
                        break;
                    case T__182: {
                        {
                            setState(1445);
                            match(T__182);
                            setState(1447);
                            _la = _input.LA(1);
                            if (_la == T__145) {
                                {
                                    setState(1446);
                                    match(T__145);
                                }
                            }

                            setState(1449);
                            type();
                            setState(1450);
                            ((Instruction_loadContext) _localctx).Local_id = match(Local_id);

                            ((Instruction_loadContext) _localctx).result = factory.createRead(((Instruction_loadContext) _localctx).Local_id);
                            setState(1453);
                            _la = _input.LA(1);
                            if (_la == T__101) {
                                {
                                    setState(1452);
                                    match(T__101);
                                }
                            }

                            setState(1455);
                            ordering();
                            setState(1456);
                            align();
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

    public static class Instruction_storeContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Token opcode;
        public Token Local_id;
        public Token value2;
        public Token pointer;
        public AlignContext alignment;
        public MetadatarefContext nontemporalindex;
        public Token value4;

        public MetadatarefContext metadataref() {
            return getRuleContext(MetadatarefContext.class, 0);
        }

        public TypeContext type(int i) {
            return getRuleContext(TypeContext.class, i);
        }

        public List<TerminalNode> Local_id() {
            return getTokens(LLVM_IRParser.Local_id);
        }

        public AlignContext align() {
            return getRuleContext(AlignContext.class, 0);
        }

        public TerminalNode Integer() {
            return getToken(LLVM_IRParser.Integer, 0);
        }

        public List<TypeContext> type() {
            return getRuleContexts(TypeContext.class);
        }

        public OrderingContext ordering() {
            return getRuleContext(OrderingContext.class, 0);
        }

        public TerminalNode Local_id(int i) {
            return getToken(LLVM_IRParser.Local_id, i);
        }

        public Instruction_storeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_store;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_store(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_store(this);
        }
    }

    public final Instruction_storeContext instruction_store() throws RecognitionException {
        Instruction_storeContext _localctx = new Instruction_storeContext(_ctx, getState());
        enterRule(_localctx, 220, RULE_instruction_store);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1460);
                ((Instruction_storeContext) _localctx).opcode = match(T__189);
                setState(1506);
                switch (_input.LA(1)) {
                    case T__212:
                    case T__211:
                    case T__178:
                    case T__157:
                    case T__154:
                    case T__145:
                    case T__140:
                    case T__118:
                    case T__47:
                    case Int_type:
                    case Local_id:
                    case Floatingtype: {
                        {
                            setState(1462);
                            _la = _input.LA(1);
                            if (_la == T__145) {
                                {
                                    setState(1461);
                                    match(T__145);
                                }
                            }

                            setState(1464);
                            type();
                            setState(1469);
                            switch (_input.LA(1)) {
                                case Local_id: {
                                    setState(1465);
                                    ((Instruction_storeContext) _localctx).Local_id = match(Local_id);
                                    ((Instruction_storeContext) _localctx).result = factory.createRead(((Instruction_storeContext) _localctx).Local_id);
                                }
                                    break;
                                case Integer: {
                                    setState(1467);
                                    ((Instruction_storeContext) _localctx).value2 = match(Integer);
                                    ((Instruction_storeContext) _localctx).result = factory.createNumericLiteral(((Instruction_storeContext) _localctx).value2);
                                }
                                    break;
                                default:
                                    throw new NoViableAltException(this);
                            }
                            setState(1471);
                            match(T__222);
                            setState(1472);
                            type();
                            setState(1473);
                            ((Instruction_storeContext) _localctx).pointer = match(Local_id);
                            setState(1476);
                            switch (getInterpreter().adaptivePredict(_input, 138, _ctx)) {
                                case 1: {
                                    setState(1474);
                                    match(T__222);
                                    setState(1475);
                                    ((Instruction_storeContext) _localctx).alignment = align();
                                }
                                    break;
                            }
                            setState(1481);
                            switch (getInterpreter().adaptivePredict(_input, 139, _ctx)) {
                                case 1: {
                                    setState(1478);
                                    match(T__222);
                                    setState(1479);
                                    match(T__238);
                                    setState(1480);
                                    ((Instruction_storeContext) _localctx).nontemporalindex = metadataref();
                                }
                                    break;
                            }

                            ((Instruction_storeContext) _localctx).result = factory.createReassignment(((Instruction_storeContext) _localctx).pointer, _localctx.result);

                        }
                    }
                        break;
                    case T__182: {
                        {
                            setState(1485);
                            match(T__182);
                            setState(1487);
                            _la = _input.LA(1);
                            if (_la == T__145) {
                                {
                                    setState(1486);
                                    match(T__145);
                                }
                            }

                            setState(1489);
                            type();
                            setState(1494);
                            switch (_input.LA(1)) {
                                case Local_id: {
                                    setState(1490);
                                    ((Instruction_storeContext) _localctx).Local_id = match(Local_id);
                                    ((Instruction_storeContext) _localctx).result = factory.createRead(((Instruction_storeContext) _localctx).Local_id);
                                }
                                    break;
                                case Integer: {
                                    setState(1492);
                                    ((Instruction_storeContext) _localctx).value4 = match(Integer);
                                    ((Instruction_storeContext) _localctx).result = factory.createNumericLiteral(((Instruction_storeContext) _localctx).value4);
                                }
                                    break;
                                default:
                                    throw new NoViableAltException(this);
                            }
                            setState(1496);
                            match(T__222);
                            setState(1497);
                            type();
                            setState(1498);
                            ((Instruction_storeContext) _localctx).pointer = match(Local_id);
                            setState(1500);
                            _la = _input.LA(1);
                            if (_la == T__101) {
                                {
                                    setState(1499);
                                    match(T__101);
                                }
                            }

                            setState(1502);
                            ordering();
                            setState(1503);
                            ((Instruction_storeContext) _localctx).alignment = align();

                            ((Instruction_storeContext) _localctx).result = factory.createReassignment(((Instruction_storeContext) _localctx).pointer, _localctx.result);

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

    public static class Instruction_fenceContext extends ParserRuleContext {
        public Token opcode;

        public OrderingContext ordering() {
            return getRuleContext(OrderingContext.class, 0);
        }

        public Instruction_fenceContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_fence;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_fence(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_fence(this);
        }
    }

    public final Instruction_fenceContext instruction_fence() throws RecognitionException {
        Instruction_fenceContext _localctx = new Instruction_fenceContext(_ctx, getState());
        enterRule(_localctx, 222, RULE_instruction_fence);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1508);
                ((Instruction_fenceContext) _localctx).opcode = match(T__13);
                setState(1510);
                _la = _input.LA(1);
                if (_la == T__101) {
                    {
                        setState(1509);
                        match(T__101);
                    }
                }

                setState(1512);
                ordering();
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

    public static class Instruction_cmpxchgContext extends ParserRuleContext {
        public Token opcode;
        public TypedvalueContext pointer;
        public TypedvalueContext comparedwith;
        public TypedvalueContext newvalue;

        public TypedvalueContext typedvalue(int i) {
            return getRuleContext(TypedvalueContext.class, i);
        }

        public OrderingContext ordering() {
            return getRuleContext(OrderingContext.class, 0);
        }

        public List<TypedvalueContext> typedvalue() {
            return getRuleContexts(TypedvalueContext.class);
        }

        public Instruction_cmpxchgContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_cmpxchg;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_cmpxchg(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_cmpxchg(this);
        }
    }

    public final Instruction_cmpxchgContext instruction_cmpxchg() throws RecognitionException {
        Instruction_cmpxchgContext _localctx = new Instruction_cmpxchgContext(_ctx, getState());
        enterRule(_localctx, 224, RULE_instruction_cmpxchg);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1514);
                ((Instruction_cmpxchgContext) _localctx).opcode = match(T__191);
                setState(1516);
                _la = _input.LA(1);
                if (_la == T__145) {
                    {
                        setState(1515);
                        match(T__145);
                    }
                }

                setState(1518);
                ((Instruction_cmpxchgContext) _localctx).pointer = typedvalue();
                setState(1519);
                match(T__222);
                setState(1520);
                ((Instruction_cmpxchgContext) _localctx).comparedwith = typedvalue();
                setState(1521);
                match(T__222);
                setState(1522);
                ((Instruction_cmpxchgContext) _localctx).newvalue = typedvalue();
                setState(1524);
                _la = _input.LA(1);
                if (_la == T__101) {
                    {
                        setState(1523);
                        match(T__101);
                    }
                }

                setState(1526);
                ordering();
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

    public static class Instruction_atomicrmwContext extends ParserRuleContext {
        public Token opcode;
        public Atomicrmw_operationContext operation;
        public TypedvalueContext pointer;

        public TypedvalueContext typedvalue(int i) {
            return getRuleContext(TypedvalueContext.class, i);
        }

        public Atomicrmw_operationContext atomicrmw_operation() {
            return getRuleContext(Atomicrmw_operationContext.class, 0);
        }

        public OrderingContext ordering() {
            return getRuleContext(OrderingContext.class, 0);
        }

        public List<TypedvalueContext> typedvalue() {
            return getRuleContexts(TypedvalueContext.class);
        }

        public Instruction_atomicrmwContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_atomicrmw;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_atomicrmw(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_atomicrmw(this);
        }
    }

    public final Instruction_atomicrmwContext instruction_atomicrmw() throws RecognitionException {
        Instruction_atomicrmwContext _localctx = new Instruction_atomicrmwContext(_ctx, getState());
        enterRule(_localctx, 226, RULE_instruction_atomicrmw);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1528);
                ((Instruction_atomicrmwContext) _localctx).opcode = match(T__126);
                setState(1530);
                _la = _input.LA(1);
                if (_la == T__145) {
                    {
                        setState(1529);
                        match(T__145);
                    }
                }

                setState(1532);
                ((Instruction_atomicrmwContext) _localctx).operation = atomicrmw_operation();
                setState(1533);
                ((Instruction_atomicrmwContext) _localctx).pointer = typedvalue();
                setState(1534);
                match(T__222);
                setState(1535);
                typedvalue();
                setState(1537);
                _la = _input.LA(1);
                if (_la == T__101) {
                    {
                        setState(1536);
                        match(T__101);
                    }
                }

                setState(1539);
                ordering();
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

    public static class Atomicrmw_operationContext extends ParserRuleContext {
        public Atomicrmw_operationContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_atomicrmw_operation;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterAtomicrmw_operation(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitAtomicrmw_operation(this);
        }
    }

    public final Atomicrmw_operationContext atomicrmw_operation() throws RecognitionException {
        Atomicrmw_operationContext _localctx = new Atomicrmw_operationContext(_ctx, getState());
        enterRule(_localctx, 228, RULE_atomicrmw_operation);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1541);
                _la = _input.LA(1);
                if (!(((((_la - 45)) & ~0x3f) == 0 && ((1L << (_la - 45)) & ((1L << (T__195 - 45)) | (1L << (T__173 - 45)) | (1L << (T__169 - 45)) | (1L << (T__155 - 45)))) != 0) ||
                                ((((_la - 124)) & ~0x3f) == 0 && ((1L << (_la - 124)) & ((1L << (T__116 - 124)) | (1L << (T__105 - 124)) | (1L << (T__93 - 124)) | (1L << (T__84 - 124)))) != 0) || ((((_la - 213)) & ~0x3f) == 0 && ((1L << (_la - 213)) & ((1L << (T__27 - 213)) |
                                (1L << (T__16 - 213)) | (1L << (T__15 - 213)))) != 0))) {
                    _errHandler.recoverInline(this);
                }
                consume();
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

    public static class Instruction_getelementptrContext extends ParserRuleContext {
        public Token opcode;
        public TypedvalueContext base;
        public TypedvalueContext typedvalue;
        public List<TypedvalueContext> indices = new ArrayList<TypedvalueContext>();

        public TypedvalueContext typedvalue(int i) {
            return getRuleContext(TypedvalueContext.class, i);
        }

        public List<TypedvalueContext> typedvalue() {
            return getRuleContexts(TypedvalueContext.class);
        }

        public Instruction_getelementptrContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_getelementptr;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_getelementptr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_getelementptr(this);
        }
    }

    public final Instruction_getelementptrContext instruction_getelementptr() throws RecognitionException {
        Instruction_getelementptrContext _localctx = new Instruction_getelementptrContext(_ctx, getState());
        enterRule(_localctx, 230, RULE_instruction_getelementptr);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1543);
                ((Instruction_getelementptrContext) _localctx).opcode = match(T__213);
                setState(1545);
                _la = _input.LA(1);
                if (_la == T__128) {
                    {
                        setState(1544);
                        match(T__128);
                    }
                }

                setState(1547);
                ((Instruction_getelementptrContext) _localctx).base = typedvalue();
                setState(1552);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 150, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(1548);
                                match(T__222);
                                setState(1549);
                                ((Instruction_getelementptrContext) _localctx).typedvalue = typedvalue();
                                ((Instruction_getelementptrContext) _localctx).indices.add(((Instruction_getelementptrContext) _localctx).typedvalue);
                            }
                        }
                    }
                    setState(1554);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 150, _ctx);
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

    public static class ConversioninstructionContext extends ParserRuleContext {
        public ConvertionopcodeContext opcode;
        public TypeContext fromtype;
        public ValuerefContext value;
        public TypeContext targettype;

        public TypeContext type(int i) {
            return getRuleContext(TypeContext.class, i);
        }

        public ConvertionopcodeContext convertionopcode() {
            return getRuleContext(ConvertionopcodeContext.class, 0);
        }

        public List<TypeContext> type() {
            return getRuleContexts(TypeContext.class);
        }

        public ValuerefContext valueref() {
            return getRuleContext(ValuerefContext.class, 0);
        }

        public ConversioninstructionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_conversioninstruction;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterConversioninstruction(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitConversioninstruction(this);
        }
    }

    public final ConversioninstructionContext conversioninstruction() throws RecognitionException {
        ConversioninstructionContext _localctx = new ConversioninstructionContext(_ctx, getState());
        enterRule(_localctx, 232, RULE_conversioninstruction);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1555);
                ((ConversioninstructionContext) _localctx).opcode = convertionopcode();
                setState(1556);
                ((ConversioninstructionContext) _localctx).fromtype = type();
                setState(1557);
                ((ConversioninstructionContext) _localctx).value = valueref();
                setState(1558);
                match(T__179);
                setState(1559);
                ((ConversioninstructionContext) _localctx).targettype = type();
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

    public static class ConvertionopcodeContext extends ParserRuleContext {
        public ConvertionopcodeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_convertionopcode;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterConvertionopcode(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitConvertionopcode(this);
        }
    }

    public final ConvertionopcodeContext convertionopcode() throws RecognitionException {
        ConvertionopcodeContext _localctx = new ConvertionopcodeContext(_ctx, getState());
        enterRule(_localctx, 234, RULE_convertionopcode);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1561);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__215) | (1L << T__190) | (1L << T__184) | (1L << T__181))) != 0) ||
                                ((((_la - 94)) & ~0x3f) == 0 && ((1L << (_la - 94)) & ((1L << (T__146 - 94)) | (1L << (T__117 - 94)) | (1L << (T__111 - 94)) | (1L << (T__85 - 94)))) != 0) || ((((_la - 161)) & ~0x3f) == 0 && ((1L << (_la - 161)) & ((1L << (T__79 - 161)) |
                                (1L << (T__64 - 161)) | (1L << (T__42 - 161)) | (1L << (T__29 - 161)) | (1L << (T__25 - 161)))) != 0))) {
                    _errHandler.recoverInline(this);
                }
                consume();
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

    public static class OtherinstructionContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Instruction_icmpContext op1;

        public Instruction_icmpContext instruction_icmp() {
            return getRuleContext(Instruction_icmpContext.class, 0);
        }

        public Instruction_landingpadContext instruction_landingpad() {
            return getRuleContext(Instruction_landingpadContext.class, 0);
        }

        public Instruction_selectContext instruction_select() {
            return getRuleContext(Instruction_selectContext.class, 0);
        }

        public Instruction_va_argContext instruction_va_arg() {
            return getRuleContext(Instruction_va_argContext.class, 0);
        }

        public Instruction_fcmpContext instruction_fcmp() {
            return getRuleContext(Instruction_fcmpContext.class, 0);
        }

        public OtherinstructionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_otherinstruction;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterOtherinstruction(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitOtherinstruction(this);
        }
    }

    public final OtherinstructionContext otherinstruction() throws RecognitionException {
        OtherinstructionContext _localctx = new OtherinstructionContext(_ctx, getState());
        enterRule(_localctx, 236, RULE_otherinstruction);
        try {
            setState(1570);
            switch (_input.LA(1)) {
                case T__135:
                    enterOuterAlt(_localctx, 1);
                    {
                        setState(1563);
                        ((OtherinstructionContext) _localctx).op1 = instruction_icmp();

                        ((OtherinstructionContext) _localctx).result = ((OtherinstructionContext) _localctx).op1.result;

                    }
                    break;
                case T__110:
                    enterOuterAlt(_localctx, 2);
                    {
                        setState(1566);
                        instruction_fcmp();
                    }
                    break;
                case T__177:
                    enterOuterAlt(_localctx, 3);
                    {
                        setState(1567);
                        instruction_select();
                    }
                    break;
                case T__204:
                    enterOuterAlt(_localctx, 4);
                    {
                        setState(1568);
                        instruction_va_arg();
                    }
                    break;
                case T__198:
                    enterOuterAlt(_localctx, 5);
                    {
                        setState(1569);
                        instruction_landingpad();
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

    public static class Instruction_icmpContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Token opcode;
        public IcmpconditionContext condition;
        public ValuerefContext op1;
        public ValuerefContext op2;

        public IcmpconditionContext icmpcondition() {
            return getRuleContext(IcmpconditionContext.class, 0);
        }

        public ValuerefContext valueref(int i) {
            return getRuleContext(ValuerefContext.class, i);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public List<ValuerefContext> valueref() {
            return getRuleContexts(ValuerefContext.class);
        }

        public Instruction_icmpContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_icmp;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_icmp(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_icmp(this);
        }
    }

    public final Instruction_icmpContext instruction_icmp() throws RecognitionException {
        Instruction_icmpContext _localctx = new Instruction_icmpContext(_ctx, getState());
        enterRule(_localctx, 238, RULE_instruction_icmp);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1572);
                ((Instruction_icmpContext) _localctx).opcode = match(T__135);
                setState(1573);
                ((Instruction_icmpContext) _localctx).condition = icmpcondition();
                setState(1574);
                type();
                setState(1575);
                ((Instruction_icmpContext) _localctx).op1 = valueref();
                setState(1576);
                match(T__222);
                setState(1577);
                ((Instruction_icmpContext) _localctx).op2 = valueref();

                LlvmExpressionNode op1Result = factory.createisReadBlock(((Instruction_icmpContext) _localctx).op1.resultToken);
                if (op1Result == null) {
                    op1Result = factory.createNumericLiteral(((Instruction_icmpContext) _localctx).op1.resultToken);
                }
                LlvmExpressionNode op2Result = factory.createisReadBlock(((Instruction_icmpContext) _localctx).op2.resultToken);
                if (op2Result == null) {
                    op2Result = factory.createNumericLiteral(((Instruction_icmpContext) _localctx).op2.resultToken);
                }
                ((Instruction_icmpContext) _localctx).result = factory.createCompBinary(((Instruction_icmpContext) _localctx).opcode,
                                ((Instruction_icmpContext) _localctx).condition.resultToken.getText(), op1Result, op2Result);

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

    public static class IcmpconditionContext extends ParserRuleContext {
        public Token resultToken;
        public Token opconde;

        public IcmpconditionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_icmpcondition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterIcmpcondition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitIcmpcondition(this);
        }
    }

    public final IcmpconditionContext icmpcondition() throws RecognitionException {
        IcmpconditionContext _localctx = new IcmpconditionContext(_ctx, getState());
        enterRule(_localctx, 240, RULE_icmpcondition);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1580);
                ((IcmpconditionContext) _localctx).opconde = _input.LT(1);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__232) | (1L << T__217) | (1L << T__199))) != 0) ||
                                ((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (T__160 - 80)) | (1L << (T__151 - 80)) | (1L << (T__138 - 80)))) != 0) || ((((_la - 173)) & ~0x3f) == 0 && ((1L << (_la - 173)) & ((1L << (T__67 - 173)) |
                                (1L << (T__63 - 173)) | (1L << (T__49 - 173)) | (1L << (T__4 - 173)))) != 0))) {
                    ((IcmpconditionContext) _localctx).opconde = (Token) _errHandler.recoverInline(this);
                }
                consume();

                ((IcmpconditionContext) _localctx).resultToken = ((IcmpconditionContext) _localctx).opconde;

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

    public static class Instruction_fcmpContext extends ParserRuleContext {
        public Token opcode;
        public FcmpconditionContext condition;
        public ValuerefContext op1;
        public ValuerefContext op2;

        public FcmpconditionContext fcmpcondition() {
            return getRuleContext(FcmpconditionContext.class, 0);
        }

        public ValuerefContext valueref(int i) {
            return getRuleContext(ValuerefContext.class, i);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public List<ValuerefContext> valueref() {
            return getRuleContexts(ValuerefContext.class);
        }

        public Instruction_fcmpContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_fcmp;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_fcmp(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_fcmp(this);
        }
    }

    public final Instruction_fcmpContext instruction_fcmp() throws RecognitionException {
        Instruction_fcmpContext _localctx = new Instruction_fcmpContext(_ctx, getState());
        enterRule(_localctx, 242, RULE_instruction_fcmp);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1583);
                ((Instruction_fcmpContext) _localctx).opcode = match(T__110);
                setState(1584);
                ((Instruction_fcmpContext) _localctx).condition = fcmpcondition();
                setState(1585);
                type();
                setState(1586);
                ((Instruction_fcmpContext) _localctx).op1 = valueref();
                setState(1587);
                match(T__222);
                setState(1588);
                ((Instruction_fcmpContext) _localctx).op2 = valueref();
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

    public static class FcmpconditionContext extends ParserRuleContext {
        public TerminalNode Boolean() {
            return getToken(LLVM_IRParser.Boolean, 0);
        }

        public FcmpconditionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fcmpcondition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterFcmpcondition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitFcmpcondition(this);
        }
    }

    public final FcmpconditionContext fcmpcondition() throws RecognitionException {
        FcmpconditionContext _localctx = new FcmpconditionContext(_ctx, getState());
        enterRule(_localctx, 244, RULE_fcmpcondition);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1590);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__239) | (1L << T__232) | (1L << T__199))) != 0) ||
                                ((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & ((1L << (T__153 - 87)) | (1L << (T__141 - 87)) | (1L << (T__138 - 87)) | (1L << (T__134 - 87)) |
                                                (1L << (T__123 - 87)) | (1L << (T__96 - 87)))) != 0) ||
                                ((((_la - 160)) & ~0x3f) == 0 && ((1L << (_la - 160)) & ((1L << (T__80 - 160)) | (1L << (T__73 - 160)) | (1L << (T__67 - 160)) | (1L << (T__53 - 160)) | (1L << (T__32 - 160)))) != 0) || _la == Boolean)) {
                    _errHandler.recoverInline(this);
                }
                consume();
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

    public static class Instruction_phiContext extends ParserRuleContext {
        public Token opcode;
        public ValuerefContext valueref;
        public List<ValuerefContext> values = new ArrayList<ValuerefContext>();
        public BasicblockrefContext basicblockref;
        public List<BasicblockrefContext> labels = new ArrayList<BasicblockrefContext>();

        public BasicblockrefContext basicblockref(int i) {
            return getRuleContext(BasicblockrefContext.class, i);
        }

        public ValuerefContext valueref(int i) {
            return getRuleContext(ValuerefContext.class, i);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public List<BasicblockrefContext> basicblockref() {
            return getRuleContexts(BasicblockrefContext.class);
        }

        public List<ValuerefContext> valueref() {
            return getRuleContexts(ValuerefContext.class);
        }

        public Instruction_phiContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_phi;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_phi(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_phi(this);
        }
    }

    public final Instruction_phiContext instruction_phi() throws RecognitionException {
        Instruction_phiContext _localctx = new Instruction_phiContext(_ctx, getState());
        enterRule(_localctx, 246, RULE_instruction_phi);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1592);
                ((Instruction_phiContext) _localctx).opcode = match(T__119);
                setState(1593);
                type();
                {
                    setState(1594);
                    match(T__178);
                    setState(1595);
                    ((Instruction_phiContext) _localctx).valueref = valueref();
                    ((Instruction_phiContext) _localctx).values.add(((Instruction_phiContext) _localctx).valueref);
                    setState(1596);
                    match(T__222);
                    setState(1597);
                    ((Instruction_phiContext) _localctx).basicblockref = basicblockref();
                    ((Instruction_phiContext) _localctx).labels.add(((Instruction_phiContext) _localctx).basicblockref);
                    setState(1598);
                    match(T__208);
                }
                setState(1609);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 152, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(1600);
                                match(T__222);
                                setState(1601);
                                match(T__178);
                                setState(1602);
                                ((Instruction_phiContext) _localctx).valueref = valueref();
                                ((Instruction_phiContext) _localctx).values.add(((Instruction_phiContext) _localctx).valueref);
                                setState(1603);
                                match(T__222);
                                setState(1604);
                                ((Instruction_phiContext) _localctx).basicblockref = basicblockref();
                                ((Instruction_phiContext) _localctx).labels.add(((Instruction_phiContext) _localctx).basicblockref);
                                setState(1605);
                                match(T__208);
                            }
                        }
                    }
                    setState(1611);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 152, _ctx);
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

    public static class Instruction_selectContext extends ParserRuleContext {
        public Token opcode;
        public TypedvalueContext condition;
        public TypedvalueContext value1;
        public TypedvalueContext value2;

        public TypedvalueContext typedvalue(int i) {
            return getRuleContext(TypedvalueContext.class, i);
        }

        public List<TypedvalueContext> typedvalue() {
            return getRuleContexts(TypedvalueContext.class);
        }

        public Instruction_selectContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_select;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_select(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_select(this);
        }
    }

    public final Instruction_selectContext instruction_select() throws RecognitionException {
        Instruction_selectContext _localctx = new Instruction_selectContext(_ctx, getState());
        enterRule(_localctx, 248, RULE_instruction_select);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1612);
                ((Instruction_selectContext) _localctx).opcode = match(T__177);
                setState(1613);
                ((Instruction_selectContext) _localctx).condition = typedvalue();
                setState(1614);
                match(T__222);
                setState(1615);
                ((Instruction_selectContext) _localctx).value1 = typedvalue();
                setState(1616);
                match(T__222);
                setState(1617);
                ((Instruction_selectContext) _localctx).value2 = typedvalue();
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

    public static class Instruction_call_nonvoidContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Token istail;
        public Token opcode;
        public ParameterattributesContext returnattributes;
        public CalleeContext functionName;
        public ArglistContext arglistName;

        public NonvoidtypeContext nonvoidtype() {
            return getRuleContext(NonvoidtypeContext.class, 0);
        }

        public CalleeContext callee() {
            return getRuleContext(CalleeContext.class, 0);
        }

        public ParameterattributesContext parameterattributes() {
            return getRuleContext(ParameterattributesContext.class, 0);
        }

        public CconvContext cconv() {
            return getRuleContext(CconvContext.class, 0);
        }

        public FunctionattributesContext functionattributes() {
            return getRuleContext(FunctionattributesContext.class, 0);
        }

        public ArglistContext arglist() {
            return getRuleContext(ArglistContext.class, 0);
        }

        public Instruction_call_nonvoidContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_call_nonvoid;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_call_nonvoid(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_call_nonvoid(this);
        }
    }

    public final Instruction_call_nonvoidContext instruction_call_nonvoid() throws RecognitionException {
        Instruction_call_nonvoidContext _localctx = new Instruction_call_nonvoidContext(_ctx, getState());
        enterRule(_localctx, 250, RULE_instruction_call_nonvoid);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {

                Token finalToken;

                setState(1623);
                switch (getInterpreter().adaptivePredict(_input, 154, _ctx)) {
                    case 1: {
                        setState(1621);
                        _la = _input.LA(1);
                        if (_la == T__104) {
                            {
                                setState(1620);
                                ((Instruction_call_nonvoidContext) _localctx).istail = match(T__104);
                            }
                        }

                    }
                        break;
                }
                setState(1625);
                ((Instruction_call_nonvoidContext) _localctx).opcode = match(T__234);
                setState(1627);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__233) | (1L << T__200) | (1L << T__193) | (1L << T__192) | (1L << T__183))) != 0) ||
                                ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (T__175 - 65)) | (1L << (T__172 - 65)) | (1L << (T__166 - 65)) | (1L << (T__163 - 65)) |
                                                (1L << (T__152 - 65)) | (1L << (T__136 - 65)) | (1L << (T__130 - 65)) | (1L << (T__125 - 65)))) != 0) ||
                                ((((_la - 140)) & ~0x3f) == 0 && ((1L << (_la - 140)) & ((1L << (T__100 - 140)) | (1L << (T__76 - 140)) | (1L << (T__46 - 140)) | (1L << (T__41 - 140)))) != 0) ||
                                ((((_la - 205)) & ~0x3f) == 0 && ((1L << (_la - 205)) & ((1L << (T__35 - 205)) | (1L << (T__33 - 205)) | (1L << (T__31 - 205)) | (1L << (T__24 - 205)) | (1L << (T__20 - 205)))) != 0)) {
                    {
                        setState(1626);
                        cconv();
                    }
                }

                setState(1630);
                _la = _input.LA(1);
                if (((((_la - 33)) & ~0x3f) == 0 && ((1L << (_la - 33)) & ((1L << (T__207 - 33)) | (1L << (T__203 - 33)) | (1L << (T__202 - 33)) | (1L << (T__171 - 33)) | (1L << (T__165 - 33)))) != 0) ||
                                ((((_la - 98)) & ~0x3f) == 0 && ((1L << (_la - 98)) & ((1L << (T__142 - 98)) | (1L << (T__114 - 98)) | (1L << (T__83 - 98)))) != 0) || _la == T__58 || _la == T__3) {
                    {
                        setState(1629);
                        ((Instruction_call_nonvoidContext) _localctx).returnattributes = parameterattributes();
                    }
                }

                setState(1632);
                nonvoidtype();
                setState(1633);
                ((Instruction_call_nonvoidContext) _localctx).functionName = callee();
                setState(1634);
                ((Instruction_call_nonvoidContext) _localctx).arglistName = arglist();
                setState(1636);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__231) | (1L << T__214) | (1L << T__206) | (1L << T__201))) != 0) ||
                                ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (T__168 - 72)) | (1L << (T__164 - 72)) | (1L << (T__159 - 72)) | (1L << (T__132 - 72)) |
                                                (1L << (T__120 - 72)) | (1L << (T__115 - 72)) | (1L << (T__113 - 72)))) != 0) ||
                                ((((_la - 146)) & ~0x3f) == 0 && ((1L << (_la - 146)) & ((1L << (T__94 - 146)) | (1L << (T__87 - 146)) | (1L << (T__82 - 146)) | (1L << (T__77 - 146)) |
                                                (1L << (T__70 - 146)) | (1L << (T__68 - 146)) | (1L << (T__61 - 146)) | (1L << (T__57 - 146)) | (1L << (T__56 - 146)) | (1L << (T__45 - 146)) |
                                                (1L << (T__43 - 146)) | (1L << (T__39 - 146)) | (1L << (T__37 - 146)) | (1L << (T__36 - 146)))) != 0) ||
                                ((((_la - 210)) & ~0x3f) == 0 && ((1L << (_la - 210)) & ((1L << (T__30 - 210)) | (1L << (T__19 - 210)) | (1L << (T__12 - 210)) | (1L << (T__5 - 210)) |
                                                (1L << (T__1 - 210)) | (1L << (Attribute_id - 210)))) != 0)) {
                    {
                        setState(1635);
                        functionattributes();
                    }
                }

                LlvmExpressionNode node = factory.createRead(((Instruction_call_nonvoidContext) _localctx).functionName.resultToken);
                finalToken = ((Instruction_call_nonvoidContext) _localctx).arglistName.finalToken;
                ((Instruction_call_nonvoidContext) _localctx).result = factory.createCall(node, ((Instruction_call_nonvoidContext) _localctx).arglistName.result, finalToken);

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

    public static class Instruction_call_voidContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Token istail;
        public Token opcode;
        public ParameterattributesContext returnattributes;
        public CalleeContext functionName;
        public ArglistContext args;

        public CalleeContext callee() {
            return getRuleContext(CalleeContext.class, 0);
        }

        public ParameterattributesContext parameterattributes() {
            return getRuleContext(ParameterattributesContext.class, 0);
        }

        public CconvContext cconv() {
            return getRuleContext(CconvContext.class, 0);
        }

        public FunctionattributesContext functionattributes() {
            return getRuleContext(FunctionattributesContext.class, 0);
        }

        public ArglistContext arglist() {
            return getRuleContext(ArglistContext.class, 0);
        }

        public VoidtypeContext voidtype() {
            return getRuleContext(VoidtypeContext.class, 0);
        }

        public Instruction_call_voidContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_call_void;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_call_void(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_call_void(this);
        }
    }

    public final Instruction_call_voidContext instruction_call_void() throws RecognitionException {
        Instruction_call_voidContext _localctx = new Instruction_call_voidContext(_ctx, getState());
        enterRule(_localctx, 252, RULE_instruction_call_void);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {

                Token finalToken;

                setState(1644);
                switch (getInterpreter().adaptivePredict(_input, 159, _ctx)) {
                    case 1: {
                        setState(1642);
                        _la = _input.LA(1);
                        if (_la == T__104) {
                            {
                                setState(1641);
                                ((Instruction_call_voidContext) _localctx).istail = match(T__104);
                            }
                        }

                    }
                        break;
                }
                setState(1646);
                ((Instruction_call_voidContext) _localctx).opcode = match(T__234);
                setState(1648);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__233) | (1L << T__200) | (1L << T__193) | (1L << T__192) | (1L << T__183))) != 0) ||
                                ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (T__175 - 65)) | (1L << (T__172 - 65)) | (1L << (T__166 - 65)) | (1L << (T__163 - 65)) |
                                                (1L << (T__152 - 65)) | (1L << (T__136 - 65)) | (1L << (T__130 - 65)) | (1L << (T__125 - 65)))) != 0) ||
                                ((((_la - 140)) & ~0x3f) == 0 && ((1L << (_la - 140)) & ((1L << (T__100 - 140)) | (1L << (T__76 - 140)) | (1L << (T__46 - 140)) | (1L << (T__41 - 140)))) != 0) ||
                                ((((_la - 205)) & ~0x3f) == 0 && ((1L << (_la - 205)) & ((1L << (T__35 - 205)) | (1L << (T__33 - 205)) | (1L << (T__31 - 205)) | (1L << (T__24 - 205)) | (1L << (T__20 - 205)))) != 0)) {
                    {
                        setState(1647);
                        cconv();
                    }
                }

                setState(1651);
                _la = _input.LA(1);
                if (((((_la - 33)) & ~0x3f) == 0 && ((1L << (_la - 33)) & ((1L << (T__207 - 33)) | (1L << (T__203 - 33)) | (1L << (T__202 - 33)) | (1L << (T__171 - 33)) | (1L << (T__165 - 33)))) != 0) ||
                                ((((_la - 98)) & ~0x3f) == 0 && ((1L << (_la - 98)) & ((1L << (T__142 - 98)) | (1L << (T__114 - 98)) | (1L << (T__83 - 98)))) != 0) || _la == T__58 || _la == T__3) {
                    {
                        setState(1650);
                        ((Instruction_call_voidContext) _localctx).returnattributes = parameterattributes();
                    }
                }

                setState(1653);
                voidtype();
                setState(1654);
                ((Instruction_call_voidContext) _localctx).functionName = callee();
                setState(1655);
                ((Instruction_call_voidContext) _localctx).args = arglist();
                setState(1657);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__231) | (1L << T__214) | (1L << T__206) | (1L << T__201))) != 0) ||
                                ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (T__168 - 72)) | (1L << (T__164 - 72)) | (1L << (T__159 - 72)) | (1L << (T__132 - 72)) |
                                                (1L << (T__120 - 72)) | (1L << (T__115 - 72)) | (1L << (T__113 - 72)))) != 0) ||
                                ((((_la - 146)) & ~0x3f) == 0 && ((1L << (_la - 146)) & ((1L << (T__94 - 146)) | (1L << (T__87 - 146)) | (1L << (T__82 - 146)) | (1L << (T__77 - 146)) |
                                                (1L << (T__70 - 146)) | (1L << (T__68 - 146)) | (1L << (T__61 - 146)) | (1L << (T__57 - 146)) | (1L << (T__56 - 146)) | (1L << (T__45 - 146)) |
                                                (1L << (T__43 - 146)) | (1L << (T__39 - 146)) | (1L << (T__37 - 146)) | (1L << (T__36 - 146)))) != 0) ||
                                ((((_la - 210)) & ~0x3f) == 0 && ((1L << (_la - 210)) & ((1L << (T__30 - 210)) | (1L << (T__19 - 210)) | (1L << (T__12 - 210)) | (1L << (T__5 - 210)) |
                                                (1L << (T__1 - 210)) | (1L << (Attribute_id - 210)))) != 0)) {
                    {
                        setState(1656);
                        functionattributes();
                    }
                }

                LlvmExpressionNode node = factory.createRead(((Instruction_call_voidContext) _localctx).functionName.resultToken);
                finalToken = ((Instruction_call_voidContext) _localctx).args.finalToken;
                ((Instruction_call_voidContext) _localctx).result = factory.createCall(node, ((Instruction_call_voidContext) _localctx).args.result, finalToken);

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

    public static class ArglistContext extends ParserRuleContext {
        public List<LlvmExpressionNode> result;
        public Token finalToken;
        public ArgumentContext arguments;
        public Token op1;

        public List<ArgumentContext> argument() {
            return getRuleContexts(ArgumentContext.class);
        }

        public ArgumentContext argument(int i) {
            return getRuleContext(ArgumentContext.class, i);
        }

        public ArglistContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_arglist;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterArglist(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitArglist(this);
        }
    }

    public final ArglistContext arglist() throws RecognitionException {
        ArglistContext _localctx = new ArglistContext(_ctx, getState());
        enterRule(_localctx, 254, RULE_arglist);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {

                List<LlvmExpressionNode> parameters = new ArrayList<>();

                setState(1662);
                match(T__149);
                setState(1674);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__212) | (1L << T__211) | (1L << T__178))) != 0) ||
                                ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__157 - 83)) | (1L << (T__154 - 83)) | (1L << (T__140 - 83)) | (1L << (T__118 - 83)))) != 0) ||
                                ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (T__47 - 193)) | (1L << (Int_type - 193)) | (1L << (Local_id - 193)))) != 0) || _la == Floatingtype) {
                    {
                        setState(1663);
                        ((ArglistContext) _localctx).arguments = argument();

                        parameters.add(factory.createRead(((ArglistContext) _localctx).arguments.resultToken));

                        setState(1671);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == T__222) {
                            {
                                {
                                    setState(1665);
                                    match(T__222);
                                    setState(1666);
                                    ((ArglistContext) _localctx).arguments = argument();

                                    parameters.add(factory.createRead(((ArglistContext) _localctx).arguments.resultToken));

                                }
                            }
                            setState(1673);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                    }
                }

                setState(1676);
                ((ArglistContext) _localctx).op1 = match(T__170);

                ((ArglistContext) _localctx).result = parameters;
                ((ArglistContext) _localctx).finalToken = ((ArglistContext) _localctx).op1;

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

    public static class CalleeContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Token resultToken;
        public ValuerefContext op1;

        public InlineassemblerContext inlineassembler() {
            return getRuleContext(InlineassemblerContext.class, 0);
        }

        public ValuerefContext valueref() {
            return getRuleContext(ValuerefContext.class, 0);
        }

        public CalleeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_callee;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterCallee(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitCallee(this);
        }
    }

    public final CalleeContext callee() throws RecognitionException {
        CalleeContext _localctx = new CalleeContext(_ctx, getState());
        enterRule(_localctx, 256, RULE_callee);
        try {
            setState(1683);
            switch (_input.LA(1)) {
                case T__236:
                case T__234:
                case T__233:
                case T__230:
                case T__229:
                case T__228:
                case T__227:
                case T__226:
                case T__224:
                case T__215:
                case T__213:
                case T__212:
                case T__211:
                case T__210:
                case T__207:
                case T__205:
                case T__204:
                case T__203:
                case T__202:
                case T__200:
                case T__198:
                case T__193:
                case T__192:
                case T__191:
                case T__190:
                case T__188:
                case T__186:
                case T__184:
                case T__183:
                case T__181:
                case T__180:
                case T__178:
                case T__177:
                case T__176:
                case T__175:
                case T__173:
                case T__172:
                case T__171:
                case T__169:
                case T__166:
                case T__165:
                case T__163:
                case T__162:
                case T__157:
                case T__156:
                case T__154:
                case T__152:
                case T__148:
                case T__146:
                case T__144:
                case T__142:
                case T__140:
                case T__136:
                case T__135:
                case T__133:
                case T__130:
                case T__129:
                case T__126:
                case T__125:
                case T__124:
                case T__119:
                case T__118:
                case T__117:
                case T__114:
                case T__112:
                case T__111:
                case T__110:
                case T__109:
                case T__108:
                case T__106:
                case T__105:
                case T__104:
                case T__102:
                case T__100:
                case T__99:
                case T__97:
                case T__92:
                case T__90:
                case T__85:
                case T__84:
                case T__83:
                case T__81:
                case T__79:
                case T__76:
                case T__74:
                case T__72:
                case T__71:
                case T__65:
                case T__64:
                case T__60:
                case T__58:
                case T__55:
                case T__54:
                case T__52:
                case T__51:
                case T__47:
                case T__46:
                case T__42:
                case T__41:
                case T__40:
                case T__35:
                case T__34:
                case T__33:
                case T__31:
                case T__29:
                case T__25:
                case T__24:
                case T__22:
                case T__20:
                case T__18:
                case T__17:
                case T__15:
                case T__9:
                case T__7:
                case T__3:
                case T__0:
                case Visibility:
                case Boolean:
                case Null:
                case Int_type:
                case Global_id:
                case Local_id:
                case Meta_int:
                case Meta_name:
                case Integer:
                case Signed_int:
                case Cstring:
                case Metadata_string:
                case Float:
                case Floatingtype:
                    enterOuterAlt(_localctx, 1);
                    {
                        setState(1679);
                        ((CalleeContext) _localctx).op1 = valueref();

                        ((CalleeContext) _localctx).resultToken = ((CalleeContext) _localctx).op1.resultToken;

                    }
                    break;
                case T__220:
                    enterOuterAlt(_localctx, 2);
                    {
                        setState(1682);
                        inlineassembler();
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

    public static class InlineassemblerContext extends ParserRuleContext {
        public Token assembler;
        public Token flags;

        public List<TerminalNode> String() {
            return getTokens(LLVM_IRParser.String);
        }

        public TerminalNode String(int i) {
            return getToken(LLVM_IRParser.String, i);
        }

        public InlineassemblerContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_inlineassembler;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInlineassembler(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInlineassembler(this);
        }
    }

    public final InlineassemblerContext inlineassembler() throws RecognitionException {
        InlineassemblerContext _localctx = new InlineassemblerContext(_ctx, getState());
        enterRule(_localctx, 258, RULE_inlineassembler);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1685);
                match(T__220);
                setState(1687);
                _la = _input.LA(1);
                if (_la == T__86) {
                    {
                        setState(1686);
                        match(T__86);
                    }
                }

                setState(1690);
                _la = _input.LA(1);
                if (_la == T__30) {
                    {
                        setState(1689);
                        match(T__30);
                    }
                }

                setState(1693);
                _la = _input.LA(1);
                if (_la == T__69) {
                    {
                        setState(1692);
                        match(T__69);
                    }
                }

                setState(1695);
                ((InlineassemblerContext) _localctx).assembler = match(String);
                setState(1696);
                match(T__222);
                setState(1697);
                ((InlineassemblerContext) _localctx).flags = match(String);
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

    public static class Instruction_va_argContext extends ParserRuleContext {
        public Token opcode;

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public TypedvalueContext typedvalue() {
            return getRuleContext(TypedvalueContext.class, 0);
        }

        public Instruction_va_argContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_va_arg;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_va_arg(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_va_arg(this);
        }
    }

    public final Instruction_va_argContext instruction_va_arg() throws RecognitionException {
        Instruction_va_argContext _localctx = new Instruction_va_argContext(_ctx, getState());
        enterRule(_localctx, 260, RULE_instruction_va_arg);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1699);
                ((Instruction_va_argContext) _localctx).opcode = match(T__204);
                setState(1700);
                typedvalue();
                setState(1701);
                match(T__222);
                setState(1702);
                type();
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

    public static class Instruction_landingpadContext extends ParserRuleContext {
        public Token opcode;
        public TypeContext resulttype;
        public TypedvalueContext personality;
        public LandingpadclauseContext landingpadclause;
        public List<LandingpadclauseContext> clauses = new ArrayList<LandingpadclauseContext>();

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public LandingpadclauseContext landingpadclause(int i) {
            return getRuleContext(LandingpadclauseContext.class, i);
        }

        public TypedvalueContext typedvalue() {
            return getRuleContext(TypedvalueContext.class, 0);
        }

        public List<LandingpadclauseContext> landingpadclause() {
            return getRuleContexts(LandingpadclauseContext.class);
        }

        public Instruction_landingpadContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_instruction_landingpad;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInstruction_landingpad(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInstruction_landingpad(this);
        }
    }

    public final Instruction_landingpadContext instruction_landingpad() throws RecognitionException {
        Instruction_landingpadContext _localctx = new Instruction_landingpadContext(_ctx, getState());
        enterRule(_localctx, 262, RULE_instruction_landingpad);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1704);
                ((Instruction_landingpadContext) _localctx).opcode = match(T__198);
                setState(1705);
                ((Instruction_landingpadContext) _localctx).resulttype = type();
                setState(1706);
                match(T__196);
                setState(1707);
                ((Instruction_landingpadContext) _localctx).personality = typedvalue();
                setState(1710);
                switch (_input.LA(1)) {
                    case T__237:
                    case T__23: {
                        setState(1708);
                        ((Instruction_landingpadContext) _localctx).landingpadclause = landingpadclause();
                        ((Instruction_landingpadContext) _localctx).clauses.add(((Instruction_landingpadContext) _localctx).landingpadclause);
                    }
                        break;
                    case T__66: {
                        setState(1709);
                        match(T__66);
                    }
                        break;
                    default:
                        throw new NoViableAltException(this);
                }
                setState(1715);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 170, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(1712);
                                ((Instruction_landingpadContext) _localctx).landingpadclause = landingpadclause();
                                ((Instruction_landingpadContext) _localctx).clauses.add(((Instruction_landingpadContext) _localctx).landingpadclause);
                            }
                        }
                    }
                    setState(1717);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 170, _ctx);
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

    public static class LandingpadclauseContext extends ParserRuleContext {
        public Token landingpadtype;
        public TypedvalueContext catchtype;
        public ArraytypeContext arrayType;
        public ArrayconstantContext arrayConstant;

        public ArraytypeContext arraytype() {
            return getRuleContext(ArraytypeContext.class, 0);
        }

        public ArrayconstantContext arrayconstant() {
            return getRuleContext(ArrayconstantContext.class, 0);
        }

        public TypedvalueContext typedvalue() {
            return getRuleContext(TypedvalueContext.class, 0);
        }

        public LandingpadclauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_landingpadclause;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterLandingpadclause(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitLandingpadclause(this);
        }
    }

    public final LandingpadclauseContext landingpadclause() throws RecognitionException {
        LandingpadclauseContext _localctx = new LandingpadclauseContext(_ctx, getState());
        enterRule(_localctx, 264, RULE_landingpadclause);
        try {
            setState(1724);
            switch (_input.LA(1)) {
                case T__23:
                    enterOuterAlt(_localctx, 1);
                    {
                        setState(1718);
                        ((LandingpadclauseContext) _localctx).landingpadtype = match(T__23);
                        setState(1719);
                        ((LandingpadclauseContext) _localctx).catchtype = typedvalue();
                    }
                    break;
                case T__237:
                    enterOuterAlt(_localctx, 2);
                    {
                        setState(1720);
                        ((LandingpadclauseContext) _localctx).landingpadtype = match(T__237);
                        setState(1721);
                        ((LandingpadclauseContext) _localctx).arrayType = arraytype();
                        setState(1722);
                        ((LandingpadclauseContext) _localctx).arrayConstant = arrayconstant();
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

    public static class OrderingContext extends ParserRuleContext {
        public OrderingContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_ordering;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterOrdering(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitOrdering(this);
        }
    }

    public final OrderingContext ordering() throws RecognitionException {
        OrderingContext _localctx = new OrderingContext(_ctx, getState());
        enterRule(_localctx, 266, RULE_ordering);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1726);
                _la = _input.LA(1);
                if (!(_la == T__197 || _la == T__174 || _la == T__131 || _la == T__75 || _la == T__6 || _la == T__2)) {
                    _errHandler.recoverInline(this);
                }
                consume();
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

    public static class TypedvalueContext extends ParserRuleContext {
        public LlvmExpressionNode result;
        public Token resultToken;
        public ValuerefContext val;

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public ValuerefContext valueref() {
            return getRuleContext(ValuerefContext.class, 0);
        }

        public TypedvalueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_typedvalue;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterTypedvalue(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitTypedvalue(this);
        }
    }

    public final TypedvalueContext typedvalue() throws RecognitionException {
        TypedvalueContext _localctx = new TypedvalueContext(_ctx, getState());
        enterRule(_localctx, 268, RULE_typedvalue);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1728);
                type();
                setState(1729);
                ((TypedvalueContext) _localctx).val = valueref();

                ((TypedvalueContext) _localctx).result = ((TypedvalueContext) _localctx).val.result;
                ((TypedvalueContext) _localctx).resultToken = ((TypedvalueContext) _localctx).val.resultToken;

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

    public static class ParametertypeContext extends ParserRuleContext {
        public ParameterattributesContext parameterattributes() {
            return getRuleContext(ParameterattributesContext.class, 0);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public ParametertypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_parametertype;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterParametertype(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitParametertype(this);
        }
    }

    public final ParametertypeContext parametertype() throws RecognitionException {
        ParametertypeContext _localctx = new ParametertypeContext(_ctx, getState());
        enterRule(_localctx, 270, RULE_parametertype);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1732);
                type();
                setState(1734);
                switch (getInterpreter().adaptivePredict(_input, 172, _ctx)) {
                    case 1: {
                        setState(1733);
                        parameterattributes();
                    }
                        break;
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

    public static class ParameterattributesContext extends ParserRuleContext {
        public ParameterattributeContext parameterattribute;
        public List<ParameterattributeContext> attributes = new ArrayList<ParameterattributeContext>();

        public List<ParameterattributeContext> parameterattribute() {
            return getRuleContexts(ParameterattributeContext.class);
        }

        public ParameterattributeContext parameterattribute(int i) {
            return getRuleContext(ParameterattributeContext.class, i);
        }

        public ParameterattributesContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_parameterattributes;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterParameterattributes(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitParameterattributes(this);
        }
    }

    public final ParameterattributesContext parameterattributes() throws RecognitionException {
        ParameterattributesContext _localctx = new ParameterattributesContext(_ctx, getState());
        enterRule(_localctx, 272, RULE_parameterattributes);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1737);
                _errHandler.sync(this);
                _alt = 1;
                do {
                    switch (_alt) {
                        case 1: {
                            {
                                setState(1736);
                                ((ParameterattributesContext) _localctx).parameterattribute = parameterattribute();
                                ((ParameterattributesContext) _localctx).attributes.add(((ParameterattributesContext) _localctx).parameterattribute);
                            }
                        }
                            break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    setState(1739);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 173, _ctx);
                } while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
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

    public static class ParameterattributeContext extends ParserRuleContext {
        public TerminalNode Integer() {
            return getToken(LLVM_IRParser.Integer, 0);
        }

        public ParameterattributeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_parameterattribute;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterParameterattribute(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitParameterattribute(this);
        }
    }

    public final ParameterattributeContext parameterattribute() throws RecognitionException {
        ParameterattributeContext _localctx = new ParameterattributeContext(_ctx, getState());
        enterRule(_localctx, 274, RULE_parameterattribute);
        int _la;
        try {
            setState(1755);
            switch (_input.LA(1)) {
                case T__58:
                    enterOuterAlt(_localctx, 1);
                    {
                        setState(1741);
                        match(T__58);
                    }
                    break;
                case T__171:
                    enterOuterAlt(_localctx, 2);
                    {
                        setState(1742);
                        match(T__171);
                    }
                    break;
                case T__114:
                    enterOuterAlt(_localctx, 3);
                    {
                        setState(1743);
                        match(T__114);
                    }
                    break;
                case T__207:
                    enterOuterAlt(_localctx, 4);
                    {
                        {
                            setState(1744);
                            match(T__207);
                            setState(1747);
                            _la = _input.LA(1);
                            if (_la == T__10) {
                                {
                                    setState(1745);
                                    match(T__10);
                                    setState(1746);
                                    match(Integer);
                                }
                            }

                        }
                    }
                    break;
                case T__203:
                    enterOuterAlt(_localctx, 5);
                    {
                        setState(1749);
                        match(T__203);
                    }
                    break;
                case T__142:
                    enterOuterAlt(_localctx, 6);
                    {
                        setState(1750);
                        match(T__142);
                    }
                    break;
                case T__83:
                    enterOuterAlt(_localctx, 7);
                    {
                        setState(1751);
                        match(T__83);
                    }
                    break;
                case T__202:
                    enterOuterAlt(_localctx, 8);
                    {
                        setState(1752);
                        match(T__202);
                    }
                    break;
                case T__3:
                    enterOuterAlt(_localctx, 9);
                    {
                        setState(1753);
                        match(T__3);
                    }
                    break;
                case T__165:
                    enterOuterAlt(_localctx, 10);
                    {
                        setState(1754);
                        match(T__165);
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

    public static class ArgumentContext extends ParserRuleContext {
        public Token resultToken;
        public ValuerefContext op2;

        public ParametertypeContext parametertype() {
            return getRuleContext(ParametertypeContext.class, 0);
        }

        public ValuerefContext valueref() {
            return getRuleContext(ValuerefContext.class, 0);
        }

        public ArgumentContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_argument;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterArgument(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitArgument(this);
        }
    }

    public final ArgumentContext argument() throws RecognitionException {
        ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
        enterRule(_localctx, 276, RULE_argument);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1757);
                parametertype();
                setState(1758);
                ((ArgumentContext) _localctx).op2 = valueref();

                ((ArgumentContext) _localctx).resultToken = ((ArgumentContext) _localctx).op2.resultToken;

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

    public static class ParameterContext extends ParserRuleContext {
        public Token resultToken;
        public ParamnameContext pa1;

        public ParametertypeContext parametertype() {
            return getRuleContext(ParametertypeContext.class, 0);
        }

        public ParamnameContext paramname() {
            return getRuleContext(ParamnameContext.class, 0);
        }

        public ParameterContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_parameter;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterParameter(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitParameter(this);
        }
    }

    public final ParameterContext parameter() throws RecognitionException {
        ParameterContext _localctx = new ParameterContext(_ctx, getState());
        enterRule(_localctx, 278, RULE_parameter);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1761);
                parametertype();
                setState(1762);
                ((ParameterContext) _localctx).pa1 = paramname();

                ((ParameterContext) _localctx).resultToken = ((ParameterContext) _localctx).pa1.resultToken;

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

    public static class NonvoidtypeContext extends ParserRuleContext {
        public VoidtypeContext basetype;
        public TypesuffixContext typesuffix;
        public List<TypesuffixContext> suffixes = new ArrayList<TypesuffixContext>();

        public NonleftrecursivenonvoidtypeContext nonleftrecursivenonvoidtype() {
            return getRuleContext(NonleftrecursivenonvoidtypeContext.class, 0);
        }

        public TypesuffixContext typesuffix(int i) {
            return getRuleContext(TypesuffixContext.class, i);
        }

        public List<TypesuffixContext> typesuffix() {
            return getRuleContexts(TypesuffixContext.class);
        }

        public StarContext star(int i) {
            return getRuleContext(StarContext.class, i);
        }

        public List<StarContext> star() {
            return getRuleContexts(StarContext.class);
        }

        public VoidtypeContext voidtype() {
            return getRuleContext(VoidtypeContext.class, 0);
        }

        public NonvoidtypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_nonvoidtype;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterNonvoidtype(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitNonvoidtype(this);
        }
    }

    public final NonvoidtypeContext nonvoidtype() throws RecognitionException {
        NonvoidtypeContext _localctx = new NonvoidtypeContext(_ctx, getState());
        enterRule(_localctx, 280, RULE_nonvoidtype);
        try {
            int _alt;
            setState(1784);
            switch (_input.LA(1)) {
                case T__47:
                    enterOuterAlt(_localctx, 1);
                    {
                        setState(1765);
                        ((NonvoidtypeContext) _localctx).basetype = voidtype();
                        setState(1767);
                        _errHandler.sync(this);
                        _alt = 1;
                        do {
                            switch (_alt) {
                                case 1: {
                                    {
                                        setState(1766);
                                        ((NonvoidtypeContext) _localctx).typesuffix = typesuffix();
                                        ((NonvoidtypeContext) _localctx).suffixes.add(((NonvoidtypeContext) _localctx).typesuffix);
                                    }
                                }
                                    break;
                                default:
                                    throw new NoViableAltException(this);
                            }
                            setState(1769);
                            _errHandler.sync(this);
                            _alt = getInterpreter().adaptivePredict(_input, 176, _ctx);
                        } while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
                    }
                    break;
                case T__212:
                case T__211:
                case T__178:
                case T__157:
                case T__154:
                case T__140:
                case T__118:
                case Int_type:
                case Local_id:
                case Floatingtype:
                    enterOuterAlt(_localctx, 2);
                    {
                        setState(1771);
                        nonleftrecursivenonvoidtype();
                        setState(1775);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 177, _ctx);
                        while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                            if (_alt == 1) {
                                {
                                    {
                                        setState(1772);
                                        star();
                                    }
                                }
                            }
                            setState(1777);
                            _errHandler.sync(this);
                            _alt = getInterpreter().adaptivePredict(_input, 177, _ctx);
                        }
                        setState(1781);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 178, _ctx);
                        while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                            if (_alt == 1) {
                                {
                                    {
                                        setState(1778);
                                        typesuffix();
                                    }
                                }
                            }
                            setState(1783);
                            _errHandler.sync(this);
                            _alt = getInterpreter().adaptivePredict(_input, 178, _ctx);
                        }
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

    public static class StarContext extends ParserRuleContext {
        public AddressspaceContext addressspace() {
            return getRuleContext(AddressspaceContext.class, 0);
        }

        public StarContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_star;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterStar(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitStar(this);
        }
    }

    public final StarContext star() throws RecognitionException {
        StarContext _localctx = new StarContext(_ctx, getState());
        enterRule(_localctx, 282, RULE_star);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1787);
                _la = _input.LA(1);
                if (_la == T__7) {
                    {
                        setState(1786);
                        addressspace();
                    }
                }

                setState(1789);
                match(T__185);
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

    public static class TypeContext extends ParserRuleContext {
        public NonleftrecursivetypeContext basetype;
        public StarContext star;
        public List<StarContext> stars = new ArrayList<StarContext>();
        public TypesuffixContext typesuffix;
        public List<TypesuffixContext> suffixes = new ArrayList<TypesuffixContext>();

        public NonleftrecursivetypeContext nonleftrecursivetype() {
            return getRuleContext(NonleftrecursivetypeContext.class, 0);
        }

        public TypesuffixContext typesuffix(int i) {
            return getRuleContext(TypesuffixContext.class, i);
        }

        public StarContext star(int i) {
            return getRuleContext(StarContext.class, i);
        }

        public List<TypesuffixContext> typesuffix() {
            return getRuleContexts(TypesuffixContext.class);
        }

        public List<StarContext> star() {
            return getRuleContexts(StarContext.class);
        }

        public TypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_type;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterType(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitType(this);
        }
    }

    public final TypeContext type() throws RecognitionException {
        TypeContext _localctx = new TypeContext(_ctx, getState());
        enterRule(_localctx, 284, RULE_type);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1791);
                ((TypeContext) _localctx).basetype = nonleftrecursivetype();
                setState(1795);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 181, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(1792);
                                ((TypeContext) _localctx).star = star();
                                ((TypeContext) _localctx).stars.add(((TypeContext) _localctx).star);
                            }
                        }
                    }
                    setState(1797);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 181, _ctx);
                }
                setState(1801);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 182, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(1798);
                                ((TypeContext) _localctx).typesuffix = typesuffix();
                                ((TypeContext) _localctx).suffixes.add(((TypeContext) _localctx).typesuffix);
                            }
                        }
                    }
                    setState(1803);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 182, _ctx);
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

    public static class TypesuffixContext extends ParserRuleContext {
        public ParametertypeContext parametertype;
        public List<ParametertypeContext> containedtypes = new ArrayList<ParametertypeContext>();
        public Token vararg;
        public StarContext star;
        public List<StarContext> stars = new ArrayList<StarContext>();

        public List<ParametertypeContext> parametertype() {
            return getRuleContexts(ParametertypeContext.class);
        }

        public StarContext star(int i) {
            return getRuleContext(StarContext.class, i);
        }

        public ParametertypeContext parametertype(int i) {
            return getRuleContext(ParametertypeContext.class, i);
        }

        public List<StarContext> star() {
            return getRuleContexts(StarContext.class);
        }

        public TypesuffixContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_typesuffix;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterTypesuffix(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitTypesuffix(this);
        }
    }

    public final TypesuffixContext typesuffix() throws RecognitionException {
        TypesuffixContext _localctx = new TypesuffixContext(_ctx, getState());
        enterRule(_localctx, 286, RULE_typesuffix);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1804);
                match(T__149);
                setState(1820);
                switch (_input.LA(1)) {
                    case T__212:
                    case T__211:
                    case T__178:
                    case T__170:
                    case T__157:
                    case T__154:
                    case T__140:
                    case T__118:
                    case T__47:
                    case Int_type:
                    case Local_id:
                    case Floatingtype: {
                        setState(1817);
                        _la = _input.LA(1);
                        if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__212) | (1L << T__211) | (1L << T__178))) != 0) ||
                                        ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__157 - 83)) | (1L << (T__154 - 83)) | (1L << (T__140 - 83)) | (1L << (T__118 - 83)))) != 0) ||
                                        ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (T__47 - 193)) | (1L << (Int_type - 193)) | (1L << (Local_id - 193)))) != 0) ||
                                        _la == Floatingtype) {
                            {
                                setState(1805);
                                ((TypesuffixContext) _localctx).parametertype = parametertype();
                                ((TypesuffixContext) _localctx).containedtypes.add(((TypesuffixContext) _localctx).parametertype);
                                setState(1810);
                                _errHandler.sync(this);
                                _alt = getInterpreter().adaptivePredict(_input, 183, _ctx);
                                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                                    if (_alt == 1) {
                                        {
                                            {
                                                setState(1806);
                                                match(T__222);
                                                setState(1807);
                                                ((TypesuffixContext) _localctx).parametertype = parametertype();
                                                ((TypesuffixContext) _localctx).containedtypes.add(((TypesuffixContext) _localctx).parametertype);
                                            }
                                        }
                                    }
                                    setState(1812);
                                    _errHandler.sync(this);
                                    _alt = getInterpreter().adaptivePredict(_input, 183, _ctx);
                                }
                                setState(1815);
                                _la = _input.LA(1);
                                if (_la == T__222) {
                                    {
                                        setState(1813);
                                        match(T__222);
                                        setState(1814);
                                        ((TypesuffixContext) _localctx).vararg = match(T__14);
                                    }
                                }

                            }
                        }

                    }
                        break;
                    case T__14: {
                        setState(1819);
                        ((TypesuffixContext) _localctx).vararg = match(T__14);
                    }
                        break;
                    default:
                        throw new NoViableAltException(this);
                }
                setState(1822);
                match(T__170);
                setState(1826);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 187, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(1823);
                                ((TypesuffixContext) _localctx).star = star();
                                ((TypesuffixContext) _localctx).stars.add(((TypesuffixContext) _localctx).star);
                            }
                        }
                    }
                    setState(1828);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 187, _ctx);
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

    public static class NonleftrecursivetypeContext extends ParserRuleContext {
        public StructtypeContext structtype() {
            return getRuleContext(StructtypeContext.class, 0);
        }

        public OpaquetypeContext opaquetype() {
            return getRuleContext(OpaquetypeContext.class, 0);
        }

        public ArraytypeContext arraytype() {
            return getRuleContext(ArraytypeContext.class, 0);
        }

        public InttypeContext inttype() {
            return getRuleContext(InttypeContext.class, 0);
        }

        public TerminalNode Floatingtype() {
            return getToken(LLVM_IRParser.Floatingtype, 0);
        }

        public X86mmxtypeContext x86mmxtype() {
            return getRuleContext(X86mmxtypeContext.class, 0);
        }

        public TerminalNode Local_id() {
            return getToken(LLVM_IRParser.Local_id, 0);
        }

        public MetadatatypeContext metadatatype() {
            return getRuleContext(MetadatatypeContext.class, 0);
        }

        public TypedefContext typedef() {
            return getRuleContext(TypedefContext.class, 0);
        }

        public VectortypeContext vectortype() {
            return getRuleContext(VectortypeContext.class, 0);
        }

        public VoidtypeContext voidtype() {
            return getRuleContext(VoidtypeContext.class, 0);
        }

        public NonleftrecursivetypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_nonleftrecursivetype;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterNonleftrecursivetype(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitNonleftrecursivetype(this);
        }
    }

    public final NonleftrecursivetypeContext nonleftrecursivetype() throws RecognitionException {
        NonleftrecursivetypeContext _localctx = new NonleftrecursivetypeContext(_ctx, getState());
        enterRule(_localctx, 288, RULE_nonleftrecursivetype);
        try {
            setState(1844);
            switch (_input.LA(1)) {
                case T__212:
                case T__211:
                case T__178:
                case T__157:
                case T__154:
                case T__118:
                case T__47:
                case Int_type:
                case Floatingtype:
                    enterOuterAlt(_localctx, 1);
                    {
                        setState(1838);
                        switch (getInterpreter().adaptivePredict(_input, 188, _ctx)) {
                            case 1: {
                                setState(1829);
                                inttype();
                            }
                                break;
                            case 2: {
                                setState(1830);
                                match(Floatingtype);
                            }
                                break;
                            case 3: {
                                setState(1831);
                                vectortype();
                            }
                                break;
                            case 4: {
                                setState(1832);
                                arraytype();
                            }
                                break;
                            case 5: {
                                setState(1833);
                                x86mmxtype();
                            }
                                break;
                            case 6: {
                                setState(1834);
                                voidtype();
                            }
                                break;
                            case 7: {
                                setState(1835);
                                metadatatype();
                            }
                                break;
                            case 8: {
                                setState(1836);
                                structtype();
                            }
                                break;
                            case 9: {
                                setState(1837);
                                opaquetype();
                            }
                                break;
                        }
                    }
                    break;
                case T__140:
                case Local_id:
                    enterOuterAlt(_localctx, 2);
                    {
                        setState(1842);
                        switch (getInterpreter().adaptivePredict(_input, 189, _ctx)) {
                            case 1: {
                                setState(1840);
                                typedef();
                            }
                                break;
                            case 2: {
                                setState(1841);
                                match(Local_id);
                            }
                                break;
                        }
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

    public static class NonleftrecursivenonvoidtypeContext extends ParserRuleContext {
        public StructtypeContext structtype() {
            return getRuleContext(StructtypeContext.class, 0);
        }

        public OpaquetypeContext opaquetype() {
            return getRuleContext(OpaquetypeContext.class, 0);
        }

        public ArraytypeContext arraytype() {
            return getRuleContext(ArraytypeContext.class, 0);
        }

        public InttypeContext inttype() {
            return getRuleContext(InttypeContext.class, 0);
        }

        public TerminalNode Floatingtype() {
            return getToken(LLVM_IRParser.Floatingtype, 0);
        }

        public X86mmxtypeContext x86mmxtype() {
            return getRuleContext(X86mmxtypeContext.class, 0);
        }

        public TerminalNode Local_id() {
            return getToken(LLVM_IRParser.Local_id, 0);
        }

        public MetadatatypeContext metadatatype() {
            return getRuleContext(MetadatatypeContext.class, 0);
        }

        public TypedefContext typedef() {
            return getRuleContext(TypedefContext.class, 0);
        }

        public VectortypeContext vectortype() {
            return getRuleContext(VectortypeContext.class, 0);
        }

        public NonleftrecursivenonvoidtypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_nonleftrecursivenonvoidtype;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterNonleftrecursivenonvoidtype(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitNonleftrecursivenonvoidtype(this);
        }
    }

    public final NonleftrecursivenonvoidtypeContext nonleftrecursivenonvoidtype() throws RecognitionException {
        NonleftrecursivenonvoidtypeContext _localctx = new NonleftrecursivenonvoidtypeContext(_ctx, getState());
        enterRule(_localctx, 290, RULE_nonleftrecursivenonvoidtype);
        try {
            setState(1860);
            switch (_input.LA(1)) {
                case T__212:
                case T__211:
                case T__178:
                case T__157:
                case T__154:
                case T__118:
                case Int_type:
                case Floatingtype:
                    enterOuterAlt(_localctx, 1);
                    {
                        setState(1854);
                        switch (getInterpreter().adaptivePredict(_input, 191, _ctx)) {
                            case 1: {
                                setState(1846);
                                inttype();
                            }
                                break;
                            case 2: {
                                setState(1847);
                                match(Floatingtype);
                            }
                                break;
                            case 3: {
                                setState(1848);
                                vectortype();
                            }
                                break;
                            case 4: {
                                setState(1849);
                                arraytype();
                            }
                                break;
                            case 5: {
                                setState(1850);
                                x86mmxtype();
                            }
                                break;
                            case 6: {
                                setState(1851);
                                metadatatype();
                            }
                                break;
                            case 7: {
                                setState(1852);
                                structtype();
                            }
                                break;
                            case 8: {
                                setState(1853);
                                opaquetype();
                            }
                                break;
                        }
                    }
                    break;
                case T__140:
                case Local_id:
                    enterOuterAlt(_localctx, 2);
                    {
                        setState(1858);
                        switch (getInterpreter().adaptivePredict(_input, 192, _ctx)) {
                            case 1: {
                                setState(1856);
                                typedef();
                            }
                                break;
                            case 2: {
                                setState(1857);
                                match(Local_id);
                            }
                                break;
                        }
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

    public static class TypedefContext extends ParserRuleContext {
        public NonvoidtypeContext nonvoidtype() {
            return getRuleContext(NonvoidtypeContext.class, 0);
        }

        public LocalnameContext localname() {
            return getRuleContext(LocalnameContext.class, 0);
        }

        public TypedefContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_typedef;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterTypedef(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitTypedef(this);
        }
    }

    public final TypedefContext typedef() throws RecognitionException {
        TypedefContext _localctx = new TypedefContext(_ctx, getState());
        enterRule(_localctx, 292, RULE_typedef);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1862);
                localname();
                setState(1863);
                match(T__140);
                setState(1864);
                nonvoidtype();
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

    public static class BinaryopcodeContext extends ParserRuleContext {
        public BinaryopcodeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_binaryopcode;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterBinaryopcode(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitBinaryopcode(this);
        }
    }

    public final BinaryopcodeContext binaryopcode() throws RecognitionException {
        BinaryopcodeContext _localctx = new BinaryopcodeContext(_ctx, getState());
        enterRule(_localctx, 294, RULE_binaryopcode);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1866);
                _la = _input.LA(1);
                if (!(_la == T__84 || _la == T__38 || _la == T__15)) {
                    _errHandler.recoverInline(this);
                }
                consume();
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

    public static class InttypeContext extends ParserRuleContext {
        public TerminalNode Int_type() {
            return getToken(LLVM_IRParser.Int_type, 0);
        }

        public InttypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_inttype;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterInttype(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitInttype(this);
        }
    }

    public final InttypeContext inttype() throws RecognitionException {
        InttypeContext _localctx = new InttypeContext(_ctx, getState());
        enterRule(_localctx, 296, RULE_inttype);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1868);
                match(Int_type);
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

    public static class OpaquetypeContext extends ParserRuleContext {
        public OpaquetypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_opaquetype;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterOpaquetype(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitOpaquetype(this);
        }
    }

    public final OpaquetypeContext opaquetype() throws RecognitionException {
        OpaquetypeContext _localctx = new OpaquetypeContext(_ctx, getState());
        enterRule(_localctx, 298, RULE_opaquetype);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1870);
                match(T__212);
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

    public static class StructtypeContext extends ParserRuleContext {
        public TypeContext type;
        public List<TypeContext> types = new ArrayList<TypeContext>();
        public Token packed;

        public TypeContext type(int i) {
            return getRuleContext(TypeContext.class, i);
        }

        public List<TypeContext> type() {
            return getRuleContexts(TypeContext.class);
        }

        public StructtypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_structtype;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterStructtype(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitStructtype(this);
        }
    }

    public final StructtypeContext structtype() throws RecognitionException {
        StructtypeContext _localctx = new StructtypeContext(_ctx, getState());
        enterRule(_localctx, 300, RULE_structtype);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1898);
                switch (_input.LA(1)) {
                    case T__154: {
                        setState(1872);
                        match(T__154);
                        setState(1881);
                        _la = _input.LA(1);
                        if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__212) | (1L << T__211) | (1L << T__178))) != 0) ||
                                        ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__157 - 83)) | (1L << (T__154 - 83)) | (1L << (T__140 - 83)) | (1L << (T__118 - 83)))) != 0) ||
                                        ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (T__47 - 193)) | (1L << (Int_type - 193)) | (1L << (Local_id - 193)))) != 0) ||
                                        _la == Floatingtype) {
                            {
                                setState(1873);
                                ((StructtypeContext) _localctx).type = type();
                                ((StructtypeContext) _localctx).types.add(((StructtypeContext) _localctx).type);
                                setState(1878);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                                while (_la == T__222) {
                                    {
                                        {
                                            setState(1874);
                                            match(T__222);
                                            setState(1875);
                                            ((StructtypeContext) _localctx).type = type();
                                            ((StructtypeContext) _localctx).types.add(((StructtypeContext) _localctx).type);
                                        }
                                    }
                                    setState(1880);
                                    _errHandler.sync(this);
                                    _la = _input.LA(1);
                                }
                            }
                        }

                        setState(1883);
                        match(T__194);
                    }
                        break;
                    case T__211: {
                        setState(1884);
                        ((StructtypeContext) _localctx).packed = match(T__211);
                        setState(1885);
                        match(T__154);
                        setState(1894);
                        _la = _input.LA(1);
                        if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__212) | (1L << T__211) | (1L << T__178))) != 0) ||
                                        ((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (T__157 - 83)) | (1L << (T__154 - 83)) | (1L << (T__140 - 83)) | (1L << (T__118 - 83)))) != 0) ||
                                        ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & ((1L << (T__47 - 193)) | (1L << (Int_type - 193)) | (1L << (Local_id - 193)))) != 0) ||
                                        _la == Floatingtype) {
                            {
                                setState(1886);
                                ((StructtypeContext) _localctx).type = type();
                                ((StructtypeContext) _localctx).types.add(((StructtypeContext) _localctx).type);
                                setState(1891);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                                while (_la == T__222) {
                                    {
                                        {
                                            setState(1887);
                                            match(T__222);
                                            setState(1888);
                                            ((StructtypeContext) _localctx).type = type();
                                            ((StructtypeContext) _localctx).types.add(((StructtypeContext) _localctx).type);
                                        }
                                    }
                                    setState(1893);
                                    _errHandler.sync(this);
                                    _la = _input.LA(1);
                                }
                            }
                        }

                        setState(1896);
                        match(T__194);
                        setState(1897);
                        match(T__8);
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

    public static class VectortypeContext extends ParserRuleContext {
        public Token size;
        public TypeContext elemtype;

        public TerminalNode Integer() {
            return getToken(LLVM_IRParser.Integer, 0);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public VectortypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_vectortype;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterVectortype(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitVectortype(this);
        }
    }

    public final VectortypeContext vectortype() throws RecognitionException {
        VectortypeContext _localctx = new VectortypeContext(_ctx, getState());
        enterRule(_localctx, 302, RULE_vectortype);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1900);
                match(T__211);
                setState(1901);
                ((VectortypeContext) _localctx).size = match(Integer);
                setState(1902);
                match(T__107);
                setState(1903);
                ((VectortypeContext) _localctx).elemtype = type();
                setState(1904);
                match(T__8);
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

    public static class ArraytypeContext extends ParserRuleContext {
        public Token size;
        public TypeContext elemtype;

        public TerminalNode Integer() {
            return getToken(LLVM_IRParser.Integer, 0);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public ArraytypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_arraytype;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterArraytype(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitArraytype(this);
        }
    }

    public final ArraytypeContext arraytype() throws RecognitionException {
        ArraytypeContext _localctx = new ArraytypeContext(_ctx, getState());
        enterRule(_localctx, 304, RULE_arraytype);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1906);
                match(T__178);
                setState(1907);
                ((ArraytypeContext) _localctx).size = match(Integer);
                setState(1908);
                match(T__107);
                setState(1909);
                ((ArraytypeContext) _localctx).elemtype = type();
                setState(1910);
                match(T__208);
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

    public static class X86mmxtypeContext extends ParserRuleContext {
        public X86mmxtypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_x86mmxtype;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterX86mmxtype(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitX86mmxtype(this);
        }
    }

    public final X86mmxtypeContext x86mmxtype() throws RecognitionException {
        X86mmxtypeContext _localctx = new X86mmxtypeContext(_ctx, getState());
        enterRule(_localctx, 306, RULE_x86mmxtype);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1912);
                match(T__157);
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

    public static class VoidtypeContext extends ParserRuleContext {
        public VoidtypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_voidtype;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterVoidtype(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitVoidtype(this);
        }
    }

    public final VoidtypeContext voidtype() throws RecognitionException {
        VoidtypeContext _localctx = new VoidtypeContext(_ctx, getState());
        enterRule(_localctx, 308, RULE_voidtype);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1914);
                match(T__47);
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

    public static class MetadatatypeContext extends ParserRuleContext {
        public MetadatatypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_metadatatype;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterMetadatatype(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitMetadatatype(this);
        }
    }

    public final MetadatatypeContext metadatatype() throws RecognitionException {
        MetadatatypeContext _localctx = new MetadatatypeContext(_ctx, getState());
        enterRule(_localctx, 310, RULE_metadatatype);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1916);
                match(T__118);
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

    public static class FloatingtypeContext extends ParserRuleContext {
        public FloatingtypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_floatingtype;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterFloatingtype(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitFloatingtype(this);
        }
    }

    public final FloatingtypeContext floatingtype() throws RecognitionException {
        FloatingtypeContext _localctx = new FloatingtypeContext(_ctx, getState());
        enterRule(_localctx, 312, RULE_floatingtype);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1918);
                _la = _input.LA(1);
                if (!(((((_la - 19)) & ~0x3f) == 0 && ((1L << (_la - 19)) & ((1L << (T__221 - 19)) | (1L << (T__209 - 19)) | (1L << (T__158 - 19)))) != 0) || ((((_la - 118)) & ~0x3f) == 0 && ((1L << (_la - 118)) & ((1L << (T__122 - 118)) |
                                (1L << (T__98 - 118)) | (1L << (T__91 - 118)))) != 0))) {
                    _errHandler.recoverInline(this);
                }
                consume();
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

    public static class LinkageContext extends ParserRuleContext {
        public LinkageContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_linkage;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterLinkage(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitLinkage(this);
        }
    }

    public final LinkageContext linkage() throws RecognitionException {
        LinkageContext _localctx = new LinkageContext(_ctx, getState());
        enterRule(_localctx, 314, RULE_linkage);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1920);
                _la = _input.LA(1);
                if (!(((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & ((1L << (T__230 - 10)) | (1L << (T__229 - 10)) | (1L << (T__227 - 10)) | (1L << (T__188 - 10)) | (1L << (T__180 - 10)) | (1L << (T__176 - 10)))) != 0) ||
                                ((((_la - 78)) & ~0x3f) == 0 && ((1L << (_la - 78)) & ((1L << (T__162 - 78)) | (1L << (T__148 - 78)) | (1L << (T__144 - 78)) | (1L << (T__109 - 78)) |
                                                (1L << (T__108 - 78)) | (1L << (T__99 - 78)))) != 0) || ((((_la - 169)) & ~0x3f) == 0 && ((1L << (_la - 169)) & ((1L << (T__71 - 169)) |
                                (1L << (T__60 - 169)) | (1L << (T__40 - 169)) | (1L << (T__18 - 169)))) != 0))) {
                    _errHandler.recoverInline(this);
                }
                consume();
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

    public static class CconvContext extends ParserRuleContext {
        public Token val;
        public Token customnumber;

        public TerminalNode Integer() {
            return getToken(LLVM_IRParser.Integer, 0);
        }

        public CconvContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_cconv;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).enterCconv(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LLVM_IRListener)
                ((LLVM_IRListener) listener).exitCconv(this);
        }
    }

    public final CconvContext cconv() throws RecognitionException {
        CconvContext _localctx = new CconvContext(_ctx, getState());
        enterRule(_localctx, 316, RULE_cconv);
        int _la;
        try {
            setState(1925);
            switch (_input.LA(1)) {
                case T__233:
                case T__200:
                case T__193:
                case T__192:
                case T__183:
                case T__175:
                case T__172:
                case T__166:
                case T__163:
                case T__152:
                case T__136:
                case T__130:
                case T__125:
                case T__100:
                case T__76:
                case T__46:
                case T__41:
                case T__35:
                case T__33:
                case T__24:
                case T__20:
                    enterOuterAlt(_localctx, 1);
                    {
                        setState(1922);
                        ((CconvContext) _localctx).val = _input.LT(1);
                        _la = _input.LA(1);
                        if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__233) | (1L << T__200) | (1L << T__193) | (1L << T__192) | (1L << T__183))) != 0) ||
                                        ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (T__175 - 65)) | (1L << (T__172 - 65)) | (1L << (T__166 - 65)) | (1L << (T__163 - 65)) |
                                                        (1L << (T__152 - 65)) | (1L << (T__136 - 65)) | (1L << (T__130 - 65)) | (1L << (T__125 - 65)))) != 0) ||
                                        ((((_la - 140)) & ~0x3f) == 0 && ((1L << (_la - 140)) & ((1L << (T__100 - 140)) | (1L << (T__76 - 140)) | (1L << (T__46 - 140)) | (1L << (T__41 - 140)))) != 0) || ((((_la - 205)) & ~0x3f) == 0 && ((1L << (_la - 205)) & ((1L << (T__35 - 205)) |
                                        (1L << (T__33 - 205)) | (1L << (T__24 - 205)) | (1L << (T__20 - 205)))) != 0))) {
                            ((CconvContext) _localctx).val = (Token) _errHandler.recoverInline(this);
                        }
                        consume();
                    }
                    break;
                case T__31:
                    enterOuterAlt(_localctx, 2);
                    {
                        setState(1923);
                        ((CconvContext) _localctx).val = match(T__31);
                        setState(1924);
                        ((CconvContext) _localctx).customnumber = match(Integer);
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

    public static final String _serializedATN = "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u0107\u078a\4\2\t" + "\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"
                    + "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" + "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"
                    + "\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!" + "\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"
                    + ",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t" + "\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="
                    + "\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I" + "\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"
                    + "\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4" + "`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"
                    + "k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\4u\tu\4v\tv\4" + "w\tw\4x\tx\4y\ty\4z\tz\4{\t{\4|\t|\4}\t}\4~\t~\4\177\t\177\4\u0080\t\u0080"
                    + "\4\u0081\t\u0081\4\u0082\t\u0082\4\u0083\t\u0083\4\u0084\t\u0084\4\u0085" + "\t\u0085\4\u0086\t\u0086\4\u0087\t\u0087\4\u0088\t\u0088\4\u0089\t\u0089"
                    + "\4\u008a\t\u008a\4\u008b\t\u008b\4\u008c\t\u008c\4\u008d\t\u008d\4\u008e" + "\t\u008e\4\u008f\t\u008f\4\u0090\t\u0090\4\u0091\t\u0091\4\u0092\t\u0092"
                    + "\4\u0093\t\u0093\4\u0094\t\u0094\4\u0095\t\u0095\4\u0096\t\u0096\4\u0097" + "\t\u0097\4\u0098\t\u0098\4\u0099\t\u0099\4\u009a\t\u009a\4\u009b\t\u009b"
                    + "\4\u009c\t\u009c\4\u009d\t\u009d\4\u009e\t\u009e\4\u009f\t\u009f\4\u00a0" + "\t\u00a0\3\2\7\2\u0142\n\2\f\2\16\2\u0145\13\2\3\3\3\3\3\3\3\3\3\3\3\3"
                    + "\5\3\u014d\n\3\3\4\3\4\3\4\3\4\3\4\6\4\u0154\n\4\r\4\16\4\u0155\3\4\6" + "\4\u0159\n\4\r\4\16\4\u015a\3\4\3\4\6\4\u015f\n\4\r\4\16\4\u0160\3\4\6"
                    + "\4\u0164\n\4\r\4\16\4\u0165\6\4\u0168\n\4\r\4\16\4\u0169\3\4\3\4\3\5\3" + "\5\3\5\5\5\u0171\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u017a\n\6\3\7\3\7"
                    + "\5\7\u017e\n\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0188\n\t\3\n\3\n\3" + "\n\3\n\5\n\u018e\n\n\3\13\3\13\3\13\3\13\3\13\5\13\u0195\n\13\3\f\3\f"
                    + "\3\f\5\f\u019a\n\f\3\r\3\r\3\r\5\r\u019f\n\r\3\16\3\16\3\16\3\16\3\16" + "\3\16\5\16\u01a7\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17"
                    + "\u01b2\n\17\3\20\3\20\3\20\5\20\u01b7\n\20\3\21\3\21\3\21\5\21\u01bc\n" + "\21\3\21\5\21\u01bf\n\21\3\21\3\21\3\21\3\22\3\22\3\22\5\22\u01c7\n\22"
                    + "\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\5\25\u01d4\n\25" + "\3\25\5\25\u01d7\n\25\3\25\5\25\u01da\n\25\3\25\5\25\u01dd\n\25\3\25\3"
                    + "\25\3\25\5\25\u01e2\n\25\3\25\3\25\5\25\u01e6\n\25\3\25\3\25\5\25\u01ea" + "\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"
                    + "\3\26\3\26\5\26\u01fb\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27" + "\3\27\5\27\u0207\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31"
                    + "\5\31\u0213\n\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\7\31\u021c\n\31\f" + "\31\16\31\u021f\13\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"
                    + "\3\32\3\33\3\33\3\33\3\33\5\33\u0230\n\33\3\33\3\33\3\33\3\33\3\33\3\33" + "\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35"
                    + "\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37" + "\3\37\3\37\3\37\6\37\u0257\n\37\r\37\16\37\u0258\3\37\3\37\3 \3 \3 \3"
                    + " \3 \3 \3 \6 \u0264\n \r \16 \u0265\3 \3 \3!\3!\5!\u026c\n!\3!\5!\u026f" + "\n!\3!\3!\5!\u0273\n!\3!\5!\u0276\n!\3!\3!\3!\3!\3!\3!\3\"\3\"\3#\3#\3"
                    + "#\3#\3#\3#\3#\3$\3$\3%\3%\5%\u028b\n%\3%\3%\3%\3%\5%\u0291\n%\3%\3%\5" + "%\u0295\n%\3&\3&\5&\u0299\n&\3&\3&\3\'\3\'\5\'\u029f\n\'\3\'\3\'\3(\3"
                    + "(\3(\7(\u02a6\n(\f(\16(\u02a9\13(\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*" + "\3*\3*\3*\5*\u02ba\n*\3+\3+\3+\3+\3+\7+\u02c1\n+\f+\16+\u02c4\13+\5+\u02c6"
                    + "\n+\3+\3+\3,\3,\3,\5,\u02cd\n,\3-\3-\3.\3.\3.\3.\3.\3/\3/\3\60\3\60\3" + "\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\64\3"
                    + "\64\5\64\u02e9\n\64\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\6\65\u02f3" + "\n\65\r\65\16\65\u02f4\3\65\3\65\3\65\3\66\3\66\3\66\3\67\5\67\u02fe\n"
                    + "\67\3\67\5\67\u0301\n\67\3\67\5\67\u0304\n\67\3\67\5\67\u0307\n\67\3\67" + "\5\67\u030a\n\67\3\67\3\67\3\67\3\67\3\67\5\67\u0311\n\67\3\67\3\67\5"
                    + "\67\u0315\n\67\3\67\5\67\u0318\n\67\3\67\5\67\u031b\n\67\3\67\5\67\u031e" + "\n\67\3\67\5\67\u0321\n\67\38\38\38\39\39\39\39\39\39\39\39\79\u032e\n"
                    + "9\f9\169\u0331\139\39\39\59\u0335\n9\59\u0337\n9\39\59\u033a\n9\3:\6:" + "\u033d\n:\r:\16:\u033e\3:\6:\u0342\n:\r:\16:\u0343\3:\3:\3:\3:\3:\3:\6"
                    + ":\u034c\n:\r:\16:\u034d\6:\u0350\n:\r:\16:\u0351\3;\3;\3<\3<\3=\3=\3=" + "\3=\3=\7=\u035d\n=\f=\16=\u0360\13=\3=\3=\3=\7=\u0365\n=\f=\16=\u0368"
                    + "\13=\3=\3=\3=\3>\3>\5>\u036f\n>\3?\3?\3?\3?\3@\3@\3@\7@\u0378\n@\f@\16" + "@\u037b\13@\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\5A\u0387\nA\3A\7A\u038a\nA\f"
                    + "A\16A\u038d\13A\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B" + "\3B\3B\3B\3B\3B\3B\3B\5B\u03a8\nB\3C\3C\5C\u03ac\nC\3D\3D\7D\u03b0\nD"
                    + "\fD\16D\u03b3\13D\3D\3D\5D\u03b7\nD\3E\3E\7E\u03bb\nE\fE\16E\u03be\13" + "E\3E\5E\u03c1\nE\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\5F\u03cf\nF\3F\7"
                    + "F\u03d2\nF\fF\16F\u03d5\13F\3G\3G\3G\3H\3H\3H\3H\3H\3H\5H\u03e0\nH\3I" + "\3I\3I\3I\3I\3I\3I\3I\3I\3I\3I\3I\3I\3I\5I\u03f0\nI\3J\3J\3J\3J\3J\3J"
                    + "\3J\3J\3J\3J\3J\7J\u03fd\nJ\fJ\16J\u0400\13J\3J\3J\3K\3K\3K\3K\3K\3K\3" + "K\3K\3K\7K\u040d\nK\fK\16K\u0410\13K\5K\u0412\nK\3K\3K\3L\3L\5L\u0418"
                    + "\nL\3L\5L\u041b\nL\3L\5L\u041e\nL\3L\5L\u0421\nL\3L\3L\3L\3L\5L\u0427" + "\nL\3L\3L\3L\3L\3L\3L\3L\3M\3M\5M\u0432\nM\3M\5M\u0435\nM\3M\5M\u0438"
                    + "\nM\3M\5M\u043b\nM\3M\3M\3M\3M\5M\u0441\nM\3M\3M\3M\3M\3M\3M\3M\3N\3N" + "\3N\3O\3O\3P\3P\3P\5P\u0452\nP\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q"
                    + "\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q" + "\5Q\u0478\nQ\3R\3R\5R\u047c\nR\3R\5R\u047f\nR\3R\3R\3R\3R\3R\3R\3S\3S"
                    + "\7S\u0489\nS\fS\16S\u048c\13S\3S\3S\3S\3S\3S\3S\3T\3T\3U\3U\5U\u0498\n" + "U\3U\5U\u049b\nU\3U\3U\3U\3U\3U\3U\3V\3V\7V\u04a5\nV\fV\16V\u04a8\13V"
                    + "\3V\3V\3V\3V\3V\3V\3W\3W\5W\u04b2\nW\3W\5W\u04b5\nW\3W\3W\3W\3W\3W\3W" + "\3X\3X\7X\u04bf\nX\fX\16X\u04c2\13X\3X\3X\3X\3X\3X\3X\3Y\3Y\5Y\u04cc\n"
                    + "Y\3Y\3Y\3Y\3Y\3Y\3Y\3Z\3Z\5Z\u04d6\nZ\3Z\3Z\3Z\3Z\3Z\3Z\3[\3[\7[\u04e0" + "\n[\f[\16[\u04e3\13[\3[\3[\3[\3[\3[\3[\3\\\3\\\3\\\3\\\3\\\3\\\3\\\3]"
                    + "\3]\3]\3]\3]\3]\3]\3^\3^\3^\3^\3^\3^\3^\3_\3_\3_\3_\3_\3_\3_\3_\3_\3_" + "\3_\3_\3_\3_\3_\3_\3_\3_\5_\u0512\n_\3`\3`\5`\u0516\n`\3`\5`\u0519\n`"
                    + "\3`\3`\3`\3`\3`\3`\3a\3a\5a\u0523\na\3a\3a\3a\3a\3a\3a\3b\3b\5b\u052d" + "\nb\3b\3b\3b\3b\3b\3b\3c\3c\3c\3c\3c\3c\3c\3d\3d\3d\3d\3d\3d\3d\3e\3e"
                    + "\3e\3e\3e\3e\3e\3f\3f\3f\5f\u054d\nf\3g\3g\3g\3g\3g\3h\3h\3h\3h\3h\3h" + "\3h\3i\3i\3i\3i\3i\3i\3i\3j\3j\5j\u0564\nj\3k\3k\3k\3k\6k\u056a\nk\rk"
                    + "\16k\u056b\3l\3l\3l\3l\3l\3l\6l\u0574\nl\rl\16l\u0575\3m\3m\3m\3m\3m\3" + "m\3m\5m\u057f\nm\3n\3n\3n\3n\3n\3n\5n\u0587\nn\3n\3n\3n\3n\5n\u058d\n"
                    + "n\3o\3o\5o\u0591\no\3o\3o\3o\5o\u0596\no\3o\3o\3o\3o\5o\u059c\no\3o\3" + "o\3o\5o\u05a1\no\3o\3o\3o\5o\u05a6\no\3o\3o\5o\u05aa\no\3o\3o\3o\3o\5"
                    + "o\u05b0\no\3o\3o\3o\5o\u05b5\no\3p\3p\5p\u05b9\np\3p\3p\3p\3p\3p\5p\u05c0" + "\np\3p\3p\3p\3p\3p\5p\u05c7\np\3p\3p\3p\5p\u05cc\np\3p\3p\3p\3p\5p\u05d2"
                    + "\np\3p\3p\3p\3p\3p\5p\u05d9\np\3p\3p\3p\3p\5p\u05df\np\3p\3p\3p\3p\5p" + "\u05e5\np\3q\3q\5q\u05e9\nq\3q\3q\3r\3r\5r\u05ef\nr\3r\3r\3r\3r\3r\3r"
                    + "\5r\u05f7\nr\3r\3r\3s\3s\5s\u05fd\ns\3s\3s\3s\3s\3s\5s\u0604\ns\3s\3s" + "\3t\3t\3u\3u\5u\u060c\nu\3u\3u\3u\7u\u0611\nu\fu\16u\u0614\13u\3v\3v\3"
                    + "v\3v\3v\3v\3w\3w\3x\3x\3x\3x\3x\3x\3x\5x\u0625\nx\3y\3y\3y\3y\3y\3y\3" + "y\3y\3z\3z\3z\3{\3{\3{\3{\3{\3{\3{\3|\3|\3}\3}\3}\3}\3}\3}\3}\3}\3}\3"
                    + "}\3}\3}\3}\3}\3}\7}\u064a\n}\f}\16}\u064d\13}\3~\3~\3~\3~\3~\3~\3~\3\177" + "\3\177\5\177\u0658\n\177\5\177\u065a\n\177\3\177\3\177\5\177\u065e\n\177"
                    + "\3\177\5\177\u0661\n\177\3\177\3\177\3\177\3\177\5\177\u0667\n\177\3\177" + "\3\177\3\u0080\3\u0080\5\u0080\u066d\n\u0080\5\u0080\u066f\n\u0080\3\u0080"
                    + "\3\u0080\5\u0080\u0673\n\u0080\3\u0080\5\u0080\u0676\n\u0080\3\u0080\3" + "\u0080\3\u0080\3\u0080\5\u0080\u067c\n\u0080\3\u0080\3\u0080\3\u0081\3"
                    + "\u0081\3\u0081\3\u0081\3\u0081\3\u0081\3\u0081\3\u0081\7\u0081\u0688\n" + "\u0081\f\u0081\16\u0081\u068b\13\u0081\5\u0081\u068d\n\u0081\3\u0081\3"
                    + "\u0081\3\u0081\3\u0082\3\u0082\3\u0082\3\u0082\5\u0082\u0696\n\u0082\3" + "\u0083\3\u0083\5\u0083\u069a\n\u0083\3\u0083\5\u0083\u069d\n\u0083\3\u0083"
                    + "\5\u0083\u06a0\n\u0083\3\u0083\3\u0083\3\u0083\3\u0083\3\u0084\3\u0084" + "\3\u0084\3\u0084\3\u0084\3\u0085\3\u0085\3\u0085\3\u0085\3\u0085\3\u0085"
                    + "\5\u0085\u06b1\n\u0085\3\u0085\7\u0085\u06b4\n\u0085\f\u0085\16\u0085" + "\u06b7\13\u0085\3\u0086\3\u0086\3\u0086\3\u0086\3\u0086\3\u0086\5\u0086"
                    + "\u06bf\n\u0086\3\u0087\3\u0087\3\u0088\3\u0088\3\u0088\3\u0088\3\u0089" + "\3\u0089\5\u0089\u06c9\n\u0089\3\u008a\6\u008a\u06cc\n\u008a\r\u008a\16"
                    + "\u008a\u06cd\3\u008b\3\u008b\3\u008b\3\u008b\3\u008b\3\u008b\5\u008b\u06d6" + "\n\u008b\3\u008b\3\u008b\3\u008b\3\u008b\3\u008b\3\u008b\5\u008b\u06de"
                    + "\n\u008b\3\u008c\3\u008c\3\u008c\3\u008c\3\u008d\3\u008d\3\u008d\3\u008d" + "\3\u008e\3\u008e\6\u008e\u06ea\n\u008e\r\u008e\16\u008e\u06eb\3\u008e"
                    + "\3\u008e\7\u008e\u06f0\n\u008e\f\u008e\16\u008e\u06f3\13\u008e\3\u008e" + "\7\u008e\u06f6\n\u008e\f\u008e\16\u008e\u06f9\13\u008e\5\u008e\u06fb\n"
                    + "\u008e\3\u008f\5\u008f\u06fe\n\u008f\3\u008f\3\u008f\3\u0090\3\u0090\7" + "\u0090\u0704\n\u0090\f\u0090\16\u0090\u0707\13\u0090\3\u0090\7\u0090\u070a"
                    + "\n\u0090\f\u0090\16\u0090\u070d\13\u0090\3\u0091\3\u0091\3\u0091\3\u0091" + "\7\u0091\u0713\n\u0091\f\u0091\16\u0091\u0716\13\u0091\3\u0091\3\u0091"
                    + "\5\u0091\u071a\n\u0091\5\u0091\u071c\n\u0091\3\u0091\5\u0091\u071f\n\u0091" + "\3\u0091\3\u0091\7\u0091\u0723\n\u0091\f\u0091\16\u0091\u0726\13\u0091"
                    + "\3\u0092\3\u0092\3\u0092\3\u0092\3\u0092\3\u0092\3\u0092\3\u0092\3\u0092" + "\5\u0092\u0731\n\u0092\3\u0092\3\u0092\5\u0092\u0735\n\u0092\5\u0092\u0737"
                    + "\n\u0092\3\u0093\3\u0093\3\u0093\3\u0093\3\u0093\3\u0093\3\u0093\3\u0093" + "\5\u0093\u0741\n\u0093\3\u0093\3\u0093\5\u0093\u0745\n\u0093\5\u0093\u0747"
                    + "\n\u0093\3\u0094\3\u0094\3\u0094\3\u0094\3\u0095\3\u0095\3\u0096\3\u0096" + "\3\u0097\3\u0097\3\u0098\3\u0098\3\u0098\3\u0098\7\u0098\u0757\n\u0098"
                    + "\f\u0098\16\u0098\u075a\13\u0098\5\u0098\u075c\n\u0098\3\u0098\3\u0098" + "\3\u0098\3\u0098\3\u0098\3\u0098\7\u0098\u0764\n\u0098\f\u0098\16\u0098"
                    + "\u0767\13\u0098\5\u0098\u0769\n\u0098\3\u0098\3\u0098\5\u0098\u076d\n" + "\u0098\3\u0099\3\u0099\3\u0099\3\u0099\3\u0099\3\u0099\3\u009a\3\u009a"
                    + "\3\u009a\3\u009a\3\u009a\3\u009a\3\u009b\3\u009b\3\u009c\3\u009c\3\u009d" + "\3\u009d\3\u009e\3\u009e\3\u009f\3\u009f\3\u00a0\3\u00a0\3\u00a0\5\u00a0"
                    + "\u0788\n\u00a0\3\u00a0\2\2\u00a1\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36" + " \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082"
                    + "\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a" + "\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2"
                    + "\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca" + "\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8\u00da\u00dc\u00de\u00e0\u00e2"
                    + "\u00e4\u00e6\u00e8\u00ea\u00ec\u00ee\u00f0\u00f2\u00f4\u00f6\u00f8\u00fa" + "\u00fc\u00fe\u0100\u0102\u0104\u0106\u0108\u010a\u010c\u010e\u0110\u0112"
                    + "\u0114\u0116\u0118\u011a\u011c\u011e\u0120\u0122\u0124\u0126\u0128\u012a" + "\u012c\u012e\u0130\u0132\u0134\u0136\u0138\u013a\u013c\u013e\2\24\3\2"
                    + "\u00fa\u00fb\4\2\67\67\u0099\u0099\4\2\u00aa\u00aa\u00d0\u00d0\6\2  \u009e" + "\u009e\u00b1\u00b1\u00e3\u00e3\6\2\6\6mm\u0082\u0082\u00a1\u00a1\13\2"
                    + "\20\20%%EEII\u0088\u0089\u008c\u008c\u0091\u0091\u0098\u0098\u00dc\u00dc" + "\5\2QQ\u00c6\u00c6\u00dd\u00dd\34\2\13\13\34\34$$))JJNNSSnnzz\177\177"
                    + "\u0081\u0081\u0094\u0094\u009b\u009b\u00a0\u00a0\u00ac\u00ac\u00ae\u00ae" + "\u00b5\u00b5\u00b9\u00ba\u00c5\u00c5\u00c7\u00c7\u00cb\u00cb\u00cd\u00ce"
                    + "\u00df\u00df\u00e6\u00e6\u00ed\u00ed\u00f1\u00f1\6\2\27\30\u009a\u009a" + "\u00a4\u00a4\u00d8\u00d8\f\2//EEIIWW~~\u0089\u0089\u0095\u0095\u009e\u009e"
                    + "\u00d7\u00d7\u00e2\u00e3\17\2\33\33\64\64::==``}}\u0083\u0083\u009d\u009d" + "\u00a3\u00a3\u00b2\u00b2\u00c8\u00c8\u00d5\u00d5\u00d9\u00d9\f\2\n\n\31"
                    + "\31++RR[[hh\u00af\u00af\u00b3\u00b3\u00c1\u00c1\u00ee\u00ee\21\2\3\3\n" + "\n++YYeehhllww\u0092\u0092\u00a2\u00a2\u00a9\u00a9\u00af\u00af\u00bd\u00bd"
                    + "\u00d2\u00d2\u00f4\u00f4\b\2--DDoo\u00a7\u00a7\u00ec\u00ec\u00f0\u00f0" + "\5\2\u009e\u009e\u00cc\u00cc\u00e3\u00e3\b\2\25\25!!TTxx\u0090\u0090\u0097"
                    + "\u0097\20\2\f\r\17\17\66\66>>BBPP^^bb\u0085\u0086\u008f\u008f\u00ab\u00ab" + "\u00b6\u00b6\u00ca\u00ca\u00e0\u00e0\26\2\t\t**\61\62;;CCFFLLOOZZjjpp"
                    + "uu\u008e\u008e\u00a6\u00a6\u00c4\u00c4\u00c9\u00c9\u00cf\u00cf\u00d1\u00d1" + "\u00da\u00da\u00de\u00de\u0813\2\u0143\3\2\2\2\4\u014c\3\2\2\2\6\u014e"
                    + "\3\2\2\2\b\u016d\3\2\2\2\n\u0179\3\2\2\2\f\u017d\3\2\2\2\16\u017f\3\2" + "\2\2\20\u0187\3\2\2\2\22\u018d\3\2\2\2\24\u0194\3\2\2\2\26\u0199\3\2\2"
                    + "\2\30\u019e\3\2\2\2\32\u01a6\3\2\2\2\34\u01b1\3\2\2\2\36\u01b6\3\2\2\2" + " \u01b8\3\2\2\2\"\u01c6\3\2\2\2$\u01c8\3\2\2\2&\u01cd\3\2\2\2(\u01d1\3"
                    + "\2\2\2*\u01fa\3\2\2\2,\u0206\3\2\2\2.\u0208\3\2\2\2\60\u0210\3\2\2\2\62" + "\u0222\3\2\2\2\64\u022f\3\2\2\2\66\u0237\3\2\2\28\u023e\3\2\2\2:\u0248"
                    + "\3\2\2\2<\u0251\3\2\2\2>\u025c\3\2\2\2@\u0275\3\2\2\2B\u027d\3\2\2\2D" + "\u027f\3\2\2\2F\u0286\3\2\2\2H\u0294\3\2\2\2J\u0296\3\2\2\2L\u029c\3\2"
                    + "\2\2N\u02a2\3\2\2\2P\u02aa\3\2\2\2R\u02b9\3\2\2\2T\u02bb\3\2\2\2V\u02cc" + "\3\2\2\2X\u02ce\3\2\2\2Z\u02d0\3\2\2\2\\\u02d5\3\2\2\2^\u02d7\3\2\2\2"
                    + "`\u02dc\3\2\2\2b\u02df\3\2\2\2d\u02e3\3\2\2\2f\u02e8\3\2\2\2h\u02ea\3" + "\2\2\2j\u02f9\3\2\2\2l\u02fd\3\2\2\2n\u0322\3\2\2\2p\u0339\3\2\2\2r\u034f"
                    + "\3\2\2\2t\u0353\3\2\2\2v\u0355\3\2\2\2x\u0357\3\2\2\2z\u036e\3\2\2\2|" + "\u0370\3\2\2\2~\u0374\3\2\2\2\u0080\u0386\3\2\2\2\u0082\u038e\3\2\2\2"
                    + "\u0084\u03ab\3\2\2\2\u0086\u03b6\3\2\2\2\u0088\u03c0\3\2\2\2\u008a\u03ce" + "\3\2\2\2\u008c\u03d6\3\2\2\2\u008e\u03d9\3\2\2\2\u0090\u03e1\3\2\2\2\u0092"
                    + "\u03f1\3\2\2\2\u0094\u0403\3\2\2\2\u0096\u0415\3\2\2\2\u0098\u042f\3\2" + "\2\2\u009a\u0449\3\2\2\2\u009c\u044c\3\2\2\2\u009e\u0451\3\2\2\2\u00a0"
                    + "\u0477\3\2\2\2\u00a2\u0479\3\2\2\2\u00a4\u0486\3\2\2\2\u00a6\u0493\3\2" + "\2\2\u00a8\u0495\3\2\2\2\u00aa\u04a2\3\2\2\2\u00ac\u04af\3\2\2\2\u00ae"
                    + "\u04bc\3\2\2\2\u00b0\u04c9\3\2\2\2\u00b2\u04d3\3\2\2\2\u00b4\u04dd\3\2" + "\2\2\u00b6\u04ea\3\2\2\2\u00b8\u04f1\3\2\2\2\u00ba\u04f8\3\2\2\2\u00bc"
                    + "\u0511\3\2\2\2\u00be\u0513\3\2\2\2\u00c0\u0520\3\2\2\2\u00c2\u052a\3\2" + "\2\2\u00c4\u0534\3\2\2\2\u00c6\u053b\3\2\2\2\u00c8\u0542\3\2\2\2\u00ca"
                    + "\u054c\3\2\2\2\u00cc\u054e\3\2\2\2\u00ce\u0553\3\2\2\2\u00d0\u055a\3\2" + "\2\2\u00d2\u0563\3\2\2\2\u00d4\u0565\3\2\2\2\u00d6\u056d\3\2\2\2\u00d8"
                    + "\u057e\3\2\2\2\u00da\u0580\3\2\2\2\u00dc\u058e\3\2\2\2\u00de\u05b6\3\2" + "\2\2\u00e0\u05e6\3\2\2\2\u00e2\u05ec\3\2\2\2\u00e4\u05fa\3\2\2\2\u00e6"
                    + "\u0607\3\2\2\2\u00e8\u0609\3\2\2\2\u00ea\u0615\3\2\2\2\u00ec\u061b\3\2" + "\2\2\u00ee\u0624\3\2\2\2\u00f0\u0626\3\2\2\2\u00f2\u062e\3\2\2\2\u00f4"
                    + "\u0631\3\2\2\2\u00f6\u0638\3\2\2\2\u00f8\u063a\3\2\2\2\u00fa\u064e\3\2" + "\2\2\u00fc\u0655\3\2\2\2\u00fe\u066a\3\2\2\2\u0100\u067f\3\2\2\2\u0102"
                    + "\u0695\3\2\2\2\u0104\u0697\3\2\2\2\u0106\u06a5\3\2\2\2\u0108\u06aa\3\2" + "\2\2\u010a\u06be\3\2\2\2\u010c\u06c0\3\2\2\2\u010e\u06c2\3\2\2\2\u0110"
                    + "\u06c6\3\2\2\2\u0112\u06cb\3\2\2\2\u0114\u06dd\3\2\2\2\u0116\u06df\3\2" + "\2\2\u0118\u06e3\3\2\2\2\u011a\u06fa\3\2\2\2\u011c\u06fd\3\2\2\2\u011e"
                    + "\u0701\3\2\2\2\u0120\u070e\3\2\2\2\u0122\u0736\3\2\2\2\u0124\u0746\3\2" + "\2\2\u0126\u0748\3\2\2\2\u0128\u074c\3\2\2\2\u012a\u074e\3\2\2\2\u012c"
                    + "\u0750\3\2\2\2\u012e\u076c\3\2\2\2\u0130\u076e\3\2\2\2\u0132\u0774\3\2" + "\2\2\u0134\u077a\3\2\2\2\u0136\u077c\3\2\2\2\u0138\u077e\3\2\2\2\u013a"
                    + "\u0780\3\2\2\2\u013c\u0782\3\2\2\2\u013e\u0787\3\2\2\2\u0140\u0142\5\4" + "\3\2\u0141\u0140\3\2\2\2\u0142\u0145\3\2\2\2\u0143\u0141\3\2\2\2\u0143"
                    + "\u0144\3\2\2\2\u0144\3\3\2\2\2\u0145\u0143\3\2\2\2\u0146\u014d\5\u0126" + "\u0094\2\u0147\u014d\5&\24\2\u0148\u014d\5$\23\2\u0149\u014d\5\26\f\2"
                    + "\u014a\u014d\5\n\6\2\u014b\u014d\5\6\4\2\u014c\u0146\3\2\2\2\u014c\u0147" + "\3\2\2\2\u014c\u0148\3\2\2\2\u014c\u0149\3\2\2\2\u014c\u014a\3\2\2\2\u014c"
                    + "\u014b\3\2\2\2\u014d\5\3\2\2\2\u014e\u014f\7\u00a5\2\2\u014f\u0150\7\u00fc" + "\2\2\u0150\u0151\7\7\2\2\u0151\u0167\7X\2\2\u0152\u0154\5v<\2\u0153\u0152"
                    + "\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0153\3\2\2\2\u0155\u0156\3\2\2\2\u0156" + "\u0168\3\2\2\2\u0157\u0159\5t;\2\u0158\u0157\3\2\2\2\u0159\u015a\3\2\2"
                    + "\2\u015a\u0158\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015e" + "\7\7\2\2\u015d\u015f\7\u00fd\2\2\u015e\u015d\3\2\2\2\u015f\u0160\3\2\2"
                    + "\2\u0160\u015e\3\2\2\2\u0160\u0161\3\2\2\2\u0161\u0168\3\2\2\2\u0162\u0164" + "\5\b\5\2\u0163\u0162\3\2\2\2\u0164\u0165\3\2\2\2\u0165\u0163\3\2\2\2\u0165"
                    + "\u0166\3\2\2\2\u0166\u0168\3\2\2\2\u0167\u0153\3\2\2\2\u0167\u0158\3\2" + "\2\2\u0167\u0163\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u0167\3\2\2\2\u0169"
                    + "\u016a\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u016c\7\60\2\2\u016c\7\3\2\2" + "\2\u016d\u0170\7\u0101\2\2\u016e\u016f\7\7\2\2\u016f\u0171\7\u0101\2\2"
                    + "\u0170\u016e\3\2\2\2\u0170\u0171\3\2\2\2\u0171\t\3\2\2\2\u0172\u0173\7" + "\u00fa\2\2\u0173\u0174\7\7\2\2\u0174\u0175\7|\2\2\u0175\u017a\5T+\2\u0176"
                    + "\u0177\7\u00fb\2\2\u0177\u0178\7\7\2\2\u0178\u017a\5T+\2\u0179\u0172\3" + "\2\2\2\u0179\u0176\3\2\2\2\u017a\13\3\2\2\2\u017b\u017e\5\n\6\2\u017c"
                    + "\u017e\5\16\b\2\u017d\u017b\3\2\2\2\u017d\u017c\3\2\2\2\u017e\r\3\2\2" + "\2\u017f\u0180\t\2\2\2\u0180\17\3\2\2\2\u0181\u0182\5\22\n\2\u0182\u0183"
                    + "\b\t\1\2\u0183\u0188\3\2\2\2\u0184\u0185\5\24\13\2\u0185\u0186\b\t\1\2" + "\u0186\u0188\3\2\2\2\u0187\u0181\3\2\2\2\u0187\u0184\3\2\2\2\u0188\21"
                    + "\3\2\2\2\u0189\u018a\5*\26\2\u018a\u018b\b\n\1\2\u018b\u018e\3\2\2\2\u018c" + "\u018e\5\f\7\2\u018d\u0189\3\2\2\2\u018d\u018c\3\2\2\2\u018e\23\3\2\2"
                    + "\2\u018f\u0190\7\u00f8\2\2\u0190\u0195\b\13\1\2\u0191\u0192\5\32\16\2" + "\u0192\u0193\b\13\1\2\u0193\u0195\3\2\2\2\u0194\u018f\3\2\2\2\u0194\u0191"
                    + "\3\2\2\2\u0195\25\3\2\2\2\u0196\u019a\5(\25\2\u0197\u019a\5f\64\2\u0198" + "\u019a\5 \21\2\u0199\u0196\3\2\2\2\u0199\u0197\3\2\2\2\u0199\u0198\3\2"
                    + "\2\2\u019a\27\3\2\2\2\u019b\u019f\5(\25\2\u019c\u019f\5l\67\2\u019d\u019f" + "\5 \21\2\u019e\u019b\3\2\2\2\u019e\u019c\3\2\2\2\u019e\u019d\3\2\2\2\u019f"
                    + "\31\3\2\2\2\u01a0\u01a1\5\34\17\2\u01a1\u01a2\b\16\1\2\u01a2\u01a7\3\2" + "\2\2\u01a3\u01a4\5\u0118\u008d\2\u01a4\u01a5\b\16\1\2\u01a5\u01a7\3\2"
                    + "\2\2\u01a6\u01a0\3\2\2\2\u01a6\u01a3\3\2\2\2\u01a7\33\3\2\2\2\u01a8\u01a9" + "\5~@\2\u01a9\u01aa\b\17\1\2\u01aa\u01b2\3\2\2\2\u01ab\u01ac\5\u0082B\2"
                    + "\u01ac\u01ad\b\17\1\2\u01ad\u01b2\3\2\2\2\u01ae\u01af\5\u008cG\2\u01af" + "\u01b0\b\17\1\2\u01b0\u01b2\3\2\2\2\u01b1\u01a8\3\2\2\2\u01b1\u01ab\3"
                    + "\2\2\2\u01b1\u01ae\3\2\2\2\u01b2\35\3\2\2\2\u01b3\u01b7\5~@\2\u01b4\u01b7" + "\5\u0080A\2\u01b5\u01b7\5\u008aF\2\u01b6\u01b3\3\2\2\2\u01b6\u01b4\3\2"
                    + "\2\2\u01b6\u01b5\3\2\2\2\u01b7\37\3\2\2\2\u01b8\u01b9\5\u0088E\2\u01b9" + "\u01bb\7\u00f2\2\2\u01ba\u01bc\5\u013c\u009f\2\u01bb\u01ba\3\2\2\2\u01bb"
                    + "\u01bc\3\2\2\2\u01bc\u01be\3\2\2\2\u01bd\u01bf\7\u00f3\2\2\u01be\u01bd" + "\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01c1\5\u011e\u0090"
                    + "\2\u01c1\u01c2\5\"\22\2\u01c2!\3\2\2\2\u01c3\u01c7\5\30\r\2\u01c4\u01c7" + "\7\u00f7\2\2\u01c5\u01c7\5.\30\2\u01c6\u01c3\3\2\2\2\u01c6\u01c4\3\2\2"
                    + "\2\u01c6\u01c5\3\2\2\2\u01c7#\3\2\2\2\u01c8\u01c9\7s\2\2\u01c9\u01ca\t" + "\3\2\2\u01ca\u01cb\7\7\2\2\u01cb\u01cc\7\u0101\2\2\u01cc%\3\2\2\2\u01cd"
                    + "\u01ce\7i\2\2\u01ce\u01cf\7\26\2\2\u01cf\u01d0\7\u0101\2\2\u01d0\'\3\2" + "\2\2\u01d1\u01d3\5\u0088E\2\u01d2\u01d4\5\u013c\u009f\2\u01d3\u01d2\3"
                    + "\2\2\2\u01d3\u01d4\3\2\2\2\u01d4\u01d6\3\2\2\2\u01d5\u01d7\5^\60\2\u01d6" + "\u01d5\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7\u01d9\3\2\2\2\u01d8\u01da\5Z"
                    + ".\2\u01d9\u01d8\3\2\2\2\u01d9\u01da\3\2\2\2\u01da\u01dc\3\2\2\2\u01db" + "\u01dd\7V\2\2\u01dc\u01db\3\2\2\2\u01dc\u01dd\3\2\2\2\u01dd\u01de\3\2"
                    + "\2\2\u01de\u01df\t\4\2\2\u01df\u01e1\5\u011e\u0090\2\u01e0\u01e2\5*\26" + "\2\u01e1\u01e0\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2\u01e5\3\2\2\2\u01e3\u01e4"
                    + "\7\24\2\2\u01e4\u01e6\5`\61\2\u01e5\u01e3\3\2\2\2\u01e5\u01e6\3\2\2\2" + "\u01e6\u01e9\3\2\2\2\u01e7\u01e8\7\24\2\2\u01e8\u01ea\5b\62\2\u01e9\u01e7"
                    + "\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea)\3\2\2\2\u01eb\u01ec\5R*\2\u01ec\u01ed" + "\b\26\1\2\u01ed\u01fb\3\2\2\2\u01ee\u01fb\5H%\2\u01ef\u01fb\5J&\2\u01f0"
                    + "\u01fb\5L\'\2\u01f1\u01fb\5F$\2\u01f2\u01fb\5T+\2\u01f3\u01fb\5X-\2\u01f4" + "\u01fb\5D#\2\u01f5\u01fb\5B\"\2\u01f6\u01fb\5,\27\2\u01f7\u01fb\5\30\r"
                    + "\2\u01f8\u01f9\7\u00f7\2\2\u01f9\u01fb\b\26\1\2\u01fa\u01eb\3\2\2\2\u01fa" + "\u01ee\3\2\2\2\u01fa\u01ef\3\2\2\2\u01fa\u01f0\3\2\2\2\u01fa\u01f1\3\2"
                    + "\2\2\u01fa\u01f2\3\2\2\2\u01fa\u01f3\3\2\2\2\u01fa\u01f4\3\2\2\2\u01fa" + "\u01f5\3\2\2\2\u01fa\u01f6\3\2\2\2\u01fa\u01f7\3\2\2\2\u01fa\u01f8\3\2"
                    + "\2\2\u01fb+\3\2\2\2\u01fc\u0207\5.\30\2\u01fd\u0207\5\60\31\2\u01fe\u0207" + "\5\62\32\2\u01ff\u0207\5\64\33\2\u0200\u0207\5\66\34\2\u0201\u0207\58"
                    + "\35\2\u0202\u0207\5:\36\2\u0203\u0207\5<\37\2\u0204\u0207\5> \2\u0205" + "\u0207\5@!\2\u0206\u01fc\3\2\2\2\u0206\u01fd\3\2\2\2\u0206\u01fe\3\2\2"
                    + "\2\u0206\u01ff\3\2\2\2\u0206\u0200\3\2\2\2\u0206\u0201\3\2\2\2\u0206\u0202" + "\3\2\2\2\u0206\u0203\3\2\2\2\u0206\u0204\3\2\2\2\u0206\u0205\3\2\2\2\u0207"
                    + "-\3\2\2\2\u0208\u0209\5\u00ecw\2\u0209\u020a\7]\2\2\u020a\u020b\5\u011e" + "\u0090\2\u020b\u020c\5\22\n\2\u020c\u020d\7?\2\2\u020d\u020e\5\u011e\u0090"
                    + "\2\u020e\u020f\7H\2\2\u020f/\3\2\2\2\u0210\u0212\7\35\2\2\u0211\u0213" + "\7r\2\2\u0212\u0211\3\2\2\2\u0212\u0213\3\2\2\2\u0213\u0214\3\2\2\2\u0214"
                    + "\u0215\7]\2\2\u0215\u0216\5\u011e\u0090\2\u0216\u021d\5\22\n\2\u0217\u0218" + "\7\24\2\2\u0218\u0219\5\u011e\u0090\2\u0219\u021a\5*\26\2\u021a\u021c"
                    + "\3\2\2\2\u021b\u0217\3\2\2\2\u021c\u021f\3\2\2\2\u021d\u021b\3\2\2\2\u021d" + "\u021e\3\2\2\2\u021e\u0220\3\2\2\2\u021f\u021d\3\2\2\2\u0220\u0221\7H"
                    + "\2\2\u0221\61\3\2\2\2\u0222\u0223\7A\2\2\u0223\u0224\7]\2\2\u0224\u0225" + "\5\u010e\u0088\2\u0225\u0226\7\24\2\2\u0226\u0227\5\u010e\u0088\2\u0227"
                    + "\u0228\7\24\2\2\u0228\u0229\5\u010e\u0088\2\u0229\u022a\7H\2\2\u022a\63" + "\3\2\2\2\u022b\u022c\7k\2\2\u022c\u0230\5\u00f2z\2\u022d\u022e\7\u0084"
                    + "\2\2\u022e\u0230\5\u00f6|\2\u022f\u022b\3\2\2\2\u022f\u022d\3\2\2\2\u0230" + "\u0231\3\2\2\2\u0231\u0232\7]\2\2\u0232\u0233\5\u010e\u0088\2\u0233\u0234"
                    + "\7\24\2\2\u0234\u0235\5\u010e\u0088\2\u0235\u0236\7H\2\2\u0236\65\3\2" + "\2\2\u0237\u0238\7\16\2\2\u0238\u0239\7]\2\2\u0239\u023a\5\u010e\u0088"
                    + "\2\u023a\u023b\7\24\2\2\u023b\u023c\5\u010e\u0088\2\u023c\u023d\7H\2\2" + "\u023d\67\3\2\2\2\u023e\u023f\7\u00a8\2\2\u023f\u0240\7]\2\2\u0240\u0241"
                    + "\5\u0130\u0099\2\u0241\u0242\5\20\t\2\u0242\u0243\7\24\2\2\u0243\u0244" + "\5\u010e\u0088\2\u0244\u0245\7\24\2\2\u0245\u0246\5\u010e\u0088\2\u0246"
                    + "\u0247\7H\2\2\u02479\3\2\2\2\u0248\u0249\78\2\2\u0249\u024a\7]\2\2\u024a" + "\u024b\5\u010e\u0088\2\u024b\u024c\7\24\2\2\u024c\u024d\5\u010e\u0088"
                    + "\2\u024d\u024e\7\24\2\2\u024e\u024f\5\u010e\u0088\2\u024f\u0250\7H\2\2" + "\u0250;\3\2\2\2\u0251\u0252\7\u00bf\2\2\u0252\u0253\7]\2\2\u0253\u0256"
                    + "\5\u010e\u0088\2\u0254\u0255\7\24\2\2\u0255\u0257\7\u00fd\2\2\u0256\u0254" + "\3\2\2\2\u0257\u0258\3\2\2\2\u0258\u0256\3\2\2\2\u0258\u0259\3\2\2\2\u0259"
                    + "\u025a\3\2\2\2\u025a\u025b\7H\2\2\u025b=\3\2\2\2\u025c\u025d\7\22\2\2" + "\u025d\u025e\7]\2\2\u025e\u025f\5\u010e\u0088\2\u025f\u0260\7\24\2\2\u0260"
                    + "\u0263\5\u010e\u0088\2\u0261\u0262\7\24\2\2\u0262\u0264\7\u00fd\2\2\u0263" + "\u0261\3\2\2\2\u0264\u0265\3\2\2\2\u0265\u0263\3\2\2\2\u0265\u0266\3\2"
                    + "\2\2\u0266\u0267\3\2\2\2\u0267\u0268\7H\2\2\u0268?\3\2\2\2\u0269\u026b" + "\t\5\2\2\u026a\u026c\7\\\2\2\u026b\u026a\3\2\2\2\u026b\u026c\3\2\2\2\u026c"
                    + "\u026e\3\2\2\2\u026d\u026f\7\21\2\2\u026e\u026d\3\2\2\2\u026e\u026f\3" + "\2\2\2\u026f\u0276\3\2\2\2\u0270\u0272\t\6\2\2\u0271\u0273\7\32\2\2\u0272"
                    + "\u0271\3\2\2\2\u0272\u0273\3\2\2\2\u0273\u0276\3\2\2\2\u0274\u0276\t\7" + "\2\2\u0275\u0269\3\2\2\2\u0275\u0270\3\2\2\2\u0275\u0274\3\2\2\2\u0276"
                    + "\u0277\3\2\2\2\u0277\u0278\7]\2\2\u0278\u0279\5\u010e\u0088\2\u0279\u027a" + "\7\24\2\2\u027a\u027b\5\u010e\u0088\2\u027b\u027c\7H\2\2\u027cA\3\2\2"
                    + "\2\u027d\u027e\7q\2\2\u027eC\3\2\2\2\u027f\u0280\7\u00e9\2\2\u0280\u0281" + "\7]\2\2\u0281\u0282\5\22\n\2\u0282\u0283\7\24\2\2\u0283\u0284\5\u009e"
                    + "P\2\u0284\u0285\7H\2\2\u0285E\3\2\2\2\u0286\u0287\7\u0096\2\2\u0287G\3" + "\2\2\2\u0288\u028a\7X\2\2\u0289\u028b\5N(\2\u028a\u0289\3\2\2\2\u028a"
                    + "\u028b\3\2\2\2\u028b\u028c\3\2\2\2\u028c\u0295\7\60\2\2\u028d\u028e\7" + "\37\2\2\u028e\u0290\7X\2\2\u028f\u0291\5N(\2\u0290\u028f\3\2\2\2\u0290"
                    + "\u0291\3\2\2\2\u0291\u0292\3\2\2\2\u0292\u0293\7\60\2\2\u0293\u0295\7" + "\u00ea\2\2\u0294\u0288\3\2\2\2\u0294\u028d\3\2\2\2\u0295I\3\2\2\2\u0296"
                    + "\u0298\7@\2\2\u0297\u0299\5N(\2\u0298\u0297\3\2\2\2\u0298\u0299\3\2\2" + "\2\u0299\u029a\3\2\2\2\u029a\u029b\7\"\2\2\u029bK\3\2\2\2\u029c\u029e"
                    + "\7\37\2\2\u029d\u029f\5N(\2\u029e\u029d\3\2\2\2\u029e\u029f\3\2\2\2\u029f" + "\u02a0\3\2\2\2\u02a0\u02a1\7\u00ea\2\2\u02a1M\3\2\2\2\u02a2\u02a7\5P)"
                    + "\2\u02a3\u02a4\7\24\2\2\u02a4\u02a6\5P)\2\u02a5\u02a3\3\2\2\2\u02a6\u02a9" + "\3\2\2\2\u02a7\u02a5\3\2\2\2\u02a7\u02a8\3\2\2\2\u02a8O\3\2\2\2\u02a9"
                    + "\u02a7\3\2\2\2\u02aa\u02ab\5\u011e\u0090\2\u02ab\u02ac\5*\26\2\u02acQ" + "\3\2\2\2\u02ad\u02ae\7\u00fd\2\2\u02ae\u02ba\b*\1\2\u02af\u02b0\7\u00fe"
                    + "\2\2\u02b0\u02ba\b*\1\2\u02b1\u02b2\7\u0103\2\2\u02b2\u02ba\b*\1\2\u02b3" + "\u02b4\7\u00f4\2\2\u02b4\u02ba\b*\1\2\u02b5\u02b6\7\u00f5\2\2\u02b6\u02ba"
                    + "\b*\1\2\u02b7\u02b8\7\u0100\2\2\u02b8\u02ba\b*\1\2\u02b9\u02ad\3\2\2\2" + "\u02b9\u02af\3\2\2\2\u02b9\u02b1\3\2\2\2\u02b9\u02b3\3\2\2\2\u02b9\u02b5"
                    + "\3\2\2\2\u02b9\u02b7\3\2\2\2\u02baS\3\2\2\2\u02bb\u02bc\7\u00bb\2\2\u02bc" + "\u02c5\7X\2\2\u02bd\u02c2\5V,\2\u02be\u02bf\7\24\2\2\u02bf\u02c1\5V,\2"
                    + "\u02c0\u02be\3\2\2\2\u02c1\u02c4\3\2\2\2\u02c2\u02c0\3\2\2\2\u02c2\u02c3" + "\3\2\2\2\u02c3\u02c6\3\2\2\2\u02c4\u02c2\3\2\2\2\u02c5\u02bd\3\2\2\2\u02c5"
                    + "\u02c6\3\2\2\2\u02c6\u02c7\3\2\2\2\u02c7\u02c8\7\60\2\2\u02c8U\3\2\2\2" + "\u02c9\u02cd\5\u010e\u0088\2\u02ca\u02cd\5\f\7\2\u02cb\u02cd\7\u00f5\2"
                    + "\2\u02cc\u02c9\3\2\2\2\u02cc\u02ca\3\2\2\2\u02cc\u02cb\3\2\2\2\u02cdW" + "\3\2\2\2\u02ce\u02cf\7\u0102\2\2\u02cfY\3\2\2\2\u02d0\u02d1\7\u00e1\2"
                    + "\2\u02d1\u02d2\7]\2\2\u02d2\u02d3\5\\/\2\u02d3\u02d4\7H\2\2\u02d4[\3\2" + "\2\2\u02d5\u02d6\t\b\2\2\u02d6]\3\2\2\2\u02d7\u02d8\7\u00eb\2\2\u02d8"
                    + "\u02d9\7]\2\2\u02d9\u02da\7\u00fd\2\2\u02da\u02db\7H\2\2\u02db_\3\2\2" + "\2\u02dc\u02dd\7\23\2\2\u02dd\u02de\7\u0101\2\2\u02dea\3\2\2\2\u02df\u02e0"
                    + "\7\u00e8\2\2\u02e0\u02e1\7\u00fd\2\2\u02e1\u02e2\b\62\1\2\u02e2c\3\2\2" + "\2\u02e3\u02e4\7c\2\2\u02e4\u02e5\7\u0101\2\2\u02e5e\3\2\2\2\u02e6\u02e9"
                    + "\5h\65\2\u02e7\u02e9\5j\66\2\u02e8\u02e6\3\2\2\2\u02e8\u02e7\3\2\2\2\u02e9" + "g\3\2\2\2\u02ea\u02eb\7\u00b7\2\2\u02eb\u02ec\b\65\1\2\u02ec\u02ed\5l"
                    + "\67\2\u02ed\u02ee\7X\2\2\u02ee\u02f2\b\65\1\2\u02ef\u02f0\5x=\2\u02f0" + "\u02f1\b\65\1\2\u02f1\u02f3\3\2\2\2\u02f2\u02ef\3\2\2\2\u02f3\u02f4\3"
                    + "\2\2\2\u02f4\u02f2\3\2\2\2\u02f4\u02f5\3\2\2\2\u02f5\u02f6\3\2\2\2\u02f6" + "\u02f7\7\60\2\2\u02f7\u02f8\b\65\1\2\u02f8i\3\2\2\2\u02f9\u02fa\7_\2\2"
                    + "\u02fa\u02fb\5l\67\2\u02fbk\3\2\2\2\u02fc\u02fe\5\u013c\u009f\2\u02fd" + "\u02fc\3\2\2\2\u02fd\u02fe\3\2\2\2\u02fe\u0300\3\2\2\2\u02ff\u0301\7\u00f3"
                    + "\2\2\u0300\u02ff\3\2\2\2\u0300\u0301\3\2\2\2\u0301\u0303\3\2\2\2\u0302" + "\u0304\5\u013e\u00a0\2\u0303\u0302\3\2\2\2\u0303\u0304\3\2\2\2\u0304\u0306"
                    + "\3\2\2\2\u0305\u0307\7V\2\2\u0306\u0305\3\2\2\2\u0306\u0307\3\2\2\2\u0307" + "\u0309\3\2\2\2\u0308\u030a\5\u0112\u008a\2\u0309\u0308\3\2\2\2\u0309\u030a"
                    + "\3\2\2\2\u030a\u030b\3\2\2\2\u030b\u030c\5\u011e\u0090\2\u030c\u030d\7" + "\u00f7\2\2\u030d\u030e\7]\2\2\u030e\u0310\b\67\1\2\u030f\u0311\5p9\2\u0310"
                    + "\u030f\3\2\2\2\u0310\u0311\3\2\2\2\u0311\u0312\3\2\2\2\u0312\u0314\7H" + "\2\2\u0313\u0315\5r:\2\u0314\u0313\3\2\2\2\u0314\u0315\3\2\2\2\u0315\u0317"
                    + "\3\2\2\2\u0316\u0318\5`\61\2\u0317\u0316\3\2\2\2\u0317\u0318\3\2\2\2\u0318" + "\u031a\3\2\2\2\u0319\u031b\5b\62\2\u031a\u0319\3\2\2\2\u031a\u031b\3\2"
                    + "\2\2\u031b\u031d\3\2\2\2\u031c\u031e\5d\63\2\u031d\u031c\3\2\2\2\u031d" + "\u031e\3\2\2\2\u031e\u0320\3\2\2\2\u031f\u0321\5n8\2\u0320\u031f\3\2\2"
                    + "\2\u0320\u0321\3\2\2\2\u0321m\3\2\2\2\u0322\u0323\7K\2\2\u0323\u0324\5" + "P)\2\u0324o\3\2\2\2\u0325\u0326\5\u011e\u0090\2\u0326\u0327\7\u00f8\2"
                    + "\2\u0327\u032f\b9\1\2\u0328\u0329\7\24\2\2\u0329\u032a\5\u011e\u0090\2" + "\u032a\u032b\7\u00f8\2\2\u032b\u032c\b9\1\2\u032c\u032e\3\2\2\2\u032d"
                    + "\u0328\3\2\2\2\u032e\u0331\3\2\2\2\u032f\u032d\3\2\2\2\u032f\u0330\3\2" + "\2\2\u0330\u0334\3\2\2\2\u0331\u032f\3\2\2\2\u0332\u0333\7\24\2\2\u0333"
                    + "\u0335\7\u00e4\2\2\u0334\u0332\3\2\2\2\u0334\u0335\3\2\2\2\u0335\u0337" + "\3\2\2\2\u0336\u0325\3\2\2\2\u0336\u0337\3\2\2\2\u0337\u033a\3\2\2\2\u0338"
                    + "\u033a\7\u00e4\2\2\u0339\u0336\3\2\2\2\u0339\u0338\3\2\2\2\u033aq\3\2" + "\2\2\u033b\u033d\5v<\2\u033c\u033b\3\2\2\2\u033d\u033e\3\2\2\2\u033e\u033c"
                    + "\3\2\2\2\u033e\u033f\3\2\2\2\u033f\u0350\3\2\2\2\u0340\u0342\5t;\2\u0341" + "\u0340\3\2\2\2\u0342\u0343\3\2\2\2\u0343\u0341\3\2\2\2\u0343\u0344\3\2"
                    + "\2\2\u0344\u0345\3\2\2\2\u0345\u0346\7]\2\2\u0346\u0347\7\u00fd\2\2\u0347" + "\u0348\7H\2\2\u0348\u0350\3\2\2\2\u0349\u034c\5\6\4\2\u034a\u034c\7\u00fc"
                    + "\2\2\u034b\u0349\3\2\2\2\u034b\u034a\3\2\2\2\u034c\u034d\3\2\2\2\u034d" + "\u034b\3\2\2\2\u034d\u034e\3\2\2\2\u034e\u0350\3\2\2\2\u034f\u033c\3\2"
                    + "\2\2\u034f\u0341\3\2\2\2\u034f\u034b\3\2\2\2\u0350\u0351\3\2\2\2\u0351" + "\u034f\3\2\2\2\u0351\u0352\3\2\2\2\u0352s\3\2\2\2\u0353\u0354\7\u00d4"
                    + "\2\2\u0354u\3\2\2\2\u0355\u0356\t\t\2\2\u0356w\3\2\2\2\u0357\u0358\b=" + "\1\2\u0358\u035e\5z>\2\u0359\u035a\5~@\2\u035a\u035b\b=\1\2\u035b\u035d"
                    + "\3\2\2\2\u035c\u0359\3\2\2\2\u035d\u0360\3\2\2\2\u035e\u035c\3\2\2\2\u035e" + "\u035f\3\2\2\2\u035f\u0366\3\2\2\2\u0360\u035e\3\2\2\2\u0361\u0362\5\u0080"
                    + "A\2\u0362\u0363\b=\1\2\u0363\u0365\3\2\2\2\u0364\u0361\3\2\2\2\u0365\u0368" + "\3\2\2\2\u0366\u0364\3\2\2\2\u0366\u0367\3\2\2\2\u0367\u0369\3\2\2\2\u0368"
                    + "\u0366\3\2\2\2\u0369\u036a\5\u008aF\2\u036a\u036b\b=\1\2\u036by\3\2\2" + "\2\u036c\u036d\7\u00f9\2\2\u036d\u036f\b>\1\2\u036e\u036c\3\2\2\2\u036e"
                    + "\u036f\3\2\2\2\u036f{\3\2\2\2\u0370\u0371\7\24\2\2\u0371\u0372\7\u00fb" + "\2\2\u0372\u0373\5\f\7\2\u0373}\3\2\2\2\u0374\u0375\5\u0086D\2\u0375\u0379"
                    + "\5\u00f8}\2\u0376\u0378\5|?\2\u0377\u0376\3\2\2\2\u0378\u037b\3\2\2\2" + "\u0379\u0377\3\2\2\2\u0379\u037a\3\2\2\2\u037a\177\3\2\2\2\u037b\u0379"
                    + "\3\2\2\2\u037c\u037d\5\u0082B\2\u037d\u037e\bA\1\2\u037e\u0387\3\2\2\2" + "\u037f\u0380\5\u00dep\2\u0380\u0381\bA\1\2\u0381\u0387\3\2\2\2\u0382\u0387"
                    + "\5\u00e0q\2\u0383\u0384\5\u00fe\u0080\2\u0384\u0385\bA\1\2\u0385\u0387" + "\3\2\2\2\u0386\u037c\3\2\2\2\u0386\u037f\3\2\2\2\u0386\u0382\3\2\2\2\u0386"
                    + "\u0383\3\2\2\2\u0387\u038b\3\2\2\2\u0388\u038a\5|?\2\u0389\u0388\3\2\2" + "\2\u038a\u038d\3\2\2\2\u038b\u0389\3\2\2\2\u038b\u038c\3\2\2\2\u038c\u0081"
                    + "\3\2\2\2\u038d\u038b\3\2\2\2\u038e\u03a7\5\u0086D\2\u038f\u0390\5\u00a0" + "Q\2\u0390\u0391\bB\1\2\u0391\u03a8\3\2\2\2\u0392\u0393\5\u00bc_\2\u0393"
                    + "\u0394\bB\1\2\u0394\u03a8\3\2\2\2\u0395\u03a8\5\u00caf\2\u0396\u03a8\5" + "\u00d2j\2\u0397\u0398\5\u00dan\2\u0398\u0399\bB\1\2\u0399\u03a8\3\2\2"
                    + "\2\u039a\u039b\5\u00dco\2\u039b\u039c\bB\1\2\u039c\u03a8\3\2\2\2\u039d" + "\u03a8\5\u00e8u\2\u039e\u03a8\5\u00e2r\2\u039f\u03a8\5\u00e4s\2\u03a0"
                    + "\u03a8\5\u00eav\2\u03a1\u03a2\5\u00eex\2\u03a2\u03a3\bB\1\2\u03a3\u03a8" + "\3\2\2\2\u03a4\u03a5\5\u00fc\177\2\u03a5\u03a6\bB\1\2\u03a6\u03a8\3\2"
                    + "\2\2\u03a7\u038f\3\2\2\2\u03a7\u0392\3\2\2\2\u03a7\u0395\3\2\2\2\u03a7" + "\u0396\3\2\2\2\u03a7\u0397\3\2\2\2\u03a7\u039a\3\2\2\2\u03a7\u039d\3\2"
                    + "\2\2\u03a7\u039e\3\2\2\2\u03a7\u039f\3\2\2\2\u03a7\u03a0\3\2\2\2\u03a7" + "\u03a1\3\2\2\2\u03a7\u03a4\3\2\2\2\u03a8\u0083\3\2\2\2\u03a9\u03aa\7\u00f8"
                    + "\2\2\u03aa\u03ac\bC\1\2\u03ab\u03a9\3\2\2\2\u03ab\u03ac\3\2\2\2\u03ac" + "\u0085\3\2\2\2\u03ad\u03b1\7\u00f8\2\2\u03ae\u03b0\7\u0105\2\2\u03af\u03ae"
                    + "\3\2\2\2\u03b0\u03b3\3\2\2\2\u03b1\u03af\3\2\2\2\u03b1\u03b2\3\2\2\2\u03b2" + "\u03b4\3\2\2\2\u03b3\u03b1\3\2\2\2\u03b4\u03b5\7\7\2\2\u03b5\u03b7\bD"
                    + "\1\2\u03b6\u03ad\3\2\2\2\u03b6\u03b7\3\2\2\2\u03b7\u0087\3\2\2\2\u03b8" + "\u03bc\7\u00f7\2\2\u03b9\u03bb\7\u0105\2\2\u03ba\u03b9\3\2\2\2\u03bb\u03be"
                    + "\3\2\2\2\u03bc\u03ba\3\2\2\2\u03bc\u03bd\3\2\2\2\u03bd\u03bf\3\2\2\2\u03be" + "\u03bc\3\2\2\2\u03bf\u03c1\7\7\2\2\u03c0\u03b8\3\2\2\2\u03c0\u03c1\3\2"
                    + "\2\2\u03c1\u0089\3\2\2\2\u03c2\u03cf\5\u008cG\2\u03c3\u03c4\5\u008eH\2" + "\u03c4\u03c5\bF\1\2\u03c5\u03cf\3\2\2\2\u03c6\u03c7\5\u0090I\2\u03c7\u03c8"
                    + "\bF\1\2\u03c8\u03cf\3\2\2\2\u03c9\u03cf\5\u0092J\2\u03ca\u03cf\5\u0094" + "K\2\u03cb\u03cf\5\u009aN\2\u03cc\u03cf\5\u009cO\2\u03cd\u03cf\5\u0096"
                    + "L\2\u03ce\u03c2\3\2\2\2\u03ce\u03c3\3\2\2\2\u03ce\u03c6\3\2\2\2\u03ce" + "\u03c9\3\2\2\2\u03ce\u03ca\3\2\2\2\u03ce\u03cb\3\2\2\2\u03ce\u03cc\3\2"
                    + "\2\2\u03ce\u03cd\3\2\2\2\u03cf\u03d3\3\2\2\2\u03d0\u03d2\5|?\2\u03d1\u03d0" + "\3\2\2\2\u03d2\u03d5\3\2\2\2\u03d3\u03d1\3\2\2\2\u03d3\u03d4\3\2\2\2\u03d4"
                    + "\u008b\3\2\2\2\u03d5\u03d3\3\2\2\2\u03d6\u03d7\5\u0086D\2\u03d7\u03d8" + "\5\u0098M\2\u03d8\u008d\3\2\2\2\u03d9\u03df\7\u00e7\2\2\u03da\u03db\5"
                    + "\u010e\u0088\2\u03db\u03dc\bH\1\2\u03dc\u03e0\3\2\2\2\u03dd\u03de\7\u00c3" + "\2\2\u03de\u03e0\bH\1\2\u03df\u03da\3\2\2\2\u03df\u03dd\3\2\2\2\u03e0"
                    + "\u008f\3\2\2\2\u03e1\u03ef\7\u00d6\2\2\u03e2\u03e3\5\u010e\u0088\2\u03e3" + "\u03e4\7\24\2\2\u03e4\u03e5\7\u00c0\2\2\u03e5\u03e6\5\u009eP\2\u03e6\u03e7"
                    + "\7\24\2\2\u03e7\u03e8\7\u00c0\2\2\u03e8\u03e9\5\u009eP\2\u03e9\u03ea\b" + "I\1\2\u03ea\u03f0\3\2\2\2\u03eb\u03ec\7\u00c0\2\2\u03ec\u03ed\5\u009e"
                    + "P\2\u03ed\u03ee\bI\1\2\u03ee\u03f0\3\2\2\2\u03ef\u03e2\3\2\2\2\u03ef\u03eb" + "\3\2\2\2\u03f0\u0091\3\2\2\2\u03f1\u03f2\7\u00b4\2\2\u03f2\u03f3\5\u010e"
                    + "\u0088\2\u03f3\u03f4\7\24\2\2\u03f4\u03f5\7\u00c0\2\2\u03f5\u03f6\5\u009e" + "P\2\u03f6\u03fe\7@\2\2\u03f7\u03f8\5\u010e\u0088\2\u03f8\u03f9\7\24\2"
                    + "\2\u03f9\u03fa\7\u00c0\2\2\u03fa\u03fb\5\u009eP\2\u03fb\u03fd\3\2\2\2" + "\u03fc\u03f7\3\2\2\2\u03fd\u0400\3\2\2\2\u03fe\u03fc\3\2\2\2\u03fe\u03ff"
                    + "\3\2\2\2\u03ff\u0401\3\2\2\2\u0400\u03fe\3\2\2\2\u0401\u0402\7\"\2\2\u0402" + "\u0093\3\2\2\2\u0403\u0404\7g\2\2\u0404\u0405\5\u010e\u0088\2\u0405\u0406"
                    + "\7\24\2\2\u0406\u0411\7@\2\2\u0407\u0408\7\u00c0\2\2\u0408\u040e\5\u009e" + "P\2\u0409\u040a\7\24\2\2\u040a\u040b\7\u00c0\2\2\u040b\u040d\5\u009eP"
                    + "\2\u040c\u0409\3\2\2\2\u040d\u0410\3\2\2\2\u040e\u040c\3\2\2\2\u040e\u040f" + "\3\2\2\2\u040f\u0412\3\2\2\2\u0410\u040e\3\2\2\2\u0411\u0407\3\2\2\2\u0411"
                    + "\u0412\3\2\2\2\u0412\u0413\3\2\2\2\u0413\u0414\7\"\2\2\u0414\u0095\3\2" + "\2\2\u0415\u0417\7\u00bc\2\2\u0416\u0418\5\u013e\u00a0\2\u0417\u0416\3"
                    + "\2\2\2\u0417\u0418\3\2\2\2\u0418\u041a\3\2\2\2\u0419\u041b\7\u00b8\2\2" + "\u041a\u0419\3\2\2\2\u041a\u041b\3\2\2\2\u041b\u041d\3\2\2\2\u041c\u041e"
                    + "\7G\2\2\u041d\u041c\3\2\2\2\u041d\u041e\3\2\2\2\u041e\u0420\3\2\2\2\u041f" + "\u0421\7\u0080\2\2\u0420\u041f\3\2\2\2\u0420\u0421\3\2\2\2\u0421\u0422"
                    + "\3\2\2\2\u0422\u0423\5\u0136\u009c\2\u0423\u0424\5\u0102\u0082\2\u0424" + "\u0426\5\u0100\u0081\2\u0425\u0427\5r:\2\u0426\u0425\3\2\2\2\u0426\u0427"
                    + "\3\2\2\2\u0427\u0428\3\2\2\2\u0428\u0429\7?\2\2\u0429\u042a\7\u00c0\2" + "\2\u042a\u042b\5\u009eP\2\u042b\u042c\7\u0093\2\2\u042c\u042d\7\u00c0"
                    + "\2\2\u042d\u042e\5\u009eP\2\u042e\u0097\3\2\2\2\u042f\u0431\7\u00bc\2" + "\2\u0430\u0432\5\u013e\u00a0\2\u0431\u0430\3\2\2\2\u0431\u0432\3\2\2\2"
                    + "\u0432\u0434\3\2\2\2\u0433\u0435\7\u00b8\2\2\u0434\u0433\3\2\2\2\u0434" + "\u0435\3\2\2\2\u0435\u0437\3\2\2\2\u0436\u0438\7G\2\2\u0437\u0436\3\2"
                    + "\2\2\u0437\u0438\3\2\2\2\u0438\u043a\3\2\2\2\u0439\u043b\7\u0080\2\2\u043a" + "\u0439\3\2\2\2\u043a\u043b\3\2\2\2\u043b\u043c\3\2\2\2\u043c\u043d\5\u011a"
                    + "\u008e\2\u043d\u043e\5\u0102\u0082\2\u043e\u0440\5\u0100\u0081\2\u043f" + "\u0441\5r:\2\u0440\u043f\3\2\2\2\u0440\u0441\3\2\2\2\u0441\u0442\3\2\2"
                    + "\2\u0442\u0443\7?\2\2\u0443\u0444\7\u00c0\2\2\u0444\u0445\5\u009eP\2\u0445" + "\u0446\7\u0093\2\2\u0446\u0447\7\u00c0\2\2\u0447\u0448\5\u009eP\2\u0448"
                    + "\u0099\3\2\2\2\u0449\u044a\7y\2\2\u044a\u044b\5\u010e\u0088\2\u044b\u009b" + "\3\2\2\2\u044c\u044d\7\u008b\2\2\u044d\u009d\3\2\2\2\u044e\u0452\5x=\2"
                    + "\u044f\u0450\7\u00f8\2\2\u0450\u0452\bP\1\2\u0451\u044e\3\2\2\2\u0451" + "\u044f\3\2\2\2\u0452\u009f\3\2\2\2\u0453\u0454\5\u00a2R\2\u0454\u0455"
                    + "\bQ\1\2\u0455\u0478\3\2\2\2\u0456\u0457\5\u00a4S\2\u0457\u0458\bQ\1\2" + "\u0458\u0478\3\2\2\2\u0459\u045a\5\u00a8U\2\u045a\u045b\bQ\1\2\u045b\u0478"
                    + "\3\2\2\2\u045c\u045d\5\u00aaV\2\u045d\u045e\bQ\1\2\u045e\u0478\3\2\2\2" + "\u045f\u0460\5\u00acW\2\u0460\u0461\bQ\1\2\u0461\u0478\3\2\2\2\u0462\u0463"
                    + "\5\u00aeX\2\u0463\u0464\bQ\1\2\u0464\u0478\3\2\2\2\u0465\u0466\5\u00b0" + "Y\2\u0466\u0467\bQ\1\2\u0467\u0478\3\2\2\2\u0468\u0469\5\u00b2Z\2\u0469"
                    + "\u046a\bQ\1\2\u046a\u0478\3\2\2\2\u046b\u046c\5\u00b4[\2\u046c\u046d\b" + "Q\1\2\u046d\u0478\3\2\2\2\u046e\u046f\5\u00b6\\\2\u046f\u0470\bQ\1\2\u0470"
                    + "\u0478\3\2\2\2\u0471\u0472\5\u00b8]\2\u0472\u0473\bQ\1\2\u0473\u0478\3" + "\2\2\2\u0474\u0475\5\u00ba^\2\u0475\u0476\bQ\1\2\u0476\u0478\3\2\2\2\u0477"
                    + "\u0453\3\2\2\2\u0477\u0456\3\2\2\2\u0477\u0459\3\2\2\2\u0477\u045c\3\2" + "\2\2\u0477\u045f\3\2\2\2\u0477\u0462\3\2\2\2\u0477\u0465\3\2\2\2\u0477"
                    + "\u0468\3\2\2\2\u0477\u046b\3\2\2\2\u0477\u046e\3\2\2\2\u0477\u0471\3\2" + "\2\2\u0477\u0474\3\2\2\2\u0478\u00a1\3\2\2\2\u0479\u047b\7\u00e3\2\2\u047a"
                    + "\u047c\7\\\2\2\u047b\u047a\3\2\2\2\u047b\u047c\3\2\2\2\u047c\u047e\3\2" + "\2\2\u047d\u047f\7\21\2\2\u047e\u047d\3\2\2\2\u047e\u047f\3\2\2\2\u047f"
                    + "\u0480\3\2\2\2\u0480\u0481\5\u011e\u0090\2\u0481\u0482\5\20\t\2\u0482" + "\u0483\7\24\2\2\u0483\u0484\5\20\t\2\u0484\u0485\bR\1\2\u0485\u00a3\3"
                    + "\2\2\2\u0486\u048a\7\u0088\2\2\u0487\u0489\5\u00a6T\2\u0488\u0487\3\2" + "\2\2\u0489\u048c\3\2\2\2\u048a\u0488\3\2\2\2\u048a\u048b\3\2\2\2\u048b"
                    + "\u048d\3\2\2\2\u048c\u048a\3\2\2\2\u048d\u048e\5\u011e\u0090\2\u048e\u048f" + "\5\20\t\2\u048f\u0490\7\24\2\2\u0490\u0491\5\20\t\2\u0491\u0492\bS\1\2"
                    + "\u0492\u00a5\3\2\2\2\u0493\u0494\t\n\2\2\u0494\u00a7\3\2\2\2\u0495\u0497" + "\7\u009e\2\2\u0496\u0498\7\\\2\2\u0497\u0496\3\2\2\2\u0497\u0498\3\2\2"
                    + "\2\u0498\u049a\3\2\2\2\u0499\u049b\7\21\2\2\u049a\u0499\3\2\2\2\u049a" + "\u049b\3\2\2\2\u049b\u049c\3\2\2\2\u049c\u049d\5\u011e\u0090\2\u049d\u049e"
                    + "\5\20\t\2\u049e\u049f\7\24\2\2\u049f\u04a0\5\20\t\2\u04a0\u04a1\bU\1\2" + "\u04a1\u00a9\3\2\2\2\u04a2\u04a6\7\20\2\2\u04a3\u04a5\5\u00a6T\2\u04a4"
                    + "\u04a3\3\2\2\2\u04a5\u04a8\3\2\2\2\u04a6\u04a4\3\2\2\2\u04a6\u04a7\3\2" + "\2\2\u04a7\u04a9\3\2\2\2\u04a8\u04a6\3\2\2\2\u04a9\u04aa\5\u011e\u0090"
                    + "\2\u04aa\u04ab\5\20\t\2\u04ab\u04ac\7\24\2\2\u04ac\u04ad\5\20\t\2\u04ad" + "\u04ae\bV\1\2\u04ae\u00ab\3\2\2\2\u04af\u04b1\7 \2\2\u04b0\u04b2\7\\\2"
                    + "\2\u04b1\u04b0\3\2\2\2\u04b1\u04b2\3\2\2\2\u04b2\u04b4\3\2\2\2\u04b3\u04b5" + "\7\21\2\2\u04b4\u04b3\3\2\2\2\u04b4\u04b5\3\2\2\2\u04b5\u04b6\3\2\2\2"
                    + "\u04b6\u04b7\5\u011e\u0090\2\u04b7\u04b8\5\20\t\2\u04b8\u04b9\7\24\2\2" + "\u04b9\u04ba\5\20\t\2\u04ba\u04bb\bW\1\2\u04bb\u00ad\3\2\2\2\u04bc\u04c0"
                    + "\7\u0098\2\2\u04bd\u04bf\5\u00a6T\2\u04be\u04bd\3\2\2\2\u04bf\u04c2\3" + "\2\2\2\u04c0\u04be\3\2\2\2\u04c0\u04c1\3\2\2\2\u04c1\u04c3\3\2\2\2\u04c2"
                    + "\u04c0\3\2\2\2\u04c3\u04c4\5\u011e\u0090\2\u04c4\u04c5\5\20\t\2\u04c5" + "\u04c6\7\24\2\2\u04c6\u04c7\5\20\t\2\u04c7\u04c8\bX\1\2\u04c8\u00af\3"
                    + "\2\2\2\u04c9\u04cb\7\u00a1\2\2\u04ca\u04cc\7\32\2\2\u04cb\u04ca\3\2\2" + "\2\u04cb\u04cc\3\2\2\2\u04cc\u04cd\3\2\2\2\u04cd\u04ce\5\u011e\u0090\2"
                    + "\u04ce\u04cf\5\20\t\2\u04cf\u04d0\7\24\2\2\u04d0\u04d1\5\20\t\2\u04d1" + "\u04d2\bY\1\2\u04d2\u00b1\3\2\2\2\u04d3\u04d5\7\6\2\2\u04d4\u04d6\7\32"
                    + "\2\2\u04d5\u04d4\3\2\2\2\u04d5\u04d6\3\2\2\2\u04d6\u04d7\3\2\2\2\u04d7" + "\u04d8\5\u011e\u0090\2\u04d8\u04d9\5\20\t\2\u04d9\u04da\7\24\2\2\u04da"
                    + "\u04db\5\20\t\2\u04db\u04dc\bZ\1\2\u04dc\u00b3\3\2\2\2\u04dd\u04e1\7\u008c" + "\2\2\u04de\u04e0\5\u00a6T\2\u04df\u04de\3\2\2\2\u04e0\u04e3\3\2\2\2\u04e1"
                    + "\u04df\3\2\2\2\u04e1\u04e2\3\2\2\2\u04e2\u04e4\3\2\2\2\u04e3\u04e1\3\2" + "\2\2\u04e4\u04e5\5\u011e\u0090\2\u04e5\u04e6\5\20\t\2\u04e6\u04e7\7\24"
                    + "\2\2\u04e7\u04e8\5\20\t\2\u04e8\u04e9\b[\1\2\u04e9\u00b5\3\2\2\2\u04ea" + "\u04eb\7%\2\2\u04eb\u04ec\5\u011e\u0090\2\u04ec\u04ed\5\20\t\2\u04ed\u04ee"
                    + "\7\24\2\2\u04ee\u04ef\5\20\t\2\u04ef\u04f0\b\\\1\2\u04f0\u00b7\3\2\2\2" + "\u04f1\u04f2\7\u0091\2\2\u04f2\u04f3\5\u011e\u0090\2\u04f3\u04f4\5\20"
                    + "\t\2\u04f4\u04f5\7\24\2\2\u04f5\u04f6\5\20\t\2\u04f6\u04f7\b]\1\2\u04f7" + "\u00b9\3\2\2\2\u04f8\u04f9\7\u00dc\2\2\u04f9\u04fa\5\u011e\u0090\2\u04fa"
                    + "\u04fb\5\20\t\2\u04fb\u04fc\7\24\2\2\u04fc\u04fd\5\20\t\2\u04fd\u04fe" + "\b^\1\2\u04fe\u00bb\3\2\2\2\u04ff\u0500\5\u00be`\2\u0500\u0501\b_\1\2"
                    + "\u0501\u0512\3\2\2\2\u0502\u0503\5\u00c0a\2\u0503\u0504\b_\1\2\u0504\u0512" + "\3\2\2\2\u0505\u0506\5\u00c2b\2\u0506\u0507\b_\1\2\u0507\u0512\3\2\2\2"
                    + "\u0508\u0509\5\u00c4c\2\u0509\u050a\b_\1\2\u050a\u0512\3\2\2\2\u050b\u050c" + "\5\u00c6d\2\u050c\u050d\b_\1\2\u050d\u0512\3\2\2\2\u050e\u050f\5\u00c8"
                    + "e\2\u050f\u0510\b_\1\2\u0510\u0512\3\2\2\2\u0511\u04ff\3\2\2\2\u0511\u0502" + "\3\2\2\2\u0511\u0505\3\2\2\2\u0511\u0508\3\2\2\2\u0511\u050b\3\2\2\2\u0511"
                    + "\u050e\3\2\2\2\u0512\u00bd\3\2\2\2\u0513\u0515\7\u00b1\2\2\u0514\u0516" + "\7\\\2\2\u0515\u0514\3\2\2\2\u0515\u0516\3\2\2\2\u0516\u0518\3\2\2\2\u0517"
                    + "\u0519\7\21\2\2\u0518\u0517\3\2\2\2\u0518\u0519\3\2\2\2\u0519\u051a\3" + "\2\2\2\u051a\u051b\5\u011e\u0090\2\u051b\u051c\5\20\t\2\u051c\u051d\7"
                    + "\24\2\2\u051d\u051e\5\20\t\2\u051e\u051f\b`\1\2\u051f\u00bf\3\2\2\2\u0520" + "\u0522\7\u0082\2\2\u0521\u0523\7\32\2\2\u0522\u0521\3\2\2\2\u0522\u0523"
                    + "\3\2\2\2\u0523\u0524\3\2\2\2\u0524\u0525\5\u011e\u0090\2\u0525\u0526\5" + "\20\t\2\u0526\u0527\7\24\2\2\u0527\u0528\5\20\t\2\u0528\u0529\ba\1\2\u0529"
                    + "\u00c1\3\2\2\2\u052a\u052c\7m\2\2\u052b\u052d\7\32\2\2\u052c\u052b\3\2" + "\2\2\u052c\u052d\3\2\2\2\u052d\u052e\3\2\2\2\u052e\u052f\5\u011e\u0090"
                    + "\2\u052f\u0530\5\20\t\2\u0530\u0531\7\24\2\2\u0531\u0532\5\20\t\2\u0532" + "\u0533\bb\1\2\u0533\u00c3\3\2\2\2\u0534\u0535\7I\2\2\u0535\u0536\5\u011e"
                    + "\u0090\2\u0536\u0537\5\20\t\2\u0537\u0538\7\24\2\2\u0538\u0539\5\20\t" + "\2\u0539\u053a\bc\1\2\u053a\u00c5\3\2\2\2\u053b\u053c\7\u0089\2\2\u053c"
                    + "\u053d\5\u011e\u0090\2\u053d\u053e\5\20\t\2\u053e\u053f\7\24\2\2\u053f" + "\u0540\5\20\t\2\u0540\u0541\bd\1\2\u0541\u00c7\3\2\2\2\u0542\u0543\7E"
                    + "\2\2\u0543\u0544\5\u011e\u0090\2\u0544\u0545\5\20\t\2\u0545\u0546\7\24" + "\2\2\u0546\u0547\5\20\t\2\u0547\u0548\be\1\2\u0548\u00c9\3\2\2\2\u0549"
                    + "\u054d\5\u00ccg\2\u054a\u054d\5\u00ceh\2\u054b\u054d\5\u00d0i\2\u054c" + "\u0549\3\2\2\2\u054c\u054a\3\2\2\2\u054c\u054b\3\2\2\2\u054d\u00cb\3\2"
                    + "\2\2\u054e\u054f\7\16\2\2\u054f\u0550\5\u010e\u0088\2\u0550\u0551\7\24" + "\2\2\u0551\u0552\5\u010e\u0088\2\u0552\u00cd\3\2\2\2\u0553\u0554\7\u00a8"
                    + "\2\2\u0554\u0555\5\u010e\u0088\2\u0555\u0556\7\24\2\2\u0556\u0557\5\u010e" + "\u0088\2\u0557\u0558\7\24\2\2\u0558\u0559\5\u010e\u0088\2\u0559\u00cf"
                    + "\3\2\2\2\u055a\u055b\78\2\2\u055b\u055c\5\u010e\u0088\2\u055c\u055d\7" + "\24\2\2\u055d\u055e\5\u010e\u0088\2\u055e\u055f\7\24\2\2\u055f\u0560\5"
                    + "\u010e\u0088\2\u0560\u00d1\3\2\2\2\u0561\u0564\5\u00d4k\2\u0562\u0564" + "\5\u00d6l\2\u0563\u0561\3\2\2\2\u0563\u0562\3\2\2\2\u0564\u00d3\3\2\2"
                    + "\2\u0565\u0566\7\u00bf\2\2\u0566\u0569\5\u010e\u0088\2\u0567\u0568\7\24" + "\2\2\u0568\u056a\5*\26\2\u0569\u0567\3\2\2\2\u056a\u056b\3\2\2\2\u056b"
                    + "\u0569\3\2\2\2\u056b\u056c\3\2\2\2\u056c\u00d5\3\2\2\2\u056d\u056e\7\22" + "\2\2\u056e\u056f\5\u010e\u0088\2\u056f\u0570\7\24\2\2\u0570\u0573\5\u010e"
                    + "\u0088\2\u0571\u0572\7\24\2\2\u0572\u0574\5*\26\2\u0573\u0571\3\2\2\2" + "\u0574\u0575\3\2\2\2\u0575\u0573\3\2\2\2\u0575\u0576\3\2\2\2\u0576\u00d7"
                    + "\3\2\2\2\u0577\u057f\5\u00dan\2\u0578\u057f\5\u00dco\2\u0579\u057f\5\u00de" + "p\2\u057a\u057f\5\u00e0q\2\u057b\u057f\5\u00e2r\2\u057c\u057f\5\u00e4"
                    + "s\2\u057d\u057f\5\u00e8u\2\u057e\u0577\3\2\2\2\u057e\u0578\3\2\2\2\u057e" + "\u0579\3\2\2\2\u057e\u057a\3\2\2\2\u057e\u057b\3\2\2\2\u057e\u057c\3\2"
                    + "\2\2\u057e\u057d\3\2\2\2\u057f\u00d9\3\2\2\2\u0580\u0581\7v\2\2\u0581" + "\u0586\5\u011e\u0090\2\u0582\u0583\7\24\2\2\u0583\u0584\5\u010e\u0088"
                    + "\2\u0584\u0585\bn\1\2\u0585\u0587\3\2\2\2\u0586\u0582\3\2\2\2\u0586\u0587" + "\3\2\2\2\u0587\u058c\3\2\2\2\u0588\u0589\7\24\2\2\u0589\u058a\5b\62\2"
                    + "\u058a\u058b\bn\1\2\u058b\u058d\3\2\2\2\u058c\u0588\3\2\2\2\u058c\u058d" + "\3\2\2\2\u058d\u00db\3\2\2\2\u058e\u05b4\7\u00be\2\2\u058f\u0591\7a\2"
                    + "\2\u0590\u058f\3\2\2\2\u0590\u0591\3\2\2\2\u0591\u0592\3\2\2\2\u0592\u0595" + "\5\u011e\u0090\2\u0593\u0594\7\24\2\2\u0594\u0596\5\u011e\u0090\2\u0595"
                    + "\u0593\3\2\2\2\u0595\u0596\3\2\2\2\u0596\u0597\3\2\2\2\u0597\u0598\7\u00f8" + "\2\2\u0598\u059b\bo\1\2\u0599\u059a\7\24\2\2\u059a\u059c\5b\62\2\u059b"
                    + "\u0599\3\2\2\2\u059b\u059c\3\2\2\2\u059c\u05a0\3\2\2\2\u059d\u059e\7\24" + "\2\2\u059e\u059f\7\4\2\2\u059f\u05a1\5\f\7\2\u05a0\u059d\3\2\2\2\u05a0"
                    + "\u05a1\3\2\2\2\u05a1\u05a5\3\2\2\2\u05a2\u05a3\7\24\2\2\u05a3\u05a4\7" + "\u00c2\2\2\u05a4\u05a6\5\f\7\2\u05a5\u05a2\3\2\2\2\u05a5\u05a6\3\2\2\2"
                    + "\u05a6\u05b5\3\2\2\2\u05a7\u05a9\7<\2\2\u05a8\u05aa\7a\2\2\u05a9\u05a8" + "\3\2\2\2\u05a9\u05aa\3\2\2\2\u05aa\u05ab\3\2\2\2\u05ab\u05ac\5\u011e\u0090"
                    + "\2\u05ac\u05ad\7\u00f8\2\2\u05ad\u05af\bo\1\2\u05ae\u05b0\7\u008d\2\2" + "\u05af\u05ae\3\2\2\2\u05af\u05b0\3\2\2\2\u05b0\u05b1\3\2\2\2\u05b1\u05b2"
                    + "\5\u010c\u0087\2\u05b2\u05b3\5b\62\2\u05b3\u05b5\3\2\2\2\u05b4\u0590\3" + "\2\2\2\u05b4\u05a7\3\2\2\2\u05b5\u00dd\3\2\2\2\u05b6\u05e4\7\65\2\2\u05b7"
                    + "\u05b9\7a\2\2\u05b8\u05b7\3\2\2\2\u05b8\u05b9\3\2\2\2\u05b9\u05ba\3\2" + "\2\2\u05ba\u05bf\5\u011e\u0090\2\u05bb\u05bc\7\u00f8\2\2\u05bc\u05c0\b"
                    + "p\1\2\u05bd\u05be\7\u00fd\2\2\u05be\u05c0\bp\1\2\u05bf\u05bb\3\2\2\2\u05bf" + "\u05bd\3\2\2\2\u05c0\u05c1\3\2\2\2\u05c1\u05c2\7\24\2\2\u05c2\u05c3\5"
                    + "\u011e\u0090\2\u05c3\u05c6\7\u00f8\2\2\u05c4\u05c5\7\24\2\2\u05c5\u05c7" + "\5b\62\2\u05c6\u05c4\3\2\2\2\u05c6\u05c7\3\2\2\2\u05c7\u05cb\3\2\2\2\u05c8"
                    + "\u05c9\7\24\2\2\u05c9\u05ca\7\4\2\2\u05ca\u05cc\5\f\7\2\u05cb\u05c8\3" + "\2\2\2\u05cb\u05cc\3\2\2\2\u05cc\u05cd\3\2\2\2\u05cd\u05ce\bp\1\2\u05ce"
                    + "\u05e5\3\2\2\2\u05cf\u05d1\7<\2\2\u05d0\u05d2\7a\2\2\u05d1\u05d0\3\2\2" + "\2\u05d1\u05d2\3\2\2\2\u05d2\u05d3\3\2\2\2\u05d3\u05d8\5\u011e\u0090\2"
                    + "\u05d4\u05d5\7\u00f8\2\2\u05d5\u05d9\bp\1\2\u05d6\u05d7\7\u00fd\2\2\u05d7" + "\u05d9\bp\1\2\u05d8\u05d4\3\2\2\2\u05d8\u05d6\3\2\2\2\u05d9\u05da\3\2"
                    + "\2\2\u05da\u05db\7\24\2\2\u05db\u05dc\5\u011e\u0090\2\u05dc\u05de\7\u00f8" + "\2\2\u05dd\u05df\7\u008d\2\2\u05de\u05dd\3\2\2\2\u05de\u05df\3\2\2\2\u05df"
                    + "\u05e0\3\2\2\2\u05e0\u05e1\5\u010c\u0087\2\u05e1\u05e2\5b\62\2\u05e2\u05e3" + "\bp\1\2\u05e3\u05e5\3\2\2\2\u05e4\u05b8\3\2\2\2\u05e4\u05cf\3\2\2\2\u05e5"
                    + "\u00df\3\2\2\2\u05e6\u05e8\7\u00e5\2\2\u05e7\u05e9\7\u008d\2\2\u05e8\u05e7" + "\3\2\2\2\u05e8\u05e9\3\2\2\2\u05e9\u05ea\3\2\2\2\u05ea\u05eb\5\u010c\u0087"
                    + "\2\u05eb\u00e1\3\2\2\2\u05ec\u05ee\7\63\2\2\u05ed\u05ef\7a\2\2\u05ee\u05ed" + "\3\2\2\2\u05ee\u05ef\3\2\2\2\u05ef\u05f0\3\2\2\2\u05f0\u05f1\5\u010e\u0088"
                    + "\2\u05f1\u05f2\7\24\2\2\u05f2\u05f3\5\u010e\u0088\2\u05f3\u05f4\7\24\2" + "\2\u05f4\u05f6\5\u010e\u0088\2\u05f5\u05f7\7\u008d\2\2\u05f6\u05f5\3\2"
                    + "\2\2\u05f6\u05f7\3\2\2\2\u05f7\u05f8\3\2\2\2\u05f8\u05f9\5\u010c\u0087" + "\2\u05f9\u00e3\3\2\2\2\u05fa\u05fc\7t\2\2\u05fb\u05fd\7a\2\2\u05fc\u05fb"
                    + "\3\2\2\2\u05fc\u05fd\3\2\2\2\u05fd\u05fe\3\2\2\2\u05fe\u05ff\5\u00e6t" + "\2\u05ff\u0600\5\u010e\u0088\2\u0600\u0601\7\24\2\2\u0601\u0603\5\u010e"
                    + "\u0088\2\u0602\u0604\7\u008d\2\2\u0603\u0602\3\2\2\2\u0603\u0604\3\2\2" + "\2\u0604\u0605\3\2\2\2\u0605\u0606\5\u010c\u0087\2\u0606\u00e5\3\2\2\2"
                    + "\u0607\u0608\t\13\2\2\u0608\u00e7\3\2\2\2\u0609\u060b\7\35\2\2\u060a\u060c" + "\7r\2\2\u060b\u060a\3\2\2\2\u060b\u060c\3\2\2\2\u060c\u060d\3\2\2\2\u060d"
                    + "\u0612\5\u010e\u0088\2\u060e\u060f\7\24\2\2\u060f\u0611\5\u010e\u0088" + "\2\u0610\u060e\3\2\2\2\u0611\u0614\3\2\2\2\u0612\u0610\3\2\2\2\u0612\u0613"
                    + "\3\2\2\2\u0613\u00e9\3\2\2\2\u0614\u0612\3\2\2\2\u0615\u0616\5\u00ecw" + "\2\u0616\u0617\5\u011e\u0090\2\u0617\u0618\5\20\t\2\u0618\u0619\7?\2\2"
                    + "\u0619\u061a\5\u011e\u0090\2\u061a\u00eb\3\2\2\2\u061b\u061c\t\f\2\2\u061c" + "\u00ed\3\2\2\2\u061d\u061e\5\u00f0y\2\u061e\u061f\bx\1\2\u061f\u0625\3"
                    + "\2\2\2\u0620\u0625\5\u00f4{\2\u0621\u0625\5\u00fa~\2\u0622\u0625\5\u0106" + "\u0084\2\u0623\u0625\5\u0108\u0085\2\u0624\u061d\3\2\2\2\u0624\u0620\3"
                    + "\2\2\2\u0624\u0621\3\2\2\2\u0624\u0622\3\2\2\2\u0624\u0623\3\2\2\2\u0625" + "\u00ef\3\2\2\2\u0626\u0627\7k\2\2\u0627\u0628\5\u00f2z\2\u0628\u0629\5"
                    + "\u011e\u0090\2\u0629\u062a\5\20\t\2\u062a\u062b\7\24\2\2\u062b\u062c\5" + "\20\t\2\u062c\u062d\by\1\2\u062d\u00f1\3\2\2\2\u062e\u062f\t\r\2\2\u062f"
                    + "\u0630\bz\1\2\u0630\u00f3\3\2\2\2\u0631\u0632\7\u0084\2\2\u0632\u0633" + "\5\u00f6|\2\u0633\u0634\5\u011e\u0090\2\u0634\u0635\5\20\t\2\u0635\u0636"
                    + "\7\24\2\2\u0636\u0637\5\20\t\2\u0637\u00f5\3\2\2\2\u0638\u0639\t\16\2" + "\2\u0639\u00f7\3\2\2\2\u063a\u063b\7{\2\2\u063b\u063c\5\u011e\u0090\2"
                    + "\u063c\u063d\7@\2\2\u063d\u063e\5\20\t\2\u063e\u063f\7\24\2\2\u063f\u0640" + "\5\u009eP\2\u0640\u0641\7\"\2\2\u0641\u064b\3\2\2\2\u0642\u0643\7\24\2"
                    + "\2\u0643\u0644\7@\2\2\u0644\u0645\5\20\t\2\u0645\u0646\7\24\2\2\u0646" + "\u0647\5\u009eP\2\u0647\u0648\7\"\2\2\u0648\u064a\3\2\2\2\u0649\u0642"
                    + "\3\2\2\2\u064a\u064d\3\2\2\2\u064b\u0649\3\2\2\2\u064b\u064c\3\2\2\2\u064c" + "\u00f9\3\2\2\2\u064d\u064b\3\2\2\2\u064e\u064f\7A\2\2\u064f\u0650\5\u010e"
                    + "\u0088\2\u0650\u0651\7\24\2\2\u0651\u0652\5\u010e\u0088\2\u0652\u0653" + "\7\24\2\2\u0653\u0654\5\u010e\u0088\2\u0654\u00fb\3\2\2\2\u0655\u0659"
                    + "\b\177\1\2\u0656\u0658\7\u008a\2\2\u0657\u0656\3\2\2\2\u0657\u0658\3\2" + "\2\2\u0658\u065a\3\2\2\2\u0659\u0657\3\2\2\2\u0659\u065a\3\2\2\2\u065a"
                    + "\u065b\3\2\2\2\u065b\u065d\7\b\2\2\u065c\u065e\5\u013e\u00a0\2\u065d\u065c" + "\3\2\2\2\u065d\u065e\3\2\2\2\u065e\u0660\3\2\2\2\u065f\u0661\5\u0112\u008a"
                    + "\2\u0660\u065f\3\2\2\2\u0660\u0661\3\2\2\2\u0661\u0662\3\2\2\2\u0662\u0663" + "\5\u011a\u008e\2\u0663\u0664\5\u0102\u0082\2\u0664\u0666\5\u0100\u0081"
                    + "\2\u0665\u0667\5r:\2\u0666\u0665\3\2\2\2\u0666\u0667\3\2\2\2\u0667\u0668" + "\3\2\2\2\u0668\u0669\b\177\1\2\u0669\u00fd\3\2\2\2\u066a\u066e\b\u0080"
                    + "\1\2\u066b\u066d\7\u008a\2\2\u066c\u066b\3\2\2\2\u066c\u066d\3\2\2\2\u066d" + "\u066f\3\2\2\2\u066e\u066c\3\2\2\2\u066e\u066f\3\2\2\2\u066f\u0670\3\2"
                    + "\2\2\u0670\u0672\7\b\2\2\u0671\u0673\5\u013e\u00a0\2\u0672\u0671\3\2\2" + "\2\u0672\u0673\3\2\2\2\u0673\u0675\3\2\2\2\u0674\u0676\5\u0112\u008a\2"
                    + "\u0675\u0674\3\2\2\2\u0675\u0676\3\2\2\2\u0676\u0677\3\2\2\2\u0677\u0678" + "\5\u0136\u009c\2\u0678\u0679\5\u0102\u0082\2\u0679\u067b\5\u0100\u0081"
                    + "\2\u067a\u067c\5r:\2\u067b\u067a\3\2\2\2\u067b\u067c\3\2\2\2\u067c\u067d" + "\3\2\2\2\u067d\u067e\b\u0080\1\2\u067e\u00ff\3\2\2\2\u067f\u0680\b\u0081"
                    + "\1\2\u0680\u068c\7]\2\2\u0681\u0682\5\u0116\u008c\2\u0682\u0689\b\u0081" + "\1\2\u0683\u0684\7\24\2\2\u0684\u0685\5\u0116\u008c\2\u0685\u0686\b\u0081"
                    + "\1\2\u0686\u0688\3\2\2\2\u0687\u0683\3\2\2\2\u0688\u068b\3\2\2\2\u0689" + "\u0687\3\2\2\2\u0689\u068a\3\2\2\2\u068a\u068d\3\2\2\2\u068b\u0689\3\2"
                    + "\2\2\u068c\u0681\3\2\2\2\u068c\u068d\3\2\2\2\u068d\u068e\3\2\2\2\u068e" + "\u068f\7H\2\2\u068f\u0690\b\u0081\1\2\u0690\u0101\3\2\2\2\u0691\u0692"
                    + "\5\20\t\2\u0692\u0693\b\u0082\1\2\u0693\u0696\3\2\2\2\u0694\u0696\5\u0104" + "\u0083\2\u0695\u0691\3\2\2\2\u0695\u0694\3\2\2\2\u0696\u0103\3\2\2\2\u0697"
                    + "\u0699\7\26\2\2\u0698\u069a\7\u009c\2\2\u0699\u0698\3\2\2\2\u0699\u069a" + "\3\2\2\2\u069a\u069c\3\2\2\2\u069b\u069d\7\u00d4\2\2\u069c\u069b\3\2\2"
                    + "\2\u069c\u069d\3\2\2\2\u069d\u069f\3\2\2\2\u069e\u06a0\7\u00ad\2\2\u069f" + "\u069e\3\2\2\2\u069f\u06a0\3\2\2\2\u06a0\u06a1\3\2\2\2\u06a1\u06a2\7\u0101"
                    + "\2\2\u06a2\u06a3\7\24\2\2\u06a3\u06a4\7\u0101\2\2\u06a4\u0105\3\2\2\2" + "\u06a5\u06a6\7&\2\2\u06a6\u06a7\5\u010e\u0088\2\u06a7\u06a8\7\24\2\2\u06a8"
                    + "\u06a9\5\u011e\u0090\2\u06a9\u0107\3\2\2\2\u06aa\u06ab\7,\2\2\u06ab\u06ac" + "\5\u011e\u0090\2\u06ac\u06ad\7.\2\2\u06ad\u06b0\5\u010e\u0088\2\u06ae"
                    + "\u06b1\5\u010a\u0086\2\u06af\u06b1\7\u00b0\2\2\u06b0\u06ae\3\2\2\2\u06b0" + "\u06af\3\2\2\2\u06b1\u06b5\3\2\2\2\u06b2\u06b4\5\u010a\u0086\2\u06b3\u06b2"
                    + "\3\2\2\2\u06b4\u06b7\3\2\2\2\u06b5\u06b3\3\2\2\2\u06b5\u06b6\3\2\2\2\u06b6" + "\u0109\3\2\2\2\u06b7\u06b5\3\2\2\2\u06b8\u06b9\7\u00db\2\2\u06b9\u06bf"
                    + "\5\u010e\u0088\2\u06ba\u06bb\7\5\2\2\u06bb\u06bc\5\u0132\u009a\2\u06bc" + "\u06bd\5J&\2\u06bd\u06bf\3\2\2\2\u06be\u06b8\3\2\2\2\u06be\u06ba\3\2\2"
                    + "\2\u06bf\u010b\3\2\2\2\u06c0\u06c1\t\17\2\2\u06c1\u010d\3\2\2\2\u06c2" + "\u06c3\5\u011e\u0090\2\u06c3\u06c4\5\20\t\2\u06c4\u06c5\b\u0088\1\2\u06c5"
                    + "\u010f\3\2\2\2\u06c6\u06c8\5\u011e\u0090\2\u06c7\u06c9\5\u0112\u008a\2" + "\u06c8\u06c7\3\2\2\2\u06c8\u06c9\3\2\2\2\u06c9\u0111\3\2\2\2\u06ca\u06cc"
                    + "\5\u0114\u008b\2\u06cb\u06ca\3\2\2\2\u06cc\u06cd\3\2\2\2\u06cd\u06cb\3" + "\2\2\2\u06cd\u06ce\3\2\2\2\u06ce\u0113\3\2\2\2\u06cf\u06de\7\u00b8\2\2"
                    + "\u06d0\u06de\7G\2\2\u06d1\u06de\7\u0080\2\2\u06d2\u06d5\7#\2\2\u06d3\u06d4" + "\7\u00e8\2\2\u06d4\u06d6\7\u00fd\2\2\u06d5\u06d3\3\2\2\2\u06d5\u06d6\3"
                    + "\2\2\2\u06d6\u06de\3\2\2\2\u06d7\u06de\7\'\2\2\u06d8\u06de\7d\2\2\u06d9" + "\u06de\7\u009f\2\2\u06da\u06de\7(\2\2\u06db\u06de\7\u00ef\2\2\u06dc\u06de"
                    + "\7M\2\2\u06dd\u06cf\3\2\2\2\u06dd\u06d0\3\2\2\2\u06dd\u06d1\3\2\2\2\u06dd" + "\u06d2\3\2\2\2\u06dd\u06d7\3\2\2\2\u06dd\u06d8\3\2\2\2\u06dd\u06d9\3\2"
                    + "\2\2\u06dd\u06da\3\2\2\2\u06dd\u06db\3\2\2\2\u06dd\u06dc\3\2\2\2\u06de" + "\u0115\3\2\2\2\u06df\u06e0\5\u0110\u0089\2\u06e0\u06e1\5\20\t\2\u06e1"
                    + "\u06e2\b\u008c\1\2\u06e2\u0117\3\2\2\2\u06e3\u06e4\5\u0110\u0089\2\u06e4" + "\u06e5\5\u0084C\2\u06e5\u06e6\b\u008d\1\2\u06e6\u0119\3\2\2\2\u06e7\u06e9"
                    + "\5\u0136\u009c\2\u06e8\u06ea\5\u0120\u0091\2\u06e9\u06e8\3\2\2\2\u06ea" + "\u06eb\3\2\2\2\u06eb\u06e9\3\2\2\2\u06eb\u06ec\3\2\2\2\u06ec\u06fb\3\2"
                    + "\2\2\u06ed\u06f1\5\u0124\u0093\2\u06ee\u06f0\5\u011c\u008f\2\u06ef\u06ee" + "\3\2\2\2\u06f0\u06f3\3\2\2\2\u06f1\u06ef\3\2\2\2\u06f1\u06f2\3\2\2\2\u06f2"
                    + "\u06f7\3\2\2\2\u06f3\u06f1\3\2\2\2\u06f4\u06f6\5\u0120\u0091\2\u06f5\u06f4" + "\3\2\2\2\u06f6\u06f9\3\2\2\2\u06f7\u06f5\3\2\2\2\u06f7\u06f8\3\2\2\2\u06f8"
                    + "\u06fb\3\2\2\2\u06f9\u06f7\3\2\2\2\u06fa\u06e7\3\2\2\2\u06fa\u06ed\3\2" + "\2\2\u06fb\u011b\3\2\2\2\u06fc\u06fe\5^\60\2\u06fd\u06fc\3\2\2\2\u06fd"
                    + "\u06fe\3\2\2\2\u06fe\u06ff\3\2\2\2\u06ff\u0700\79\2\2\u0700\u011d\3\2" + "\2\2\u0701\u0705\5\u0122\u0092\2\u0702\u0704\5\u011c\u008f\2\u0703\u0702"
                    + "\3\2\2\2\u0704\u0707\3\2\2\2\u0705\u0703\3\2\2\2\u0705\u0706\3\2\2\2\u0706" + "\u070b\3\2\2\2\u0707\u0705\3\2\2\2\u0708\u070a\5\u0120\u0091\2\u0709\u0708"
                    + "\3\2\2\2\u070a\u070d\3\2\2\2\u070b\u0709\3\2\2\2\u070b\u070c\3\2\2\2\u070c" + "\u011f\3\2\2\2\u070d\u070b\3\2\2\2\u070e\u071e\7]\2\2\u070f\u0714\5\u0110"
                    + "\u0089\2\u0710\u0711\7\24\2\2\u0711\u0713\5\u0110\u0089\2\u0712\u0710" + "\3\2\2\2\u0713\u0716\3\2\2\2\u0714\u0712\3\2\2\2\u0714\u0715\3\2\2\2\u0715"
                    + "\u0719\3\2\2\2\u0716\u0714\3\2\2\2\u0717\u0718\7\24\2\2\u0718\u071a\7" + "\u00e4\2\2\u0719\u0717\3\2\2\2\u0719\u071a\3\2\2\2\u071a\u071c\3\2\2\2"
                    + "\u071b\u070f\3\2\2\2\u071b\u071c\3\2\2\2\u071c\u071f\3\2\2\2\u071d\u071f" + "\7\u00e4\2\2\u071e\u071b\3\2\2\2\u071e\u071d\3\2\2\2\u071f\u0720\3\2\2"
                    + "\2\u0720\u0724\7H\2\2\u0721\u0723\5\u011c\u008f\2\u0722\u0721\3\2\2\2" + "\u0723\u0726\3\2\2\2\u0724\u0722\3\2\2\2\u0724\u0725\3\2\2\2\u0725\u0121"
                    + "\3\2\2\2\u0726\u0724\3\2\2\2\u0727\u0731\5\u012a\u0096\2\u0728\u0731\7" + "\u0107\2\2\u0729\u0731\5\u0130\u0099\2\u072a\u0731\5\u0132\u009a\2\u072b"
                    + "\u0731\5\u0134\u009b\2\u072c\u0731\5\u0136\u009c\2\u072d\u0731\5\u0138" + "\u009d\2\u072e\u0731\5\u012e\u0098\2\u072f\u0731\5\u012c\u0097\2\u0730"
                    + "\u0727\3\2\2\2\u0730\u0728\3\2\2\2\u0730\u0729\3\2\2\2\u0730\u072a\3\2" + "\2\2\u0730\u072b\3\2\2\2\u0730\u072c\3\2\2\2\u0730\u072d\3\2\2\2\u0730"
                    + "\u072e\3\2\2\2\u0730\u072f\3\2\2\2\u0731\u0737\3\2\2\2\u0732\u0735\5\u0126" + "\u0094\2\u0733\u0735\7\u00f8\2\2\u0734\u0732\3\2\2\2\u0734\u0733\3\2\2"
                    + "\2\u0735\u0737\3\2\2\2\u0736\u0730\3\2\2\2\u0736\u0734\3\2\2\2\u0737\u0123" + "\3\2\2\2\u0738\u0741\5\u012a\u0096\2\u0739\u0741\7\u0107\2\2\u073a\u0741"
                    + "\5\u0130\u0099\2\u073b\u0741\5\u0132\u009a\2\u073c\u0741\5\u0134\u009b" + "\2\u073d\u0741\5\u0138\u009d\2\u073e\u0741\5\u012e\u0098\2\u073f\u0741"
                    + "\5\u012c\u0097\2\u0740\u0738\3\2\2\2\u0740\u0739\3\2\2\2\u0740\u073a\3" + "\2\2\2\u0740\u073b\3\2\2\2\u0740\u073c\3\2\2\2\u0740\u073d\3\2\2\2\u0740"
                    + "\u073e\3\2\2\2\u0740\u073f\3\2\2\2\u0741\u0747\3\2\2\2\u0742\u0745\5\u0126" + "\u0094\2\u0743\u0745\7\u00f8\2\2\u0744\u0742\3\2\2\2\u0744\u0743\3\2\2"
                    + "\2\u0745\u0747\3\2\2\2\u0746\u0740\3\2\2\2\u0746\u0744\3\2\2\2\u0747\u0125" + "\3\2\2\2\u0748\u0749\5\u0086D\2\u0749\u074a\7f\2\2\u074a\u074b\5\u011a"
                    + "\u008e\2\u074b\u0127\3\2\2\2\u074c\u074d\t\20\2\2\u074d\u0129\3\2\2\2" + "\u074e\u074f\7\u00f6\2\2\u074f\u012b\3\2\2\2\u0750\u0751\7\36\2\2\u0751"
                    + "\u012d\3\2\2\2\u0752\u075b\7X\2\2\u0753\u0758\5\u011e\u0090\2\u0754\u0755" + "\7\24\2\2\u0755\u0757\5\u011e\u0090\2\u0756\u0754\3\2\2\2\u0757\u075a"
                    + "\3\2\2\2\u0758\u0756\3\2\2\2\u0758\u0759\3\2\2\2\u0759\u075c\3\2\2\2\u075a" + "\u0758\3\2\2\2\u075b\u0753\3\2\2\2\u075b\u075c\3\2\2\2\u075c\u075d\3\2"
                    + "\2\2\u075d\u076d\7\60\2\2\u075e\u075f\7\37\2\2\u075f\u0768\7X\2\2\u0760" + "\u0765\5\u011e\u0090\2\u0761\u0762\7\24\2\2\u0762\u0764\5\u011e\u0090"
                    + "\2\u0763\u0761\3\2\2\2\u0764\u0767\3\2\2\2\u0765\u0763\3\2\2\2\u0765\u0766" + "\3\2\2\2\u0766\u0769\3\2\2\2\u0767\u0765\3\2\2\2\u0768\u0760\3\2\2\2\u0768"
                    + "\u0769\3\2\2\2\u0769\u076a\3\2\2\2\u076a\u076b\7\60\2\2\u076b\u076d\7" + "\u00ea\2\2\u076c\u0752\3\2\2\2\u076c\u075e\3\2\2\2\u076d\u012f\3\2\2\2"
                    + "\u076e\u076f\7\37\2\2\u076f\u0770\7\u00fd\2\2\u0770\u0771\7\u0087\2\2" + "\u0771\u0772\5\u011e\u0090\2\u0772\u0773\7\u00ea\2\2\u0773\u0131\3\2\2"
                    + "\2\u0774\u0775\7@\2\2\u0775\u0776\7\u00fd\2\2\u0776\u0777\7\u0087\2\2" + "\u0777\u0778\5\u011e\u0090\2\u0778\u0779\7\"\2\2\u0779\u0133\3\2\2\2\u077a"
                    + "\u077b\7U\2\2\u077b\u0135\3\2\2\2\u077c\u077d\7\u00c3\2\2\u077d\u0137" + "\3\2\2\2\u077e\u077f\7|\2\2\u077f\u0139\3\2\2\2\u0780\u0781\t\21\2\2\u0781"
                    + "\u013b\3\2\2\2\u0782\u0783\t\22\2\2\u0783\u013d\3\2\2\2\u0784\u0788\t" + "\23\2\2\u0785\u0786\7\u00d3\2\2\u0786\u0788\7\u00fd\2\2\u0787\u0784\3"
                    + "\2\2\2\u0787\u0785\3\2\2\2\u0788\u013f\3\2\2\2\u00ca\u0143\u014c\u0155" + "\u015a\u0160\u0165\u0167\u0169\u0170\u0179\u017d\u0187\u018d\u0194\u0199"
                    + "\u019e\u01a6\u01b1\u01b6\u01bb\u01be\u01c6\u01d3\u01d6\u01d9\u01dc\u01e1" + "\u01e5\u01e9\u01fa\u0206\u0212\u021d\u022f\u0258\u0265\u026b\u026e\u0272"
                    + "\u0275\u028a\u0290\u0294\u0298\u029e\u02a7\u02b9\u02c2\u02c5\u02cc\u02e8" + "\u02f4\u02fd\u0300\u0303\u0306\u0309\u0310\u0314\u0317\u031a\u031d\u0320"
                    + "\u032f\u0334\u0336\u0339\u033e\u0343\u034b\u034d\u034f\u0351\u035e\u0366" + "\u036e\u0379\u0386\u038b\u03a7\u03ab\u03b1\u03b6\u03bc\u03c0\u03ce\u03d3"
                    + "\u03df\u03ef\u03fe\u040e\u0411\u0417\u041a\u041d\u0420\u0426\u0431\u0434" + "\u0437\u043a\u0440\u0451\u0477\u047b\u047e\u048a\u0497\u049a\u04a6\u04b1"
                    + "\u04b4\u04c0\u04cb\u04d5\u04e1\u0511\u0515\u0518\u0522\u052c\u054c\u0563" + "\u056b\u0575\u057e\u0586\u058c\u0590\u0595\u059b\u05a0\u05a5\u05a9\u05af"
                    + "\u05b4\u05b8\u05bf\u05c6\u05cb\u05d1\u05d8\u05de\u05e4\u05e8\u05ee\u05f6" + "\u05fc\u0603\u060b\u0612\u0624\u064b\u0657\u0659\u065d\u0660\u0666\u066c"
                    + "\u066e\u0672\u0675\u067b\u0689\u068c\u0695\u0699\u069c\u069f\u06b0\u06b5" + "\u06be\u06c8\u06cd\u06d5\u06dd\u06eb\u06f1\u06f7\u06fa\u06fd\u0705\u070b"
                    + "\u0714\u0719\u071b\u071e\u0724\u0730\u0734\u0736\u0740\u0744\u0746\u0758" + "\u075b\u0765\u0768\u076c\u0787";
    public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}