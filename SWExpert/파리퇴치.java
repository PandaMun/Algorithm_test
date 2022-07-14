import java.util.Scanner;

class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{   
			int n = sc.nextInt();
			int m = sc.nextInt();

			int [][] matrix = new int[n][n];
			for(int i = 0; i< n; i++){
				for(int j =0; j < n; j++){
					matrix[i][j] = sc.nextInt();
				}
			}
			int answer = 0;
			for(int i = 0; i<n-m+1; i++){
				for (int j = 0; j <n-m+1; j++){
					int result = 0;
					for (int k = i; k<i+m; k++){
						for (int l = j; l<j+m; l++){
							result += matrix[k][l];

						}
					}
					if (result > answer){
						answer = result;
					}
				}
			}
			System.out.println("#"+Integer.toString(test_case)+ " " + Integer.toString(answer));
			}
		}
	}

