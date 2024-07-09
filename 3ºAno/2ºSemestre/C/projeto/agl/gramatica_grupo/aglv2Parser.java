// Generated from aglv2.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class aglv2Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, Boolean=40, ID=41, Number=42, String=43, COMMENT=44, MLCOMMENT=45, 
		WS=46, NL=47;
	public static final int
		RULE_program = 0, RULE_stat = 1, RULE_assignment = 2, RULE_instantiation = 3, 
		RULE_expr = 4, RULE_events = 5, RULE_event = 6, RULE_functions = 7, RULE_time = 8, 
		RULE_if_stat = 9, RULE_while_loop = 10, RULE_for_loop = 11, RULE_graphicalObject = 12, 
		RULE_view = 13, RULE_point = 14, RULE_vector = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "stat", "assignment", "instantiation", "expr", "events", "event", 
			"functions", "time", "if_stat", "while_loop", "for_loop", "graphicalObject", 
			"view", "point", "vector"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'='", "'.'", "':'", "'+'", "'-'", "'('", "')'", "'&&'", 
			"'||'", "'=='", "'!='", "'<'", "'<='", "'>'", "'>='", "'wait'", "'mouse click'", 
			"'input'", "'close'", "'refresh'", "'after'", "'print'", "'move'", "'by'", 
			"'ms'", "'s'", "'if'", "'{'", "'}'", "'else'", "'while'", "'for'", "'in'", 
			"'..'", "'do'", "'at'", "'with'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "Boolean", "ID", "Number", "String", "COMMENT", 
			"MLCOMMENT", "WS", "NL"
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
	public String getGrammarFileName() { return "aglv2.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public aglv2Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(aglv2Parser.EOF, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2487082811392L) != 0)) {
				{
				{
				setState(32);
				stat();
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(38);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatContext extends ParserRuleContext {
		public InstantiationContext instantiation() {
			return getRuleContext(InstantiationContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public FunctionsContext functions() {
			return getRuleContext(FunctionsContext.class,0);
		}
		public ViewContext view() {
			return getRuleContext(ViewContext.class,0);
		}
		public GraphicalObjectContext graphicalObject() {
			return getRuleContext(GraphicalObjectContext.class,0);
		}
		public For_loopContext for_loop() {
			return getRuleContext(For_loopContext.class,0);
		}
		public If_statContext if_stat() {
			return getRuleContext(If_statContext.class,0);
		}
		public While_loopContext while_loop() {
			return getRuleContext(While_loopContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitStat(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		try {
			setState(54);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				instantiation();
				setState(41);
				match(T__0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				assignment();
				setState(44);
				match(T__0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(46);
				functions();
				setState(47);
				match(T__0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(49);
				view();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(50);
				graphicalObject();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(51);
				for_loop();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(52);
				if_stat();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(53);
				while_loop();
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
	public static class AssignmentContext extends ParserRuleContext {
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	 
		public AssignmentContext() { }
		public void copyFrom(AssignmentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentInstatiationContext extends AssignmentContext {
		public InstantiationContext instantiation() {
			return getRuleContext(InstantiationContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignmentInstatiationContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterAssignmentInstatiation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitAssignmentInstatiation(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentExistingContext extends AssignmentContext {
		public TerminalNode ID() { return getToken(aglv2Parser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignmentExistingContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterAssignmentExisting(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitAssignmentExisting(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentObjectAttributeContext extends AssignmentContext {
		public List<TerminalNode> ID() { return getTokens(aglv2Parser.ID); }
		public TerminalNode ID(int i) {
			return getToken(aglv2Parser.ID, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignmentObjectAttributeContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterAssignmentObjectAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitAssignmentObjectAttribute(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_assignment);
		try {
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new AssignmentExistingContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				match(ID);
				setState(57);
				match(T__1);
				setState(58);
				expr(0);
				}
				break;
			case 2:
				_localctx = new AssignmentInstatiationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				instantiation();
				setState(60);
				match(T__1);
				setState(61);
				expr(0);
				}
				break;
			case 3:
				_localctx = new AssignmentObjectAttributeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(63);
				match(ID);
				setState(64);
				match(T__2);
				setState(65);
				match(ID);
				setState(66);
				match(T__1);
				setState(67);
				expr(0);
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
	public static class InstantiationContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(aglv2Parser.ID); }
		public TerminalNode ID(int i) {
			return getToken(aglv2Parser.ID, i);
		}
		public InstantiationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instantiation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterInstantiation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitInstantiation(this);
		}
	}

	public final InstantiationContext instantiation() throws RecognitionException {
		InstantiationContext _localctx = new InstantiationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_instantiation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(ID);
			setState(71);
			match(T__3);
			setState(72);
			match(ID);
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
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprBooleanANDContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprBooleanANDContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterExprBooleanAND(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitExprBooleanAND(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprEventContext extends ExprContext {
		public EventsContext events() {
			return getRuleContext(EventsContext.class,0);
		}
		public ExprEventContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterExprEvent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitExprEvent(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprUnaryOperatorContext extends ExprContext {
		public Token sign;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprUnaryOperatorContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterExprUnaryOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitExprUnaryOperator(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprRealNumberContext extends ExprContext {
		public TerminalNode Number() { return getToken(aglv2Parser.Number, 0); }
		public ExprRealNumberContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterExprRealNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitExprRealNumber(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprStringContext extends ExprContext {
		public TerminalNode String() { return getToken(aglv2Parser.String, 0); }
		public ExprStringContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterExprString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitExprString(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprPointContext extends ExprContext {
		public PointContext point() {
			return getRuleContext(PointContext.class,0);
		}
		public ExprPointContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterExprPoint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitExprPoint(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprBoolCompareContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprBoolCompareContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterExprBoolCompare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitExprBoolCompare(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprBooleanContext extends ExprContext {
		public TerminalNode Boolean() { return getToken(aglv2Parser.Boolean, 0); }
		public ExprBooleanContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterExprBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitExprBoolean(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprBooleanORContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprBooleanORContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterExprBooleanOR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitExprBooleanOR(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprParenthesisContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprParenthesisContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterExprParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitExprParenthesis(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprVectorContext extends ExprContext {
		public VectorContext vector() {
			return getRuleContext(VectorContext.class,0);
		}
		public ExprVectorContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterExprVector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitExprVector(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprOperationContext extends ExprContext {
		public ExprContext e1;
		public Token op;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprOperationContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterExprOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitExprOperation(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprIDContext extends ExprContext {
		public TerminalNode ID() { return getToken(aglv2Parser.ID, 0); }
		public ExprIDContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterExprID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitExprID(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				_localctx = new ExprUnaryOperatorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(75);
				((ExprUnaryOperatorContext)_localctx).sign = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__4 || _la==T__5) ) {
					((ExprUnaryOperatorContext)_localctx).sign = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(76);
				expr(12);
				}
				break;
			case 2:
				{
				_localctx = new ExprParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(77);
				match(T__6);
				setState(78);
				expr(0);
				setState(79);
				match(T__7);
				}
				break;
			case 3:
				{
				_localctx = new ExprEventContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(81);
				events();
				}
				break;
			case 4:
				{
				_localctx = new ExprPointContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(82);
				point();
				}
				break;
			case 5:
				{
				_localctx = new ExprVectorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(83);
				vector();
				}
				break;
			case 6:
				{
				_localctx = new ExprRealNumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(84);
				match(Number);
				}
				break;
			case 7:
				{
				_localctx = new ExprStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(85);
				match(String);
				}
				break;
			case 8:
				{
				_localctx = new ExprIDContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(86);
				match(ID);
				}
				break;
			case 9:
				{
				_localctx = new ExprBooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(87);
				match(Boolean);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(104);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(102);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new ExprOperationContext(new ExprContext(_parentctx, _parentState));
						((ExprOperationContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(90);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(91);
						((ExprOperationContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__4 || _la==T__5) ) {
							((ExprOperationContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(92);
						((ExprOperationContext)_localctx).e2 = expr(14);
						}
						break;
					case 2:
						{
						_localctx = new ExprBooleanANDContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(93);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(94);
						match(T__8);
						setState(95);
						expr(4);
						}
						break;
					case 3:
						{
						_localctx = new ExprBooleanORContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(96);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(97);
						match(T__9);
						setState(98);
						expr(3);
						}
						break;
					case 4:
						{
						_localctx = new ExprBoolCompareContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(99);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(100);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 129024L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(101);
						expr(2);
						}
						break;
					}
					} 
				}
				setState(106);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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
	public static class EventsContext extends ParserRuleContext {
		public EventContext event() {
			return getRuleContext(EventContext.class,0);
		}
		public EventsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_events; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterEvents(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitEvents(this);
		}
	}

	public final EventsContext events() throws RecognitionException {
		EventsContext _localctx = new EventsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_events);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(T__16);
			setState(108);
			event();
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
	public static class EventContext extends ParserRuleContext {
		public EventContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event; }
	 
		public EventContext() { }
		public void copyFrom(EventContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EventInputContext extends EventContext {
		public EventInputContext(EventContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterEventInput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitEventInput(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EventMouseClickContext extends EventContext {
		public EventMouseClickContext(EventContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterEventMouseClick(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitEventMouseClick(this);
		}
	}

	public final EventContext event() throws RecognitionException {
		EventContext _localctx = new EventContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_event);
		try {
			setState(112);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__17:
				_localctx = new EventMouseClickContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				match(T__17);
				}
				break;
			case T__18:
				_localctx = new EventInputContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				match(T__18);
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
	public static class FunctionsContext extends ParserRuleContext {
		public FunctionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functions; }
	 
		public FunctionsContext() { }
		public void copyFrom(FunctionsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionMoveVectorContext extends FunctionsContext {
		public TerminalNode ID() { return getToken(aglv2Parser.ID, 0); }
		public PointContext point() {
			return getRuleContext(PointContext.class,0);
		}
		public FunctionMoveVectorContext(FunctionsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterFunctionMoveVector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitFunctionMoveVector(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionPrintContext extends FunctionsContext {
		public List<TerminalNode> String() { return getTokens(aglv2Parser.String); }
		public TerminalNode String(int i) {
			return getToken(aglv2Parser.String, i);
		}
		public List<TerminalNode> ID() { return getTokens(aglv2Parser.ID); }
		public TerminalNode ID(int i) {
			return getToken(aglv2Parser.ID, i);
		}
		public FunctionPrintContext(FunctionsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterFunctionPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitFunctionPrint(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCloseContext extends FunctionsContext {
		public TerminalNode ID() { return getToken(aglv2Parser.ID, 0); }
		public FunctionCloseContext(FunctionsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterFunctionClose(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitFunctionClose(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionMoveIDContext extends FunctionsContext {
		public List<TerminalNode> ID() { return getTokens(aglv2Parser.ID); }
		public TerminalNode ID(int i) {
			return getToken(aglv2Parser.ID, i);
		}
		public FunctionMoveIDContext(FunctionsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterFunctionMoveID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitFunctionMoveID(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionRefreshTimeContext extends FunctionsContext {
		public TerminalNode ID() { return getToken(aglv2Parser.ID, 0); }
		public TimeContext time() {
			return getRuleContext(TimeContext.class,0);
		}
		public FunctionRefreshTimeContext(FunctionsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterFunctionRefreshTime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitFunctionRefreshTime(this);
		}
	}

	public final FunctionsContext functions() throws RecognitionException {
		FunctionsContext _localctx = new FunctionsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_functions);
		int _la;
		try {
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new FunctionCloseContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				match(T__19);
				setState(115);
				match(ID);
				}
				break;
			case 2:
				_localctx = new FunctionRefreshTimeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				match(T__20);
				setState(117);
				match(ID);
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__21) {
					{
					setState(118);
					match(T__21);
					setState(119);
					time();
					}
				}

				}
				break;
			case 3:
				_localctx = new FunctionPrintContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(122);
				match(T__22);
				setState(124); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(123);
					_la = _input.LA(1);
					if ( !(_la==ID || _la==String) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					setState(126); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID || _la==String );
				}
				break;
			case 4:
				_localctx = new FunctionMoveVectorContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(128);
				match(T__23);
				setState(129);
				match(ID);
				setState(130);
				match(T__24);
				setState(131);
				point();
				}
				break;
			case 5:
				_localctx = new FunctionMoveIDContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(132);
				match(T__23);
				setState(133);
				match(ID);
				setState(134);
				match(T__24);
				setState(135);
				match(ID);
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
	public static class TimeContext extends ParserRuleContext {
		public Token ts;
		public TerminalNode Number() { return getToken(aglv2Parser.Number, 0); }
		public TimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterTime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitTime(this);
		}
	}

	public final TimeContext time() throws RecognitionException {
		TimeContext _localctx = new TimeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_time);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(Number);
			setState(139);
			((TimeContext)_localctx).ts = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__25 || _la==T__26) ) {
				((TimeContext)_localctx).ts = (Token)_errHandler.recoverInline(this);
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
	public static class If_statContext extends ParserRuleContext {
		public If_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stat; }
	 
		public If_statContext() { }
		public void copyFrom(If_statContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfElseStatContext extends If_statContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public IfElseStatContext(If_statContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterIfElseStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitIfElseStat(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfElseIfContext extends If_statContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public If_statContext if_stat() {
			return getRuleContext(If_statContext.class,0);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public IfElseIfContext(If_statContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterIfElseIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitIfElseIf(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfStatContext extends If_statContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public IfStatContext(If_statContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitIfStat(this);
		}
	}

	public final If_statContext if_stat() throws RecognitionException {
		If_statContext _localctx = new If_statContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_if_stat);
		int _la;
		try {
			setState(191);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new IfStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(141);
				match(T__27);
				setState(142);
				match(T__6);
				setState(143);
				expr(0);
				setState(144);
				match(T__7);
				setState(145);
				match(T__28);
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2487082811392L) != 0)) {
					{
					{
					setState(146);
					stat();
					}
					}
					setState(151);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(152);
				match(T__29);
				}
				break;
			case 2:
				_localctx = new IfElseIfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
				match(T__27);
				setState(155);
				match(T__6);
				setState(156);
				expr(0);
				setState(157);
				match(T__7);
				setState(158);
				match(T__28);
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2487082811392L) != 0)) {
					{
					{
					setState(159);
					stat();
					}
					}
					setState(164);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(165);
				match(T__29);
				setState(166);
				match(T__30);
				setState(167);
				if_stat();
				}
				break;
			case 3:
				_localctx = new IfElseStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(169);
				match(T__27);
				setState(170);
				match(T__6);
				setState(171);
				expr(0);
				setState(172);
				match(T__7);
				setState(173);
				match(T__28);
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2487082811392L) != 0)) {
					{
					{
					setState(174);
					stat();
					}
					}
					setState(179);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(180);
				match(T__29);
				setState(181);
				match(T__30);
				setState(182);
				match(T__28);
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2487082811392L) != 0)) {
					{
					{
					setState(183);
					stat();
					}
					}
					setState(188);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(189);
				match(T__29);
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
	public static class While_loopContext extends ParserRuleContext {
		public While_loopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_loop; }
	 
		public While_loopContext() { }
		public void copyFrom(While_loopContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileLoopContext extends While_loopContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public WhileLoopContext(While_loopContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterWhileLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitWhileLoop(this);
		}
	}

	public final While_loopContext while_loop() throws RecognitionException {
		While_loopContext _localctx = new While_loopContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_while_loop);
		int _la;
		try {
			_localctx = new WhileLoopContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			match(T__31);
			setState(194);
			match(T__6);
			setState(195);
			expr(0);
			setState(196);
			match(T__7);
			setState(197);
			match(T__28);
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2487082811392L) != 0)) {
				{
				{
				setState(198);
				stat();
				}
				}
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(204);
			match(T__29);
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
	public static class For_loopContext extends ParserRuleContext {
		public For_loopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_loop; }
	 
		public For_loopContext() { }
		public void copyFrom(For_loopContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForLoopContext extends For_loopContext {
		public TerminalNode ID() { return getToken(aglv2Parser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ForLoopContext(For_loopContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterForLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitForLoop(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForRangeContext extends For_loopContext {
		public Token from;
		public Token to;
		public TerminalNode ID() { return getToken(aglv2Parser.ID, 0); }
		public List<TerminalNode> Number() { return getTokens(aglv2Parser.Number); }
		public TerminalNode Number(int i) {
			return getToken(aglv2Parser.Number, i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ForRangeContext(For_loopContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterForRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitForRange(this);
		}
	}

	public final For_loopContext for_loop() throws RecognitionException {
		For_loopContext _localctx = new For_loopContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_for_loop);
		int _la;
		try {
			setState(240);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new ForLoopContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(206);
				match(T__32);
				setState(207);
				match(T__6);
				setState(208);
				match(ID);
				setState(209);
				match(T__1);
				setState(210);
				expr(0);
				setState(211);
				match(T__0);
				setState(212);
				expr(0);
				setState(213);
				match(T__0);
				setState(214);
				expr(0);
				setState(215);
				match(T__7);
				setState(216);
				match(T__28);
				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2487082811392L) != 0)) {
					{
					{
					setState(217);
					stat();
					}
					}
					setState(222);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(223);
				match(T__29);
				}
				break;
			case 2:
				_localctx = new ForRangeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(225);
				match(T__32);
				setState(226);
				match(ID);
				setState(227);
				match(T__33);
				setState(228);
				((ForRangeContext)_localctx).from = match(Number);
				setState(229);
				match(T__34);
				setState(230);
				((ForRangeContext)_localctx).to = match(Number);
				setState(231);
				match(T__35);
				setState(232);
				match(T__28);
				setState(236);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2487082811392L) != 0)) {
					{
					{
					setState(233);
					stat();
					}
					}
					setState(238);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(239);
				match(T__29);
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
	public static class GraphicalObjectContext extends ParserRuleContext {
		public GraphicalObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_graphicalObject; }
	 
		public GraphicalObjectContext() { }
		public void copyFrom(GraphicalObjectContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GraphicalObjectInstatiationCoordsContext extends GraphicalObjectContext {
		public PointContext point() {
			return getRuleContext(PointContext.class,0);
		}
		public TerminalNode ID() { return getToken(aglv2Parser.ID, 0); }
		public InstantiationContext instantiation() {
			return getRuleContext(InstantiationContext.class,0);
		}
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public GraphicalObjectInstatiationCoordsContext(GraphicalObjectContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterGraphicalObjectInstatiationCoords(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitGraphicalObjectInstatiationCoords(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GraphicalObjectUpdateContext extends GraphicalObjectContext {
		public TerminalNode ID() { return getToken(aglv2Parser.ID, 0); }
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public GraphicalObjectUpdateContext(GraphicalObjectContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterGraphicalObjectUpdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitGraphicalObjectUpdate(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GraphicalObjectInstatiationIDContext extends GraphicalObjectContext {
		public List<TerminalNode> ID() { return getTokens(aglv2Parser.ID); }
		public TerminalNode ID(int i) {
			return getToken(aglv2Parser.ID, i);
		}
		public InstantiationContext instantiation() {
			return getRuleContext(InstantiationContext.class,0);
		}
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public GraphicalObjectInstatiationIDContext(GraphicalObjectContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterGraphicalObjectInstatiationID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitGraphicalObjectInstatiationID(this);
		}
	}

	public final GraphicalObjectContext graphicalObject() throws RecognitionException {
		GraphicalObjectContext _localctx = new GraphicalObjectContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_graphicalObject);
		int _la;
		try {
			setState(290);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				_localctx = new GraphicalObjectInstatiationCoordsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(244);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(242);
					match(ID);
					}
					break;
				case 2:
					{
					setState(243);
					instantiation();
					}
					break;
				}
				setState(246);
				match(T__36);
				setState(247);
				point();
				setState(248);
				match(T__37);
				setState(249);
				match(T__28);
				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(250);
					assignment();
					setState(251);
					match(T__0);
					}
					}
					setState(257);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(258);
				match(T__29);
				}
				break;
			case 2:
				_localctx = new GraphicalObjectInstatiationIDContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(262);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(260);
					match(ID);
					}
					break;
				case 2:
					{
					setState(261);
					instantiation();
					}
					break;
				}
				setState(264);
				match(T__36);
				setState(265);
				match(ID);
				setState(266);
				match(T__37);
				setState(267);
				match(T__28);
				setState(273);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(268);
					assignment();
					setState(269);
					match(T__0);
					}
					}
					setState(275);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(276);
				match(T__29);
				}
				break;
			case 3:
				_localctx = new GraphicalObjectUpdateContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(277);
				match(T__37);
				setState(278);
				match(ID);
				setState(279);
				match(T__35);
				setState(280);
				match(T__28);
				setState(286);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(281);
					assignment();
					setState(282);
					match(T__0);
					}
					}
					setState(288);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(289);
				match(T__29);
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
	public static class ViewContext extends ParserRuleContext {
		public InstantiationContext instantiation() {
			return getRuleContext(InstantiationContext.class,0);
		}
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public ViewContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_view; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterView(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitView(this);
		}
	}

	public final ViewContext view() throws RecognitionException {
		ViewContext _localctx = new ViewContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_view);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			instantiation();
			setState(293);
			match(T__37);
			setState(294);
			match(T__28);
			setState(300);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(295);
				assignment();
				setState(296);
				match(T__0);
				}
				}
				setState(302);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(303);
			match(T__29);
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
	public static class PointContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public PointContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_point; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterPoint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitPoint(this);
		}
	}

	public final PointContext point() throws RecognitionException {
		PointContext _localctx = new PointContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_point);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			match(T__6);
			setState(306);
			expr(0);
			setState(307);
			match(T__38);
			setState(308);
			expr(0);
			setState(309);
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
	public static class VectorContext extends ParserRuleContext {
		public VectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vector; }
	 
		public VectorContext() { }
		public void copyFrom(VectorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VectorPointContext extends VectorContext {
		public PointContext point() {
			return getRuleContext(PointContext.class,0);
		}
		public VectorPointContext(VectorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterVectorPoint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitVectorPoint(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VectorPolarContext extends VectorContext {
		public List<TerminalNode> Number() { return getTokens(aglv2Parser.Number); }
		public TerminalNode Number(int i) {
			return getToken(aglv2Parser.Number, i);
		}
		public VectorPolarContext(VectorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).enterVectorPolar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof aglv2Listener ) ((aglv2Listener)listener).exitVectorPolar(this);
		}
	}

	public final VectorContext vector() throws RecognitionException {
		VectorContext _localctx = new VectorContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_vector);
		try {
			setState(317);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				_localctx = new VectorPointContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(311);
				point();
				}
				break;
			case 2:
				_localctx = new VectorPolarContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(312);
				match(T__6);
				setState(313);
				match(Number);
				setState(314);
				match(T__3);
				setState(315);
				match(Number);
				setState(316);
				match(T__7);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001/\u0140\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0001\u0000\u0005\u0000\"\b\u0000\n\u0000\f\u0000%\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00017\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"E\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004Y\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004g\b\u0004\n\u0004\f\u0004"+
		"j\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0003\u0006q\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007y\b\u0007\u0001\u0007\u0001\u0007"+
		"\u0004\u0007}\b\u0007\u000b\u0007\f\u0007~\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007\u0089\b\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0005\t\u0094\b\t\n\t\f\t\u0097\t\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u00a1\b\t\n\t"+
		"\f\t\u00a4\t\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0005\t\u00b0\b\t\n\t\f\t\u00b3\t\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0005\t\u00b9\b\t\n\t\f\t\u00bc\t\t\u0001\t\u0001\t"+
		"\u0003\t\u00c0\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005"+
		"\n\u00c8\b\n\n\n\f\n\u00cb\t\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00db\b\u000b"+
		"\n\u000b\f\u000b\u00de\t\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0005\u000b\u00eb\b\u000b\n\u000b\f\u000b\u00ee\t\u000b"+
		"\u0001\u000b\u0003\u000b\u00f1\b\u000b\u0001\f\u0001\f\u0003\f\u00f5\b"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u00fe"+
		"\b\f\n\f\f\f\u0101\t\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u0107\b"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u0110"+
		"\b\f\n\f\f\f\u0113\t\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0005\f\u011d\b\f\n\f\f\f\u0120\t\f\u0001\f\u0003\f\u0123"+
		"\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u012b\b\r"+
		"\n\r\f\r\u012e\t\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u013e\b\u000f\u0001\u000f"+
		"\u0000\u0001\b\u0010\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e\u0000\u0004\u0001\u0000\u0005\u0006\u0001"+
		"\u0000\u000b\u0010\u0002\u0000))++\u0001\u0000\u001a\u001b\u015f\u0000"+
		"#\u0001\u0000\u0000\u0000\u00026\u0001\u0000\u0000\u0000\u0004D\u0001"+
		"\u0000\u0000\u0000\u0006F\u0001\u0000\u0000\u0000\bX\u0001\u0000\u0000"+
		"\u0000\nk\u0001\u0000\u0000\u0000\fp\u0001\u0000\u0000\u0000\u000e\u0088"+
		"\u0001\u0000\u0000\u0000\u0010\u008a\u0001\u0000\u0000\u0000\u0012\u00bf"+
		"\u0001\u0000\u0000\u0000\u0014\u00c1\u0001\u0000\u0000\u0000\u0016\u00f0"+
		"\u0001\u0000\u0000\u0000\u0018\u0122\u0001\u0000\u0000\u0000\u001a\u0124"+
		"\u0001\u0000\u0000\u0000\u001c\u0131\u0001\u0000\u0000\u0000\u001e\u013d"+
		"\u0001\u0000\u0000\u0000 \"\u0003\u0002\u0001\u0000! \u0001\u0000\u0000"+
		"\u0000\"%\u0001\u0000\u0000\u0000#!\u0001\u0000\u0000\u0000#$\u0001\u0000"+
		"\u0000\u0000$&\u0001\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000&\'\u0005"+
		"\u0000\u0000\u0001\'\u0001\u0001\u0000\u0000\u0000()\u0003\u0006\u0003"+
		"\u0000)*\u0005\u0001\u0000\u0000*7\u0001\u0000\u0000\u0000+,\u0003\u0004"+
		"\u0002\u0000,-\u0005\u0001\u0000\u0000-7\u0001\u0000\u0000\u0000./\u0003"+
		"\u000e\u0007\u0000/0\u0005\u0001\u0000\u000007\u0001\u0000\u0000\u0000"+
		"17\u0003\u001a\r\u000027\u0003\u0018\f\u000037\u0003\u0016\u000b\u0000"+
		"47\u0003\u0012\t\u000057\u0003\u0014\n\u00006(\u0001\u0000\u0000\u0000"+
		"6+\u0001\u0000\u0000\u00006.\u0001\u0000\u0000\u000061\u0001\u0000\u0000"+
		"\u000062\u0001\u0000\u0000\u000063\u0001\u0000\u0000\u000064\u0001\u0000"+
		"\u0000\u000065\u0001\u0000\u0000\u00007\u0003\u0001\u0000\u0000\u0000"+
		"89\u0005)\u0000\u00009:\u0005\u0002\u0000\u0000:E\u0003\b\u0004\u0000"+
		";<\u0003\u0006\u0003\u0000<=\u0005\u0002\u0000\u0000=>\u0003\b\u0004\u0000"+
		">E\u0001\u0000\u0000\u0000?@\u0005)\u0000\u0000@A\u0005\u0003\u0000\u0000"+
		"AB\u0005)\u0000\u0000BC\u0005\u0002\u0000\u0000CE\u0003\b\u0004\u0000"+
		"D8\u0001\u0000\u0000\u0000D;\u0001\u0000\u0000\u0000D?\u0001\u0000\u0000"+
		"\u0000E\u0005\u0001\u0000\u0000\u0000FG\u0005)\u0000\u0000GH\u0005\u0004"+
		"\u0000\u0000HI\u0005)\u0000\u0000I\u0007\u0001\u0000\u0000\u0000JK\u0006"+
		"\u0004\uffff\uffff\u0000KL\u0007\u0000\u0000\u0000LY\u0003\b\u0004\fM"+
		"N\u0005\u0007\u0000\u0000NO\u0003\b\u0004\u0000OP\u0005\b\u0000\u0000"+
		"PY\u0001\u0000\u0000\u0000QY\u0003\n\u0005\u0000RY\u0003\u001c\u000e\u0000"+
		"SY\u0003\u001e\u000f\u0000TY\u0005*\u0000\u0000UY\u0005+\u0000\u0000V"+
		"Y\u0005)\u0000\u0000WY\u0005(\u0000\u0000XJ\u0001\u0000\u0000\u0000XM"+
		"\u0001\u0000\u0000\u0000XQ\u0001\u0000\u0000\u0000XR\u0001\u0000\u0000"+
		"\u0000XS\u0001\u0000\u0000\u0000XT\u0001\u0000\u0000\u0000XU\u0001\u0000"+
		"\u0000\u0000XV\u0001\u0000\u0000\u0000XW\u0001\u0000\u0000\u0000Yh\u0001"+
		"\u0000\u0000\u0000Z[\n\r\u0000\u0000[\\\u0007\u0000\u0000\u0000\\g\u0003"+
		"\b\u0004\u000e]^\n\u0003\u0000\u0000^_\u0005\t\u0000\u0000_g\u0003\b\u0004"+
		"\u0004`a\n\u0002\u0000\u0000ab\u0005\n\u0000\u0000bg\u0003\b\u0004\u0003"+
		"cd\n\u0001\u0000\u0000de\u0007\u0001\u0000\u0000eg\u0003\b\u0004\u0002"+
		"fZ\u0001\u0000\u0000\u0000f]\u0001\u0000\u0000\u0000f`\u0001\u0000\u0000"+
		"\u0000fc\u0001\u0000\u0000\u0000gj\u0001\u0000\u0000\u0000hf\u0001\u0000"+
		"\u0000\u0000hi\u0001\u0000\u0000\u0000i\t\u0001\u0000\u0000\u0000jh\u0001"+
		"\u0000\u0000\u0000kl\u0005\u0011\u0000\u0000lm\u0003\f\u0006\u0000m\u000b"+
		"\u0001\u0000\u0000\u0000nq\u0005\u0012\u0000\u0000oq\u0005\u0013\u0000"+
		"\u0000pn\u0001\u0000\u0000\u0000po\u0001\u0000\u0000\u0000q\r\u0001\u0000"+
		"\u0000\u0000rs\u0005\u0014\u0000\u0000s\u0089\u0005)\u0000\u0000tu\u0005"+
		"\u0015\u0000\u0000ux\u0005)\u0000\u0000vw\u0005\u0016\u0000\u0000wy\u0003"+
		"\u0010\b\u0000xv\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000y\u0089"+
		"\u0001\u0000\u0000\u0000z|\u0005\u0017\u0000\u0000{}\u0007\u0002\u0000"+
		"\u0000|{\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~|\u0001\u0000"+
		"\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0089\u0001\u0000\u0000"+
		"\u0000\u0080\u0081\u0005\u0018\u0000\u0000\u0081\u0082\u0005)\u0000\u0000"+
		"\u0082\u0083\u0005\u0019\u0000\u0000\u0083\u0089\u0003\u001c\u000e\u0000"+
		"\u0084\u0085\u0005\u0018\u0000\u0000\u0085\u0086\u0005)\u0000\u0000\u0086"+
		"\u0087\u0005\u0019\u0000\u0000\u0087\u0089\u0005)\u0000\u0000\u0088r\u0001"+
		"\u0000\u0000\u0000\u0088t\u0001\u0000\u0000\u0000\u0088z\u0001\u0000\u0000"+
		"\u0000\u0088\u0080\u0001\u0000\u0000\u0000\u0088\u0084\u0001\u0000\u0000"+
		"\u0000\u0089\u000f\u0001\u0000\u0000\u0000\u008a\u008b\u0005*\u0000\u0000"+
		"\u008b\u008c\u0007\u0003\u0000\u0000\u008c\u0011\u0001\u0000\u0000\u0000"+
		"\u008d\u008e\u0005\u001c\u0000\u0000\u008e\u008f\u0005\u0007\u0000\u0000"+
		"\u008f\u0090\u0003\b\u0004\u0000\u0090\u0091\u0005\b\u0000\u0000\u0091"+
		"\u0095\u0005\u001d\u0000\u0000\u0092\u0094\u0003\u0002\u0001\u0000\u0093"+
		"\u0092\u0001\u0000\u0000\u0000\u0094\u0097\u0001\u0000\u0000\u0000\u0095"+
		"\u0093\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096"+
		"\u0098\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0098"+
		"\u0099\u0005\u001e\u0000\u0000\u0099\u00c0\u0001\u0000\u0000\u0000\u009a"+
		"\u009b\u0005\u001c\u0000\u0000\u009b\u009c\u0005\u0007\u0000\u0000\u009c"+
		"\u009d\u0003\b\u0004\u0000\u009d\u009e\u0005\b\u0000\u0000\u009e\u00a2"+
		"\u0005\u001d\u0000\u0000\u009f\u00a1\u0003\u0002\u0001\u0000\u00a0\u009f"+
		"\u0001\u0000\u0000\u0000\u00a1\u00a4\u0001\u0000\u0000\u0000\u00a2\u00a0"+
		"\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u00a5"+
		"\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a5\u00a6"+
		"\u0005\u001e\u0000\u0000\u00a6\u00a7\u0005\u001f\u0000\u0000\u00a7\u00a8"+
		"\u0003\u0012\t\u0000\u00a8\u00c0\u0001\u0000\u0000\u0000\u00a9\u00aa\u0005"+
		"\u001c\u0000\u0000\u00aa\u00ab\u0005\u0007\u0000\u0000\u00ab\u00ac\u0003"+
		"\b\u0004\u0000\u00ac\u00ad\u0005\b\u0000\u0000\u00ad\u00b1\u0005\u001d"+
		"\u0000\u0000\u00ae\u00b0\u0003\u0002\u0001\u0000\u00af\u00ae\u0001\u0000"+
		"\u0000\u0000\u00b0\u00b3\u0001\u0000\u0000\u0000\u00b1\u00af\u0001\u0000"+
		"\u0000\u0000\u00b1\u00b2\u0001\u0000\u0000\u0000\u00b2\u00b4\u0001\u0000"+
		"\u0000\u0000\u00b3\u00b1\u0001\u0000\u0000\u0000\u00b4\u00b5\u0005\u001e"+
		"\u0000\u0000\u00b5\u00b6\u0005\u001f\u0000\u0000\u00b6\u00ba\u0005\u001d"+
		"\u0000\u0000\u00b7\u00b9\u0003\u0002\u0001\u0000\u00b8\u00b7\u0001\u0000"+
		"\u0000\u0000\u00b9\u00bc\u0001\u0000\u0000\u0000\u00ba\u00b8\u0001\u0000"+
		"\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb\u00bd\u0001\u0000"+
		"\u0000\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000\u00bd\u00be\u0005\u001e"+
		"\u0000\u0000\u00be\u00c0\u0001\u0000\u0000\u0000\u00bf\u008d\u0001\u0000"+
		"\u0000\u0000\u00bf\u009a\u0001\u0000\u0000\u0000\u00bf\u00a9\u0001\u0000"+
		"\u0000\u0000\u00c0\u0013\u0001\u0000\u0000\u0000\u00c1\u00c2\u0005 \u0000"+
		"\u0000\u00c2\u00c3\u0005\u0007\u0000\u0000\u00c3\u00c4\u0003\b\u0004\u0000"+
		"\u00c4\u00c5\u0005\b\u0000\u0000\u00c5\u00c9\u0005\u001d\u0000\u0000\u00c6"+
		"\u00c8\u0003\u0002\u0001\u0000\u00c7\u00c6\u0001\u0000\u0000\u0000\u00c8"+
		"\u00cb\u0001\u0000\u0000\u0000\u00c9\u00c7\u0001\u0000\u0000\u0000\u00c9"+
		"\u00ca\u0001\u0000\u0000\u0000\u00ca\u00cc\u0001\u0000\u0000\u0000\u00cb"+
		"\u00c9\u0001\u0000\u0000\u0000\u00cc\u00cd\u0005\u001e\u0000\u0000\u00cd"+
		"\u0015\u0001\u0000\u0000\u0000\u00ce\u00cf\u0005!\u0000\u0000\u00cf\u00d0"+
		"\u0005\u0007\u0000\u0000\u00d0\u00d1\u0005)\u0000\u0000\u00d1\u00d2\u0005"+
		"\u0002\u0000\u0000\u00d2\u00d3\u0003\b\u0004\u0000\u00d3\u00d4\u0005\u0001"+
		"\u0000\u0000\u00d4\u00d5\u0003\b\u0004\u0000\u00d5\u00d6\u0005\u0001\u0000"+
		"\u0000\u00d6\u00d7\u0003\b\u0004\u0000\u00d7\u00d8\u0005\b\u0000\u0000"+
		"\u00d8\u00dc\u0005\u001d\u0000\u0000\u00d9\u00db\u0003\u0002\u0001\u0000"+
		"\u00da\u00d9\u0001\u0000\u0000\u0000\u00db\u00de\u0001\u0000\u0000\u0000"+
		"\u00dc\u00da\u0001\u0000\u0000\u0000\u00dc\u00dd\u0001\u0000\u0000\u0000"+
		"\u00dd\u00df\u0001\u0000\u0000\u0000\u00de\u00dc\u0001\u0000\u0000\u0000"+
		"\u00df\u00e0\u0005\u001e\u0000\u0000\u00e0\u00f1\u0001\u0000\u0000\u0000"+
		"\u00e1\u00e2\u0005!\u0000\u0000\u00e2\u00e3\u0005)\u0000\u0000\u00e3\u00e4"+
		"\u0005\"\u0000\u0000\u00e4\u00e5\u0005*\u0000\u0000\u00e5\u00e6\u0005"+
		"#\u0000\u0000\u00e6\u00e7\u0005*\u0000\u0000\u00e7\u00e8\u0005$\u0000"+
		"\u0000\u00e8\u00ec\u0005\u001d\u0000\u0000\u00e9\u00eb\u0003\u0002\u0001"+
		"\u0000\u00ea\u00e9\u0001\u0000\u0000\u0000\u00eb\u00ee\u0001\u0000\u0000"+
		"\u0000\u00ec\u00ea\u0001\u0000\u0000\u0000\u00ec\u00ed\u0001\u0000\u0000"+
		"\u0000\u00ed\u00ef\u0001\u0000\u0000\u0000\u00ee\u00ec\u0001\u0000\u0000"+
		"\u0000\u00ef\u00f1\u0005\u001e\u0000\u0000\u00f0\u00ce\u0001\u0000\u0000"+
		"\u0000\u00f0\u00e1\u0001\u0000\u0000\u0000\u00f1\u0017\u0001\u0000\u0000"+
		"\u0000\u00f2\u00f5\u0005)\u0000\u0000\u00f3\u00f5\u0003\u0006\u0003\u0000"+
		"\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f4\u00f3\u0001\u0000\u0000\u0000"+
		"\u00f5\u00f6\u0001\u0000\u0000\u0000\u00f6\u00f7\u0005%\u0000\u0000\u00f7"+
		"\u00f8\u0003\u001c\u000e\u0000\u00f8\u00f9\u0005&\u0000\u0000\u00f9\u00ff"+
		"\u0005\u001d\u0000\u0000\u00fa\u00fb\u0003\u0004\u0002\u0000\u00fb\u00fc"+
		"\u0005\u0001\u0000\u0000\u00fc\u00fe\u0001\u0000\u0000\u0000\u00fd\u00fa"+
		"\u0001\u0000\u0000\u0000\u00fe\u0101\u0001\u0000\u0000\u0000\u00ff\u00fd"+
		"\u0001\u0000\u0000\u0000\u00ff\u0100\u0001\u0000\u0000\u0000\u0100\u0102"+
		"\u0001\u0000\u0000\u0000\u0101\u00ff\u0001\u0000\u0000\u0000\u0102\u0103"+
		"\u0005\u001e\u0000\u0000\u0103\u0123\u0001\u0000\u0000\u0000\u0104\u0107"+
		"\u0005)\u0000\u0000\u0105\u0107\u0003\u0006\u0003\u0000\u0106\u0104\u0001"+
		"\u0000\u0000\u0000\u0106\u0105\u0001\u0000\u0000\u0000\u0107\u0108\u0001"+
		"\u0000\u0000\u0000\u0108\u0109\u0005%\u0000\u0000\u0109\u010a\u0005)\u0000"+
		"\u0000\u010a\u010b\u0005&\u0000\u0000\u010b\u0111\u0005\u001d\u0000\u0000"+
		"\u010c\u010d\u0003\u0004\u0002\u0000\u010d\u010e\u0005\u0001\u0000\u0000"+
		"\u010e\u0110\u0001\u0000\u0000\u0000\u010f\u010c\u0001\u0000\u0000\u0000"+
		"\u0110\u0113\u0001\u0000\u0000\u0000\u0111\u010f\u0001\u0000\u0000\u0000"+
		"\u0111\u0112\u0001\u0000\u0000\u0000\u0112\u0114\u0001\u0000\u0000\u0000"+
		"\u0113\u0111\u0001\u0000\u0000\u0000\u0114\u0123\u0005\u001e\u0000\u0000"+
		"\u0115\u0116\u0005&\u0000\u0000\u0116\u0117\u0005)\u0000\u0000\u0117\u0118"+
		"\u0005$\u0000\u0000\u0118\u011e\u0005\u001d\u0000\u0000\u0119\u011a\u0003"+
		"\u0004\u0002\u0000\u011a\u011b\u0005\u0001\u0000\u0000\u011b\u011d\u0001"+
		"\u0000\u0000\u0000\u011c\u0119\u0001\u0000\u0000\u0000\u011d\u0120\u0001"+
		"\u0000\u0000\u0000\u011e\u011c\u0001\u0000\u0000\u0000\u011e\u011f\u0001"+
		"\u0000\u0000\u0000\u011f\u0121\u0001\u0000\u0000\u0000\u0120\u011e\u0001"+
		"\u0000\u0000\u0000\u0121\u0123\u0005\u001e\u0000\u0000\u0122\u00f4\u0001"+
		"\u0000\u0000\u0000\u0122\u0106\u0001\u0000\u0000\u0000\u0122\u0115\u0001"+
		"\u0000\u0000\u0000\u0123\u0019\u0001\u0000\u0000\u0000\u0124\u0125\u0003"+
		"\u0006\u0003\u0000\u0125\u0126\u0005&\u0000\u0000\u0126\u012c\u0005\u001d"+
		"\u0000\u0000\u0127\u0128\u0003\u0004\u0002\u0000\u0128\u0129\u0005\u0001"+
		"\u0000\u0000\u0129\u012b\u0001\u0000\u0000\u0000\u012a\u0127\u0001\u0000"+
		"\u0000\u0000\u012b\u012e\u0001\u0000\u0000\u0000\u012c\u012a\u0001\u0000"+
		"\u0000\u0000\u012c\u012d\u0001\u0000\u0000\u0000\u012d\u012f\u0001\u0000"+
		"\u0000\u0000\u012e\u012c\u0001\u0000\u0000\u0000\u012f\u0130\u0005\u001e"+
		"\u0000\u0000\u0130\u001b\u0001\u0000\u0000\u0000\u0131\u0132\u0005\u0007"+
		"\u0000\u0000\u0132\u0133\u0003\b\u0004\u0000\u0133\u0134\u0005\'\u0000"+
		"\u0000\u0134\u0135\u0003\b\u0004\u0000\u0135\u0136\u0005\b\u0000\u0000"+
		"\u0136\u001d\u0001\u0000\u0000\u0000\u0137\u013e\u0003\u001c\u000e\u0000"+
		"\u0138\u0139\u0005\u0007\u0000\u0000\u0139\u013a\u0005*\u0000\u0000\u013a"+
		"\u013b\u0005\u0004\u0000\u0000\u013b\u013c\u0005*\u0000\u0000\u013c\u013e"+
		"\u0005\b\u0000\u0000\u013d\u0137\u0001\u0000\u0000\u0000\u013d\u0138\u0001"+
		"\u0000\u0000\u0000\u013e\u001f\u0001\u0000\u0000\u0000\u001b#6DXfhpx~"+
		"\u0088\u0095\u00a2\u00b1\u00ba\u00bf\u00c9\u00dc\u00ec\u00f0\u00f4\u00ff"+
		"\u0106\u0111\u011e\u0122\u012c\u013d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}