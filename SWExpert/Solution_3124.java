import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int Node_A;
    int Node_B;
    int Weight;

    public Edge(int node_A, int node_B, int weight) {
        this.Node_A = node_A;
        this.Node_B = node_B;
        this.Weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.Weight - o.Weight;
    }
}

public class Solution_3124 {

    static int V;
    static int E;
    static int[] parents;
    static List<Edge> list;

    public static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parents[y] = x;
            return true;
        }
        return false;
    }

    public static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        parents[x] = find(parents[x]);
        return parents[x];
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc < T + 1; tc++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            parents = new int[V+1];
            list = new ArrayList<>();
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                list.add(new Edge(a, b, c));
            }
            Collections.sort(list);
            // 초기화
            for (int i = 0; i < V+1; i++) {
                parents[i] = i;
            }
            long answer = 0;

            for (int i = 0; i < E; i++) {
                Edge egde = list.get(i);
                if (union(egde.Node_A, egde.Node_B)) {
                    answer += (long)egde.Weight;
                }
            }
            System.out.println("#" + tc + " " + answer);
        }
    }
}