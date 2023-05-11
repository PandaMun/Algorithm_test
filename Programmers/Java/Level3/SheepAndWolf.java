package Level3;

public class SheepAndWolf {
    int[] nodeInfo; // 노드의 정보 (양 또는 늑대)를 저장하는 배열
    int[][] nodeEdges; // 노드 간의 연결 관계를 저장하는 배열
    int maxSheepCount = 0; // 최대 양의 수를 저장하는 변수

    public int solution(int[] info, int[][] edges) {
        nodeInfo = info; // 전달받은 info 배열을 nodeInfo에 저장합니다.
        nodeEdges = edges; // 전달받은 edges 배열을 nodeEdges에 저장합니다.
        boolean[] isVisited = new boolean[info.length]; // 초기 방문 배열을 생성합니다. (모든 노드는 방문하지 않은 상태)
        dfs(0, isVisited, 0, 0); // dfs 메서드를 호출하여 최대 양의 수를 계산합니다.

        return maxSheepCount; // 최대 양의 수를 반환합니다.
    }

    public void dfs(int index, boolean[] visited, int sheepCount, int wolfCount) {
        // index 현재 노드, 방문체크 배열, 양 숫자, 늑대 숫자
        visited[index] = true; // 현재 노드를 방문 처리합니다.
        if (nodeInfo[index] == 0) { // 현재 노드가 양인 경우
            sheepCount++; // 양의 수를 증가시킵니다.
            if (sheepCount > maxSheepCount) { // 최대 양의 수를 갱신해야 하는 경우
                maxSheepCount = sheepCount; // 최대 양의 수를 갱신합니다.
            }
        } else { // 현재 노드가 늑대인 경우
            wolfCount++; // 늑대의 수를 증가시킵니다.
        }

        if (sheepCount <= wolfCount) { // 양의 수가 늑대의 수보다 작거나 같은 경우
            return; // 종료합니다. (해당 경로는 양이 늑대보다 적으므로 최대 양의 수를 갱신할 수 없습니다.)
        }

        for (int[] edge : nodeEdges) { // 각 간선에 대해서
            if (visited[edge[0]] && !visited[edge[1]]) { // 첫 번째 노드는 방문했으나 두 번째 노드는 방문하지 않은 경우
                boolean[] nextVisited = new boolean[visited.length]; // 다음 방문 배열을 생성합니다.

                for (int i = 0; i < visited.length; i++) { // 현재 방문 배열을 복사합니다.
                    nextVisited[i] = visited[i];
                }

                dfs(edge[1], nextVisited, sheepCount, wolfCount); // 다음 노드를 방문하도록 dfs를 재귀 호출합니다.
            }
        }
    }
}
