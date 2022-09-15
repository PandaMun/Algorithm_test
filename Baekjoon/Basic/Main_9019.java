import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class register {
    int num;
    String command;

    public register(int num, String command) {
        this.num = num;
        this.command = command;
    }
}

public class Main_9019 {

    public static int D(int num) {
        return (num * 2) % 10000;
    }

    public static int S(int num) {
        return num == 0 ? 9999 : num - 1;
    }

    public static int L(int num) {
        return num % 1000 * 10 + num / 1000;
    }

    public static int R(int num) {
        return num % 10 * 1000 + num / 10;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            boolean[] visited = new boolean[10000];
            String answer = "";
            Queue<register> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            queue.add(new register(num, ""));
            visited[num] = true;

            while (!queue.isEmpty()) {
                register reg = queue.poll();
                if (reg.num == target) {
                    answer = reg.command;
                    break;
                }
                System.out.println(reg.num + " " + reg.command);
                int d = D(reg.num);
                int s = S(reg.num);
                int l = L(reg.num);
                int r = R(reg.num);
                if (!visited[d]) {
                    queue.add(new register(d, reg.command + "D"));
                    visited[d] = true;
                }
                if (!visited[s]) {
                    queue.add(new register(s, reg.command + "S"));
                    visited[s] = true;
                }
                if (!visited[l]) {
                    queue.add(new register(l, reg.command + "L"));
                    visited[l] = true;
                }
                if (!visited[r]) {
                    queue.add(new register(r, reg.command + "R"));
                    visited[r] = true;
                }

            }
            System.out.println(answer);
        }

    }

}
