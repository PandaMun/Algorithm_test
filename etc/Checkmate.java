package com.ssafy.ws.step4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 체크메이트 판별하기
 */
public class Checkmate {
	public static void main(String[] args) throws Exception {
		int[] dx = { 0, 0, -1, -1, -1, 1, 1, 1 };
		int[] dy = { 1, -1, 1, 0, -1, 0, 1, -1 };
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			char[][] chess = new char[N][N];
			String[] location = (br.readLine()).split("");
			chess[Integer.parseInt(location[2]) - 1][Integer.parseInt(location[3]) - 1] = 'X';

			int result = 0;

			for (int i = 0; i < 8; i++) {
				int x = Integer.parseInt(location[0]) - 1;
				int y = Integer.parseInt(location[1]) - 1;
				while (true) {

					x += dx[i];
					y += dy[i];
					if (x >= 0 && y >= 0 && x < N && y < N) {
						if (chess[x][y] == 'X') {
							result = 1;
							break;
						}
					}
					else {
						break;
					}

				}
				if (result == 1) {
					break;
				}
			}
			System.out.println("#"+(test_case+1) + " " + result);

		}
	}
}