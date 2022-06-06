answer = []
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    word1 = list(input())
    word2 = word1[:]
    word2.reverse()
    if word1[0:len(word1)//2] == word2[0:len(word2)//2]:
        answer.append(str(1))
    else:
        answer.append(str(0))
for i in range(len(answer)):
    print('#' +str(i+1) + ' ' + str(answer[i]))