def d():
    answer = set(range(1,10001))
    for i in range(1,10001):
         number = 0
         number += i
         i = str(i)
         for j in i:
             number += int(j)
         if number in answer:
             answer.remove(number)
    for i in answer:
        print(i)
    
    
d()