import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12891 {
    
    static int [] DNA = {0,0,0,0};
    
    static void add(String word) {
        if(word .equals("A")) {
            DNA[0] += 1;
        }
        else if(word.equals("C")) {
            DNA[1] += 1;
        }
        else if(word.equals("G")) {
            DNA[2] += 1;
        }
        else if(word.equals("T")) {
            DNA[3] += 1;
        }
            }
        
    
    static void remove(String word) {
        if(word .equals("A")) {
            DNA[0] -= 1;
        }
        else if(word.equals("C")) {
            DNA[1] -= 1;
        }
        else if(word.equals("G")) {
            DNA[2] -= 1;
        }
        else if(word.equals("T")) {
            DNA[3] -= 1;
        }
    }
    static boolean check(int [] count) {
        if (count[0] <= DNA[0] && count[1] <= DNA[1] && count[2] <= DNA[2] && count[3] <= DNA[3]) {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
    
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int [] cnt = new int[4];
        int res = 0;
        String word = br.readLine();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<4; i++) {
            cnt[i] = Integer.parseInt(st.nextToken());
        }
        String [] password = new String[S];
        for(int i = 0; i<S; i++) {
            password[i] = String.valueOf(word.charAt(i));
        }
        
        for(int i = 0; i<P; i++) {
            add(password[i]);
        }
        
        if (check(cnt)) {
            res += 1;
        }
        int start = 0;
        for(int end = P; end < S; end++) {
            remove(password[start]);
            add(password[end]);
            start += 1;
          
            if (check(cnt)) {
                res += 1;
            }
        }
        System.out.println(res);
    }
}