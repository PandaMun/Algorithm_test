import sys
input = sys.stdin.readline
time = 0
answer = 0
n = int(input())
line = list(map(int,input().split()))
line.sort()
for i in line:
    time = time + i
    answer += time
print(answer)
    