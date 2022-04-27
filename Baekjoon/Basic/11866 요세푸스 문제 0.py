from collections import deque
import sys
input = sys.stdin.readline
n, k= map(int, input().split())
queue = deque([])
answer = []
count = 0
k = k - 1
for i in range(1,n+1):
    queue.append(i)
    

while(1):
    if len(queue) == 1:
        answer.append(queue[0])
        break
    else:
        if len(answer) == 0:
            count = k
            answer.append(queue[count])
            del queue[count]
        if len(queue) <= 1:
            answer.append(queue[0])
            break
        else:
            if count + k >= len(queue):
                count = (count + k) % (len(queue))
                answer.append(queue[count])
                del queue[count]
            else:
                count = (count + k)
                answer.append(queue[count])
                del queue[count]

print('<' + ", ".join(map(str,answer)) + '>')