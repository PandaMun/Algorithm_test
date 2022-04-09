import itertools
count , m = map(int, input().split())
card = list(map(int,input().split()))
answer = []

for i in itertools.combinations(card , 3):
    if sum(i) <= m:
        answer.append(sum(i))
print(max(answer))