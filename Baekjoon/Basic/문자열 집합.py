import sys
input = sys.stdin.readline
s = []
answer = 0
n,m = map(int, input().split())
for i in range(n):
    s.append(input())
for i in range(m):
    check = input()
    if check in s:
        answer += 1
print(answer)