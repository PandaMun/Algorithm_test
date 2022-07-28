def solution(skill, skill_trees):
    i = []
    answer = 0
    for i in skill_trees:
        test = list(i)
        order = list(skill)
        length = 0
        for j in test:
            if j in order:
                if j == order[0]:
                    del order[0]
                    length += 1
                else:
                    break
            else:
                length += 1
            if length == len(test) or len(order) == 0:
                print(order, test,length, answer)
                answer += 1
                break

    return answer