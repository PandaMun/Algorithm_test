answer = []
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    L,U,X = map(int,input().split())
    if L <= X <= U:
        result = 0
    elif X < L:
        result = L - X
    else:
        result = -1  
    answer.append(result)
for i in range(len(answer)):
    print('#' +str(i+1) + ' ' + str(answer[i]))