answer = []
T = int(input())
number = {"ZRO":0, "ONE":1, "TWO":2, "THR":3, "FOR":4, "FIV":5, "SIX":6, "SVN":7, "EGT":8, "NIN":9}
numbers = ["ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"]
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(T):
    a,seq = input().split()
    case = list(input().split())
    recase = []
    for i in case:
        recase.append(number[i])
    recase.sort()
    result = []
    for i in recase:
        result.append(numbers[i])
    answer.append(' '.join(result))
for i in range(len(answer)):
    print('#' +str(i+1) + ' ' + str(answer[i]))          