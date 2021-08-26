HH, MM = map(int, input().split())



if(MM <= 44):
    MM = 60-(45-MM)
    if(HH == 0):
        HH = 23
    else:
        HH = HH - 1
else:
    MM = MM - 45

print(HH ,end=' ')
print(MM)