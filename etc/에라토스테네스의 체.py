x = int(input())

def PrimeNumber(x):
    for i in range(2,x):
        if (x % i == 0):
            print("False")
        else:
            print("True")


PrimeNumber(x)