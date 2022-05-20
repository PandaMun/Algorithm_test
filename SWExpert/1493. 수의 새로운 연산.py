answer = []
def find(n):
    result = n
    for i in range(1,n+1):
        result -= i
        if result <= 0:
            return [i + result, 1 - result]
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    p,q = map(int,input().split())
    xy1 = find(p)
    xy2 = find(q)
    xy = []
    for i in range(len(xy1)):
        xy.append(xy1[i] + xy2[i])
    result = 0 
    for i in range(xy[0]+xy[1] -1):
        result += i+1
    result -= xy[1] - 1
    answer.append(result)
for i in range(len(answer)):
    print('#' +str(i+1) + ' ' + str(answer[i]))            