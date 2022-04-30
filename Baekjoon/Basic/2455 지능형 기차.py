answer = 0
people = 0
for i in range(4):
    off, on = map(int,input().split())
    people = people + on - off
    if people > answer:
        answer = people
print(answer)