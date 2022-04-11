sentence = []
for i in range(int(input())):
    sentence.append(input())
sentence = list(set(sentence))
sentence.sort()
sentence.sort(key=len)
for i in sentence:
    print(i)
    