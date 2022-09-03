package Greedy;

public class MakeBignum {

    public static String solution(String number, int k) {
        String answer = "";
        char[] arr = number.toCharArray();

        int len = k + 1;
        int start = 0;
        while (true) {
            int[] max = new int[] { -1, 0 };
            for (int i = start; i < start + len; i++) {
                if (max[0] < (arr[i] - '0')) {
                    max[0] = arr[i] - '0';
                    max[1] = i;
                }
                if (max[0] == 9) {
                    break;
                }
            }
            answer += String.valueOf(max[0]);
            len -= max[1] - start;
            start = max[1] + 1;
            if (answer.length() == number.length() - k) {
                break;
            }
        }
        return answer;

    }

    public static void main(String[] args) {
        String number = "1924";
        int k = 2;
        System.out.println(solution(number, k));
    }

}
