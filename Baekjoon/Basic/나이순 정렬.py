import sys
input = sys.stdin.readline
ages = []
member = []
answer = []
for i in range(int(input())):
    age,name = input().split()
    member.append((int(age),name))
member.sort(key = lambda x : x[0] )
for i in member:
    print(str(i[0]) +' ' + i[1])
    

            
    
    
    