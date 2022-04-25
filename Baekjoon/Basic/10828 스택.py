answer = []
stack = []
for i in range(int(input())):
    command = input()
    if 'push' in command:
        command = command.replace('push ','')
        stack.append(int(command))
    elif 'pop' in command:
        if len(stack) > 0:
            answer.append(stack.pop())
        else:
            answer.append(-1)
    elif 'size' in command:
        answer.append(len(stack))
    elif 'top' in command:
        if len(stack) > 0:
            answer.append(stack[-1])
        else:
            answer.append(-1)
    elif 'empty' in command:
        if len(stack) == 0:
            answer.append(1)
        else:
            answer.append(0)
for i in answer:
    print(i)        
    