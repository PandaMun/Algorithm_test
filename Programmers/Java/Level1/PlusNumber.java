package Level1;

public class PlusNumber {
    public static int solution(String my_string) {
        int answer = 0;
        for (int i = 0; i < my_string.length(); i++) {
            if (isNum(Character.toString(my_string.charAt(i)))) {
                answer += (my_string.charAt(i)) - '0';
            }
        }
        return answer;
    }

    public static boolean isNum(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("aAb1B2cC34oOp"));
    }
}