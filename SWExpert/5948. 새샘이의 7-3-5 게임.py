from itertools import combinations
answer = []
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    result = []
    numbers = list(map(int,input().split()))
    for i in combinations(numbers,3):
        summary = sum(i)
        if summary not in result:
            result.append(summary)
    result.sort()
    answer.append(result[-5])
for i in range(len(answer)):
    print('#' +str(i+1) + ' ' + str(answer[i]))