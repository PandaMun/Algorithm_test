package Level2;

import java.util.*;

public class SelectCitrus {

    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        for (int i = 0; i < list.size(); i++) {
            if (k <= 0) {
                break;
            } else {
                answer++;
                k -= list.get(i).getValue();
            }
        }

        return answer;
    }

}
