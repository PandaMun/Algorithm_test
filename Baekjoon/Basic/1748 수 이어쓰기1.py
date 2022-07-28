n = int(input())
answer = 0
count = 10
stack = 1
while(1):
    if n >= count:
        answer += ((count - 1) - answer) * stack
    else:
        answer += (n - (count // 10) + 1) * stack
        break
    stack += 1
    count *= 10 
print(answer)
