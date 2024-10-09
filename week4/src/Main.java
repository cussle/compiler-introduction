import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int index;  // 현재 문자열의 index를 관리하는 전역변수
    private static String input;  // 입력받은 문자열을 담는 전역변수

    // 문자열의 끝에 도달했는지 확인하는 메서드
    private static boolean isEnd() {
        return index >= input.length();
    }

    // 현재 문자를 반환하는 메서드
    private static char currentSymbol() {
        if (isEnd()) {
            return '\0';
        }
        return input.charAt(index);
    }

    // 다음 문자로 이동하는 메서드
    private static void nextSymbol() {
        index++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        sb.append("CFG:").append("\n");
        sb.append("\t").append("S -> aA | bB").append("\n");
        sb.append("\t").append("A -> aBb | bBb | cBb").append("\n");
        sb.append("\t").append("B -> d | e | f").append("\n\n");

        sb.append("input: ");
        input = br.readLine();
        br.close();
        
        System.out.println(sb.toString());
    }
}
