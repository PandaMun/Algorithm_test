from collections import deque
n = int(input())
balloon = (list(map(int,input().split())))
deck = []
for i in range(n):
    deck.append([balloon[i],i+1])
stack = 0
current = 0
answer = []
while(1):
    if stack == 0:
        num = balloon.popleft()
        answer.append(num[1])
        current = num[1]
    else:
        if num[0] > 0:
            (len(balloon)  + 1 + num) 
        else: