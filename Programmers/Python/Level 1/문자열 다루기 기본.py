def solution(s):
    if len(s) == 4 or len(s) == 6:
        return str.isdigit(s)
    else:
        return False