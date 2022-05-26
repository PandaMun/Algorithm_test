answer = []
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n = int(input())
    s1 = (n*(n+1))// 2
    s2 = (n**2)
    s3 = (n**2)+n
    answer.append(str(s1) + ' ' + str(s2) + ' ' + str(s3))
for i in range(len(answer)):
    print('#' +str(i+1) + ' ' + str(answer[i]))
