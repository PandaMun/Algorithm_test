def CountAlpha(a):
    Max_size= []
    smallletter = 'abcdefghijklmnopqrstuvwxyz'
    bigletter = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    alphabet = {}
    for i in bigletter:
        alphabet[i] = 0
    for i in a:
        for j in range(26):
            if(i==smallletter[j] or i==bigletter[j]):
                alphabet[bigletter[j]] += 1
    max_value = max(alphabet.values())
    for key,value in alphabet.items():
        if value == max_value:
            Max_size.append(key)
    if len(Max_size) < 2:
        print(Max_size[0])
    else:
        print('?')

                

A = input()
CountAlpha(A)