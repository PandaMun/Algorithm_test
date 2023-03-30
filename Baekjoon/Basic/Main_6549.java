import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main_6549 {

    public static int[] histogram;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n;

        Stack<Integer> stack = new Stack<Integer>();

        while (true) {

            st = new StringTokenizer(br.readLine(), " ");

            n = Integer.parseInt(st.nextToken());

            if (n == 0) {
                break;
            }

            int[] histogram = new int[n];
            for (int i = 0; i < n; i++) {
                histogram[i] = Integer.parseInt(st.nextToken());
            }

            long maxArea = 0;

            for (int i = 0; i < n; i++) {

                while ((!stack.isEmpty()) && histogram[stack.peek()] >= histogram[i]) {
                    int height = histogram[stack.pop()]; // 이전 체인의 높이;
                    long width = stack.isEmpty() ? i : i - 1 - stack.peek();

                    maxArea = Math.max(maxArea, height * width);
                }
                stack.push(i);

            }

            while (!stack.isEmpty()) {
                int height = histogram[stack.pop()];
                int width = 0;
                if (stack.isEmpty()) {
                    width = n;
                } else {
                    width = n - 1 - stack.peek();
                }
                maxArea = Math.max(maxArea, width * height);
            }
            System.out.println(maxArea);
        }
    }

}