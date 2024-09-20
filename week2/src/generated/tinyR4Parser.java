// Generated from C:/Users/user/IdeaProjects/CP-2024/week2/src/tinyR4.g4 by ANTLR 4.13.1
package generated;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class tinyR4Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, FUNC=19, U32=20, IF=21, ELSE=22, RETURN=23, LET=24, MUT=25, 
		OR=26, AND=27, LE=28, GE=29, EQ=30, NE=31, RARROW=32, ID=33, LITERAL=34, 
		LIT_INT=35, LIT_STR=36, DecimalConstant=37, OctalConstant=38, HexadecimalConstant=39, 
		NilConstant=40, WildCardConstant=41, WS=42;
	public static final int
		RULE_program = 0, RULE_decl = 1, RULE_fun_decl = 2, RULE_params = 3, RULE_param = 4, 
		RULE_type_spec = 5, RULE_ret_type_spec = 6, RULE_compound_stmt = 7, RULE_local_decl = 8, 
		RULE_dec_spec = 9, RULE_val = 10, RULE_stmt = 11, RULE_expr_stmt = 12, 
		RULE_expr = 13, RULE_additive_expr = 14, RULE_multiplicative_expr = 15, 
		RULE_unary_expr = 16, RULE_factor = 17, RULE_relative_expr = 18, RULE_comparative_expr = 19, 
		RULE_if_stmt = 20, RULE_return_stmt = 21, RULE_args = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "decl", "fun_decl", "params", "param", "type_spec", "ret_type_spec", 
			"compound_stmt", "local_decl", "dec_spec", "val", "stmt", "expr_stmt", 
			"expr", "additive_expr", "multiplicative_expr", "unary_expr", "factor", 
			"relative_expr", "comparative_expr", "if_stmt", "return_stmt", "args"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "','", "':'", "'{'", "'}'", "'='", "';'", "'+'", 
			"'-'", "'*'", "'/'", "'%'", "'--'", "'++'", "'!'", "'<'", "'>'", "'fn'", 
			"'u32'", "'if'", "'else'", "'return'", "'let'", "'mut'", "'||'", "'&&'", 
			"'<='", "'>='", "'=='", "'!='", "'->'", null, null, null, null, null, 
			null, null, null, "'_'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "FUNC", "U32", "IF", "ELSE", 
			"RETURN", "LET", "MUT", "OR", "AND", "LE", "GE", "EQ", "NE", "RARROW", 
			"ID", "LITERAL", "LIT_INT", "LIT_STR", "DecimalConstant", "OctalConstant", 
			"HexadecimalConstant", "NilConstant", "WildCardConstant", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "tinyR4.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public tinyR4Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tinyR4Visitor ) return ((tinyR4Visitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(46);
				decl();
				}
				}
				setState(49); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==FUNC );
			System.out.println("202200000 Rule 0");
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclContext extends ParserRuleContext {
		public Fun_declContext fun_decl() {
			return getRuleContext(Fun_declContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).exitDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tinyR4Visitor ) return ((tinyR4Visitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			fun_decl();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Fun_declContext extends ParserRuleContext {
		public TerminalNode FUNC() { return getToken(tinyR4Parser.FUNC, 0); }
		public TerminalNode ID() { return getToken(tinyR4Parser.ID, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public Ret_type_specContext ret_type_spec() {
			return getRuleContext(Ret_type_specContext.class,0);
		}
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public Fun_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fun_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).enterFun_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).exitFun_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tinyR4Visitor ) return ((tinyR4Visitor<? extends T>)visitor).visitFun_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fun_declContext fun_decl() throws RecognitionException {
		Fun_declContext _localctx = new Fun_declContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_fun_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(FUNC);
			setState(56);
			match(ID);
			setState(57);
			match(T__0);
			setState(58);
			params();
			setState(59);
			match(T__1);
			setState(60);
			ret_type_spec();
			setState(61);
			compound_stmt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamsContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).exitParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tinyR4Visitor ) return ((tinyR4Visitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_params);
		int _la;
		try {
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				param();
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(65);
					match(T__2);
					setState(66);
					param();
					}
					}
					setState(71);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(tinyR4Parser.ID, 0); }
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tinyR4Visitor ) return ((tinyR4Visitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(ID);
			setState(75);
			match(T__3);
			setState(76);
			type_spec();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Type_specContext extends ParserRuleContext {
		public TerminalNode U32() { return getToken(tinyR4Parser.U32, 0); }
		public Type_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_spec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).enterType_spec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).exitType_spec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tinyR4Visitor ) return ((tinyR4Visitor<? extends T>)visitor).visitType_spec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_specContext type_spec() throws RecognitionException {
		Type_specContext _localctx = new Type_specContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_type_spec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(U32);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Ret_type_specContext extends ParserRuleContext {
		public TerminalNode RARROW() { return getToken(tinyR4Parser.RARROW, 0); }
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public Ret_type_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ret_type_spec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).enterRet_type_spec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).exitRet_type_spec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tinyR4Visitor ) return ((tinyR4Visitor<? extends T>)visitor).visitRet_type_spec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ret_type_specContext ret_type_spec() throws RecognitionException {
		Ret_type_specContext _localctx = new Ret_type_specContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ret_type_spec);
		try {
			setState(83);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case RARROW:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				match(RARROW);
				setState(82);
				type_spec();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Compound_stmtContext extends ParserRuleContext {
		public List<Local_declContext> local_decl() {
			return getRuleContexts(Local_declContext.class);
		}
		public Local_declContext local_decl(int i) {
			return getRuleContext(Local_declContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public Compound_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).enterCompound_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).exitCompound_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tinyR4Visitor ) return ((tinyR4Visitor<? extends T>)visitor).visitCompound_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Compound_stmtContext compound_stmt() throws RecognitionException {
		Compound_stmtContext _localctx = new Compound_stmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_compound_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(T__4);
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LET) {
				{
				{
				setState(86);
				local_decl();
				}
				}
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 25780405794L) != 0)) {
				{
				{
				setState(92);
				stmt();
				}
				}
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(98);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Local_declContext extends ParserRuleContext {
		public Dec_specContext dec_spec() {
			return getRuleContext(Dec_specContext.class,0);
		}
		public TerminalNode ID() { return getToken(tinyR4Parser.ID, 0); }
		public ValContext val() {
			return getRuleContext(ValContext.class,0);
		}
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public Local_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_local_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).enterLocal_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).exitLocal_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tinyR4Visitor ) return ((tinyR4Visitor<? extends T>)visitor).visitLocal_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Local_declContext local_decl() throws RecognitionException {
		Local_declContext _localctx = new Local_declContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_local_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			dec_spec();
			setState(101);
			match(ID);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(102);
				match(T__3);
				setState(103);
				type_spec();
				}
			}

			{
			setState(106);
			match(T__6);
			setState(107);
			val();
			}
			setState(109);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Dec_specContext extends ParserRuleContext {
		public TerminalNode LET() { return getToken(tinyR4Parser.LET, 0); }
		public TerminalNode MUT() { return getToken(tinyR4Parser.MUT, 0); }
		public Dec_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec_spec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).enterDec_spec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).exitDec_spec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tinyR4Visitor ) return ((tinyR4Visitor<? extends T>)visitor).visitDec_spec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dec_specContext dec_spec() throws RecognitionException {
		Dec_specContext _localctx = new Dec_specContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_dec_spec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(LET);
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MUT) {
				{
				setState(112);
				match(MUT);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValContext extends ParserRuleContext {
		public TerminalNode LITERAL() { return getToken(tinyR4Parser.LITERAL, 0); }
		public TerminalNode ID() { return getToken(tinyR4Parser.ID, 0); }
		public ValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_val; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).enterVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).exitVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tinyR4Visitor ) return ((tinyR4Visitor<? extends T>)visitor).visitVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValContext val() throws RecognitionException {
		ValContext _localctx = new ValContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_val);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==LITERAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StmtContext extends ParserRuleContext {
		public Expr_stmtContext expr_stmt() {
			return getRuleContext(Expr_stmtContext.class,0);
		}
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public Return_stmtContext return_stmt() {
			return getRuleContext(Return_stmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tinyR4Visitor ) return ((tinyR4Visitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_stmt);
		try {
			setState(121);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__8:
			case T__9:
			case T__13:
			case T__14:
			case T__15:
			case ID:
			case LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				expr_stmt();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
				compound_stmt();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(119);
				if_stmt();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 4);
				{
				setState(120);
				return_stmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Expr_stmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).enterExpr_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).exitExpr_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tinyR4Visitor ) return ((tinyR4Visitor<? extends T>)visitor).visitExpr_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_stmtContext expr_stmt() throws RecognitionException {
		Expr_stmtContext _localctx = new Expr_stmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expr_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			expr();
			setState(124);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public Additive_exprContext additive_expr() {
			return getRuleContext(Additive_exprContext.class,0);
		}
		public Relative_exprContext relative_expr() {
			return getRuleContext(Relative_exprContext.class,0);
		}
		public TerminalNode ID() { return getToken(tinyR4Parser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tinyR4Visitor ) return ((tinyR4Visitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expr);
		try {
			setState(131);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				additive_expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				relative_expr(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(128);
				match(ID);
				setState(129);
				match(T__6);
				setState(130);
				expr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Additive_exprContext extends ParserRuleContext {
		public Additive_exprContext left;
		public Token op;
		public Multiplicative_exprContext right;
		public Multiplicative_exprContext multiplicative_expr() {
			return getRuleContext(Multiplicative_exprContext.class,0);
		}
		public Additive_exprContext additive_expr() {
			return getRuleContext(Additive_exprContext.class,0);
		}
		public Additive_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additive_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).enterAdditive_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).exitAdditive_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tinyR4Visitor ) return ((tinyR4Visitor<? extends T>)visitor).visitAdditive_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Additive_exprContext additive_expr() throws RecognitionException {
		return additive_expr(0);
	}

	private Additive_exprContext additive_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Additive_exprContext _localctx = new Additive_exprContext(_ctx, _parentState);
		Additive_exprContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_additive_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(134);
			multiplicative_expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(141);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Additive_exprContext(_parentctx, _parentState);
					_localctx.left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_additive_expr);
					setState(136);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(137);
					((Additive_exprContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==T__8 || _la==T__9) ) {
						((Additive_exprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(138);
					((Additive_exprContext)_localctx).right = multiplicative_expr(0);
					}
					} 
				}
				setState(143);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Multiplicative_exprContext extends ParserRuleContext {
		public Multiplicative_exprContext left;
		public Token op;
		public Unary_exprContext right;
		public Unary_exprContext unary_expr() {
			return getRuleContext(Unary_exprContext.class,0);
		}
		public Multiplicative_exprContext multiplicative_expr() {
			return getRuleContext(Multiplicative_exprContext.class,0);
		}
		public Multiplicative_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicative_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).enterMultiplicative_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).exitMultiplicative_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tinyR4Visitor ) return ((tinyR4Visitor<? extends T>)visitor).visitMultiplicative_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiplicative_exprContext multiplicative_expr() throws RecognitionException {
		return multiplicative_expr(0);
	}

	private Multiplicative_exprContext multiplicative_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Multiplicative_exprContext _localctx = new Multiplicative_exprContext(_ctx, _parentState);
		Multiplicative_exprContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_multiplicative_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(145);
			unary_expr();
			}
			_ctx.stop = _input.LT(-1);
			setState(152);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Multiplicative_exprContext(_parentctx, _parentState);
					_localctx.left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_multiplicative_expr);
					setState(147);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(148);
					((Multiplicative_exprContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 14336L) != 0)) ) {
						((Multiplicative_exprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(149);
					((Multiplicative_exprContext)_localctx).right = unary_expr();
					}
					} 
				}
				setState(154);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Unary_exprContext extends ParserRuleContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public Unary_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).enterUnary_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).exitUnary_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tinyR4Visitor ) return ((tinyR4Visitor<? extends T>)visitor).visitUnary_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unary_exprContext unary_expr() throws RecognitionException {
		Unary_exprContext _localctx = new Unary_exprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_unary_expr);
		int _la;
		try {
			setState(158);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
			case T__9:
			case T__13:
			case T__14:
			case T__15:
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				((Unary_exprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 116224L) != 0)) ) {
					((Unary_exprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(156);
				expr();
				}
				break;
			case T__0:
			case ID:
			case LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				factor();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FactorContext extends ParserRuleContext {
		public TerminalNode LITERAL() { return getToken(tinyR4Parser.LITERAL, 0); }
		public TerminalNode ID() { return getToken(tinyR4Parser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tinyR4Visitor ) return ((tinyR4Visitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_factor);
		int _la;
		try {
			setState(173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(160);
				_la = _input.LA(1);
				if ( !(_la==ID || _la==LITERAL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				match(T__0);
				setState(162);
				expr();
				setState(163);
				match(T__1);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(165);
				match(ID);
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__15) {
					{
					setState(166);
					match(T__15);
					}
				}

				setState(169);
				match(T__0);
				setState(170);
				args();
				setState(171);
				match(T__1);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Relative_exprContext extends ParserRuleContext {
		public Relative_exprContext left;
		public Token op;
		public Comparative_exprContext right;
		public Comparative_exprContext comparative_expr() {
			return getRuleContext(Comparative_exprContext.class,0);
		}
		public Relative_exprContext relative_expr() {
			return getRuleContext(Relative_exprContext.class,0);
		}
		public TerminalNode AND() { return getToken(tinyR4Parser.AND, 0); }
		public TerminalNode OR() { return getToken(tinyR4Parser.OR, 0); }
		public Relative_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relative_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).enterRelative_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).exitRelative_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tinyR4Visitor ) return ((tinyR4Visitor<? extends T>)visitor).visitRelative_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Relative_exprContext relative_expr() throws RecognitionException {
		return relative_expr(0);
	}

	private Relative_exprContext relative_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Relative_exprContext _localctx = new Relative_exprContext(_ctx, _parentState);
		Relative_exprContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_relative_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(176);
			comparative_expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(183);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Relative_exprContext(_parentctx, _parentState);
					_localctx.left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_relative_expr);
					setState(178);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(179);
					((Relative_exprContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==OR || _la==AND) ) {
						((Relative_exprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(180);
					((Relative_exprContext)_localctx).right = comparative_expr(0);
					}
					} 
				}
				setState(185);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Comparative_exprContext extends ParserRuleContext {
		public Comparative_exprContext left;
		public Token op;
		public Additive_exprContext right;
		public Additive_exprContext additive_expr() {
			return getRuleContext(Additive_exprContext.class,0);
		}
		public Comparative_exprContext comparative_expr() {
			return getRuleContext(Comparative_exprContext.class,0);
		}
		public TerminalNode EQ() { return getToken(tinyR4Parser.EQ, 0); }
		public TerminalNode NE() { return getToken(tinyR4Parser.NE, 0); }
		public TerminalNode LE() { return getToken(tinyR4Parser.LE, 0); }
		public TerminalNode GE() { return getToken(tinyR4Parser.GE, 0); }
		public Comparative_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparative_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).enterComparative_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).exitComparative_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tinyR4Visitor ) return ((tinyR4Visitor<? extends T>)visitor).visitComparative_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Comparative_exprContext comparative_expr() throws RecognitionException {
		return comparative_expr(0);
	}

	private Comparative_exprContext comparative_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Comparative_exprContext _localctx = new Comparative_exprContext(_ctx, _parentState);
		Comparative_exprContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_comparative_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(187);
			additive_expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(194);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Comparative_exprContext(_parentctx, _parentState);
					_localctx.left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_comparative_expr);
					setState(189);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(190);
					((Comparative_exprContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4026925056L) != 0)) ) {
						((Comparative_exprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(191);
					((Comparative_exprContext)_localctx).right = additive_expr(0);
					}
					} 
				}
				setState(196);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class If_stmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(tinyR4Parser.IF, 0); }
		public Relative_exprContext relative_expr() {
			return getRuleContext(Relative_exprContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(tinyR4Parser.ELSE, 0); }
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).enterIf_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).exitIf_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tinyR4Visitor ) return ((tinyR4Visitor<? extends T>)visitor).visitIf_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_if_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(IF);
			setState(198);
			relative_expr(0);
			setState(199);
			stmt();
			setState(202);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(200);
				match(ELSE);
				setState(201);
				stmt();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Return_stmtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(tinyR4Parser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Return_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).enterReturn_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).exitReturn_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tinyR4Visitor ) return ((tinyR4Visitor<? extends T>)visitor).visitReturn_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_stmtContext return_stmt() throws RecognitionException {
		Return_stmtContext _localctx = new Return_stmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_return_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(RETURN);
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 25769920002L) != 0)) {
				{
				setState(205);
				expr();
				}
			}

			setState(208);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tinyR4Listener ) ((tinyR4Listener)listener).exitArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tinyR4Visitor ) return ((tinyR4Visitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_args);
		int _la;
		try {
			setState(219);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case T__0:
			case T__8:
			case T__9:
			case T__13:
			case T__14:
			case T__15:
			case ID:
			case LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(211);
				expr();
				setState(216);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(212);
					match(T__2);
					setState(213);
					expr();
					}
					}
					setState(218);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 14:
			return additive_expr_sempred((Additive_exprContext)_localctx, predIndex);
		case 15:
			return multiplicative_expr_sempred((Multiplicative_exprContext)_localctx, predIndex);
		case 18:
			return relative_expr_sempred((Relative_exprContext)_localctx, predIndex);
		case 19:
			return comparative_expr_sempred((Comparative_exprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean additive_expr_sempred(Additive_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean multiplicative_expr_sempred(Multiplicative_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean relative_expr_sempred(Relative_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean comparative_expr_sempred(Comparative_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001*\u00de\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0001\u0000\u0004\u00000\b\u0000\u000b\u0000"+
		"\f\u00001\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003"+
		"D\b\u0003\n\u0003\f\u0003G\t\u0003\u0003\u0003I\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0003\u0006T\b\u0006\u0001\u0007\u0001\u0007\u0005"+
		"\u0007X\b\u0007\n\u0007\f\u0007[\t\u0007\u0001\u0007\u0005\u0007^\b\u0007"+
		"\n\u0007\f\u0007a\t\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0003\bi\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0003\tr\b\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0003\u000bz\b\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u0084\b\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u008c"+
		"\b\u000e\n\u000e\f\u000e\u008f\t\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u0097\b\u000f\n\u000f"+
		"\f\u000f\u009a\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010"+
		"\u009f\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0003\u0011\u00a8\b\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0003\u0011\u00ae\b\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u00b6\b\u0012"+
		"\n\u0012\f\u0012\u00b9\t\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u00c1\b\u0013\n\u0013\f\u0013"+
		"\u00c4\t\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0003\u0014\u00cb\b\u0014\u0001\u0015\u0001\u0015\u0003\u0015\u00cf\b"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0005\u0016\u00d7\b\u0016\n\u0016\f\u0016\u00da\t\u0016\u0003\u0016"+
		"\u00dc\b\u0016\u0001\u0016\u0000\u0004\u001c\u001e$&\u0017\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,\u0000\u0006\u0001\u0000!\"\u0001\u0000\t\n\u0001\u0000\u000b"+
		"\r\u0002\u0000\t\n\u000e\u0010\u0001\u0000\u001a\u001b\u0002\u0000\u0011"+
		"\u0012\u001c\u001f\u00df\u0000/\u0001\u0000\u0000\u0000\u00025\u0001\u0000"+
		"\u0000\u0000\u00047\u0001\u0000\u0000\u0000\u0006H\u0001\u0000\u0000\u0000"+
		"\bJ\u0001\u0000\u0000\u0000\nN\u0001\u0000\u0000\u0000\fS\u0001\u0000"+
		"\u0000\u0000\u000eU\u0001\u0000\u0000\u0000\u0010d\u0001\u0000\u0000\u0000"+
		"\u0012o\u0001\u0000\u0000\u0000\u0014s\u0001\u0000\u0000\u0000\u0016y"+
		"\u0001\u0000\u0000\u0000\u0018{\u0001\u0000\u0000\u0000\u001a\u0083\u0001"+
		"\u0000\u0000\u0000\u001c\u0085\u0001\u0000\u0000\u0000\u001e\u0090\u0001"+
		"\u0000\u0000\u0000 \u009e\u0001\u0000\u0000\u0000\"\u00ad\u0001\u0000"+
		"\u0000\u0000$\u00af\u0001\u0000\u0000\u0000&\u00ba\u0001\u0000\u0000\u0000"+
		"(\u00c5\u0001\u0000\u0000\u0000*\u00cc\u0001\u0000\u0000\u0000,\u00db"+
		"\u0001\u0000\u0000\u0000.0\u0003\u0002\u0001\u0000/.\u0001\u0000\u0000"+
		"\u000001\u0001\u0000\u0000\u00001/\u0001\u0000\u0000\u000012\u0001\u0000"+
		"\u0000\u000023\u0001\u0000\u0000\u000034\u0006\u0000\uffff\uffff\u0000"+
		"4\u0001\u0001\u0000\u0000\u000056\u0003\u0004\u0002\u00006\u0003\u0001"+
		"\u0000\u0000\u000078\u0005\u0013\u0000\u000089\u0005!\u0000\u00009:\u0005"+
		"\u0001\u0000\u0000:;\u0003\u0006\u0003\u0000;<\u0005\u0002\u0000\u0000"+
		"<=\u0003\f\u0006\u0000=>\u0003\u000e\u0007\u0000>\u0005\u0001\u0000\u0000"+
		"\u0000?I\u0001\u0000\u0000\u0000@E\u0003\b\u0004\u0000AB\u0005\u0003\u0000"+
		"\u0000BD\u0003\b\u0004\u0000CA\u0001\u0000\u0000\u0000DG\u0001\u0000\u0000"+
		"\u0000EC\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000FI\u0001\u0000"+
		"\u0000\u0000GE\u0001\u0000\u0000\u0000H?\u0001\u0000\u0000\u0000H@\u0001"+
		"\u0000\u0000\u0000I\u0007\u0001\u0000\u0000\u0000JK\u0005!\u0000\u0000"+
		"KL\u0005\u0004\u0000\u0000LM\u0003\n\u0005\u0000M\t\u0001\u0000\u0000"+
		"\u0000NO\u0005\u0014\u0000\u0000O\u000b\u0001\u0000\u0000\u0000PT\u0001"+
		"\u0000\u0000\u0000QR\u0005 \u0000\u0000RT\u0003\n\u0005\u0000SP\u0001"+
		"\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000T\r\u0001\u0000\u0000\u0000"+
		"UY\u0005\u0005\u0000\u0000VX\u0003\u0010\b\u0000WV\u0001\u0000\u0000\u0000"+
		"X[\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000"+
		"\u0000Z_\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000\\^\u0003\u0016"+
		"\u000b\u0000]\\\u0001\u0000\u0000\u0000^a\u0001\u0000\u0000\u0000_]\u0001"+
		"\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`b\u0001\u0000\u0000\u0000"+
		"a_\u0001\u0000\u0000\u0000bc\u0005\u0006\u0000\u0000c\u000f\u0001\u0000"+
		"\u0000\u0000de\u0003\u0012\t\u0000eh\u0005!\u0000\u0000fg\u0005\u0004"+
		"\u0000\u0000gi\u0003\n\u0005\u0000hf\u0001\u0000\u0000\u0000hi\u0001\u0000"+
		"\u0000\u0000ij\u0001\u0000\u0000\u0000jk\u0005\u0007\u0000\u0000kl\u0003"+
		"\u0014\n\u0000lm\u0001\u0000\u0000\u0000mn\u0005\b\u0000\u0000n\u0011"+
		"\u0001\u0000\u0000\u0000oq\u0005\u0018\u0000\u0000pr\u0005\u0019\u0000"+
		"\u0000qp\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000r\u0013\u0001"+
		"\u0000\u0000\u0000st\u0007\u0000\u0000\u0000t\u0015\u0001\u0000\u0000"+
		"\u0000uz\u0003\u0018\f\u0000vz\u0003\u000e\u0007\u0000wz\u0003(\u0014"+
		"\u0000xz\u0003*\u0015\u0000yu\u0001\u0000\u0000\u0000yv\u0001\u0000\u0000"+
		"\u0000yw\u0001\u0000\u0000\u0000yx\u0001\u0000\u0000\u0000z\u0017\u0001"+
		"\u0000\u0000\u0000{|\u0003\u001a\r\u0000|}\u0005\b\u0000\u0000}\u0019"+
		"\u0001\u0000\u0000\u0000~\u0084\u0003\u001c\u000e\u0000\u007f\u0084\u0003"+
		"$\u0012\u0000\u0080\u0081\u0005!\u0000\u0000\u0081\u0082\u0005\u0007\u0000"+
		"\u0000\u0082\u0084\u0003\u001a\r\u0000\u0083~\u0001\u0000\u0000\u0000"+
		"\u0083\u007f\u0001\u0000\u0000\u0000\u0083\u0080\u0001\u0000\u0000\u0000"+
		"\u0084\u001b\u0001\u0000\u0000\u0000\u0085\u0086\u0006\u000e\uffff\uffff"+
		"\u0000\u0086\u0087\u0003\u001e\u000f\u0000\u0087\u008d\u0001\u0000\u0000"+
		"\u0000\u0088\u0089\n\u0002\u0000\u0000\u0089\u008a\u0007\u0001\u0000\u0000"+
		"\u008a\u008c\u0003\u001e\u000f\u0000\u008b\u0088\u0001\u0000\u0000\u0000"+
		"\u008c\u008f\u0001\u0000\u0000\u0000\u008d\u008b\u0001\u0000\u0000\u0000"+
		"\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u001d\u0001\u0000\u0000\u0000"+
		"\u008f\u008d\u0001\u0000\u0000\u0000\u0090\u0091\u0006\u000f\uffff\uffff"+
		"\u0000\u0091\u0092\u0003 \u0010\u0000\u0092\u0098\u0001\u0000\u0000\u0000"+
		"\u0093\u0094\n\u0002\u0000\u0000\u0094\u0095\u0007\u0002\u0000\u0000\u0095"+
		"\u0097\u0003 \u0010\u0000\u0096\u0093\u0001\u0000\u0000\u0000\u0097\u009a"+
		"\u0001\u0000\u0000\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0098\u0099"+
		"\u0001\u0000\u0000\u0000\u0099\u001f\u0001\u0000\u0000\u0000\u009a\u0098"+
		"\u0001\u0000\u0000\u0000\u009b\u009c\u0007\u0003\u0000\u0000\u009c\u009f"+
		"\u0003\u001a\r\u0000\u009d\u009f\u0003\"\u0011\u0000\u009e\u009b\u0001"+
		"\u0000\u0000\u0000\u009e\u009d\u0001\u0000\u0000\u0000\u009f!\u0001\u0000"+
		"\u0000\u0000\u00a0\u00ae\u0007\u0000\u0000\u0000\u00a1\u00a2\u0005\u0001"+
		"\u0000\u0000\u00a2\u00a3\u0003\u001a\r\u0000\u00a3\u00a4\u0005\u0002\u0000"+
		"\u0000\u00a4\u00ae\u0001\u0000\u0000\u0000\u00a5\u00a7\u0005!\u0000\u0000"+
		"\u00a6\u00a8\u0005\u0010\u0000\u0000\u00a7\u00a6\u0001\u0000\u0000\u0000"+
		"\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000"+
		"\u00a9\u00aa\u0005\u0001\u0000\u0000\u00aa\u00ab\u0003,\u0016\u0000\u00ab"+
		"\u00ac\u0005\u0002\u0000\u0000\u00ac\u00ae\u0001\u0000\u0000\u0000\u00ad"+
		"\u00a0\u0001\u0000\u0000\u0000\u00ad\u00a1\u0001\u0000\u0000\u0000\u00ad"+
		"\u00a5\u0001\u0000\u0000\u0000\u00ae#\u0001\u0000\u0000\u0000\u00af\u00b0"+
		"\u0006\u0012\uffff\uffff\u0000\u00b0\u00b1\u0003&\u0013\u0000\u00b1\u00b7"+
		"\u0001\u0000\u0000\u0000\u00b2\u00b3\n\u0002\u0000\u0000\u00b3\u00b4\u0007"+
		"\u0004\u0000\u0000\u00b4\u00b6\u0003&\u0013\u0000\u00b5\u00b2\u0001\u0000"+
		"\u0000\u0000\u00b6\u00b9\u0001\u0000\u0000\u0000\u00b7\u00b5\u0001\u0000"+
		"\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8%\u0001\u0000\u0000"+
		"\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00ba\u00bb\u0006\u0013\uffff"+
		"\uffff\u0000\u00bb\u00bc\u0003\u001c\u000e\u0000\u00bc\u00c2\u0001\u0000"+
		"\u0000\u0000\u00bd\u00be\n\u0002\u0000\u0000\u00be\u00bf\u0007\u0005\u0000"+
		"\u0000\u00bf\u00c1\u0003\u001c\u000e\u0000\u00c0\u00bd\u0001\u0000\u0000"+
		"\u0000\u00c1\u00c4\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000"+
		"\u0000\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c3\'\u0001\u0000\u0000\u0000"+
		"\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c5\u00c6\u0005\u0015\u0000\u0000"+
		"\u00c6\u00c7\u0003$\u0012\u0000\u00c7\u00ca\u0003\u0016\u000b\u0000\u00c8"+
		"\u00c9\u0005\u0016\u0000\u0000\u00c9\u00cb\u0003\u0016\u000b\u0000\u00ca"+
		"\u00c8\u0001\u0000\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000\u0000\u00cb"+
		")\u0001\u0000\u0000\u0000\u00cc\u00ce\u0005\u0017\u0000\u0000\u00cd\u00cf"+
		"\u0003\u001a\r\u0000\u00ce\u00cd\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001"+
		"\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0\u00d1\u0005"+
		"\b\u0000\u0000\u00d1+\u0001\u0000\u0000\u0000\u00d2\u00dc\u0001\u0000"+
		"\u0000\u0000\u00d3\u00d8\u0003\u001a\r\u0000\u00d4\u00d5\u0005\u0003\u0000"+
		"\u0000\u00d5\u00d7\u0003\u001a\r\u0000\u00d6\u00d4\u0001\u0000\u0000\u0000"+
		"\u00d7\u00da\u0001\u0000\u0000\u0000\u00d8\u00d6\u0001\u0000\u0000\u0000"+
		"\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9\u00dc\u0001\u0000\u0000\u0000"+
		"\u00da\u00d8\u0001\u0000\u0000\u0000\u00db\u00d2\u0001\u0000\u0000\u0000"+
		"\u00db\u00d3\u0001\u0000\u0000\u0000\u00dc-\u0001\u0000\u0000\u0000\u0015"+
		"1EHSY_hqy\u0083\u008d\u0098\u009e\u00a7\u00ad\u00b7\u00c2\u00ca\u00ce"+
		"\u00d8\u00db";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}