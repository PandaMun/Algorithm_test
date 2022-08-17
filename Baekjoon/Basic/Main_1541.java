import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1541 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		StringTokenizer st1 = new StringTokenizer(br.readLine(), "-");
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i<st1.countTokens();) {
			StringTokenizer st2 = new StringTokenizer(st1.nextToken(), "+");
			int sum = 0;
			for(int j = 0; j<st2.countTokens();) {
				sum += Integer.parseInt(st2.nextToken());
			}
			list.add(sum);
		}
		int res = list.get(0);
		for(int i = 1; i<list.size();i++) {
			res -= list.get(i);
		}
		System.out.println(res);
	}
}
