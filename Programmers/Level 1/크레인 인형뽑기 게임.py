def solution(board, moves):
    answer = 0
    bucket = []
    for i in moves:
        for j in range(0,len(board)):
            print(i)
            if board[j][i-1] != 0:
                if len(bucket) > 0 and bucket[-1] == board[j][i-1]:
                    del bucket[-1]
                    answer += 2
                else:
                    bucket.append(board[j][i-1])
                board[j][i-1] = 0
                break

    return answer