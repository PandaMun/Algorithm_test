answer = []
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    case = list(input())
    sentence = []
    sentence.append(case)
    max_len = len(case)
    for i in range(4):
        a = list(input())
        if len(a) > max_len:
            max_len = len(a)
        sentence.append(a)
    result = ''
    for i in range(max_len):
        for j in range(5):
            if len(sentence[j]) >= i+1 :
                result += (sentence[j][i])
    answer.append(result)
for i in range(len(answer)):
    print('#' +str(i+1) + ' ' + str(answer[i]))