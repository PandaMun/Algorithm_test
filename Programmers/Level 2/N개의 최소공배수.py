def solution(arr):
    arr.sort(reverse=True)
    max_value = arr.pop(0)
    result = 0
    result += max_value
    for i in arr:
        if result % i == 0:
            continue 
        else:
            for j in range(2,i+1):
                if (result * j) % i == 0:
                    result = result * j
                    break
    return result