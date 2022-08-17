package DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestWayOfGameMap {

    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int[][] visited;

    public static int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        visited = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { 0, 0, 1 }); // x,y,거리
        while (!queue.isEmpty()) {
            int[] location = queue.poll();
            int x = location[0];
            int y = location[1];
            int distance = location[2];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (nx == n - 1 && ny == m - 1) {
                        return distance + 1;
                    } else if (maps[nx][ny] == 1 && visited[nx][ny] != 1) {
                        queue.offer(new int[] { nx, ny, distance + 1 });
                        visited[nx][ny] = 1;
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[][] maps = new int[][] { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 1 } };
        System.out.println(solution(maps));
    }
}