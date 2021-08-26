A = int(input())
B = int(input())
C = int(input())
Zero = 0 
one = 0 
two = 0 
three = 0 
four  = 0 
five = 0 
six = 0 
seven = 0 
eight = 0 
nine = 0 

array =[]
number = (A*B*C)
while number!=0:
    value = number%10 
    number = number // 10
    array.append(value)

for i in array:
    if(i==0):
        Zero +=1
    elif(i==1):
        one +=1
    elif(i==2):
        two+=1
    elif(i==3):
        three+=1
    elif(i==4):
        four += 1
    elif(i==5):
        five += 1
    elif(i==6):
        six += 1
    elif(i==7):
        seven+=1
    elif(i==8):
        eight +=1
    else :
        nine += 1

print(Zero)
print(one)
print(two)
print(three)
print(four)
print(five)
print(six)
print(seven)
print(eight)
print(nine)