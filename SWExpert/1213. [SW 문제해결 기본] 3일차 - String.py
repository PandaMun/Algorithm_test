answer = []
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(10):
    case = int(input())
    find = input()
    sentence = input()
    sentence = sentence.split(find)
    answer.append(len(sentence)-1)
for i in range(len(answer)):
    print('#' +str(i+1) + ' ' + str(answer[i]))               
          