answer = 1
number = int(input()) - 1
n = 6
while(number >= n):
    number -= n
    n += 6
    answer += 1
if number > 0:
    answer += 1    
print(answer)