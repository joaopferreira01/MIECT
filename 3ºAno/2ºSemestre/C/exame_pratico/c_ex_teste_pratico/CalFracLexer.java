// Generated from CalFrac.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class CalFracLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, VAR=14, NUM=15, STRING=16, NL=17, 
		COMMENT=18, WS=19, ERROR=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "VAR", "NUM", "STRING", "NL", "COMMENT", 
			"WS", "ERROR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'print'", "'->'", "'*'", "':'", "'+'", "'-'", "'('", "')'", 
			"'^'", "'/'", "'read'", "'reduce'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "VAR", "NUM", "STRING", "NL", "COMMENT", "WS", "ERROR"
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


	public CalFracLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CalFrac.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0014~\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\r\u0004\rR\b\r\u000b\r\f\rS\u0001\u000e"+
		"\u0004\u000eW\b\u000e\u000b\u000e\f\u000eX\u0001\u000f\u0001\u000f\u0005"+
		"\u000f]\b\u000f\n\u000f\f\u000f`\t\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0003\u0010e\b\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0005\u0011m\b\u0011\n\u0011\f\u0011p\t"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0004"+
		"\u0012w\b\u0012\u000b\u0012\f\u0012x\u0001\u0012\u0001\u0012\u0001\u0013"+
		"\u0001\u0013\u0002^n\u0000\u0014\u0001\u0001\u0003\u0002\u0005\u0003\u0007"+
		"\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b"+
		"\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013"+
		"\'\u0014\u0001\u0000\u0003\u0001\u0000az\u0001\u000009\u0002\u0000\t\t"+
		"  \u0083\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000"+
		"\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000"+
		"\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000"+
		"\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000"+
		"\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000"+
		"\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000"+
		"\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000"+
		"\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000"+
		"!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001"+
		"\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0001)\u0001\u0000"+
		"\u0000\u0000\u0003+\u0001\u0000\u0000\u0000\u00051\u0001\u0000\u0000\u0000"+
		"\u00074\u0001\u0000\u0000\u0000\t6\u0001\u0000\u0000\u0000\u000b8\u0001"+
		"\u0000\u0000\u0000\r:\u0001\u0000\u0000\u0000\u000f<\u0001\u0000\u0000"+
		"\u0000\u0011>\u0001\u0000\u0000\u0000\u0013@\u0001\u0000\u0000\u0000\u0015"+
		"B\u0001\u0000\u0000\u0000\u0017D\u0001\u0000\u0000\u0000\u0019I\u0001"+
		"\u0000\u0000\u0000\u001bQ\u0001\u0000\u0000\u0000\u001dV\u0001\u0000\u0000"+
		"\u0000\u001fZ\u0001\u0000\u0000\u0000!d\u0001\u0000\u0000\u0000#h\u0001"+
		"\u0000\u0000\u0000%v\u0001\u0000\u0000\u0000\'|\u0001\u0000\u0000\u0000"+
		")*\u0005;\u0000\u0000*\u0002\u0001\u0000\u0000\u0000+,\u0005p\u0000\u0000"+
		",-\u0005r\u0000\u0000-.\u0005i\u0000\u0000./\u0005n\u0000\u0000/0\u0005"+
		"t\u0000\u00000\u0004\u0001\u0000\u0000\u000012\u0005-\u0000\u000023\u0005"+
		">\u0000\u00003\u0006\u0001\u0000\u0000\u000045\u0005*\u0000\u00005\b\u0001"+
		"\u0000\u0000\u000067\u0005:\u0000\u00007\n\u0001\u0000\u0000\u000089\u0005"+
		"+\u0000\u00009\f\u0001\u0000\u0000\u0000:;\u0005-\u0000\u0000;\u000e\u0001"+
		"\u0000\u0000\u0000<=\u0005(\u0000\u0000=\u0010\u0001\u0000\u0000\u0000"+
		">?\u0005)\u0000\u0000?\u0012\u0001\u0000\u0000\u0000@A\u0005^\u0000\u0000"+
		"A\u0014\u0001\u0000\u0000\u0000BC\u0005/\u0000\u0000C\u0016\u0001\u0000"+
		"\u0000\u0000DE\u0005r\u0000\u0000EF\u0005e\u0000\u0000FG\u0005a\u0000"+
		"\u0000GH\u0005d\u0000\u0000H\u0018\u0001\u0000\u0000\u0000IJ\u0005r\u0000"+
		"\u0000JK\u0005e\u0000\u0000KL\u0005d\u0000\u0000LM\u0005u\u0000\u0000"+
		"MN\u0005c\u0000\u0000NO\u0005e\u0000\u0000O\u001a\u0001\u0000\u0000\u0000"+
		"PR\u0007\u0000\u0000\u0000QP\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000"+
		"\u0000SQ\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000T\u001c\u0001"+
		"\u0000\u0000\u0000UW\u0007\u0001\u0000\u0000VU\u0001\u0000\u0000\u0000"+
		"WX\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000"+
		"\u0000Y\u001e\u0001\u0000\u0000\u0000Z^\u0005\"\u0000\u0000[]\t\u0000"+
		"\u0000\u0000\\[\u0001\u0000\u0000\u0000]`\u0001\u0000\u0000\u0000^_\u0001"+
		"\u0000\u0000\u0000^\\\u0001\u0000\u0000\u0000_a\u0001\u0000\u0000\u0000"+
		"`^\u0001\u0000\u0000\u0000ab\u0005\"\u0000\u0000b \u0001\u0000\u0000\u0000"+
		"ce\u0005\r\u0000\u0000dc\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000"+
		"ef\u0001\u0000\u0000\u0000fg\u0005\n\u0000\u0000g\"\u0001\u0000\u0000"+
		"\u0000hi\u0005/\u0000\u0000ij\u0005/\u0000\u0000jn\u0001\u0000\u0000\u0000"+
		"km\t\u0000\u0000\u0000lk\u0001\u0000\u0000\u0000mp\u0001\u0000\u0000\u0000"+
		"no\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000oq\u0001\u0000\u0000"+
		"\u0000pn\u0001\u0000\u0000\u0000qr\u0005\n\u0000\u0000rs\u0001\u0000\u0000"+
		"\u0000st\u0006\u0011\u0000\u0000t$\u0001\u0000\u0000\u0000uw\u0007\u0002"+
		"\u0000\u0000vu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000xv\u0001"+
		"\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000"+
		"z{\u0006\u0012\u0000\u0000{&\u0001\u0000\u0000\u0000|}\t\u0000\u0000\u0000"+
		"}(\u0001\u0000\u0000\u0000\u0007\u0000SX^dnx\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}