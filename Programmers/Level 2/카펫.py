def solution(brown, yellow):
    answer = []
    measure = []
    if yellow == 1:
        return [3,3]
    for i in range(1,yellow+1):
        if yellow % i == 0:
            measure.append([i,yellow//i])
    for i in measure:
        if (i[0] + 2) * 2 + (i[1] * 2) == brown:
            answer.append(i)
    answer.sort(reverse=True)
    for i in range(2):
        answer[0][i] += 2
    return answer[0]