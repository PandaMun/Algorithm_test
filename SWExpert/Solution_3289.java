import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3289 {

    static int [] parents;
    static int n;
    static int m;

    public static void union(int x, int y){
        x = find(x);
        y = find(y);
        parents[x] = y;
    }
    public static int find(int x){
        if(parents[x] == x){
            return x;
        }
        parents[x] = find(parents[x]);
        return parents[x];
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc < T+1; tc++){
            System.out.print("#" + tc + " ");
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            parents = new int[n + 1];
            for(int i = 0; i< n+1; i++){
                parents[i] = i;
            }
            for(int i = 0; i< m; i++){
                st = new StringTokenizer(br.readLine());
                int cal = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(cal == 0){
                    union(a,b);
                }else{
                    if(find(a) != find(b)){
                        System.out.print(0);
                    }
                    else{
                        System.out.print(1);
                    }
                }
            }
            System.out.println();

        }
    }
}
