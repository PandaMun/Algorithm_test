import datetime
answer = []
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    D,H,M = map(int,input().split())
    if D >= 11:
        day = (D - 11)
        if day == 0 and H < 11:
            answer.append(-1)
        else:
            hour = H - 11
            if hour < 0:
                day -= 1
                hour += 24
            if day == 0 and hour == 0 and M < 11:
                answer.append(-1)
            else:
                minute = M - 11
                if minute < 0:
                    hour -= 1
                    minute += 60
                    if hour < 0:
                        day -= 1
                        hour += 24
    answer.append(((day * 24) * 60) + (hour * 60) + minute)
for i in range(len(answer)):
    print('#' +str(i+1) + ' ' + str(answer[i]))
