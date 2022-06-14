def solution(n, words):
    answer = []
    sentence = []
    seq = 1
    cycle = 1
    for i in range(len(words)):
        if i == 0:
            said = words[i]
            sentence.append(words[i])
        else:
            if said[-1] == words[i][0]:
                if words[i] in sentence:
                    return [seq,cycle]
                else:
                    said = words[i]
                    sentence.append(words[i])
                
            else:
                return [seq,cycle]
        seq += 1
        if seq == n+1:
            seq = 1
            cycle += 1
    return [0,0]