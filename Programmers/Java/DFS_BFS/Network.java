package DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Network {
    static int [] visited;
	
	public static void dfs(int [][] computers, int n) {
		visited[n] = 1;
		for(int i = 0; i<computers[n].length; i++) {
			
			if(visited[i] != 1 && computers[n][i] == 1) {
				dfs(computers,i);
			}
		}
	}
	public static int solution(int n, int[][] computers) {
    
        visited = new int[n];
        int answer = 0;
        for(int i = 0; i<n; i++) {
        	if(visited[i] != 1) {
        		dfs(computers,i);
        		answer += 1;
        	}
        }
        return answer;
    }
    public static void main(String[] args) {
        int n = 3;
        int [][] computers = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(solution(n,computers));

    }
}
