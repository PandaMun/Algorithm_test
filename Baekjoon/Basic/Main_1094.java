import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1094 {

    static int stick;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int end = Integer.parseInt(br.readLine());
        int answer = 0;
        stick = 64;
        while (true) {
            if (answer == 0 && (stick - end) == 0) {
                answer += 1;
                break;
            }
            stick /= 2;
            if (stick <= end) {
                end -= stick;
                answer += 1;
            }
            if (end == 0) {
                break;
            }
        }
        System.out.println(answer);

    }
}
