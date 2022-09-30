import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1463 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[n + 1];
        answer[1] = 0;
        for (int i = 2; i <= n; i++) {
            answer[i] = Integer.MAX_VALUE;
            if (i % 3 == 0) {
                answer[i] = Math.min(answer[i / 3] + 1, answer[i]);
            }
            if (i % 2 == 0) {
                answer[i] = Math.min(answer[i / 2] + 1, answer[i]);
            }
            answer[i] = Math.min(answer[i - 1] + 1, answer[i]);
        }
        System.out.println(answer[n]);
    }

}