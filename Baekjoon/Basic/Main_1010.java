import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1010 {
	
	static double fac(int n) {
		double result = 1;
		while(n != 0) {
			result *= n;
			n -= 1;
		}
		return result;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int t = Integer.parseInt(br.readLine());
		for(int tc = 0; tc <t; tc++) {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		System.out.println(Math.round(fac(m) / ( fac(m-n) * fac(n) )));
		
		
		}
		
	}
}
