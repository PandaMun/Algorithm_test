import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_5656 {

    static Stack<Integer> stack;
    static int n, w, h;
    static int answer;
    static int[][] board;
    static int[][] board2;
    static boolean[][] visited;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int[] array;

    public static void down() {
        stack = new Stack<>();
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (board2[j][i] != 0) {
                    stack.push(board2[j][i]);
                    board2[j][i] = 0;
                }
            }
            int nh = h - 1;
            while (!stack.isEmpty()) {
                board2[nh--][i] = stack.pop();
            }
        }

    }

    public static void dfs(int count) {
        if (count == n) {
            board2 = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    board2[i][j] = board[i][j];
                }
            }

            for (int i = 0; i < count; i++) {
                visited = new boolean[h][w];
                bfs(array[i]);
            }
            int num = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (board2[i][j] > 0) {
                        num++;
                    }
                }
            }
            System.out.println(num);
            answer = Math.min(answer, num);
            return;
        }

        for (int i = 0; i < w; i++) {
            array[count] = i;
            dfs(count + 1);
        }

    }

    public static void bfs(int location) {
        int height = -1;
        for (int i = 0; i < h; i++) {
            if (board2[i][location] > 0) {
                height = i;
                break;
            }
        }
        if (height != -1) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] { height, location });
            visited[height][location] = true;
            while (!queue.isEmpty()) {
                int[] out = queue.poll();
                int x = out[0];
                int y = out[1];
                int r = board2[x][y];
                board2[x][y] = 0;
                for (int i = 0; i < 4; i++) {
                    for (int j = 1; j < r; j++) {
                        int nx = x + (dx[i] * j);
                        int ny = y + (dy[i] * j);
                        if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                            if (!visited[nx][ny] && board2[nx][ny] != 0) {
                                queue.add(new int[] { nx, ny });
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }

            }
            down();

        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        StringTokenizer st = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            board = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            array = new int[n];
            answer = Integer.MAX_VALUE;
            dfs(0);
            System.out.println(answer);
        }
    }

}