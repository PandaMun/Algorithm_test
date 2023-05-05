package Level3;

public class VanishingFoothold {

    public static class Result {
        boolean win;
        int count;

        public Result(boolean win, int count) {
            this.win = win;
            this.count = count;
        }
    }

    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static Result dfs(int[][] board, int ax, int ay, int bx, int by, int order, int count) {

        // 현재 발판이 사라졌는데 내차례야... 그럼 패배를 리턴하고 현재까지의 이동횟수를 리턴할것
        if ((board[ax][ay] == 0 && order % 2 == 0) || (board[bx][by] == 0 && order % 2 == 1)) {
            return new Result(false, count);
        }

        boolean win = false;
        int max = board.length * board[0].length;
        int min = count;
        if (order % 2 == 0) {
            for (int i = 0; i < 4; i++) {
                int nx = ax + dx[i];
                int ny = ay + dy[i];
                if (nx >= 0 && nx < board.length && ny < board[0].length && ny >= 0 && board[nx][ny] != 0) {
                    board[ax][ay] = 0;
                    // dfs를 통한 결과
                    Result result = dfs(board, nx, ny, bx, by, order + 1, count + 1);
                    // 결과를
                    if (result.win == false) {
                        win = true;
                    }
                    if (!result.win) { // 패배면
                        min = Math.max(min, result.count); // 최소 경로
                    } else {
                        max = Math.min(max, result.count);
                    }
                    board[ax][ay] = 1;
                }
            }

        } else if (order % 2 == 1) {
            for (int i = 0; i < 4; i++) {
                int nx = bx + dx[i];
                int ny = by + dy[i];
                if (nx >= 0 && nx < board.length && ny < board[0].length && ny >= 0 && board[nx][ny] != 0) {
                    board[bx][by] = 0;
                    Result result = dfs(board, ax, ay, nx, ny, order + 1, count + 1);
                    if (result.win == false) {
                        win = true;
                    }
                    if (!result.win) { // 졌다면
                        min = Math.max(min, result.count);
                    } else {
                        max = Math.min(max, result.count);
                    }
                    board[bx][by] = 1;
                }
            }
        }
        return new Result(win, win ? min : max); // 이기면 최소값 지면 최댓값
    }

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        Result result = dfs(board, aloc[0], aloc[1], bloc[0], bloc[1], 0, 0);
        return result.count;
    }
}
