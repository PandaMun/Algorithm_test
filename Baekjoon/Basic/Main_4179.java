import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4179 {

    static int R;
    static int C;
    static char[][] map;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Queue<int[]> fireQueue = new LinkedList<>();
        Queue<int[]> queue = new LinkedList<>();
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String Line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = Line.charAt(j);
                if (map[i][j] == 'F') {
                    fireQueue.add(new int[] { i, j });
                } else if (map[i][j] == 'J') {
                    queue.add(new int[] { i, j, 0 });
                }
            }
        }
        int answer = 0;
        boolean escape = false;
        while (!queue.isEmpty()) {

            for (int start = 0, end = fireQueue.size(); start < end; start++) {
                int[] xy = fireQueue.poll();
                int x = xy[0];
                int y = xy[1];
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                        if (map[nx][ny] != '#' && map[nx][ny] != 'F') {
                            map[nx][ny] = 'F';
                            fireQueue.add(new int[] { nx, ny });
                        }
                    }
                }
            }
            for (int start = 0, end = queue.size(); start < end; start++) {
                int[] xy = queue.poll();
                int x = xy[0];
                int y = xy[1];
                int w = xy[2];
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                        escape = true;
                        answer = w + 1;
                        break;
                    }
                    if (map[nx][ny] != 'F' && map[nx][ny] != '#' && map[nx][ny] != 'J') {
                        map[nx][ny] = 'J';
                        queue.add(new int[] { nx, ny, w + 1 });
                    }

                }
                if (escape) {
                    break;
                }
            }

            if (escape) {
                System.out.println(answer);
                break;
            }
            if (queue.isEmpty()) {
                System.out.println("IMPOSSIBLE");
                break;
            }
        }
    }
}