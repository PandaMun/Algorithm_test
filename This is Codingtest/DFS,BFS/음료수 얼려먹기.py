# N * M 크기의 얼음틀이 존재할때 구멍이 뚫려 있는 부분은 0, 
# 칸막이가 존재하는 부분은 1로 표시되는데 구멍이 뚫려 있는 부분은 
# 서로 연결되어 있는걸로 간주합니다.
# 이떄 얼음틀 모양이 주어졌을떄 생성되는 총 얼음의 개수를 구하시오
#          
#           00110
#           00011
#           11111
#           00000
#
#  위와 같은 경우 총 3개의 얼음이 생길수 있습니다.

# 코드

def DFS(x,y):
    if (0 <= x < n) and (0 <= y < m):
        if graph[x][y] == 0:
            graph[x][y] = 1
            DFS(x-1,y)
            DFS(x,y-1)
            DFS(x+1,y)
            DFS(x,y+1)
            return True
    return False

n, m = map(int,input().split())
graph = []
for i in range(n):
    graph.append(list(map(int,input())))

answer = 0

for i in range(n):
    for j in range(m):
        if DFS(i,j) == True:
            answer += 1
print(answer)

    