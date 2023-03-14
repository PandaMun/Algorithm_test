package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class LongNode {
    public static int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[] check = new boolean[n];
        boolean[][] connect = new boolean[n][n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < edge.length; i++) {
            connect[edge[i][0] - 1][edge[i][1] - 1] = true;
            connect[edge[i][1] - 1][edge[i][0] - 1] = true;
        }
        check[0] = true;
        queue.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                for (int j = 0; j < n; j++) {
                    if (connect[j][node] && !check[j]) {
                        check[j] = true;
                        queue.add(j);
                    }
                }
            }
            answer = size;
        }
        return answer;
    }
}
