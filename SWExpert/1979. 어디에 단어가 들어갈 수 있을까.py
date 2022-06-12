answer = []
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n,k = map(int,input().split())
    matrix = []
    re_matrix = []
    result = 0
    for i in range(n):
        matrix.append(list(map(int,input().split())))
    for i in range(len(matrix)):
        array = []
        for j in range(len(matrix)):
            array.append(matrix[j][i])
        re_matrix.append(array)
    for i in range(len(matrix)):
        stack = 0
        re_stack = 0
        for j in range(len(matrix)):
            if matrix[i][j] == 1:
                stack += 1
                if (n-1) == j and stack == k:
                    print(matrix[i])
                    print('matrix')
                    result += 1
            else:
                if stack == k:
                    print(matrix[i])
                    print('matrix')
                    result += 1
                    stack = 0
                else:
                    stack = 0
        
            if re_matrix[i][j] == 1:
                re_stack += 1
                if (n-1) == j and re_stack == k:
                    print(re_matrix[i])
                    result += 1
            else:
                if re_stack == k:
                    print(re_matrix[i])
                    result += 1
                    re_stack = 0
                else:
                    re_stack = 0
    answer.append(result)
for i in range(len(answer)):
    print('#' +str(i+1) + ' ' + str(answer[i]))