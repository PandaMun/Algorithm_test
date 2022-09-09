package Level2;

public class Long_Jump {
    /**
     * dfs 시간 초과
     */
    // static long answer;

    // public static void dfs(int n, int count) {
    // if (count == n) {
    // answer += 1;
    // return;
    // }
    // if (count < n) {
    // dfs(n, count + 1);
    // }
    // if (count + 1 < n) {
    // dfs(n, count + 2);
    // }
    // }

    // public static long solution(int n) {
    // answer = 0;
    // dfs(n, 0);
    // answer %= 1234567;
    // return answer;
    // }

    // dp
    public static long solution(int n) {
        long[] dp = new long[2001];
        dp[1] = 1;// 1칸을 한번
        dp[2] = 2;// 1칸을 두번, 2칸을 한번

        for (int i = 3; i <= n; i++) { // 3번째 칸부터 목표인 n번째 칸까지
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(solution(n));
    }

}