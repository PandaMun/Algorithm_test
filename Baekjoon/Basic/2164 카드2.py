from collections import deque
import sys
input = sys.stdin.readline
count = int(input())
queue = deque([])
for i in range(1,count+1):
    queue.append(i)
while(1):
    if len(queue) > 1:
        queue.popleft()
        if len(queue) == 1:
            break
        else:
            queue.append((queue.popleft()))
    else:
        break
print(queue[0])