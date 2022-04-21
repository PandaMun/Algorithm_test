import sys
input = sys.stdin.readline
def factorial(n):
    result = 1
    while(n != 0):
        result *= n
        n -= 1
    return result
n, k = map(int, input().split())
print(factorial(n) // (factorial(n-k) * factorial(k)))