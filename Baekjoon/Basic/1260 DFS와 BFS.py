from collections import deque
n,m,v = map(int,input().split())
graph = []
visited1 = []
visited2 = []
DFS_answer = []
BFS_answer = []

def DFS(visited,graph,v):
    visited[v] = True
    DFS_answer.append(v)
    for i in graph[v]:
        if visited[i] == False:
            DFS(visited,graph,i)
            
def BFS(visited,graph,v):
    queue = deque([v])
    visited[v] = True
    while queue:
        v = queue.popleft()
        BFS_answer.append(v)
        for i in graph[v]:
            if visited[i] == False:
                queue.append(i)
                visited[i] = True

for i in range(n+1):
    graph.append([])
    visited1.append(False)
    visited2.append(False)
for i in range(m):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)
for i in graph:
    i.sort()
DFS(visited1,graph,v)
print(' '.join(map(str,DFS_answer)))
BFS(visited2,graph,v)
print(' '.join(map(str,BFS_answer)))