def solution(num):
    count = 0
    for i in range(500):
        if num == 1:
            return count

        if num % 2 == 0:
            num = num // 2
            count += 1
        else:
            num = (num * 3) + 1
            count += 1
    if num != 0:
        return -1