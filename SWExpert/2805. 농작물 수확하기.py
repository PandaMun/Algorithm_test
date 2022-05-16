answer = []
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N = int(input())
    crops = []
    for i in range(N):
        crops.append(list(map(int,input())))
    middle = N // 2 
    result = 0
    start = 0
    for i in range(middle):
        result += sum(crops[i][middle-start:middle+start+1])
        start += 1
    result += sum(crops[middle])
    end = start - 1
    for i in range(middle+1,len(crops)):
        result += sum(crops[i][middle-end:middle+end+1])
        end -= 1
    print(result)