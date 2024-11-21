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

    // 지역 변수 선언을 처리
    // 변수의 초기화 값에 따라 적절한 Bytecode를 생성하고, 변수의 인덱스를 심볼 테이블에 등록
    @Override
    public void exitLocal_decl(tinyR3Parser.Local_declContext ctx) {
        // 변수 이름 추출
        String varName = ctx.id().getText();
        // 초기화 값 추출 (리터럴 또는 식별자)
        String value = ctx.val().getText();

        // 심볼 테이블에 변수 이름을 추가하고 로컬 변수 인덱스를 얻음
        int varIndex = symbolTable.addVariable(varName);

        // 초기화 값이 정수 리터럴인 경우
        if (isInteger(value)) {
            int intValue = Integer.parseInt(value);
            // 상수 로딩: 값의 크기에 따라 적절한 명령어 선택
            if (intValue >= -1 && intValue <= 5) {
                jasmin.addLine("iconst_" + intValue); // 예: iconst_5
            } else if (intValue >= -128 && intValue <= 127) {
                jasmin.addLine("bipush " + intValue); // 예: bipush 100
            } else if (intValue >= -32768 && intValue <= 32767) {
                jasmin.addLine("sipush " + intValue); // 예: sipush 1000
            } else {
                jasmin.addLine("ldc " + intValue);    // 예: ldc 100000
            }
            // 값을 로컬 변수에 저장
            jasmin.addLine("istore_" + varIndex);
        } else {
            // 초기화 값이 다른 변수인 경우
            // 해당 변수의 값을 로드
            jasmin.addLine("iload_" + symbolTable.getVariableIndex(value));
            // 값을 현재 변수에 저장
            jasmin.addLine("istore_" + varIndex);
        }
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
}
