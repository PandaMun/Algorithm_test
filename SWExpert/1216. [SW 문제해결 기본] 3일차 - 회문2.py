answer = []
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1):
    case = int(input())
    matrix = []
    rematrix = []
    result = []
    # matrix
    for i in range(100):
        matrix.append(list(input()))
    #90 도 회전 'rematrix'
    for i in range(len(matrix)):
        build = []
        for j in range(len(matrix)):
            build.append(matrix[j][i])
        rematrix.append(build)
    # rematrix, matrix 검사
    for i in range(len(matrix)):
        for j in range(100):
            for k in range(101-j):
                if ''.join(matrix[i][k:k+j]) == ''.join(reversed(matrix[i][k:k+j])):
                    result.append(j)
                if ''.join(rematrix[i][k:k+j]) == ''.join(reversed(rematrix[i][k:k+j])):
                    result.append(j)
    if len(result) == 0:
        answer.append(1)
    else:
        answer.append(max(result))
for i in range(len(answer)):
    print('#' +str(i+1) + ' ' + str(answer[i]))               
                
        