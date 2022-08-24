import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576 {
    
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
    
        int [][] box = new int[n][m];
        Queue<int []> queue = new LinkedList<>();
        for(int i = 0; i< n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1){
                    queue.add(new int [] {i,j,0});
                }
            }
        }
        int answer = 0;
        while(!queue.isEmpty()){
            int [] xy = queue.poll();
            int x = xy[0];
            int y = xy[1];
            int time = xy[2];
            for(int i = 0; i< 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >=0 && ny >=0 && nx < n && ny < m){
                    if (box[nx][ny] == 0){
                        box[nx][ny] = 1;
                        queue.add(new int[]{nx,ny, time + 1});
                    }
                }
                answer = Math.max(answer,time);
            }
        }
        for(int i = 0; i< n; i++){
            for(int j = 0; j < m; j++){
                if (box[i][j] == 0){
                    answer = -1;
                }
            }
        }
        System.out.println(answer);
    
    }
}