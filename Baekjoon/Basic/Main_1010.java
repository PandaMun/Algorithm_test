import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1010 {
    
    static int[][] map;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    static int count;
    static int w;
    static int h;
    
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        while(true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w == 0 && h == 0) {
                break;
            }
            map = new int[h][w];
            for(int i = 0; i<h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            Queue <int[]> queue = new LinkedList<>();
            count = 0;
            for(int i = 0; i< h; i++) {
                for(int j = 0; j<w; j++) {
                    if(map[i][j] == 1) {
                        queue.add(new int[] {i,j});
                        while(!queue.isEmpty()) {
                            int[] dir = queue.poll();
                            int x = dir[0];
                            int y = dir[1];
                            map[x][y] = 2;
                            for(int d = 0; d<8; d++) {
                                int nx = dx[d] + x;
                                int ny = dy[d] + y;
                                if(nx >= 0 && ny >= 0 && nx < h && ny < w) {
                                    if(map[nx][ny] == 1) {
                                        queue.add(new int[] {nx,ny});
                                        map[nx][ny] = 2;
                                    }
                                }
                            }
                        }
                        count += 1;
                    }
                    
                } 
            }
            
            
            
            System.out.println(count);
            
        }
    }
}
