a = int(input())

for i in range(0, a):
    space = a - (i+1)
    print(" " * space + ("*" * (i+1)))
