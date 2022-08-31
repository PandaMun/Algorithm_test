import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_5430 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        for (int tc = 0; tc < T; tc++) {
            String command = br.readLine();
            int count = Integer.parseInt(br.readLine());
            boolean order = true;
            boolean answer = false;
            st = new StringTokenizer(br.readLine(), "[],");
            Deque<Integer> arr = new LinkedList<>();
            for (int i = 0; i < count; i++) {
                arr.offer(Integer.parseInt(st.nextToken()));
            }
            for (int i = 0; i < command.length(); i++) {
                if (command.charAt(i) == 'R') {
                    order = !order;
                }
                if (command.charAt(i) == 'D') {
                    if (arr.size() == 0) {
                        answer = true;
                        break;
                    } else {
                        if (order) {
                            arr.poll();
                        } else {
                            arr.pollLast();
                        }
                    }
                }
            }
            if (!answer) {
                int len = arr.size();
                if (!order) {
                    System.out.print("[");
                    for (int i = 0; i < len - 1; i++) {
                        System.out.print(arr.pollLast() + ",");
                    }
                    if (len == 0) {
                        System.out.println("]");
                    } else {
                        System.out.println(arr.pollLast() + "]");
                    }
                } else {
                    System.out.print("[");
                    for (int i = 0; i < len - 1; i++) {
                        System.out.print(arr.poll() + ",");
                    }
                    if (len == 0) {
                        System.out.println("]");
                    } else {
                        System.out.println(arr.poll() + "]");
                    }
                }
            } else {
                System.out.println("error");
            }

        }
    }
}
