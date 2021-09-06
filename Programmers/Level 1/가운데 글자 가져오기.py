def solution(s):
    answer = ''
    s = list(s)
    if (len(s) % 2) == 0:
        half = len(s) // 2
        answer = s[half-1] + s[half]
    else:
        half = len(s) // 2
        answer = s[half]
    return answer