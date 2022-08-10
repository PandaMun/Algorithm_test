import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16935 {

	static int n;
	static int m;
	static int[][] array1;
	static int[][] array2;
	static int[][] array3;
	static int[][] array4;
	static int x;
	static int y;

	static int[][] cal1(int[][] arr) {
		int[][] array = new int[n][m];
		int cnt = 0;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < m; j++) {
				array[cnt][j] = arr[i][j];
			}
			cnt += 1;
		}

		return array;

	}

	static int[][] cal2(int[][] arr) {
		int[][] array = new int[n][m];
		for (int i = 0; i < n; i++) {
			int cnt = 0;
			for (int j = m - 1; j >= 0; j--) {
				array[i][cnt] = arr[i][j];
				cnt += 1;
			}
		}

		return array;
	}

	static int[][] cal3(int[][] arr) {
		int[][] array = new int[m][n];
		for (int i = 0; i < m; i++) {
			int cnt = n - 1;
			for (int j = 0; j < n; j++) {
				array[i][j] = arr[cnt][i];
				cnt -= 1;
			}
		}

		return array;
	}

	static int[][] cal4(int[][] arr) {
		int[][] array = new int[m][n];
		int cnt = m - 1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				array[i][j] = arr[j][cnt];
			}
			cnt --;
		}

		return array;

	}

	static void divArray(int[][] arr) {
		array1 = new int[n / 2][m / 2];
		array2 = new int[n / 2][m / 2];
		array3 = new int[n / 2][m / 2];
		array4 = new int[n / 2][m / 2];
		x = 0;
		for (int i = 0; i < n / 2; i++) {
			y = 0;
			for (int j = 0; j < m / 2; j++) {
				array1[x][y] = arr[i][j];
				y += 1;
			}
			x += 1;
		}
		x = 0;
		for (int i = 0; i < n / 2; i++) {
			y = 0;
			for (int j = m / 2; j < m; j++) {
				array2[x][y] = arr[i][j];
				y += 1;
			}
			x += 1;
		}
		x = 0;
		for (int i = n / 2; i < n; i++) {
			y = 0;
			for (int j = 0; j < m / 2; j++) {
				array4[x][y] = arr[i][j];
				y += 1;
			}
			x += 1;
		}
		x = 0;
		for (int i = n / 2; i < n; i++) {
			y = 0;
			for (int j = m / 2; j < m; j++) {
				array3[x][y] = arr[i][j];
				y += 1;
			}
			x += 1;
		}
	}

	static int[][] cal5(int[][] arr) {
		int[][] array = new int[n][m];
		x = 0;
		for (int i = 0; i < n / 2; i++) {
			y = 0;
			for (int j = 0; j < m / 2; j++) {
				array[i][j] = array4[x][y];
				y += 1;
			}
			x += 1;
		}
		x = 0;
		for (int i = 0; i < n / 2; i++) {
			y = 0;
			for (int j = m / 2; j < m; j++) {
				array[i][j] = array1[x][y];
				y += 1;
			}
			x += 1;
		}
		x = 0;
		for (int i = n / 2; i < n; i++) {
			y = 0;
			for (int j = 0; j < m / 2; j++) {
				array[i][j] = array3[x][y];
				y += 1;
			}
			x += 1;
		}
		x = 0;
		for (int i = n / 2; i < n; i++) {
			y = 0;
			for (int j = m / 2; j < m; j++) {
				array[i][j] = array2[x][y];
				y += 1;
			}
			x += 1;
		}

		return array;
	}

	static int[][] cal6(int[][] arr) {
		int[][] array = new int[n][m];
		x = 0;
		for (int i = 0; i < n / 2; i++) {
			y = 0;
			for (int j = 0; j < m / 2; j++) {
				array[i][j] = array2[x][y];
				y += 1;
			}
			x += 1;
		}
		x = 0;
		for (int i = 0; i < n / 2; i++) {
			y = 0;
			for (int j = m / 2; j < m; j++) {
				array[i][j] = array3[x][y];
				y += 1;
			}
			x += 1;
		}
		x = 0;
		for (int i = n / 2; i < n; i++) {
			y = 0;
			for (int j = 0; j < m / 2; j++) {
				array[i][j] = array1[x][y];
				y += 1;
			}
			x += 1;
		}
		x = 0;
		for (int i = n / 2; i < n; i++) {
			y = 0;
			for (int j = m / 2; j < m; j++) {
				array[i][j] = array4[x][y];
				y += 1;
			}
			x += 1;
		}

		return array;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < r; i++) {
			int command = Integer.parseInt(st.nextToken());

			if (command == 1) {
				arr = cal1(arr);
			} else if (command == 2) {
				arr = cal2(arr);
			} else if (command == 3) {
				arr = cal3(arr);
				int tmp = n;
				n = m;
				m = tmp;
			} else if (command == 4) {
				arr = cal4(arr);
				int tmp = n;
				n = m;
				m = tmp;
			} else if (command == 5) {
				divArray(arr);
				arr = cal5(arr);
			} else if (command == 6) {
				divArray(arr);
				arr = cal6(arr);
			}

		}

		// 출력
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		

	}
}
