import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        StringTokenizer st = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] answer = new int[n + 1][3];
        int[][] value = new int[n + 1][3];
        for (int i = 0; i < 3; i++) {
            answer[0][i] = 0;
            value[0][i] = 0;

        }
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                value[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i < n + 1; i++) {
            answer[i][0] = Math.min(answer[i - 1][1], answer[i - 1][2]) + value[i][0];
            answer[i][1] = Math.min(answer[i - 1][0], answer[i - 1][2]) + value[i][1];
            answer[i][2] = Math.min(answer[i - 1][1], answer[i - 1][0]) + value[i][2];
        }
        System.out.println(Math.min(Math.min(answer[n][0], answer[n][1]), answer[n][2]));
    }
}
