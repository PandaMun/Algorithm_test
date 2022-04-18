import sys
input = sys.stdin.readline
answer = []
while(1):
    n,m = map(int, input().split())
    if n == 0 and m == 0:
        break
    else:
        if m % n == 0:
            answer.append('factor')
        elif n % m == 0:
            answer.append('multiple')
        else:
            answer.append('neither')
for i in answer:
    print(i)
    