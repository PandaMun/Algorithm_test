package Level2;

public class ArcheryCompetiton {

    static int res = -1;
    static int[] answer;

    public static void dfs(int order, int my_Score, int[] score, int[] info, int enemy_Score,
            int left_Arrow) {
        if (order > 10) {
            int diff = my_Score - enemy_Score;
            if (diff > res && diff > 0) {
                answer = new int[10];
                score[10] = left_Arrow;
                answer = score.clone();
                res = diff;
            }
            if (diff == res && diff > 0) {
                score[10] = left_Arrow;
                for (int i = 10; i >= 0; i--) {
                    if (answer[i] < score[i]) {
                        answer = score.clone();
                        break;
                    } else if (answer[i] > score[i]) {
                        break;
                    }
                }
            }
            return;
        }

        if (left_Arrow >= info[order] + 1) { // 이번 과녁 화살 개수가 가능한 경우
            score[order] = (info[order] + 1);
            if (info[order] == 0) {
                dfs(order + 1, my_Score + (10 - order), score, info, enemy_Score, left_Arrow - (info[order] + 1));
            } else {
                dfs(order + 1, my_Score + (10 - order), score, info, enemy_Score - (10 - order),
                        left_Arrow - (info[order] + 1));
            }
            score[order] = 0;
        }
        dfs(order + 1, my_Score, score, info, enemy_Score, left_Arrow);

    }

    public static int[] solution(int n, int[] info) {
        int ans[];
        int Enemy = 0;
        for (int i = 0, start = 10; i < info.length; i++) {
            if (info[i] != 0) {
                Enemy += start;
            }
            start -= 1;
        }
        int[] score = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        dfs(0, 0, score, info, Enemy, n);
        if (answer == null) {
            ans = new int[] { -1 };
            return ans;
        } else {
            return answer;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[] info = new int[] { 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 };
        System.out.println(solution(n, info));
    }

}
