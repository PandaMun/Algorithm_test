import math
hour,minute = map(int,input().split(':'))
area = list(map(int,input().split()))
for i in range(int(input())):
    command = list(input().split())
    if command[1] == '^':
        current_area = math.ceil((hour + (minute * (1/60))) / 2)
        if current_area > 6:
            current_area = 6
        area[current_area-1] = 0
    else:
        if 'M' in command[1]:
            minute += int(command[1][0:2])
            if minute >= 60:
                hour += 1
                minute -= 60
            if hour > 12:
                hour -= 12
        if 'H' in command[1]:
            hour += int(command[1][0:1])
            if hour >= 12:
                hour -= 12
answer = sum(area)
if area > 100:
    print(100)
else:
    print(answer)