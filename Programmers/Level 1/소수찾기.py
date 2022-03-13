import math

def solution(n):
    answer = 0
    eratos = [True for i in range(n + 1)]
    '''에라토스테네스의 체'''
    for i in range(2,int(math.sqrt(n))+1):
        if eratos[i] == True:
            j = 2
            while(n >= i * j):
                eratos[i*j] = False
                j +=1
                
    for i in eratos:
        if i:
            answer += 1
    return answer - 2