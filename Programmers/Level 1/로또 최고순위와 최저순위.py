def solution(lottos, win_nums):
    win_count = 0
    zero_count = 0
    low = 0
    high = 0
    answer = []
    for i in range(len(lottos)):
        if lottos[i] in win_nums:
            win_count += 1
    zero_count = lottos.count(0)
    if win_count + zero_count  == 6:
        answer.append(1)
    elif win_count + zero_count  == 5:
        answer.append(2)
    elif win_count + zero_count  == 4:
        answer.append(3)
    elif win_count + zero_count  == 3:
        answer.append(4)
    elif win_count + zero_count  == 2:
        answer.append(5)
    else:
        answer.append(6)

    if win_count  == 6:
        answer.append(1)
    elif win_count == 5:
        answer.append(2)
    elif win_count == 4:
        answer.append(3)
    elif win_count == 3:
        answer.append(4)
    elif win_count == 2:
        answer.append(5)
    else:
        answer.append(6)


    return answer