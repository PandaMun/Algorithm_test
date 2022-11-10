import java.util.*;
import java.io.*;

public class Main_2644 {

    static int answer = Integer.MAX_VALUE;
    static boolean[][] relation;
    static int n, end;

    static void dfs(int start, int count, boolean[][] visited) {
        if (relation[start][end]) {
            if (answer > count + 1) {
                answer = count + 1;
            }
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (relation[start][i] && !visited[start][i]) {
                visited[start][i] = true;
                visited[i][start] = true;
                dfs(i, count + 1, visited);
                visited[start][i] = false;
                visited[i][start] = false;

            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        relation = new boolean[n + 1][n + 1];
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        int relation_count = Integer.parseInt(br.readLine());
        for (int i = 0; i < relation_count; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            relation[a][b] = true;
            relation[b][a] = true;
        }
        boolean[][] visited = new boolean[n + 1][n + 1];
        dfs(start, 0, visited);
        if (answer == 2147483647) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}
