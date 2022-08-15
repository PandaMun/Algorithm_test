import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_3273 {

    static int answer;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        answer = 0;

        int n = Integer.parseInt(br.readLine());
        Integer[] array = new Integer[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);

        int x = Integer.parseInt(br.readLine());
        int i = 0;
        int j = n - 1;
        while (i < j) {
            if (array[i] + array[j] == x) {
                answer += 1;
            }
            if (array[i] + array[j] < x) {
                i += 1;
            } else {
                j -= 1;
            }

        }
        System.out.println(answer);

    }
}
