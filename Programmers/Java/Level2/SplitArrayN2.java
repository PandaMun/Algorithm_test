package Level2;

public class SplitArrayN2 {

    public static int[] solution(int n, long left, long right) {
        int size = (int) right - (int) left + 1;
        int[] answer = new int[size];
        int cnt = 0;
        for (long i = left; i <= right; i++) {
            answer[cnt++] = Math.max((int) (i % (long) n), (int) (i / (long) n)) + 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        solution(3, 2, 5);
    }
}