import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        for (int tc = 1; tc < 11; tc++) {
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            Map<Integer, List<Integer>> map = new HashMap<>();
            int[][] graph = new int[len / 2][2];
            boolean[] visited = new boolean[len + 1];
            List<int[]> answer = new ArrayList<>();
            for (int i = 0; i < (len / 2); i++) {
                graph[i][0] = Integer.parseInt(st.nextToken());
                graph[i][1] = Integer.parseInt(st.nextToken());
                map.put(graph[i][0], new ArrayList<>());
            }
            for (int i = 0; i < len / 2; i++) {
                List<Integer> a = map.get(graph[i][0]);
                a.add(graph[i][1]);
                map.put(graph[i][0], a);
            }
            Queue<int[]> queue = new LinkedList<>();
            int max = 1;
            answer = new ArrayList<>();
            visited[start] = true;
            for (int i : map.get(start)) {
                queue.add(new int[] { i, 1 });
                visited[i] = true;
                answer.add(new int[] { i, 1 });
            }
            while (!queue.isEmpty()) {
                int[] next = queue.poll();
                if (next[1] > max) {
                    max = next[1];
                }
                int key = next[0];
                if (map.get(key) != null) {
                    for (int i : map.get(key)) {
                        if (!visited[i]) {
                            queue.add(new int[] { i, next[1] + 1 });
                            answer.add(new int[] { i, max });
                            System.out.println(i);
                            visited[i] = true;
                        }
                    }
                }
            }
            Collections.sort(answer, new Comparator<int[]>() {

                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[1] == o2[1]) {
                        return o2[0] - o1[0];
                    }
                    return o2[1] - o1[1];
                }

            });
            System.out.println("#" + tc + " " + answer.get(0)[0]);
        }
    }
}
