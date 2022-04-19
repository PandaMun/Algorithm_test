import sys
input = sys.stdin.readline

def GCD(n,m):
    while(m > 0):
        n,m = m, n%m
    return n
def LCM(n,m):
    return ((n*m)/GCD(n,m))

answer = []

for i in range(int(input())):
    n,m = map(int, input().split())
    answer.append(LCM(n,m))
for i in answer:
    print(int(i))

