import sys
number = 0
T = int(sys.stdin.readline())
A_value = []
B_value = []
Total_Value=[]

for i in range(0, T):

    a, b = map(int, sys.stdin.readline().split())
    A_value.append(a)
    B_value.append(b)
    Total_Value.append(a+b)

for i in range(0, T):
    print("Case #%d"%(number+1)+":", A_value[number],"+",B_value[number], "=", Total_Value[number])
    number += 1
