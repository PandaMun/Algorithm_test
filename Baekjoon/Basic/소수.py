import math

def PrimeNumber(number):
    
    for i in range(2, int(math.sqrt(number)+1)):
        if number % i == 0:
            return False
    return True
answer = []

for i in range(int(input()), int(input())+1):
    if i>1 and PrimeNumber(i):
        answer.append(i)
if len(answer) == 0:
    print(-1)        
else:
    print(sum(answer))
    print(min(answer))
        
    