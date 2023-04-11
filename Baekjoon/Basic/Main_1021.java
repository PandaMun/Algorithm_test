import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1021 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        LinkedList<Integer> deque = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
        }
        st = new StringTokenizer(br.readLine());
        int answer = 0;
        for (int i = 0; i < m; i++) {
            int location = Integer.parseInt(st.nextToken());
            int index = deque.indexOf(location);
            if (index > deque.size() / 2) {
                for (int j = 0; j < deque.size() - index; j++) {
                    int pop = deque.pollLast();
                    deque.push(pop);
                    answer += 1;
                }
            } else {
                for (int j = 0; j < index; j++) {
                    int pop = deque.poll();
                    deque.add(pop);
                    answer += 1;
                }
            }
            deque.poll();
        }
        System.out.println(answer);
    }
}
