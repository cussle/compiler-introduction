public class Fib {

    // 기본 생성자
    public Fib() {
        super();
    }

    // fib 함수 - n번째 피보나치 수를 반환
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

    // main 함수 - fib 함수를 호출하여 결과를 출력
    public static void main(String[] args) {
        // fib(10) 호출
        int result = fib(10);

        // 결과를 출력
        System.out.println(result);
    }
}