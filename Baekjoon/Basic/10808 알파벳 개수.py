answer = [0,0,0,0,0,0,0,0,0,0,
          0,0,0,0,0,0,0,0,0,0,
          0,0,0,0,0,0]
for i in input():
    answer[ord(i)-97] += 1
answer = list(map(str,answer))
print(' '.join(answer))