
    
answer = [0,1]
j = 1
count = int(input())
for i in range(count):
    answer.append(answer[j-1]+answer[j])
    j += 1
print(answer[count])