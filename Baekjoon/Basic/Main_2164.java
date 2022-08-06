import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main_2164{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i<N+1; i++){
            queue.add(i);
        }
        for(int i = 1; ; i++){
            if (queue.size() == 1){
                break;
            }
            if(i%2 == 0){
                queue.add(queue.remove());
            }else{
                queue.remove();
            }
         }
        System.out.println(queue.peek());
    }
}