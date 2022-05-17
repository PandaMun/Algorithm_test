from itertools import combinations
n,k = map(int,input().split())
result = 0
A = list(map(int,input().split()))
for i in range(1,len(A)+1):
    for j in list(combinations(A,i)):
        if sum(j) == k:
            result += 1
print(result)

                