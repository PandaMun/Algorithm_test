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
    print(suffle1,suffle2)