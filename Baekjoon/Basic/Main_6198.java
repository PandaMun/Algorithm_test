import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_6198 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /**
         * 입력값에 따라 자료형 타입도 달라져야 합니다.
         * 이번 예제에서는 최대 80000개의 빌딩이 입력값으로 들어오므로
         * 최대 80000 + 79999 + 79998 + 79997 ...... + 2 + 1= 3200040000(32억 4만개)가 답이 될수
         * 있기 떄문에
         * int가 아닌 long을 써야 합나디.
         */

        long answer = 0;
        int buildingCount = Integer.parseInt(br.readLine());
        Stack<Integer> building = new Stack<>();
        building.push(Integer.parseInt(br.readLine()));

        for (int i = 1; i < buildingCount; i++) {
            int nextBuilding = Integer.parseInt(br.readLine());
            while (!building.isEmpty() && building.peek() <= nextBuilding) {
                building.pop();
            }
            answer += (building.size());
            building.push(nextBuilding);

        }
        System.out.println(answer);
    }

}