answer = []
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1):
    table_size = int(input())
    table = []
    re_table = []
    result = 0
    for i in range(100):
        table.append(list(map(int,input().split())))
    #90 도 회전 'rematrix'
    for i in range(len(table)):
        build = []
        for j in range(len(table)):
            build.append(table[j][i])
        re_table.append(build)
    for i in re_table:
        present = 0
        for j in i:
            if j == 1:
                present =1 
            elif j == 2 and present == 1:
                present = 0 
                result += 1
    answer.append(result)
for i in range(len(answer)):
    print('#' +str(i+1) + ' ' + str(answer[i]))               
                
        