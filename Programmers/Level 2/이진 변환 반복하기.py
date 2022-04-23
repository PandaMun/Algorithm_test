def solution(s):
    answer = [0,0]
    while(1):
        n = ''
        for i in s:
            if i == '0':
                answer[1] += 1
            else:
                n += i
        s = str(bin(len(n))[2:])
        answer[0] += 1
        if s == '1':
            break
    return answer