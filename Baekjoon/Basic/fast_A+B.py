import sys

loop = int(sys.stdin.readline())
value = []

for i in range(0,loop):
    a, b = map(int, sys.stdin.readline().split())
    value.append(a+b)

for i in value:
    print(i)
