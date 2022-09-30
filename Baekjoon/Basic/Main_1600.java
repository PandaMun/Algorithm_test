import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600 {
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int[][] dz = { { 1, -1, 1, 1 }, { 1, 1, -1, 1 }, { -1, 1, -1, -1 }, { -1, -1, 1, -1 } };

    static int answer = -1;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][] map = new int[h][w];
        boolean[][][] visited = new boolean[h][w][k + 1];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0, 0, 0 });
        while (!queue.isEmpty()) {
            int[] out = queue.poll();
            int x = out[0];
            int y = out[1];
            int count = out[2];
            int skill = out[3];
            // System.out.println(x + " " + y + " " + skill);
            if (x == w - 1 && y == h - 1) {
                answer = count;
                break;
            }
            for (int i = 0; i < 4; i++) {
                if (x + dx[i] >= 0 && x + dx[i] < w && y + dy[i] >= 0 && y + dy[i] < h) {
                    if (map[y + dy[i]][x + dx[i]] != 1) {
                        if (!visited[y + dy[i]][x + dx[i]][skill]) {
                            queue.add(new int[] { x + dx[i], y + dy[i], count + 1, skill });
                            visited[y + dy[i]][x + dx[i]][skill] = true;
                        }
                    }
                }

            }
            if (skill < k) {
                for (int i = 0; i < 4; i++) {
                    if (y + dy[i] + dz[i][1] >= 0 && y + dy[i] + dz[i][1] < h && x + dx[i] + dz[i][0] >= 0
                            && x + dx[i] + dz[i][0] < w) {
                        if (map[y + dy[i] + dz[i][1]][x + dx[i] + dz[i][0]] != 1) {
                            if (!visited[y + dy[i] + dz[i][1]][x + dx[i] + dz[i][0]][skill + 1]) {
                                queue.add(
                                        new int[] { x + dx[i] + dz[i][0], y + dy[i] + dz[i][1], count + 1, skill + 1 });
                                visited[y + dy[i] + dz[i][1]][x + dx[i] + dz[i][0]][skill + 1] = true;
                            }
                        }
                    }
                    if (y + dy[i] + dz[i][3] >= 0 && y + dy[i] + dz[i][3] < h && x + dx[i] + dz[i][2] >= 0
                            && x + dx[i] + dz[i][2] < w) {
                        if (map[y + dy[i] + dz[i][3]][x + dx[i] + dz[i][2]] != 1) {
                            if (!visited[y + dy[i] + dz[i][3]][x + dx[i] + dz[i][2]][skill + 1]) {
                                queue.add(
                                        new int[] { x + dx[i] + dz[i][2], y + dy[i] + dz[i][3], count + 1, skill + 1 });
                                visited[y + dy[i] + dz[i][3]][x + dx[i] + dz[i][2]][skill + 1] = true;
                            }
                        }
                    }
                }
            }
        }
        if (answer != -1) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }
}
