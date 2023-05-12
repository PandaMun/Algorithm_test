package Level3;

class StudyCodingTest {
    public int solution(int alp, int cop, int[][] problems) {
        // 목표치를 구하는 알고리즘 능력(goal_a)과 코딩 능력(goal_c) 초기화
        int goal_a = 0;
        int goal_c = 0;

        // 목표치를 구하는 for문
        for (int i = 0; i < problems.length; i++) {
            goal_a = Math.max(problems[i][0], goal_a); // 최대 알고리즘 능력 갱신
            goal_c = Math.max(problems[i][1], goal_c); // 최대 코딩 능력 갱신
        }

        // 목표치가 이미 알고리즘 능력과 코딩 능력을 만족하는 경우 0 반환
        if (goal_a <= alp && goal_c <= cop) {
            return 0;
        }

        // 알고리즘 능력과 코딩 능력이 목표치를 초과하는 경우, 최대 목표치로 설정
        if (alp >= goal_a) {
            alp = goal_a;
        }
        if (cop >= goal_c) {
            cop = goal_c;
        }

        // dp 배열 초기화
        int[][] dp = new int[goal_a + 2][goal_c + 2];

        for (int i = alp; i <= goal_a; i++) {
            for (int j = cop; j <= goal_c; j++) {
                dp[i][j] = Integer.MAX_VALUE; // 초기 값을 최대값으로 설정
            }
        }

        dp[alp][cop] = 0; // 현재 알고리즘 능력과 코딩 능력에 대한 최소 학습 시간은 0으로 설정

        // dp 배열 채우기
        for (int i = alp; i <= goal_a; i++) {
            for (int j = cop; j <= goal_c; j++) {
                // 알고리즘 능력과 코딩 능력이 하나씩 증가하는 경우 시간은 1씩 증가합니다.
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1); // 알고리즘 능력 1 증가
                dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1); // 코딩 능력 1 증가

                // problems 배열 순회
                for (int[] p : problems) {
                    // 만약 현 알고리즘 능력과 코딩능력이 해당 문제를 풀기에 충분하다면
                    if (i >= p[0] && j >= p[1]) {
                        // 문제를 풀고 난후 모든 능력이 목표치에 도달하는 경우
                        if (i + p[2] > goal_a && j + p[3] > goal_c) {
                            dp[goal_a][goal_c] = Math.min(dp[goal_a][goal_c], dp[i][j] + p[4]);
                            // 문제를 풀고 난후 알고리즘 능력이 목표치에 도달하는 경우
                        } else if (i + p[2] > goal_a) {
                            dp[goal_a][j + p[3]] = Math.min(dp[goal_a][j + p[3]], dp[i][j] + p[4]);
                            // 문제를 풀고 난후 코딩 능력이 목표치에 도달하는 경우
                        } else if (j + p[3] > goal_c) {
                            dp[i + p[2]][goal_c] = Math.min(dp[i + p[2]][goal_c], dp[i][j] + p[4]);
                            // 문제를 풀고 난후 모든 능력이 목표치에 도달 안 하는 경우
                        } else if (i + p[2] <= goal_a && j + p[3] <= goal_c) {
                            dp[i + p[2]][j + p[3]] = Math.min(dp[i + p[2]][j + p[3]], dp[i][j] + p[4]);
                        }
                    }
                }
            }
        }
        return dp[goal_a][goal_c];
    }
}

// import java.util.Arrays;

// class Solution {
// static int[][] problemInfos;
// static int minHour;

// public int solution(int alp, int cop, int[][] problems) {
// problemInfos = problems;
// minHour = Integer.MAX_VALUE;
// boolean[] solvedProblem = new boolean[problems.length];
// dfs(0, solvedProblem, alp, cop, 0);
// return minHour;
// }

// public static void dfs(int count, boolean[] solvedProblem, int alp, int cop,
// int time) {
// if (count >= solvedProblem.length) {
// minHour = Math.min(minHour, time);
// return;
// }

// for (int i = 0; i < problemInfos.length; i++) {
// if (!solvedProblem[i]) {
// solvedProblem[i] = true;
// int nalp = alp;
// int ncop = cop;
// int addTime = 0;
// if (problemInfos[i][0] > alp) {
// addTime += problemInfos[i][0] - alp;
// nalp = problemInfos[i][0];
// }
// if (problemInfos[i][1] > cop) {
// addTime += problemInfos[i][1] - cop;
// ncop = problemInfos[i][1];
// }
// dfs(count + 1, Arrays.copyOf(solvedProblem, solvedProblem.length), nalp +
// problemInfos[i][2],
// ncop + problemInfos[i][3], time + addTime + problemInfos[i][4]);
// solvedProblem[i] = false;
// }
// }
// }
// }