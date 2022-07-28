n = int(input())
cal = input()
num = []
for i in range(n):
    num.append(int(input()))
number = []
cal = list(cal)
    
for i in range(len(cal)):
    a = cal.pop(0)
    if 'A' <= a <= 'Z':
        number.append(num[ord(a)-ord('A')])
    else:
        num1 = number.pop()
        num2 = number.pop()
        if a == '+':
            number.append(num2 + num1)
        elif a == '-':
            number.append(num2 - num1)
        elif a == '*':
            number.append(num2 * num1)
        elif a == '/':
            number.append(num2 / num1)
print('%.2f' %number[0])	
