import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17070 {
    static int[] dx = { 1, 1, 0 };
    static int[] dy = { 0, 1, 1 };

    public static void main(String[] args) throws IOException {
        StringTokenizer st = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n + 1][n + 1];
        int[][][] answer = new int[n + 1][n + 1][3];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                answer[i][j][0] = 0;
                answer[i][j][1] = 0;
                answer[i][j][2] = 0;
            }
        }
        answer[1][2][0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 2; j < n + 1; j++) {
                if (i == 1 && j == 2) {
                    continue;
                }
                if (map[i][j] != 1) {
                    answer[i][j][0] = answer[i][j - 1][0] + answer[i][j - 1][1];
                }
                if (map[i][j - 1] != 1 && map[i - 1][j] != 1 && map[i][j] != 1) {
                    answer[i][j][1] = answer[i - 1][j - 1][1] + answer[i - 1][j - 1][0] + answer[i - 1][j - 1][2];
                }
                if (map[i][j] != 1) {
                    answer[i][j][2] = answer[i - 1][j][1] + answer[i - 1][j][2];
                }
            }
        }
        System.out.println(answer[n][n][0] + answer[n][n][1] + answer[n][n][2]);

    }
}
