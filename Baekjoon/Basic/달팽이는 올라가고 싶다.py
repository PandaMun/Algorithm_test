import sys
import math
answer = list(map(int,sys.stdin.readline().rsplit()))

print(math.ceil((answer[2] - answer[0])/(answer[0]- answer[1])+1))
