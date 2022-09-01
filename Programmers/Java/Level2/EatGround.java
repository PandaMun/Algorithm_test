package Level2;

public class EatGround {

    static int answer = 0;
    static int N;

    static int solution(int[][] land) {
        N = land.length;
        for (int i = 1; i < N; i++) {
            land[i][0] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][1] += Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][2] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][3]));
            land[i][3] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][2]));
        }
        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, land[N - 1][i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] land = new int[][] { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };
        System.out.println(solution(land));

    }
}
