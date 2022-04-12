import sys
input = sys.stdin.readline
N = int(input())
answer = []
dic = {}
coordinates = list(map(int, input().split()))
a = list(set(coordinates))
a.sort()
for i in range(len(a)):
    dic[a[i]] = i
for i in coordinates:
    answer.append(str(dic[i]))
print(' '.join(answer))

