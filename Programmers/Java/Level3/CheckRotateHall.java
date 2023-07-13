package Level3;

public class CheckRotateHall {
    private int n, num = 0;
    private boolean finish = false;
    private int[] weak, dist, choice;
    private int[][] rotateWeak;

    public int solution(int n, int[] weak, int[] dist) {
        this.n = n;
        this.weak = weak;
        this.dist = dist;
        setWeak(); // 약한 지점을 회전하여 저장합니다.

        // 사용 가능한 친구의 수(dist.length)만큼 반복합니다.
        for (int i = 1; i <= dist.length; i++) {
            num = i; // 사용할 친구의 수를 설정합니다.
            choice = new int[num]; // 선택한 친구들을 저장하는 배열입니다.
            permutation(0, new boolean[dist.length]); // 가능한 친구 조합을 찾습니다.
            if (finish)
                break; // 유효한 해결책을 찾으면 반복문을 종료합니다.
        }

        return (finish) ? num : -1; // 친구의 수를 반환하거나 유효한 해결책을 찾지 못했을 경우 -1을 반환합니다.
    }

    // 가능한 친구 조합을 찾는 재귀 함수입니다.
    public void permutation(int depth, boolean[] visit) {
        if (finish)
            return; // 해결책을 찾았을 경우 재귀를 종료합니다.
        if (depth == num) {
            check(); // 선택한 친구 조합이 모든 약한 지점을 커버하는지 확인합니다.
            return;
        }

        for (int i = 0; i < dist.length; i++) {
            if (!visit[i]) {
                choice[depth] = dist[i]; // 해당 친구를 현재 조합에 추가합니다.
                visit[i] = true; // 해당 친구를 방문했음을 표시합니다.
                permutation(depth + 1, visit); // 다음 친구를 선택하기 위해 재귀 호출합니다.
                visit[i] = false; // 해당 친구 방문 표시를 초기화합니다.
            }
        }
    }

    // 선택한 친구 조합으로 모든 약한 지점을 커버하는지 확인하는 함수입니다.
    public void check() {
        for (int[] weak : rotateWeak) {
            int idx = 0, start = 0;
            boolean[] visit = new boolean[weak.length];

            while (idx != num) {
                int i = start;
                int value = choice[idx++];

                for (int j = start; j < weak.length; j++) {
                    if (!(weak[i] <= weak[j] && weak[j] <= weak[i] + value))
                        break;
                    visit[j] = true;
                    start++;
                }
            }

            if (isFinish(visit)) {
                finish = true;
                return;
            }
        }
    }

    // 모든 약한 지점이 커버되었는지 확인하는 함수입니다.
    public boolean isFinish(boolean[] visit) {
        for (boolean bool : visit) {
            if (!bool)
                return false;
        }
        return true;
    }

    // 약한 지점을 회전하여 저장하는 함수입니다.
    public void setWeak() {
        int len = weak.length;
        rotateWeak = new int[len][len];

        for (int i = 0; i < len; i++) {
            rotateWeak[i] = rotate(weak, i);
        }
    }

    // 약한 지점을 주어진 인덱스만큼 회전시키는 함수입니다.
    public int[] rotate(int[] weak, int idx) {
        int len = weak.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            if (i + idx < len)
                result[i] = weak[i + idx];
            else
                result[i] = weak[i + idx - len] + n;
        }
        return result;
    }
}