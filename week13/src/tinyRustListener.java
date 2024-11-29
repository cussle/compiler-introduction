import generated.tinyRustBaseListener;
import generated.tinyRustParser;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class tinyRustListener extends tinyRustBaseListener implements ParseTreeListener {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    ParseTreeProperty<String> rustTree = new ParseTreeProperty<>();
    private static FileWriter fw;
    static HashMap<String, Integer> localVarMap;
    static int nextVarIndex = 0;
    static int labelIndex = 1;

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
        File outputFile = new File("./jasmin-2.4/Test.j");

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
                .end method \n
                """);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "오류 발생", e);
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
            logger.log(Level.SEVERE, "오류 발생", e);
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
            logger.log(Level.SEVERE, "오류 발생", e);
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
        } else if (ctx.return_stmt() != null) {
            result = rustTree.get(ctx.return_stmt());
        } else if (ctx.print_stmt() != null) {
            result = rustTree.get(ctx.print_stmt());
        } else if (ctx.if_stmt() != null) {
            result = rustTree.get(ctx.if_stmt());
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
        rustTree.put(ctx, rustTree.get(ctx.comparative_expr()));
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
    public void exitReturn_stmt(tinyRustParser.Return_stmtContext ctx) {
        rustTree.put(ctx, "return");
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
