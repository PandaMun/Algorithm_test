import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FollowingNum1 {
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int answer = 0;
    int N = Integer.parseInt(br.readLine());
    int len = String.valueOf(N).length();
    answer += ((N - ((int)(Math.pow(10 ,(len - 1))) - 1 )) * len);
    System.out.println(answer);
    System.out.println("2222");
    len -= 1;
    for(int i = len; i >= 1; i-- ){
        System.out.println(i);
        System.out.println(answer);
        if (i == 1) {
            answer += 9;
        }
        else {
            System.out.println(Math.pow(10 , i-1));
            answer += ((9 * (Math.pow(10 , i-1))) * i);
        }
    }
    System.out.println(answer);
    }
}