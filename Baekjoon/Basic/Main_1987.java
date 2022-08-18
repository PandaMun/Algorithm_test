import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1987 {

    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int r;
    static int c;
    static int answer = 0;
    static char[][] board;

    public static void dfs(int x, int y, List<Character> list, int count) {
        
       answer = Math.max(answer,count);
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                if (check(list, board[nx][ny])) {
                    list.add(board[nx][ny]);
                    dfs(nx, ny, list, count + 1);
                    list.remove(count);
                }
            }
        }
    }

    public static boolean check(List<Character> list, char a) {
        for (int i = 0; i < list.size(); i++) {
            if (a == list.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new char[r][c];

        for (int i = 0; i < r; i++) {
            String Line = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = Line.charAt(j);
            }
        }
        List<Character> list = new ArrayList<>();
        list.add(board[0][0]);
        dfs(0, 0, list, 1);
        System.out.println(answer);
    }
}
