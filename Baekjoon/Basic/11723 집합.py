import sys
input = sys.stdin.readline
stack = []
for i in range(int(input())):
    command = list(input().split())
    if command[0] == 'add':
        if command[1] not in stack:
            stack.append(command[1])
    elif command[0] == 'remove':
        if command[1] in stack:
            stack.remove(command[1])
    elif command[0] == 'check':
        if command[1] in stack:
            print(1)
        else:
            print(0)
    elif command[0] == 'toggle':
        if command[1] in stack:
            stack.remove(command[1])
        else:
            stack.append(command[1])
    elif command[0] == 'all':
        stack = ['1','2','3','4','5','6','7','8','9','10','11','12','13','14','15','16','17','18','19','20']
    elif command[0] == 'empty':
        stack = []

