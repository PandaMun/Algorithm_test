# 50점
# import sys
# input = sys.stdin.readline
# S = input()
# case = []
# result = []

# for i in range(int(input())):
#     a,l,r = input().split()
#     l = int(l)
#     r = int(r)
#     answer = [0]
#     for i in S:
#         if i == a:
#             answer.append(answer[-1] + 1)
#         else:
#             answer.append(answer[-1])
#     result.append(answer[r+1]-answer[l])
# for i in result:
#     sys.stdout.write(str(i)+'\n')
    
# 100점
import sys
input = sys.stdin.readline
S = input()
case = []
answer = []
result = []

def test(S,case):
    for i in 'abcdefghijklmnopqrstuvwxyz':
        count = 0
        a = []
        for j in S:
            if j == i:
                count += 1
            a.append(count)
        case.append(a)
    return case
case = test(S,case)
for i in range(int(input())):
    a,l,r = input().split()
    l = int(l)
    r = int(r)
    test = case[ord(a)-97]
    if S[l] == a:
        result.append(test[r]-test[l]+1)
    else:
        result.append(test[r]-test[l])
for i in result:
    print(i)