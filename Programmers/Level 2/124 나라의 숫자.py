def solution(n):
    answer = ''
    while(1):
        if n % 3 == 0:
            answer += '4'
            n //= 3
            n -= 1
        else:
            answer += str(n%3)
            n //= 3
        if n == 0:
            return answer[::-1]