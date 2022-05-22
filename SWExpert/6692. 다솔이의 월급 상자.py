answer = []
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    result = 0
    for i in range(int(input())):
        a,b = map(float, input().split())
        result += a*b
    answer.append(format(result,".6f"))
for i in range(len(answer)):
    print('#' +str(i+1) + ' ' + str(answer[i]))
