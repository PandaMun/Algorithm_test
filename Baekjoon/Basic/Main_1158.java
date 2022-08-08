import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1158 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        List<Integer> Circle = new LinkedList<>();
        for(int i = 1; i<n+1; i++){
            Circle.add(i);
        }
        int index = k-1;
        System.out.print("<");
        while(Circle.size() > 1){
            if (Circle.size() <= index){
                index = index % Circle.size();
            }
            System.out.print(Circle.get(index)+", ");
            Circle.remove(index);

            index += k-1;
        }
        System.out.println(Circle.get(0) + ">");
    }
}
