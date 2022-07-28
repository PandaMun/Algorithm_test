import heapq

def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    while(1):
        if len(scoville) <= 1 and scoville[0] < K:
            return -1
        if scoville[0] <= K:
            least1 = heapq.heappop(scoville)
            least2 = heapq.heappop(scoville)
            heapq.heappush(scoville, least1 + (least2 * 2))
            answer += 1
        else:
            break


    return answer