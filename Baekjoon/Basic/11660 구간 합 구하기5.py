import sys
input = sys.stdin.readline
matrix = []
answer = []
cnt, case = map(int,input().split())
for i in range(cnt):
    matrix.append(list(map(int, input().split())))
for i in range(case):
    c = []
    result = 0
    rg = list(map(int,input().split()))
    start = [rg[0],rg[1]]
    end = [rg[2],rg[3]]
    front = start[1]
    while(start != end):
        result += matrix[start[0]-1][start[1]-1]
        if start[1] == end[1]:
            start[0] += 1
            start[1] = front
        else:
            start[1] += 1
    result += (matrix[start[0]-1][start[1]-1])
    answer.append(result)
for i in answer:
    print(i)