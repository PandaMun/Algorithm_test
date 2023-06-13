package Level2;

public class RotateMatrix {

    public int[] solution(int rows, int columns, int[][] queries) {

        int[] answer = new int[queries.length];
        int[][] matrix = new int[rows][columns];
        int initNum = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = initNum;
                initNum++;
            }
        }

        int index = 0;

        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;
            int firstNum = matrix[x1][y2];
            int min = firstNum;

            // 숫자를 우로 이동 (상단)
            for (int j = y2 - 1; j >= y1; j--) {
                min = Math.min(min, matrix[x1][j]);
                matrix[x1][j + 1] = matrix[x1][j];
            }

            // 숫자를 위로 이동 (좌측)
            for (int j = x1 + 1; j <= x2; j++) {
                min = Math.min(min, matrix[j][y1]);
                matrix[j - 1][y1] = matrix[j][y1];
            }

            // 숫자를 좌로 이동 (하단)
            for (int j = y1 + 1; j <= y2; j++) {
                min = Math.min(min, matrix[x2][j]);
                matrix[x2][j - 1] = matrix[x2][j];
            }

            // 숫자를 아래로 이동 (우측)
            for (int j = x2 - 1; j >= x1; j--) {
                min = Math.min(min, matrix[j][y2]);
                matrix[j + 1][y2] = matrix[j][y2];
            }

            matrix[x1 + 1][y2] = firstNum;
            answer[index] = min;
            index++;

        }

        return answer;
    }

}
