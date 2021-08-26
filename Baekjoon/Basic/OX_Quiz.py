count = int(input())
OX = []
for i in range(count):
    OX.append(list(input()))

for i in range(count):
    score = 0
    stack = 0
    length = int(len(OX[i]))
    for j in range(length):
        if OX[i][j] == "O":
            if j >= 1:
                if OX[i][j-1] =="O":
                    stack +=1
                else:
                    stack = 0
            score += 1
            score += stack
    print(score)



            
        
