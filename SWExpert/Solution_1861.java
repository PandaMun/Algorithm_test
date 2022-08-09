import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1861 {

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T + 1; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] matrix = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int res[] = new int[] { 0, 0 };
			int value;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					List<int[]> arr = new ArrayList<>();
					value = 1;
					arr.add(new int[] { i, j });
					while (!(arr.isEmpty())) {
						int x = arr.get(0)[0];
						int y = arr.get(0)[1];
						arr.remove(0);
						for (int k = 0; k < 4; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];

							if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
								if (matrix[nx][ny] - matrix[x][y] == 1) {

									arr.add(new int[] { nx, ny });
									value += 1;
								}
							}
						}
					}
					if (res[1] < value) {
						res[1] = value;
						res[0] = matrix[i][j];
					}
					if (res[1] == value) {
						if (res[0] > matrix[i][j]) {
							res[0] = matrix[i][j];
						}
					}
				}

			}
			System.out.println("#" + tc + " " + res[0] + " " + res[1]);

		}

	}
}
