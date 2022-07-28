answer = []
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    length = int(input())
    seq = list(map(int,input().split()))
    stack = 0
    pre = 0
    result = []
    for i in range(length):
        for j in range():
            if seq[i] > pre:
                stack += 1
                pre = seq[i]
            else:
                result.append(stack)
                stack = 1
                pre = seq[i]
    answer.append(max(result))
for i in range(len(answer)):
    print('#' +str(i+1) + ' ' + str(answer[i]))
