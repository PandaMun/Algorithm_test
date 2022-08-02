import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503 {
    static int[][] moving = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
    static int[][] back = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        // map의 크기 n,m
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 좌표(r,c) 바라보는 방향(d)
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int res = 0;
        while (true) {
            if (map[r][c] == 0) {
                map[r][c] = 2;
                res += 1;
            }
            if (map[r][c - 1] != 0 && map[r - 1][c] != 0 && map[r + 1][c] != 0 && map[r][c + 1] != 0) {
                        int dr = r + back[d][0];
                        int dc = c + back[d][1];
                        if (map[dr][dc] == 1) {
                            break;
                        } else {
                            r = dr;
                            c = dc;
                        }
                    
                
            } else {
                        int dr = r + moving[d][0];
                        int dc = c + moving[d][1];
                        if (map[dr][dc] == 0) {
                            r = dr;
                            c = dc;
                        }
                        if (d == 0) {
                            d = 3;
                        } else {
                            d -= 1;
                        }
                    
                
            }
            
        }
        System.out.println(res);

    }

}