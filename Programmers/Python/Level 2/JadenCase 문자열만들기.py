def solution(s):
    result = []
    answer = s.split(' ')
    for i in answer:
        if len(i) > 0:
            result.append(i[0].upper() + i[1:].lower())
        else:
            result.append(i)
    return ' '.join(result)