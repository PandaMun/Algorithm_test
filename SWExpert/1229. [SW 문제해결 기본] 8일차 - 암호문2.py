from collections import deque
answer = []
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(10):
    N = int(input())
    code = list((input().split()))
    count = int(input())
    command = deque()
    command += list(input().split())

    for i in range(count):
        command_type = command.popleft()
        if  command_type == 'I':
            x = int(command.popleft())
            y = int(command.popleft())
            case = []
            for j in range(y):
                code.insert(x+j,command.popleft())
        if command_type == 'D':
            x = int(command.popleft())
            y = int(command.popleft())
            del code[x:x+y]
            
    answer.append(' '.join(code[:10]))
for i in range(len(answer)):
    print('#' +str(i+1) + ' ' + str(answer[i]))               
                 