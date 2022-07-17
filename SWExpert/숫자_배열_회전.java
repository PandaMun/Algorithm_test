import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자_배열_회전 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case<T+1; test_case++){
            int N = Integer.parseInt(br.readLine());
            int [][] matrix = new int [N][N];
            for(int i = 0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<N; j++){
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int [][] matrix1 = new int [N][N];
            int [][] matrix2 = new int [N][N];
            int [][] matrix3 = new int [N][N];
            for(int i = 0; i<N; i++){
                for (int j = 0; j<N; j++){
                    matrix1[i][j] = matrix[N - j - 1][i];
                    matrix2[i][j] = matrix[N - i - 1][N - j - 1];
                    matrix3[i][j] = matrix[j][N - i - 1];
                }
            }
            System.out.println("#"+ test_case);
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    System.out.print(matrix1[i][j]);
                }
                System.out.print(" ");
                for(int j = 0; j < N; j++) {
                    System.out.print(matrix2[i][j]);
                }
                System.out.print(" ");
                for(int j = 0; j < N; j++) {
                    System.out.print(matrix3[i][j]);
                }
                System.out.println();
            }
        }
    }
}
