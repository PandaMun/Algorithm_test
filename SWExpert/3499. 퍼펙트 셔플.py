answer = []
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    seq = int(input())
    card = list(input().split())
    if seq % 2 == 1:
       half = (seq // 2) + 1
    else:
        half = seq // 2
    suffle1 = card[0:half]
    suffle2 = card[half:]
    result = []
    for i in range(len(suffle2)):
        result.append(suffle1[i])
        result.append(suffle2[i])
    if len(suffle2) != half:
        result.append(suffle1[-1])
    answer.append(' '.join(result))
for i in range(len(answer)):
    print('#' +str(i+1) + ' ' + str(answer[i]))
