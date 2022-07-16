import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.StringTokenizer;

public class 두개의_문자열 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
		{
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int [] A = new int[n];
            int [] B = new int[m];
            st = new StringTokenizer(br.readLine());
            for(int i =0; i < n; i++){
                A[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i =0; i < m; i++){
                B[i] = Integer.parseInt(st.nextToken());
            }
            int result = 0;
            if(n > m){
                for(int i = 0; i<n-m+1; i++){
                    int sum = 0;
                    for(int j = 0; j < m; j++){
                        sum += A[i+j] * B[j];
                    }
                    if(sum > result){
                        result = sum;
                    }
                }
            }else{
                for(int i = 0; i<m-n+1; i++){
                    int sum = 0;
                    for(int j = 0; j < n; j++){
                        sum += A[j] * B[i+j];
                    }
                    if(sum > result){
                        result = sum;
                    }
                }
            }
            System.out.println('#' + Integer.toString(test_case) + ' ' + Integer.toString(result));
        } 
    }
}
