def StringRepeat(S,R):
    P = ''
    for i in S:
            P += i*R
    return P


T = int(input())
p = []
for i in range(T):
    R,S = input().split()
    p.append(StringRepeat(S,int(R)))
for i in p:
    print(i)