def solution(d, budget):
    result = 0
    d.sort()
    for i in d:
        if budget < i:
            return result
        else:
            budget -= i
            result += 1

    return result