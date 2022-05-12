def solution(price, money, count):
    want = 0
    for i in range(1, count+1):
        want += i * price

    if money - want > 0:
        return 0
    else:
        return (money - want) * -1
