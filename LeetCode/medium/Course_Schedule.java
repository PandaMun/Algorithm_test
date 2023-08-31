class Solution {
    // 인접 리스트 그래프 
    public ArrayList<Integer>[] graph = new ArrayList[100001];
    // 방문 여부 
    public boolean[] visit;
    // 함수 호출 종료 여부
    public boolean[] finish;
    // 싸이클 존재여부
    public boolean cycle;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // init table
        visit = new boolean[numCourses]; 
        finish = new boolean[numCourses];

        //===== init graph ====
        for(int i=0;i < numCourses ; i++)
            graph[i] = new ArrayList<Integer>();
        // prerequisites[i][0] 의 부모노드 prerequisites[i][1]
        
        for(int[] c:prerequisites){
            graph[c[0]].add(c[1]);
        }
        
        // 일단 모든 노드를 시작으로 한다 
        for(int i =0 ;i<numCourses;i++){
            dfs(i);
            if(cycle) break;
        }
        // cycle이 존재함 -> 끝낼 수 없음 
        // cycle이 존재하지 않음 -> 끝낼 수 있음 
        return !cycle;
        
    }
    
    // cur 노드를 방문
    public void dfs(int cur){
        if(visit[cur]){
            // 이미 이 cur을 다녀간 dfs 함수가 아직 진행중
            if(!finish[cur])cycle = true;
            return;     
        }
        visit[cur] = true;
        // 인접 노드들을 방문
        for(Integer adj : graph[cur]){
            dfs(adj);
        }
        finish[cur] = true;
    }
}