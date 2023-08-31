class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][] dp = new int[n][m]; // n, m 크기의 dp 배열 생성

        dp[0][0] = grid[0][0]; // 0,0 초기화

        for(int i = 1; i < n; i++){
            dp[i][0] = grid[i][0] + dp[i-1][0]; // matrix에서 가장 왼쪽 먼저 값을 채우고
        }
        
        for(int j = 1; j < m; j++){
            dp[0][j] = grid[0][j] + dp[0][j-1]; //matrix에서 가장 위쪽 먼저 값을 채워서
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j]; // 위에랑 왼쪽이랑 값이 작은곳을 선택해서 현재 위치 값이랑 더해서 저장(갱신)
            }
        }
        return dp[n-1][m-1];
    }
}