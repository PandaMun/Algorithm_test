import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1753 {

    static int V;
    static int E;
    static List<int[]>[] weight;
    static int[] distance;
    static boolean[] visited;

    static int check() {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 1; i <= V; i++) {
            if (visited[i] == false) {
                if (min > distance[i]) {
                    min = distance[i];
                    res = i;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        weight = new ArrayList[V + 1];
        for (int i = 0; i < V + 1; i++) {
            weight[i] = new ArrayList<>();
        }
        visited = new boolean[V + 1];
        distance = new int[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            weight[a].add(new int[] { b, w });
        }

        while (!visited[start]) {
            visited[start] = true;
            for (int j = 0; j < weight[start].size(); j++) {
                int[] arr = weight[start].get(j);
                distance[arr[0]] = Math.min(distance[arr[0]], distance[start] + arr[1]);
            }
            start = check();

        }
        for (int i = 1; i <= V; i++) {
            if (distance[i] != Integer.MAX_VALUE) {
                System.out.println(distance[i]);
            } else {
                System.out.println("INF");
            }
        }

    }
}
