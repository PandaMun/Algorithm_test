import sys
input = sys.stdin.readline

n,k = map(int,input().split())
number = list(map(int, input().split()))
answer = [0]
result = []
for i in number:
    answer.append(i+answer[-1])
for i in range(k,n+1):
    result.append(answer[i]-answer[i-k])
    
print(result)