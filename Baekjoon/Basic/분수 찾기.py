# fountain = [1,1]
# for i in range(int(input()) - 1):
#     if fountain[1] == 1 and fountain[0] % 2 == 0:
#         fountain[0] = fountain[0] + 1
#         order = 1
#     elif fountain[0] == 1 and fountain[1] % 2 == 1:
#         fountain[1] += 1
#         order = 0
#     else:
#         if order == 1:
#             fountain[1] += 1
#             fountain[0] -= 1
#         else:
#             fountain[1] -= 1
#             fountain[0] += 1
    
# print(str(fountain[0])+'/'+str(fountain[1]))    

# 시간 초과후 다시 작성
count = int(input())
n = 1
order = 1
counts = 0
while(count > n):
    count -= n
    n += 1
    counts += 1
    if order == 1:
        order = 0
    else:
        order = 1
if order == 1:
    print(str((counts + 1) - (count - 1)) + '/' + str(count))
else:
    print(str(count) + '/' + str((counts + 1) - count + 1))
    