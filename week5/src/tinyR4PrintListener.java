import generated.tinyR4BaseListener;
import generated.tinyR4Parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class tinyR4PrintListener extends tinyR4BaseListener implements ParseTreeListener {

    private static String output;  // 프로그램의 출력 결과
    ParseTreeProperty<String> r4Tree = new ParseTreeProperty<>();  // 파스트리의 각각의 노드 값을 저장

    // 파싱 결과를 얻기 위한 static 메서드
    public static String getOutput() {
        return output;
    }

    // 프로그램 전체를 방문한 후 decl을 처리하여 output을 설정
    @Override
    public void exitProgram(tinyR4Parser.ProgramContext ctx) {
        StringBuilder program = new StringBuilder();
        for (int i = 0; i < ctx.decl().size(); i++) {
            // 각 decl의 출력을 가져와 문자열에 추가
            program.append(r4Tree.get(ctx.decl(i)));
        }
        output = program.toString();
    }
}
