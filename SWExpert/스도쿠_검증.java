import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 스도쿠_검증 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        int [][] puzzle = new int[9][9];
        int [] normal = new int[9];
        for(int test_case = 1; test_case<T+1; test_case++){
            int result = 1;
            int [] sum1 = new int [9];
            int [] sum2 = new int [9];
            for(int i = 0; i<9; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<9; j++){
                    puzzle[i][j] = Integer.parseInt(st.nextToken());
                }
                normal[i] = i+1;
            }
            for(int i = 0; i<9; i++){ // 가로, 세로 
                sum1 = new int[9];
                sum2 = new int[9];
                for(int j = 0; j<9; j++){
                    sum1[j] = puzzle[i][j];
                    sum2[j] = puzzle[j][i];
                }
                Arrays.sort(sum1);
                Arrays.sort(sum2);
                for(int k = 0; k<9; k++){
                    if((sum1[k] != normal[k]) || (sum2[k] != normal[k])){
                        result = 0;
                    }
                }
                if(result != 1){
                    break;
                }
            }
            if(result != 0){
                int [] matrix1 = new int[9];
                int [] matrix2 = new int[9];
                int [] matrix3 = new int[9];
                int stack1 = 0;
                int stack2 = 0;
                int stack3 = 0;
                for(int i = 0; i<9; i++){
                    for (int j = 0; j<9; j++){
                        if(j < 3){
                            matrix1[stack1++] = puzzle[i][j];
                        }
                        else if((j >= 3) && (j < 6)){
                            matrix2[stack2++] = puzzle[i][j];
                        } 
                        else{
                            matrix3[stack3++] = puzzle[i][j];
                        }
                    }
                    if((i == 2) || (i == 5) || (i == 8)){
                        Arrays.sort(matrix1);
                        Arrays.sort(matrix2);
                        Arrays.sort(matrix3);
                        for(int k = 0; k < 9; k++){
                            if((matrix1[k] != normal[k]) || (matrix2[k] != normal[k]) || (matrix3[k] != normal[k])){
                                result = 0;
                                break;
                            }
                        }
                        stack1 = 0;
                        stack2 = 0;
                        stack3 = 0;
                    }
                    if(result != 1){
                        break;
                    }

                }
            }
            System.out.println('#' + Integer.toString(test_case)+' '+Integer.toString(result));
    }
}
}

