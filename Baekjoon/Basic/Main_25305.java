import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_25305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Integer [] score = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i< n; i++){
            score[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(score, Collections.reverseOrder());
        int answer = score[0];
        for(int i = 0; i< score.length; i++){
            if(score[i] != answer){
                System.out.println(score[i]);
                break;
            }
        }

    }
}
