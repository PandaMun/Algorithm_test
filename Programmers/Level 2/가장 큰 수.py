def solution(numbers):
    numbers = list(map(str,numbers))
    #number의 자리수가 최대 1000이기 때문에 3을 곱하여
    #자리수를 맞혀주는게 이번 문제의 핵심입니다.
    numbers.sort(key = lambda x : x * 3,reverse = True)
    return str(int(''.join(numbers)))