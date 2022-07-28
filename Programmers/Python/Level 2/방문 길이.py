def solution(dirs):
    answer = 0
    track = []
    position = [0,0]
    for i in dirs:        
        a = []
        present = str(position)
        a.append(present)
        if i == 'U':
            if position[1] + 1 <= 5:
                position[1] += 1
            else:
                continue
        elif i == 'D':
            if position[1] - 1 >= -5 :
                position[1] -= 1
            else:
                continue
        elif i == 'R':
            if position[0] + 1 <= 5:
                position[0] += 1
            else:
                continue
        else:
            if position[0] - 1 >= -5:
                position[0] -= 1
            else:
                continue
        a.append(str(position))
        a.sort()
        if a not in track:
            track.append(a)

    return len(track)