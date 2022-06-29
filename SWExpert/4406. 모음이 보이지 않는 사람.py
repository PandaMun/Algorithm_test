answer = []
T = int(input())
vowel = ['a','e','i','o','u']
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    word = input()
    result = ''
    for i in word:
        if i not in vowel:
            result += i
    answer.append(result)    
for i in range(len(answer)):
    print('#' +str(i+1) + ' ' + str(answer[i]))

