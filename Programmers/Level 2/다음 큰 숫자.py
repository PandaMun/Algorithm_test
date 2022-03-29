def solution(n):
    answer = 0
    i = 1
    while(1):
        if str(format(n+i, 'b')).count('1') == str(format(n, 'b')).count('1'):
            answer = n+i
            break
        i += 1
    return answer