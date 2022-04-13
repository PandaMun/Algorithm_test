from itertools import permutations
number = []
n ,m = map(int, input().split())
for i in range(1, n+1):
    number.append(i)
for i in permutations(number, m):
    print(' '.join(list(map(str, list(i)))))