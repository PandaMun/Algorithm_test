days =['MON','TUE','WED','THU','FRI','SAT','SUN']
T = int(input())
answer = []
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    now = days.index(input())
    next = 0
    if now == 6:
        next += 1
        now = 0
    for i in range(now,len(days)):
        if days[i] == 'SUN':
            answer.append(next)
            break
        next += 1
for i in range(len(answer)):
    print('#' + str(i+1) + ' ' + str(answer[i]))
                    