answer = []
for i in range(3):
    a = list(map(int,input().split()))
    b = a.count(1)
    if b == 4:
        answer.append('E')
    elif b == 3:
        answer.append('A')
    elif b == 2:
        answer.append('B')
    elif b == 1:
        answer.append('C')
    else:
        answer.append('D')
for i in answer:
    print(i)