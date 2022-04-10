numbers = []
answer = ''
for i in range(int(input())):
    numbers.append(list(map(int,input().split())))
    
for i in range(len(numbers)):
    rank = 1
    for j in range(len(numbers)):
        if i != j:
            if numbers[i][0] < numbers[j][0] and numbers[i][1] < numbers[j][1]:
                rank += 1
    answer += str(rank)
    if i != len(numbers) - 1:
        answer += ' '
print(answer)
