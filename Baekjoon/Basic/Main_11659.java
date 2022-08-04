import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11659{
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int [] numbers = new int[n];
		int [] sum = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		} 
		for(int j = 0; j<n; j++) {
			if(j == 0) {
				
				sum[j+1] = numbers[j];
			}else {
				sum[j+1] = sum[j] + numbers[j];
			}
		}
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken());
			System.out.println(sum[end]-sum[start]);
		}
	}
}