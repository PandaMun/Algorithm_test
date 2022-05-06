import sys 
input = sys.stdin.readline
answer = []
for i in range(int(input())):
    applicant = []
    for j in range(int(input())):
        applicant.append(list(map(int,input().split())))
        minimum = 0
    cnt = 0
    applicant.sort(key = lambda x : x[0])
    for i in applicant:
        if minimum == 0:
            minimum = i[1]
            cnt += 1
        elif minimum > i[1]:
            minimum = i[1]
            cnt += 1
    answer.append(cnt)
for i in answer:
    print(i)