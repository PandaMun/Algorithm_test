month = int(input())
S,G,P,D = map(int,input().split())
MVP = list(input())
last_month = 0
result = 0
present_month = 0
print(MVP)
for i in MVP:
    print(i)
    if i == 'B':
        present_month = (S - 1) - last_month
    elif i == 'S':
        present_month = (G - 1) - last_month
    elif i == 'G':
        present_month = (P - 1) - last_month
    elif i == 'P':
        present_month = (D - 1) - last_month
    elif i == 'D':
        present_month = D
    print("저번달")
    print(last_month)
    print("이번달 지른돈")
    print(present_month)
    print('-----')
    result += present_month
    last_month = present_month
print(result)