import sys
input = sys.stdin.readline
n,m = map(int,input().split())
card = list(map(int, input().split()))
for i in range(m):
    x = min(card)
    card.remove(min(card))
    y = min(card)
    card.remove(min(card))
    card.append(x + y)
    card.append(x + y)
print(sum(card))
    
    