import sys
from itertools import permutations
input = sys.stdin.readline
answer = []
n,m,k = map(int,input().split())
quests = []
total_key = []
for i in range(m):
    quest = list(map(int,input().split()))
    quests.append(quest)
    total_key += quest
total_key = list(set(total_key))
key_combination = list(permutations(total_key,n))
for i in key_combination:
    success = 0
    for j in quests:
        example = list(i[:])
        example += j
        if len(set(example)) == len(i):
            success += 1
    answer.append(success)
print(max(answer))