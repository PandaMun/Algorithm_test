import sys
from itertools import permutations as pm
answer = []
input = sys.stdin.readline
count = int(input())
numbers = list(map(int, input().split()))
calc = list(map(int,input().split()))
formula = []
cal = []
n = []
for i in range(len(calc)):
    for j in range(calc[i]):
        if i == 0:
            cal.append('+')
        elif i == 1:
            cal.append('-')
        elif i == 2:
            cal.append('*')
        elif i == 3:
            cal.append('/')
print(cal)
for i in pm(cal,count-1):
    for j in range(len(i)):
        formula.append(numbers[j])
        formula.append(i[j])
    formula.append(numbers[-1])
print(formula)
            
    

    
    
    



