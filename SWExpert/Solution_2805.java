import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_2805 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case < T + 1; test_case++) {
			int res = 0;
			int N = Integer.parseInt(br.readLine());
			int [][] farm = new int [N][N];
			for(int i = 0; i< N; i++) {
				String a = br.readLine();
				for(int j = 0; j < N; j++) {
					farm[i][j] = a.charAt(j) - '0';
				}
			}
			int start = (N/2); 
			int index = 0;
			for(int i = 0; i<= N/2; i++) {
				for(int j : Arrays.copyOfRange(farm[index], start-i, start+i+1)) {
					res += j;
				}
				index ++;
			}
			for(int i = (N/2)-1; i>=0; i--) {
				for(int j : Arrays.copyOfRange(farm[index], start-i, start+i+1)) {
					res += j;
				}
				index ++;
			}
			System.out.println("#" + test_case + " " + res);
		}
	}
}