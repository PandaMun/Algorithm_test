def solution(answers):
    number1 = [1,2,3,4,5]
    number2 = [2,1,2,3,2,4,2,5]
    number3 = [3,3,1,1,2,2,4,4,5,5]
    result1 = 0
    result2 = 0
    result3 = 0
    for i in range(len(answers)):
        if answers[i] == number1[i%5]:
            result1 += 1
        if answers[i] == number2[i%8]:
            result2 += 1
        if answers[i] == number3[i%10]:
            result3 += 1
    
    answer = []
    result = [result1,result2,result3]
    if max(result) == result1:
        answer.append(1)
    if max(result) == result2:
        answer.append(2)
    if max(result) == result3:
        answer.append(3)
    return answer