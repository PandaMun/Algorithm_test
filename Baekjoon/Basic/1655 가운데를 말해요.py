import heapq
import sys
input = sys.stdin.readline
answer = []
result = []

for i in range(int(input())):
    x = int(input())
    heapq.heappush(answer,x)
    result.append(list(answer))
    if len(answer) % 2 == 0:
        a = (len(answer) // 2) - 1
    else:
        a = (len(answer) // 2)
    
    #result.append((answer[a],answer))
print('---------')
for i in result:
    print(i)
    
#https://velog.io/@smkim104/BOJ-1655-%EA%B0%80%EC%9A%B4%EB%8D%B0%EB%A5%BC-%EB%A7%90%ED%95%B4%EC%9A%94Python-%EC%9A%B0%EC%84%A0%EC%88%9C%EC%9C%84-%ED%81%90%EC%B5%9C%EB%8C%80%ED%9E%99-%EC%B5%9C%EC%86%8C%ED%9E%99