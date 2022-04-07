import math
def PrimeNumber(number):
    for i in range(2, int(math.sqrt(number)+1)):
        if number % i == 0:
            return False
    return True
a, b = map(int, input().split())
for i in range(a, b+1):
    if PrimeNumber(i):
        print(i)