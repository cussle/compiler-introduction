public class Test {
    public Test() {
        super();
    }

    public static int cal(int a, int b) {
        return (a * b - 2) / 3;
    }

    public static void main(String[] args) {
        int value = 13;
        System.out.println(cal(2, value));
    }
}
