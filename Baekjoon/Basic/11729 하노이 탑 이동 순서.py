import sys
input = sys.stdin.readline
answer = []

def hanoitop(count,start,end,sub):
    if count == 1:
        answer.append(str(start)+ ' ' +str(end))
        return
    hanoitop(count -1, start,sub,end)
    answer.append(str(start)+ ' ' +str(end))
    hanoitop(count-1,sub,end,start)

count = int(input())
hanoitop(count,1,3,2)
print(len(answer))
for i in answer:
    print(i)