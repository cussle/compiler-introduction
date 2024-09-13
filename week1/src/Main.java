import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// imolang 덧셈연산: `:\}\^{0,3}\^{0,3}`

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("./src/test.imlg"));
        String temp = "";
        while ((temp = input.readLine()) != null) {
            System.out.println(temp);
        }
    }
}
