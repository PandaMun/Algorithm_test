import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074 {
    
    static int num;
    
    public static void z(int n,int r,int c){
        //4등분
        if (n == 0){
            return;
        }
        int size = (int)Math.pow(2, n);
        if(size/2 > r && size/2 > c){
            z(n-1, r % (size/2), c % (size/2));
        }
        else if(size/2 > r && size/2 <= c){
            num += (size/2) * (size/2) * 1;
            z(n-1, r, c - (size/2));
        }
        else if(size/2 <= r && size/2 > c){
            num += (size/2) * (size/2) * 2;
            z(n-1, r - (size/2), c );
        }
        else if(size/2 <= r && size/2 <= c){
            num += (size/2) * (size/2) * 3;
            z(n-1, r - (size/2), c - (size/2));
        }
    }

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        num = 0;
        z(n, r, c);
        System.out.println(num);

    }
}
