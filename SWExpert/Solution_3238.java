import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3238 {

    static long[] factorial;
    static int n, r, p;
    static int X, Y;
    static long answer;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            long r = Long.parseLong(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            factorial = new long[p + 1];

            factorial[0] = 1;
            for (int i = 1; i <= p; ++i) {
                factorial[i] = (i * factorial[i - 1]) % p;
            }
            answer = 1;
            // 뤼카의 정리
            while ((r | n) > 0) {
                X = (int) (n % p);
                Y = (int) (r % p);

                if (Y > X) {
                    answer = 0;
                    break;
                }
                // 페르마의 소정리
                answer = (answer * factorial[X]) % p;
                for (int i = 0; i < p - 2; i++) {
                    answer = (answer * factorial[X - Y] * factorial[Y]) % p;
                }
                n /= p;
                r /= p;
            }
            answer %= p;
            System.out.println("#" + tc + " " + answer);
        }
    }
}
