import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2531 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        // 입력
        int[] sushi = new int[4];
        for (int i = 0; i < 4; i++) {
            sushi[i] = Integer.parseInt(st.nextToken());
        }

        int[] rotation = new int[sushi[0]];
        int[] selection = new int[sushi[1] + 1];

        for (int i = 0; i < sushi[0]; i++) {
            rotation[i] = Integer.parseInt(br.readLine());
        }
        // 슬라이싱 윈도우
        int result = 0;
        int answer = 0;

        for (int i = 0; i < sushi[2]; i++) {
            if (selection[rotation[i]] == 0) {
                result++;
            }
            selection[rotation[i]]++;
        }
        if (selection[sushi[3]] == 0) {
            selection[sushi[3]]++;
            result++;
        }
        for (int i = 0; i < sushi[2] + sushi[0]; i++) {
            selection[rotation[i % sushi[0]]]--;
            if (selection[rotation[i % sushi[0]]] == 0) { // 뒤에 있는건
                result--;
            }
            selection[rotation[(i + sushi[2]) % sushi[0]]]++;
            if (selection[rotation[(i + sushi[2]) % sushi[0]]] == 1) {
                result++;
            }
            if (selection[sushi[3]] == 0) {
                selection[sushi[3]]++;
                result++;
            }
            answer = Math.max(answer, result);
        }
        System.out.println(answer);
    }
}
