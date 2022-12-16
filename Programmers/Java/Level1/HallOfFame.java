package Level1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HallOfFame {
    public static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> HallOfFame = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            HallOfFame.add(score[i]);
            Collections.sort(HallOfFame);
            if (i < k) {
                answer[i] = HallOfFame.get(0);
            } else {
                answer[i] = HallOfFame.get(i - k + 1);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, new int[] { 10, 100, 20, 150, 1, 100, 200 }));
    }
}
