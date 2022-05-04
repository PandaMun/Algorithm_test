import heapq
import sys
input = sys.stdin.readline
number = []
stack = []
for i in range(int(input())):
    number.append(int(input()))
for i in number:
    if i == 0:
        if len(stack) > 0:
            print(heapq.heappop(stack))
        else:
            print('0')
    else:
        heapq.heappush(stack,i)