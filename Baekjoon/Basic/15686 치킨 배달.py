import sys
input = sys.stdin.readline
from itertools import combinations
n,m = map(int,input().split())
chicken = []
home = []
matrix = []
answer = []
for i in range(n):
    line = list(map(int,input().split()))
    matrix.append(line)
for i in range(n):
    for j in range(n):
        if matrix[i][j] == 1:
            home.append([i+1,j+1])
        elif matrix[i][j] == 2:
            chicken.append([i+1,j+1])

for i in combinations(chicken,m):
    distance = 0
    for j in home:
        result = 1000
        for k in range(m):
            result = min(result , (abs(i[k][0] - j[0]) + abs(i[k][1] - j[1])))
        distance += result
    answer.append(distance)
print(min(answer))           