from collections import deque
answer = []
while(1):
    w,h = map(int,input().split())
    if w == 0 and h == 0:
        break
    map = []
    for i in range(h):
        map.append(list(map(int, input().split())))
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]
    queue = deque()
    queue.append((0,0))
    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0 < nx < w and 0 < ny < h:
                if map[y][x] == 1:
                    
        