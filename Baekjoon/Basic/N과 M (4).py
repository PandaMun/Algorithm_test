import sys
from itertools import combinations_with_replacement
input = sys.stdin.readline
n ,m = map(int, input().split())
result = []
for i in range(1, n+1):
    result.append(i)
for i in combinations_with_replacement(result,m):
    print(' '.join(list(map(str,i))))