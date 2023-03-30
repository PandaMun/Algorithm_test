import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Pair {

    int height;
    int cnt;

    Pair(int height, int cnt) {
        this.height = height;
        this.cnt = cnt;
    }
}

public class Main_3015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Pair> s = new Stack<>();
        long answer = 0;
        for (int i = 0; i < N; ++i) {
            int cur = Integer.parseInt(br.readLine());
            Pair next = new Pair(cur, 1);
            while (!s.isEmpty() && s.peek().height <= cur) {
                Pair p = s.pop();
                answer += p.cnt;
                if (p.height == cur) {
                    next.cnt += p.cnt;
                }
            }

            if (!s.isEmpty()) {
                answer++;
            }
            s.push(next);
        }
        System.out.print(answer);
    }
}