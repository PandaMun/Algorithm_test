answer = []
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    dx = [0,1,0,-1]
    dy = [1,0,-1,0]
    case = int(input())
    matrix = []
    for i in range(case):
        a = [0] * case
        matrix.append(a)
    x = 0
    y = 0
    i = 0
    seq = 1
    cnt = 0
    while(1):
        matrix[x][y] = str(seq)
        x += dx[i]
        y += dy[i]
        seq += 1
        if 0 <= x < case and 0 <= y < case:
            if matrix[x][y] != 0:
                x -= dx[i]
                y -= dy[i]
                if i == 3:
                    i = 0
                else:
                    i += 1
                x += dx[i]
                y += dy[i]
        else:
            x -= dx[i]
            y -= dy[i]
            if i == 3:
                i = 0
            else:
                i += 1
            x += dx[i]
            y += dy[i]
        if seq == (case * case)+1:
            break
    print('#' +str(test_case))
    for i in matrix:
        print(' '.join(i))



