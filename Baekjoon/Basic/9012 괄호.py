def parenthesis(T):
    stack = 0
    for i in T:
        if i == '(':
            stack += 1
        else:
            if stack == 0 :
                return 'NO'
            else:
                stack -= 1
    if stack == 0:            
        return 'YES'
    else:
        return 'NO'
answer = []
for i in range(int(input())):
    T = input()
    answer.append(parenthesis(T))
for i in answer:
    print(i)