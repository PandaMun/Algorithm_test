ages = []
member = []
answer = []
for i in range(int(input())):
    age,name = input().split()
    member.append((int(age),name))
member.sort(key = lambda x : x[0] )
print(member)
    

            
    
    
    