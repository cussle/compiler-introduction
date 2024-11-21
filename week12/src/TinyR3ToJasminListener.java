import generated.tinyR3BaseListener;
import generated.tinyR3Parser;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class TinyR3ToJasminListener extends tinyR3BaseListener {
    private JasminCodeGenerator jasmin = new JasminCodeGenerator();  // Jasmin 코드를 저장할 객체
    private SymbolTable symbolTable = new SymbolTable();  // 변수 이름과 로컬 변수 인덱스를 매핑
    private ParseTreeProperty<Integer> exprStack = new ParseTreeProperty<>();  // 각 표현식 노드에서의 스택 사용량을 저장

    // 메인 함수 선언에 진입할 때 호출
    @Override
    public void enterMain_decl(tinyR3Parser.Main_declContext ctx) {
        // 메인 메서드 선언 시작
        jasmin.addLine(".method public static main([Ljava/lang/String;)V");

        // 스택과 로컬 변수의 최대 크기를 설정
        jasmin.addLine(".limit stack 32");
        jasmin.addLine(".limit locals 32");
    }

    // 메인 함수 선언에서 나올 때 호출
    @Override
    public void exitMain_decl(tinyR3Parser.Main_declContext ctx) {
        // 메인 메서드 종료 전에 return 명령어 추가
        jasmin.addLine("return");

        // 메서드 종료
        jasmin.addLine(".end method");
    }

    // 지역 변수 선언 처리
    // 변수의 초기화 값에 따라 적절한 Bytecode를 생성하고, 변수의 인덱스를 심볼 테이블에 등록
    @Override
    public void exitLocal_decl(tinyR3Parser.Local_declContext ctx) {
        // 변수 이름 추출
        String varName = ctx.id().getText();
        // 초기화 값 추출 (리터럴 또는 식별자)
        String value = ctx.val().getText();

        // 심볼 테이블에 변수 이름을 추가하고 로컬 변수 인덱스를 얻음
        int varIndex = symbolTable.addVariable(varName);

        // 초기화 값 로드
        loadValue(expr);

        // 값을 현재 변수에 저장
        jasmin.addLine("istore_" + varIndex);
    }

    // 표현식 문장 처리
    // 현재는 변수 할당(=)과 같은 단순 표현식만 처리
    @Override
    public void exitExpr(tinyR3Parser.ExprContext ctx) {
        // 표현식이 할당문인 경우 (예: a = 5)
        if (ctx.getChildCount() == 3 && ctx.getChild(1).getText().equals("=")) {
            // 왼쪽 피연산자: 변수 이름
            String varName = ctx.id().getText();
            // 오른쪽 피연산자: 표현식 (리터럴 또는 변수)
            String expr = ctx.expr().getText();

            // 변수의 로컬 인덱스 가져오기
            int varIndex = symbolTable.getVariableIndex(varName);

            // 표현식 값 로드
            loadValue(expr);

            // 값을 현재 변수에 저장
            jasmin.addLine("istore_" + varIndex);
        }
    }

    // 덧셈 및 뺄셈 연산 처리
    @Override
    public void exitAdditive_expr(tinyR3Parser.Additive_exprContext ctx) {
        // 이항 연산인 경우 (예: a + b)
        if (ctx.getChildCount() == 3) {
            // 왼쪽 피연산자: 덧셈 표현식 (재귀적으로 처리)
            String left = ctx.additive_expr().getText();
            // 연산자: + 또는 -
            String op = ctx.op.getText();
            // 오른쪽 피연산자: 곱셈 표현식
            String right = ctx.multiplicative_expr().getText();

            // 왼쪽 피연산자 처리
            loadValue(left);

            // 오른쪽 피연산자 처리
            loadValue(right);

            // 연산자에 따라 적절한 Bytecode 명령어 추가
            switch (op) {
                case "+":
                    jasmin.addLine("iadd"); // 덧셈
                    break;
                case "-":
                    jasmin.addLine("isub"); // 뺄셈
                    break;
                default:
                    throw new UnsupportedOperationException("지원되지 않는 연산자: " + op);
            }
        }
    }

    // 곱셈, 나눗셈, 나머지 연산 처리
    @Override
    public void exitMultiplicative_expr(tinyR3Parser.Multiplicative_exprContext ctx) {
        // 이항 연산인 경우 (예: a * b)
        if (ctx.getChildCount() == 3) {
            // 왼쪽 피연산자: 곱셈 표현식 (재귀적으로 처리)
            String left = ctx.multiplicative_expr().getText();
            // 연산자: *, /, 또는 %
            String op = ctx.op.getText();
            // 오른쪽 피연산자: 단항 표현식
            String right = ctx.unary_expr().getText();

            // 왼쪽 피연산자 처리
            loadValue(left);

            // 오른쪽 피연산자가 정수 리터럴인지 확인
            loadValue(right);

            // 연산자에 따라 적절한 Bytecode 명령어 추가
            switch (op) {
                case "*":
                    jasmin.addLine("imul"); // 곱셈
                    break;
                case "/":
                    jasmin.addLine("idiv"); // 나눗셈
                    break;
                case "%":
                    jasmin.addLine("irem"); // 나머지
                    break;
                default:
                    throw new UnsupportedOperationException("지원되지 않는 연산자: " + op);
            }
        }
    }

    // `println!` 구문 처리
    @Override
    public void exitPrint_stmt(tinyR3Parser.Print_stmtContext ctx) {
        // System.out.println을 호출하기 위한 Bytecode 명령어 추가
        jasmin.addLine("getstatic java/lang/System/out Ljava/io/PrintStream;");

        // 출력할 변수의 이름 추출
        String varName = ctx.id().getText();

        // 해당 변수의 값을 로드
        jasmin.addLine("iload_" + symbolTable.getVariableIndex(varName));

        // PrintStream의 println 메서드 호출
        jasmin.addLine("invokevirtual java/io/PrintStream/println(I)V");
    }

    // `return` 구문 처리
    @Override
    public void exitReturn_stmt(tinyR3Parser.Return_stmtContext ctx) {
        // return 명령어 추가
        jasmin.addLine("return");
    }

    // Listener가 생성한 Jasmin 코드를 반환하는 메서드
    public String getJasminCode() {
        return jasmin.getCode();
    }

    // 문자열이 정수 리터럴인지 확인하는 메서드
    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // 리터럴 또는 변수 값을 로드하는 메서드
    private void loadValue(String value) {
        // 초기화 값이 정수 리터럴인 경우
        if (isInteger(value)) {
            loadInteger(Integer.parseInt(value));
        } else {
            // 값이 변수인 경우 변수 로드
            jasmin.addLine("iload_" + symbolTable.getVariableIndex(value));
        }
    }

    // 정수 값을 로드하는 메서드
    private void loadInteger(int intValue) {
        if (intValue >= -1 && intValue <= 5) {
            jasmin.addLine("iconst_" + intValue); // 예: iconst_5
        } else if (intValue >= -128 && intValue <= 127) {
            jasmin.addLine("bipush " + intValue); // 예: bipush 100
        } else if (intValue >= -32768 && intValue <= 32767) {
            jasmin.addLine("sipush " + intValue); // 예: sipush 1000
        } else {
            jasmin.addLine("ldc " + intValue);    // 예: ldc 100000
        }
    }
}
