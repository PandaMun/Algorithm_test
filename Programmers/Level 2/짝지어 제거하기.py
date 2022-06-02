from collections import deque
def solution(s):
    s = deque(list(s))
    pair = []
    pair.append(s.popleft())
    while(1):
        if len(s) == 0:
            if len(pair) == 0:
                return 1
            else:
                return 0
        if pair[-1] == s[0]:
            pair.pop()
            s.popleft()
            if len(pair) == 0 and len(s) != 0:
                pair.append(s.popleft())
        else:
            pair.append(s.popleft())