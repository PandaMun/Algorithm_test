import math
n = int(input())
a = list(map(int,input().split()))
main_dir, sub_dir = map(int, input().split())
sum = 0
for i in range(n):
    remain = a[i] - main_dir
    if remain > 0:
        count = math.ceil(remain / sub_dir)
        print(count)
        sum += (count + 1)
    else:
        sum += 1
print(sum)