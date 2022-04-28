import sys
input = sys.stdin.readline
numbers = []
counter = {}
n = int(input())
for i in range(n):
    numbers.append(int(input()))
#산술평균
print(int(round(sum(numbers)/n)))
#중앙값
numbers.sort(reverse=True)
print(numbers[(n//2)])
#최빈값
for i in numbers:
    counter[i] = 0
for i in numbers:
    counter[i] += 1
a = dict(sorted(counter.items(),key = lambda item: item[1], reverse = True))
value = (list(a.values()))
maximum = value[0]
b = value.count(maximum)
if b > 1:
    c = list(a.keys())[0:b]
    c.remove(min(c))
    print(min(c))
else:
    print(list(a.keys())[0])
#범위
print(max(numbers) - min(numbers))