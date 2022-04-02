import math

def PrimeNumber(number):
    for j in range(2, int(math.sqrt(number))+1):
        if number % j == 0:
            return False
    return True

def solution(n, k):
    answer = []
    result = 0
    while(n > 0):
        answer.insert(0, str(n % k))
        n //= k
    change = ''.join(answer)
    answer = change.split('0')
    for i in range(answer.count('')):
        answer.remove('')
    for i in answer:
        if PrimeNumber(int(i)) and int(i) > 1:
            result += 1

    return result