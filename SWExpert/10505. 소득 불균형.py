answer = []
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n = int(input())
    income = list(map(int,input().split()))
    average = sum(income) / n
    result = 0
    for i in income:
        if i <= average:
            result += 1
    answer.append(result)
for i in range(len(answer)):
    print('#' +str(i+1) + ' ' + str(answer[i]))
