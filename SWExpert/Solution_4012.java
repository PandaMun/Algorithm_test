import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_4012 {

    static int[][] ingredients;
    static int[] save;
    static int n;
    static int[] combi;
    static int least;

    public static void Combination(int level, int count, int[] save) {
        if (count == (n / 2)) {
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list2.add(i);
            }
            for (int i = 0; i < n / 2; i++) {
                list1.add(save[i]);
                list2.remove((Object) save[i]);
            }
            int value1 = sinergy(list1);
            int value2 = sinergy(list2);
            least = Math.min(least, Math.abs(value1 - value2));

            return;

        }
        if (level >= n) {
            return;
        }
        Combination(level + 1, count, save);

        save[count] = combi[level];

        Combination(level + 1, count + 1, save);

    }

    static int sinergy(List<Integer> arr) {
        int value = 0;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                value += ingredients[arr.get(i)][arr.get(j)] + ingredients[arr.get(j)][arr.get(i)];
            }
        }
        return value;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc < T + 1; tc++) {
            n = Integer.parseInt(br.readLine());

            ingredients = new int[n][n];
            combi = new int[n];
            save = new int[n / 2];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    ingredients[i][j] = Integer.parseInt(st.nextToken());

                }
                combi[i] = i;

            }

            least = Integer.MAX_VALUE;
            Combination(0, 0, save);
            System.out.println("#" + tc + " " + least);

        }

    }

}
