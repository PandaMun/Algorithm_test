answer = []

while(1):
    n = input()
    if n == '0':
        break
    if n == ''.join(reversed(n)):
        answer.append('yes')
    else:
        answer.append('no')
for i in answer:
    print(i)