import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_11660 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int sum[][] = new int[n][n+1];
		for(int i = 0; i< n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j< n; j++) {
				if(j == 0) {
					sum[i][j] = 0;
					sum[i][j+1] = Integer.parseInt(st.nextToken());
				}else {
					sum[i][j+1] = sum[i][j] + Integer.parseInt(st.nextToken());
				}
			}
		}
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken())-1;
			int y1 = Integer.parseInt(st.nextToken())-1;
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int res = 0;
			for(int j = x1; j < x2; j++) {
				res += sum[j][y2] - sum[j][y1];
			}
			bw.write(String.valueOf(res) + "\n");
		}
		bw.flush();
	}
}