package Level3;

//간단하지만 조건을 많이 생각하여 걸어야하는 문제였음
public class EscapeMazeCommend {
    public static int[] dx = { 1, 0, 0, -1 };
    public static int[] dy = { 0, -1, 1, 0 };
    public static String[] dir = { "d", "l", "r", "u" };
    public static String answer = "";
    public static boolean check = false;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {

        dfs("", n, m, x, y, r, c, k);
        if (!check) {
            return "impossible";
        }
        return answer;
    }

    public static void dfs(String path, int n, int m, int x, int y, int r, int c, int k) {
        if (path.length() == k && x == r && y == c) {
            answer = path;
            check = true;
            return;
        }

        if (Math.abs(x - r) + Math.abs(y - c) + path.length() > k) { // 세미핵심
            // 남은 거리보다 가야할 거리가 많다면 못감
            return;
        }

        if ((k - Math.abs(x - r) + Math.abs(y - c) % k - path.length()) % 2 == 1) { // 핵심
            // (원하는 거리 - 남는거리) % 2 = 1이면 안됨
            // 7을 원함 하지만 4만큼 더 가야함 이상황은 갈수가 없음 -> 홀수 만큼은 허비할수가 없기 때문
            return;
        }
        if (!check) {
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if (nx > 0 && nx <= n && ny > 0 && ny <= m) {
                    if (path.length() + 1 <= k) {
                        dfs(path + dir[i], n, m, nx, ny, r, c, k);
                    }
                }
            }
        }
    }

}
