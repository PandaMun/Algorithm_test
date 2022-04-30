#에라토스 테네스의 체로 풀어야하는데 ㅜㅜ

import math
def PrimeNumber(number):
    for i in range(2, int(math.sqrt(number)+1)):
        if number % i == 0:
            return False
    return True
a, b = map(int, input().split())
for i in range(a, b+1):
    if i >1 and PrimeNumber(i):
        print(i)