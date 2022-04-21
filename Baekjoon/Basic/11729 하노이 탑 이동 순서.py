import sys
input = sys.stdin.readline
answer = []

def hanoitop(count,start,end,sub):
    print(count,start,end,sub)
    if count == 1:
        print(start,end)
        return
    hanoitop(count -1, start,sub,end)
    print(start,end)
    hanoitop(count-1,sub,end,start)

count = int(input())
hanoitop(count,1,3,2)