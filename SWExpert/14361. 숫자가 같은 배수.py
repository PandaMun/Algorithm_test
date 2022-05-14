from itertools import permutations
T = int(input())
answer = []
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    ok = 0
    n = input()
    for i in list(map(''.join,permutations(n,len(n)))):
        result = int(i) / int(n)
        if result >= 2 and result % 1 == 0:
            answer.append('possible')
            ok = 1
            break
    if ok == 0:
        answer.append('impossible')
for i in range(len(answer)):
    print('#' + str(i+1) + ' ' + answer[i])
                    