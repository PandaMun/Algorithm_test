import sys
input = sys.stdin.readline
n,c = map(int,input().split())
showtime = set([])
for i in range(n):
    time = int(input())
    for i in range(time,c+1,time):
        showtime.add(i)
print(len(showtime))