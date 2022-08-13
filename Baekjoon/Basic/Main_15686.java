import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15686{
	
	static int n;
	static int m;
	static int least_distance;
	static int [][] chicken;
	static int [][] house;
	static int[][] combination_chicken;
	static int index;
	static void combination(int count,int level,int [][] combination_chicken) {
		if(count == m) {
			int least = 0;
			for(int i = 0; i<house.length; i++) {
				int house_x = house[i][0] + 1;
				int house_y = house[i][1] + 1;
				int min = Integer.MAX_VALUE;
				for(int j = 0; j<combination_chicken.length; j++) {
					int chicken_x = combination_chicken[j][0] + 1;
					int chicken_y = combination_chicken[j][1] + 1;
					min = Math.min(min, (Math.abs(chicken_y - house_y) + Math.abs(chicken_x - house_x))); 
				}
				least += min;
			}
			least_distance = Math.min(least, least_distance); 
			return;
		}
		if(level >= chicken.length) {
			return;
		}
		
		combination(count,level+1,combination_chicken);
		
		combination_chicken[count] = chicken[level];
		
		combination(count+1,level+1,combination_chicken); 
		
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int [][] map = new int[n][n];
		List<int[]> chicken_check = new ArrayList<>();
		List<int[]> house_check = new ArrayList<>();
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					house_check.add(new int[] {i,j});
				}
				if(map[i][j] == 2) {
					chicken_check.add(new int[] {i,j});
				}
				
			}
		}
		
		chicken = chicken_check.toArray(new int[chicken_check.size()][2]);
		house = house_check.toArray(new int[house_check.size()][2]);
		least_distance = Integer.MAX_VALUE;
		combination_chicken = new int[m][2];
		index = 0;
		combination(0,0,combination_chicken);
		System.out.println(least_distance);
		
	}
}
