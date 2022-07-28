def solution(n, m):
    answer = []
    gcd = 0
    for i in range(1,(max(n,m))+1):
        if n % i == 0 and m % i == 0:
            gcd = i
        
    answer.append(gcd)
    answer.append(((n*m)/gcd))
        
    return answer