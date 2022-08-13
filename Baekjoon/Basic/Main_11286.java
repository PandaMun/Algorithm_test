import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_11286 {
	
	public static class Value implements Comparable<Value>{
		public int number;
		public int sign;
		
		public Value(int number, int sign) {
			this.number = number;
			this.sign = sign;
		}

		@Override
		public int compareTo(Value o) {
			// TODO Auto-generated method stub
			if(this.number == o.number) {
				return this.sign > o.sign ? 1 : -1;
			}
			return (this.number < o.number)? 1: -1;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		PriorityQueue<Value> queue = new PriorityQueue<>(Collections.reverseOrder());
		
		int count = Integer.parseInt(br.readLine());
		for(int i = 0 ; i< count; i++) {
			int input = Integer.parseInt(br.readLine());
			if(input == 0) {
				if (!queue.isEmpty()) {
					Value pop = queue.poll();
					if(pop.sign == 1) {
						System.out.println(pop.number * -1);
					}else {
						System.out.println(pop.number);
					}
				}else {
					System.out.println(0);
				}
				
			}
			else {
				if(input>=1) {
					queue.offer(new Value(input,0));
				}else if(input < 0) {
					queue.offer(new Value(input * -1 ,1));
				}
			}
			
			
		}
	}
}
