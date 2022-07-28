def solution(s):
    s = s.strip("{{")
    s = s.strip("}}")
    s = s.split('},{')
    element = []
    answer = []
    for i in s:
        element.append(list(map(int,i.split(','))))
    element.sort(key = lambda x : len(x))
    for i in element:
        for j in i:
            if j not in answer:
                answer.append(j)

    return answer