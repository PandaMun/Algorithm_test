import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Location {
    int x, y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main_9205 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        StringTokenizer st = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            int count = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            Location start = new Location(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
            List<Location> shop = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                st = new StringTokenizer(br.readLine());
                shop.add(new Location(Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken())));
            }
            st = new StringTokenizer(br.readLine());
            Location destiny = new Location(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));

            Queue<Location> queue = new LinkedList<>();
            queue.add(start);
            boolean[] visited = new boolean[count];
            boolean answer = false;
            while (!queue.isEmpty()) {
                Location present = queue.poll();
                if (Math.abs(destiny.x - present.x) + Math.abs(destiny.y - present.y) <= 1000) {
                    answer = true;
                    break;
                }
                for (int i = 0; i < shop.size(); i++) {
                    Location next = shop.get(i);
                    if (Math.abs(next.x - present.x) + Math.abs(next.y - present.y) <= 1000 && !visited[i]) {
                        queue.add(new Location(next.x, next.y));
                        visited[i] = true;
                    }
                }
            }
            if (answer) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }

        }

    }

}
