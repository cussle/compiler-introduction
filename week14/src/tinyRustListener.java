import generated.tinyRustBaseListener;
import generated.tinyRustParser;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class tinyRustListener extends tinyRustBaseListener implements ParseTreeListener {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    ParseTreeProperty<String> rustTree = new ParseTreeProperty<>();
    private static FileWriter fw;
    static HashMap<String, Integer> localVarMap;
    static int nextVarIndex = 0;
    static int labelIndex = 1;

    // 현재 루프의 종료 레이블을 저장하기 위한 변수
    private String currentLoopEndLabel = null;

    private static void assignLocalVar(String varName) {
        localVarMap.computeIfAbsent(varName, k -> nextVarIndex++);
    }

    private static int getLocalVarTableIdx(String varName) {
        if (!localVarMap.containsKey(varName)) {
            throw new RuntimeException("=== 정의되지 않은 변수: " + varName);
        }
        return localVarMap.get(varName);
    }

    @Override
    public void enterProgram(tinyRustParser.ProgramContext ctx) {
        // 파일 출력 (변경 필요)
        File outputFile = new File("./Test.j");

        //변수 테이블
        localVarMap = new HashMap<>();

        try {
            if (!outputFile.exists()) {
                if (!outputFile.createNewFile()) {
                    throw new Exception("파일 생성 실패");
                }
            }

            fw = new FileWriter(outputFile);

            // 클래스 정의 시작 및 기본 생성자 정의
            fw.write("""
                .class public Test
                .super java/lang/Object
                ; standard initializer
                .method public <init>()V
                aload_0
                invokenonvirtual java/lang/Object/<init>()V
                return
                .end method\n
                """);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "enterProgram > > > 오류 발생", e);
        }
    }

    @Override
    public void exitProgram(tinyRustParser.ProgramContext ctx) {
        StringBuilder program = new StringBuilder();
        for (int i = 0; i < ctx.decl().size(); i++) {
            program.append(rustTree.get(ctx.decl(i)));
        }

        // 프로그램 끝 : output 파일에 write
        try {
            fw.write(program.toString());
            fw.flush();

            fw.close();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "exitProgram > > > 오류 발생", e);
        }
    }

    @Override
    public void exitDecl(tinyRustParser.DeclContext ctx) {
        String main_decl = rustTree.get(ctx.main_decl());
        rustTree.put(ctx, main_decl);
    }

    @Override
    public void enterMain_decl(tinyRustParser.Main_declContext ctx) {
        // Main_decl은 main 함수이므로 main을 위한 자료구조 및 변수 초기화
        try {
            // 메인 메서드 선언 시작 및 스택과 로컬 변수의 최대 크기 설정
            fw.write("""
                .method public static main([Ljava/lang/String;)V
                .limit stack 32
                .limit locals 32
                """);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "enterMain_decl > > > 오류 발생", e);
        }
    }

    @Override
    public void exitMain_decl(tinyRustParser.Main_declContext ctx) {
        String compound_stmt = rustTree.get(ctx.compound_stmt());
        rustTree.put(ctx, compound_stmt + "\n" + ".end method\n");
    }

    @Override
    public void exitCompound_stmt(tinyRustParser.Compound_stmtContext ctx) {
        StringBuilder result = new StringBuilder();
        int local_count = ctx.local_decl().size();
        int stmt_count = ctx.stmt().size();
        for (int i = 0; i < local_count; i++) {
            result.append(rustTree.get(ctx.local_decl(i)));
        }
        for (int i = 0; i < stmt_count; i++) {
            result.append(rustTree.get(ctx.stmt(i)));
        }
        rustTree.put(ctx, result.toString());
    }

    @Override
    public void exitLocal_decl(tinyRustParser.Local_declContext ctx) {  //변수 할당(Assignment)
        String result = "";
        String val = rustTree.get(ctx.val());
        String id = rustTree.get(ctx.id());
        if (localVarMap.containsKey(id)) {
            result = "istore_" + getLocalVarTableIdx(id);
        } else {
            result = "istore_" + nextVarIndex;
            assignLocalVar(id);
        }
        rustTree.put(ctx, val + result + "\n");
    }

    @Override
    public void exitVal(tinyRustParser.ValContext ctx) {  //변수 할당 우변의, 할당될 값
        String result = "";
        if (ctx.literal() != null) {
            result = "bipush " + rustTree.get(ctx.literal());
        } else if (ctx.id() != null) {
            result = "iload_" + getLocalVarTableIdx(rustTree.get(ctx.id()));
        }
        rustTree.put(ctx, result + "\n");
    }

    @Override
    public void exitStmt(tinyRustParser.StmtContext ctx) {
        String result = "";
        if (ctx.expr_stmt() != null) {
            result = rustTree.get(ctx.expr_stmt());
        } else if (ctx.assignment_stmt() != null) {
            result = rustTree.get(ctx.assignment_stmt());
        } else if (ctx.compound_stmt() != null) {
            result = rustTree.get(ctx.compound_stmt());
        } else if (ctx.if_stmt() != null) {
            result = rustTree.get(ctx.if_stmt());
        } else if (ctx.for_stmt() != null) {
            result = rustTree.get(ctx.for_stmt());
        } else if (ctx.return_stmt() != null) {
            result = rustTree.get(ctx.return_stmt());
        } else if (ctx.break_stmt() != null) {
            result = rustTree.get(ctx.break_stmt());
        } else if (ctx.loop_stmt() != null) {
            result = rustTree.get(ctx.loop_stmt());
        } else if (ctx.print_stmt() != null) {
            result = rustTree.get(ctx.print_stmt());
        }
        rustTree.put(ctx, result);
    }

    @Override
    public void exitExpr_stmt(tinyRustParser.Expr_stmtContext ctx) {
        rustTree.put(ctx, rustTree.get(ctx.expr()));
    }

    @Override
    public void exitExpr(tinyRustParser.ExprContext ctx) {
        rustTree.put(ctx, rustTree.get(ctx.relative_expr()));
    }

    @Override
    public void exitAdditive_expr(tinyRustParser.Additive_exprContext ctx) {
        String result = "";
        String right = rustTree.get(ctx.multiplicative_expr());
        if (ctx.additive_expr() != null) {
            String left = rustTree.get(ctx.additive_expr());
            String op = ctx.getChild(1).getText();

            result = switch (op) {
                case "+" -> left + right + "iadd\n";
                case "-" -> left + right + "isub\n";
                default -> throw new IllegalArgumentException("지원되지 않는 연산자: " + op);
            };
        } else {
            result = right;
        }

        rustTree.put(ctx, result);
    }

    @Override
    public void exitMultiplicative_expr(tinyRustParser.Multiplicative_exprContext ctx) {
        String result = "";
        String right = rustTree.get(ctx.unary_expr());
        if (ctx.multiplicative_expr() != null) {
            String left = rustTree.get(ctx.multiplicative_expr());
            String op = ctx.getChild(1).getText();

            result = switch (op) {
                case "*" -> left + right + "imul\n";
                case "/" -> left + right + "idiv\n";
                case "%" -> left + right + "irem\n";
                default -> throw new IllegalArgumentException("지원되지 않는 연산자: " + op);
            };
        } else {
            result = right;
        }
        rustTree.put(ctx, result);
    }

    @Override
    public void exitUnary_expr(tinyRustParser.Unary_exprContext ctx) {
        String result = rustTree.get(ctx.factor());
        rustTree.put(ctx, result);
    }

    @Override
    public void exitFactor(tinyRustParser.FactorContext ctx) {
        // expr 막바지에 호출, literal, id 터미널 호출하거나 괄호 연산
        String result = "";
        if (ctx.id() != null) {
            result = "iload_" + getLocalVarTableIdx(rustTree.get(ctx.id()));
        } else if (ctx.literal() != null) {
            result = "bipush " + rustTree.get(ctx.literal());
        }
        rustTree.put(ctx, result + "\n");
    }

    @Override
    public void exitComparative_expr(tinyRustParser.Comparative_exprContext ctx) {
        String result = "";
        String right = rustTree.get(ctx.additive_expr());

        if (ctx.comparative_expr() != null) {
            String left = rustTree.get(ctx.comparative_expr());
            String op = ctx.getChild(1).getText();

            result = left + right;

            result += switch (op) {
                case "==" -> "if_icmpne ";
                case "!=" -> "if_icmpeq ";
                case "<" -> "if_icmpge ";
                case ">" -> "if_icmple ";
                case "<=" -> "if_icmpgt ";
                case ">=" -> "if_icmplt ";
                default -> throw new IllegalArgumentException("지원되지 않는 연산자: " + op);
            };
        } else {
            result = right;
        }
        rustTree.put(ctx, result);
    }

    @Override
    public void exitRelative_expr(tinyRustParser.Relative_exprContext ctx) {
        String result = "";
        String right = rustTree.get(ctx.comparative_expr());

        if (ctx.relative_expr() != null) {
            String left = rustTree.get(ctx.relative_expr());
            String op = ctx.getChild(1).getText();

            // 라벨 생성
            String endLabel = "L" + labelIndex;

            if (op.equals("&&")) {
                // 좌측이 false면 전체가 false
                result += left;
                result += endLabel + "\n";
                result += right;
            } else if (op.equals("||")) {
                // 중첩된 조건일 경우 코드 수정 필요
                boolean isLastLineUnusedLabel = Arrays.stream(left.split("\n"))
                    .reduce((first, second) -> second) // 마지막 줄 추출
                    .map(String::trim) // 공백 제거
                    .orElse("") // null 처리
                    .equals("; unused label:"); // 비교

                if (isLastLineUnusedLabel) {
                    left = Arrays.stream(left.split("\n"))
                        .takeWhile(line -> !line.trim().startsWith("; unused label:")) // ; unused label: 전까지 유지
                        .filter(line -> !line.trim().matches("^L\\d+:$") && !line.trim()
                            .startsWith("goto")) // 레이블과 goto 제거
                        .collect(Collectors.collectingAndThen(Collectors.joining("\n"), temp -> {
                            // 마지막 줄만 처리
                            String[] lines = temp.split("\n");
                            lines[lines.length - 1] =
                                lines[lines.length - 1].split("\\s+")[0] + " "; // 마지막 줄의 첫 단어만 가져오기
                            return String.join("\n", lines); // 결과를 다시 합치기
                        }));
                }

                // 좌측이 true면 전체가 true
                String[] conditions = Arrays.stream(new String[]{left, right})
                    .map(content -> Arrays.stream(content.split("\n"))
                        .map(line -> line.equals("if_icmpeq ") ? "if_icmpne "
                            : line.equals("if_icmpne ") ? "if_icmpeq "
                                : line.equals("if_icmpge ") ? "if_icmplt "
                                    : line.equals("if_icmplt ") ? "if_icmpge "
                                        : line.equals("if_icmple ") ? "if_icmpgt "
                                            : line.equals("if_icmpgt ") ? "if_icmple "
                                                : line) // 조건 반전
                        .collect(Collectors.collectingAndThen(
                            Collectors.toList(),
                            lines -> {
                                // 마지막 줄 변환
                                int lastIndex = lines.size() - 1;
                                lines.set(lastIndex, lines.get(lastIndex));
                                return String.join("\n", lines);
                            }
                        ))
                    )
                    .toArray(String[]::new); // 처리된 left와 right를 배열로 변환

                left = isLastLineUnusedLabel ? left : conditions[0];
                right = conditions[1];

                result += left;
                result += endLabel + "\n";
                result += right;

                // 이후 Label 처리
                result += endLabel + "\n";
                result += "goto L" + (labelIndex + 1) + "\n";
                result += endLabel + ":\n; unused label: ";
            } else {
                throw new IllegalArgumentException("지원되지 않는 연산자: " + op);
            }
        } else {
            result = right;
        }

        rustTree.put(ctx, result);
    }

    @Override
    public void exitAssignment_stmt(tinyRustParser.Assignment_stmtContext ctx) {
        String result = rustTree.get(ctx.expr());
        // 스켈레톤 코드 오류 수정
        result += "istore_" + getLocalVarTableIdx(rustTree.get(ctx.id())) + "\n";
        rustTree.put(ctx, result);
    }

    @Override
    public void exitIf_stmt(tinyRustParser.If_stmtContext ctx) {
        String result = "";

        // 조건 부분
        String condition = rustTree.get(ctx.relative_expr());
        String trueBlock = rustTree.get(ctx.compound_stmt(0));

        // OR 조건일 경우 label index 처리
        if (ctx.relative_expr().getChild(1) != null
            && ctx.relative_expr().getChild(1).getText().equals("||")) {
            labelIndex++;
        }

        result += condition;

        // 조건이 false일 경우
        String elseLabel = "L" + labelIndex++;
        result += elseLabel + "\n";

        // true일 경우
        result += trueBlock;

        // else 문이 존재할 경우
        if (ctx.ELSE() != null) {
            String endLabel = "L" + labelIndex++;
            result += "goto " + endLabel + "\n";
            result += elseLabel + ":\n";

            String falseBlock = ctx.ELSE() != null ? rustTree.get(ctx.compound_stmt(1)) : "";
            result += falseBlock + endLabel + ":\n";
        } else {
            result += elseLabel + ":\n";
        }

        rustTree.put(ctx, result);
    }

    @Override
    public void enterFor_stmt(tinyRustParser.For_stmtContext ctx) {
        String loopVar = ctx.id().getText(); // 직접 변수 이름 추출
//        System.out.println("==== loopVar(Enter): " + loopVar);  // 삭제
        assignLocalVar(loopVar); // 반복 변수 정의

        // 루프 종료 레이블 생성 및 설정
        currentLoopEndLabel = "L" + labelIndex++;
    }

    @Override
    public void exitFor_stmt(tinyRustParser.For_stmtContext ctx) {
        String loopVar = rustTree.get(ctx.id()); // 반복문 변수 이름
//        System.out.println("===== loopVar: " + loopVar);  // 삭제
        String range = rustTree.get(ctx.range()); // 범위 정보
//        System.out.println("===== Range: " + range);
        String[] parts = range.split("\\.\\.");
        int start = Integer.parseInt(parts[0]);
        int end = Integer.parseInt(parts[1]);

        // 루프 종료 레이블 설정
        String loopEndLabel = currentLoopEndLabel;

        // 루프 시작 레이블
        String loopStartLabel = "L" + labelIndex++;

        // 루프 초기화 코드
        String loopVarStore = "bipush " + start + "\n" +
            "istore_" + getLocalVarTableIdx(loopVar) + "\n";

        // 조건 검사 및 점프
        String conditionCheck = "iload_" + getLocalVarTableIdx(loopVar) + "\n" +
            "bipush " + end + "\n" +
            "if_icmpge " + loopEndLabel + "\n";

        // 루프 본문 코드
        String body = rustTree.get(ctx.compound_stmt());

        // 루프 증감 및 시작으로 점프
        String increment = "iload_" + getLocalVarTableIdx(loopVar) + "\n" +
            "bipush 1\n" +
            "iadd\n" +
            "istore_" + getLocalVarTableIdx(loopVar) + "\n" +
            "goto " + loopStartLabel + "\n";

        // 루프 종료 레이블
        String loopEnd = loopEndLabel + ":\n";

        // 전체 루프 코드
        String forLoopCode = loopStartLabel + ":\n" +
            conditionCheck +
            body +
            increment +
            loopEnd;

        // 초기화 코드 + 루프 코드
        String completeForLoop = loopVarStore + forLoopCode;

        rustTree.put(ctx, completeForLoop);

        // 루프 종료 후 이전 루프의 종료 레이블 복원
        currentLoopEndLabel = null;
    }

    @Override
    public void exitPrint_stmt(tinyRustParser.Print_stmtContext ctx) {
        // System.out.println을 호출하기 위한 Bytecode 명령어 추가
        String result = "getstatic java/lang/System/out Ljava/io/PrintStream;\n";

        // 출력할 변수의 이름 추출하고, 해당 변수의 값을 로드
        result += "iload_" + getLocalVarTableIdx(rustTree.get(ctx.id())) + "\n";

        // PrintStream의 println 메서드 호출
        result += "invokevirtual java/io/PrintStream.println(I)V\n";
        rustTree.put(ctx, result);
    }

    @Override
    public void exitRange(tinyRustParser.RangeContext ctx) {
        String start = rustTree.get(ctx.literal(0)); // 시작 값
        String end = rustTree.get(ctx.literal(1));   // 끝 값
        boolean inclusive = ctx.getText().contains("..="); // 포함 여부
//        System.out.println("==== inclusive: " + inclusive);  // 삭제

        // 포함일 경우 끝 값을 +1
        if (inclusive) {
            end = String.valueOf(Integer.parseInt(end) + 1);
        }

        // 범위 정보 저장
        rustTree.put(ctx, start + ".." + end);
    }

    @Override
    public void exitReturn_stmt(tinyRustParser.Return_stmtContext ctx) {
        rustTree.put(ctx, "return");
    }

    @Override
    public void exitBreak_stmt(tinyRustParser.Break_stmtContext ctx) {
        String result = "";

        // 현재 루프의 종료 레이블으로 점프
        if (currentLoopEndLabel != null) {
            result += "goto " + currentLoopEndLabel + "\n";
        } else {
            // 루프 외부에서 break 사용 시 에러 처리
            throw new RuntimeException("=== 루프 외부에서 break 사용");
        }

        rustTree.put(ctx, result);
    }

    @Override
    public void exitLiteral(tinyRustParser.LiteralContext ctx) {
        rustTree.put(ctx, ctx.LITERAL().getText());
    }

    @Override
    public void exitId(tinyRustParser.IdContext ctx) {
        rustTree.put(ctx, ctx.ID().getText());
    }
}
