import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// imolang 덧셈연산: `:\}\^{0,3}\^{0,3}`

public class Main {

    public static void main(String[] args) throws IOException {
        // 들여쓰기 설정
        String indent = " ".repeat(4);

        // 파일 읽기 및 쓰기
        BufferedReader input = new BufferedReader(new FileReader("./src/test.imlg"));
        BufferedWriter output = new BufferedWriter(new FileWriter("./src/test.c"));

        // 선언된 변수 관리
        Set<String> declaredVariables = new HashSet<>();
        List<String> variableDeclarations = new ArrayList<>();

        // C 코드의 시작부
        output.write("#include <stdio.h>\n\n");
        output.write("int main() {\n");

        // 정규식 패턴
        Pattern intInputPattern = Pattern.compile(":\\) (\\^(\\^){0,2})");  // 정수 읽기 패턴

        // 입력 파일 순회
        String line;
        List<String> operations = new ArrayList<>();  // 동작을 저장할 리스트
        while ((line = input.readLine()) != null) {
            // 정규식 패턴 매칭을 위한 Matcher
            Matcher intInputMatcher = intInputPattern.matcher(line);

            // 정수 입력 처리
            if (intInputMatcher.find()) {
                String temp = intInputMatcher.group(1);
                String variable = getVariable(temp);

                // 변수가 선언되지 않은 상태일 경우
                if (!declaredVariables.contains(variable)) {
                    declaredVariables.add(variable);
                    variableDeclarations.add(indent + "int " + variable + ";\n");
                }

                // 정수 입력 처리
                operations.add(indent + "scanf(\"%d\", &" + variable + ");\n");
            }
        }

        // C 코드의 변수 선언
        for (String declaration : variableDeclarations) {
            output.write(declaration);
        }
        output.write("\n");

        // C 코드의 연산 및 동작
        for (String operation : operations) {
            output.write(operation);
        }
        output.write("\n");

        // C 코드의 종료부
        output.write(indent + "return 0;\n");
        output.write("}\n");

        input.close();
        output.close();
    }

    private static String getVariable(String caret) {
        if (caret.equals("^"))
            return "a";
        if (caret.equals("^^"))
            return "b";
        if (caret.equals("^^^"))
            return "c";
        return null;
    }
}
