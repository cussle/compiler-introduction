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

    // 상수 선언
    private static final String INDENT = " ".repeat(4);  // 들여쓰기 설정
    private static final int STRING_ARRAY_SIZE = 5000;  // 정적 문자열 배열 크기

    public static void main(String[] args) throws IOException {

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
        Pattern stringInputPattern = Pattern.compile(":\\):] (\\^(\\^){0,2})");  // 문자열 읽기 패턴
        Pattern intOutputPattern = Pattern.compile(":\\)\\) (\\d+|\\^(\\^){0,2})");  // 정수 출력 패턴 (정수 또는 변수)
        Pattern stringOutputPattern = Pattern.compile(":\\)\\):] (\\S+|\\^(\\^){0,2})");  // 문자열 출력 패턴 (문자열 또는 변수)

        // 입력 파일 순회
        String line;
        while ((line = input.readLine()) != null) {
            // 정규식 패턴 매칭을 위한 Matcher
            Matcher intInputMatcher = intInputPattern.matcher(line);
            Matcher stringInputMatcher = stringInputPattern.matcher(line);
            Matcher intOutputMatcher = intOutputPattern.matcher(line);
            Matcher stringOutputMatcher = stringOutputPattern.matcher(line);

            // 정수 입력
            if (intInputMatcher.find()) {
                String caret = intInputMatcher.group(1);
                String variable = getIntVariable(caret);  // ^의 개수에 따른 변수 반환

                // 변수 선언 여부 체크 및 처리
                checkAndDeclareVariable(variable, "int", declaredVariables, variableDeclarations);

                // 정수 입력 처리
                operations.add(INDENT + "scanf(\"%d\", &" + variable + ");\n");

                continue;
            }

            // 문자열 입력
            if (stringInputMatcher.find()) {
                String caret = stringInputMatcher.group(1);
                String variable = getStringVariable(caret);  // ^의 개수에 따른 변수 반환

                // 변수 선언 여부 체크 및 처리 (정적 배열로 선언)
                checkAndDeclareVariable(variable, "char", declaredVariables, variableDeclarations);

                // 문자열 입력 처리
                operations.add(INDENT + "scanf(\"%s\", " + variable + ");\n");

                continue;
            }

            // 정수 출력
            if (intOutputMatcher.find()) {
                String outputValue = intOutputMatcher.group(1);

                // 변수 출력일 경우, value 변경
                if (!isNumeric(outputValue)) {
                    outputValue = getIntVariable(outputValue);
                }

                // 정수 출력 처리
                operations.add(INDENT + "printf(\"%d\", " + outputValue + ");\n");

                continue;
            }

            // 문자열 출력
            if (stringOutputMatcher.find()) {
                String outputValue = stringOutputMatcher.group(1);

                // 변수 출력일 경우, value 변경
                if (outputValue.startsWith("^")) {
                    outputValue = getStringVariable(outputValue);
                } else {
                    outputValue = "\"" + outputValue + "\"";
                }

                // 문자열 출력
                operations.add(INDENT + "printf(\"%s\", " + outputValue + ");\n");

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
        output.write(INDENT + "return 0;\n");
        output.write("}\n");

        input.close();
        output.close();
    }

    /**
     * 입력된 ^ 개수에 따라 정수 변수를 지정하는 메서드
     *
     * @param   caret 입력된 ^ 문자
     * @return  해당하는 변수명 반환 (a, b, c 중 하나)
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
     * @param   caret 입력된 ^ 문자
     * @return  해당하는 변수명 반환 (as, bs, cs 중 하나)
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
     * 변수가 선언되지 않은 경우 변수를 선언하는 메서드 (정적 배열 크기를 사용)
     *
     * @param variable              변수명
     * @param type                  변수 타입 (int, char 배열)
     * @param declaredVariables     이미 선언된 변수 목록
     * @param variableDeclarations  변수 선언을 저장할 리스트
     */
    private static void checkAndDeclareVariable(
        String variable,
        String type,
        Set<String> declaredVariables,
        List<String> variableDeclarations
    ) {
        if (!declaredVariables.contains(variable)) {
            declaredVariables.add(variable);
            if (type.equals("char")) {
                variableDeclarations.add(INDENT + type + " " + variable + "[" + STRING_ARRAY_SIZE + "];\n");
            } else {
                variableDeclarations.add(INDENT + type + " " + variable + ";\n");
            }
        }
    }

    /**
     * 입력된 문자열이 숫자인지 확인하는 메서드
     *
     * @param   string 입력된 문자열
     * @return  true면 숫자, false면 숫자가 아님
     */
    private static boolean isNumeric(String string) {
        return string.matches("-?\\d+");  // 정수로 구성된 숫자 매칭
    }
}
