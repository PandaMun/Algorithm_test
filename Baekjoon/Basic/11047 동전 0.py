import sys
input = sys.stdin.readline
n,k = map(int, input().split())
coin = []
answer = 0
count = 0
for i in range(n):
    coin.append(int(input()))
for i in reversed(coin):
    if k >= i:
        answer += (k//i)
        k = k%i
    else:
         if k == 0:
            break
print(answer)  