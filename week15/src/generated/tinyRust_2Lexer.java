// Generated from C:/Users/user/IdeaProjects/CP-2024/week15/src/tinyRust.g4 by ANTLR 4.13.1
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
public class tinyRust_2Lexer extends Lexer {

    public static final int
        T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, T__8 = 9,
        T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, T__14 = 15, T__15 = 16, T__16 = 17,
        T__17 = 18, T__18 = 19, T__19 = 20, T__20 = 21, T__21 = 22, T__22 = 23, T__23 = 24,
        T__24 = 25, FUNC = 26, I32 = 27, LOOP = 28, FOR = 29, IF = 30, ELSE = 31, RETURN = 32,
        LET = 33, MUT = 34, BREAK = 35, OR = 36, AND = 37, LE = 38, GE = 39, EQ = 40, NE = 41, RARROW = 42,
        ID = 43, LITERAL = 44, LIT_INT = 45, LIT_STR = 46, DecimalConstant = 47, OctalConstant = 48,
        HexadecimalConstant = 49, NilConstant = 50, WildCardConstant = 51, WS = 52;
    public static final String[] ruleNames = makeRuleNames();
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
        "\u0004\u00004\u0136\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001" +
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
            "+\u0002,\u0007,\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u0007" +
            "0\u00021\u00071\u00022\u00072\u00023\u00073\u0001\u0000\u0001\u0000\u0001" +
            "\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001" +
            "\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001" +
            "\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001" +
            "\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001" +
            "\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f" +
            "\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012" +
            "\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013" +
            "\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014" +
            "\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015" +
            "\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016" +
            "\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0019" +
            "\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a" +
            "\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c" +
            "\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d" +
            "\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001f" +
            "\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f" +
            "\u0001 \u0001 \u0001 \u0001 \u0001!\u0001!\u0001!\u0001!\u0001\"\u0001" +
            "\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001$\u0001$" +
            "\u0001$\u0001%\u0001%\u0001%\u0001&\u0001&\u0001&\u0001\'\u0001\'\u0001" +
            "\'\u0001(\u0001(\u0001(\u0001)\u0001)\u0001)\u0001*\u0001*\u0005*\u00f5" +
            "\b*\n*\f*\u00f8\t*\u0001+\u0001+\u0003+\u00fc\b+\u0001,\u0001,\u0001," +
            "\u0001,\u0001,\u0003,\u0103\b,\u0001-\u0001-\u0005-\u0107\b-\n-\f-\u010a" +
            "\t-\u0001-\u0001-\u0001.\u0001.\u0001.\u0005.\u0111\b.\n.\f.\u0114\t." +
            "\u0003.\u0116\b.\u0001/\u0001/\u0005/\u011a\b/\n/\f/\u011d\t/\u00010\u0001" +
            "0\u00010\u00040\u0122\b0\u000b0\f0\u0123\u00011\u00011\u00011\u00011\u0001" +
            "1\u00011\u00031\u012c\b1\u00012\u00012\u00013\u00043\u0131\b3\u000b3\f" +
            "3\u0132\u00013\u00013\u0001\u0108\u00004\u0001\u0001\u0003\u0002\u0005" +
            "\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n" +
            "\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011" +
            "#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a5\u001b" +
            "7\u001c9\u001d;\u001e=\u001f? A!C\"E#G$I%K&M\'O(Q)S*U+W,Y-[.]/_0a1c2e" +
            "3g4\u0001\u0000\b\u0003\u0000AZ__az\u0004\u000009AZ__az\u0001\u000019" +
            "\u0001\u000009\u0001\u000007\u0002\u0000XXxx\u0003\u000009AFaf\u0003\u0000" +
            "\t\n\r\r  \u0142\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001" +
            "\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001" +
            "\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000" +
            "\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000" +
            "\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000" +
            "\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000" +
            "\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000" +
            "\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000" +
            "\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000" +
            "%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001" +
            "\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000" +
            "\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u0000" +
            "3\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001" +
            "\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000;\u0001\u0000\u0000" +
            "\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?\u0001\u0000\u0000\u0000\u0000" +
            "A\u0001\u0000\u0000\u0000\u0000C\u0001\u0000\u0000\u0000\u0000E\u0001" +
            "\u0000\u0000\u0000\u0000G\u0001\u0000\u0000\u0000\u0000I\u0001\u0000\u0000" +
            "\u0000\u0000K\u0001\u0000\u0000\u0000\u0000M\u0001\u0000\u0000\u0000\u0000" +
            "O\u0001\u0000\u0000\u0000\u0000Q\u0001\u0000\u0000\u0000\u0000S\u0001" +
            "\u0000\u0000\u0000\u0000U\u0001\u0000\u0000\u0000\u0000W\u0001\u0000\u0000" +
            "\u0000\u0000Y\u0001\u0000\u0000\u0000\u0000[\u0001\u0000\u0000\u0000\u0000" +
            "]\u0001\u0000\u0000\u0000\u0000_\u0001\u0000\u0000\u0000\u0000a\u0001" +
            "\u0000\u0000\u0000\u0000c\u0001\u0000\u0000\u0000\u0000e\u0001\u0000\u0000" +
            "\u0000\u0000g\u0001\u0000\u0000\u0000\u0001i\u0001\u0000\u0000\u0000\u0003" +
            "k\u0001\u0000\u0000\u0000\u0005m\u0001\u0000\u0000\u0000\u0007r\u0001" +
            "\u0000\u0000\u0000\tu\u0001\u0000\u0000\u0000\u000bw\u0001\u0000\u0000" +
            "\u0000\ry\u0001\u0000\u0000\u0000\u000f{\u0001\u0000\u0000\u0000\u0011" +
            "}\u0001\u0000\u0000\u0000\u0013\u007f\u0001\u0000\u0000\u0000\u0015\u0081" +
            "\u0001\u0000\u0000\u0000\u0017\u0083\u0001\u0000\u0000\u0000\u0019\u0085" +
            "\u0001\u0000\u0000\u0000\u001b\u0087\u0001\u0000\u0000\u0000\u001d\u0089" +
            "\u0001\u0000\u0000\u0000\u001f\u008b\u0001\u0000\u0000\u0000!\u008d\u0001" +
            "\u0000\u0000\u0000#\u008f\u0001\u0000\u0000\u0000%\u0091\u0001\u0000\u0000" +
            "\u0000\'\u0094\u0001\u0000\u0000\u0000)\u009d\u0001\u0000\u0000\u0000" +
            "+\u00a2\u0001\u0000\u0000\u0000-\u00a5\u0001\u0000\u0000\u0000/\u00ab" +
            "\u0001\u0000\u0000\u00001\u00ae\u0001\u0000\u0000\u00003\u00b0\u0001\u0000" +
            "\u0000\u00005\u00b3\u0001\u0000\u0000\u00007\u00b7\u0001\u0000\u0000\u0000" +
            "9\u00bc\u0001\u0000\u0000\u0000;\u00c0\u0001\u0000\u0000\u0000=\u00c3" +
            "\u0001\u0000\u0000\u0000?\u00c8\u0001\u0000\u0000\u0000A\u00cf\u0001\u0000" +
            "\u0000\u0000C\u00d3\u0001\u0000\u0000\u0000E\u00d7\u0001\u0000\u0000\u0000" +
            "G\u00dd\u0001\u0000\u0000\u0000I\u00e0\u0001\u0000\u0000\u0000K\u00e3" +
            "\u0001\u0000\u0000\u0000M\u00e6\u0001\u0000\u0000\u0000O\u00e9\u0001\u0000" +
            "\u0000\u0000Q\u00ec\u0001\u0000\u0000\u0000S\u00ef\u0001\u0000\u0000\u0000" +
            "U\u00f2\u0001\u0000\u0000\u0000W\u00fb\u0001\u0000\u0000\u0000Y\u0102" +
            "\u0001\u0000\u0000\u0000[\u0104\u0001\u0000\u0000\u0000]\u0115\u0001\u0000" +
            "\u0000\u0000_\u0117\u0001\u0000\u0000\u0000a\u011e\u0001\u0000\u0000\u0000" +
            "c\u012b\u0001\u0000\u0000\u0000e\u012d\u0001\u0000\u0000\u0000g\u0130" +
            "\u0001\u0000\u0000\u0000ij\u0005(\u0000\u0000j\u0002\u0001\u0000\u0000" +
            "\u0000kl\u0005)\u0000\u0000l\u0004\u0001\u0000\u0000\u0000mn\u0005m\u0000" +
            "\u0000no\u0005a\u0000\u0000op\u0005i\u0000\u0000pq\u0005n\u0000\u0000" +
            "q\u0006\u0001\u0000\u0000\u0000rs\u0005(\u0000\u0000st\u0005)\u0000\u0000" +
            "t\b\u0001\u0000\u0000\u0000uv\u0005,\u0000\u0000v\n\u0001\u0000\u0000" +
            "\u0000wx\u0005:\u0000\u0000x\f\u0001\u0000\u0000\u0000yz\u0005{\u0000" +
            "\u0000z\u000e\u0001\u0000\u0000\u0000{|\u0005}\u0000\u0000|\u0010\u0001" +
            "\u0000\u0000\u0000}~\u0005=\u0000\u0000~\u0012\u0001\u0000\u0000\u0000" +
            "\u007f\u0080\u0005;\u0000\u0000\u0080\u0014\u0001\u0000\u0000\u0000\u0081" +
            "\u0082\u0005+\u0000\u0000\u0082\u0016\u0001\u0000\u0000\u0000\u0083\u0084" +
            "\u0005-\u0000\u0000\u0084\u0018\u0001\u0000\u0000\u0000\u0085\u0086\u0005" +
            "*\u0000\u0000\u0086\u001a\u0001\u0000\u0000\u0000\u0087\u0088\u0005/\u0000" +
            "\u0000\u0088\u001c\u0001\u0000\u0000\u0000\u0089\u008a\u0005%\u0000\u0000" +
            "\u008a\u001e\u0001\u0000\u0000\u0000\u008b\u008c\u0005!\u0000\u0000\u008c" +
            " \u0001\u0000\u0000\u0000\u008d\u008e\u0005<\u0000\u0000\u008e\"\u0001" +
            "\u0000\u0000\u0000\u008f\u0090\u0005>\u0000\u0000\u0090$\u0001\u0000\u0000" +
            "\u0000\u0091\u0092\u0005i\u0000\u0000\u0092\u0093\u0005n\u0000\u0000\u0093" +
            "&\u0001\u0000\u0000\u0000\u0094\u0095\u0005p\u0000\u0000\u0095\u0096\u0005" +
            "r\u0000\u0000\u0096\u0097\u0005i\u0000\u0000\u0097\u0098\u0005n\u0000" +
            "\u0000\u0098\u0099\u0005t\u0000\u0000\u0099\u009a\u0005l\u0000\u0000\u009a" +
            "\u009b\u0005n\u0000\u0000\u009b\u009c\u0005!\u0000\u0000\u009c(\u0001" +
            "\u0000\u0000\u0000\u009d\u009e\u0005\"\u0000\u0000\u009e\u009f\u0005{" +
            "\u0000\u0000\u009f\u00a0\u0005}\u0000\u0000\u00a0\u00a1\u0005\"\u0000" +
            "\u0000\u00a1*\u0001\u0000\u0000\u0000\u00a2\u00a3\u0005.\u0000\u0000\u00a3" +
            "\u00a4\u0005.\u0000\u0000\u00a4,\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005" +
            "m\u0000\u0000\u00a6\u00a7\u0005a\u0000\u0000\u00a7\u00a8\u0005t\u0000" +
            "\u0000\u00a8\u00a9\u0005c\u0000\u0000\u00a9\u00aa\u0005h\u0000\u0000\u00aa" +
            ".\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005=\u0000\u0000\u00ac\u00ad\u0005" +
            ">\u0000\u0000\u00ad0\u0001\u0000\u0000\u0000\u00ae\u00af\u0005|\u0000" +
            "\u0000\u00af2\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005f\u0000\u0000\u00b1" +
            "\u00b2\u0005n\u0000\u0000\u00b24\u0001\u0000\u0000\u0000\u00b3\u00b4\u0005" +
            "i\u0000\u0000\u00b4\u00b5\u00053\u0000\u0000\u00b5\u00b6\u00052\u0000" +
            "\u0000\u00b66\u0001\u0000\u0000\u0000\u00b7\u00b8\u0005l\u0000\u0000\u00b8" +
            "\u00b9\u0005o\u0000\u0000\u00b9\u00ba\u0005o\u0000\u0000\u00ba\u00bb\u0005" +
            "p\u0000\u0000\u00bb8\u0001\u0000\u0000\u0000\u00bc\u00bd\u0005f\u0000" +
            "\u0000\u00bd\u00be\u0005o\u0000\u0000\u00be\u00bf\u0005r\u0000\u0000\u00bf" +
            ":\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005i\u0000\u0000\u00c1\u00c2\u0005" +
            "f\u0000\u0000\u00c2<\u0001\u0000\u0000\u0000\u00c3\u00c4\u0005e\u0000" +
            "\u0000\u00c4\u00c5\u0005l\u0000\u0000\u00c5\u00c6\u0005s\u0000\u0000\u00c6" +
            "\u00c7\u0005e\u0000\u0000\u00c7>\u0001\u0000\u0000\u0000\u00c8\u00c9\u0005" +
            "r\u0000\u0000\u00c9\u00ca\u0005e\u0000\u0000\u00ca\u00cb\u0005t\u0000" +
            "\u0000\u00cb\u00cc\u0005u\u0000\u0000\u00cc\u00cd\u0005r\u0000\u0000\u00cd" +
            "\u00ce\u0005n\u0000\u0000\u00ce@\u0001\u0000\u0000\u0000\u00cf\u00d0\u0005" +
            "l\u0000\u0000\u00d0\u00d1\u0005e\u0000\u0000\u00d1\u00d2\u0005t\u0000" +
            "\u0000\u00d2B\u0001\u0000\u0000\u0000\u00d3\u00d4\u0005m\u0000\u0000\u00d4" +
            "\u00d5\u0005u\u0000\u0000\u00d5\u00d6\u0005t\u0000\u0000\u00d6D\u0001" +
            "\u0000\u0000\u0000\u00d7\u00d8\u0005b\u0000\u0000\u00d8\u00d9\u0005r\u0000" +
            "\u0000\u00d9\u00da\u0005e\u0000\u0000\u00da\u00db\u0005a\u0000\u0000\u00db" +
            "\u00dc\u0005k\u0000\u0000\u00dcF\u0001\u0000\u0000\u0000\u00dd\u00de\u0005" +
            "|\u0000\u0000\u00de\u00df\u0005|\u0000\u0000\u00dfH\u0001\u0000\u0000" +
            "\u0000\u00e0\u00e1\u0005&\u0000\u0000\u00e1\u00e2\u0005&\u0000\u0000\u00e2" +
            "J\u0001\u0000\u0000\u0000\u00e3\u00e4\u0005<\u0000\u0000\u00e4\u00e5\u0005" +
            "=\u0000\u0000\u00e5L\u0001\u0000\u0000\u0000\u00e6\u00e7\u0005>\u0000" +
            "\u0000\u00e7\u00e8\u0005=\u0000\u0000\u00e8N\u0001\u0000\u0000\u0000\u00e9" +
            "\u00ea\u0005=\u0000\u0000\u00ea\u00eb\u0005=\u0000\u0000\u00ebP\u0001" +
            "\u0000\u0000\u0000\u00ec\u00ed\u0005!\u0000\u0000\u00ed\u00ee\u0005=\u0000" +
            "\u0000\u00eeR\u0001\u0000\u0000\u0000\u00ef\u00f0\u0005-\u0000\u0000\u00f0" +
            "\u00f1\u0005>\u0000\u0000\u00f1T\u0001\u0000\u0000\u0000\u00f2\u00f6\u0007" +
            "\u0000\u0000\u0000\u00f3\u00f5\u0007\u0001\u0000\u0000\u00f4\u00f3\u0001" +
            "\u0000\u0000\u0000\u00f5\u00f8\u0001\u0000\u0000\u0000\u00f6\u00f4\u0001" +
            "\u0000\u0000\u0000\u00f6\u00f7\u0001\u0000\u0000\u0000\u00f7V\u0001\u0000" +
            "\u0000\u0000\u00f8\u00f6\u0001\u0000\u0000\u0000\u00f9\u00fc\u0003Y,\u0000" +
            "\u00fa\u00fc\u0003[-\u0000\u00fb\u00f9\u0001\u0000\u0000\u0000\u00fb\u00fa" +
            "\u0001\u0000\u0000\u0000\u00fcX\u0001\u0000\u0000\u0000\u00fd\u0103\u0003" +
            "].\u0000\u00fe\u0103\u0003_/\u0000\u00ff\u0103\u0003a0\u0000\u0100\u0103" +
            "\u0003c1\u0000\u0101\u0103\u0003e2\u0000\u0102\u00fd\u0001\u0000\u0000" +
            "\u0000\u0102\u00fe\u0001\u0000\u0000\u0000\u0102\u00ff\u0001\u0000\u0000" +
            "\u0000\u0102\u0100\u0001\u0000\u0000\u0000\u0102\u0101\u0001\u0000\u0000" +
            "\u0000\u0103Z\u0001\u0000\u0000\u0000\u0104\u0108\u0005\"\u0000\u0000" +
            "\u0105\u0107\t\u0000\u0000\u0000\u0106\u0105\u0001\u0000\u0000\u0000\u0107" +
            "\u010a\u0001\u0000\u0000\u0000\u0108\u0109\u0001\u0000\u0000\u0000\u0108" +
            "\u0106\u0001\u0000\u0000\u0000\u0109\u010b\u0001\u0000\u0000\u0000\u010a" +
            "\u0108\u0001\u0000\u0000\u0000\u010b\u010c\u0005\"\u0000\u0000\u010c\\" +
            "\u0001\u0000\u0000\u0000\u010d\u0116\u00050\u0000\u0000\u010e\u0112\u0007" +
            "\u0002\u0000\u0000\u010f\u0111\u0007\u0003\u0000\u0000\u0110\u010f\u0001" +
            "\u0000\u0000\u0000\u0111\u0114\u0001\u0000\u0000\u0000\u0112\u0110\u0001" +
            "\u0000\u0000\u0000\u0112\u0113\u0001\u0000\u0000\u0000\u0113\u0116\u0001" +
            "\u0000\u0000\u0000\u0114\u0112\u0001\u0000\u0000\u0000\u0115\u010d\u0001" +
            "\u0000\u0000\u0000\u0115\u010e\u0001\u0000\u0000\u0000\u0116^\u0001\u0000" +
            "\u0000\u0000\u0117\u011b\u00050\u0000\u0000\u0118\u011a\u0007\u0004\u0000" +
            "\u0000\u0119\u0118\u0001\u0000\u0000\u0000\u011a\u011d\u0001\u0000\u0000" +
            "\u0000\u011b\u0119\u0001\u0000\u0000\u0000\u011b\u011c\u0001\u0000\u0000" +
            "\u0000\u011c`\u0001\u0000\u0000\u0000\u011d\u011b\u0001\u0000\u0000\u0000" +
            "\u011e\u011f\u00050\u0000\u0000\u011f\u0121\u0007\u0005\u0000\u0000\u0120" +
            "\u0122\u0007\u0006\u0000\u0000\u0121\u0120\u0001\u0000\u0000\u0000\u0122" +
            "\u0123\u0001\u0000\u0000\u0000\u0123\u0121\u0001\u0000\u0000\u0000\u0123" +
            "\u0124\u0001\u0000\u0000\u0000\u0124b\u0001\u0000\u0000\u0000\u0125\u0126" +
            "\u0005N\u0000\u0000\u0126\u0127\u0005I\u0000\u0000\u0127\u012c\u0005L" +
            "\u0000\u0000\u0128\u0129\u0005n\u0000\u0000\u0129\u012a\u0005i\u0000\u0000" +
            "\u012a\u012c\u0005l\u0000\u0000\u012b\u0125\u0001\u0000\u0000\u0000\u012b" +
            "\u0128\u0001\u0000\u0000\u0000\u012cd\u0001\u0000\u0000\u0000\u012d\u012e" +
            "\u0005_\u0000\u0000\u012ef\u0001\u0000\u0000\u0000\u012f\u0131\u0007\u0007" +
            "\u0000\u0000\u0130\u012f\u0001\u0000\u0000\u0000\u0131\u0132\u0001\u0000" +
            "\u0000\u0000\u0132\u0130\u0001\u0000\u0000\u0000\u0132\u0133\u0001\u0000" +
            "\u0000\u0000\u0133\u0134\u0001\u0000\u0000\u0000\u0134\u0135\u00063\u0000" +
            "\u0000\u0135h\u0001\u0000\u0000\u0000\u000b\u0000\u00f6\u00fb\u0102\u0108" +
            "\u0112\u0115\u011b\u0123\u012b\u0132\u0001\u0000\u0001\u0000";
    public static final ATN _ATN =
        new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
        new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = makeLiteralNames();
    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);
    public static String[] channelNames = {
        "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
    };
    public static String[] modeNames = {
        "DEFAULT_MODE"
    };

    static {
        RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION);
    }

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

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }

    public tinyRust_2Lexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    private static String[] makeRuleNames() {
        return new String[]{
            "T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8",
            "T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16",
            "T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24",
            "FUNC", "I32", "LOOP", "FOR", "IF", "ELSE", "RETURN", "LET", "MUT", "BREAK",
            "OR", "AND", "LE", "GE", "EQ", "NE", "RARROW", "ID", "LITERAL", "LIT_INT",
            "LIT_STR", "DecimalConstant", "OctalConstant", "HexadecimalConstant",
            "NilConstant", "WildCardConstant", "WS"
        };
    }

    private static String[] makeLiteralNames() {
        return new String[]{
            null, "'('", "')'", "'main'", "'()'", "','", "':'", "'{'", "'}'", "'='",
            "';'", "'+'", "'-'", "'*'", "'/'", "'%'", "'!'", "'<'", "'>'", "'in'",
            "'println!'", "'\"{}\"'", "'..'", "'match'", "'=>'", "'|'", "'fn'", "'i32'",
            "'loop'", "'for'", "'if'", "'else'", "'return'", "'let'", "'mut'", "'break'",
            "'||'", "'&&'", "'<='", "'>='", "'=='", "'!='", "'->'", null, null, null,
            null, null, null, null, null, "'_'"
        };
    }

    private static String[] makeSymbolicNames() {
        return new String[]{
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, "FUNC", "I32", "LOOP", "FOR", "IF", "ELSE", "RETURN", "LET",
            "MUT", "BREAK", "OR", "AND", "LE", "GE", "EQ", "NE", "RARROW", "ID",
            "LITERAL", "LIT_INT", "LIT_STR", "DecimalConstant", "OctalConstant",
            "HexadecimalConstant", "NilConstant", "WildCardConstant", "WS"
        };
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
    public String getGrammarFileName() {
        return "tinyRust.g4";
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
}