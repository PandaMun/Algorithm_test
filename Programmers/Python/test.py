# from itertools import permutations
# def solution(s):
#     for i in permutations(s):
#         print(i)
#     answer = []
#     return answer
answer = []
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    a,b,c,d = map(int,input().split())
    if (c >= b and c >= a) or (a >= d and a >= c):
        answer.append(0)
    else:
        answer.append(min(b,d) - max(a,c))

for i in range(len(answer)):
    print('#' + str(i+1) + ' ' + str(answer[i]))