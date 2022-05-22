from collections import deque
answer = []
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(10):
    case = int(input())
    code = deque()
    code += list(map(int,input().split()))
    seq = 1
    while(1):
        num = code.popleft()
        num -= seq
        if num <= 0:
            code.append(0)
            answer.append(' '.join(list(map(str,code))))
            break
        else:
            code.append(num)
        seq += 1
        if seq > 5:
            seq = 1
    
for i in range(len(answer)):
    print('#' +str(i+1) + ' ' + str(answer[i]))               
          