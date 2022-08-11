import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5215 {

    static int n;
    static int L;
    static int best;
    static int cal[];
    static int taste[];

    static void check(int index, int sum, int weight) {
        if (weight > L) {
            return;
        }
        if (sum > best) {
            best = sum;
        }
        if (index >= n) {
            return;
        }
        check(index + 1, sum + taste[index], weight + cal[index]);// 이걸 먹는경우
        check(index + 1, sum, weight);// 안먹고 넘기는 경우
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            taste = new int[n];
            cal = new int[n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                taste[i] = Integer.parseInt(st.nextToken());
                cal[i] = Integer.parseInt(st.nextToken());
            }
            best = 0;
            check(0, 0, 0);
            System.out.println("#" + (tc + 1) + " " + best);
        }
    }
}
