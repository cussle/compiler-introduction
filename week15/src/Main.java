import generated.tinyRustLexer;
import generated.tinyRustParser;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {
        // 입력 파일 경로 설정
        String inputFile = "Test.tr";

        try {
            // CharStream으로 입력 파일 읽기
            CharStream code = CharStreams.fromFileName("./src/" + inputFile);

            // Lexer 및 TokenStream 생성
            tinyRustLexer lexer = new tinyRustLexer(code);
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            // Parser 생성 및 파싱 시작
            tinyRustParser parser = new tinyRustParser(tokens);
            ParseTree tree = parser.program();

            // Listener 생성 및 트리 순회
            tinyRustListener listener = new tinyRustListener();
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(listener, tree);
        } catch (RuntimeException e) {
            logger.log(Level.SEVERE, "Main > > > 오류 발생", e);
        }
    }
}
