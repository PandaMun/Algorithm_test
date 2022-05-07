import sys 
sys.setrecursionlimit(10000*4)

def dfs(x, y): 
    dx = [1, -1, 0, 0] 
    dy = [0, 0, 1, -1] 
    # 상,하,좌,우 확인 
    for i in range(4):
        nx = x + dx[i] 
        ny = y + dy[i] 
        if (0 <= nx < m) and (0 <= ny < n): 
            if field[nx][ny] == 1:
                field[nx][ny] = 0 
                dfs(nx, ny) 
answer = []      
for i in range(int(input())):
    m,n,k = map(int,input().split())
    field = []
    result = 0
    for i in range(m):
        line = []
        for j in range(n):
            line.append(0)
        field.append(line)
    for i in range(k):
        x,y = map(int, input().split())
        field[x][y] = 1
    for i in range(m):
        for j in range(n):
            if field[i][j] > 0:
                dfs(i,j)
                result += 1
    answer.append(result)
for i in answer:
    print(i)