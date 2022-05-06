import sys
input = sys.stdin.readline
answer = []
for i in range(int(input())):
    cnt = int(input())
    tree = list(map(int,input().split()))
    tree.sort(reverse= True)
    standard1 = tree[0]
    standard2 = tree[0]
    result = []
    del tree[0]
    seq = 1
    while(1):
        if seq % 2 == 1:
            result.append(standard1-tree[0])
            standard1 = tree[0]
            del tree[0]
        else:
            result.append(standard2-tree[0])
            standard2 = tree[0]
            del tree[0]
        seq += 1
        if seq >= cnt:
            break
    result.append(abs(standard1-standard2))
    answer.append(max(result))
for i in answer:
    print(i)