import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

def dfs(u):
    visited[u] = False
    for i in graph[u]:
        if visited[i]:
            dfs(i)
n,m = map(int, input().split())
graph = []
visited = []
answer = 0
for i in range(n+1):
    graph.append([])
    visited.append(True)
for j in range(m):
    u,v = map(int,input().split())
    graph[u].append(v)
    graph[v].append(u)
for i in range(1,n+1):
    if visited[i]:
        dfs(i)
        answer += 1
print(answer)