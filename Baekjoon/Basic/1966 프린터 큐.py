from collections import deque
for i in range(int(input())):
    answer = 0
    n,m = map(int,input().split())
    queue = (list(map(int,input().split())))
    while(1):   
        print(queue,m)
        if m == 0:
            if queue[0] == max(queue):
                answer += 1
                print(answer)
                break
            else:
                now = queue.pop(0)
                queue.append(now)
                m = len(queue)-1
        else:
            if queue[0] == max(queue):
                print(queue.pop(0))
                answer += 1
                m -= 1
            else:
                queue.append(queue.pop(0))
                m -= 1
            