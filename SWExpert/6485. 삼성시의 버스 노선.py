answer = []
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    case = int(input())
    ab = []
    for i in range(case):
        ab.append(list(map(int,input().split())))
    p = int(input())
    station = []
    for i in range(p):
        station.append(int(input()))
    a = [0] * 5000
    for i in ab:
        for j in range(i[0]-1,i[1]):
            a[j] += 1
    result = []   
    for i in station:
        result.append(str(a[i-1]))
    answer.append((' '.join(result)))

for i in range(len(answer)):
    print('#' +str(i+1) + ' ' + str(answer[i]))