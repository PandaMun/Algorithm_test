import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class Solution_1228{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        for (int tc = 0; tc < 10; tc ++){
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            List<Integer> password = new LinkedList<>();
            for(int i = 0; i<n; i++){
                password.add(Integer.parseInt(st.nextToken()));
            }
            int count = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<count; i++){
                String command = st.nextToken();
                int index = Integer.parseInt(st.nextToken());
                int command_cnt = Integer.parseInt(st.nextToken());
                for(int j = 0; j<command_cnt; j++){
                    password.add(index+j,Integer.parseInt(st.nextToken()));
                }

            }
            System.out.print("#" + (tc+1) + " ");
            for(int i = 0; i<10; i++){
                System.out.print(password.get(i) + " ");
            }
            System.out.println();

        }
    }
}