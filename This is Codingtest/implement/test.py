T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
answer = []
for test_case in range(1, T + 1):
    n = list(input())
    case = []
    case += n
    case.sort()
    min = case
    case = []
    case += n
    case.sort(reverse=True)
    max = case
    if n == min:
        minimum = ''.join(n)
    else:
        for i in range(min.count('0')):
            min.remove(0)
        seq = 0
        for i in len(min):
            if min[i] != n[i]:
                first = i
                change = n[i]
        for i in range(len(n)-1,0,-1):
            if n[i] == min[first]:
                del n[i]
                n.insert(i,change)
                n.ins
                
            
            
        
    if n == max:
        maximum = ''.join(n)
    
    
print(minimum)
# answer = []
# T = int(input())
# # 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
# for test_case in range(1, T + 1):
#     n = int(input())
#     box = []
#     x = []
#     y = []
#     for i in range(n):
#         box.append(list(input().split()))
#     for i in range(len(box)):
#         for j in range(len(i)):
#             if j == '#':
#                 x.append(j)
#                 y.append(i)
        
            
                
            