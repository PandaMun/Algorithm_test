h, w = map(int, input().split())
check = []
answer = []
for i in range(h):
    check.append(input())
for a in range(h-7):
    for b in range(w-7):
        answer1 = 0
        answer2 = 0
        for i in range(a,a+8):
            for j in range(b,b+8):
                if (i + j) % 2 == 0:
                    if check[i][j] != 'W':
                        answer1 += 1
                    if check[i][j] != 'B':
                        answer2 += 1
                else:
                    if check[i][j] != 'B':
                        answer1 += 1
                    if check[i][j] != 'W':
                        answer2 += 1 
        print(answer1,answer2)
