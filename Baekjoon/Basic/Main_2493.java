import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2493 {
    public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		Stack<int[]> top = new Stack<>();
		int[] res = new int[n];
		res[0] = 0;
		top.push(new int[] { 100000001, 0 });

		for (int i = 0; i < n; i++) {
			int j = Integer.parseInt(st.nextToken());
			while (!top.isEmpty()) {
				if (top.peek()[0] < j) {
					top.pop();
				} else {
					System.out.print(top.peek()[1] + " ");
					top.push(new int[] { j, i + 1 });
					break;
				}
			}
		}

	}

}
