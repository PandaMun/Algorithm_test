def solution(priorities, location):
    count  = 1
    while(len(priorities) != 0):
        # 맨 첫번째가 가장 큰수 체크
        # 맞다면
        if priorities[0] != max(priorities):
            priorities.append(priorities.pop(0))
            if location == 0:
                location = len(priorities) - 1 
            else:
                location -= 1
        # 아니라면
        else:
            if location == 0:
                return count 
            else:
                priorities.pop(0)
                count += 1
                location -= 1
                # test #
                print(priorities)
                print(location)
                print(count)
                print(len(priorities))

    return len(priorities)