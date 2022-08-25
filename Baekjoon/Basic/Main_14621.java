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

public class Main_14621 {

    static int N, M;
    static int[] parents;
    static int[] gender;
    static List<Edge> list;

    public static boolean union(int x, int y) {
        if (gender[x] != gender[y]) {
            x = find(x);
            y = find(y);
            if (x != y) {
                parents[x] = y;
                return true;
            }
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

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];
        gender = new int[N + 1];
        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            parents[i] = i;
            if (st.nextToken().equals("M")) {
                gender[i] = 0;
            } else {
                gender[i] = 1;
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.add(new Edge(x, y, w));

        }
        int answer = 0;
        Collections.sort(list);
        for (int i = 0; i < M; i++) {
            Edge edge = list.get(i);
            if (union(edge.Node_A, edge.Node_B)) {
                answer += edge.Weight;
            }
        }
        System.out.println(answer);
    }
}
