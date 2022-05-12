from itertools import permutations
def solution(k, dungeons):
    answer = []
    for i in permutations(dungeons,len(dungeons)):
        result = 0
        count = k
        for j in i:
            if count >= j[0]:
                result += 1
                count -= j[1]
        answer.append(result)
    return max(answer)

print(solution(80,[[80,20],[50,40],[30,10]]))