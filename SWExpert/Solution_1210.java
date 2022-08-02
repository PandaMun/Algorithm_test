import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1210 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int [] answer = new int[10];
		for(int test_case = 0; test_case < 10; test_case++) {
			int T = Integer.parseInt(br.readLine());
			int x = 0;
			int [][] Ladder = new int[100][100];
			for(int i = 0; i< 100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<100; j++) {
					Ladder[i][j] = Integer.parseInt(st.nextToken());
					if(i==99 && Ladder[i][j] == 2) {
						x = j;
					}
				}
			}// 입력
			for(int y = 99; y >= 0; y--) {
				if(x < 99 && Ladder[y][x+1] == 1) {
					while(true) {
						if(x == 99 || Ladder[y][x+1] == 0) {
							break;
						}else {
							x += 1;
						}
					}
				}
				else if(0 < x && Ladder[y][x-1] == 1) {
					while(true) {
						if(x == 0 || Ladder[y][x-1] == 0) {
							break;
						}else {
							x -= 1;
						}
					}
				}
			}
			answer[T-1] = x;
		}
		for(int i=0; i<10; i++) {
			System.out.println("#" + (i+1) + " " + answer[i]);
		}
	}
}