def croatia_alpha(x):
    answer = 0
    alphabet = ['dz=','c=', 'c-', 'd-', 'lj', 'nj', 's=', 'z=']
    length = len(x)
    for i in alphabet:
        if i in x:
            answer += x.count(i)
            x = x.replace(i,(' '*len(i)))
            
    print(answer + (length - x.count(' ')))



x = input()
croatia_alpha(x)