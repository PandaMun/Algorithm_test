def solution(dartResult):
    answer = []
    score = 0
    index = 0
    for i in range(3):
        if dartResult[index].isdigit():
            if dartResult[index + 1].isdigit():
                score = 10
                index += 2
            else:
                score = int(dartResult[index])
                index += 1
            if dartResult[index] == 'S':
                answer.append(score)
                if (index + 1) < len(dartResult):
                    index += 1
            elif dartResult[index] == 'D':
                answer.append(score ** 2)
                if (index + 1) < len(dartResult):
                    index += 1
            elif dartResult[index] == 'T':
                answer.append(score ** 3)
                if (index + 1) < len(dartResult):
                    index += 1
            if dartResult[index] == '*':
                if len(answer) > 1:
                    answer[-1] *= 2
                    answer[-2] *= 2
                    if (index + 1) < len(dartResult):
                        index += 1
                else:
                    answer[-1] *= 2
                    if (index + 1) < len(dartResult):
                        index += 1
            if dartResult[index] == '#':
                answer[-1] *= -1
                if (index + 1) < len(dartResult):
                    index += 1

    return sum(answer)