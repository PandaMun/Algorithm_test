from collections import deque
import sys

input = sys.stdin.readline

n,k = map(int,input().split())
queue = deque()

visited = [False] * 1000001
queue.append((n,0)) 
visited[n] = True
while(queue):
    location,move = queue.popleft()
    if location == k:
        print(move)
        break
    else:
        if(0 <= (location * 2) <= 1000000) and (visited[location * 2] == False):
            visited[location * 2] = True
            queue.append((location * 2, move+1))
        if(0 <= location - 1 <= 1000000) and (visited[location - 1] == False): 
            visited[location - 1] = True
            queue.append((location-1,move+1))
        if(0 <= location + 1 <= 1000000) and (visited[location + 1] == False) :
            visited[location  + 1] = True
            queue.append((location+1, move+1))
        
        
