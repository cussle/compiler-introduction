import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import generated.tinyR4Lexer;
import generated.tinyR4Parser;
public class TestMain {
    public static void main(String[] args) throws Exception {
        tinyR4Lexer lexer = new tinyR4Lexer(CharStreams.fromFileName("test.tr"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tinyR4Parser parser = new tinyR4Parser(tokens);
        ParseTree tree = parser.program();
    }
}
