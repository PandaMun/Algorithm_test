package Level2;

public class ExpectedMatchedList {
    public static int solution(int n, int a, int b) {
        int answer = 1;
        while (true) {
            a = (int) ((a + 1) / 2);
            b = (int) ((b + 1) / 2);
            if (a == b) {
                break;
            }
            answer += 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(8, 4, 7));
    }
}
