// Generated from Hello.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class HelloParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, ID=3, WS=4;
	public static final int
		RULE_more = 0, RULE_any = 1, RULE_greetings = 2, RULE_bye = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"more", "any", "greetings", "bye"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'hello'", "'bye'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "ID", "WS"
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
	public String getGrammarFileName() { return "Hello.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public HelloParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MoreContext extends ParserRuleContext {
		public List<AnyContext> any() {
			return getRuleContexts(AnyContext.class);
		}
		public AnyContext any(int i) {
			return getRuleContext(AnyContext.class,i);
		}
		public TerminalNode EOF() { return getToken(HelloParser.EOF, 0); }
		public MoreContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_more; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterMore(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitMore(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitMore(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MoreContext more() throws RecognitionException {
		MoreContext _localctx = new MoreContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_more);
		int _la;
		try {
			setState(15);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(11);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0 || _la==T__1) {
					{
					{
					setState(8);
					any();
					}
					}
					setState(13);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(14);
				match(EOF);
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
	public static class AnyContext extends ParserRuleContext {
		public GreetingsContext greetings() {
			return getRuleContext(GreetingsContext.class,0);
		}
		public ByeContext bye() {
			return getRuleContext(ByeContext.class,0);
		}
		public AnyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_any; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterAny(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitAny(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitAny(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnyContext any() throws RecognitionException {
		AnyContext _localctx = new AnyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_any);
		try {
			setState(19);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(17);
				greetings();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(18);
				bye();
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
	public static class GreetingsContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(HelloParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(HelloParser.ID, i);
		}
		public GreetingsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_greetings; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterGreetings(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitGreetings(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitGreetings(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GreetingsContext greetings() throws RecognitionException {
		GreetingsContext _localctx = new GreetingsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_greetings);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			match(T__0);
			setState(23); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(22);
				match(ID);
				}
				}
				setState(25); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
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
	public static class ByeContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(HelloParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(HelloParser.ID, i);
		}
		public ByeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bye; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).enterBye(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HelloListener ) ((HelloListener)listener).exitBye(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HelloVisitor ) return ((HelloVisitor<? extends T>)visitor).visitBye(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ByeContext bye() throws RecognitionException {
		ByeContext _localctx = new ByeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_bye);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			match(T__1);
			setState(29); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(28);
				match(ID);
				}
				}
				setState(31); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
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

	public static final String _serializedATN =
		"\u0004\u0001\u0004\"\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0001\u0000\u0005\u0000\n\b"+
		"\u0000\n\u0000\f\u0000\r\t\u0000\u0001\u0000\u0003\u0000\u0010\b\u0000"+
		"\u0001\u0001\u0001\u0001\u0003\u0001\u0014\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0004\u0002\u0018\b\u0002\u000b\u0002\f\u0002\u0019\u0001\u0003\u0001"+
		"\u0003\u0004\u0003\u001e\b\u0003\u000b\u0003\f\u0003\u001f\u0001\u0003"+
		"\u0000\u0000\u0004\u0000\u0002\u0004\u0006\u0000\u0000\"\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0002\u0013\u0001\u0000\u0000\u0000\u0004\u0015\u0001"+
		"\u0000\u0000\u0000\u0006\u001b\u0001\u0000\u0000\u0000\b\n\u0003\u0002"+
		"\u0001\u0000\t\b\u0001\u0000\u0000\u0000\n\r\u0001\u0000\u0000\u0000\u000b"+
		"\t\u0001\u0000\u0000\u0000\u000b\f\u0001\u0000\u0000\u0000\f\u0010\u0001"+
		"\u0000\u0000\u0000\r\u000b\u0001\u0000\u0000\u0000\u000e\u0010\u0005\u0000"+
		"\u0000\u0001\u000f\u000b\u0001\u0000\u0000\u0000\u000f\u000e\u0001\u0000"+
		"\u0000\u0000\u0010\u0001\u0001\u0000\u0000\u0000\u0011\u0014\u0003\u0004"+
		"\u0002\u0000\u0012\u0014\u0003\u0006\u0003\u0000\u0013\u0011\u0001\u0000"+
		"\u0000\u0000\u0013\u0012\u0001\u0000\u0000\u0000\u0014\u0003\u0001\u0000"+
		"\u0000\u0000\u0015\u0017\u0005\u0001\u0000\u0000\u0016\u0018\u0005\u0003"+
		"\u0000\u0000\u0017\u0016\u0001\u0000\u0000\u0000\u0018\u0019\u0001\u0000"+
		"\u0000\u0000\u0019\u0017\u0001\u0000\u0000\u0000\u0019\u001a\u0001\u0000"+
		"\u0000\u0000\u001a\u0005\u0001\u0000\u0000\u0000\u001b\u001d\u0005\u0002"+
		"\u0000\u0000\u001c\u001e\u0005\u0003\u0000\u0000\u001d\u001c\u0001\u0000"+
		"\u0000\u0000\u001e\u001f\u0001\u0000\u0000\u0000\u001f\u001d\u0001\u0000"+
		"\u0000\u0000\u001f \u0001\u0000\u0000\u0000 \u0007\u0001\u0000\u0000\u0000"+
		"\u0005\u000b\u000f\u0013\u0019\u001f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}