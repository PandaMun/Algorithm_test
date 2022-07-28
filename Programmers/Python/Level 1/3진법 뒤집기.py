def solution(n):
    answer = 0
    ternary = ''
    while(n >= 3):
        ternary += str(int(n%3))
        n /= 3
    if n > 0:
        ternary += str(int(n%3))

    return int(ternary, 3)