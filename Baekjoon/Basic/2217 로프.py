import sys
input = sys.stdin.readline
rope = []
for i in range(int(input())):
    rope.append(int(input()))
rope.sort(reverse=True)
answer = []
mount = 0
for i in range(len(rope)):
    answer.append(int(rope[i]*(i+1)))
print(max(answer))
    