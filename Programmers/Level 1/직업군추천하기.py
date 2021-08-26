def solution(table, languages, preference):
    result = []
    for i in table:
        job = i.split(" ")
        number = 0
        n = 0
        for j in languages:
            num = 0
            if job[1] == j:
                num = 5
            elif job[2] == j:
                num = 4
            elif job[3] == j:
                num = 3
            elif job[4] == j:
                num = 2
            elif job[5] == j:
                num = 1
            number += (preference[n] * num)
            n += 1
        result.append(number)
    answer = []
    answer.append(result[1])
    answer.append(result[4])
    answer.append(result[2])
    answer.append(result[3])
    answer.append(result[0])
    if answer.index(max(answer)) == 0:
        final = 'CONTENTS'
    elif answer.index(max(answer)) == 1:
        final = 'GAME'
    elif answer.index(max(answer)) == 2:
        final = 'HARDWARE'
    elif answer.index(max(answer)) == 3:
        final = 'PORTAL'
    elif answer.index(max(answer)) == 4:
        final = 'SI'
    return final
