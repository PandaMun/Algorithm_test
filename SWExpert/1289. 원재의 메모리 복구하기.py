answer = []
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    target = list(input())
    result = 0
    case = ['0']*len(target)
    for i in range(len(target)):
        if target[i] != case[i]:
            if target[i] == '1':
                result += 1
                for j in range(i,len(target)):
                    case[j] = str(1)
            else:
                result += 1
                for j in range(i,len(target)):
                    case[j] = str(0)
                    
    answer.append(result)
for i in range(len(answer)):
    print('#' +str(i+1) + ' ' + str(answer[i]))               
                