answer = []
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    result = [[],[],[]]
    n = int(input())
    array = []
    for i in range(n):
        array.append(list(input().split()))
    stack = 0
    while(stack != 3):
        new_array = []
        for i in range(n):
            a = []
            for j in range(n-1,-1,-1):
                a.append(array[j][i])
            new_array.append(a)
            result[stack].append(''.join(a))
        array = new_array    
        stack += 1
    print('#' + str(test_case))
    for i in range(n):
        a = []
        for j in range(3):
            a.append(result[j][i])
        print(' '.join(a))
        

