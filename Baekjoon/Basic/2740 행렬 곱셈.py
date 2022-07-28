n,m = map(int,input().split())
matrix_A = []
matrix_B = []
for i in range(n):
    matrix_A.append(list(map(int,input().split())))
m,k = map(int,input().split())
for i in range(m):
    matrix_B.append(list(map(int,input().split())))
for i in range(n):
    for j in range(k):
        
