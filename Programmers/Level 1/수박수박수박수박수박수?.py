def solution(n):
    answer = ''
    if n % 2 == 0:
        count = n // 2 
        answer = '수박' * count
    else:
        count = (n-1)//2
        answer = ('수박' * count) + '수'
    return answer