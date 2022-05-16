answer = []
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1):
    n = int(input())
    matrix = []
    result = []
    for i in range(100):
        a = list(map(int,input().split()))
        matrix.append(a)
        result.append(sum(a)) # 가로 합
    for i in range(100): # 세로 합
        length = 0
        for j in range(100):
            length += matrix[j][i]
        result.append(length)
                    
    cross1 = 0
    cross2 = 0
    for i in range(100): 
        cross1 += matrix[i][i] # 왼쪽 대각선
        cross2 += matrix[0+i][99-i] # 오른쪽 대각선
    result.append(cross1)
    result.append(cross2)
    answer.append(max(result))
    
for i in range(len(answer)):
    print('#' +str(i+1) + ' ' + str(answer[i]))               
          