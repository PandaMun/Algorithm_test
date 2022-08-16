import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1828 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int[][] chemical = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            chemical[i][0] = Integer.parseInt(st.nextToken());
            chemical[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(chemical, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        int answer = 1;
        int cover = chemical[0][1];
        for (int i = 0; i < n; i++) {
            if (chemical[i][0] > cover){
                cover = chemical[i][1];
                answer += 1;
            }
            }
        
        System.out.println(answer);

    }
}
