S = input()
a = S[0]
answer = []
zero = 0
one = 0
cnt = ''
for i in S:
    if a == i:
        cnt += i
    else:
        answer.append(cnt)
        a = i
        cnt = a
answer.append(cnt)
for i in answer:
    if i[0] == '0':
        zero += 1
    else:
        one += 1
print(min(zero,one))
