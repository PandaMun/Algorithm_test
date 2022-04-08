import math
answer = []
while(1):
    tri = list(map(int, input().split()))
    if tri[0] == 0 and tri[1] == 0 and tri[2] == 0:
        break
    long = max(tri)
    tri.remove(long)
    if long == int(math.sqrt((tri[0] ** 2) + (tri[1] ** 2))):
        answer.append('right')
    else:
        answer.append('wrong')
for i in answer:
    print(i)