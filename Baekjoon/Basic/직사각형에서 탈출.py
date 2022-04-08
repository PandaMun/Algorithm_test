a,b,c,d = list(map(int, input().split()))
answer = [a,b,c-a,d-b]
print(min(answer))
