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
}
