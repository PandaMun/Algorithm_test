dice = list(map(int,input().split()))
number = 0
sameCount = 0
for i in dice:
    if sameCount < (dice.count(i)):
        sameCount = dice.count(i)
        number = i
if sameCount == 3:
    print(10000 + (number * 1000))
elif sameCount == 2:
    print(1000 + (number * 100))
else:
    print(max(dice) * 100)