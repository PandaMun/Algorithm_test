import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2563{

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
	
		int count = Integer.parseInt(br.readLine());
		
		int [][] white = new int[100][100];
		
		for(int i = 0; i< 100; i++) {
			for(int j = 0; j < 100; j++) {
				white[i][j] = 0;
			}
		}
		for(int i = 0; i<count; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
		
			for(int j = y; j < 10 + y; j++) {
				for(int k = x; k < 10 + x; k++) {
					white[j][k] = 1;
				}
			}
		}
		int res = 0;
		for(int i = 0; i< 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(white[i][j] == 1) {
					res += 1;
				}
			}
		}
		System.out.println(res);
	}
}
