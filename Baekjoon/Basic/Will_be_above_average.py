Case_count = int(input())
test_case = []
for i in range(Case_count):
    aboveAverage = 0
    average = 0
    test_case.append(list(map(int, input().split())))
    value_count = ((test_case[i][0]))
    for j in range(value_count):
        average += test_case[i][j+1]
    average = average/value_count
    for h in range(value_count):
        if test_case[i][h+1] > average:
            aboveAverage +=1
    a = float((aboveAverage/value_count)*100)
    print('%0.3f'%a + "%")
            
    