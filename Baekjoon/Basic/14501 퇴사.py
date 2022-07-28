from collections import deque 
n = int(input())
schedule = []
answer = []
for i in range(n):
    schedule.append(list(map(int,input().split())))
state = deque()
first = schedule.pop(0)
state.append(first)
state.append(0,0)
idx = 0
while state:
    date,money = state.popleft
    answer.append(money)
    for i in range(2):
        state.append()
