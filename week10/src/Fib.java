public class Fib {

    // n번째 피보나치 수를 구하는 메서드
    public static int fib(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int a = 0;
        int b = 1;
        int count = 2;

        while (count <= n) {
            int temp = a + b;
            a = b;
            b = temp;
            count++;
        }

        return b;
    }

    // 메인 메서드
    public static void main(String[] args) {
        int result = fib(10);  // 10번째 피보나치 수를 구함
        System.out.println(result);  // 결과 출력
    }
}
