def solution(N, stages):
    answer = []
    values = []
    dic = {}
    count = 0
    for i in range(1,N+1):
        if (len(stages)  - count) == 0:
            dic[i] = 0
        else:
            dic[i] = (stages.count(i)/(len(stages)  - count))
        count += stages.count(i)
    values = list(dic.values())

    for i in range(len(values)):
        if len(values) == 0:
            break
        maximum = max(values)
        for j in range(1,N+1):
            if dic[j] == maximum:
                answer.append(j)
                values.remove(maximum)

    return answer