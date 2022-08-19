import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697{

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 0;
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Queue <int[]> queue = new LinkedList<>();
		queue.offer(new int[] {n,0});
		boolean []  visited = new boolean[100001];
		while(!queue.isEmpty()) {
			int [] arr = queue.poll();
			if(arr[0] == k) {
				answer = arr[1];
				break;
			}
			visited[arr[0]] = true;
			if(0<=arr[0]*2 && arr[0]*2 <= 100000 && !visited[arr[0]*2]) {
			queue.offer(new int[] {arr[0]*2, arr[1]+1});
			}
			if(0<=arr[0]+1 && arr[0]+1 <= 100000 &&!visited[arr[0]+1]) {
			queue.offer(new int[] {arr[0]+1, arr[1]+1});
			}
			if(0<=arr[0]-1 && arr[0]-1 <= 100000 &&!visited[arr[0]-1]) {
			queue.offer(new int[] {arr[0]-1, arr[1]+1});
		}
		}
		System.out.println(answer);
		
		
	}
}
