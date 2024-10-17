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

    // 함수 decl을 방문하여 함수 처리
    @Override
    public void exitFun_decl(tinyR4Parser.Fun_declContext ctx) {
        StringBuilder function = new StringBuilder("fn " + ctx.id().getText() + "(");

        // 함수의 파라미터 처리
        if (ctx.params() != null && ctx.params().param() != null) {
            for (int i = 0; i < ctx.params().param().size(); i++) {
                if (i > 0) {
                    function.append(", ");
                }
                function.append(ctx.params().param(i).id().getText()).append(": ")
                    .append(ctx.params().param(i).type_spec().getText());
            }
        }
        function.append(") ");

        // 함수의 리턴 처리
        if (ctx.ret_type_spec() != null && ctx.ret_type_spec().type_spec() != null) {
            function.append("-> ").append(ctx.ret_type_spec().type_spec().getText()).append(" ");
        }

        function.append(r4Tree.get(ctx.compound_stmt())).append("\n");
        r4Tree.put(ctx, function.toString());
    }

    // 복합 stmt 처리
    @Override
    public void exitCompound_stmt(tinyR4Parser.Compound_stmtContext ctx) {
        StringBuilder compoudStmt = new StringBuilder();
        compoudStmt.append("{\n");
        for (int i = 0; i < ctx.stmt().size(); i++) {
            compoudStmt.append(r4Tree.get(ctx.stmt(i))).append("\n");
        }
        compoudStmt.append("}\n");
        r4Tree.put(ctx, compoudStmt.toString());
    }
}
