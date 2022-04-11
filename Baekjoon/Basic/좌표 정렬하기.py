xy=[]
for i in range(int(input())):
    xy.append(list(map(int, input().split())))
xy.sort()
for i in xy:
    print(str(i[0]) + ' ' + str(i[1]))
    