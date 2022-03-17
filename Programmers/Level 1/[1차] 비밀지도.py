def solution(n, arr1, arr2):
    map1 = []
    map2 = []
    finalmap1 = []
    finalmap2 = []
    lastmap = []
    for i in range(n):
        map1.append(format(arr1[i],'b'))
        map2.append(format(arr2[i],'b'))
    for i in range(n):
        if len(map1[i]) == n:
            finalmap1.append(map1[i])
        else:
            finalmap1.append(("0" * (n - len(map1[i]))+ map1[i]))
        if len(map2[i]) == n:
            finalmap2.append(map2[i])
        else:
            finalmap2.append(("0" * (n - len(map2[i]))+ map2[i]))

    for i in range(n):
        result = ''
        for j in range(n):
            if finalmap1[i][j] == '1' or finalmap2[i][j] == '1':
                result += '#'
            else:
                result += ' '
        lastmap.append(result)


    return lastmap