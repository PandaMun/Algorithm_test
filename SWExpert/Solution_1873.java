import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873 {

	static char[][] Up(char[][] map, int h, int w) {
		if (x > 0) {
			if (map[x - 1][y] == '.') {
				map[x - 1][y] = '^';
				map[x][y] = '.';
				x = x - 1;
			} else {
				map[x][y] = '^';
			}
		} else {
			map[x][y] = '^';
		}
		dir = 0;
		return map;
	}

	static char[][] Down(char[][] map, int h, int w) {
		if (x < h - 1) {
			if (map[x + 1][y] == '.') {
				map[x + 1][y] = 'v';
				map[x][y] = '.';
				x = x + 1;
			} else {
				map[x][y] = 'v';
			}
		} else {
			map[x][y] = 'v';
		}
		dir = 1;
		return map;
	}

	static char[][] Left(char[][] map, int h, int w) {
		if (y > 0) {
			if (map[x][y - 1] == '.') {
				map[x][y - 1] = '<';
				map[x][y] = '.';
				y = y - 1;
			} else {
				map[x][y] = '<';
			}
		} else {
			map[x][y] = '<';
		}
		dir = 2;
		return map;
	}

	static char[][] Right(char[][] map, int h, int w) {
		if (y < w - 1) {
			if (map[x][y + 1] == '.') {
				map[x][y + 1] = '>';
				map[x][y] = '.';
				y = y + 1;
			} else {
				map[x][y] = '>';
			}
		} else {
			map[x][y] = '>';
		}
		dir = 3;
		return map;
	}

	static char[][] Shoot(char[][] map, int h, int w) {

		if (dir == 0) {
			for (int i = 1; i < x + 1; i++) {
				if (map[x - i][y] == '*') {
					map[x - i][y] = '.';
					return map;
				} else if (map[x - i][y] == '#') {
					return map;
				}
			}
		} else if (dir == 1) {
			for (int i = 1; i < h - x; i++) {
				if (map[x + i][y] == '*') {
					map[x + i][y] = '.';
					return map;
				} else if (map[x + i][y] == '#') {
					return map;
				}
			}
		} else if (dir == 2) {
			for (int i = 1; i < y + 1; i++) {
				if (map[x][y - i] == '*') {
					map[x][y - i] = '.';
					return map;
				}else if (map[x][y - i] == '#') {
					return map;
				}
			}
		} else if (dir == 3) {
			for (int i = 1; i < w - y; i++) {
				if (map[x][y + i] == '*') {
					map[x][y + i] = '.';
					return map;
				} else if (map[x][y + i] == '#') {
					return map;
				}
			}
		}
		return map;
	}

	static int x = 0;
	static int y = 0;
	static int dir = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case < t + 1; test_case++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			char[][] map = new char[h][w];
			for (int i = 0; i < h; i++) {
				String line = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = line.charAt(j);
					if (map[i][j] == '^') {
						x = i;
						y = j;
						dir = 0;
					} else if (map[i][j] == 'v') {
						x = i;
						y = j;
						dir = 1;
					} else if (map[i][j] == '<') {
						x = i;
						y = j;
						dir = 2;
					} else if (map[i][j] == '>') {
						x = i;
						y = j;
						dir = 3;
					}
				}
			} // 여기까지 input
			int commandCnt = Integer.parseInt(br.readLine());
			String commandLine = br.readLine();
			for (int i = 0; i < commandCnt; i++) {
				char command = commandLine.charAt(i);
				if (command == 'U') {
					map = Up(map, h, w);
				} else if (command == 'D') {
					map = Down(map, h, w);
				} else if (command == 'L') {
					map = Left(map, h, w);
				} else if (command == 'R') {
					map = Right(map, h, w);
				} else if (command == 'S') {
					map = Shoot(map, h, w);
				}
			}
			System.out.print("#" + test_case + " ");
			for (int k = 0; k < h; k++) {
				for (int l = 0; l < w; l++) {
					System.out.print(map[k][l]);
				}
				System.out.println();
			}

		}

	}

}