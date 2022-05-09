#BFS을 수행하여 미로를 탈출하자
#입력 예시
#
#5 6
#101010
#111111
#000001
#111111
#111111

from collections import deque

n,m = map(int,input().split())

graph = []
for i in range(n):
    graph.append(list(map(int,input())))
dx = [-1,1,0,0]
dy = [0,0,-1,1]
def BFS(x,y):
    queue = deque()
    queue.append((x,y))
    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < m:
                if graph[nx][ny] == 0: #벽인 경우
                    continue
                if graph[nx][ny] == 1:
                    graph[nx][ny] = graph[x][y] + 1
                    queue.append((nx,ny))
    return graph[n-1][m-1]

print(BFS(0,0))
print(graph)
                    
                    
    