import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_5644 {
    static int[] visited;
    static int[] a_location = new int[2];
    static int[] b_location = new int[2];
    static int[] dx = { 0, -1, 0, 1, 0 };
    static int[] dy = { 0, 0, 1, 0, -1 };

    public static int check(int[][] charger, int[] location1, int[] location2) {
        visited = new int[charger.length];
        int res = 0;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < charger.length; i++) {
            if (charger[i][2] >= (Math.abs(location1[0] - charger[i][0]) + Math.abs(location1[1] - charger[i][1]))) {
                list1.add(i);
            }
            if (charger[i][2] >= (Math.abs(location2[0] - charger[i][0]) + Math.abs(location2[1] - charger[i][1]))) {
                list2.add(i);
            }
        }
        if (list1.size() > 0 && list2.size() > 0) {
            if (list1.get(0) != list2.get(0)) {
                res += charger[list1.get(0)][3];
                res += charger[list2.get(0)][3];
            } else {

                if (list1.size() > 1 && list2.size() > 1) {

                    res += charger[list1.get(0)][3];
                    res += charger[Math.min(list1.get(1), list2.get(1))][3];
                } else if (list2.size() > 1 && list1.size() == 1) {
                    res += charger[list1.get(0)][3];
                    res += charger[list2.get(1)][3];
                } else if (list1.size() > 1 && list2.size() == 1) {
                    res += charger[list2.get(0)][3];
                    res += charger[list1.get(1)][3];
                } else {
                    res += charger[list1.get(0)][3];
                }
            }

        } else {
            for (int i = 0; i < list1.size(); i++) {
                res += charger[list1.get(i)][3];
                break;
            }
            for (int i = 0; i < list2.size(); i++) {
                res += charger[list2.get(i)][3];
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc < T + 1; tc++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int[] a_move = new int[m];
            int[] b_move = new int[m];
            for (int i = 0; i < m; i++) {
                a_move[i] = Integer.parseInt(st1.nextToken());
                b_move[i] = Integer.parseInt(st2.nextToken());
            }
            int[][] charger = new int[a][4];
            visited = new int[a];
            for (int i = 0; i < a; i++) {
                st = new StringTokenizer(br.readLine());
                charger[i][1] = Integer.parseInt(st.nextToken()) - 1;
                charger[i][0] = Integer.parseInt(st.nextToken()) - 1;
                charger[i][2] = Integer.parseInt(st.nextToken());
                charger[i][3] = Integer.parseInt(st.nextToken());
                visited[i] = 0;
            }

            Arrays.sort(charger, new Comparator<int[]>() {

                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[3] - o1[3];
                }
            });

            a_location = new int[] { 0, 0 };
            b_location = new int[] { 9, 9 };
            int answer = 0;
            answer += check(charger, a_location, b_location);
            for (int i = 0; i < m; i++) {
                a_location[0] += dx[a_move[i]];
                a_location[1] += dy[a_move[i]];
                b_location[0] += dx[b_move[i]];
                b_location[1] += dy[b_move[i]];
                answer += check(charger, a_location, b_location);
            }
            System.out.println("#" + tc + " " + answer);

        }

    }

}
