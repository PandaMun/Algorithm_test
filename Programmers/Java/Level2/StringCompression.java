package Level2;

public class StringCompression {

    public static int solution(String s) {
        int answer = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            int cnt = 1;
            int len = 0;
            boolean finish = true;
            for (int j = 0; j < s.length() - i; j += i) {
                if (j + (2 * i) > s.length()) {
                    len += (s.length() - (j + i));
                    if (cnt == 1) {
                        len += i;
                    }
                    finish = false;
                    break;
                }
                if (s.substring(j, j + i).equals(s.substring(j + i, j + 2 * i))) {
                    cnt += 1;
                } else {
                    if (cnt > 1) {
                        len += Integer.toString(cnt).length();
                        len += i;
                        cnt = 1;
                    } else {
                        len += i;
                    }
                }
            }
            if (cnt > 1) {
                len += Integer.toString(cnt).length();
                len += i;
            } else {
                if (finish) {
                    len += i;
                }
            }
            answer = Math.min(len, answer);
        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "a";
        System.out.println(solution(s));
    }
}
