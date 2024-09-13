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

        Set<String> declaredVariables = new HashSet<>();  // 선언된 변수를 관리할 Set
        List<String> variableDeclarations = new ArrayList<>();  // 변수 선언을 저장할 리스트
        List<String> operations = new ArrayList<>();  // 동작을 저장할 리스트

        // C 코드의 시작부
        output.write("#include <stdio.h>\n\n");
        output.write("int main() {\n");

        // 정규식 패턴
        Pattern intInputPattern = Pattern.compile(":\\) (\\^(\\^){0,2})");  // 정수 읽기 패턴
        Pattern stringInputPattern = Pattern.compile(":\\):\\] (\\^(\\^){0,2})");  // 문자열 읽기 패턴

        // 입력 파일 순회
        String line;
        while ((line = input.readLine()) != null) {
            // 정규식 패턴 매칭을 위한 Matcher
            Matcher intInputMatcher = intInputPattern.matcher(line);
            Matcher stringInputMatcher = stringInputPattern.matcher(line);

            // 정수 입력 처리
            if (intInputMatcher.find()) {
                String caret = intInputMatcher.group(1);
                String variable = getIntVariable(caret);  // ^의 개수에 따른 변수 반환

                // 변수 선언 여부 체크 및 처리
                checkAndDeclareVariable(variable, "int", declaredVariables, variableDeclarations, indent);

                // 정수 입력 처리
                operations.add(indent + "scanf(\"%d\", &" + variable + ");\n");

                continue;
            }

            // 문자열 입력 처리
            if (stringInputMatcher.find()) {
                String caret = stringInputMatcher.group(1);
                String variable = getStringVariable(caret);  // ^의 개수에 따른 변수 반환

                // 변수 선언 여부 체크 및 처리
                checkAndDeclareVariable(variable, "char*", declaredVariables, variableDeclarations, indent);

                // 문자열 입력 처리
                operations.add(indent + "scanf(\"%s\", " + variable + ");\n");

                continue;
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

    /**
     * 입력된 ^ 개수에 따라 정수 변수를 지정하는 메서드
     *
     * @param caret 입력된 ^ 문자
     * @return 해당하는 변수명 반환 (a, b, c 중 하나)
     */
    private static String getIntVariable(String caret) {
        if (caret.equals("^")) {
            return "a";
        }
        if (caret.equals("^^")) {
            return "b";
        }
        if (caret.equals("^^^")) {
            return "c";
        }
        return null;
    }

    /**
     * 입력된 ^ 개수에 따라 문자열 변수를 지정하는 메서드
     *
     * @param caret 입력된 ^ 문자
     * @return 해당하는 변수명 반환 (as, bs, cs 중 하나)
     */
    private static String getStringVariable(String caret) {
        if (caret.equals("^")) {
            return "as";
        }
        if (caret.equals("^^")) {
            return "bs";
        }
        if (caret.equals("^^^")) {
            return "cs";
        }
        return null;
    }

    /**
     * 변수가 선언되지 않은 경우 변수를 선언하는 메서드
     *
     * @param variable             변수명
     * @param type                 변수 타입 (int, char*)
     * @param declaredVariables    이미 선언된 변수 목록
     * @param variableDeclarations 변수 선언을 저장할 리스트
     * @param indent               들여쓰기 설정
     */
    private static void checkAndDeclareVariable(
        String variable,
        String type,
        Set<String> declaredVariables,
        List<String> variableDeclarations,
        String indent
    ) {
        if (!declaredVariables.contains(variable)) {
            declaredVariables.add(variable);
            variableDeclarations.add(indent + type + " " + variable + ";\n");
        }
    }
}
