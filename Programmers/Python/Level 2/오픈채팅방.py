def solution(record):
    nick_name = {}
    answer = []
    for i in record:
        records = i.split()
        if records[0] == 'Enter':
            answer.append(records[1]+"/"+ "님이 들어왔습니다.")
            nick_name[records[1]] = records[2]
        elif records[0] == 'Leave':
            answer.append(records[1]+"/" + "님이 나갔습니다.")
        else:
            nick_name[records[1]] = records[2]
    for i in range(len(answer)):
        j = (answer[i].split("/"))
        answer[i] = answer[i].replace(j[0]+'/', nick_name[j[0]])

    return answer

