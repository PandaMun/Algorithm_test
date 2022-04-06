import math

killogram = int(input())
if killogram <= 4:
    if killogram % 3 == 0:
        print(killogram // 3)
    else:
        print(-1)
else:
    for i in range((killogram//5), -1, -1):
        if (killogram - (i*5)) % 3 == 0:
            print(int((killogram - (i*5)) / 3) + i)
            break
        if (i == 0):
            print(-1)
            break
    