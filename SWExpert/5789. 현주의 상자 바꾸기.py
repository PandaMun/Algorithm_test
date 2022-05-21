answer = []
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n,q = map(int,input().split())
    case = [0] * n
    for i in range(1,q+1):
        L,R = map(int,input().split())
        for j in range(L-1,R):
            case[j] = i
    answer.append(' '.join(map(str,case)))
for i in range(len(answer)):
    print('#' +str(i+1) + ' ' + str(answer[i]))
