answer = []
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n,m = map(int,input().split())
    a = list(map(int,input().split()))
    b = list(map(int,input().split()))
    result = 0
    if len(a) > len(b):
        for i in range(len(a) - len(b) + 1):
            cal = 0
            for j in range(len(b)):
                cal += a[j+i] * b[j]
            if cal > result:
                result = cal
    else:
        for i in range(len(b) - len(a) + 1):
            cal = 0
            for j in range(len(a)):
                cal += a[j] * b[j+i]
            if cal > result:
                result = cal
    answer.append(result)
for i in range(len(answer)):
    print('#' +str(i+1) + ' ' + str(answer[i]))   