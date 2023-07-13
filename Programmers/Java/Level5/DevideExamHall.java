package Level5;

import java.util.*;

public class DevideExamHall {
    private int root, size;
    private Node[] tree;
    private int[] parent;

    public int solution(int k, int[] num, int[][] links) {

        setTree(num, links); // 트리 구조 설정

        int low = 0, high = (int) 1e9;
        // low: 자를 수 있는 최소 길이 범위의 시작 값
        // high: 자를 수 있는 최대 길이 범위의 끝 값
        // high의 경우 Integer.MAX_VALUE를 하면 원소 중 최댓값을 더해줬을 때 int 범위를 벗어날 수 있으므로 주의해야 함

        for (int n : num) {
            low = Math.max(low, n);
            // num 배열에서 가장 큰 값을 low로 설정
            // 자를 수 있는 최소 길이는 num 배열의 가장 큰 값 이상이어야 함
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            // 이진 탐색을 위해 현재 범위의 중간값인 mid를 계산

            if (checkGroup(num, mid) <= k) {
                high = mid - 1;
                // 현재 mid로 자를 수 있는 그룹의 개수가 k보다 작거나 같으면
                // 현재 mid 값을 갱신하고 범위를 좁힘 (더 작은 값으로 이동)
            } else {
                low = mid + 1;
                // 현재 mid로 자를 수 있는 그룹의 개수가 k보다 크면
                // 현재 mid 값을 갱신하고 범위를 좁힘 (더 큰 값으로 이동)
            }
        }

        return high + 1;
        // high 값이 최종적으로 결정된 경우 high + 1을 반환
        // high 값은 자를 수 있는 최대 길이이므로, high 값보다 작거나 같은 길이로 나누는 것이 조건을 만족하는 최대 길이
    }

    private int checkGroup(int[] num, int max) {
        size = 0; // 자르는 개수를 저장하는 변수
        dfs(num, root, max); // DFS로 자르는 작업을 수행
        return size + 1; // 자른 그룹의 개수 반환
    }

    private int dfs(int[] num, int cur, int max) {
        int lv = 0, rv = 0;

        if (tree[cur].left != -1)
            lv = dfs(num, tree[cur].left, max);
        // 현재 노드의 왼쪽 자식이 있으면 왼쪽 자식에 대해 DFS 수행

        if (tree[cur].right != -1)
            rv = dfs(num, tree[cur].right, max);
        // 현재 노드의 오른쪽 자식이 있으면 오른쪽 자식에 대해 DFS 수행

        // 자식 노드들과 자신의 값의 합이 max보다 작거나 같으면 자를 필요가 없음
        if (num[cur] + lv + rv <= max)
            return num[cur] + lv + rv;

        // 자신 노드들 중 제일 작은 값과 자신의 값의 합이 max보다 작거나 같으면 한 개만 자르면 됨
        if (num[cur] + Math.min(lv, rv) <= max) {
            size += 1;
            return num[cur] + Math.min(lv, rv);
        }

        // 둘 다 잘라야하는 경우
        // 맨 밑단 노드 값이 max보다 작은 경우는 없음
        // low가 제일 큰 노드를 기준으로 잡히기 때문에 무조건 첫 번째 if에서 통과됨
        size += 2;
        return num[cur];
    }

    private void setTree(int[] num, int[][] links) {
        tree = new Node[num.length];
        parent = new int[num.length];

        Arrays.fill(parent, -1);

        for (int i = 0; i < links.length; i++) {
            tree[i] = new Node(links[i][0], links[i][1]);

            if (tree[i].left != -1)
                parent[tree[i].left] = i;
            if (tree[i].right != -1)
                parent[tree[i].right] = i;
        }

        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1) {
                root = i;
                break;
            }
        }
    }

    class Node {
        int left, right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}