package Graph;

//
public class Ranking {
    public static int solution(int n, int[][] results) {
        int answer = 0;
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = 0;
            }
        }
        for (int i = 0; i < results.length; i++) {
            arr[results[i][0]][results[i][1]] = 1; // 이긴 케이스
            arr[results[i][1]][results[i][0]] = -1; // 패배한 케이스
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] != 0) {
                        continue;
                    }
                    if (arr[i][k] == 1 && arr[k][j] == 1) {
                        arr[i][j] = 1;
                    }
                    if (arr[i][k] == -1 && arr[k][j] == -1) {
                        arr[i][j] = -1;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    break;
                }
                count++;
            }
            if (count == n) {
                answer += 1;
            }
        }
        return answer;

    }

    public static void main(String[] args) {
        System.out.println(solution(5, new int[][] { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } }));
    }
}