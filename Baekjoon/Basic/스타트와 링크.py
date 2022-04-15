import sys
from itertools import combinations
input = sys.stdin.readline
n = int(input())
number = []
answer = []
table = []
for i in range(n):
    table.append(list(map(int,input().split())))
    number.append(i)
for i in combinations(number,n//2):
    a = list(map(int, i))
    b = list(set(number) - set(a))
    start = 0
    link = 0
    for j in combinations(a,2):
        start += table[j[0]][j[1]]
        start += table[j[1]][j[0]]
    for j in combinations(b,2):
        link += table[j[0]][j[1]]
        link += table[j[1]][j[0]]
    if start - link >= 0:
        answer.append(start - link)
print(min(answer))
