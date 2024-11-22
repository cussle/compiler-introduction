import java.util.ArrayList;
import java.util.List;

public class JasminCodeGenerator {

    private final List<String> codeList = new ArrayList<>();

    // 코드 라인을 추가
    public void addLine(String line) {
        System.out.println(line);
        codeList.add(line);
    }

    // 전체 코드를 문자열로 반환
    public String getCodeList() {
        StringBuilder sb = new StringBuilder();
        for (String line : codeList) {
            sb.append(line).append("\n");
        }
        return sb.toString();
    }
}
