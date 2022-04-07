number = int(input())
answer = []
while(number > 1):
    for i in range(2,number+1):
        if number % i == 0:
            print(i)
            number = number // i
            break

                
    
