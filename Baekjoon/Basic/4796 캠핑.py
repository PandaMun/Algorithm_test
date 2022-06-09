answer = []
Available_Camping = []
while(1):
    case= list(map(int,input().split()))
    if case == [0,0,0]:
        break
    else:
        Available_Camping.append(case)
for i in Available_Camping:
    count = i[2] // i[1]
    leave = i[2] % i[1]
    if leave >= i[0]:
        leave = i[0]
    result = (count * i[0]) + leave
    answer.append(result)
for i in range(len(answer)):
    print('Case ' + str(i+1) + ': ' + str(answer[i]))