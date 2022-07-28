from collections import deque
answer = []
for i in range(int(input())):
    result = 0
    n,m = map(int,input().split())
    queue = (list(map(int,input().split())))
    while(1):   
        if m == 0:
            if queue[0] == max(queue):
                result += 1
                answer.append(result)
                break
            else:
                now = queue.pop(0)
                queue.append(now)
                m = len(queue)-1
        else:
            if queue[0] == max(queue):
                queue.pop(0)
                result += 1
                m -= 1
            else:
                queue.append(queue.pop(0))
                m -= 1
for i in answer:
    print(i)         