import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_3040 {

    public static void main(String[] args) throws NumberFormatException, IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] array = new int[9];
        for(int i = 0; i<9; i++){
        array[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 0; i<9; i++){
            for(int j = i+1; j<9; j++){
                if(Arrays.stream(array).sum() - array[i] - array[j] == 100){
                    array[i] = -1;
                    array[j] = -1;
                    break;
                }
            }
        }
        for(int i = 0; i<9; i++){
            if(array[i] != -1){
                System.out.println(array[i]);
            }
        }

    }
}
