import sys
input = sys.stdin.readline
answer = []
for i in range(int(input())):
    count = int(input())
    cloth = {}
    result = 1
    for i in range(count):
        name, kinds = input().split()
        if kinds in cloth:
            cloth[kinds] += 1
        else:
            cloth[kinds] = 1
    for i in cloth.values():
        result *= (i+1)
    
    answer.append(result-1)
for i in answer:
    print(i)
        
