import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2636 {

    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] cheese = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] melting = new int[n];
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }

        });
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == (n - 1)) {
                for (int j = 0; j < m; j++) {
                    queue.add(new int[] { i, j, 0 });
                    visited[i][j] = true;
                }
            } else {
                queue.add(new int[] { i, 0, 0 });
                queue.add(new int[] { i, m - 1, 0 });
                visited[i][0] = true;
                visited[i][m - 1] = true;
            }
        }
        int answer = 0;
        while (!queue.isEmpty()) {
            int[] next = queue.poll();
            int x = next[0];
            int y = next[1];
            int count = next[2];
            answer = Math.max(count, answer);
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                    if (cheese[nx][ny] == 1) {
                        queue.add(new int[] { nx, ny, count + 1 });
                        melting[count + 1]++;
                        cheese[nx][ny] = 0;
                        visited[nx][ny] = true;
                    } else {
                        queue.add(new int[] { nx, ny, count });
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        System.out.println(answer);
        System.out.println(melting[answer]);

    }
}
