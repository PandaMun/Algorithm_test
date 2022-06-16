import math
answer = []
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    ok = 0
    n = int(input())
    for i in range(1,int(math.sqrt(n)+1)):
        if math.sqrt(n * i) % 1 == 0:
            ok = 1
            answer.append(i)
            break
    if ok == 0:
        answer.append(n)

for i in range(len(answer)):
    print('#' +str(i+1) + ' ' + str(answer[i]))
