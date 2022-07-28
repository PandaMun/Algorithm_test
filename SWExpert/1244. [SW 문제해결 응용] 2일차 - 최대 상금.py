answer = []
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    result = []
    n,count = map(int,input().split())
    n = list(str(n))
    max_n = []
    max_n += n
    max_n.sort(reverse=True)
        
def dfs(num,count):
    if count == 0:
        return max(result)
    else:
        for i in range(len(num)):





