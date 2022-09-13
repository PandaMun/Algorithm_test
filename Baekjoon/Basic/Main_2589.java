import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2589 {

    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String Line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Line.charAt(j);
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        int answer = 0;
        int stack = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'L') {
                    queue.add(new int[] { i, j, 0 });
                    boolean[][] visited = new boolean[n][m];
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        int[] next = queue.poll();
                        int x = next[0];
                        int y = next[1];
                        int time = next[2];
                        stack = 0;
                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                                if (map[nx][ny] == 'L' && !visited[nx][ny]) {
                                    queue.add(new int[] { nx, ny, time + 1 });
                                    stack += 1;
                                    visited[nx][ny] = true;
                                }
                            }
                            if (stack == 0) {
                                answer = Math.max(answer, time);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(answer);

    }
}