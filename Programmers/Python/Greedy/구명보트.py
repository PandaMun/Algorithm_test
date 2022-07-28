def solution(people, limit):
    answer = 0
    people.sort()
    minimum = 0
    maximum = len(people) -1
    while(minimum <= maximum):
        if maximum - minimum == 0:
            answer += 1
            break
        elif people[minimum] + people[maximum] > limit:
            maximum -= 1
            answer += 1
        else:
            minimum += 1
            maximum -= 1
            answer += 1

    return answer