import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16926 {

	static int tmp1;
	static int tmp2;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int[][] check = new int[n + 2][m + 2];
		int[][] array = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < n + 2; i++) {
			for (int j = 0; j < m + 2; j++) {
				if (i == 0 || j == 0 || i == n + 1 || j == m + 1) {
					check[i][j] = 1;
				} else {
					check[i][j] = 0;
				}
			}

		}
		int range = Integer.min(n / 2, m / 2);
		for (int count = 0; count < r; count++) {
			for (int i = 0; i < n + 2; i++) {
				for (int j = 0; j < m + 2; j++) {
					if (i == 0 || j == 0 || i == n + 1 || j == m + 1) {
						check[i][j] = 1;
					} else {
						check[i][j] = 0;
					}
				}
			}

			for (int i = 0; i < range; i++) {
				int x = i;
				int y = i;
				tmp1 = array[x][y];
				while (true) {
					if (check[x + 1 + 1][y + 1] == 0) {
						tmp2 = array[x + 1][y];
						array[x + 1][y] = tmp1;
						tmp1 = tmp2;
						check[x + 2][y + 1] = 1;
						x++;
					} else {
						tmp1 = tmp2;
						break;
					}
				}

				while (true) {
					if (check[x + 1][y + 1 + 1] == 0) {
						tmp2 = array[x][y + 1];
						array[x][y + 1] = tmp1;
						tmp1 = tmp2;
						check[x + 1][y + 2] = 1;
						y++;
					} else {
						tmp1 = tmp2;
						break;
					}
				}

				while (true) {
					if (check[x + 1 - 1][y + 1] == 0) {
						tmp2 = array[x - 1][y];
						array[x - 1][y] = tmp1;
						tmp1 = tmp2;
						check[x][y + 1] = 1;
						x--;
					} else {
						break;
					}
				}

				while (true) {
					if (check[x + 1][y + 1 - 1] == 0) {
						tmp2 = array[x][y - 1];
						array[x][y - 1] = tmp1;
						tmp1 = tmp2;
						check[x + 1][y] = 1;
						y--;
					} else {
						break;
					}
				}

			}
		}
		for (int a = 0; a < n; a++) {
			for (int b = 0; b < m; b++) {
				System.out.print(array[a][b] + " ");
			}
			System.out.println();
		}

	}
}
