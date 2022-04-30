from collections import deque
import sys
input = sys.stdin.readline
count = int(input())
queue = deque([])
answer = []
result = []
for i in range(count):
    command = input().strip()
    if 'push' in command:
        command = int(command.replace("push ",""))
        queue.append(command)
    elif command == 'pop':
        if len(queue) > 0:
            answer.append(queue.popleft())
        else:
            answer.append(-1)
    elif command == 'size':
        answer.append(len(queue))
    elif command == 'empty':
        if len(queue) > 0:
            answer.append(0)
        else:
            answer.append(1)
    elif command == 'front':
        if len(queue) > 0:
            answer.append(queue[0])
        else:
            answer.append(-1)
    elif command == 'back' :
        if len(queue) > 0:
            answer.append(queue[-1])
        else:
            answer.append(-1)
for i in answer:
    print(i)