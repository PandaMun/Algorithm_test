value_list = []
infinity = 1
index = 0

while infinity:
    a ,b = map(int, input().split())
    value_list.append(a+b)
    if(a==0 and b==0):
        break
    print(value_list[index])
    index +=1



