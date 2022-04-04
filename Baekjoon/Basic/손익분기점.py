import math
price = list(map(int,input().split(' ')))
loss = price[0]
count = 0
if price[1] > price[2]:
    count = -1
else:
    count = price[0] // (price[2] - price[1])+1
print(count)