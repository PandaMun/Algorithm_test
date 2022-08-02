import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2447 {
	
	static StringBuilder blank(int count) {
		StringBuilder sb = new StringBuilder("");
		for(int i = 0; i < count; i++) {
			sb.append(" ");
		}
		return sb;
	}
	
	static int cnt = 1;
	
	static void CountingStar(int start, int end, String [] star) {
		if(start == end) {
			for(String res : star) {
				System.out.println(res);
			}
			return;
		}
		String [] newStar = new String[star.length * 3];
		int j = 0;
		for(int i = 0; i<newStar.length; i++) {
			j = i % start;
			if(i >= (newStar.length/3) && i< ((newStar.length/3)*2)) {
				newStar[i] = star[j] + (blank(start)) + star[j];
			}
			else {
			newStar[i] =  (star[j] + star[j] + star[j]);
			}
			
		}
		CountingStar(start * 3, end, newStar);
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String [] star = {"***","* *","***"};
		CountingStar(3,N,star);
	}
}