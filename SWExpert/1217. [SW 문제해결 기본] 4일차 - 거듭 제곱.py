answer = []
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
def squared(n,count,result):
    if count == 0:
        return result
    result *= n
    return squared(n,count-1,result)

for test_case in range(2):
    case = int(input())
    n,m= map(int,input().split())
    answer.append(squared(n,m,1))
for i in range(len(answer)):
    print('#' +str(i+1) + ' ' + str(answer[i]))