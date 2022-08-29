import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1767 {

	static List<Integer> answer = new ArrayList<>();
	static List<int[]> core;
	static int n;
	static int max_count;
	static int count = 0;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static boolean LineCheck(int x, int y, int d, int[][] chip) {
		if (d == 0) {
			for (int i = x - 1; i >= 0; i--) {
				if (chip[i][y] == 1) {
					return false;
				}
			}
			return true;
		}
		if (d == 1) {
			for (int i = y + 1; i < n; i++) {
				if (chip[x][i] == 1) {
					return false;
				}
			}
			return true;
		}
		if (d == 2) {
			for (int i = x + 1; i < n; i++) {
				if (chip[i][y] == 1) {
					return false;
				}
			}
			return true;
		}
		if (d == 3) {
			for (int i = y - 1; i >= 0; i--) {
				if (chip[x][i] == 1) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public static void dfs(int stack, int count, int sum, int[][] chips) {
		int[][] chip = new int[n][n];
		//초기화
		for (int a = 0; a < n; a++) {
			for (int b = 0; b < n; b++) {
				chip[a][b] = chips[a][b];
			}
		}

		if (stack == core.size()) {
			if (max_count < count) {
				max_count = count;
				answer = new ArrayList<>();
				answer.add(sum);
			} else if (max_count == count) {
				answer.add(sum);
			}
			return;
		}
		// 연결이 없는 경우
		dfs(stack + 1, count, sum, chip);

		// 사방중 한곳을 연결하는 경우
		for (int i = 0; i < 4; i++) {
			if (LineCheck(core.get(stack)[0], core.get(stack)[1], i, chips)) {
				
				if (i == 0) {
					int cnt = 0;
					for (int x = core.get(stack)[0] - 1; x >= 0; x--) {
						chip[x][core.get(stack)[1]] = 1;
						cnt += 1;
					}
					dfs(stack + 1, count + 1, (sum + cnt), chip);

				}
				
				else if (i == 1) {
					int cnt = 0;
					for (int y = core.get(stack)[1] + 1; y < n; y++) {
						chip[core.get(stack)[0]][y] = 1;
						cnt += 1;
					}
					dfs(stack + 1, count + 1, (sum + cnt), chip);
				}
				
				else if (i == 2) {
					int cnt = 0;
					for (int x = core.get(stack)[0] + 1; x < n; x++) {
						chip[x][core.get(stack)[1]] = 1;
						cnt += 1;
					}
					dfs(stack + 1, count + 1, (sum + cnt), chip);
				}

				else if (i == 3) {
					int cnt = 0;
					for (int y = core.get(stack)[1] - 1; y >= 0; y--) {
						chip[core.get(stack)[0]][y] = 1;
						cnt += 1;
					}
					dfs(stack + 1, count + 1, (sum + cnt), chip);
				}
				
				//초기화
				for (int a = 0; a < n; a++) {
					for (int b = 0; b < n; b++) {
						chip[a][b] = chips[a][b];
					}
				}	
			}
			
			
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T + 1; tc++) {
			n = Integer.parseInt(br.readLine());
			int[][] chip = new int[n][n];
			core = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					chip[i][j] = Integer.parseInt(st.nextToken());
					if (chip[i][j] == 1) {
						if (i != 0 && i != n - 1 && j != 0 && j != n - 1) {
							core.add(new int[] { i, j });
						} else {
							count += 1;
						}
					}
				}
			}
			max_count = 0;
			dfs(0, 0, 0, chip);
			int res = Integer.MAX_VALUE;
			for (int i = 0; i < answer.size(); i++) {
				res = Math.min(res, answer.get(i));
			}
			System.out.println("#" + tc + " " + res);

		}

	}
}
