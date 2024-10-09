import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int index;  // 현재 문자열의 index를 관리하는 전역변수
    private static String input;  // 입력받은 문자열을 담는 전역변수

    // Terminal Symbol
    private static final char TOKEN_a = 'a';
    private static final char TOKEN_b = 'b';
    private static final char TOKEN_c = 'c';
    private static final char TOKEN_d = 'd';
    private static final char TOKEN_e = 'e';
    private static final char TOKEN_f = 'f';

    // Result message
    private static final String ACCEPT = "OK";
    private static final String ERROR = "FAIL";

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
        System.out.print("[debug] current: " + currentSymbol());
        index++;
        System.out.println(" → next: " + currentSymbol());
    }

    // Terminal Symbol `a`에 대한 procedure
    private static boolean pa() {
        if (currentSymbol() == TOKEN_a) {
            nextSymbol();
            return true;
        }
        return false;
    }

    // Terminal Symbol `b`에 대한 procedure
    private static boolean pb() {
        if (currentSymbol() == TOKEN_b) {
            nextSymbol();
            return true;
        }
        return false;
    }

    // Terminal Symbol `c`에 대한 procedure
    private static boolean pc() {
        if (currentSymbol() == TOKEN_c) {
            nextSymbol();
            return true;
        }
        return false;
    }

    // Terminal Symbol `d`에 대한 procedure
    private static boolean pd() {
        if (currentSymbol() == TOKEN_d) {
            nextSymbol();
            return true;
        }
        return false;
    }

    // Terminal Symbol `e`에 대한 procedure
    private static boolean pe() {
        if (currentSymbol() == TOKEN_e) {
            nextSymbol();
            return true;
        }
        return false;
    }

    // Terminal Symbol `f`에 대한 procedure
    private static boolean pf() {
        if (currentSymbol() == TOKEN_f) {
            nextSymbol();
            return true;
        }
        return false;
    }

    // Non-Terminal Symbol `S`에 대한 procedure
    // S -> aA | bB
    private static boolean pS() {
        if (pa()) {  // a로 시작할 경우,
            return pA();  // 이후 A 형태여야 함
        }

        if (pb()) {  // b로 시작할 경우,
            return pB();  // 이후 B 형태여야 함
        }

        return false;
    }

    // Non-Terminal Symbol `A`에 대한 procedure
    // A -> aBb | bBb | cBb
    private static boolean pA() {
        if (pa()) {  // a로 시작할 경우,
            return (pB() && pb());  // 이후 Bb 형태여야 함
        }

        if (pb()) {  // b로 시작할 경우,
            return (pB() && pb());  // 이후 Bb 형태여야 함
        }

        if (pc()) {  // c로 시작할 경우,
            return (pB() && pb());  // 이후 Bb 형태여야 함
        }

        return false;
    }

    // Non-Terminal Symbol `B`에 대한 procedure
    // B -> d | e | f
    private static boolean pB() {
        return (pd() || pe() || pf());  // Symbol이 d, e, f 중 하나이면 성공
    }

    // 시작 규칙 S를 호출하여 파싱을 시작하는 메서드
    private static boolean parse() {
        index = 0;  // index 전역변수 초기화
        return (pS() && isEnd());
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // CFG 출력
        sb.append("CFG:").append("\n");
        sb.append("\t").append("S -> aA | bB").append("\n");
        sb.append("\t").append("A -> aBb | bBb | cBb").append("\n");
        sb.append("\t").append("B -> d | e | f").append("\n\n");

        // 문자열 입력
        sb.append("input: ");
        System.out.print(sb.toString());
        input = br.readLine();
        br.close();

        System.out.println();
        // 파서 실행
        if (parse()) {
            System.out.println(ACCEPT);
        } else {
            System.out.println(ERROR);
        }
    }
}
