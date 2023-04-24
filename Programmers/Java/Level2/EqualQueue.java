package Level2;

import java.util.LinkedList;
import java.util.Queue;

public class EqualQueue {

    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> firstQueue = new LinkedList<>();
        Queue<Integer> secondQueue = new LinkedList<>();

        long sum1 = 0, sum2 = 0;
        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            firstQueue.offer(queue1[i]);
        }

        for (int i = 0; i < queue2.length; i++) {
            sum2 += queue2[i];
            secondQueue.offer(queue2[i]);
        }

        int count = 0;
        while (sum1 != sum2) {
            count++;

            if (sum1 > sum2) {
                int value = firstQueue.poll();
                sum1 -= value;
                sum2 += value;
                secondQueue.offer(value);
            } else {
                int value = secondQueue.poll();
                sum1 += value;
                sum2 -= value;
                firstQueue.offer(value);
            }

            if (count > (queue1.length + queue2.length) * 2)
                return -1;
        }

        return count;
    }
}
