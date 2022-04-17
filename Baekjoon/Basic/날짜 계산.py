import sys
input = sys.stdin.readline
e,s,m = map(int,input().split())
check = [1,1,1]
answer = 1
while(1):
    if check[0] == e and check[1] == s and check[2] == m:
        break
    else:
        for i in range(len(check)):
            check[i] += 1
        if check[0] > 15:
            check[0] = 1
        if check[1] > 28:
            check[1] = 1
        if check[2] > 19:
            check[2] = 1
        answer += 1
print(answer)
    