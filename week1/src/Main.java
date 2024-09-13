import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// imolang 덧셈연산: `:\}\^{0,3}\^{0,3}`

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("./src/test.imlg"));
        BufferedWriter output = new BufferedWriter(new FileWriter("./src/test.c"));

        // C 코드의 시작부
        output.write("#include <stdio.h>\n");
        output.write("int main() {\n");

        // C 코드의 종료부
        output.write("\treturn 0;\n");
        output.write("}\n");

        input.close();
        output.close();
    }
}
