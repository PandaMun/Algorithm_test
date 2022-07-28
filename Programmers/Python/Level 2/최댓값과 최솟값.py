def solution(s):
    test = []
    answer = ''
    test = list(map(int, s.split(' ')))
    answer += str(min(test)) + ' ' + str(max(test))
    return answer