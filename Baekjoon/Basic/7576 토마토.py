from collections import deque

m,n = map(int,input().split())
box = []
answer = []
queue = deque()
for i in range(n):
    box.append(list(map(int,input().split())))
for i in range(n):
    for j in range(m):
        if box[i][j] == 1:
            queue.append((i,j))

dx = [1,-1,0,0]
dy = [0,0,1,-1]
while queue:
    x,y = queue.popleft()
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < n and 0 <= ny < m:
            if box[nx][ny] == 0:
                box[nx][ny] = box[x][y] + 1
                queue.append((nx,ny))
for i in range(n):
    answer.append(max(box[i]))
    for j in range(m):
        if box[i][j] == 0:
            print(-1)
            exit(0)
print(max(answer)-1)
            
            

                
    