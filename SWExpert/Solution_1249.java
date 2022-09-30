import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_1249 {

    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                for (int j = 0; j < n; j++) {
                    map[i][j] = (int) (line.charAt(j)) - 48;
                }
            }
            boolean[][] visited = new boolean[n][n];
            PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[2] - o2[2];
                }

            });
            queue.add(new int[] { 0, 0, 0 });
            while (!queue.isEmpty()) {
                int[] next = queue.poll();
                int x = next[0];
                int y = next[1];
                int cost = next[2];
                // System.out.println(x + " " + y + " " + cost);
                if (x == n - 1 && y == n - 1) {
                    System.out.println("#" + (test_case + 1) + " " + cost);
                    break;
                }
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        if (!visited[nx][ny]) {
                            queue.add(new int[] { nx, ny, cost + map[nx][ny] });
                            visited[nx][ny] = true;
                        }
                    }
                }

            }
        }
    }
}
