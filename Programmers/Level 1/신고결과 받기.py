def solution(id_list, report, k):
    dic = {}
    stopId = []
    mail = {}
    # 중복 제거
    report = list(set(report))
    # 정지된 아이디 확인
    for i in id_list:
        dic[i] = 0
        mail[i] = 0
    for i in report:
        stack = i.split()
        dic[stack[1]] += 1
    # 메일 보낼거 확인
    for i in report:
        stack = i.split()
        if dic[stack[1]] >= k:
            mail[stack[0]] += 1
    return list(mail.values())