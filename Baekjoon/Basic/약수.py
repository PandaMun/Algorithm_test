import sys
input = sys.stdin.readline
count = int(input())
answer = list(map(int, input().split()))
answer.sort()
print(answer[0] * answer[-1])