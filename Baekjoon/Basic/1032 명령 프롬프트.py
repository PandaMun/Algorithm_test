file = []
answer = ''
for i in range(int(input())):
    file.append(input())
for i in range(len(file[0])):
    for j in range(len(file)):
        if file[0][i] != file[j][i]:
            answer += '?'
            break
        if j == len(file) - 1:
            answer += file[0][i]
print(answer) 
        