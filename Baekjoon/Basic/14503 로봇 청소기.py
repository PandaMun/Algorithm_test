n,m = map(int,input().split())
r,c,d = map(int,input().split())
graph = []
answer = 0
for i in range(n):
    graph.append(list(map(int,input().split())))
while(1):
    if graph[n][m] == 0:
        graph[n][m] = 2
        answer += 1
        
            