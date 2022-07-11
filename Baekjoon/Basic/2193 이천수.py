n = int(input())
pinary = [0,1,1]
for i in range(3,n+1):
    pinary.append(pinary[-2]+pinary[-1])
print(pinary[n])