import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_17143 {

    static List<Shark> shark;
    static int r;
    static int c;
    static int[] dx = { 0, -1, 1, 0, 0 };
    static int[] dy = { 0, 0, 0, 1, -1 };

    static class Shark {
        int r, c, s, d, z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

    }

    public static void sharkMove() {
        boolean[][] visited = new boolean[r + 1][c + 1];
        boolean flag = false;
        for (int i = 0; i < shark.size(); i++) {
            if (shark.get(i).z != 0) {
                if (shark.get(i).d == 1 || shark.get(i).d == 2) {
                    for (int j = 0; j < shark.get(i).s % ((r * 2) - 2); j++) {
                        if (shark.get(i).r == 1) {
                            shark.get(i).d = 2;
                        } else if (shark.get(i).r == r) {
                            shark.get(i).d = 1;
                        }
                        shark.get(i).r += dx[shark.get(i).d];
                        shark.get(i).c += dy[shark.get(i).d];
                    }
                } else if (shark.get(i).d == 3 || shark.get(i).d == 4) { // 오른쪽
                    for (int j = 0; j < shark.get(i).s % ((c * 2) - 2); j++) {
                        if (shark.get(i).c == 1) {
                            shark.get(i).d = 3;
                        } else if (shark.get(i).c == c) {
                            shark.get(i).d = 4;
                        }
                        shark.get(i).r += dx[shark.get(i).d];
                        shark.get(i).c += dy[shark.get(i).d];
                    }
                }
            }
            if (!visited[shark.get(i).r][shark.get(i).c]) {
                visited[shark.get(i).r][shark.get(i).c] = true;
            } else {
                flag = true;
            }
        }
        if (flag) {
            checkEat();
        }

    }

    public static void checkEat() {
        int[][] map = new int[r + 1][c + 1];
        for (int i = 0; i < r + 1; i++) {
            for (int j = 0; j < c + 1; j++) {
                map[i][j] = -1;
            }
        }
        List<Integer> check = new ArrayList<>();
        for (int i = 0; i < shark.size(); i++) {
            int shark_r = shark.get(i).r;
            int shark_c = shark.get(i).c;
            int shark_size = shark.get(i).z;
            if (map[shark_r][shark_c] == -1) {
                map[shark_r][shark_c] = i;
                check.add(i);
            } else {
                if (shark.get(map[shark_r][shark_c]).z < shark_size) {
                    check.remove((Object) map[shark_r][shark_c]);
                    map[shark_r][shark_c] = i;
                    check.add(i);
                }
            }
        }
        List<Shark> result = new ArrayList<>();
        for (int i : check) {
            result.add(shark.get(i));
        }
        shark = result;
    }

    public static int catchShark(int location) {
        int sharkLocation = Integer.MAX_VALUE;
        int sharkSize = 0;
        for (int i = 0; i < shark.size(); i++) {
            if (shark.get(i).c == location) {
                sharkLocation = Math.min(shark.get(i).r, sharkLocation);
            }
        }
        for (int i = 0; i < shark.size(); i++) {
            if (shark.get(i).r == sharkLocation && shark.get(i).c == location) {
                sharkSize = shark.get(i).z;
                shark.remove(i);
            }
        }

        return sharkSize;
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        shark = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int shark_r = Integer.parseInt(st.nextToken());
            int shark_c = Integer.parseInt(st.nextToken());
            int shark_s = Integer.parseInt(st.nextToken());
            int shark_d = Integer.parseInt(st.nextToken());
            int shark_z = Integer.parseInt(st.nextToken());
            shark.add(new Shark(shark_r, shark_c, shark_s, shark_d, shark_z));
        }
        int answer = 0;
        for (int i = 1; i <= c; i++) {
            answer += catchShark(i);
            sharkMove();
        }
        System.out.println(answer);

    }

}