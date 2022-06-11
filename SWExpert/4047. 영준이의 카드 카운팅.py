answer = []
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    case = input()
    result = ''
    card = []
    s = 0
    d = 0
    h = 0
    c = 0
    for i in range(0,len(case),3):
        if case[i:i+3] in card:
            result = 'ERROR'
            break
        else:
            card.append(case[i:i+3])
            if case[i] == 'S':
                s += 1
            elif case[i] == 'D':
                d += 1
            elif case[i] == 'H':
                h += 1
            elif case[i] == 'C':
                c += 1
    if result != 'ERROR':
        result = str(13-s) + ' ' + str(13-d) + ' ' + str(13-h) + ' ' + str(13-c)
    answer.append(result)
for i in range(len(answer)):
    print('#' +str(i+1) + ' ' + str(answer[i]))               
      