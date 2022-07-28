import sys
input = sys.stdin.readline
n = int(input())
seq = list(map(int, input().split()))
answer = []
stack = []

for i in seq:
    if len(stack) == 0:
        stack.append(i)
    else:
        
        