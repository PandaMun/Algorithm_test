package Level1;

public class NearlestSameLetter {

    public static int[] solution(String s) {
        int[] result = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            result[i] = -1;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    result[i] = i - j;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution("banana"));
    }
}
