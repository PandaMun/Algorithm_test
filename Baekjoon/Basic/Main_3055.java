import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3055 {

    static int R;
    static int C;
    static char[][] map;
    static int[] destiny;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static Queue<int[]> s_bfs(Queue<int[]> queue) {
        Queue<int[]> res = new LinkedList<>();
        while (!queue.isEmpty()) {
            int[] xy = queue.poll();
            int x = xy[0];
            int y = xy[1];
            int w = xy[2];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                    if (map[nx][ny] != '*' && map[nx][ny] != 'X' && map[nx][ny] != 'S') {
                        map[nx][ny] = 'S';
                        res.add(new int[] { nx, ny, w + 1 });
                    }
                }
            }
        }
        return res;

    }

    public static Queue<int[]> water_bfs(Queue<int[]> queue) {
        Queue<int[]> res = new LinkedList<>();
        while (!queue.isEmpty()) {
            int[] xy = queue.poll();
            int x = xy[0];
            int y = xy[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                    if (map[nx][ny] != 'X' && map[nx][ny] != 'D' && map[nx][ny] != '*') {
                        map[nx][ny] = '*';
                        res.add(new int[] { nx, ny });
                    }
                }
            }
        }
        return res;

    }

    public static int check() {
        if (map[destiny[0]][destiny[1]] == 'S') {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'S') {
                    count += 1;
                }
            }
        }
        if (count == 0) {
            return 1;
        }
        return 2;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Queue<int[]> waterQueue = new LinkedList<>();
        Queue<int[]> queue = new LinkedList<>();
        destiny = new int[2];
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String Line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = Line.charAt(j);
                if (map[i][j] == '*') {
                    waterQueue.add(new int[] { i, j });
                } else if (map[i][j] == 'S') {
                    queue.add(new int[] { i, j, 0 });
                } else if (map[i][j] == 'D') {
                    destiny[0] = i;
                    destiny[1] = j;
                }
            }
        }
        int count = 0;
        while (true) {
            waterQueue = water_bfs(waterQueue);
            queue = s_bfs(queue);
            int i = check();
            count += 1;
            if (i == 1) {
                System.out.println("KAKTUS");
                break;
            } else if (i == 0) {
                System.out.println(count);
                break;
            }
        }
    }
}
