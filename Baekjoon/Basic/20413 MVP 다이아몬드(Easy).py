month = int(input())
S,G,P,D = map(int,input().split())
MVP = list(input())
last_month = 0
result = 0
present_month = 0
for i in MVP:
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
    result += present_month
    last_month = present_month
print(result)