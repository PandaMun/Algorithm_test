
n, m, k = map(int, input().split())
data = list(map(int, input().split()))
result = 0
init = 0
data.sort(reverse=True)
for i in range(m):
    if init == k:
        result += data[1]
        init = 0
    else:
        result += data[0]
        init += 1

print(result)





