import sys
input = sys.stdin.readline
answer = []
def factorial(n):
    result = 1
    while(n != 0):
        result *= n
        n -= 1
    return result

for i in range(int(input())):
    n, m = map(int, input().split())
    answer.append(factorial(m) // ((factorial(m - n) * factorial(n))))

for i in answer:
    print(i)
