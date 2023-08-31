import sys
input = sys.stdin.readline
a,b = map(int,input().split())
def ab(a,b):
    answer = 0
    while(1):
        if a > b:
            return -1
        if a == b:
            return answer + 1
        else:
            if b % 2 == 0:
                b = int(b/2)
                answer += 1
            else:
                b = (b / 10) - 0.1
                answer += 1
                
print(ab(a,b))
    
