import math
def PrimeNumber(number):
    for i in range(2, int(math.sqrt(number)+1)):
        if number % i == 0:
            return False
    return True
answer = 0
count = int(input())
numbers = list(map(int, input().split()))
for i in range(count):
    if numbers[i] > 1 and PrimeNumber(numbers[i]):
        answer += 1
print(answer)
    