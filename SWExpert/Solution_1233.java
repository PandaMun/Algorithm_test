import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1233{

	static boolean check(String calc) {
		if (calc.equals("+") || calc.equals("*") || calc.equals("-") || calc.equals("/")) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		boolean res;

		for (int tc = 1; tc < 11; tc++) {
			res = true;
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				String value = st.nextToken();
				if (st.hasMoreTokens()) {
					if (check(value)) {
						res = false;
					}
				}
				else {
					if (!check(value)) {
						res = false;
					}
				}
			}
			System.out.print("#" + tc + " ");
			if (res) {
				System.out.print(1);
			} else {
				System.out.print(0);
			}
			System.out.println();

		}
	}
}
