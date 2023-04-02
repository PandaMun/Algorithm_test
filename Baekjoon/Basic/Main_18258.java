import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18258 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        // System.out.println() -> 시간 초과 발생
        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();
        int last = 0;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String commend = st.nextToken();
            if (commend.equals("push")) {
                int input = Integer.parseInt(st.nextToken());
                last = input;
                queue.add(input);
            } else if (commend.equals("pop")) {
                if (queue.size() > 0) {
                    sb.append(queue.poll() + "\n");
                } else {
                    sb.append(-1 + "\n");
                }
            } else if (commend.equals("size")) {
                sb.append(queue.size() + "\n");
            } else if (commend.equals("empty")) {
                if (queue.size() > 0) {
                    sb.append(0 + "\n");
                } else {
                    sb.append(1 + "\n");
                }
            } else if (commend.equals("front")) {
                if (queue.size() > 0) {
                    sb.append(queue.peek() + "\n");
                } else {
                    sb.append(-1 + "\n");
                }
            } else if (commend.equals("back")) {
                if (queue.size() > 0) {
                    sb.append(last + "\n");
                } else {
                    sb.append(-1 + "\n");
                }
            }
        }
        System.out.println(sb);

    }

}
