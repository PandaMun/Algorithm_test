answer = []
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(10):
    n,case = map(int,input().split())
    case = list(str(case))
    seq = 0
    while(1):
        if len(case) -1 == seq:
            answer.append(int(''.join(case)))
            break
        else:
            if case[seq] == case[seq+1]:
                if seq > 0:
                    del case[seq:seq+2]
                    seq -= 1
                else:
                    del case[seq:seq+2]
            else:
                seq += 1
for i in range(len(answer)):
    print('#' +str(i+1) + ' ' + str(answer[i]))