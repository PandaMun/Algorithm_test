def solution(n):
    answer = [0,1]
    for i in range(2,n):
        first = answer[0]
        second = answer[1]
        answer[1] = first + second
        answer[0] = second
        
    return sum(answer) % 1234567