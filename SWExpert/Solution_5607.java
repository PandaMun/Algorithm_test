import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5607 {

    static long[] factorial;

    public static long pow(long a, long N) {
        if (N == 0) {
            return 1;
        }
        if (N == 1) {
            return a;
        }
        if (N % 2 == 0) { // 2로 나누어 떨어진다면
            long temp = pow(a, N / 2);
            return (temp * temp) % 1234567891;
        }
        long temp = pow(a, N - 1) % 1234567891;
        return (temp * a) % 1234567891;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        factorial = new long[1000001];
        factorial[0] = 1;
        for (int i = 1; i < 1000001; i++) {
            factorial[i] = (factorial[i - 1] * i) % 1234567891;

        }
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            /**
             * 
             * fermat little therom
             * P가 소수 이고 A가 P로 나누어지지 않는 정수라면 다음과 같은 특성을 가진다.
             * A ^ (P - 1) = 1 (mod P)
             * A ^ (P - 2) = 1/A = A ^ (-1) (mod P)
             * 
             * 
             * nCr = n! / r! * (n-r)!
             * answer = n! / (r! * (n-r))!(mod1234567891)
             * = (n! (((n-r)! * r!)^1234567891-2))(mod 1234567891)
             */
            long numerator = factorial[n];
            long denominator = (factorial[n - r] * factorial[r]) % 1234567891;
            denominator = pow(denominator, 1234567891 - 2);
            long answer = (numerator * denominator) % 1234567891;
            System.out.println("#" + tc + " " + answer);
        }
    }
}
