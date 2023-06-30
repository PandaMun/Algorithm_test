package Level4;

import java.util.ArrayList;

public class MinimizeDeclineSales {

    public static ArrayList<ArrayList<Integer>> link;
    public static int[][] dp = new int[300001][2];

    public static int solution(int[] sales, int[][] links) {
        link = new ArrayList<>();

        // 링크 정보를 저장하는 ArrayList 초기화
        for (int i = 0; i < sales.length + 1; i++) {
            link.add(new ArrayList<>());
        }

        // 링크 정보를 ArrayList에 저장
        for (int i = 0; i < links.length; i++) {
            int a = links[i][0];
            int b = links[i][1];
            link.get(a).add(b);
        }

        // DFS로 팀장과 팀원의 최소 비용 계산
        dfs(sales, 1);
        int answer = Math.min(dp[1][0], dp[1][1]);
        return answer;
    }

    public static void dfs(int[] sales, int idx) {
        // dp 배열 초기화
        dp[idx][0] = 0;
        dp[idx][1] = sales[idx - 1];

        // 해당 직원에게 부서질 팀원이 없으면 종료
        if (link.get(idx).size() == 0)
            return;

        // 추가 비용(extra) 초기화
        int extra = (int) 1e9;

        // 팀원들을 순회하며 DFS 호출
        for (int child : link.get(idx)) {
            dfs(sales, child);

            // 팀장과 팀원의 비용 비교
            if (dp[child][0] < dp[child][1]) {
                // 부서질 팀원이 더 적은 경우
                dp[idx][0] += dp[child][0];
                dp[idx][1] += dp[child][0];

                // 추가 비용(extra) 갱신
                extra = Math.min(extra, dp[child][1] - dp[child][0]);
            } else {
                // 팀장이 더 적은 경우
                dp[idx][0] += dp[child][1];
                dp[idx][1] += dp[child][1];

                // 추가 비용(extra) 갱신
                extra = 0;
            }
        }

        // 추가 비용(extra)를 최종 비용에 더해줌
        dp[idx][0] += extra;
        return;
    }
}