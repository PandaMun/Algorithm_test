def dial(x):
    answer = 0
    for i in x:
        if i == 'A' or i == 'B' or i == 'C':
            answer += 3
        elif i == 'D' or i == 'E' or i == 'F':
            answer += 4
        elif i == 'G' or i == 'H' or i == 'I':
            answer += 5
        elif i == 'J' or i == 'K' or i == 'L':
            answer += 6
        elif i == 'M' or i == 'N' or i == 'O':
            answer += 7
        elif i == 'P' or i == 'Q' or i == 'R' or i == 'S':
            answer += 8
        elif i == 'T' or i == 'U' or i == 'V':
            answer += 9
        elif i == 'W' or i == 'X' or i == 'Y' or i == 'Z':
            answer += 10
    print(answer)
x = input()
dial(x)
        
