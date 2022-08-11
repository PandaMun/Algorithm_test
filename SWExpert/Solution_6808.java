import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_6808 {

	
	static int[] card;
	static boolean[] visited;
	static int result;
	
	static void permutation(List<Integer> arr, int res[], boolean[] visited, int count) {
		if (count == 9) {
			int score1 = 0;
			int score2 = 0;
			for(int i = 0; i < 9; i++) {
				if(card[i] < res[i]) {
					score1 += res[i] + card[i];
				}
				else if(card[i] > res[i]) {
					score2 += res[i] + card[i];
				}
			}
			if (score1 > score2) {
				result += 1;
			}
						
		} else {
			for (int i = 0; i < 9; i++) {
				if (!visited[i]) {
					visited[i] = true;
					res[count] = arr.get(i);
					permutation(arr, res, visited, count + 1);
					visited[i] = false;
				}
			}
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T + 1; tc++) {
			result = 0;
			card = new int[9];
			List<Integer> arr = new ArrayList<>();
			for(int i = 1; i< 19; i++) {
				arr.add(i);
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				card[i] = Integer.parseInt(st.nextToken());
				arr.remove((Object)card[i]);
			}
			int [] res = new int[9];
			visited = new boolean[9];
			permutation(arr,res,visited,0);
			System.out.println("#" + tc + " " + (362880-result) + " " + result);

		}
	}

}
