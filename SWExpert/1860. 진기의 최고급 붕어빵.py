
answer = []
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n,m,k = map(int,input().split())
    number = list(map(int,input().split()))
    number.sort()
    bread = 0
    time = 0
    while(1):
        time += m
        bread += k
        print(time,bread)
        if time > number[0]:
            answer.append('Impossible')
            break
        else:
            for i in range(k):
                if len(number) == 0:
                    break
                else:
                    number.pop(0)
        if len(number) == 0:
            answer.append('Possible')
            break
for i in range(len(answer)):
    print('#' +str(i+1) + ' ' + str(answer[i]))               
      