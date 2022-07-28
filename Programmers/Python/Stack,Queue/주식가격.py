def solution(prices):
    answer = []
    for i in range(len(prices)):
        for j in range(i,len(prices)):
            # 가격이 떨어졌을떄 
            if prices[i] > prices[j] and i < j:
                answer.append(j-i)
                break
            # 마지막 까지 떨어지지 않았을떄
            elif i < j and j == len(prices) - 1:
                answer.append((len(prices) - 1) - i)
                break
    answer.append(0)           
    return answer

print(solution([1,2,3,2,3]))