import sys
input = sys.stdin.readline
problem = []
answer = 0
for i in range(int(input())):
    problem.append(list(map(int,input().split())))
problem.sort(key = lambda x : (x[0],-x[1]))
print(problem)
while(1):
    for i in 