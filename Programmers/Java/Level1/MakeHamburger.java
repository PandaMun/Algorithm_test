package Level1;

import java.util.Stack;

public class MakeHamburger {
    public static int solution(int[] ingredient) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for (int i = 0; i < ingredient.length; i++) {
            stack.add(ingredient[i]);
            if (stack.size() >= 4) {
                if (stack.get(stack.size() - 1) == 1 && stack.get(stack.size() - 2) == 3
                        && stack.get(stack.size() - 3) == 2 && stack.get(stack.size() - 4) == 1) {
                    answer += 1;
                    stack.remove(stack.size() - 1);
                    stack.remove(stack.size() - 1);
                    stack.remove(stack.size() - 1);
                    stack.remove(stack.size() - 1);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] { 2, 1, 1, 2, 3, 1, 2, 3, 1 }));
    }
}
