import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502 {

    static int[][] virus;
    static int n;
    static int m;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
    static int[][] map;
    static int[][] newMap;
    static int answer = 0;

    static void spreadVirus() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < 10; i++) {
            if (virus[i][0] != -1) {
                queue.add(new int[] { virus[i][0], virus[i][1] });
                visited[virus[i][0]][virus[i][1]] = true;
            }
        }
        while (!queue.isEmpty()) {
            int[] spread = queue.poll();
            int x = spread[0];
            int y = spread[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visited[nx][ny] && newMap[nx][ny] == 0) {
                        queue.add(new int[] { nx, ny });
                        newMap[nx][ny] = 2;
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    static void buildWall(int count) {
        if (count == 3) {
            newMap = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    newMap[i][j] = map[i][j];
                }
            }
            spreadVirus();
            answer = Math.max(findSpace(), answer);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    buildWall(count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static int findSpace() {
        int space = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (newMap[i][j] == 0) {
                    space += 1;
                }
            }
        }
        return space;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        virus = new int[10][2];
        int virusCnt = 0;
        for (int i = 0; i < 10; i++) {
            virus[i][0] = -1;
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virus[virusCnt][0] = i;
                    virus[virusCnt++][1] = j;
                }
            }
        }

        buildWall(0);
        System.out.println(answer);
    }

}
