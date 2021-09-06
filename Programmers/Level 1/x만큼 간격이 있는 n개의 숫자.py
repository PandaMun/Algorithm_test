def solution(x, n):
    answer = []
    origin_x = x
    for i in range(n):
        answer.append(x)
        x += origin_x
    return answer