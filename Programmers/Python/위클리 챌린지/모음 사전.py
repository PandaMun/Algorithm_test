from itertools import product
def solution(word):
    words = []
    for i in range(1,6):
        words += (list(map(''.join,(product('AEIOU',repeat = i)))))
    words.sort()
    answer = words.index(word)
    return answer +1

print(solution("AAAAE"))
print(solution("AAAE"))
print(solution("I"))
print(solution("EIO"))