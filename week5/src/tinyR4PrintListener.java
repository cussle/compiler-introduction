import generated.tinyR4BaseListener;
import generated.tinyR4Parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class tinyR4PrintListener extends tinyR4BaseListener implements ParseTreeListener {

    private static String output;  // 프로그램의 최종 출력 결과
    ParseTreeProperty<String> r4Tree = new ParseTreeProperty<>();  // 각 구문 노드의 문자열 저장

    // 파싱 결과를 반환하는 getter 메서드
    public static String getOutput() {
        return output;
    }

    // program 규칙에 대한 exit 메서드
    @Override
    public void exitProgram(tinyR4Parser.ProgramContext ctx) {
        StringBuilder program = new StringBuilder();

        // 모든 선언을 문자열로 추가
        for (int i = 0; i < ctx.decl().size(); i++) {
            String decl = r4Tree.get(ctx.decl(i));
            if (decl != null) {
                program.append(decl).append("\n");
            }
        }

        // 최종 프로그램 문자열을 저장
        output = program.toString();
    }

    // decl 규칙에 대한 exit 메서드
    @Override
    public void exitDecl(tinyR4Parser.DeclContext ctx) {
        if (ctx.fun_decl() != null) {
            String funDecl = r4Tree.get(ctx.fun_decl());
            if (funDecl != null) {
                r4Tree.put(ctx, funDecl);
            }
        }
    }

    // fun_decl 규칙에 대한 exit 메서드
    @Override
    public void exitFun_decl(tinyR4Parser.Fun_declContext ctx) {
        // 함수의 이름
        String funcName = ctx.id().getText();

        // 함수의 파라미터
        String params = "";
        if (!ctx.params().param().isEmpty()) {
            params = r4Tree.get(ctx.params());
        }

        // 함수의 리턴 타입
        String retType = "";
        if (ctx.ret_type_spec().type_spec() != null) {
            retType = " -> " + r4Tree.get(ctx.ret_type_spec());
        }

        // 함수의 본문
        String compoundStmt = r4Tree.get(ctx.compound_stmt());

        // 함수 선언 문자열 생성
        String funcDecl = "fn " + funcName + "(" + params + ")" + retType + " " + compoundStmt;
        r4Tree.put(ctx, funcDecl);
    }

    // params 규칙에 대한 exit 메서드
    @Override
    public void exitParams(tinyR4Parser.ParamsContext ctx) {
        StringBuilder params = new StringBuilder();

        // 모든 파라미터를 문자열로 추가
        for (int i = 0; i < ctx.param().size(); i++) {
            if (i > 0) {
                params.append(", ");
            }
            params.append(r4Tree.get(ctx.param(i)));
        }
        r4Tree.put(ctx, params.toString());
    }

    // param 규칙에 대한 exit 메서드
    @Override
    public void exitParam(tinyR4Parser.ParamContext ctx) {
        // 파라미터를 < id: type_spec > 형태로 추가
        String param = ctx.id().getText() + ": " + ctx.type_spec().getText();
        r4Tree.put(ctx, param);
    }

    // ret_type_spec 규칙에 대한 exit 메서드
    @Override
    public void exitRet_type_spec(tinyR4Parser.Ret_type_specContext ctx) {
        if (ctx.type_spec() != null) {
            r4Tree.put(ctx, ctx.type_spec().getText());
        }
    }

    // compound_stmt 규칙에 대한 exit 메서드
    @Override
    public void exitCompound_stmt(tinyR4Parser.Compound_stmtContext ctx) {
        StringBuilder compoundStmt = new StringBuilder();
        compoundStmt.append("{\n");

        // 모든 stmt를 문자열로 추가
        for (int i = 0; i < ctx.stmt().size(); i++) {
            String stmt = r4Tree.get(ctx.stmt(i));
            if (stmt != null) {
                compoundStmt.append(stmt).append("\n");
            }
        }
        compoundStmt.append("}");
        r4Tree.put(ctx, compoundStmt.toString());
    }

    // stmt 규칙에 대한 exit 메서드
    @Override
    public void exitStmt(tinyR4Parser.StmtContext ctx) {
        if (ctx.expr_stmt() != null) {
            String exprStmt = r4Tree.get(ctx.expr_stmt());
            if (exprStmt != null) {
                r4Tree.put(ctx, exprStmt);
            }
        }
    }

    // expr_stmt 규칙에 대한 exit 메서드
    @Override
    public void exitExpr_stmt(tinyR4Parser.Expr_stmtContext ctx) {
        String expr = r4Tree.get(ctx.expr());
        if (expr != null) {
            // 표현식에 세미콜론 추가
            r4Tree.put(ctx, expr + ";");
        }
    }

    // expr 규칙에 대한 exit 메서드
    @Override
    public void exitExpr(tinyR4Parser.ExprContext ctx) {
        if (ctx.additive_expr() != null) {
            r4Tree.put(ctx, r4Tree.get(ctx.additive_expr()));
        }
    }

    // additive_expr 규칙에 대한 exit 메서드
    @Override
    public void exitAdditive_expr(tinyR4Parser.Additive_exprContext ctx) {
        if (ctx.op != null) {  // 다중 항의 경우 각각 처리
            String left = r4Tree.get(ctx.left);
            String right = r4Tree.get(ctx.right);
            if (left != null && right != null) {
                String expr = left + " " + ctx.op.getText() + " " + right;
                r4Tree.put(ctx, expr);
            }
        } else {  // 단일 항의 경우 그대로 처리
            r4Tree.put(ctx, r4Tree.get(ctx.multiplicative_expr()));
        }
    }

    // multiplicative_expr 규칙에 대한 exit 메서드
    @Override
    public void exitMultiplicative_expr(tinyR4Parser.Multiplicative_exprContext ctx) {
        if (ctx.op != null) {  // 다중 항의 경우 각각 처리
            String left = r4Tree.get(ctx.left);
            String right = r4Tree.get(ctx.right);
            if (left != null && right != null) {
                String expr = left + " " + ctx.op.getText() + " " + right;
                r4Tree.put(ctx, expr);
            }
        } else {  // 단일 항의 경우 그대로 처리
            r4Tree.put(ctx, r4Tree.get(ctx.unary_expr()));
        }
    }

    // unary_expr 규칙에 대한 exit 메서드
    @Override
    public void exitUnary_expr(tinyR4Parser.Unary_exprContext ctx) {
        if (ctx.op != null) {  // op + expr 형태의 경우
            String expr = ctx.op.getText() + r4Tree.get(ctx.expr());
            r4Tree.put(ctx, expr);
        } else {  // factor 의 형태일 경우
            r4Tree.put(ctx, r4Tree.get(ctx.factor()));
        }
    }

    // factor 규칙에 대한 exit 메서드
    @Override
    public void exitFactor(tinyR4Parser.FactorContext ctx) {
        if (ctx.literal() != null) {  // literal 형태
            r4Tree.put(ctx, ctx.literal().getText());
        } else if (ctx.id() != null) {    // id 형태
            r4Tree.put(ctx, ctx.id().getText());
        } else if (ctx.expr() != null) {  // expr 형태 (괄호)
            String expr = r4Tree.get(ctx.expr());
            if (expr != null) {
                r4Tree.put(ctx, "(" + expr + ")");
            }
        }
    }
}
