import sys
input = sys.stdin.readline
time = []
answer = []
for i in range(int(input())):
    start,end = map(int, input().split())
    time.append([start,end])
time.sort()
time.sort(key=lambda x: x[1])
for i in time:
    if len(answer) == 0:
        answer.append(i)
    else:
        if i[0] >= answer[-1][1]:
            answer.append(i)
print(answer)
