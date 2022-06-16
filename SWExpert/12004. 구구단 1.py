answer = []
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N = int(input())
    result = False
    for i in range(1,10):
        case = N / i
        if case < 10 and case % 1 == 0:
            result = True
    if result:
        answer.append('Yes')
    else:
        answer.append('No')
for i in range(len(answer)):
    print('#' + str(i+1) + ' ' + str(answer[i]))