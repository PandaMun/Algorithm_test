number = input()
set = []
result = 0
for i in number:
    if i in set:
        set.remove(i)
    else:    
        if i == '9' or i == '6':
            if '6' in set:
                set.remove('6')
                continue
            elif '9' in set:
                set.remove('9')
                continue
        for j in range(10):
            set.append(str(j))
        result += 1
        set.remove(str(i))
print(result)