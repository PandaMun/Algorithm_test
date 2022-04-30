from collections import deque
import sys
input = sys.stdin.readline
n, k= map(int, input().split())
queue = []
answer = []
count = 0
k = k - 1
for i in range(1,n+1):
    queue.append(i)


while(1):
    if len(queue) == 0:
        break
    else:
        count = (count + k) % len(queue)
        answer.append(queue.pop(count))

print('<' + ", ".join(map(str,answer)) + '>')