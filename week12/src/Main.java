import generated.tinyR3Lexer;
import generated.tinyR3Parser;
import java.io.FileWriter;
import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Main {

    public static void main(String[] args) throws IOException {
        // 입력 파일 경로 설정
        String inputFile = "Test.tr";
        String outputFile = "Test.j";

        // CharStream으로 입력 파일 읽기
        CharStream code = CharStreams.fromFileName("./src/" + inputFile);

        // Lexer 및 TokenStream 생성
        tinyR3Lexer lexer = new tinyR3Lexer(code);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Parser 생성 및 파싱 시작
        tinyR3Parser parser = new tinyR3Parser(tokens);
        tinyR3Parser.ProgramContext tree = parser.program();

        // Listener 생성 및 트리 순회
        TinyR3ToJasminListener listener = new TinyR3ToJasminListener();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, tree);

        // 생성된 Jasmin 코드 가져오기
        String jasminCode = listener.getJasminCode();

        // Jasmin 코드 파일로 저장
        FileWriter writer = new FileWriter(outputFile);
        writer.write(jasminCode);
        writer.close();

        System.out.println(jasminCode);
    }
}