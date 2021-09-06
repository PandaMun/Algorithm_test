def solution(phone_number):
    length = len(phone_number)
    star_length = length - 4
    answer = ('*' * star_length) + phone_number[-4:]
    return answer