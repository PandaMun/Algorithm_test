package Level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class ClimbingCourse {

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        // 주어진 경로로부터 그래프를 셍성합니다.
        ArrayList<ArrayList<Node>> graph = createGraph(n, paths);
        // 꼭대기를 저장하는 맵
        HashMap<Integer, Boolean> summitMap = createSummitMap(summits);
        // 출입구를 저장하는 맵
        HashMap<Integer, Boolean> gateMap = createGateMap(summits);
        // 우선순위 큐
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 꼭대기 정렬
        Arrays.sort(summits);

        // 각 지점까지의 거리를 저장하라 배열
        int[] intensities = new int[n + 1];
        // 각 지점에 일단 최댓값을 넣어놓습니다.
        Arrays.fill(intensities, Integer.MAX_VALUE);
        // 출입구 돌면서 우선순위 큐에 추가하고 거리를 0으로 설정합니다.
        for (int gate : gates) {
            pq.offer(new Node(gate, 0));
            intensities[gate] = 0;
        }
        // 우선순위 돌면서 다익스트라 알고리즘써서 최단거리 계산
        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (gateMap.containsKey(now.index) || summitMap.containsKey(now.index)) {
                continue;
            }

            if (intensities[now.index] < now.intensity) {
                continue;
            }

            for (Node next : graph.get(now.index)) {
                // 이웃 노드의 강도와 현재 노드의 강도를 비교해서 큰값
                int intensity = Math.max(next.intensity, now.intensity);
                // 기존값이 현재 강도보다 크다면 intensities에 현재 강도 저장(갱신)
                if (intensities[next.index] > intensity) {
                    intensities[next.index] = intensity;
                    // 우선순위 큐에 추가합니다.
                    pq.offer(new Node(next.index, intensity));
                }
            }
        }

        int index = -1;
        int minIntensity = Integer.MAX_VALUE;
        for (int summit : summits) {
            if (intensities[summit] < minIntensity) {
                minIntensity = intensities[summit];
                index = summit;
            }
        }
        return new int[] { index, minIntensity };
    }

    private static HashMap<Integer, Boolean> createGateMap(int[] gates) {
        HashMap<Integer, Boolean> gateMap = new HashMap<>();
        for (int gate : gates) {
            gateMap.put(gate, true);
        }
        return gateMap;
    }

    private static HashMap<Integer, Boolean> createSummitMap(int[] summits) {
        HashMap<Integer, Boolean> summitMap = new HashMap<>();
        for (int summit : summits) {
            summitMap.put(summit, true);
        }
        return summitMap;
    }

    private ArrayList<ArrayList<Node>> createGraph(int n, int[][] paths) {
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] p : paths) {
            graph.get(p[0]).add(new Node(p[1], p[2]));
            graph.get(p[1]).add(new Node(p[0], p[2]));
        }

        return graph;
    }

}

class Node implements Comparable<Node> {
    int index;
    int intensity;

    public Node(int index, int intensity) {
        this.index = index;
        this.intensity = intensity;
    }

    @Override
    public int compareTo(Node o) {
        return this.intensity - o.intensity;
    }
}
