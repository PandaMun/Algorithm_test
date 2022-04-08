def factorial(answer, n):
    if n == 0:
        print(answer)
    else:
        answer *= n
        factorial(answer,n-1)
answer = 1
factorial(answer,int(input()))