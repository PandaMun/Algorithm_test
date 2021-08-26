N = int(input())

array = list(map(int , input().split()))
A = array[0]
B = array[0]  

for i in range(0,N):
      
    if(A<array[i]):
        A = array[i]
    if(B>=array[i]):
        B = array[i]


print(B,end=' ')
print(A)
    

