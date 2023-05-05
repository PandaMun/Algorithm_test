package Level3;

public class UndestoriedBuilding {
    // public int solution(int[][] board, int[][] skill) {
    // int answer = 0;

    // for (int i = 0; i < skill.length; i++) {
    // if (skill[i][0] == 1) { //attack
    // for (int j = skill[i][1]; j < skill[i][3]; j++) {
    // for (int k = skill[i][2]; k < skill[i][4]; k++) {
    // board[j][j] -= skill[i][5];
    // }
    // }
    // } else { //heal
    // for (int j = skill[i][1]; j < skill[i][3]; j++) {
    // for (int k = skill[i][2]; k < skill[i][4]; k++) {
    // board[j][j] += skill[i][5];
    // }
    // }
    // }
    // }
    // for (int i = 0; i < board.length; i++) {
    // for (int j = 0; j < board[i].length; j++) {
    // if (board[i][j] > 0) {
    // answer += 1;
    // }
    // }
    // }
    // return answer;
    // }

    public int solution(int[][] board, int[][] skill) {

        int answer = 0;
        int N = board.length;
        int M = board[0].length;

        int[][] sum = new int[N + 1][M + 1];

        for (int i = 0; i < skill.length; i++) { // 누적합을 위해 값을 추가

            sum[skill[i][1]][skill[i][2]] += skill[i][5];
            sum[skill[i][1]][skill[i][4] + 1] += skill[i][5] * -1;
            sum[skill[i][3] + 1][skill[i][2]] += skill[i][5] * -1;
            sum[skill[i][3] + 1][skill[i][4] + 1] += skill[i][5];

        }

        // 가로 누적합
        for (int i = 0; i < N + 1; i++) {
            int prefix = 0;
            for (int j = 0; j < M + 1; j++) {
                prefix += sum[i][j];
                sum[i][j] = prefix;
            }
        }
        // 세로 누적합
        for (int i = 0; i < M; i++) {
            int prefix = 0;
            for (int j = 0; j < N; j++) {
                prefix += sum[j][i];
                sum[j][i] = prefix;
            }
        }
        // 기존값과 누적합을 합친 값이 0 이상이면 파괴되지 않은 건물 !!!
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (sum[i][j] + board[i][j] > 0) {
                    answer += 1;
                }
            }
        }

        return answer;
    }

}
