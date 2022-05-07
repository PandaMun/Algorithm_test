import sys
input = sys.stdin.readline
computer = []
visited = []
for i in range(int(input())+1):
    computer.append([])
    visited.append(0)
    
for i in range(int(input())):
    n,m = map(int,input().split())
    computer[n].append(m)
    computer[m].append(n)
    
def dfs(computer,v,visited):
    visited[v] = 1
    for i in computer[v]:
        if visited[i] == 0:
            dfs(computer,i,visited)
    return True
        
dfs(computer,1,visited)
print(sum(visited) -1 )


        