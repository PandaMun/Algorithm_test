import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2839 {
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n <= 4){
            if (n % 3 == 0){
                System.out.println(n/3);
            }
            else{
                System.out.println(-1);
            }
        }
        else{
            for(int i = n/5; i>-1; i--){
                if( (n - (i*5))  % 3 == 0){
                    System.out.println(((n - (i*5)) / 3) + i);
                    break;
                }
                if(i == 0){
                    System.out.println(-1);
                    break;
                }
            }
        }
    
    }
}
