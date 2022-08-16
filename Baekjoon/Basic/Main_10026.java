import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main_10026 {

    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static HashMap<Character, Integer> colors = new HashMap<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        int[][] visited1 = new int[n][n];
        int [][] visited2 = new int[n][n];
        for (int i = 0; i < n; i++) {
            String Line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = Line.charAt(j);
                visited1[i][j] = 0;
                visited2[i][j] = 0;
            }
        }
        colors.put('R', 0);
        colors.put('G', 1);
        colors.put('B', 2);
        int answer1 = 0;
        int answer2 = 0;
        Queue<int[]> queue1 = new LinkedList<>();
        Queue<int[]> queue2 = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited1[i][j] == 0){
                    queue1.offer(new int[] {i,j,colors.get(map[i][j])});
                    visited1[i][j] = 1;
                    while(!queue1.isEmpty()){
                        int[] arr = queue1.poll();
                        int x = arr[0];
                        int y = arr[1];
                        int color = arr[2];
                        for(int k = 0; k < 4; k++){
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                                if(color == 0 && map[nx][ny] == 'R' && visited1[nx][ny] == 0){
                                    queue1.offer(new int[] { nx, ny, colors.get(map[nx][ny]) });
                                    visited1[nx][ny] = 1;
                                }
                                else if(color == 1 && map[nx][ny] == 'G' && visited1[nx][ny] == 0){
                                    queue1.offer(new int[] { nx, ny, colors.get(map[nx][ny]) });
                                    visited1[nx][ny] = 1;
                                }
                                else if(color == 2 && map[nx][ny] == 'B' && visited1[nx][ny] == 0){
                                    queue1.offer(new int[] { nx, ny, colors.get(map[nx][ny]) });
                                    visited1[nx][ny] = 1;
                                }
                        }
                    }
                }
                answer1 += 1;
            }
                if (visited2[i][j] == 0) {
                    queue2.offer(new int[] { i, j, colors.get(map[i][j]) });
                    visited2[i][j] = 1;
                    while (!queue2.isEmpty()) {
                        int[] arr = queue2.poll();
                        int x = arr[0];
                        int y = arr[1];
                        int color = arr[2];
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                                if ((color == 0 || color == 1) && (map[nx][ny] == 'R' || map[nx][ny] == 'G')
                                        && visited2[nx][ny] == 0) {
                                    queue2.offer(new int[] { nx, ny, colors.get(map[nx][ny]) });
                                    visited2[nx][ny] = 1;

                                } else if (color == 2 && map[nx][ny] == 'B' && visited2[nx][ny] == 0) {
                                    queue2.offer(new int[] { nx, ny, colors.get(map[nx][ny]) });
                                    visited2[nx][ny] = 1;
                                }
                            }
                        }
                    }
                    answer2 += 1;

                }
            }
        }
        System.out.println(answer1 + " " + answer2);

    }
}
