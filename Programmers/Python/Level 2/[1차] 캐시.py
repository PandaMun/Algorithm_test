def solution(cacheSize, cities):
    answer = 0
    cachestack = []
    for i in range(len(cities)):
        cities[i] = cities[i].upper()
    for i in cities:
        if len(cachestack) < cacheSize:
            if i in cachestack:
                cachestack.remove(i)
                cachestack.append(i)
                answer += 1
            else:
                cachestack.append(i)
                answer += 5

        elif len(cachestack) == cacheSize:
            if i in cachestack :
                cachestack.remove(i)
                cachestack.append(i)
                answer += 1
            else:
                cachestack.append(i)
                cachestack.pop(0)
                answer += 5
    return answer