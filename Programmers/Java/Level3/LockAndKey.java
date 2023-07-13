package Level3;

public class LockAndKey {
    public boolean solution(int[][] key, int[][] lock) {

        int m = key.length; // 키의 길이
        int n = lock.length; // 자물쇠의 길이

        int len = n + m * 2 - 2; // 확장된 배열의 길이
        int[][] map = new int[len][len]; // 확장된 배열

        /* 확장된 배열에 자물쇠 표시 */
        for (int i = m - 1; i < m + n - 1; i++) {
            for (int j = m - 1; j < m + n - 1; j++) {
                map[i][j] = lock[i - (m - 1)][j - (m - 1)];
            }
        }

        /* 4번 회전 및 체크 */
        for (int i = 0; i < 4; i++) {
            if (check(map, key, n)) { // 자물쇠와 키가 맞는지 체크
                return true; // 맞다면 true 반환
            }
            rotate(key); // 시계 방향으로 90도 회전
        }

        return false; // 모든 경우에 맞지 않으면 false 반환
    }

    /* 키가 자물쇠에 맞는지 체크 */
    public static boolean check(int[][] map, int[][] key, int lockLen) {
        int keyLen = key.length;
        int mapLen = map.length;
        for (int i = 0; i < mapLen - keyLen + 1; i++) {
            for (int j = 0; j < mapLen - keyLen + 1; j++) {

                /* 키를 맵에 더함 */
                for (int k = 0; k < keyLen; k++) {
                    for (int l = 0; l < keyLen; l++) {
                        map[i + k][j + l] += key[k][l];
                    }
                }

                /* 자물쇠 부분이 전부 1인지 확인 */
                boolean flag = true;
                for (int k = keyLen - 1; k < keyLen + lockLen - 1; k++) {
                    for (int l = keyLen - 1; l < keyLen + lockLen - 1; l++) {
                        if (map[k][l] != 1) { // 1이 아니면 홈이 맞지 않음
                            flag = false;
                            break;
                        }
                    }
                    if (!flag) {
                        break;
                    }
                }

                if (flag) {
                    return true; // 전부 1이면 true 반환
                }

                /* 맵에서 키를 빼서 원래 상태로 복구 */
                for (int k = 0; k < keyLen; k++) {
                    for (int l = 0; l < keyLen; l++) {
                        map[i + k][j + l] -= key[k][l];
                    }
                }
            }
        }

        return false; // 맞지 않으면 false 반환
    }

    /* 키를 시계 방향으로 90도 회전 */
    public static void rotate(int[][] key) {
        int len = key.length;
        int[][] temp = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                temp[i][j] = key[len - j - 1][i];
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                key[i][j] = temp[i][j];
            }
        }
    }
}
