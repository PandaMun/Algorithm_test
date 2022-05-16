answer = []
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    length = int(input())
    matrix = []
    rematrix = []
    result = 0
    # matrix
    for i in range(8):
        matrix.append(list(input()))
    #90 도 회전 'rematrix'
    for i in range(len(matrix)):
        build = []
        for j in range(len(matrix)):
            build.append(matrix[j][i])
        rematrix.append(build)
    size = length // 2
    # rematrix, matrix 검사
    for i in range(len(matrix)):
        for j in range(8-length+1):
            if ''.join(matrix[i][j:j+length]) == ''.join(reversed(matrix[i][j:j+length])):
                result += 1
            if ''.join(rematrix[i][j:j+length]) == ''.join(reversed(rematrix[i][j:j+length])):
                result += 1
                
    answer.append(result)
for i in range(len(answer)):
    print('#' +str(i+1) + ' ' + str(answer[i]))               
                
        