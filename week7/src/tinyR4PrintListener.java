import generated.tinyR4BaseListener;
import generated.tinyR4Parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class tinyR4PrintListener extends tinyR4BaseListener implements ParseTreeListener {

    private static final int INDENT = 4;  // 들여쓰기 크기: 4칸
    private int indentCnt = 0;  // 현재 들여쓰기 횟수를 카운트
    private static String output;  // 프로그램의 최종 출력 결과
    ParseTreeProperty<String> r4Tree = new ParseTreeProperty<>();  // 각 구문 노드의 문자열 저장

    // 파싱 결과를 반환하는 getter 메서드
    public static String getOutput() {
        return output;
    }

    // 현재 들여쓰기 횟수에 맞는 공백 문자열을 반환하는 getter 메서드
    private String getIndent() {
        return " ".repeat(indentCnt * INDENT);
    }

    // 프로그램의 exit 규칙 메서드: 전체 프로그램을 문자열로 변환
    @Override
    public void exitProgram(tinyR4Parser.ProgramContext ctx) {
        StringBuilder program = new StringBuilder();

        // 모든 선언을 문자열로 추가
        for (int i = 0; i < ctx.decl().size(); i++) {
            program.append(r4Tree.get(ctx.decl(i)));
        }

        // 최종 프로그램 문자열을 저장
        output = program.toString();
    }

    // decl 규칙의 exit 메서드
    @Override
    public void exitDecl(tinyR4Parser.DeclContext ctx) {
        String fun_decl = r4Tree.get(ctx.fun_decl());  // 함수 선언(fun_decl)을 처리하여 decl의 문자열로 저장
        r4Tree.put(ctx, fun_decl);
    }

    // fun_decl 규칙의 exit 메서드
    @Override
    public void exitFun_decl(tinyR4Parser.Fun_declContext ctx) {
        String fun = ctx.FUNC().getText();  // "fn" 키워드
        String id = r4Tree.get(ctx.id());  // 함수 이름
        String params = r4Tree.get(ctx.params());  // 매개변수 목록
        String ret_type_spec = r4Tree.get(ctx.ret_type_spec());  // 반환 타입
        String compound_stmt = r4Tree.get(ctx.compound_stmt());  // 함수 본문
        r4Tree.put(ctx, fun + " " + id + "(" + params + ") " + ret_type_spec + compound_stmt);
    }

    // 매개변수(params) 규칙의 exit 메서드
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

    // 타입(type_spec) 규칙의 exit 메서드
    @Override
    public void exitType_spec(tinyR4Parser.Type_specContext ctx) {
        r4Tree.put(ctx, ctx.U32().getText());  // 타입 문자열 (u32) 처리 후 저장
    }

    // 반환 타입(ret_type_spec) 규칙의 exit 메서드
    @Override
    public void exitRet_type_spec(tinyR4Parser.Ret_type_specContext ctx) {
        if (ctx.getChildCount() == 0) {
            r4Tree.put(ctx, "");  // 반환 타입이 없는 경우 빈 문자열로 설정
        }
    }

    // 복합 구문(compound_stmt)의 exit 메서드
    @Override
    public void exitCompound_stmt(tinyR4Parser.Compound_stmtContext ctx) {
        StringBuilder result = new StringBuilder();

        // 지역 변수 선언을 처리하여 결과에 추가
        int local_count = ctx.local_decl().size();
        for (int i = 0; i < local_count; i++) {
            result.append(r4Tree.get(ctx.local_decl(i)));
        }

        // 문장을 처리하여 결과에 추가
        int stmt_count = ctx.stmt().size();
        for (int i = 0; i < stmt_count; i++) {
            result.append(r4Tree.get(ctx.stmt(i)));
        }

        // 전체 구문을 중괄호로 감싸고, 변환된 결과를 저장
        r4Tree.put(ctx, "{" + result + "}");
    }

    // 값(val) 규칙의 exit 메서드
    @Override
    public void exitVal(tinyR4Parser.ValContext ctx) {
        String result = "";
        if (ctx.literal() != null) {  // 리터럴이 있는 경우
            result = r4Tree.get(ctx.literal());
        } else if (ctx.id() != null) {  // 식별자가 있는 경우
            result = r4Tree.get(ctx.id());
        }
        r4Tree.put(ctx, result);
    }

    // 문장(stmt) 규칙의 exit 메서드
    @Override
    public void exitStmt(tinyR4Parser.StmtContext ctx) {
        String result = "";
        if (ctx.expr_stmt() != null) {  // 표현식 문장을 처리하고 결과에 추가
            result = r4Tree.get(ctx.expr_stmt());
        } else if (ctx.compound_stmt() != null) {  // 복합 문장인 경우
            result = r4Tree.get(ctx.compound_stmt());
        } else if (ctx.if_stmt() != null) {  // if 문인 경우
            result = r4Tree.get(ctx.if_stmt());
        } else if (ctx.for_stmt() != null) {  // for 문인 경우
            result = r4Tree.get(ctx.for_stmt());
        }
        r4Tree.put(ctx, result);
    }

    // 표현식 문장(expr_stmt)의 exit 메서드
    @Override
    public void exitExpr_stmt(tinyR4Parser.Expr_stmtContext ctx) {
        String expr = r4Tree.get(ctx.expr());
        r4Tree.put(ctx, expr + ";");  // 표현식에 세미콜론 추가
    }

    // 표현식(expr) 규칙의 exit 메서드
    @Override
    public void exitExpr(tinyR4Parser.ExprContext ctx) {
        String result = "";
        if (ctx.additive_expr() != null) {  // 덧셈식이 있는 경우
            result = r4Tree.get(ctx.additive_expr());
        } else if (ctx.relative_expr() != null) {  // 논리 표현식이 있는 경우
            result = r4Tree.get(ctx.relative_expr());
        }
        r4Tree.put(ctx, result);
    }

    // 덧셈 표현식(additive_expr)의 exit 메서드
    @Override
    public void exitAdditive_expr(tinyR4Parser.Additive_exprContext ctx) {
        String result = "";
        if (ctx.additive_expr() != null) {  // 덧셈식이 중첩된 경우
            String left = r4Tree.get(ctx.additive_expr());  // 왼쪽 피연산자
            String op = ctx.getChild(1).getText();  // 연산자
            String right = r4Tree.get(ctx.multiplicative_expr());  // 오른쪽 피연산자
            result = left + " " + op + " " + right;
        } else {  // 단일 항의 경우 그대로 처리
            result = r4Tree.get(ctx.multiplicative_expr());  // 곱셈 표현식 결과
        }
        r4Tree.put(ctx, result);
    }

    // 곱셈 표현식(multiplicative_expr)의 exit 메서드
    @Override
    public void exitMultiplicative_expr(tinyR4Parser.Multiplicative_exprContext ctx) {
        String result = "";
        if (ctx.multiplicative_expr() != null) {  // 곱셈식이 중첩된 경우
            String left = r4Tree.get(ctx.multiplicative_expr());  // 왼쪽 피연산자
            String op = ctx.getChild(1).getText();  // 연산자
            String right = r4Tree.get(ctx.unary_expr());  // 오른쪽 피연산자
            result = left + " " + op + " " + right;
        } else {  // 단일 항의 경우 그대로 처리
            result = r4Tree.get(ctx.unary_expr());  // 단항 표현식 결과
        }
        r4Tree.put(ctx, result);
    }

    // 단항 표현식(unary_expr)의 exit 메서드
    @Override
    public void exitUnary_expr(tinyR4Parser.Unary_exprContext ctx) {
        String result = "";
        if (ctx.expr() != null) {  // 표현식이 있는 경우
            String op = ctx.getChild(0).getText();  // 연산자
            String expr = r4Tree.get(ctx.expr());  // 표현식 결과
            result = op + expr;
        } else {  // 표현식이 없는 경우
            result = r4Tree.get(ctx.factor());  // 인수 결과
        }
        r4Tree.put(ctx, result);
    }

    // 인수(factor) 규칙의 exit 메서드
    @Override
    public void exitFactor(tinyR4Parser.FactorContext ctx) {
        String result = "";
        if (ctx.expr() != null) {  // 표현식이 괄호로 감싸진 경우
            result = "(" + r4Tree.get(ctx.expr()) + ")";
        } else {
            if (ctx.literal() != null) {  // 리터럴이 있는 경우
                result = r4Tree.get(ctx.literal());  // 리터럴 값
            } else {  // 리터럴이 없는 경우
                result = r4Tree.get(ctx.id());

                // 매크로 호출 처리
                if (ctx.getChildCount() > 1 && ctx.getChild(1).getText().equals("!")) {
                    result += "!";  // 함수 호출 뒤에 느낌표 추가
                }

                // 함수 호출에 인자가 있는 경우 처리
                if (ctx.args() != null) {
                    result += "(" + r4Tree.get(ctx.args()) + ")";
                }
            }
        }
        r4Tree.put(ctx, result);
    }

    // 논리 표현식(relative_expr)의 exit 메서드
    @Override
    public void exitRelative_expr(tinyR4Parser.Relative_exprContext ctx) {
        String result = "";
        if (ctx.relative_expr() != null) {  // 논리 표현식이 중첩된 경우
            String left = r4Tree.get(ctx.relative_expr());  // 왼쪽 피연산자
            String op = ctx.getChild(1).getText();  // 논리 연산자
            String right = r4Tree.get(ctx.comparative_expr());  // 오른쪽 피연산자
            result = left + " " + op + " " + right;
        } else {  // 단일 항의 경우 그대로 처리
            result = r4Tree.get(ctx.comparative_expr());  // 비교 표현식 결과
        }
        r4Tree.put(ctx, result);
    }

    // 비교 표현식(comparative_expr)의 exit 메서드
    @Override
    public void exitComparative_expr(tinyR4Parser.Comparative_exprContext ctx) {
        String result = "";
        if (ctx.comparative_expr() != null) {  // 비교 표현식이 중첩된 경우
            String left = r4Tree.get(ctx.comparative_expr());  // 왼쪽 피연산자
            String op = ctx.getChild(1).getText();  // 비교 연산자
            String right = r4Tree.get(ctx.additive_expr());  // 오른쪽 피연산자
            result = left + " " + op + " " + right;
        } else {  // 단일 항의 경우 그대로 처리
            result = r4Tree.get(ctx.additive_expr());  // 덧셈 표현식 결과를 가져옴
        }
        r4Tree.put(ctx, result);
    }

    // if 문(if_stmt)의 exit 메서드
    @Override
    public void exitIf_stmt(tinyR4Parser.If_stmtContext ctx) {
        StringBuilder result = new StringBuilder();

        // "if" 키워드와 조건식 추가
        result.append("if ");
        result.append(r4Tree.get(ctx.relative_expr()));  // 조건식 처리

        // if 블록 추가
        result.append(" ");
        result.append(r4Tree.get(ctx.compound_stmt(0)));

        // else 블록이 있는 경우 처리
        if (ctx.ELSE() != null) {
            result.append(" else ");
            result.append(r4Tree.get(ctx.compound_stmt(1)));  // else 블록 처리
        }

        r4Tree.put(ctx, result.toString());
    }

    // for 문(for_stmt)의 exit 메서드
    @Override
    public void exitFor_stmt(tinyR4Parser.For_stmtContext ctx) {
        StringBuilder result = new StringBuilder();

        // "for" 키워드와 반복 변수 및 범위 추가
        result.append("for ");
        result.append(r4Tree.get(ctx.id()));  // 반복 변수
        result.append(" in ");
        result.append(r4Tree.get(ctx.range()));  // 반복 범위

        // for 블록 추가
        result.append(" ");
        result.append(r4Tree.get(ctx.compound_stmt()));

        r4Tree.put(ctx, result.toString());
    }

    // 반복 범위(range)의 exit 메서드
    @Override
    public void exitRange(tinyR4Parser.RangeContext ctx) {
        StringBuilder result = new StringBuilder();

        // 범위의 시작 리터럴
        result.append(r4Tree.get(ctx.literal(0)));
        result.append("..");  // 범위 연산자 추가

        // 범위의 "=" 고려
        if (ctx.getChildCount() == 4) {
            result.append("=");
        }

        // 범위의 끝 리터럴 추가
        result.append(r4Tree.get(ctx.literal(1)));

        r4Tree.put(ctx, result.toString());
    }

    // 인자 목록(args) 규칙의 exit 메서드
    @Override
    public void exitArgs(tinyR4Parser.ArgsContext ctx) {
        StringBuilder args = new StringBuilder();

        // 각 인자를 쉼표로 구분하여 처리
        for (int i = 0; i < ctx.expr().size(); i++) {
            if (i > 0) {
                args.append(", ");
            }
            args.append(r4Tree.get(ctx.expr(i)));
        }

        r4Tree.put(ctx, args.toString());
    }

    // 리터럴(literal) 규칙의 exit 메서드
    @Override
    public void exitLiteral(tinyR4Parser.LiteralContext ctx) {
        r4Tree.put(ctx, ctx.LITERAL().getText());
    }

    // 식별자(id) 규칙의 exit 메서드
    @Override
    public void exitId(tinyR4Parser.IdContext ctx) {
        r4Tree.put(ctx, ctx.ID().getText());
    }

}
