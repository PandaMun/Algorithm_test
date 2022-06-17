import sys
input = sys.stdin.readline
score = []
for i in range(int(input())):
    name,korean,english,math = map(str,input().split())
    score.append([name,int(korean),int(english),int(math)])
score.sort(key=lambda x: (-x[1],x[2],-x[3],x[0]))
for i in score:
    print(i[0])