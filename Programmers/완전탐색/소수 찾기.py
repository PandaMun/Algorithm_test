from itertools import permutations
def PrimeNumber(n):
        for i in range(2,n):
            if n % i == 0:
                return False
        return True
def solution(numbers):
    result = []
    answer = 0
    for i in range(1,len(numbers)+1):
        for j in permutations(list(numbers),i):
            number = int(''.join(j))
            result.append(number)
    for i in list(set(result)):
        if PrimeNumber(i) and i > 1:
            answer += 1
    return answer