import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236 {

    static int sharkSize;
    static int time;
    static int answer;
    static int[][] sea;
    static int n;
    static boolean[][] visited;
    static int shark_X;
    static int shark_Y;
    static int[] dx = { -1, 0, 0, 1 };
    static int[] dy = { 0, -1, 1, 0 };

    static int bfs(boolean[][] visited) {
        int stop = Integer.MAX_VALUE;
        List<int[]> list = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { shark_X, shark_Y, 0 });
        while (!queue.isEmpty()) {
            int[] shark = queue.poll();
            int x = shark[0];
            int y = shark[1];
            int time = shark[2];

            if (sea[x][y] > 0 && sea[x][y] < sharkSize) {
                stop = Math.min(stop, time);
                if (stop == time) {
                    list.add(new int[] { x, y });
                }
                if (time > stop) {
                    break;
                }

            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (visited[nx][ny] == false && sharkSize >= sea[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[] { nx, ny, time + 1 });
                    }
                }
            }
        }
        if(list.size() > 0){
        Collections.sort(list, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }

        });
        shark_X = list.get(0)[0];
        shark_Y = list.get(0)[1];
        sea[shark_X][shark_Y] = 0;
        return stop;
    }
        return 0;
    
    }

    static boolean check() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (sea[i][j] > 0 && sea[i][j] < sharkSize) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        sea = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                sea[i][j] = Integer.parseInt(st.nextToken());
                if (sea[i][j] == 9) {
                    shark_X = i;
                    shark_Y = j;
                    sea[i][j] = 0;
                }
            }
        }
        sharkSize = 2;
        answer = 0;
        int stack = 0;
        while (true) {
            if (check()) {
                visited = new boolean[n][n];
                int res = (bfs(visited));
                if (res == 0){
                    break;
                }
                else{
                answer += res;
                stack += 1;
                if (stack == sharkSize) {
                    sharkSize += 1;
                    stack = 0;
                }
            }
            } else {
                break;
            }
        }
        System.out.println(answer);
    }
}
