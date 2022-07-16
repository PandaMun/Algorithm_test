import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 어디에_단어가_들어갈_수_있을까 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        int [] answer = new int[T]; 
        for(int test_case = 1; test_case <= T; test_case++)
		{
           st = new StringTokenizer(br.readLine());
           int n = Integer.parseInt(st.nextToken());
           int m = Integer.parseInt(st.nextToken());
           int [][] matrix = new int[n][n];
           int [][] rematrix = new int[n][n];
           int result = 0;
           for(int i = 0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<n; j++){
                    matrix[i][j] = Integer.parseInt(st.nextToken()); 
                }
           } 
           for(int i = 0; i<n; i++){
                for (int j = 0; j<n; j++){
                    rematrix[j][i] = matrix[i][j];
                }
           }
           for(int i = 0; i<n; i++){
                int stack = 0;
                int restack = 0;
                for (int j = 0; j<n; j++){
                    if (matrix[i][j] == 1){
                        stack += 1;
                        if(((n-1) == j) && (stack == m)){
                            result += 1;
                        }
                    }else{
                        if(stack == m){
                            result += 1;
                            stack = 0;
                        }else{
                            stack = 0;
                        }
                    }
                    if (rematrix[i][j] == 1){
                        restack += 1;
                        if(((n-1) == j) && (restack == m)){
                            result += 1;
                        }
                    }else{
                        if(restack == m){
                            result += 1;
                            restack = 0;
                        }else{
                            restack = 0;
                        }
                    }


                }
           }
           answer[test_case-1] = result;
        }
        for(int i = 0; i<T; i++){
            System.out.println('#' + Integer.toString(i+1) + ' ' + Integer.toString(answer[i]));
        }
    }
}
