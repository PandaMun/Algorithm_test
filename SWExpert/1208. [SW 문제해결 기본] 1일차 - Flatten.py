answer = []
for test_case in range(10):
    dump = int(input())
    box = list(map(int,input().split()))
    for i in range(dump):
        box.sort()
        box[-1] -= 1
        box[0] += 1
    box.sort()
    answer.append(box[-1]-box[0])
for i in range(len(answer)):
    print('#' +str(i+1) + ' ' + str(answer[i]))