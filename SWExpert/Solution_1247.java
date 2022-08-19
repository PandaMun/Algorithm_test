import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1247 {
	
	static int [] corporation = new int[2];
	static int [] home = new int[2];
	static int min;
	static boolean [] visited;
	static int [][] customer;
	
	static void dfs(int x,int y, int distance,int n) {
		if(n == customer.length) {
			distance +=  (Math.abs(x-home[0]) + Math.abs(y-home[1]));
			min = Math.min(min, distance);
			return;
		}
		for(int i = 0; i<customer.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				int len = (Math.abs(x-customer[i][0]) + Math.abs(y-customer[i][1]));
				dfs(customer[i][0],customer[i][1],distance + len, n+1);
				visited[i] = false;
			}
			
		}
		
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
	
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc < T+1; tc ++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			customer = new int [n][2];
			corporation[0] = Integer.parseInt(st.nextToken());
			corporation[1] = Integer.parseInt(st.nextToken());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			visited = new boolean[n];
			for(int i = 0; i<n; i++) {
				customer[i][0] = Integer.parseInt(st.nextToken());
				customer[i][1] = Integer.parseInt(st.nextToken());		
				visited[i] = false;
			}
			min = Integer.MAX_VALUE;
			dfs(corporation[0],corporation[1],0,0);
			
			System.out.println("#" + tc + " " + min);
		}
	}
}
