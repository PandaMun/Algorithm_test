import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2023 {

    static int n;
    static StringBuilder sb = new StringBuilder();

    public static boolean isPrime(int x) {
        if (x == 1) {
            return false;
        }
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    static void interPrime(int depth, int num) { // 자릿수 늘려가면서 소수 체크.
        if (depth == n) {
            sb.append(num + "\n");
            return;
        }
        // 소수는 2를 제외하면 모두 홀수. 따라서 i를 홀수로 증가시켜 시간 복잡도 줄이기.
        for (int i = 1; i <= 9; i += 2) {
            int next = num * 10 + i;
            if (isPrime(next)) {
                interPrime(depth + 1, next);
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        // 앞자리에 올 수 있는 소수는 2,3,5,7뿐
        interPrime(1, 2);
        interPrime(1, 3);
        interPrime(1, 5);
        interPrime(1, 7);

        System.out.println(sb.toString());

        br.close();
    }
}
