import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        sb.append("CFG:").append("\n");
        sb.append("\t").append("S -> aA | bB").append("\n");
        sb.append("\t").append("A -> aBb | bBb | cBb").append("\n");
        sb.append("\t").append("B -> d | e | f").append("\n\n");

        sb.append("input: ");

        System.out.println(sb.toString());
    }
}
