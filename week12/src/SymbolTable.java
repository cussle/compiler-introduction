import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

    private final Map<String, Integer> map = new HashMap<>();
    private int nextVarIndex = 0;

    // 변수 이름을 추가하고 인덱스를 반환
    public int addVariable(String varName) {
//        if (!map.containsKey(varName)) {  // 변수 이름이 이미 존재하는지 확인
//            map.put(varName, nextVarIndex++);
//        }
//        return map.get(varName);
        return map.computeIfAbsent(varName, k -> nextVarIndex++);
    }

    // 변수 이름으로 인덱스 조회
    public int getVariableIndex(String varName) {
        if (!map.containsKey(varName)) {
            throw new RuntimeException("=== 정의되지 않은 변수: " + varName);
        }
        return map.get(varName);
    }
}
