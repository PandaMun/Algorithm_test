package Level1;

import java.util.*;

public class FruitShop {

    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int num = score.length / m;
        Arrays.sort(score);
        for (int i = 1; i <= num; i++) {
            answer += (score[score.length - (m * i)] * m);
        }
        return answer;
    }

}
