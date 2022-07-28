# from itertools import permutations
# n,k = map(int,input().split())
# monster = list(map(int,input().split()))
# citizen = list(map(int,input().split()))
# quest = []
# for i in range(len(monster)):
#     quest.append([monster[i],citizen[i]])
# answer = 0 
# for i in (list(permutations(quest,n))):
#     life = k
#     stack = 0
#     result = 0
#     for j in range(n):
#         if life - (i[j][0] + stack) < 0:
#             break
#         else:
#             life -= (i[j][0] + stack)
#             stack += i[j][0]
#             result += i[j][1]
#     if result > answer:
#         answer = result
# print(answer)
n,k = map(int,input().split())
monster = list(map(int,input().split()))
citizen = list(map(int,input().split()))
quest = []
for i in range(len(monster)):
    quest.append([monster[i],citizen[i]])
quest.sort(key=lambda x: (x[0], x[1]))
stack = 0
seq = 0
result = 0
for i in range(len(quest)):
    if k - (quest[i][0] + stack) < 0:
        break
    else:
        k -= (quest[i][0] + stack)
        stack += quest[i][0]
        result += quest[i][1]
print(result)