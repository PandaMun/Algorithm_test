T = int(input())
answer = []
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    case = list(input())
    count = len(case)
    win = 0
    for i in case:
        if i == 'o':
            win += 1
    if (15 - count) + win >= 8:
        answer.append('YES')
    else:
        answer.append('NO')
for i in range(len(answer)):
    print('#' + str(i+1) + ' ' + answer[i])
        