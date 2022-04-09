n = int(input())
for i in range(1,n+1):
    if n == i + sum(map(int,list(str(i)))):
        print(i)
        break
    if i == n:
        print(0)