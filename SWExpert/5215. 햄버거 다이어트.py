answer = []
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
def dfs(index,summary,weight):
    global best
    if weight > L:
        return 
    if summary > best:
        best = summary
    if index > N:
        return
    dfs(index+1,summary+kinds[index][0],weight+kinds[index][1])
    dfs(index+1,summary,weight)

for test_case in range(1, T + 1):
    N,L = map(int,input().split())
    kinds = [[0,0]]
    for i in range(N):
        kinds.append(list(map(int,input().split())))
    best = 0
    dfs(0,0,0)
    answer.append(best)

for i in range(len(answer)):
    print('#' +str(i+1) + ' ' + str(answer[i]))         