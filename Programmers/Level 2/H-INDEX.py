def solution(citations):
    answer = 0
    citations.sort()
    for i in range(1,max(citations)+1):
        a = 0
        b = 0
        for j in citations:
            if j >= i:
                a += 1
            else:
                b += 1
        if a >= i and b <= i:
            answer = i
                   
    return answer