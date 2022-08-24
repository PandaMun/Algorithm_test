import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_13023 {
    
    static boolean [] visited;
    static List<Integer>[] list;
    static int n;
    static int m;
    static int answer = 0;

    static void dfs(int start, int count){
        if(count >= 4){
            answer = 1;
            return;
        }
            for(int i = 0; i< list[start].size(); i++){
                int value = list[start].get(i);
                if(!visited[value]){
                    visited[value] = true;
                    dfs(value, count + 1);
                    visited[value] = false;
                }
            }
        }
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n];
        
        for(int i = 0; i<n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for(int i = 0; i< n; i++){
        if(answer == 1){
            break;
        }
        visited = new boolean[n];
        visited[i] = true;
        dfs(i,0);
        }
        System.out.println(answer);
        
    }
}
