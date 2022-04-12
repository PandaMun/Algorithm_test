answer = []
floor = []
room = []
a = []
for i in range(int(input())):
    floor.append(int(input()))
    room.append(int(input()))
for i in range(1,max(room)+1):
    a.append(i)
answer.append(a)
for i in range(max(floor)):
    a = []
    for j in range(max(room)):
            a.append(sum(answer[i][0:j+1]))
    answer.append(a)
print(answer)
for i in range(len(floor)):
    print(answer[floor[i]][room[i]-1])
            
        
        
        
        
        
        