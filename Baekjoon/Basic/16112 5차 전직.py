import sys
input = sys.stdin.readline
n,k = map(int,input().split())
exp = list(map(int,input().split()))
exp.sort(reverse=True)
result = 0
for i in range(len(exp)):
    if (len(exp) - (i+1)) >= k:
        result += (k * exp[i])
    else:
        result += (len(exp) - (i+1)) * exp[i]

print(result)