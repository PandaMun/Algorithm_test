count = int(input())
answer = 0
for i in range(count):
    sentence = input()
    alphabet = []
    for j in sentence:
        if len(alphabet) != 0:
            if j in alphabet and j != alphabet[-1]:
                break
            else:
                alphabet.append(j)
        else:
            alphabet.append(j)
        if len(alphabet) == len(sentence):
            answer +=1
     
print(answer)
