import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1486 {

    static int T, N, B, min;
    static int[] staffSrc, staffTgt;
    static int staffTgtCnt; // 1, 2, 3,

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            staffSrc = new int[N]; // 직원의 키
            staffTgt = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                staffSrc[i] = Integer.parseInt(st.nextToken());
            }

            // 풀이
            min = Integer.MAX_VALUE;
            // 처음에는 1명만으로 구성된 경우를 따지고, 2명으로 구성된 경우를 따지고... N 경우를 따지고
            for (int i = 1; i <= N; i++) {
                staffTgtCnt = i;
                comb(0, 0); // srcIdx, tgtIdx
            }

            System.out.println("#" + t + " " + min);
        }

    }

    static void comb(int srcIdx, int tgtIdx) {
        // 재귀호출 기저조건
        if (tgtIdx == staffTgtCnt) {
            // 현재 목표인 tgt 가 완성된 상태
            // complete code

            // 현재 선택된 직원의 키의 합을 구해서 B 크거나 같은지 확인 => min 갱신
            int sum = 0;
            for (int i = 0; i < staffTgtCnt; i++) {
                sum += staffTgt[i];
            }

            if (sum >= B)
                min = Math.min(min, sum - B); // 차이가 최소인 값으로 선택

            return;
        }

        // 끝까지 다 왔을 때
        if (srcIdx == N)
            return;

        // 조합은 현재 srcIdx 를 선택하거나 선택 안하고 다음 것을 선택하거나
        staffTgt[tgtIdx] = staffSrc[srcIdx]; // 선택 가정

        comb(srcIdx + 1, tgtIdx + 1); // 바로 위 선택을 존중
        comb(srcIdx + 1, tgtIdx); // 바로 위 선택을 버림
    }
}