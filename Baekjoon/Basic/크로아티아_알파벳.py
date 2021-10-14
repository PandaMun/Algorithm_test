def croatia_alpha(x):
    x = list(x)
    answer = 0
    length = len(x)
    for i in range(2,len(x)):
        if x[i] == '=':
            if x[i-1] == 'z':
                if x[i-2] == 'd':
                    answer += 1
                    del x[i]
                    del x[i-1]
                    del x[i-2]
                    length -= 3
    for i in range(1,length):
        if x[i] == '=':
            if x[i-1] =='c':
                answer += 1
                del x[i]
                del x[i-1]
                length -= 2
            if x[i-1] =='s':
                answer += 1
                del x[i]
                del x[i-1]
                length -= 2
            if x[i-1] =='z':
                answer += 1
                del x[i]
                del x[i-1]
                length -= 2
        elif x[i] == 'j':
            if x[i-1] =='l':
                answer += 1
                del x[i]
                del x[i-1]
                length -= 2
            if x[i-1] =='n':
                answer += 1
                del x[i]
                del x[i-1]
                length -= 2
        elif x[i] == '-':
            if x[i-1] =='c':
                answer += 1
                del x[i]
                del x[i-1]
                length -= 2
            if x[i-1] =='d':
                answer += 1
                del x[i]
                del x[i-1]
                length -= 2
    print(x)

x = input()
croatia_alpha(x)