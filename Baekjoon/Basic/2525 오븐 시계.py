hour, minute = map(int,input().split())
cookingTime = int(input())
minute += cookingTime
if minute >= 60:
    a = minute % 60
    b = minute // 60
    minute = a
    hour += b
    if hour >= 24:
        hour -= 24
print(str(hour) + ' ' + str(minute))