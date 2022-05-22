answer = []
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    case = list(input())
    stack = []
    while case:
        i = case.pop()
        if i in stack:
            stack.remove(i)
        else:
            stack.append(i)
    stack.sort()
    result = ''.join(stack)
    if len(result) == 0:
        answer.append("Good")
    else:
        answer.append(result)
for i in range(len(answer)):
    print('#' +str(i+1) + ' ' + str(answer[i]))
