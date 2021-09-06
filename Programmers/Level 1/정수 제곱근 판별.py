def solution(n):
    for i in range(n+1):
        if i * i == n:
            return (i+1) ** 2
    
    return -1