def solution(new_id):
    symbol = ['-','_','.']
    answer = ''
    Level2 = []
    Level6 = []
    dot = []
    answer = ''
# Level 1
    Level1 = new_id.lower()
    
# Level 2
    for i in Level1:
        if i.isalpha():
            Level2.append(i)
        elif i.isdigit():
            Level2.append(i)
        elif i in symbol:
            Level2.append(i)
# Level 3
    Level3 = Level2
    for i in range(len(Level2) - 1):
        if Level2[i] == ".":
            if Level2[i+1] == ".":
                Level3[i] = '*'
    while('*' in Level3):
        Level3.remove('*')
#Level 4
    if Level3[0] == '.':
        del Level3[0]
    if len(Level3) > 0:    
        if Level3[-1] == '.':
            del Level3[-1]
#Level 5        
    if len(Level3) == 0:
        Level3.append('a')
#Level 6        
    if len(Level3) >= 16:
        Level6 = Level3[:15]
        if Level6[-1] == '.':
            del Level6[-1]
    else:
        Level6 = Level3
            
#Level 7            
    while(len(Level6) <= 2):
        Level6.append(Level6[-1])
        
    answer =  ''.join(Level6)
    return answer