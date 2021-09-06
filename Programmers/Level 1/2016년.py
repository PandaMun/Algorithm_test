#딕셔너리를 사용하여 key = a,b value = result로 잡고 조건 걸어서 확인후 출력
def solution(a, b):
    month = 1
    day = 1
    schedule = {}
    days = ['FRI','SAT','SUN','MON','TUE','WED','THU']
    for i in range(365):
        if month == 1 or month == 3 or month == 5 or month == 7 or month == 8 or month == 10 or month == 12:
            if day == 31:
                date = str(month) + ' ' + str(day)
                schedule[date] = days[i%7]
                month += 1
                day = 1
                continue
        elif month == 2:
            if day == 29:
                date = str(month) + ' ' + str(day)
                schedule[date] = days[i%7]
                month += 1
                day = 1
                continue
        elif month == 4 or month == 6 or month == 9 or month == 11:
            if day == 30:
                date = str(month) + ' ' + str(day)
                schedule[date] = days[i%7]
                month += 1
                day = 1
                continue
        
        date = str(month) + ' ' + str(day)
        schedule[date] = days[i%7]
        day += 1
        
        
    now = str(a) + ' ' + str(b)    
    answer = schedule[now]
    return answer