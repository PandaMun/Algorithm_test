s = input()
answer = ''
alphabet = 'abcdefghijklmnopqrstuvwxyz'
for i in alphabet:
    if i in s:
        answer += str(s.index(i)) + ' '
    else:
        answer += '-1 '
print(answer)

print(chr(97))