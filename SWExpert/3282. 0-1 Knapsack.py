def check(weight,value,index):
    global best_value
    if weight > k:
        return
    if index == n:
        return 
    if value > best_value:
        best_value = value
    check(weight+bag[index][0], value+bag[index][1], index + 1)
    check(weight,value,index+1)

answer = []
seq = 0
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n,k = map(int,input().split())
    size = 0
    value = 0
    bag = []
    for i in range(n):
        bag.append(list(map(int,input().split())))
    best_value = 0
    check(0,0,0)
    
    print('#' +str(seq+1) + ' ' + str(best_value)) 
            