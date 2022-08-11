import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2961 {

    static int material[][];
    static int least;
    static int n;
    static void dfs(int index, int bitter, int sour,int count){

        if(count > 0 && least > Math.abs(bitter - sour)){
            least = Math.abs(bitter - sour);
        }
        if (index >= n){
            return;
        }
        dfs(index+1,bitter*material[index][0], sour + material[index][1],count+1);
        dfs(index+1,bitter,sour,count);
        
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
		material = new int [n][2];
        for(int i = 0; i< n; i++){
        st = new StringTokenizer(br.readLine());
            material[i][0] = Integer.parseInt(st.nextToken());
            material[i][1] = Integer.parseInt(st.nextToken());
    }
        least = 1000000000;
        dfs(0,1,0,0);
        System.out.println(least);
    }
}
