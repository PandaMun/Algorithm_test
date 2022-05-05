def solution(n):
    answer = 0
    for i in range(1,n+1):
        result = 0
        for j in range(i,n+1):
            result += j
            if result >= n:
                if result == n:
                    answer += 1
                break

    return answer