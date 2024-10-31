import generated.tinyR4Lexer;
import generated.tinyR4Parser;
import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Main {

    public static void main(String[] args) throws IOException {
        // 파일에서 입력 스트림을 읽고, lexer를 통해 토큰화
        CharStream code = CharStreams.fromFileName("./src/test.tr");
        tinyR4Lexer lexer = new tinyR4Lexer(code);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // 파서를 통해 프로그램을 파싱한 후 파스트리 생성
        tinyR4Parser parser = new tinyR4Parser(tokens);
        ParseTree tree = parser.program();

        // walker를 사용해 파스트리를 순회하며 listener가 이벤트를 처리하도록 함
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new tinyR4PrintListener(), tree);

        // 파싱 결과 출력
        System.out.println(tinyR4PrintListener.getOutput());
    }
}
