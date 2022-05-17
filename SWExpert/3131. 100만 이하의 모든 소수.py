import math
answer = []
sieve = [True] * 1000000
for i in range(2,int(math.sqrt(1000000))):
    if sieve[i] == True:
        for j in range(i*2,1000000,i):
            sieve[j] = False

for i in range(2,1000000):
    if sieve[i] == True:
        answer.append(str(i))
print(' '.join(answer))