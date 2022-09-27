package Level2;

public class JumpAndTeleport {
    public static int solution(int n) {
        int ans = 0;
        while (true) {
            if (n == 0) {
                break;
            }
            if (n % 2 == 1) {
                n -= 1;
                ans += 1;
            } else {
                n /= 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution(5000));
    }
}