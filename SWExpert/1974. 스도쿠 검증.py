answer = []
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
a = [1,2,3,4,5,6,7,8,9]
for test_case in range(1, T + 1):
    matrix = []
    result = []
    for i in range(9):
        array = list(map(int,input().split()))
        matrix.append(array)
        result.append(array)
    stack = 0
    matrix1 = []
    matrix2 = []
    matrix3 = []
    for i in range(len(matrix)):
        matrix1 += matrix[i][0:3]
        matrix2 += matrix[i][3:6]
        matrix3 += matrix[i][6:9]
        stack += 1
        if stack == 3:
            stack = 0
            result.append(matrix1)
            result.append(matrix2)
            result.append(matrix3)
            matrix1 = []
            matrix2 = []
            matrix3 = []
        b = []
        for j in range(len(matrix)):
            b.append(matrix[j][i])
        result.append(b)
    cnt = 0
    for i in result:
        i.sort()
        if i == a:
            cnt += 1
    if cnt == 27:
        answer.append(1)
    else:
        answer.append(0)
for i in range(len(answer)):
    print('#' +str(i+1) + ' ' + str(answer[i]))               
                 