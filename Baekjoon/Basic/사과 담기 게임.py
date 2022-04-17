import sys
input = sys.stdin.readline
n, m = map(int, input().split())
location = []
answer = 0
j = int(input())
for i in range(1,m+1):
    location.append(i)
for i in range(j):
    apple = int(input())
    if apple in location:
        continue
    if apple < location[0]:
        move = location[0] - apple
        answer += move
        for i in range(len(location)):
            location[i] -= move
    if apple > location[-1]:
        move = apple - location[-1]
        answer += move
        for i in range(len(location)):
            location[i] += move
print(answer)
        