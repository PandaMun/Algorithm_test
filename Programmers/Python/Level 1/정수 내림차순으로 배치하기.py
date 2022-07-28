n = int(input())

def solution(n):
    n = list(str(n))
    n.sort(reverse = True)
    answer = "".join(n)
    return int(answer)

print(solution(n))
