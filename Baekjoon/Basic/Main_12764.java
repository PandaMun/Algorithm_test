import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_12764 {
    static int[] seat;
    static int answer = 0;
    static int[] seatCount;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        seatCount = new int[N + 1];
        PriorityQueue<int[]> order = new PriorityQueue<>(new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }

        });
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }

        });
        PriorityQueue<Integer> count = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            order.offer(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
        }
        for (int i = 0; i < N; i++) {
            int[] seats = order.poll();
            if (i == 0) {
                queue.offer(new int[] { seats[1], 0 });
                seatCount[0] = 1;
                answer = 1;
            } else {
                if (queue.peek()[0] > seats[0]) {
                    if (count.size() != 0) { // 남은 좌석이 있을때
                        int num = count.poll();
                        queue.offer(new int[] { seats[1], num });
                        seatCount[num] += 1;
                    } else { // 남는 좌석이 없을때 추가
                        queue.offer(new int[] { seats[1], answer });
                        seatCount[answer] = 1;
                    }
                    answer = Math.max(answer, queue.size());

                } else {
                    while (!queue.isEmpty() && queue.peek()[0] <= seats[0]) {
                        count.offer(queue.peek()[1]);
                        queue.poll();
                    }
                    int seat = count.poll();
                    queue.offer(new int[] { seats[1], seat });
                    seatCount[seat] += 1;
                }
            }
        }
        sb.append(answer + "\n");
        for (int i = 0; i < answer; i++) {
            sb.append(seatCount[i] + " ");
        }
        System.out.println(sb.toString());
    }
}
