answer = []
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    dx = [0,0,1,-1,1,-1,1,-1]
    dy = [1,-1,0,0,1,-1,-1,1]
    n,m = map(int,input().split())
    matrix = []
    for i in range(n):
        seq = []
        if i == (n//2)-1:
            seq += ([0]*((n//2)-1))
            seq += ([2,1])
            seq += ([0]*((n//2)-1))
        elif i == (n//2):
            seq += ([0]*((n//2)-1))
            seq += ([1,2])
            seq += ([0]*((n//2)-1))
        else:
            seq += [0]*n
        matrix.append(seq)
    for i in range(m):
        y,x,color = map(int,input().split())
        x-=1
        y-=1
        if color == 1:
            find_color = 2
        else:
            find_color = 1
        matrix[x][y] = color
        for i in range(8):
            nx = 0 + x
            ny = 0 + y
            find = []
            while(1):
                nx = nx + dx[i]
                ny = ny + dy[i]
                if 0 <= nx <= n-1 and 0 <= ny <= n-1:
                    if matrix[nx][ny] == find_color:
                        find.append([nx,ny])
                    elif matrix[nx][ny] == 0:
                        break
                    elif matrix[nx][ny] == color:
                        if len(find) != 0:
                            for i in find:
                                matrix[i[0]][i[1]] = color
                            break
                        else:
                            break
                            
                else:
                    break
    black = 0
    white = 0
    for i in (matrix):
        black += i.count(1)
        white += i.count(2)
    answer.append(str(black) + ' ' + str(white))
for i in range(len(answer)):
    print('#' +str(i+1) + ' ' + str(answer[i]))

