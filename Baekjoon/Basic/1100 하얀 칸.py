stack = 1
result = 0
for i in range(8):
    chess = list(input())
    if stack % 2 == 1:
        for j in range(0,7,2):
            if chess[j] == 'F':
                result += 1
    else:
        for j in range(1,8,2):
            if chess[j] == 'F':
                result += 1
    stack += 1
print(result)