import math

count = int(input())
rings = list(map(int,input().split()))
standard = rings[0]
del rings[0]
for i in rings:
    print(str(standard // math.gcd(standard,i)) + '/' + str(i // math.gcd(standard,i)))
    