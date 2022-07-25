import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MatrixMultiplication {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [][] matrix1 = new int [N][M];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<M; j++){
                matrix1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int [][] matrix2 = new int [M][K];
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<K; j++){
                matrix2[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = 0;
        int answer[][] = new int [N][K];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < K; j++){
                result = 0;
                for(int k = 0; k < M; k++){
                    result += (matrix1[i][k] * matrix2[k][j]);
                }
                answer[i][j] = result;
                System.out.print(result + " ");
            }
            System.out.println();
        }
    }
}
