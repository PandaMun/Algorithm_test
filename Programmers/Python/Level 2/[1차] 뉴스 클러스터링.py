def solution(str1, str2):
    answer = 0
    A = []
    B = []
    str1 = str1.lower()
    str2 = str2.lower()
    for i in range(len(str1)-1):
        if str1[i:i+2].isalpha():
            A.append(str1[i:i+2])
    for i in range(len(str2)-1):
        if str2[i:i+2].isalpha():
            B.append(str2[i:i+2])
    # 교집합
    # 합집합
    intersection = []
    sum_set = []
    for i in range(len(A)):
        if A[i] not in intersection:
            intersection += ([A[i]] * min(A.count(A[i]),B.count(A[i])))
        if A[i] not in sum_set:
            sum_set += ([A[i]] * max(A.count(A[i]),B.count(A[i])))
    for i in range(len(B)):
        if B[i] not in sum_set:
            sum_set.append(B[i] * B.count(B[i]))
    if len(intersection) == 0 and len(sum_set) == 0:
        return 65536  
    return int(65536 * (len(intersection)/len(sum_set)))