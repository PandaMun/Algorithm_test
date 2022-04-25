import sys
answer = []
sentence = []
while(1):
    stack = []
    sentence = input()
    if sentence == ".":
        break
    for i in sentence:
        if i == "(":
            stack.append("(")
        if i == "[":
            stack.append("[")
        if i == ")":
            if len(stack) == 0:
                answer.append('no')
                break
            else:
                if stack[-1] == "(":
                    stack.pop()
                else:
                    answer.append('no')
                    break
        if i == "]":
            if len(stack) == 0:
                answer.append('no')
                break
            else:
                if stack[-1] == "[":
                    stack.pop()
                else:
                    answer.append('no')
                    break
        if i == "." and len(stack) == 0:
            answer.append('yes')      
        elif i == "." and len(stack) > 0:
            answer.append('no')
for i in answer:
    print(i)