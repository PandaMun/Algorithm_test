array = []
remain = []
for i in range(10):
    a = int(input())
    array.append(a)
    
for i in range(10):
     remain.append(array[i] % 42)
new_remain=[]

# new_remain안에 j값이 없다면 집어넣는 방식으로 중복을 제거 하였습니다.

for j in remain:
    if j not in new_remain:
        new_remain.append(j)

print(len(new_remain))
