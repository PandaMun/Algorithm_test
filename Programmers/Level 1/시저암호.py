def solution(s, n):
    answer = ''
    j = list(s)
    for s in j:
        if s == ' ':
            answer += s
        elif s.isupper():
            i = ord(s) + n
            if i >= 65 and i <= 90:
                answer += chr(i)
            else:
                answer += chr(i - 26)
        elif s.islower():
            i = ord(s) + n
            if i >= 97 and i <= 122:
                answer += chr(i)
            else:
                answer += chr(i - 26)
                
    return answer