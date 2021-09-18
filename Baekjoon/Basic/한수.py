def hansoo(n):
    answer = []
    for i in range(1,n+1):
        count = 0
        seq = []
        if i // 10 == 0:
            answer.append(i)
        else:
            i = str(i)
            for j in range(1,len(i)):
                seq.append(int(i[j-1]) - int(i[j]))
            for k in seq:
                if k == seq[0]:
                    count += 1
            if count == len(seq):
                answer.append(i)
    print(len(answer))
             
n = int(input())
hansoo(n)

        