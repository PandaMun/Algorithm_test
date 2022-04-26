seq = []
stack = []

rg = int(input())
for i in range(rg):
    seq.append(int(input()))

def stackseq(rg,seq):
    i = 0
    j = 1
    result = []
    while(i != rg):
        if len(stack) > 0:
            if seq[i] == stack[-1]:
                stack.pop()
                i += 1
                result.append('-')
            else:
                stack.append(j)
                result.append('+')
                j += 1
        else:
            stack.append(j)
            result.append('+')
            j += 1
        if j > rg+1:
            return 'NO'
    return result

answer = stackseq(rg,seq)
if answer == 'NO':
    print(answer)
else:
    for i in answer:
        print(i)