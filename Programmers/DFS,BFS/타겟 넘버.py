from collections import deque
def solution(numbers, target):
    answer = 0
    end = len(numbers) -1
    stack = deque()
    first = numbers[0]
    stack.append((first,0))
    stack.append((-1 * first,0))
    while stack:
        n,m = stack.popleft()
        if m < end:
            stack.append((n-numbers[m+1], m+1))
            stack.append((n+numbers[m+1], m+1))
        elif n == target:
            answer += 1
    return answer