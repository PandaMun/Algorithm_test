from itertools import combinations
number = []
n ,m = map(int, input().split())
for i in range(1, n+1):
    number.append(i)
for i in combinations(number, m):
    print(' '.join(list(map(str, list(i)))))