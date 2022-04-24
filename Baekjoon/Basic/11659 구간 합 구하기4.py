import sys
input = sys.stdin.readline
n, m = map(int,input().split())
number = list(map(int,input().split()))
answer = [0]
result = []
for i in number:
    answer.append(i+answer[-1])
for i in range(m):    
    a,b = map(int, input().split())
    result.append(answer[b]-answer[a-1])
for i in result:
    print(i)