answer = []
for i in range(int(input())):
    a,b = map(int,input().split())
    answer.append(str(a+b))

for i in range(len(answer)):
    print('Case #'+str(i+1)+':' + ' ' + answer[i])
    