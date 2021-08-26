YY = int(input())

if( (YY%4 ==0 and YY%100 != 0 ) or (YY%400 == 0)):
    print(1)
else:
    print(0)