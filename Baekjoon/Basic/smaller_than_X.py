import sys
N,X = map(int, sys.stdin.readline().split())
Sequence_A = list(map(int, input().split()))
lower_A = []
for i in Sequence_A:
    if(i<X):
        lower_A.append(i)

for i in lower_A:
    print(i ,end=' ')
