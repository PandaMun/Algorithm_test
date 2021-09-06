def solution(numbers):
    answer = []
    result = []
    for i in range(len(numbers)):
        for j in range(len(numbers)):
            if i == j:
                continue
            result.append(numbers[i]+numbers[j])
    for i in result:
        if i not in answer:
            answer.append(i)
    answer.sort()
    return answer