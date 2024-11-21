import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    private Map<String, Integer> varMap = new HashMap<>();
    private int nextVarIndex = 0;

    // 변수 이름이 이미 존재하는지 확인
    public boolean contains(String varName) {
        return varMap.containsKey(varName);
    }

    // 변수 이름을 추가하고 인덱스를 반환
    public int addVariable(String varName) {
        if (!varMap.containsKey(varName)) {
            varMap.put(varName, nextVarIndex++);
        }
        return varMap.get(varName);
    }

    // 변수 이름으로 인덱스 조회
    public int getVariableIndex(String varName) {
        return varMap.get(varName);
    }
}
