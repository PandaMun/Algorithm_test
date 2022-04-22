import sys
input = sys.stdin.readline
n = int(input())
answer = 0
def factorial(n):
    result = 1
    while(n!=0):
        result *= n
        n -= 1
    return result
n = str(factorial(n))
for i in reversed(n):
    if i == '0':
        answer += 1
    else:
        break
print(answer)
