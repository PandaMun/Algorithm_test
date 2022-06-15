answer = []
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    scores = list(map(int,input().split()))
    result = 0
    for i in scores:
        if i >= 40:
            result += i
        else:
            result += 40
    answer.append(result//len(scores))
for i in range(len(answer)):
    print('#' +str(i+1) + ' ' + str(answer[i]))
