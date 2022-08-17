import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_1992 {
    static List<String> answer = new ArrayList<>();

    public static int check(int[][] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += arr[i][j];
            }
        }
        if (sum == (arr.length * arr[0].length)) {
            return 1;
        } else if (sum == 0) {
            return 0;
        } else {
            return 2;
        }
    }

    public static void dfs(int[][] map, int n) {
        answer.add("(");
        int[][] arr1 = new int[n / 2][n / 2];
        int[][] arr2 = new int[n / 2][n / 2];
        int[][] arr3 = new int[n / 2][n / 2];
        int[][] arr4 = new int[n / 2][n / 2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < n / 2 && j < n / 2) {
                    arr1[i][j] = map[i][j];
                } else if (i < n / 2 && j >= n / 2) {
                    arr2[i][j - (n / 2)] = map[i][j];
                } else if (i >= n / 2 && j < n / 2) {
                    arr3[i - (n / 2)][j] = map[i][j];
                } else if (i >= (n / 2) && j >= (n / 2)) {
                    arr4[i - (n / 2)][j - (n / 2)] = map[i][j];
                }
            }
        }
        int a = check(arr1, n / 2);
        if (a == 1 || a == 0) {
            answer.add(Integer.toString(a));
        } else {
            dfs(arr1, n / 2);
        }

        int b = check(arr2, n / 2);
        if (b == 1 || b == 0) {
            answer.add(Integer.toString(b));
        } else {
            dfs(arr2, n / 2);
        }

        int c = check(arr3, n / 2);
        if (c == 1 || c == 0) {
            answer.add(Integer.toString(c));
        } else {
            dfs(arr3, n / 2);
        }

        int d = check(arr4, n / 2);
        if (d == 1 || d == 0) {
            answer.add(Integer.toString(d));
        } else {
            dfs(arr4, n / 2);
        }

        answer.add(")");
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String Line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = (int) (Line.charAt(j)) - 48;
            }
        }
        int a = check(map, n);
        if (a == 2) {
            dfs(map, n);
        } else {
            answer.add(String.valueOf(a));
        }
        for (int i = 0; i < answer.size(); i++) {
            System.out.print((answer.get(i)));
        }
    }
}
