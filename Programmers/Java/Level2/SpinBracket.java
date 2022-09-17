package Level2;

import java.util.Stack;

public class SpinBracket {

    public static boolean check(String a) {
        int res = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '}') {
                if (stack.size() != 0 && stack.peek() == '{') {
                    res += 1;
                    stack.pop();
                }
            } else if (a.charAt(i) == ')') {
                if (stack.size() != 0 && stack.peek() == '(') {
                    res += 1;
                    stack.pop();
                }
            } else if (a.charAt(i) == ']') {
                if (stack.size() != 0 && stack.peek() == '[') {
                    res += 1;
                    stack.pop();
                }
            } else {
                stack.add(a.charAt(i));
            }
        }
        if (res * 2 == a.length()) {
            return true;
        } else {
            return false;
        }
    }

    public static int solution(String s) {
        int answer = 0;
        String bracket = "";
        for (int i = 0; i < s.length(); i++) {
            bracket += s.substring(i, s.length());
            bracket += (s.substring(0, i));
            if (check(bracket)) {
                answer += 1;
            }
            bracket = "";
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("[](){}"));
    }
}
