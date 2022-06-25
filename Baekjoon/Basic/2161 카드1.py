from collections import deque
stack = deque(list(range(1,int(input())+1)))
cnt = 1
answer = []
while(len(stack)!=0):
    if cnt % 2 == 1:
        answer.append(str(stack.popleft()))
    else:
        stack.append(stack.popleft())
    cnt += 1
    if len(stack) == 1:
        answer.append(str(stack.popleft()))
        break
print(' '.join(answer))