import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3234{

	static int answer;

	public static void dfs(int n, int[] weights, int left, int right, int count, boolean[] visited) {
		if (count == n) {
			if (right <= left) {
				answer += 1;
			}
			return;
		}
		for (int i = 0; i < n; i++) {

			if (!visited[i]) {
				if (right > left) {
					return;
				}
				visited[i] = true;
				dfs(n, weights, left + weights[i], right, count + 1, visited);

				dfs(n, weights, left, right + weights[i], count + 1, visited);
				visited[i] = false;

			}
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] weights = new int[n];
			for (int i = 0; i < n; i++) {
				weights[i] = Integer.parseInt(st.nextToken());
			}
			boolean[] visited = new boolean[n];
			answer = 0;
			dfs(n, weights, 0, 0, 0, visited);

			System.out.println("#" + tc + " " + answer);

		}

	}
}

