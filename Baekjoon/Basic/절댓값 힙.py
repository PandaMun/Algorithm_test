import sys
import heapq
input = sys.stdin.readline
n = []
answer = []
for i in range(int(input())):
    x = int(input())
    if x == 0:
        if len(n) > 0:
            a = heapq.heappop(n)
            if a[1] == 'plus':
                answer.append(a[0])
            else:
                answer.append(-1 * a[0])
        else:
            answer.append(0)
    else:
        if x > 0:
            heapq.heappush(n, (x,'plus'))
        else:
            heapq.heappush(n, (-1*x,'minus'))
for i in answer:
    print(i)
