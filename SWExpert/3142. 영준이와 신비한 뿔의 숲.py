answer = []
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n,m = map(int,input().split())
    unicorn = 0
    twinhorn = 0
    while(1):
        if m * 2 == n:
            twinhorn += m
            answer.append(str(unicorn) + ' ' +str(twinhorn))
            break
        else:
            unicorn += 1
            m -= 1
            n -= 1
for i in range(len(answer)):
    print('#' +str(i+1) + ' ' + str(answer[i]))