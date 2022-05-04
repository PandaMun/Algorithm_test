import heapq
import sys
input = sys.stdin.readline
answer = []
number = []
N = []
for i in range(int(input())):
    number.append(int(input()))
for i in number:   
    if i == 0:
        if len(N) > 0:
            print(heapq.heappop(N)[1])
        else:
            print('0')
    else:
        heapq.heappush(N,(-i,i))
