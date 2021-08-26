loop = int(input())
value = []
a = 1
for i in range(0,loop):
    a, b = input().split()
    c = int(a)+int(b)
    value.append(c)

for i in value:
    print(i)
    
