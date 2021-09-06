def solution(x):
    arr = 0
    type_x = str(x)
    for i in type_x:
        arr += int(i)
    return x % arr == 0