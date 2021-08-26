array = []
realNumber = 1

for i in range(0,9):
    array.append(int(input()))
number = 1
Max = array[0]
for i in array:
    if(i>Max):
        Max = i
        realNumber = number
    
    number += 1

print(Max)
print(realNumber)