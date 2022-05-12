from collections import deque
def solution(bridge_length, weight, truck_weights):
    answer = 1
    ing = deque()
    truck_weights = deque(truck_weights)
    summary = 0
    while truck_weights:
        next =  truck_weights[0] 
        # 다리위 총 무게와 다음 트럭의 무게의 합이 감당 가능한 무게라면
        if summary + next <= weight: 
            i = truck_weights.popleft() # 진행 시켜 ㅋㅋㅋ
            summary += i
            ing.append([0,i])  
        # 시간 증가
        answer += 1
        # 거리 증가
        for i in range(len(ing)):
            ing[i][0] += 1
        # (도착했다면) 다리의 거리와 맨 앞 트럭이 지난 거리가 같은 경우
        if len(ing) > 0 and ing[0][0] == bridge_length:
            summary -= ing.popleft()[1]
    # 그동안 지난 시간 + (다리의 길이 - 마지막 트럭의 위치)
    return answer + ((bridge_length - ing[-1][0])) 