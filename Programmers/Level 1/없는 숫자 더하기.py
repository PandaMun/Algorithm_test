def solution(numbers):
    example = [0,1,2,3,4,5,6,7,8,9]
    numbers = list(set(example) - set(numbers))
    answer = 0
    for i in numbers:
        answer += i
    return answer