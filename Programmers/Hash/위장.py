def solution(clothes):
    answer = 1
    type = {}
    for i in clothes:
        type[i[1]] = []
    for i in clothes:
        type[i[1]].append(i[0])
    for i in type.keys():
        answer *= len(type[i]) + 1
    return answer - 1