answer = []
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    a,b = map(int,input().split())
    if a+b >= 24:
        answer.append((a+b)-24)
    else:
        answer.append(a+b)
for i in range(len(answer)):
    print('#' + str(i+1) + ' ' + str(answer[i]))