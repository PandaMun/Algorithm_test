xy=[]
for i in range(int(input())):
    y, x =list(map(int, input().split()))
    xy.append((x, y))
xy.sort()
for i in xy:
    print(str(i[1]) + ' ' + str(i[0]))
    