import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1926 {
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,1,0,-1};
    static int size;
    static int max_size;
    static int count;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [][] paper = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue <int[]> queue = new LinkedList<>();
        max_size = 0;
        count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(paper[i][j] == 1){
                    size = 0;
                    queue.offer(new int[] {i,j});
                    paper[i][j] = 2;
                    while(!queue.isEmpty()){
                        int [] dir = queue.poll();
                        int x = dir[0];
                        int y = dir[1];
                        for(int k = 0; k<4; k++){
                            int nx = dx[k] + x;
                            int ny = dy[k] + y;
                            if(nx>=0 && nx < n && ny>=0 && ny < m){
                                if(paper[nx][ny] == 1){
                                    queue.offer(new int []{nx,ny});
                                    paper[nx][ny] = 2;
                                }
                            }
                        }
                        size += 1;
                    }
                    max_size = Math.max(size, max_size);
                    count += 1;
                }
            }
        }
        System.out.println(count);
        System.out.println(max_size);
    }
}
