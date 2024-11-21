import java.util.ArrayList;
import java.util.List;

public class JasminCodeGenerator {
    private List<String> code = new ArrayList<>();

    // 코드 라인을 추가
    public void addLine(String line) {
        code.add(line);
    }

    // 전체 코드를 문자열로 반환
    public String getCode() {
        StringBuilder sb = new StringBuilder();
        for (String line : code) {
            sb.append(line).append("\n");
        }
        return sb.toString();
    }
}
