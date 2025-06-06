// Generated from C:/Users/user/IdeaProjects/CP-2024/week5/src/tinyR4.g4 by ANTLR 4.13.1
package generated;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class tinyR4Lexer extends Lexer {

    static {
        RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
        new PredictionContextCache();
    public static final int
        T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, T__8 = 9,
        T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, T__14 = 15, T__15 = 16, T__16 = 17,
        T__17 = 18, T__18 = 19, T__19 = 20, FUNC = 21, U32 = 22, LOOP = 23, FOR = 24, IF = 25,
        ELSE = 26, RETURN = 27, LET = 28, MUT = 29, BREAK = 30, OR = 31, AND = 32, LE = 33, GE = 34,
        EQ = 35, NE = 36, RARROW = 37, ID = 38, LITERAL = 39, LIT_INT = 40, LIT_STR = 41, DecimalConstant = 42,
        OctalConstant = 43, HexadecimalConstant = 44, NilConstant = 45, WildCardConstant = 46,
        WS = 47;
    public static String[] channelNames = {
        "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
    };

    public static String[] modeNames = {
        "DEFAULT_MODE"
    };

    private static String[] makeRuleNames() {
        return new String[]{
            "T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8",
            "T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16",
            "T__17", "T__18", "T__19", "FUNC", "U32", "LOOP", "FOR", "IF", "ELSE",
            "RETURN", "LET", "MUT", "BREAK", "OR", "AND", "LE", "GE", "EQ", "NE",
            "RARROW", "ID", "LITERAL", "LIT_INT", "LIT_STR", "DecimalConstant", "OctalConstant",
            "HexadecimalConstant", "NilConstant", "WildCardConstant", "WS"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
            null, "'('", "')'", "','", "':'", "'{'", "'}'", "'='", "';'", "'+'",
            "'-'", "'*'", "'/'", "'%'", "'--'", "'++'", "'!'", "'<'", "'>'", "'in'",
            "'..'", "'fn'", "'u32'", "'loop'", "'for'", "'if'", "'else'", "'return'",
            "'let'", "'mut'", "'break'", "'||'", "'&&'", "'<='", "'>='", "'=='",
            "'!='", "'->'", null, null, null, null, null, null, null, null, "'_'"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, "FUNC", "U32",
            "LOOP", "FOR", "IF", "ELSE", "RETURN", "LET", "MUT", "BREAK", "OR", "AND",
            "LE", "GE", "EQ", "NE", "RARROW", "ID", "LITERAL", "LIT_INT", "LIT_STR",
            "DecimalConstant", "OctalConstant", "HexadecimalConstant", "NilConstant",
            "WildCardConstant", "WS"
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


    public tinyR4Lexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    @Override
    public String getGrammarFileName() {
        return "tinyR4.g4";
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
    public String[] getChannelNames() {
        return channelNames;
    }

    @Override
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public static final String _serializedATN =
        "\u0004\u0000/\u0111\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001" +
            "\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004" +
            "\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007" +
            "\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b" +
            "\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002" +
            "\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002" +
            "\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002" +
            "\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002" +
            "\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002" +
            "\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002" +
            "\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007" +
            "!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007" +
            "&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007" +
            "+\u0002,\u0007,\u0002-\u0007-\u0002.\u0007.\u0001\u0000\u0001\u0000\u0001" +
            "\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001" +
            "\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001" +
            "\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001" +
            "\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\u000e" +
            "\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010" +
            "\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013" +
            "\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015" +
            "\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016" +
            "\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017" +
            "\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019" +
            "\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a" +
            "\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b" +
            "\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d" +
            "\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e" +
            "\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0001" +
            " \u0001 \u0001!\u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0001#\u0001#\u0001" +
            "#\u0001$\u0001$\u0001$\u0001%\u0001%\u0005%\u00d0\b%\n%\f%\u00d3\t%\u0001" +
            "&\u0001&\u0003&\u00d7\b&\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0003" +
            "\'\u00de\b\'\u0001(\u0001(\u0005(\u00e2\b(\n(\f(\u00e5\t(\u0001(\u0001" +
            "(\u0001)\u0001)\u0001)\u0005)\u00ec\b)\n)\f)\u00ef\t)\u0003)\u00f1\b)" +
            "\u0001*\u0001*\u0005*\u00f5\b*\n*\f*\u00f8\t*\u0001+\u0001+\u0001+\u0004" +
            "+\u00fd\b+\u000b+\f+\u00fe\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0003" +
            ",\u0107\b,\u0001-\u0001-\u0001.\u0004.\u010c\b.\u000b.\f.\u010d\u0001" +
            ".\u0001.\u0001\u00e3\u0000/\u0001\u0001\u0003\u0002\u0005\u0003\u0007" +
            "\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b" +
            "\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013" +
            "\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a5\u001b7\u001c9\u001d" +
            ";\u001e=\u001f? A!C\"E#G$I%K&M\'O(Q)S*U+W,Y-[.]/\u0001\u0000\b\u0003\u0000" +
            "AZ__az\u0004\u000009AZ__az\u0001\u000019\u0001\u000009\u0001\u000007\u0002" +
            "\u0000XXxx\u0003\u000009AFaf\u0003\u0000\t\n\r\r  \u011d\u0000\u0001\u0001" +
            "\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001" +
            "\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000" +
            "\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000" +
            "\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000" +
            "\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000" +
            "\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000" +
            "\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000" +
            "\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000" +
            "\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'" +
            "\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000" +
            "\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000" +
            "\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005" +
            "\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000" +
            "\u0000\u0000\u0000;\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000" +
            "\u0000?\u0001\u0000\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0000C" +
            "\u0001\u0000\u0000\u0000\u0000E\u0001\u0000\u0000\u0000\u0000G\u0001\u0000" +
            "\u0000\u0000\u0000I\u0001\u0000\u0000\u0000\u0000K\u0001\u0000\u0000\u0000" +
            "\u0000M\u0001\u0000\u0000\u0000\u0000O\u0001\u0000\u0000\u0000\u0000Q" +
            "\u0001\u0000\u0000\u0000\u0000S\u0001\u0000\u0000\u0000\u0000U\u0001\u0000" +
            "\u0000\u0000\u0000W\u0001\u0000\u0000\u0000\u0000Y\u0001\u0000\u0000\u0000" +
            "\u0000[\u0001\u0000\u0000\u0000\u0000]\u0001\u0000\u0000\u0000\u0001_" +
            "\u0001\u0000\u0000\u0000\u0003a\u0001\u0000\u0000\u0000\u0005c\u0001\u0000" +
            "\u0000\u0000\u0007e\u0001\u0000\u0000\u0000\tg\u0001\u0000\u0000\u0000" +
            "\u000bi\u0001\u0000\u0000\u0000\rk\u0001\u0000\u0000\u0000\u000fm\u0001" +
            "\u0000\u0000\u0000\u0011o\u0001\u0000\u0000\u0000\u0013q\u0001\u0000\u0000" +
            "\u0000\u0015s\u0001\u0000\u0000\u0000\u0017u\u0001\u0000\u0000\u0000\u0019" +
            "w\u0001\u0000\u0000\u0000\u001by\u0001\u0000\u0000\u0000\u001d|\u0001" +
            "\u0000\u0000\u0000\u001f\u007f\u0001\u0000\u0000\u0000!\u0081\u0001\u0000" +
            "\u0000\u0000#\u0083\u0001\u0000\u0000\u0000%\u0085\u0001\u0000\u0000\u0000" +
            "\'\u0088\u0001\u0000\u0000\u0000)\u008b\u0001\u0000\u0000\u0000+\u008e" +
            "\u0001\u0000\u0000\u0000-\u0092\u0001\u0000\u0000\u0000/\u0097\u0001\u0000" +
            "\u0000\u00001\u009b\u0001\u0000\u0000\u00003\u009e\u0001\u0000\u0000\u0000" +
            "5\u00a3\u0001\u0000\u0000\u00007\u00aa\u0001\u0000\u0000\u00009\u00ae" +
            "\u0001\u0000\u0000\u0000;\u00b2\u0001\u0000\u0000\u0000=\u00b8\u0001\u0000" +
            "\u0000\u0000?\u00bb\u0001\u0000\u0000\u0000A\u00be\u0001\u0000\u0000\u0000" +
            "C\u00c1\u0001\u0000\u0000\u0000E\u00c4\u0001\u0000\u0000\u0000G\u00c7" +
            "\u0001\u0000\u0000\u0000I\u00ca\u0001\u0000\u0000\u0000K\u00cd\u0001\u0000" +
            "\u0000\u0000M\u00d6\u0001\u0000\u0000\u0000O\u00dd\u0001\u0000\u0000\u0000" +
            "Q\u00df\u0001\u0000\u0000\u0000S\u00f0\u0001\u0000\u0000\u0000U\u00f2" +
            "\u0001\u0000\u0000\u0000W\u00f9\u0001\u0000\u0000\u0000Y\u0106\u0001\u0000" +
            "\u0000\u0000[\u0108\u0001\u0000\u0000\u0000]\u010b\u0001\u0000\u0000\u0000" +
            "_`\u0005(\u0000\u0000`\u0002\u0001\u0000\u0000\u0000ab\u0005)\u0000\u0000" +
            "b\u0004\u0001\u0000\u0000\u0000cd\u0005,\u0000\u0000d\u0006\u0001\u0000" +
            "\u0000\u0000ef\u0005:\u0000\u0000f\b\u0001\u0000\u0000\u0000gh\u0005{" +
            "\u0000\u0000h\n\u0001\u0000\u0000\u0000ij\u0005}\u0000\u0000j\f\u0001" +
            "\u0000\u0000\u0000kl\u0005=\u0000\u0000l\u000e\u0001\u0000\u0000\u0000" +
            "mn\u0005;\u0000\u0000n\u0010\u0001\u0000\u0000\u0000op\u0005+\u0000\u0000" +
            "p\u0012\u0001\u0000\u0000\u0000qr\u0005-\u0000\u0000r\u0014\u0001\u0000" +
            "\u0000\u0000st\u0005*\u0000\u0000t\u0016\u0001\u0000\u0000\u0000uv\u0005" +
            "/\u0000\u0000v\u0018\u0001\u0000\u0000\u0000wx\u0005%\u0000\u0000x\u001a" +
            "\u0001\u0000\u0000\u0000yz\u0005-\u0000\u0000z{\u0005-\u0000\u0000{\u001c" +
            "\u0001\u0000\u0000\u0000|}\u0005+\u0000\u0000}~\u0005+\u0000\u0000~\u001e" +
            "\u0001\u0000\u0000\u0000\u007f\u0080\u0005!\u0000\u0000\u0080 \u0001\u0000" +
            "\u0000\u0000\u0081\u0082\u0005<\u0000\u0000\u0082\"\u0001\u0000\u0000" +
            "\u0000\u0083\u0084\u0005>\u0000\u0000\u0084$\u0001\u0000\u0000\u0000\u0085" +
            "\u0086\u0005i\u0000\u0000\u0086\u0087\u0005n\u0000\u0000\u0087&\u0001" +
            "\u0000\u0000\u0000\u0088\u0089\u0005.\u0000\u0000\u0089\u008a\u0005.\u0000" +
            "\u0000\u008a(\u0001\u0000\u0000\u0000\u008b\u008c\u0005f\u0000\u0000\u008c" +
            "\u008d\u0005n\u0000\u0000\u008d*\u0001\u0000\u0000\u0000\u008e\u008f\u0005" +
            "u\u0000\u0000\u008f\u0090\u00053\u0000\u0000\u0090\u0091\u00052\u0000" +
            "\u0000\u0091,\u0001\u0000\u0000\u0000\u0092\u0093\u0005l\u0000\u0000\u0093" +
            "\u0094\u0005o\u0000\u0000\u0094\u0095\u0005o\u0000\u0000\u0095\u0096\u0005" +
            "p\u0000\u0000\u0096.\u0001\u0000\u0000\u0000\u0097\u0098\u0005f\u0000" +
            "\u0000\u0098\u0099\u0005o\u0000\u0000\u0099\u009a\u0005r\u0000\u0000\u009a" +
            "0\u0001\u0000\u0000\u0000\u009b\u009c\u0005i\u0000\u0000\u009c\u009d\u0005" +
            "f\u0000\u0000\u009d2\u0001\u0000\u0000\u0000\u009e\u009f\u0005e\u0000" +
            "\u0000\u009f\u00a0\u0005l\u0000\u0000\u00a0\u00a1\u0005s\u0000\u0000\u00a1" +
            "\u00a2\u0005e\u0000\u0000\u00a24\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005" +
            "r\u0000\u0000\u00a4\u00a5\u0005e\u0000\u0000\u00a5\u00a6\u0005t\u0000" +
            "\u0000\u00a6\u00a7\u0005u\u0000\u0000\u00a7\u00a8\u0005r\u0000\u0000\u00a8" +
            "\u00a9\u0005n\u0000\u0000\u00a96\u0001\u0000\u0000\u0000\u00aa\u00ab\u0005" +
            "l\u0000\u0000\u00ab\u00ac\u0005e\u0000\u0000\u00ac\u00ad\u0005t\u0000" +
            "\u0000\u00ad8\u0001\u0000\u0000\u0000\u00ae\u00af\u0005m\u0000\u0000\u00af" +
            "\u00b0\u0005u\u0000\u0000\u00b0\u00b1\u0005t\u0000\u0000\u00b1:\u0001" +
            "\u0000\u0000\u0000\u00b2\u00b3\u0005b\u0000\u0000\u00b3\u00b4\u0005r\u0000" +
            "\u0000\u00b4\u00b5\u0005e\u0000\u0000\u00b5\u00b6\u0005a\u0000\u0000\u00b6" +
            "\u00b7\u0005k\u0000\u0000\u00b7<\u0001\u0000\u0000\u0000\u00b8\u00b9\u0005" +
            "|\u0000\u0000\u00b9\u00ba\u0005|\u0000\u0000\u00ba>\u0001\u0000\u0000" +
            "\u0000\u00bb\u00bc\u0005&\u0000\u0000\u00bc\u00bd\u0005&\u0000\u0000\u00bd" +
            "@\u0001\u0000\u0000\u0000\u00be\u00bf\u0005<\u0000\u0000\u00bf\u00c0\u0005" +
            "=\u0000\u0000\u00c0B\u0001\u0000\u0000\u0000\u00c1\u00c2\u0005>\u0000" +
            "\u0000\u00c2\u00c3\u0005=\u0000\u0000\u00c3D\u0001\u0000\u0000\u0000\u00c4" +
            "\u00c5\u0005=\u0000\u0000\u00c5\u00c6\u0005=\u0000\u0000\u00c6F\u0001" +
            "\u0000\u0000\u0000\u00c7\u00c8\u0005!\u0000\u0000\u00c8\u00c9\u0005=\u0000" +
            "\u0000\u00c9H\u0001\u0000\u0000\u0000\u00ca\u00cb\u0005-\u0000\u0000\u00cb" +
            "\u00cc\u0005>\u0000\u0000\u00ccJ\u0001\u0000\u0000\u0000\u00cd\u00d1\u0007" +
            "\u0000\u0000\u0000\u00ce\u00d0\u0007\u0001\u0000\u0000\u00cf\u00ce\u0001" +
            "\u0000\u0000\u0000\u00d0\u00d3\u0001\u0000\u0000\u0000\u00d1\u00cf\u0001" +
            "\u0000\u0000\u0000\u00d1\u00d2\u0001\u0000\u0000\u0000\u00d2L\u0001\u0000" +
            "\u0000\u0000\u00d3\u00d1\u0001\u0000\u0000\u0000\u00d4\u00d7\u0003O\'" +
            "\u0000\u00d5\u00d7\u0003Q(\u0000\u00d6\u00d4\u0001\u0000\u0000\u0000\u00d6" +
            "\u00d5\u0001\u0000\u0000\u0000\u00d7N\u0001\u0000\u0000\u0000\u00d8\u00de" +
            "\u0003S)\u0000\u00d9\u00de\u0003U*\u0000\u00da\u00de\u0003W+\u0000\u00db" +
            "\u00de\u0003Y,\u0000\u00dc\u00de\u0003[-\u0000\u00dd\u00d8\u0001\u0000" +
            "\u0000\u0000\u00dd\u00d9\u0001\u0000\u0000\u0000\u00dd\u00da\u0001\u0000" +
            "\u0000\u0000\u00dd\u00db\u0001\u0000\u0000\u0000\u00dd\u00dc\u0001\u0000" +
            "\u0000\u0000\u00deP\u0001\u0000\u0000\u0000\u00df\u00e3\u0005\"\u0000" +
            "\u0000\u00e0\u00e2\t\u0000\u0000\u0000\u00e1\u00e0\u0001\u0000\u0000\u0000" +
            "\u00e2\u00e5\u0001\u0000\u0000\u0000\u00e3\u00e4\u0001\u0000\u0000\u0000" +
            "\u00e3\u00e1\u0001\u0000\u0000\u0000\u00e4\u00e6\u0001\u0000\u0000\u0000" +
            "\u00e5\u00e3\u0001\u0000\u0000\u0000\u00e6\u00e7\u0005\"\u0000\u0000\u00e7" +
            "R\u0001\u0000\u0000\u0000\u00e8\u00f1\u00050\u0000\u0000\u00e9\u00ed\u0007" +
            "\u0002\u0000\u0000\u00ea\u00ec\u0007\u0003\u0000\u0000\u00eb\u00ea\u0001" +
            "\u0000\u0000\u0000\u00ec\u00ef\u0001\u0000\u0000\u0000\u00ed\u00eb\u0001" +
            "\u0000\u0000\u0000\u00ed\u00ee\u0001\u0000\u0000\u0000\u00ee\u00f1\u0001" +
            "\u0000\u0000\u0000\u00ef\u00ed\u0001\u0000\u0000\u0000\u00f0\u00e8\u0001" +
            "\u0000\u0000\u0000\u00f0\u00e9\u0001\u0000\u0000\u0000\u00f1T\u0001\u0000" +
            "\u0000\u0000\u00f2\u00f6\u00050\u0000\u0000\u00f3\u00f5\u0007\u0004\u0000" +
            "\u0000\u00f4\u00f3\u0001\u0000\u0000\u0000\u00f5\u00f8\u0001\u0000\u0000" +
            "\u0000\u00f6\u00f4\u0001\u0000\u0000\u0000\u00f6\u00f7\u0001\u0000\u0000" +
            "\u0000\u00f7V\u0001\u0000\u0000\u0000\u00f8\u00f6\u0001\u0000\u0000\u0000" +
            "\u00f9\u00fa\u00050\u0000\u0000\u00fa\u00fc\u0007\u0005\u0000\u0000\u00fb" +
            "\u00fd\u0007\u0006\u0000\u0000\u00fc\u00fb\u0001\u0000\u0000\u0000\u00fd" +
            "\u00fe\u0001\u0000\u0000\u0000\u00fe\u00fc\u0001\u0000\u0000\u0000\u00fe" +
            "\u00ff\u0001\u0000\u0000\u0000\u00ffX\u0001\u0000\u0000\u0000\u0100\u0101" +
            "\u0005N\u0000\u0000\u0101\u0102\u0005I\u0000\u0000\u0102\u0107\u0005L" +
            "\u0000\u0000\u0103\u0104\u0005n\u0000\u0000\u0104\u0105\u0005i\u0000\u0000" +
            "\u0105\u0107\u0005l\u0000\u0000\u0106\u0100\u0001\u0000\u0000\u0000\u0106" +
            "\u0103\u0001\u0000\u0000\u0000\u0107Z\u0001\u0000\u0000\u0000\u0108\u0109" +
            "\u0005_\u0000\u0000\u0109\\\u0001\u0000\u0000\u0000\u010a\u010c\u0007" +
            "\u0007\u0000\u0000\u010b\u010a\u0001\u0000\u0000\u0000\u010c\u010d\u0001" +
            "\u0000\u0000\u0000\u010d\u010b\u0001\u0000\u0000\u0000\u010d\u010e\u0001" +
            "\u0000\u0000\u0000\u010e\u010f\u0001\u0000\u0000\u0000\u010f\u0110\u0006" +
            ".\u0000\u0000\u0110^\u0001\u0000\u0000\u0000\u000b\u0000\u00d1\u00d6\u00dd" +
            "\u00e3\u00ed\u00f0\u00f6\u00fe\u0106\u010d\u0001\u0000\u0001\u0000";
    public static final ATN _ATN =
        new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}