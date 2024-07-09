// Generated from agl.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class agl_rewrittenLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, ID=8, Number=9, 
		String=10, COMMENT=11, MLCOMMENT=12, WS=13, NL=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "ID", "Number", 
			"String", "COMMENT", "MLCOMMENT", "WS", "NL"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'.'", "'='", "':'", "'with'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "ID", "Number", "String", 
			"COMMENT", "MLCOMMENT", "WS", "NL"
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


	public agl_rewrittenLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "agl.g4"; }

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
		"\u0004\u0000\u000ep\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0005\u00071\b"+
		"\u0007\n\u0007\f\u00074\t\u0007\u0001\b\u0004\b7\b\b\u000b\b\f\b8\u0001"+
		"\b\u0001\b\u0004\b=\b\b\u000b\b\f\b>\u0003\bA\b\b\u0001\t\u0001\t\u0005"+
		"\tE\b\t\n\t\f\tH\t\t\u0001\t\u0001\t\u0001\n\u0001\n\u0005\nN\b\n\n\n"+
		"\f\nQ\t\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0005\u000bY\b\u000b\n\u000b\f\u000b\\\t\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0004\fd\b\f\u000b\f\f\f"+
		"e\u0001\f\u0001\f\u0001\r\u0003\rk\b\r\u0001\r\u0001\r\u0001\r\u0001\r"+
		"\u0001Z\u0000\u000e\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t"+
		"\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f"+
		"\u0019\r\u001b\u000e\u0001\u0000\u0006\u0003\u0000AZ__az\u0004\u00000"+
		"9AZ__az\u0001\u000009\u0003\u0000\n\n\r\r\"\"\u0002\u0000\n\n\r\r\u0002"+
		"\u0000\t\t  x\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0001\u001d\u0001\u0000\u0000\u0000\u0003\u001f\u0001\u0000\u0000\u0000"+
		"\u0005!\u0001\u0000\u0000\u0000\u0007#\u0001\u0000\u0000\u0000\t%\u0001"+
		"\u0000\u0000\u0000\u000b*\u0001\u0000\u0000\u0000\r,\u0001\u0000\u0000"+
		"\u0000\u000f.\u0001\u0000\u0000\u0000\u00116\u0001\u0000\u0000\u0000\u0013"+
		"B\u0001\u0000\u0000\u0000\u0015K\u0001\u0000\u0000\u0000\u0017T\u0001"+
		"\u0000\u0000\u0000\u0019c\u0001\u0000\u0000\u0000\u001bj\u0001\u0000\u0000"+
		"\u0000\u001d\u001e\u0005;\u0000\u0000\u001e\u0002\u0001\u0000\u0000\u0000"+
		"\u001f \u0005.\u0000\u0000 \u0004\u0001\u0000\u0000\u0000!\"\u0005=\u0000"+
		"\u0000\"\u0006\u0001\u0000\u0000\u0000#$\u0005:\u0000\u0000$\b\u0001\u0000"+
		"\u0000\u0000%&\u0005w\u0000\u0000&\'\u0005i\u0000\u0000\'(\u0005t\u0000"+
		"\u0000()\u0005h\u0000\u0000)\n\u0001\u0000\u0000\u0000*+\u0005{\u0000"+
		"\u0000+\f\u0001\u0000\u0000\u0000,-\u0005}\u0000\u0000-\u000e\u0001\u0000"+
		"\u0000\u0000.2\u0007\u0000\u0000\u0000/1\u0007\u0001\u0000\u00000/\u0001"+
		"\u0000\u0000\u000014\u0001\u0000\u0000\u000020\u0001\u0000\u0000\u0000"+
		"23\u0001\u0000\u0000\u00003\u0010\u0001\u0000\u0000\u000042\u0001\u0000"+
		"\u0000\u000057\u0007\u0002\u0000\u000065\u0001\u0000\u0000\u000078\u0001"+
		"\u0000\u0000\u000086\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u0000"+
		"9@\u0001\u0000\u0000\u0000:<\u0005.\u0000\u0000;=\u0007\u0002\u0000\u0000"+
		"<;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000><\u0001\u0000\u0000"+
		"\u0000>?\u0001\u0000\u0000\u0000?A\u0001\u0000\u0000\u0000@:\u0001\u0000"+
		"\u0000\u0000@A\u0001\u0000\u0000\u0000A\u0012\u0001\u0000\u0000\u0000"+
		"BF\u0005\"\u0000\u0000CE\b\u0003\u0000\u0000DC\u0001\u0000\u0000\u0000"+
		"EH\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000"+
		"\u0000GI\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000IJ\u0005\"\u0000"+
		"\u0000J\u0014\u0001\u0000\u0000\u0000KO\u0005#\u0000\u0000LN\b\u0004\u0000"+
		"\u0000ML\u0001\u0000\u0000\u0000NQ\u0001\u0000\u0000\u0000OM\u0001\u0000"+
		"\u0000\u0000OP\u0001\u0000\u0000\u0000PR\u0001\u0000\u0000\u0000QO\u0001"+
		"\u0000\u0000\u0000RS\u0006\n\u0000\u0000S\u0016\u0001\u0000\u0000\u0000"+
		"TU\u0005#\u0000\u0000UV\u0005(\u0000\u0000VZ\u0001\u0000\u0000\u0000W"+
		"Y\t\u0000\u0000\u0000XW\u0001\u0000\u0000\u0000Y\\\u0001\u0000\u0000\u0000"+
		"Z[\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000\u0000[]\u0001\u0000\u0000"+
		"\u0000\\Z\u0001\u0000\u0000\u0000]^\u0005#\u0000\u0000^_\u0005)\u0000"+
		"\u0000_`\u0001\u0000\u0000\u0000`a\u0006\u000b\u0000\u0000a\u0018\u0001"+
		"\u0000\u0000\u0000bd\u0007\u0005\u0000\u0000cb\u0001\u0000\u0000\u0000"+
		"de\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000"+
		"\u0000fg\u0001\u0000\u0000\u0000gh\u0006\f\u0000\u0000h\u001a\u0001\u0000"+
		"\u0000\u0000ik\u0005\r\u0000\u0000ji\u0001\u0000\u0000\u0000jk\u0001\u0000"+
		"\u0000\u0000kl\u0001\u0000\u0000\u0000lm\u0005\n\u0000\u0000mn\u0001\u0000"+
		"\u0000\u0000no\u0006\r\u0000\u0000o\u001c\u0001\u0000\u0000\u0000\n\u0000"+
		"28>@FOZej\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}