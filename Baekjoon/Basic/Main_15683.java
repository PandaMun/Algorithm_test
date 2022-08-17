import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15683 {

	static int min = Integer.MAX_VALUE;
	static int x;
	static int y;

	public static int check(int[][] map) {
		int res = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == 0) {
					res += 1;
				}
			}
		}
		return res;
	}

	public static int[][] camera1(int[][] map, int n, int[] camera) {
		if (n == 1) { // 동
			for (int i = camera[1] + 1; i < y; i++) {
				if (map[camera[0]][i] == 0) {
					map[camera[0]][i] = -1;
				}
				if (map[camera[0]][i] == 6) {
					break;
				}
			}
		} else if (n == 3) { // 서쪽
			for (int i = camera[1] - 1; i >= 0; i--) {
				if (map[camera[0]][i] == 0) {
					map[camera[0]][i] = -1;
				}
				if (map[camera[0]][i] == 6) {
					break;
				}
			}

		} else if (n == 2) { // 남쪽
			for (int i = camera[0] + 1; i < x; i++) {
				if (map[i][camera[1]] == 0) {
					map[i][camera[1]] = -1;
				}
				if (map[i][camera[1]] == 6) {
					break;
				}
			}
		} else if (n == 0) { // 북쪽
			for (int i = camera[0] - 1; i >= 0; i--) {
				if (map[i][camera[1]] == 0) {
					map[i][camera[1]] = -1;
				}
				if (map[i][camera[1]] == 6) {
					break;
				}
			}
		}

		return map;
	}

	public static int[][] camera2(int[][] map, int n, int[] camera) {
		if (n == 0 || n == 2) {// 북,남
			camera1(map, 0, camera);
			camera1(map, 2, camera);
		}
		if (n == 1 || n == 3) {// 동,서
			camera1(map, 1, camera);
			camera1(map, 3, camera);
		}

		return map;

	}

	public static int[][] camera3(int[][] map, int n, int[] camera) {

		if (n == 0) {
			camera1(map, 0, camera);
			camera1(map, 1, camera);
		} else if (n == 1) {
			camera1(map, 1, camera);
			camera1(map, 2, camera);
		} else if (n == 2) {
			camera1(map, 2, camera);
			camera1(map, 3, camera);
		} else if (n == 3) {
			camera1(map, 3, camera);
			camera1(map, 0, camera);
		}

		return map;
	}

	public static int[][] camera4(int[][] map, int n, int[] camera) {

		if (n == 0) {
			camera1(map, 3, camera);
			camera1(map, 0, camera);
			camera1(map, 1, camera);
		} else if (n == 1) {
			camera1(map, 0, camera);
			camera1(map, 1, camera);
			camera1(map, 2, camera);
		} else if (n == 2) {
			camera1(map, 1, camera);
			camera1(map, 2, camera);
			camera1(map, 3, camera);
		} else if (n == 3) {
			camera1(map, 2, camera);
			camera1(map, 3, camera);
			camera1(map, 0, camera);
		}
		return map;
	}

	public static int[][] camera5(int[][] map, int n, int[] camera) {
		camera1(map, 0, camera);
		camera1(map, 1, camera);
		camera1(map, 2, camera);
		camera1(map, 3, camera);

		return map;
	}

	public static void dfs(int[][] maps, List<int[]> camera, int n) {

		if (camera.size() == n) {
			min = Math.min(min, check(maps));
		} else {
			int[] shoot = camera.get(n);
			if (shoot[2] == 1) {
				for (int i = 0; i < 4; i++) {
					int[][] map = init(maps);
					dfs(camera1(map, i, shoot), camera, n + 1);
				}

			} else if (shoot[2] == 2) {
				for (int i = 0; i < 4; i++) {
					int[][] map = init(maps);
					dfs(camera2(map, i, shoot), camera, n + 1);
				}

			} else if (shoot[2] == 3) {
				for (int i = 0; i < 4; i++) {
					int[][] map = init(maps);
					dfs(camera3(map, i, shoot), camera, n + 1);
				}

			} else if (shoot[2] == 4) {
				for (int i = 0; i < 4; i++) {
					int[][] map = init(maps);
					dfs(camera4(map, i, shoot), camera, n + 1);
				}
			} else if (shoot[2] == 5) {
				for (int i = 0; i < 4; i++) {
					int[][] map = init(maps);
					dfs(camera5(map, i, shoot), camera, n + 1);
				}
			}
		}
	}

	public static int[][] init(int[][] map) {
		int[][] maps = new int[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				maps[i][j] = map[i][j];
			}
		}
		return maps;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		List<int[]> camera = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		int[][] map = new int[x][y];
		for (int i = 0; i < x; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < y; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6) {
					camera.add(new int[] { i, j, map[i][j] });
				}
			}
		}
		dfs(map, camera, 0);

		System.out.println(min);
	}

}
