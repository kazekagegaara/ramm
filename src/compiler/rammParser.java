// Generated from ramm.g4 by ANTLR 4.5
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class rammParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Println=1, Print=2, Input=3, Assert=4, Size=5, Def=6, If=7, Else=8, Return=9, 
		For=10, While=11, To=12, Do=13, End=14, In=15, Null=16, Or=17, And=18, 
		Equals=19, NEquals=20, GTEquals=21, LTEquals=22, Pow=23, Excl=24, GT=25, 
		LT=26, Add=27, Subtract=28, Multiply=29, Divide=30, Modulus=31, OBrace=32, 
		CBrace=33, OBracket=34, CBracket=35, OParen=36, CParen=37, SColon=38, 
		Assign=39, Comma=40, QMark=41, Colon=42, Bool=43, Number=44, Identifier=45, 
		String=46, Comment=47, Space=48;
	public static final int
		RULE_parse = 0, RULE_block = 1, RULE_statement = 2, RULE_assignment = 3, 
		RULE_functionCall = 4, RULE_ifStatement = 5, RULE_ifStat = 6, RULE_elseIfStat = 7, 
		RULE_elseStat = 8, RULE_functionDecl = 9, RULE_forStatement = 10, RULE_whileStatement = 11, 
		RULE_idList = 12, RULE_exprList = 13, RULE_expression = 14, RULE_list = 15, 
		RULE_indexes = 16;
	public static final String[] ruleNames = {
		"parse", "block", "statement", "assignment", "functionCall", "ifStatement", 
		"ifStat", "elseIfStat", "elseStat", "functionDecl", "forStatement", "whileStatement", 
		"idList", "exprList", "expression", "list", "indexes"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'println'", "'print'", "'input'", "'assert'", "'size'", "'def'", 
		"'if'", "'else'", "'return'", "'for'", "'while'", "'to'", "'do'", "'end'", 
		"'in'", "'null'", "'||'", "'&&'", "'=='", "'!='", "'>='", "'<='", "'^'", 
		"'!'", "'>'", "'<'", "'+'", "'-'", "'*'", "'/'", "'%'", "'{'", "'}'", 
		"'['", "']'", "'('", "')'", "';'", "'='", "','", "'?'", "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Println", "Print", "Input", "Assert", "Size", "Def", "If", "Else", 
		"Return", "For", "While", "To", "Do", "End", "In", "Null", "Or", "And", 
		"Equals", "NEquals", "GTEquals", "LTEquals", "Pow", "Excl", "GT", "LT", 
		"Add", "Subtract", "Multiply", "Divide", "Modulus", "OBrace", "CBrace", 
		"OBracket", "CBracket", "OParen", "CParen", "SColon", "Assign", "Comma", 
		"QMark", "Colon", "Bool", "Number", "Identifier", "String", "Comment", 
		"Space"
	};
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
	public String getGrammarFileName() { return "ramm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public rammParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ParseContext extends ParserRuleContext {
		public Token t;
		public TerminalNode EOF() { return getToken(rammParser.EOF, 0); }
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitParse(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Println) | (1L << Print) | (1L << Input) | (1L << Assert) | (1L << Size) | (1L << Def) | (1L << If) | (1L << Else) | (1L << Return) | (1L << For) | (1L << While) | (1L << To) | (1L << Do) | (1L << End) | (1L << In) | (1L << Null) | (1L << Or) | (1L << And) | (1L << Equals) | (1L << NEquals) | (1L << GTEquals) | (1L << LTEquals) | (1L << Pow) | (1L << Excl) | (1L << GT) | (1L << LT) | (1L << Add) | (1L << Subtract) | (1L << Multiply) | (1L << Divide) | (1L << Modulus) | (1L << OBrace) | (1L << CBrace) | (1L << OBracket) | (1L << CBracket) | (1L << OParen) | (1L << CParen) | (1L << SColon) | (1L << Assign) | (1L << Comma) | (1L << QMark) | (1L << Colon) | (1L << Bool) | (1L << Number) | (1L << Identifier) | (1L << String) | (1L << Comment) | (1L << Space))) != 0)) {
				{
				{
				setState(34);
				((ParseContext)_localctx).t = matchWildcard();
				System.out.printf("text: %-7s  type: %s \n", 
				           (((ParseContext)_localctx).t!=null?((ParseContext)_localctx).t.getText():null), tokenNames[(((ParseContext)_localctx).t!=null?((ParseContext)_localctx).t.getType():0)]);
				}
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(41);
			match(EOF);
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

	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<FunctionDeclContext> functionDecl() {
			return getRuleContexts(FunctionDeclContext.class);
		}
		public FunctionDeclContext functionDecl(int i) {
			return getRuleContext(FunctionDeclContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(45);
					switch (_input.LA(1)) {
					case Println:
					case Print:
					case Assert:
					case Size:
					case If:
					case For:
					case While:
					case Identifier:
						{
						setState(43);
						statement();
						}
						break;
					case Def:
						{
						setState(44);
						functionDecl();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(49);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(51);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Println) | (1L << Print) | (1L << Input) | (1L << Assert) | (1L << Size) | (1L << Return) | (1L << Null) | (1L << Excl) | (1L << Subtract) | (1L << OBracket) | (1L << OParen) | (1L << Bool) | (1L << Number) | (1L << Identifier) | (1L << String))) != 0)) {
				{
				setState(50);
				expression(0);
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

	public static class StatementContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(58);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				functionCall();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(55);
				ifStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(56);
				forStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(57);
				whileStatement();
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

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(rammParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IndexesContext indexes() {
			return getRuleContext(IndexesContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(Identifier);
			setState(62);
			_la = _input.LA(1);
			if (_la==OBracket) {
				{
				setState(61);
				indexes();
				}
			}

			setState(64);
			match(Assign);
			setState(65);
			expression(0);
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

	public static class FunctionCallContext extends ParserRuleContext {
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
	 
		public FunctionCallContext() { }
		public void copyFrom(FunctionCallContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IdentifierFunctionCallContext extends FunctionCallContext {
		public TerminalNode Identifier() { return getToken(rammParser.Identifier, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public IdentifierFunctionCallContext(FunctionCallContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterIdentifierFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitIdentifierFunctionCall(this);
		}
	}
	public static class PrintlnFunctionCallContext extends FunctionCallContext {
		public TerminalNode Println() { return getToken(rammParser.Println, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintlnFunctionCallContext(FunctionCallContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterPrintlnFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitPrintlnFunctionCall(this);
		}
	}
	public static class SizeFunctionCallContext extends FunctionCallContext {
		public TerminalNode Size() { return getToken(rammParser.Size, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SizeFunctionCallContext(FunctionCallContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterSizeFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitSizeFunctionCall(this);
		}
	}
	public static class PrintFunctionCallContext extends FunctionCallContext {
		public TerminalNode Print() { return getToken(rammParser.Print, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintFunctionCallContext(FunctionCallContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterPrintFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitPrintFunctionCall(this);
		}
	}
	public static class AssertFunctionCallContext extends FunctionCallContext {
		public TerminalNode Assert() { return getToken(rammParser.Assert, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssertFunctionCallContext(FunctionCallContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterAssertFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitAssertFunctionCall(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_functionCall);
		int _la;
		try {
			setState(94);
			switch (_input.LA(1)) {
			case Identifier:
				_localctx = new IdentifierFunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				match(Identifier);
				setState(68);
				match(OParen);
				setState(70);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Println) | (1L << Print) | (1L << Input) | (1L << Assert) | (1L << Size) | (1L << Return) | (1L << Null) | (1L << Excl) | (1L << Subtract) | (1L << OBracket) | (1L << OParen) | (1L << Bool) | (1L << Number) | (1L << Identifier) | (1L << String))) != 0)) {
					{
					setState(69);
					exprList();
					}
				}

				setState(72);
				match(CParen);
				}
				break;
			case Println:
				_localctx = new PrintlnFunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				match(Println);
				setState(74);
				match(OParen);
				setState(76);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Println) | (1L << Print) | (1L << Input) | (1L << Assert) | (1L << Size) | (1L << Return) | (1L << Null) | (1L << Excl) | (1L << Subtract) | (1L << OBracket) | (1L << OParen) | (1L << Bool) | (1L << Number) | (1L << Identifier) | (1L << String))) != 0)) {
					{
					setState(75);
					expression(0);
					}
				}

				setState(78);
				match(CParen);
				}
				break;
			case Print:
				_localctx = new PrintFunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				match(Print);
				setState(80);
				match(OParen);
				setState(81);
				expression(0);
				setState(82);
				match(CParen);
				}
				break;
			case Assert:
				_localctx = new AssertFunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(84);
				match(Assert);
				setState(85);
				match(OParen);
				setState(86);
				expression(0);
				setState(87);
				match(CParen);
				}
				break;
			case Size:
				_localctx = new SizeFunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(89);
				match(Size);
				setState(90);
				match(OParen);
				setState(91);
				expression(0);
				setState(92);
				match(CParen);
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

	public static class IfStatementContext extends ParserRuleContext {
		public IfStatContext ifStat() {
			return getRuleContext(IfStatContext.class,0);
		}
		public TerminalNode End() { return getToken(rammParser.End, 0); }
		public List<ElseIfStatContext> elseIfStat() {
			return getRuleContexts(ElseIfStatContext.class);
		}
		public ElseIfStatContext elseIfStat(int i) {
			return getRuleContext(ElseIfStatContext.class,i);
		}
		public ElseStatContext elseStat() {
			return getRuleContext(ElseStatContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitIfStatement(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ifStatement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			ifStat();
			setState(100);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(97);
					elseIfStat();
					}
					} 
				}
				setState(102);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			setState(104);
			_la = _input.LA(1);
			if (_la==Else) {
				{
				setState(103);
				elseStat();
				}
			}

			setState(106);
			match(End);
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

	public static class IfStatContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(rammParser.If, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Do() { return getToken(rammParser.Do, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public IfStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitIfStat(this);
		}
	}

	public final IfStatContext ifStat() throws RecognitionException {
		IfStatContext _localctx = new IfStatContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ifStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(If);
			setState(109);
			expression(0);
			setState(110);
			match(Do);
			setState(111);
			block();
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

	public static class ElseIfStatContext extends ParserRuleContext {
		public TerminalNode Else() { return getToken(rammParser.Else, 0); }
		public TerminalNode If() { return getToken(rammParser.If, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Do() { return getToken(rammParser.Do, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseIfStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseIfStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterElseIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitElseIfStat(this);
		}
	}

	public final ElseIfStatContext elseIfStat() throws RecognitionException {
		ElseIfStatContext _localctx = new ElseIfStatContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_elseIfStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(Else);
			setState(114);
			match(If);
			setState(115);
			expression(0);
			setState(116);
			match(Do);
			setState(117);
			block();
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

	public static class ElseStatContext extends ParserRuleContext {
		public TerminalNode Else() { return getToken(rammParser.Else, 0); }
		public TerminalNode Do() { return getToken(rammParser.Do, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterElseStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitElseStat(this);
		}
	}

	public final ElseStatContext elseStat() throws RecognitionException {
		ElseStatContext _localctx = new ElseStatContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_elseStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(Else);
			setState(120);
			match(Do);
			setState(121);
			block();
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

	public static class FunctionDeclContext extends ParserRuleContext {
		public TerminalNode Def() { return getToken(rammParser.Def, 0); }
		public TerminalNode Identifier() { return getToken(rammParser.Identifier, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode End() { return getToken(rammParser.End, 0); }
		public IdListContext idList() {
			return getRuleContext(IdListContext.class,0);
		}
		public FunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterFunctionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitFunctionDecl(this);
		}
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_functionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(Def);
			setState(124);
			match(Identifier);
			setState(125);
			match(OParen);
			setState(127);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(126);
				idList();
				}
			}

			setState(129);
			match(CParen);
			setState(130);
			block();
			setState(131);
			match(End);
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

	public static class ForStatementContext extends ParserRuleContext {
		public TerminalNode For() { return getToken(rammParser.For, 0); }
		public TerminalNode Identifier() { return getToken(rammParser.Identifier, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode To() { return getToken(rammParser.To, 0); }
		public TerminalNode Do() { return getToken(rammParser.Do, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode End() { return getToken(rammParser.End, 0); }
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitForStatement(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_forStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(For);
			setState(134);
			match(Identifier);
			setState(135);
			match(Assign);
			setState(136);
			expression(0);
			setState(137);
			match(To);
			setState(138);
			expression(0);
			setState(139);
			match(Do);
			setState(140);
			block();
			setState(141);
			match(End);
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

	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode While() { return getToken(rammParser.While, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Do() { return getToken(rammParser.Do, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode End() { return getToken(rammParser.End, 0); }
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitWhileStatement(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(While);
			setState(144);
			expression(0);
			setState(145);
			match(Do);
			setState(146);
			block();
			setState(147);
			match(End);
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

	public static class IdListContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(rammParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(rammParser.Identifier, i);
		}
		public IdListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterIdList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitIdList(this);
		}
	}

	public final IdListContext idList() throws RecognitionException {
		IdListContext _localctx = new IdListContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_idList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(Identifier);
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(150);
				match(Comma);
				setState(151);
				match(Identifier);
				}
				}
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ExprListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterExprList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitExprList(this);
		}
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			expression(0);
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(158);
				match(Comma);
				setState(159);
				expression(0);
				}
				}
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DivideExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DivideExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterDivideExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitDivideExpression(this);
		}
	}
	public static class ModulusExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ModulusExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterModulusExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitModulusExpression(this);
		}
	}
	public static class EqExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public EqExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterEqExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitEqExpression(this);
		}
	}
	public static class AddExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AddExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterAddExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitAddExpression(this);
		}
	}
	public static class PowerExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public PowerExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterPowerExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitPowerExpression(this);
		}
	}
	public static class OrExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public OrExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitOrExpression(this);
		}
	}
	public static class AndExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AndExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitAndExpression(this);
		}
	}
	public static class BoolExpressionContext extends ExpressionContext {
		public TerminalNode Bool() { return getToken(rammParser.Bool, 0); }
		public BoolExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterBoolExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitBoolExpression(this);
		}
	}
	public static class LtExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public LtExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterLtExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitLtExpression(this);
		}
	}
	public static class ExpressionExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IndexesContext indexes() {
			return getRuleContext(IndexesContext.class,0);
		}
		public ExpressionExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterExpressionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitExpressionExpression(this);
		}
	}
	public static class NullExpressionContext extends ExpressionContext {
		public TerminalNode Null() { return getToken(rammParser.Null, 0); }
		public NullExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterNullExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitNullExpression(this);
		}
	}
	public static class InputExpressionContext extends ExpressionContext {
		public TerminalNode Input() { return getToken(rammParser.Input, 0); }
		public TerminalNode String() { return getToken(rammParser.String, 0); }
		public InputExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterInputExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitInputExpression(this);
		}
	}
	public static class LtEqExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public LtEqExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterLtEqExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitLtEqExpression(this);
		}
	}
	public static class StringExpressionContext extends ExpressionContext {
		public TerminalNode String() { return getToken(rammParser.String, 0); }
		public IndexesContext indexes() {
			return getRuleContext(IndexesContext.class,0);
		}
		public StringExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterStringExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitStringExpression(this);
		}
	}
	public static class IdentifierExpressionContext extends ExpressionContext {
		public TerminalNode Identifier() { return getToken(rammParser.Identifier, 0); }
		public IndexesContext indexes() {
			return getRuleContext(IndexesContext.class,0);
		}
		public IdentifierExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterIdentifierExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitIdentifierExpression(this);
		}
	}
	public static class NotExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterNotExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitNotExpression(this);
		}
	}
	public static class GtEqExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public GtEqExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterGtEqExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitGtEqExpression(this);
		}
	}
	public static class NotEqExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public NotEqExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterNotEqExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitNotEqExpression(this);
		}
	}
	public static class SubtractExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public SubtractExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterSubtractExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitSubtractExpression(this);
		}
	}
	public static class TernaryExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TernaryExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterTernaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitTernaryExpression(this);
		}
	}
	public static class MultiplyExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MultiplyExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterMultiplyExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitMultiplyExpression(this);
		}
	}
	public static class GtExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public GtExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterGtExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitGtExpression(this);
		}
	}
	public static class InExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode In() { return getToken(rammParser.In, 0); }
		public InExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterInExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitInExpression(this);
		}
	}
	public static class ReturnExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterReturnExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitReturnExpression(this);
		}
	}
	public static class UnaryMinusExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnaryMinusExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterUnaryMinusExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitUnaryMinusExpression(this);
		}
	}
	public static class FunctionCallExpressionContext extends ExpressionContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public IndexesContext indexes() {
			return getRuleContext(IndexesContext.class,0);
		}
		public FunctionCallExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterFunctionCallExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitFunctionCallExpression(this);
		}
	}
	public static class NumberExpressionContext extends ExpressionContext {
		public TerminalNode Number() { return getToken(rammParser.Number, 0); }
		public NumberExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterNumberExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitNumberExpression(this);
		}
	}
	public static class ListExpressionContext extends ExpressionContext {
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public IndexesContext indexes() {
			return getRuleContext(IndexesContext.class,0);
		}
		public ListExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterListExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitListExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryMinusExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(166);
				match(Subtract);
				setState(167);
				expression(28);
				}
				break;
			case 2:
				{
				_localctx = new NotExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(168);
				match(Excl);
				setState(169);
				expression(27);
				}
				break;
			case 3:
				{
				_localctx = new ReturnExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(170);
				match(Return);
				setState(171);
				expression(21);
				}
				break;
			case 4:
				{
				_localctx = new NumberExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(172);
				match(Number);
				}
				break;
			case 5:
				{
				_localctx = new BoolExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(173);
				match(Bool);
				}
				break;
			case 6:
				{
				_localctx = new NullExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(174);
				match(Null);
				}
				break;
			case 7:
				{
				_localctx = new FunctionCallExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(175);
				functionCall();
				setState(177);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(176);
					indexes();
					}
					break;
				}
				}
				break;
			case 8:
				{
				_localctx = new ListExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(179);
				list();
				setState(181);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(180);
					indexes();
					}
					break;
				}
				}
				break;
			case 9:
				{
				_localctx = new IdentifierExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(183);
				match(Identifier);
				setState(185);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(184);
					indexes();
					}
					break;
				}
				}
				break;
			case 10:
				{
				_localctx = new StringExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(187);
				match(String);
				setState(189);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(188);
					indexes();
					}
					break;
				}
				}
				break;
			case 11:
				{
				_localctx = new ExpressionExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(191);
				match(OParen);
				setState(192);
				expression(0);
				setState(193);
				match(CParen);
				setState(195);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(194);
					indexes();
					}
					break;
				}
				}
				break;
			case 12:
				{
				_localctx = new InputExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(197);
				match(Input);
				setState(198);
				match(OParen);
				setState(200);
				_la = _input.LA(1);
				if (_la==String) {
					{
					setState(199);
					match(String);
					}
				}

				setState(202);
				match(CParen);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(258);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(256);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new PowerExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(205);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(206);
						match(Pow);
						setState(207);
						expression(27);
						}
						break;
					case 2:
						{
						_localctx = new MultiplyExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(208);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(209);
						match(Multiply);
						setState(210);
						expression(26);
						}
						break;
					case 3:
						{
						_localctx = new DivideExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(211);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(212);
						match(Divide);
						setState(213);
						expression(25);
						}
						break;
					case 4:
						{
						_localctx = new ModulusExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(214);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(215);
						match(Modulus);
						setState(216);
						expression(24);
						}
						break;
					case 5:
						{
						_localctx = new AddExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(217);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(218);
						match(Add);
						setState(219);
						expression(23);
						}
						break;
					case 6:
						{
						_localctx = new SubtractExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(220);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(221);
						match(Subtract);
						setState(222);
						expression(21);
						}
						break;
					case 7:
						{
						_localctx = new GtEqExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(223);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(224);
						match(GTEquals);
						setState(225);
						expression(20);
						}
						break;
					case 8:
						{
						_localctx = new LtEqExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(226);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(227);
						match(LTEquals);
						setState(228);
						expression(19);
						}
						break;
					case 9:
						{
						_localctx = new GtExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(229);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(230);
						match(GT);
						setState(231);
						expression(18);
						}
						break;
					case 10:
						{
						_localctx = new LtExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(232);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(233);
						match(LT);
						setState(234);
						expression(17);
						}
						break;
					case 11:
						{
						_localctx = new EqExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(235);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(236);
						match(Equals);
						setState(237);
						expression(16);
						}
						break;
					case 12:
						{
						_localctx = new NotEqExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(238);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(239);
						match(NEquals);
						setState(240);
						expression(15);
						}
						break;
					case 13:
						{
						_localctx = new AndExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(241);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(242);
						match(And);
						setState(243);
						expression(14);
						}
						break;
					case 14:
						{
						_localctx = new OrExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(244);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(245);
						match(Or);
						setState(246);
						expression(13);
						}
						break;
					case 15:
						{
						_localctx = new TernaryExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(247);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(248);
						match(QMark);
						setState(249);
						expression(0);
						setState(250);
						match(Colon);
						setState(251);
						expression(12);
						}
						break;
					case 16:
						{
						_localctx = new InExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(253);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(254);
						match(In);
						setState(255);
						expression(11);
						}
						break;
					}
					} 
				}
				setState(260);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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

	public static class ListContext extends ParserRuleContext {
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitList(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			match(OBracket);
			setState(263);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Println) | (1L << Print) | (1L << Input) | (1L << Assert) | (1L << Size) | (1L << Return) | (1L << Null) | (1L << Excl) | (1L << Subtract) | (1L << OBracket) | (1L << OParen) | (1L << Bool) | (1L << Number) | (1L << Identifier) | (1L << String))) != 0)) {
				{
				setState(262);
				exprList();
				}
			}

			setState(265);
			match(CBracket);
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

	public static class IndexesContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public IndexesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).enterIndexes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rammListener ) ((rammListener)listener).exitIndexes(this);
		}
	}

	public final IndexesContext indexes() throws RecognitionException {
		IndexesContext _localctx = new IndexesContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_indexes);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(271); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(267);
					match(OBracket);
					setState(268);
					expression(0);
					setState(269);
					match(CBracket);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(273); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 26);
		case 1:
			return precpred(_ctx, 25);
		case 2:
			return precpred(_ctx, 24);
		case 3:
			return precpred(_ctx, 23);
		case 4:
			return precpred(_ctx, 22);
		case 5:
			return precpred(_ctx, 20);
		case 6:
			return precpred(_ctx, 19);
		case 7:
			return precpred(_ctx, 18);
		case 8:
			return precpred(_ctx, 17);
		case 9:
			return precpred(_ctx, 16);
		case 10:
			return precpred(_ctx, 15);
		case 11:
			return precpred(_ctx, 14);
		case 12:
			return precpred(_ctx, 13);
		case 13:
			return precpred(_ctx, 12);
		case 14:
			return precpred(_ctx, 11);
		case 15:
			return precpred(_ctx, 10);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\62\u0116\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\7\2\'\n\2\f\2\16\2*\13\2\3\2\3\2\3\3\3\3\7\3\60\n\3\f\3\16\3"+
		"\63\13\3\3\3\5\3\66\n\3\3\4\3\4\3\4\3\4\3\4\5\4=\n\4\3\5\3\5\5\5A\n\5"+
		"\3\5\3\5\3\5\3\6\3\6\3\6\5\6I\n\6\3\6\3\6\3\6\3\6\5\6O\n\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6a\n\6\3\7\3\7"+
		"\7\7e\n\7\f\7\16\7h\13\7\3\7\5\7k\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\5\13\u0082\n"+
		"\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\7\16\u009b\n\16\f\16\16\16\u009e\13"+
		"\16\3\17\3\17\3\17\7\17\u00a3\n\17\f\17\16\17\u00a6\13\17\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00b4\n\20\3\20"+
		"\3\20\5\20\u00b8\n\20\3\20\3\20\5\20\u00bc\n\20\3\20\3\20\5\20\u00c0\n"+
		"\20\3\20\3\20\3\20\3\20\5\20\u00c6\n\20\3\20\3\20\3\20\5\20\u00cb\n\20"+
		"\3\20\5\20\u00ce\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20"+
		"\u0103\n\20\f\20\16\20\u0106\13\20\3\21\3\21\5\21\u010a\n\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\6\22\u0112\n\22\r\22\16\22\u0113\3\22\2\3\36\23\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2\2\u013b\2(\3\2\2\2\4\61\3\2"+
		"\2\2\6<\3\2\2\2\b>\3\2\2\2\n`\3\2\2\2\fb\3\2\2\2\16n\3\2\2\2\20s\3\2\2"+
		"\2\22y\3\2\2\2\24}\3\2\2\2\26\u0087\3\2\2\2\30\u0091\3\2\2\2\32\u0097"+
		"\3\2\2\2\34\u009f\3\2\2\2\36\u00cd\3\2\2\2 \u0107\3\2\2\2\"\u0111\3\2"+
		"\2\2$%\13\2\2\2%\'\b\2\1\2&$\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)+"+
		"\3\2\2\2*(\3\2\2\2+,\7\2\2\3,\3\3\2\2\2-\60\5\6\4\2.\60\5\24\13\2/-\3"+
		"\2\2\2/.\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\65\3\2\2\2"+
		"\63\61\3\2\2\2\64\66\5\36\20\2\65\64\3\2\2\2\65\66\3\2\2\2\66\5\3\2\2"+
		"\2\67=\5\b\5\28=\5\n\6\29=\5\f\7\2:=\5\26\f\2;=\5\30\r\2<\67\3\2\2\2<"+
		"8\3\2\2\2<9\3\2\2\2<:\3\2\2\2<;\3\2\2\2=\7\3\2\2\2>@\7/\2\2?A\5\"\22\2"+
		"@?\3\2\2\2@A\3\2\2\2AB\3\2\2\2BC\7)\2\2CD\5\36\20\2D\t\3\2\2\2EF\7/\2"+
		"\2FH\7&\2\2GI\5\34\17\2HG\3\2\2\2HI\3\2\2\2IJ\3\2\2\2Ja\7\'\2\2KL\7\3"+
		"\2\2LN\7&\2\2MO\5\36\20\2NM\3\2\2\2NO\3\2\2\2OP\3\2\2\2Pa\7\'\2\2QR\7"+
		"\4\2\2RS\7&\2\2ST\5\36\20\2TU\7\'\2\2Ua\3\2\2\2VW\7\6\2\2WX\7&\2\2XY\5"+
		"\36\20\2YZ\7\'\2\2Za\3\2\2\2[\\\7\7\2\2\\]\7&\2\2]^\5\36\20\2^_\7\'\2"+
		"\2_a\3\2\2\2`E\3\2\2\2`K\3\2\2\2`Q\3\2\2\2`V\3\2\2\2`[\3\2\2\2a\13\3\2"+
		"\2\2bf\5\16\b\2ce\5\20\t\2dc\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2gj\3"+
		"\2\2\2hf\3\2\2\2ik\5\22\n\2ji\3\2\2\2jk\3\2\2\2kl\3\2\2\2lm\7\20\2\2m"+
		"\r\3\2\2\2no\7\t\2\2op\5\36\20\2pq\7\17\2\2qr\5\4\3\2r\17\3\2\2\2st\7"+
		"\n\2\2tu\7\t\2\2uv\5\36\20\2vw\7\17\2\2wx\5\4\3\2x\21\3\2\2\2yz\7\n\2"+
		"\2z{\7\17\2\2{|\5\4\3\2|\23\3\2\2\2}~\7\b\2\2~\177\7/\2\2\177\u0081\7"+
		"&\2\2\u0080\u0082\5\32\16\2\u0081\u0080\3\2\2\2\u0081\u0082\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\u0084\7\'\2\2\u0084\u0085\5\4\3\2\u0085\u0086\7\20"+
		"\2\2\u0086\25\3\2\2\2\u0087\u0088\7\f\2\2\u0088\u0089\7/\2\2\u0089\u008a"+
		"\7)\2\2\u008a\u008b\5\36\20\2\u008b\u008c\7\16\2\2\u008c\u008d\5\36\20"+
		"\2\u008d\u008e\7\17\2\2\u008e\u008f\5\4\3\2\u008f\u0090\7\20\2\2\u0090"+
		"\27\3\2\2\2\u0091\u0092\7\r\2\2\u0092\u0093\5\36\20\2\u0093\u0094\7\17"+
		"\2\2\u0094\u0095\5\4\3\2\u0095\u0096\7\20\2\2\u0096\31\3\2\2\2\u0097\u009c"+
		"\7/\2\2\u0098\u0099\7*\2\2\u0099\u009b\7/\2\2\u009a\u0098\3\2\2\2\u009b"+
		"\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\33\3\2\2"+
		"\2\u009e\u009c\3\2\2\2\u009f\u00a4\5\36\20\2\u00a0\u00a1\7*\2\2\u00a1"+
		"\u00a3\5\36\20\2\u00a2\u00a0\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3"+
		"\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\35\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7"+
		"\u00a8\b\20\1\2\u00a8\u00a9\7\36\2\2\u00a9\u00ce\5\36\20\36\u00aa\u00ab"+
		"\7\32\2\2\u00ab\u00ce\5\36\20\35\u00ac\u00ad\7\13\2\2\u00ad\u00ce\5\36"+
		"\20\27\u00ae\u00ce\7.\2\2\u00af\u00ce\7-\2\2\u00b0\u00ce\7\22\2\2\u00b1"+
		"\u00b3\5\n\6\2\u00b2\u00b4\5\"\22\2\u00b3\u00b2\3\2\2\2\u00b3\u00b4\3"+
		"\2\2\2\u00b4\u00ce\3\2\2\2\u00b5\u00b7\5 \21\2\u00b6\u00b8\5\"\22\2\u00b7"+
		"\u00b6\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00ce\3\2\2\2\u00b9\u00bb\7/"+
		"\2\2\u00ba\u00bc\5\"\22\2\u00bb\u00ba\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc"+
		"\u00ce\3\2\2\2\u00bd\u00bf\7\60\2\2\u00be\u00c0\5\"\22\2\u00bf\u00be\3"+
		"\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00ce\3\2\2\2\u00c1\u00c2\7&\2\2\u00c2"+
		"\u00c3\5\36\20\2\u00c3\u00c5\7\'\2\2\u00c4\u00c6\5\"\22\2\u00c5\u00c4"+
		"\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00ce\3\2\2\2\u00c7\u00c8\7\5\2\2\u00c8"+
		"\u00ca\7&\2\2\u00c9\u00cb\7\60\2\2\u00ca\u00c9\3\2\2\2\u00ca\u00cb\3\2"+
		"\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00ce\7\'\2\2\u00cd\u00a7\3\2\2\2\u00cd"+
		"\u00aa\3\2\2\2\u00cd\u00ac\3\2\2\2\u00cd\u00ae\3\2\2\2\u00cd\u00af\3\2"+
		"\2\2\u00cd\u00b0\3\2\2\2\u00cd\u00b1\3\2\2\2\u00cd\u00b5\3\2\2\2\u00cd"+
		"\u00b9\3\2\2\2\u00cd\u00bd\3\2\2\2\u00cd\u00c1\3\2\2\2\u00cd\u00c7\3\2"+
		"\2\2\u00ce\u0104\3\2\2\2\u00cf\u00d0\f\34\2\2\u00d0\u00d1\7\31\2\2\u00d1"+
		"\u0103\5\36\20\35\u00d2\u00d3\f\33\2\2\u00d3\u00d4\7\37\2\2\u00d4\u0103"+
		"\5\36\20\34\u00d5\u00d6\f\32\2\2\u00d6\u00d7\7 \2\2\u00d7\u0103\5\36\20"+
		"\33\u00d8\u00d9\f\31\2\2\u00d9\u00da\7!\2\2\u00da\u0103\5\36\20\32\u00db"+
		"\u00dc\f\30\2\2\u00dc\u00dd\7\35\2\2\u00dd\u0103\5\36\20\31\u00de\u00df"+
		"\f\26\2\2\u00df\u00e0\7\36\2\2\u00e0\u0103\5\36\20\27\u00e1\u00e2\f\25"+
		"\2\2\u00e2\u00e3\7\27\2\2\u00e3\u0103\5\36\20\26\u00e4\u00e5\f\24\2\2"+
		"\u00e5\u00e6\7\30\2\2\u00e6\u0103\5\36\20\25\u00e7\u00e8\f\23\2\2\u00e8"+
		"\u00e9\7\33\2\2\u00e9\u0103\5\36\20\24\u00ea\u00eb\f\22\2\2\u00eb\u00ec"+
		"\7\34\2\2\u00ec\u0103\5\36\20\23\u00ed\u00ee\f\21\2\2\u00ee\u00ef\7\25"+
		"\2\2\u00ef\u0103\5\36\20\22\u00f0\u00f1\f\20\2\2\u00f1\u00f2\7\26\2\2"+
		"\u00f2\u0103\5\36\20\21\u00f3\u00f4\f\17\2\2\u00f4\u00f5\7\24\2\2\u00f5"+
		"\u0103\5\36\20\20\u00f6\u00f7\f\16\2\2\u00f7\u00f8\7\23\2\2\u00f8\u0103"+
		"\5\36\20\17\u00f9\u00fa\f\r\2\2\u00fa\u00fb\7+\2\2\u00fb\u00fc\5\36\20"+
		"\2\u00fc\u00fd\7,\2\2\u00fd\u00fe\5\36\20\16\u00fe\u0103\3\2\2\2\u00ff"+
		"\u0100\f\f\2\2\u0100\u0101\7\21\2\2\u0101\u0103\5\36\20\r\u0102\u00cf"+
		"\3\2\2\2\u0102\u00d2\3\2\2\2\u0102\u00d5\3\2\2\2\u0102\u00d8\3\2\2\2\u0102"+
		"\u00db\3\2\2\2\u0102\u00de\3\2\2\2\u0102\u00e1\3\2\2\2\u0102\u00e4\3\2"+
		"\2\2\u0102\u00e7\3\2\2\2\u0102\u00ea\3\2\2\2\u0102\u00ed\3\2\2\2\u0102"+
		"\u00f0\3\2\2\2\u0102\u00f3\3\2\2\2\u0102\u00f6\3\2\2\2\u0102\u00f9\3\2"+
		"\2\2\u0102\u00ff\3\2\2\2\u0103\u0106\3\2\2\2\u0104\u0102\3\2\2\2\u0104"+
		"\u0105\3\2\2\2\u0105\37\3\2\2\2\u0106\u0104\3\2\2\2\u0107\u0109\7$\2\2"+
		"\u0108\u010a\5\34\17\2\u0109\u0108\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010b"+
		"\3\2\2\2\u010b\u010c\7%\2\2\u010c!\3\2\2\2\u010d\u010e\7$\2\2\u010e\u010f"+
		"\5\36\20\2\u010f\u0110\7%\2\2\u0110\u0112\3\2\2\2\u0111\u010d\3\2\2\2"+
		"\u0112\u0113\3\2\2\2\u0113\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114#\3"+
		"\2\2\2\33(/\61\65<@HN`fj\u0081\u009c\u00a4\u00b3\u00b7\u00bb\u00bf\u00c5"+
		"\u00ca\u00cd\u0102\u0104\u0109\u0113";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}