import math
def solution(fees, records):
    stack = {}
    stay = []
    answer = {}
    result = []
    for i in records:
        record = i.split()
        answer[record[1]] = 0
    for i in records:
        record = i.split()
        if record[1] in stay:
            incar = list(map(int, stack[record[1]].split(':')))
            outcar = list(map(int,record[0].split(':')))
            time = ((outcar[0] * 60) + outcar[1]) - ((incar[0]* 60) + incar[1])
            answer[record[1]] += time
            stay.remove(record[1])
        else:
            stack[record[1]] = record[0]
            stay.append(record[1])
    if len(stay) != 0:
        for i in stay:
            outcar = list(map(int, stack[i].split(':')))
            answer[i] += 1439 - ((outcar[0] * 60) + outcar[1])
    key = list(answer.keys())
    key.sort()
    for i in key:
        if answer[i] - fees[0] < 0:
            result.append(fees[1])
        else:
            result.append(fees[1] + math.ceil((answer[i] - fees[0])/fees[2]) * fees[3])


    return result