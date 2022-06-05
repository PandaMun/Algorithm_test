N = int(input())
answer = []
for i in range(1,N+1):
    clap = 0
    clap += str(i).count('3')
    clap += str(i).count('6')
    clap += str(i).count('9')
    if clap == 0:
        answer.append(str(i))
    else:
        count = ''
        for i in range(clap):
            count += '-'
        answer.append(count)
print(' '.join(answer))