answer = [0,0,0,0,0,0,0,0,0,0,
          0,0,0,0,0,0,0,0,0,0,
          0,0,0,0,0,0]
for i in input():
    if i.isalpha:
        answer[ord(i)-97] += 1
answer = list(map(str,answer))
result = ' '.join(answer)
print(result)