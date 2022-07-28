import sys
input = sys.stdin.readline

n = input()
m = input()
answer = []
if len(n) < len(m):
    for i in range(len(n)):
        for j in range(i,len(n)-1):
            if (n[i:j+1]) in m:
                answer.append(len(n[i:j+1]))
else:
    for i in range(len(m)):
        for j in range(i,len(m)-1):
            if (m[i:j+1]) in n:
                answer.append(len(m[i:j+1]))
if len(answer) > 0:
    print(max(answer))
else:
    print('0')