import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109 {
    static int r;
    static int c;
    static int [] dx = new int [] {-1,0,1};
    static int [] dy = new int [] {1,1,1};
    static int [][]  map;
    static int answer;
    static boolean check;


    public static void dfs(int x, int y){
        if(y == c-1){
            check = true;
            return;
        }
        for(int i = 0; i<3; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < r && ny >= 0 && ny< c && map[nx][ny] == 0){
                if (check){
                    return;
                }
                map[nx][ny] = 2;
                dfs(nx,ny);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int [r][c];
        for(int i = 0; i<r; i++){
            String Line = br.readLine();
            for(int j = 0; j<c; j++){
                if(Line.charAt(j) == '.'){
                    map[i][j] = 0;
                }
                else{
                    map[i][j] = 1;
                }
            }
        }
        answer = 0;
        for(int i = 0; i< r; i++){
            check = false;
            dfs(i,0);
            if (check){
                answer++;
            }
        }
        System.out.println(answer);
    }
}
