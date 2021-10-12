def bignumber(a,b):
    a = int(a[::-1])
    b = int(b[::-1])
    if a > b:
        print(a)
    else:
        print(b)

a, b = input().split()
bignumber(a,b)
