import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
// baekjoon : 2012 등수 매기기
public class Main_2012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		
		int N = Integer.parseInt(br.readLine());
		int [] people = new int[N];
		for(int i = 0; i<N; i++) {
			int rank = Integer.parseInt(br.readLine());
			people[i] = rank;
		}
		Arrays.sort(people);
		for(int i = 1; i<N+1; i++) {
			answer += Math.abs(i - people[i-1]);
		}
		System.out.println(answer);
	}
}