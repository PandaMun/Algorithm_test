import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bulk {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int [] weight = new int[N];
		int [] height = new int[N];
		int [] answer = new int[N];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			height[i] = Integer.parseInt(st.nextToken());
			
		}
		for(int i = 0; i<N; i++) {
			int grade = 1;
			for(int j = 0; j<N; j++) {
				if (weight[i] < weight[j] && height[i] < height[j]) {
					grade += 1;
				}
			answer[i] = grade;
			}
		}
		for(int i = 0; i<N; i++) {
			bw.write(String.valueOf(answer[i]) + " ");
		}
		
		bw.flush();
	}
	
}