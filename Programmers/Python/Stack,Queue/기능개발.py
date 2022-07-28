# 원래풀이 시간복잡도 O(n^2)
# def solution(progresses, speeds):
#     answer = []
#     count = 0
#     perfect = 0
#     while(count != len(progresses)):
#         perfect = 0
#         for i in range(len(progresses)):                
#             if progresses[i] < 100:
#                 progresses[i] += speeds[i]

#         while(count != len(progresses)):
#             if progresses[count] >= 100:
#                 perfect += 1
#                 count += 1
#             else:
#                 break
#         if perfect >= 1:
#             answer.append(perfect)
#     return answer

#  확인후 재풀이 시간 복잡도 O(n), time을 이용하는게 한번만 반복할수 있는 비결
def solution(progresses, speeds):
    print(progresses)
    print(speeds)
    answer = []
    time = 0
    count = 0
    while len(progresses)> 0:
        if (progresses[0] + time*speeds[0]) >= 100:
            progresses.pop(0)
            speeds.pop(0)
            count += 1
        else:
            if count > 0:
                answer.append(count)
                count = 0
            time += 1
    answer.append(count)
    return answer