import sys
input = sys.stdin.readline
n = int(input())
level = []
update = []
answer = 0
for i in range(n):
    level.insert(0,int(input()))
for i in level:
    if len(update) == 0:
        update.append(i)
    else:
        if i >= update[-1]:
            answer += i - (update[-1] - 1)
            update.append(update[-1] - 1)
        else:
            update.append(i)
        
        
print(update,level,answer)