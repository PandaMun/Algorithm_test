import math
answer = []
for i in range(int(input())):
    a = list(map(int,input().split(' ')))
    floor = int(a[2] % a[0])
    if floor == 0:
        floor = a[0]
    room = math.ceil(a[2] / a[0])
    if room <= 9:
        answer.append(str(floor)+'0'+ str(room))
    else:
        answer.append(str(floor)+ str(room))
for i in answer:
    print(int(i))