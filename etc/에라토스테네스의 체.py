def PrimeNumber():
    answer = []
    for i in range(1,100):
         number = 0
         answer.append(i)
         number += i
         i = str(i)
         for j in i:
             number += int(j)
         if number in answer:
             answer.remove(number)
    for i in answer:
        print(i)

        




PrimeNumber()