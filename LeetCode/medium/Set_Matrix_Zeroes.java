class Solution {
    public void setZeroes(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        List<int[]> detect = new ArrayList<>(); // 저장할 리스트

        for(int i = 0; i< n; i++){
            for(int j = 0; j<m; j++){
                if(matrix[i][j] == 0){
                    detect.add(new int[]{i,j}); // 리스트에 위치 저장
                }
            }
        }
        for(int i = 0; i<detect.size(); i++){
            for(int j = 0; j<n; j++){
                matrix[j][detect.get(i)[1]] = 0; 
            }
            for(int j = 0; j<m; j++){
                matrix[detect.get(i)[0]][j] = 0;
            }
        }
    }
}