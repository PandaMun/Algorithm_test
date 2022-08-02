import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1208 {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		for(int test_case = 1; test_case < 11; test_case++) {
			int dumpCount = Integer.parseInt(br.readLine());
			int[] map = new int[100];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<100; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}
			for(int i = 0; i< dumpCount; i++) {
				Arrays.sort(map);
				map[99] -= 1;
				map[0] += 1;
			}
			Arrays.sort(map);
						
			System.out.println("#" + test_case + " " +(map[99] - map[0]));
		}
	
	}
}