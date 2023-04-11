package Level2;

public class DelieveryKakao {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliveryCount = 0; // 배달 가능 용량
        int pickupCount = 0; // 픽업 가능 용량

        for (int i = n - 1; i >= 0; i--) {
            if (deliveries[i] != 0 || pickups[i] != 0) {
                int cnt = 0;
                while (deliveryCount < deliveries[i] || pickupCount < pickups[i]) { // 배달이나 픽업 가능한 용량이 적을때
                    cnt += 1;
                    deliveryCount += cap; // 채워줌
                    pickupCount += cap;
                }
                deliveryCount -= deliveries[i];
                pickupCount -= pickups[i];
                answer += (i + 1) * cnt * 2;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

    }

}
