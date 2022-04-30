numbers = []
while(1):
    n = int(input())
    if n == 0:
        break
    numbers.append(n)
num = (max(numbers) * 2) + 1
sieve = [False,False] + [True] * (num-1)
for i in range(2, int(num**0.5)+1):
    if sieve[i]:
        for j in range(2*i, num, i):
            sieve[j] = False
for i in numbers:
    answer = 0
    for i in range(i+1, (i*2)+1):
        if sieve[i]:
            answer += 1
    print(answer)
            
    
