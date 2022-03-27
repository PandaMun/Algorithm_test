def solution(s):
    answer = True
    stack = 0
    for i in range(len(s)):
        if stack >= 0:
            if s[i] == "(":
                stack += 1
            else:
                stack -= 1

        else:
            return False
    if stack == 0:
        return True
    else:
        return False